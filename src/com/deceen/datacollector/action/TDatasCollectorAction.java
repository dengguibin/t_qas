		
		
/**
*/
package	com.deceen.datacollector.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletOutputStream;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.plugins.PluginRegistry;
import org.pentaho.di.core.plugins.RepositoryPluginType;
import org.pentaho.di.repository.RepositoriesMeta;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.repository.RepositoryDirectoryInterface;
import org.pentaho.di.repository.RepositoryMeta;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.deceen.datacollector.model.TDatasCollector;
import com.deceen.datacollector.service.TDatasCollectorService;
import com.deceen.kettle.service.KettleService;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.StringUtil;


/**
* @ClassName: TDatasCollectorAction.java
* @Description: t_datas_collector
* @author upaths@gmail.com  
* @date2015-7-2 15:51:46
* @version V1.0   
*/
@Scope("prototype")
@Component("tDatasCollectorAction")	
@SuppressWarnings({ "rawtypes", "serial", "unchecked", "unused" })
public class TDatasCollectorAction  extends BaseActionSupport{
	
	String foldPath="kettleFiles";
	String proPertisePath="config/kettleShare/repositories.properties";
	public final static String KETTLE_REPOSITORIES_XML_PATH="config/kettleShare/repositories.xml";
	private static final Logger log = Logger.getLogger(TDatasCollectorAction.class);

	private  TDatasCollectorService service;
	
	private KettleService kettleService;
	
	private TDatasCollector bean;
	
	private List datas;
	//已上传文件列表
	private List files;
	// 上传的文件.
	private File[] doc;

	// 上传的文件类型.
	private String[] docContentType;

	// 上传的文件名.
	private String[] docFileName;
	
	//查询单条记录信息
	public String queryInfo() throws Exception {
		if(bean != null && bean.getTid() != null && "".equals(bean.getTid()) == false){
				bean = service.select(bean.getTid());
				if(StringUtil.isNotEmpty(bean.getSource())){
					String source=bean.getSource();
					bean.setSource(StringUtil.substringAfter(source, "_"));
				}
		}
		return FORWARD_SELECT;
	}
	
	//查询 列表信息
	public String queryList() throws Exception {
		if(bean == null){ 
			bean = new TDatasCollector();
		}
		datas = service.list(bean);
		return FORWARD_LIST;
	}
	
