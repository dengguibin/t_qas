package	com.deceen.diagnoseformat.scheme.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.scheme.model.QasTDiagnosescheme;
import com.deceen.diagnoseformat.scheme.model.QasTIndicatorratedefinition;
import com.deceen.diagnoseformat.scheme.model.QasTSchemecatalog;
import com.deceen.diagnoseformat.scheme.service.QasTDiagnoseschemeService;
import com.deceen.diagnoseformat.scheme.service.QasTSchemecatalogService;
import com.deceen.indicator.indicatorcatalog.service.QasTIndicatorcatalogService;
import com.deceen.indicator.indicatorcontent.model.QasTIndicatorcontent;
import com.deceen.indicator.indicatorcontent.service.QasTIndicatorcontentService;
import com.deceen.utils.ResultMap;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.util.IDGenerator;


/**
* @ClassName: QasTDiagnoseschemeAction.java
* @Description: qas_t_diagnosescheme
* @author upaths@gmail.com  
* @date2017-11-15 17:50:55
* @version V1.0   
*/
@Scope("prototype")
@Component("qasTDiagnoseAction")	
@SuppressWarnings({ "rawtypes", "serial" })
public class QasTDiagnoseAction  extends BaseActionSupport{

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(QasTDiagnoseAction.class);

	
	private  QasTDiagnoseschemeService diagnosescheme;
	
	private  QasTSchemecatalogService schemecatalog;
	
	@Autowired
	private  QasTIndicatorcontentService indicatorcontentservice;
	@Autowired
	private QasTIndicatorcatalogService indicatorcatalogService;
	
	private QasTDiagnosescheme diagnose;
	
	private QasTSchemecatalog scheme;
	
	private List<QasTIndicatorratedefinition>  indicatorratedes;
	
	private List datas;
	
	private List<QasTIndicatorratedefinition> data;
	
