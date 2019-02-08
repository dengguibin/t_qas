/**
*/
package	com.upath.plat.auth.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsGorupsUser;
import com.upath.plat.auth.model.TRmsGroups;
import com.upath.plat.auth.model.TRmsUserRole;
import com.upath.plat.auth.service.TRmsGroupsService;
import com.upath.plat.common.action.BaseActionSupport;



/**
* strut2 config :
* spring config :
* @ClassName: TRmsGroupsAction.java
* @Description: t_rms_groups
* @author upaths@gmail.com  
* @date2012-11-17 17:22:21
* @version V1.0   
*/

@Scope("prototype")
@Component("tRmsGroupsAction")
@SuppressWarnings({ "rawtypes", "serial", "unchecked", "unused" })
public class TRmsGroupsAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TRmsGroupsAction.class);
	
	/*服务类*/
	private  TRmsGroupsService service;
	
	/*操作实体*/
	private TRmsGroups bean;
	
	/*查询列表数据*/
	private List datas ;
	
	private String userIds;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TRmsGroups data = service.select(bean);
		if(data != null){
			bean = data;
		}
		if(bean == null){
			bean = new TRmsGroups();
			bean.setSfyx(1);
		}
		return FORWARD_SELECT;
	}
	
	public String manage(){
		
		return "manage";
	}
	
	/**
	 * 如果配置out 这个参数 ，数据直接 以JSON 传出。方便 AJAX进行调用 
	 * 否则放在 控制上下文当中 
	 * @return
	 * @throws IOException
	 */
	public String listTree() throws IOException{
		String result = null;
		datas = service.listGroups(bean);
		String ctl = request.getParameter("out");
		if(ctl == null){
			result = "listTree";
		}	
		if(datas != null){
				JSONArray  json = JSONArray.fromObject(datas);
					if( ctl != null ){
						response.getWriter().print(json.toString());
					}else{
						request.setAttribute("json", json.toString());
					}
		}
		return result;
		
	}
	public String listUser() throws IOException{
		String result = null;
		datas = service.listUser(bean);
		String ctl = request.getParameter("out");
		if(ctl == null){
			result = "listUser";
		}	
		if(datas != null){
			JSONArray  json = JSONArray.fromObject(datas);
			if( ctl != null ){
				response.getWriter().print(json.toString());
			}else{
				request.setAttribute("json", json.toString());
			}
		}
		return result;
		
	}
	/**
	 * 查询数据列表
	 * @return select
	 */
	public String list(){
		request.setAttribute("mapper",service.getMapperClass());
		return FORWARD_LIST;
	}
	
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		TRmsGroups data = service.select(bean);
			if(data != null){
				bean.setXgr(getLoginUser().getUserId());
				bean.setXgsj(new Date());
				service.update(bean);
			}else{
				isNew = true;
				bean.setCjr(getLoginUser().getUserId());
				bean.setCjsj(new Date());
				service.insert(bean);
			}
		return FORWARD_SAVEOK;
	}
	
	
	public String saveUser() throws IOException{
		Map result = new HashMap();
		/*默认值代表成功*/
		result.put("result", 1);
		if(userIds == null && bean != null){
			/**
			 * 一个用户也没有选中，需要进行删除操作
			 */
			try{
				service.deleteGroupUsers(bean);
			}catch(Exception e){
				log.error(e);
				result.put("result",0);
			}
		}
		
		if(userIds != null && bean != null){
			String arr[] = userIds.split(",");
			datas = service.listUser(bean);
			/*
			 * 计算用户对当前的角色选择了添加哪些菜单，删除了哪些菜单
			 * */
			List<TRmsGorupsUser> adds = new ArrayList<TRmsGorupsUser>();
			List<TRmsGorupsUser> dels = new ArrayList<TRmsGorupsUser>();
			for(int i = 0 ; i < datas.size() ; i++){
				/**
				 * 过滤单位组
				 */
				Map data = (Map)datas.get(i);
				if("U".equals(data.get("TYPE")) == false){
					continue;
				}
				Object yhzid = data.get("YHZID");
				String yhid = data.get("YHID").toString();
				if(yhzid != null){
					/**
					 * 原来用户已有用户组关系
					 */
						boolean matched = false;
						for(int k = 0 ; k < arr.length ; k++){
							if(arr[k].equals(yhid) == true){
								matched = true;
								break;
							}
						}
						/*
						 * 对此次的用户角色关系做删除操作
						 * */
						if(matched == false){
							TRmsGorupsUser group = new TRmsGorupsUser();
							group.setYhid(yhid);
							group.setYhzid(bean.getYhzid());
							dels.add(group);
						}
				}else{
					boolean matched = false;
					/**
					 * 此类的用户需要再进行建立关系
					 */
					for(int k = 0 ; k < arr.length ; k++){
						if(arr[k].equals(yhid) == true){
							matched = true;
							break;
						}
					}
					if(matched == true){
						TRmsGorupsUser group = new TRmsGorupsUser();
						group.setYhid(yhid);
						group.setYhzid(bean.getYhzid());
						adds.add(group);
					}
				}
				
			}
			try{
				service.batchMaintUser(bean, adds,dels);
			}catch(Exception e){
				log.error(e);
				result.put("result", 0);
			}
			
		}
		JSONObject obj = JSONObject.fromObject(result);
		response.getWriter().print(obj.toString());
		return null;
	}
	
	/**
	 * 删除数据
	 * @return select
	 */
	public String delete(){
		service.delete(bean);
		return null;
	}
	
	
	@Autowired
	public void setService(TRmsGroupsService service) {
		this.service = service;
	}

	public TRmsGroups getBean() {
		return bean;
	}

	public void setBean(TRmsGroups bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
}
