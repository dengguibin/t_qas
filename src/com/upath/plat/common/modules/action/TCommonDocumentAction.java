/**
*/
package	com.upath.plat.common.modules.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import net.sf.json.JSONArray;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.attachment.AttachmentsManager;
import com.upath.plat.common.attachment.IAttachment;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.modules.model.TCommonDocument;
import com.upath.plat.common.modules.service.TCommonDocumentService;
import com.upath.plat.common.util.SystemConfig;





/**
* strut2 config :
* spring config :
* @ClassName: TCommonDocumentAction.java
* @Description: t_common_document
* @author upaths@gmail.com  
* @date2013-1-20 17:38:30
* @version V1.0   
*/

@Scope("prototype")
@Component("tCommonDocumentAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class TCommonDocumentAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TCommonDocumentAction.class);
	
	/*服务类*/
	private  TCommonDocumentService service;
	
	/*操作实体*/
	private TCommonDocument bean;
	
	/*查询列表数据*/
	private List datas ;
	
	private File[] document;
	
	private String[] documentFileName;
	
	private String[] documentContentType;
	

	String getParamValue(String key,List list){
			String value = null;
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if(item.isFormField()){
					String name = item.getFieldName();
					if(key.equals(name)){
						value = item.getString();
						break;
					}
				}
			}
			return value;
		}
	
	
	
	
	
	public String upload() throws Exception{
		try {
			request.setCharacterEncoding("UTF-8");
			if(bean.getBusinessid() == null || "".equals(bean.getBusinessid())){
				throw new PlatformException("文件上传模块必须指定appid设置文档的唯一性");
			}
			if(bean.getModuleid() == null || "".equals(bean.getModuleid())){
				throw new PlatformException("文件上传模块必须指定modid标识上传业务的功能");
			}
			if(document != null && document.length > 0){
//				for(int i = 0 ; i < document.length ; i++){
//					File file = document[i];
//					String name = documentFileName[i];
//					String type = documentContentType[i];
//					TCommonDocument store = renderStore(file, name, type);
//					this.service.insert(store);
//				}
				IAttachment[] attachments = AttachmentsManager.getInstance().uploadAttachments(documentFileName, document, bean.getModuleid(), bean.getBusinessid());
			}
		} catch (Exception ex) {
			throw new PlatformException("上传文件管理失败:"+ex.getMessage(),ex);
		}
		response.getWriter().print("1");
		return null;
	}

	public String getResult() throws Exception {
		datas = this.service.list(bean);
		if(datas != null){
			JSONArray   json = 	JSONArray.fromObject(datas);
			response.setCharacterEncoding("utf-8");
			String msg = json.toString();
			response.setContentType("text/json; charset=UTF-8");
			response.getWriter().write(msg);
		}
		
		return null;
	}

	
		
		
		public String delete()throws Exception {
			TCommonDocument store = null;
			store = service.select(bean);
			if(store == null){
				throw new PlatformException("系统无法找到此相关的文件");
			}
			String msg = "0";
			try{
				String location = store.getPath();
		    	String realpath = SystemConfig.ATTACHMENT_SAVE_DIR;
				String path = realpath+location;
				/*String systemId = Configuration.getProperty(Constants.SYSTEM_ID, "");
				if(systemId.equals(store.getSystemid()) == false){
					throw new PlatformException("系统 不允许删除不属于此系统外的文件");
				}*/
				if(StringUtils.isEmpty(path) == false){
					// 是否考虑 如果 本身  就是一个 镜像 文件；还有就是 如果 删除 原文件的时候 。镜像 文件是否 要被删除。
					//如果 此文档 不是镜像 文件。那么 
					if(StringUtils.isEmpty(store.getMinorsid()) == true){
						File file = new File(path);
						log.info("文件ID "+store.getDocid()+":"+store.getName()+"进行删除");
						if(file.exists() == true){
							//不允许 直接 删除文件
							//file.delete();
						}
					}
					
				service.delete(store);
				msg = "1";
				}
			}catch (Exception e) {
				throw new PlatformException("删除文档失败",e);
			}
			response.getWriter().print(msg);
			return null;
		}

		
		public String download()throws Exception {
			String appid = request.getParameter("wdbh");
			TCommonDocument store = null;
			store = service.select(bean);
			    InputStream is = null;
			    OutputStream os = null;
			    try {
			    	//文档的全路径。如果 在系统迁移的时候会有影响。
			    	//String path = store.getWdlj();
			    	//文档的相对路径
			    	boolean flag = true;
			    	String fileName = store.getName();
			    	if(StringUtils.isEmpty(store.getMinorsid()) == false){
			    		store.setDocid(store.getMinorsid());
			    		store = service.select(store);
			    		if(store == null){
			    			fileName = "原文件【"+fileName+"】已经被删除！";
			    			flag = false;
			    		}else{
			    			fileName = store.getName();
			    		}
			    	}
			    	String location = store.getPath();
			    	String realpath = SystemConfig.ATTACHMENT_SAVE_DIR;
			    	File file = new File(realpath+location);
			    	
			    	if(file.exists() == false){
			    		if( flag == true){
			    			fileName = "对不起，你访问的文件【"+fileName+"】不存在！";
			    		}
			    		log.warn(fileName);
			    		response.reset();
			    		response.setContentType("text/html; charset=UTF-8");
			    		String script = "<script>alert('"+fileName+"')</script>";
			    		response.getWriter().print(script);
			    		response.flushBuffer();
			    		return null;
			    	}
					if(StringUtils.isEmpty(location) == false){
					response.reset();	
					response.setHeader("Content-Disposition","attachment;" + "filename=" + new String(fileName.getBytes("GBK"),"ISO8859-1"));
						if(file.exists() == true){
							 is = new FileInputStream(file);
					            os = response.getOutputStream();
					            byte[] b = new byte[1024 * 8];
					           int l = -1;
					            while ((l = is.read(b)) != -1) {
					                os.write(b, 0, l);
					            }
					            os.flush();	
						}
				            response.flushBuffer();
					}
			    } catch (Exception e) {
			        e.printStackTrace();
			    } finally {
			     // Close
			    }
			return null;
			
		}
		public String downloadZip()throws Exception {
			List list = service.list(bean);
			if(list == null)return null;
			ZipOutputStream zos = null;
			ServletOutputStream sos = null;
			try {
				response.reset();
				response.setContentType("application/x-msdownload"); // 通知客户文件的MIME类型：
				String filename = "系统压缩文档.zip";
				if(bean.getName() != null){
					filename = bean.getName() + ".zip";
				}
				response.setHeader("Content-disposition", "attachment;filename="
						+ new String(filename.getBytes("GBK"),"ISO8859-1"));
				
				sos = response.getOutputStream();
				zos = new ZipOutputStream(sos);
				ZipEntry ze = null;
				byte[] buf = new byte[2048]; // 输出文件用的字节数组,每次发送2048个字节到输出流：
				int readLength = 0;
				int z = 0;
				for (int i = 0; i < list.size(); i++) {
					 Map store = (Map)list.get(i);
					 String fileName = store.get("NAME")==null?"":store.get("NAME").toString();
					 String location = store.get("PATH")==null?"":store.get("PATH").toString();
					 String realpath = SystemConfig.ATTACHMENT_SAVE_DIR;

					File file = new File(realpath+location);
					if(file.exists() == false){
						fileName = "对不起，你访问的文件【"+fileName+"】不存在！";
			    		log.warn(fileName);
			    		response.setContentType("text/html; charset=UTF-8");
			    		String script = "<script>alert('"+fileName+"')</script>";
			    		response.getWriter().print(script);
			    		return null;
					}else{
						ze = new ZipEntry(fileName);
						ze.setSize(file.length());
						ze.setTime(file.lastModified());
						InputStream is = new BufferedInputStream(new FileInputStream(file));
						zos.putNextEntry(ze);
						while ((readLength = is.read(buf)) != -1) {
							zos.write(buf, 0, readLength);
						}
						zos.closeEntry();
						is.close();
					}
				}
			} catch (Exception ex) {
				log.error(ex);
			} finally {
				if (zos != null) {
					try {
						zos.close();
					} catch (Exception ex) {
						log.error(ex);
					}
				}
			}
			
			
			return null;
			
		}
	
	
	@Autowired
	public void setService(TCommonDocumentService service) {
		this.service = service;
	}

	public TCommonDocument getBean() {
		return bean;
	}

	public void setBean(TCommonDocument bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public File[] getDocument() {
		return document;
	}

	public void setDocument(File[] document) {
		this.document = document;
	}

	public String[] getDocumentFileName() {
		return documentFileName;
	}

	public void setDocumentFileName(String[] documentFileName) {
		this.documentFileName = documentFileName;
	}

	public String[] getDocumentContentType() {
		return documentContentType;
	}

	public void setDocumentContentType(String[] documentContentType) {
		this.documentContentType = documentContentType;
	}
}
