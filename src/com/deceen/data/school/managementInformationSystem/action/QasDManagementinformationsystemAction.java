package	com.deceen.data.school.managementInformationSystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.deceen.data.school.managementInformationSystem.model.QasDManagementinformationsystem;
import com.deceen.data.school.managementInformationSystem.service.QasDManagementinformationsystemService;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.action.BaseActionSupport;


/**
* @ClassName: QasDManagementinformationsystemAction.java
* @Description: qas_d_managementinformationsystem
* @author upaths@gmail.com  
* @date2017-11-22 17:50:47
* @version V1.0   
*/
@Scope("prototype")
@Component("qasDManagementinformationsystemAction")	
@SuppressWarnings({ "rawtypes", "unchecked", "serial" ,"unused" })
public class QasDManagementinformationsystemAction  extends BaseActionSupport{

	private static final Logger log = Logger.getLogger(QasDManagementinformationsystemAction.class);

	private  QasDManagementinformationsystemService service;
	
	private QasDManagementinformationsystem bean;
	
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
		 /*req.setCharacterEncoding("utf-8");//必须写在第一位，因为采用这种方式去读取数据，否 则数据会出错。 
		 //设置这样方式去读。这样中文就能够读取出来了，但是需要注意。表单的发送方式必须是<span style="color:#ff0000;"> method='post'</span> 
		 resp.setContentType("text/html;charset=utf-8");
		 resp.setCharacterEncoding("utf-8");*/
		if(bean == null){ 
			bean = new QasDManagementinformationsystem();
		}
		datas = service.list(bean);
		/*for (int i = 0; i < datas.size(); i++) {
			System.out.println("datas是："+datas);
			System.out.println("键值是："+((HashMap)(datas.get(i))).get("STORAGETIME"));
			if(((HashMap)(datas.get(i))).get("TYPE")!=null){
				((HashMap)(datas.get(i))).put("TYPE",new String((String.valueOf(((HashMap)(datas.get(i))).get("TYPE"))).getBytes("gbk"), "utf-8"));
			}
			if(((HashMap)(datas.get(i))).get("SYSTEMNAME")!=null){
			((HashMap)(datas.get(i))).put("SYSTEMNAME",new String((String.valueOf(((HashMap)(datas.get(i))).get("SYSTEMNAME"))).getBytes("gbk"), "utf-8"));
			}
			if(((HashMap)(datas.get(i))).get("SOURCE")!=null){
				((HashMap)(datas.get(i))).put("SOURCE",new String((String.valueOf(((HashMap)(datas.get(i))).get("SOURCE"))).getBytes("gbk"), "utf-8"));
			}
			if(((HashMap)(datas.get(i))).get("DEVELOPMENTUNIT")!=null){
				((HashMap)(datas.get(i))).put("DEVELOPMENTUNIT",new String((String.valueOf(((HashMap)(datas.get(i))).get("DEVELOPMENTUNIT"))).getBytes("gbk"), "utf-8"));
			}
		}*/
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
				QasDManagementinformationsystem dsBean = service.select(bean.getId());
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
	
	
	public QasDManagementinformationsystemService getService() {
		return service;
	}

	@Autowired
	public void setService(QasDManagementinformationsystemService service) {
		this.service = service;
	}

	public QasDManagementinformationsystem getBean() {
		return bean;
	}

	public void setBean(QasDManagementinformationsystem bean) {
		this.bean = bean;
	}


	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