	//进行更新和增加 的进入页面
	public String toEdit() throws Exception {
		//查询一次数据信息
		queryInfo();
		return FORWARD_TOEDIT;
	}
	public String download(){
		try {
			if(bean != null && bean.getTid() != null && "".equals(bean.getTid()) == false){
				bean = service.select(bean.getTid());
			}
			if(bean!=null&&bean.getSource()!=null){
				String cpath = getPath();
				String foldUrl=cpath+foldPath+"/"+bean.getTid()+".ktr";
				response.reset();
				File file = FileUtils.getFile(foldUrl);
				if(!file.exists()){
					FileUtils.writeStringToFile(file, bean.getSource());
				}
				if(StringUtil.isNotEmpty(bean.getSource())){
					String fileName=bean.getName();
					response.setHeader("Content-Disposition","attachment;" + "filename=" + new String(fileName.getBytes("GBK"),"ISO8859-1"));
					if(file.exists()){
						FileInputStream inp = FileUtils.openInputStream(file);
						ServletOutputStream opt = response.getOutputStream();
						byte[] data = IOUtils.toByteArray(inp);
						IOUtils.write(data, opt);
						IOUtils.closeQuietly(opt);
						IOUtils.closeQuietly(inp);
					}else{
						fileName = "对不起，你访问的文件【"+fileName+"】不存在！";
						log.warn(fileName);
						response.reset();
						response.setContentType("text/html; charset=UTF-8");
						String script = "<script>alert('"+fileName+"')</script>";
						response.getWriter().print(script);
						response.flushBuffer();
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//新增和更新操作
	public String save() throws Exception {
		if(bean != null  ){
			IUser user = getLoginUser();
			String userId =user.getUserId();
			//主键记录已经存在，需要进行更新操作
			if(bean.getTid() != null && "".equals(bean.getTid()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				TDatasCollector dsBean = service.select(bean.getTid());
				if(dsBean != null){
					bean.setUdate(new Date());
					bean.setUpdator(userId);
					if(doc!=null){
						bean.setSource(IOUtils.toString(FileUtils.openInputStream(doc[0])));
					}
				// 如果数据库中有此记录信息，进行更新操作
					int rows = service.updateWithDyna(bean);
				}else{
					//是否需要输出数据不存在的异常
				}
			}else{
				bean.setCdate(new Date());
				bean.setCreator(userId);
			    bean.setTid(IDGenerator.getUUID()); 
			    if(doc!=null){
					bean.setSource(IOUtils.toString(FileUtils.openInputStream(doc[0])));
				}
				int rows = service.insert(bean);
			}
			String cpath = getPath();
			String foldUrl=cpath+foldPath;
			File kettleFile = new File(foldUrl);
			if(!kettleFile.exists()){
				kettleFile.mkdirs();
			}
			String fileName ="";
			if(doc != null){
				String fileId=bean.getTid();
				fileName=fileId+".ktr";
				File nfile = new File(foldUrl+"/"+fileName);
				if(nfile.exists()){
					FileUtils.deleteQuietly(nfile);
				}
				FileUtils.copyFile(doc[0],nfile);
			}
		}
		return FORWARD_SAVE;	
	}

	private String getPath() throws UnsupportedEncodingException {
		URL path = Thread.currentThread().getContextClassLoader().getResource("");
		String cpath=path.getPath();
		cpath=URLDecoder.decode(cpath, "UTF-8");
		return cpath;
	}
	
	/**运行
	 * @return
	 * @throws IOException 
	 */
	public String saveRunTran() throws IOException{
		if(bean != null && bean.getTid() != null && "".equals(bean.getTid()) == false){
			bean = service.select(bean.getTid());
		}
		IUser user = getLoginUser();
		String userId =user.getUserId();
		Date startDate = new Date();
		int state=0;
		Map<String,String> resultMap = new HashMap<String, String>();
		String cpath;
		try {
			cpath = getPath();
			String fileUrl=cpath+foldPath+"/"+bean.getTid()+".ktr";
			File file = new File(fileUrl);
			if(!file.exists()&&StringUtil.isNotBlank(bean.getSource())){
				FileUtils.writeStringToFile(file, bean.getSource());
			}
			if(file.exists()){
				Map<String,String>variableMap = new HashMap<String, String>();
				variableMap.put("ALARM_TYPE", "E01");
				Map<String, Object> reMap = kettleService.excuteTran(fileUrl, variableMap, null, null);
				String trnResult = String.valueOf(reMap.get("result"));
				bean.setLogs(String.valueOf(reMap.get("resultInfo")));
				if(StringUtil.equals("success", trnResult)){
					resultMap.put("msg", "执行完成");
					state=1;
				}else{
					resultMap.put("msg", "执行出错");
				}
			}else{
				resultMap.put("msg", "没有可以执行的附件");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMap.put("msg", "执行失败");
		}finally{
			Date endDate = new Date();
			bean.setState(state);
			bean.setRdate(startDate);
			long cos = (endDate.getTime() - startDate.getTime())/1000;
			bean.setCosts((int)cos);
			bean.setUdate(new Date());
			bean.setUpdator(userId);
			service.update(bean);
		}
		return FORWARD_SAVE;
	}
	public void initRe(){
		 RepositoriesMeta repositoriesMeta = new RepositoriesMeta();  
		 FileInputStream inp;
		try {
			String path= getPath()+KETTLE_REPOSITORIES_XML_PATH;
			inp = FileUtils.openInputStream(new File(path));
			repositoriesMeta.readDataFromInputStream(inp);
			String propath=getPath()+proPertisePath;
			FileInputStream propathinp = FileUtils.openInputStream(new File(propath));
			Properties p = new Properties();
			p.load(propathinp);
			RepositoryMeta repositoryMeta = repositoriesMeta.findRepository(p.getProperty("repositoryParameter.name"));
			Repository repository = PluginRegistry.getInstance().loadClass(RepositoryPluginType.class, repositoryMeta.getId(), Repository.class);  
			repository.init(repositoryMeta);  
			repository.connect(p.getProperty("login.name"),p.getProperty("login.pw")); 
			RepositoryDirectoryInterface directoryInterface = repository.loadRepositoryDirectoryTree();
		    TransMeta transMeta=repository.loadTransformation("testDB1",directoryInterface,null,true,null);
			Trans trans = new Trans(transMeta);
			trans.prepareExecution(null);
			trans.startThreads();
			trans.waitUntilFinished();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KettleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除方法，如果ID 上是以","隔开的字符，会认为是一个数组,批量删除数据
	 */
	public String remove() throws Exception {
		Map result = new HashMap();
		result.put("status", "0");
		if(bean != null && bean.getTid() != null){
			String idArrs[] = bean.getTid().split("[,]");
			boolean checkResult = true;
			if(checkResult == true){
				try{
					int rows = service.delete(idArrs);
					result.put("status", "1");
				}catch(Exception e){
					e.printStackTrace();
					result.put("message", e.getMessage());
				}
			}else{
				result.put("status", "2");
				result.put("message", "已经存在相关联的数据，请先删除");
			}
		}else{
			result.put("message","错误参数");
		}
		
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	
	public TDatasCollectorService getService() {
		return service;
	}

	@Autowired
	public void setService(TDatasCollectorService service) {
		this.service = service;
	}

	public TDatasCollector getBean() {
		return bean;
	}

	public void setBean(TDatasCollector bean) {
		this.bean = bean;
	}


	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public List getFiles() {
		return files;
	}

	public void setFiles(List files) {
		this.files = files;
	}

	public File[] getDoc() {
		return doc;
	}

	public void setDoc(File[] doc) {
		this.doc = doc;
	}

	public String[] getDocContentType() {
		return docContentType;
	}

	public void setDocContentType(String[] docContentType) {
		this.docContentType = docContentType;
	}

	public String[] getDocFileName() {
		return docFileName;
	}

	public void setDocFileName(String[] docFileName) {
		this.docFileName = docFileName;
	}
	@Autowired
	public void setKettleService(KettleService kettleService) {
		this.kettleService = kettleService;
	}

	public KettleService getKettleService() {
		return kettleService;
	}



	
	
}
