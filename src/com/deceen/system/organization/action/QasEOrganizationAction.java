		
		
/**
*/
package	com.deceen.system.organization.action;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.action.BaseActionSupport;
import com.deceen.system.organization.model.QasEOrganization;
import com.deceen.system.organization.service.QasEOrganizationService;
import com.deceen.utils.ResultMap;

import net.sf.json.JSONObject;


/**
* @ClassName: QasEOrganizationAction.java
* @Description: qas_e_organization
* @author upaths@gmail.com  
* @date2017-12-4 17:06:26
* @version V1.0   
*/
@Scope("prototype")
@Component("qasEOrganizationAction")	
@SuppressWarnings({ "rawtypes", "serial", "unchecked", "unused" })
public class QasEOrganizationAction  extends BaseActionSupport{

	private static final Logger log = Logger.getLogger(QasEOrganizationAction.class);

	private  QasEOrganizationService service;
	
	private QasEOrganization bean;
	
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
			bean = new QasEOrganization();
		}
		datas = service.list(bean);
		return FORWARD_LIST;
	}
	
	public String getTree()throws Exception{
		ResultMap result = new ResultMap();
		String key = request.getParameter("key");
		String status=request.getParameter("status");
		List<QasEOrganization> list=new ArrayList<QasEOrganization>();
		/*if(StringUtils.isEmpty(key) && StringUtils.isEmpty(status)){
			list = service.getTree();
		}*/
		if(key!=null && key!="" && status!=null && status!=""){
			list = service.selectTree(key);
		}
		if(status!=null && status!="" && key==null || key==""){
			list = service.getTree(status);
		}
		result.setObj(list);
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;
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
				QasEOrganization dsBean = service.select(bean.getId());
				if(dsBean != null){
					if(user!=null){
						bean.setUpdatedby(user.getUserId());
					}
				// 如果数据库中有此记录信息，进行更新操作
					int rows = service.updateWithDyna(bean);
				}else{
					//是否需要输出数据不存在的异常
				}
			}else{
				if(user!=null){
					bean.setCreatedby(user.getUserId());
				}
				int rows = service.insert(bean);
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
//					int rows = Integer.valueOf(((Map)service.get2Object("查询数据的行数", bean)).get("CNUM").toString());
//					if(rows > 0){
//						checkResult = false;
//						break;
//					}
//			}	
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
	
	
	public QasEOrganizationService getService() {
		return service;
	}

	@Autowired
	public void setService(QasEOrganizationService service) {
		this.service = service;
	}

	public QasEOrganization getBean() {
		return bean;
	}

	public void setBean(QasEOrganization bean) {
		this.bean = bean;
	}


	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}