	public String queryInfo() throws Exception {
		if (diagnose != null && diagnose.getId() != null
				&& "".equals(diagnose.getId()) == false) {
			diagnose = diagnosescheme.select(diagnose.getId());
			response.setContentType("text/json; charset=UTF-8");
			JSONObject json = JSONObject.fromObject(diagnose);
			response.getWriter().print(json.toString());
		}
		return null;
	}
	
	
	public String getTree() throws Exception {
		ResultMap result = new ResultMap();
		String key = request.getParameter("key");//搜索时的关键字
		String schemeId = request.getParameter("schemeId");//模型ID
		Map<String,String> params = new HashMap<String, String>();//用于封装查询参数
		if(!StringUtils.isEmpty(key)){
			params.put("name", key);
		}
		params.put("schemeId", schemeId);
		try {
			List<Map<String, Object>> tree = schemecatalog.selectTree(params);
			result.setObj(tree);
			List<Map<String, Object>> count = schemecatalog.inditorCount();
			result.put("count", count);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMsg("系统异常！");
		}
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	//选择指标弹框
	public String checkIndicator() throws Exception {
		return FORWARD_SELECT;
	}
	
	//选择指标弹框
	public String checkScheme() throws Exception {
		if(diagnose == null){ 
			diagnose = new QasTDiagnosescheme();
		}
		datas = diagnosescheme.list(diagnose);
		return FORWARD_SELECT;
	}
	
	//指标详情
	public String diagnoseActionInfo() throws Exception {
		return FORWARD_SELECT;
	}
	
	//指标列表
	public String queryList() throws Exception {
		if(diagnose == null){ 
			diagnose = new QasTDiagnosescheme();
		}
		Map<String,List<QasTDiagnosescheme>> maps = diagnosescheme.typeList(diagnose);
		request.setAttribute("maps", maps);
//		checkScheme();
		return FORWARD_LIST;
	}
	
	//进行更新和增加 的进入页面
	public String toEdit() throws Exception {
		String id = request.getParameter("id");
		//查询一次数据信息
		if(id != null && "".equals(id) == false){
			diagnose = diagnosescheme.select(id);
		}
		return FORWARD_TOEDIT;
	}
	
	/**
	 * 给模型添加指标
	 * @throws Exception
	 */
	public void addTree() throws Exception {
		ResultMap result = new ResultMap(); 
		List<QasTSchemecatalog> list= new ArrayList<QasTSchemecatalog>();
		IUser user = getLoginUser();
		String schemeId = request.getParameter("schemeId");
	 
		 List<String>strs =new ArrayList<>();
		 strs=indicatorcatalogService.selectIndicatorType();
		 
	/*	QasTSchemecatalog sch=new QasTSchemecatalog();
		sch.setSchemeid(schemeId);
		list.add(0, sch);*/
	/*	schemecatalog.deleteschemeId(schemeId);*/
		
		String ids = request.getParameter("ids");
		String[] id=ids.split(",");
		for(String i:id){
			QasTSchemecatalog schem=new QasTSchemecatalog();
			schem.setId(IDGenerator.getUUID());
			schem.setSchemeid(schemeId);
			schem.setIndicatorcatalogid(i);
			schem.setWeight((float)-1);
			if(strs.contains(i)){
				schem.setIsvalid(1);
			}else{
				schem.setIsvalid(0);
			}
			schem.setCreatedby(user.getUserId());
			schem.setUpdatedby(user.getUserId());
			schem.setCreatedtime(new Date());
			schem.setUpdatedtime(new Date());
			list.add(schem);
		}
		schemecatalog.insertlist(list,schemeId);
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
	}
	
	@SuppressWarnings("unchecked")
	public void addScheme() throws Exception {
		ResultMap result = new ResultMap(); 
		IUser user = getLoginUser();
		String schemeId = request.getParameter("schemeId");//当前操作的模板id
		String id = request.getParameter("id");//复制对象的模板id
		//记录复制模板的id的
		if(diagnose == null){
			diagnose = new QasTDiagnosescheme();
			diagnose.setId(schemeId);
			diagnose.setSourceschemeid(id);
			save();
		}
		QasTSchemecatalog schemes=new QasTSchemecatalog();
		schemes.setSchemeid(id);
		//查询内容
		List<QasTIndicatorratedefinition> indicatorratede = schemecatalog.selectIndicatorRateAll(schemes.getSchemeid());
		Map<String, String> params = new HashMap<String, String>();
		params.put("schemeid", id);
		List<QasTSchemecatalog> list = schemecatalog.selectSchemeId(params);//
		if(null != list && list.size()>0 && null != indicatorratede && indicatorratede.size()>0){
			for (QasTSchemecatalog qasTSchemecatalog : list) {
				qasTSchemecatalog.setId(IDGenerator.getUUID());
				qasTSchemecatalog.setSchemeid(schemeId);
				qasTSchemecatalog.setCreatedby(user.getUserId());
				qasTSchemecatalog.setWeight(qasTSchemecatalog.getWeight());
				qasTSchemecatalog.setIsvalid(0);
				qasTSchemecatalog.setCreatedtime(new Date());
				qasTSchemecatalog.setUpdatedby(user.getUserId());
				qasTSchemecatalog.setUpdatedtime(new Date());
			}
			schemecatalog.insertlistAll(indicatorratede,list,schemeId);
		}else{
			result.setMsg("该模板为空或分值未填写完！");
			result.put("boo", false);
		}
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
	}
	
	//添加诊断模型弹框
	public String addDiagnoseScheme() throws Exception {
		return FORWARD_TOEDIT;
	}
	
	//查询模板指标关联表
	public void getSchemeCatalog() throws Exception {
		ResultMap result = new ResultMap(); 
		if(scheme != null){
			scheme = schemecatalog.select(scheme.getId());
			result.setObj(scheme);
		}
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
	}
	
	//修改指标模型关联中间表
	public void editShcemeCatalog()throws IOException{
		if(diagnose != null){
			save();
		}
		ResultMap result = new ResultMap(); 
		IUser user = getLoginUser();
		String parentId = request.getParameter("parentId");
		if(scheme != null  ){
			//主键记录已经存在，需要进行更新操作
			if(scheme.getId() != null && "".equals(scheme.getId()) == false){
				
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasTSchemecatalog dsBean = schemecatalog.select(scheme.getId());
				
				if(dsBean != null){
					// 校验相同父级指标目录权重
					scheme.setSchemeid(dsBean.getSchemeid());
					scheme.setIndicatorcatalogid(dsBean.getIndicatorcatalogid());
					float countWeight = schemecatalog.selectCountWeight(scheme);
					if((countWeight+scheme.getWeight()-dsBean.getWeight())>1){
						result.setSuccess(false);
						result.setMsg("当前权重大于1！请修改");
					}else{
						// 如果数据库中有此记录信息，进行更新操作
						scheme.setUpdatedby(user.getUserId());
						scheme.setUpdatedtime(new Date());
						try {
							
							schemecatalog.updateWithDyna(scheme,parentId);
						} catch (Exception e) {
							e.printStackTrace();
							result.setSuccess(false);
							result.setMsg("参数异常！请联系管理员");
						}
					}
				}else{
					//是否需要输出数据不存在的异常
				}
				
			}else{	
				//id为空
			}
		}else{
			result.setSuccess(false);
			result.setMsg("参数为空");
		}
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
	}
	
	//查询result
	public void getIndicatorRate() throws Exception {
		ResultMap result = new ResultMap(); 
		if(scheme != null){
			datas = schemecatalog.selectIndicatorRate(scheme.getId());
			scheme = schemecatalog.select(scheme.getId());
			QasTIndicatorcontent  indicatorcontent  = indicatorcontentservice.select(scheme.getIndicatorcatalogid());
			result.put("datas",datas);
			result.put("scheme", scheme);
			result.put("indicatorcontent",indicatorcontent);
		}
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
	}
	
	//修改指标预警设置表
	public void editIndicatorRate()throws IOException{
		if(diagnose != null){
			save();
		}
		ResultMap result = new ResultMap(); 
		IUser user = getLoginUser();
		String parentId = request.getParameter("parentId");
		if(!indicatorratedes.isEmpty()&&scheme != null  ){
			scheme.setUpdatedby(user.getUserId());
			scheme.setUpdatedtime(new Date());
			scheme.setIsvalid(1);
			try {
				schemecatalog.updateIndicatorRate(indicatorratedes, scheme, parentId);
			} catch (Exception e) {
				e.printStackTrace();
				result.setSuccess(false);
				result.setMsg("参数异常！请联系管理员");
			}
		}else{
			result.setSuccess(false);
			result.setMsg("参数为空");
		}
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
	}
	
	//模型新增和更新操作
	public String save() throws IOException {
		
//		ResultMap result = new ResultMap(); 
		IUser user = getLoginUser();
		if(diagnose != null  ){
			//主键记录已经存在，需要进行更新操作
			if(diagnose != null  ){
				//主键记录已经存在，需要进行更新操作
				if(diagnose.getId() != null && "".equals(diagnose.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasTDiagnosescheme dsBean = diagnosescheme.select(diagnose.getId());
					if(dsBean != null){
					// 如果数据库中有此记录信息，进行更新操作
						diagnose.setUpdatedby(user.getUserId());
						diagnose.setUpdatedtime(new Date());
						diagnosescheme.updateWithDyna(diagnose);
					}else{
						//是否需要输出数据不存在的异常
					}
				}else{	// 添加
					diagnose.setId(IDGenerator.getUUID());
					diagnose.setCreatedby(user.getUserId());
					diagnose.setUpdatedby(user.getUserId());
					diagnose.setCreatedtime(new Date());
					diagnose.setUpdatedtime(new Date());
					diagnosescheme.insert(diagnose);
				}
			}
//		response.setContentType("text/json; charset=UTF-8");
//		response.getWriter().print(result.getJsonStr());
		}
		return FORWARD_TOEDIT;
	}
	
	/**
	 * 删除方法，如果ID 上是以","隔开的字符，会认为是一个数组,批量删除数据
	 */
	public String remove() throws Exception {
		ResultMap result = new ResultMap();
		if(scheme != null && scheme.getId() != null){
//			String idArrs[] = scheme.getId().split("[,]");
			boolean checkResult = true;
//程序是否需要对此数据进行数据检验,如果是请开启此部分的数据检验			
//			for(int i = 0 ; i < idArrs.length ; i++){
//					//是否有对应的数据存在
//					int rows = Integer.valueOf(((Map)diagnosescheme.get2Object("查询数据的行数", bean)).get("CNUM").toString());
//					if(rows > 0){
//						checkResult = false;
//						break;
//					}
//			}	
			if(checkResult == true){
				try{
					schemecatalog.delete((Object)scheme.getId());
				}catch(Exception e){
					e.printStackTrace();
					result.setSuccess(false);
					result.put("message", e.getMessage());
				}
			}else{
				result.setSuccess(false);
				result.setMsg("存在关联的数据，请先删除");
			}
		}else if(diagnose != null && diagnose.getId() != null){
//			String idArrs[] = diagnose.getId().split("[,]");
			boolean checkResult = true;
//程序是否需要对此数据进行数据检验,如果是请开启此部分的数据检验			
//			for(int i = 0 ; i < idArrs.length ; i++){
//					//是否有对应的数据存在
//					int rows = Integer.valueOf(((Map)diagnosediagnose.get2Object("查询数据的行数", bean)).get("CNUM").toString());
//					if(rows > 0){
//						checkResult = false;
//						break;
//					}
//			}	
			//查询是否有关联数据
			int rows= diagnosescheme.selectTask(diagnose.getId());
			if(rows > 0){
				checkResult = false;
			}
			if(checkResult == true){
				try{
					diagnosescheme.delete(diagnose.getId());
				}catch(Exception e){
					e.printStackTrace();
					result.setSuccess(false);
					result.put("message", e.getMessage());
				}
			}else{
				result.setSuccess(false);
				result.setMsg("存在关联的数据，请先删除");
			}
		}else{
			result.setSuccess(false);
			result.setMsg("错误参数");
		}
		
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;
	}
	
	/**
	 * 获取可可发布任务select
	 * @throws Exception
	 */
	public void getSelectType() throws Exception {
		ResultMap result = new ResultMap();
		if(diagnose != null && diagnose.getRangetype() != null){
			diagnose.setStatus(1);
			List<QasTDiagnosescheme> list = diagnosescheme.selectBean(diagnose);
			result.setObj(list);
		}
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
	}
	
	/**
	 * 发布任务
	 */
	@SuppressWarnings("unused")
	public void publish() throws Exception{
		ResultMap result = new ResultMap();
		IUser user = getLoginUser();
		ConcurrentMap<String, Long> concurrentMapWordCounts = new ConcurrentHashMap<String, Long>(); 
		if(diagnose != null){
			//验证当前模板指标是否有效
			int count = schemecatalog.countIsvalid(diagnose.getId());
			if(count>1){
				result.setSuccess(false);
				result.setMsg("模板信息未填写完成！");
			}else{
				diagnose.setStatus(1);
				diagnose.setUpdatedby(user.getUserId());
				diagnose.setUpdatedtime(new Date());
				diagnosescheme.publish(diagnose);
			}
		}
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
	}

	public QasTDiagnoseschemeService getDiagnosescheme() {
		return diagnosescheme;
	}
	@Autowired
	public void setDiagnosescheme(QasTDiagnoseschemeService diagnosescheme) {
		this.diagnosescheme = diagnosescheme;
	}

	public QasTSchemecatalogService getSchemecatalog() {
		return schemecatalog;
	}
	@Autowired
	public void setSchemecatalog(QasTSchemecatalogService schemecatalog) {
		this.schemecatalog = schemecatalog;
	}

	public QasTDiagnosescheme getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(QasTDiagnosescheme diagnose) {
		this.diagnose = diagnose;
	}
	
	public QasTSchemecatalog getScheme() {
		return scheme;
	}

	public void setScheme(QasTSchemecatalog scheme) {
		this.scheme = scheme;
	}

	public List<QasTIndicatorratedefinition> getIndicatorratedes() {
		return indicatorratedes;
	}

	public void setIndicatorratedes(
			List<QasTIndicatorratedefinition> indicatorratedes) {
		this.indicatorratedes = indicatorratedes;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public List<QasTIndicatorratedefinition> getData() {
		return data;
	}

	public void setData(List<QasTIndicatorratedefinition> data) {
		this.data = data;
	}
	
	
}
