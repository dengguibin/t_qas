package	com.deceen.data.teacher.teacherResearch.action;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.action.BaseActionSupport;
import com.deceen.data.teacher.teacherResearch.model.QasDTeacherresearch;
import com.deceen.data.teacher.teacherResearch.service.QasDTeacherresearchService;

import net.sf.json.JSONObject;


/**
* @ClassName: QasDTeacherresearchAction.java
* @Description: qas_d_teacherresearch
* @author upaths@gmail.com  
* @date2017-11-23 12:33:15
* @version V1.0   
*/
@Scope("prototype")
@Component("qasDTeacherresearchAction")	
@SuppressWarnings({ "rawtypes", "unchecked", "serial" ,"unused" })
public class QasDTeacherresearchAction  extends BaseActionSupport{

	private static final Logger log = Logger.getLogger(QasDTeacherresearchAction.class);

	private  QasDTeacherresearchService service;
	
	private QasDTeacherresearch bean;
	
	private List datas;
	
	//查询单条记录信息
	public String queryInfo() throws Exception {
		if(bean != null && bean.getId() != null && "".equals(bean.getId()) == false){
				bean = service.select(bean.getId());
			}
		return FORWARD_SELECT;
	}
	
	//查询 列表信息
	public String queryList() throws Exception {
		if(bean == null){ 
			bean = new QasDTeacherresearch();
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
	
	//新增和更新操作
	public String save() throws Exception {
		if(bean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(bean.getId() != null && "".equals(bean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDTeacherresearch dsBean = service.select(bean.getId());
				if(dsBean != null){
					if (user != null) {
						bean.setUpdatedby(user.getUserId());
					}
					bean.setId(dsBean.getId());
					bean.setCreatedby(dsBean.getCreatedby());
					bean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					service.updateWithDyna(bean);
				}else{
					//是否需要输出数据不存在的异常
				}
			}else{
				if (user != null) {
				 	bean.setCreatedby(user.getUserId());
				}
				service.insert(bean);
			}
			
		}
		return FORWARD_SAVE;	
	}
	
	/**
	 * 删除方法，如果ID 上是以","隔开的字符，会认为是一个数组,批量删除数据
	 */
	public String remove() throws Exception {
		Map result = new HashMap();
		result.put("status", "0");
		if(bean != null && bean.getId() != null){
			String idArrs[] = bean.getId().split("[,]");
			boolean checkResult = true;
//程序是否需要对此数据进行数据检验,如果是请开启此部分的数据检验			
//			for(int i = 0 ; i < idArrs.length ; i++){
//					//是否有对应的数据存在
//					Integer.valueOf(((Map)service.get2Object("查询数据的行数", bean)).get("CNUM").toString());
//					if(rows > 0){
//						checkResult = false;
//						break;
//					}
//			}	
			if(checkResult == true){
				try{
					service.delete(idArrs);
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
	
	
	public QasDTeacherresearchService getService() {
		return service;
	}

	@Autowired
	public void setService(QasDTeacherresearchService service) {
		this.service = service;
	}

	public QasDTeacherresearch getBean() {
		return bean;
	}

	public void setBean(QasDTeacherresearch bean) {
		this.bean = bean;
	}


	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
