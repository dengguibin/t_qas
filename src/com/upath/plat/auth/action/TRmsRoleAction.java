/**
*/
package	com.upath.plat.auth.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.facade.IPermissions;
import com.upath.plat.auth.model.TRmsRole;
import com.upath.plat.auth.model.TRmsRoleMenu;
import com.upath.plat.auth.model.TRmsRolePermisions;
import com.upath.plat.auth.model.TRmsUserRole;
import com.upath.plat.auth.service.TRmsRoleService;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.cache.AuthCacheManager;
import com.upath.plat.common.cache.CacheManager;
import com.upath.plat.common.cache.ICacheCode;
import com.upath.plat.common.util.PropertyUtil;
import com.upath.plat.common.util.VTree;



/**
* strut2 config :
* spring config :
* @ClassName: TRmsRoleAction.java
* @Description: t_rms_role
* @author upaths@gmail.com  
* @date2012-11-11 21:51:25
* @version V1.0   
*/

@Scope("prototype")
@Component("tRmsRoleAction")
@SuppressWarnings({ "rawtypes", "serial", "unchecked", "unused" })
public class TRmsRoleAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TRmsRoleAction.class);
	
	/*服务类*/
	private  TRmsRoleService service;
	
	
	/*操作实体*/
	private TRmsRole bean;
	
	/*查询列表数据*/
	private List datas ;
	
	/**
	 * 权限对应ID号
	 */
	private String[] permiss;
	
	/**
	 * 传入对应的 菜单 ID ，多个以，进行分隔
	 */
	private String menuIds;
	
	
	/**
	 * 哪些用户赋于相关的权限
	 */
	private String userIds;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TRmsRole data = service.select(bean);
		if(data != null){
			bean = data;
			TRmsRolePermisions  rp = new TRmsRolePermisions();
			rp.setJsid(bean.getJsid());
			List<TRmsRolePermisions> rps = 	service.listPermisions(rp);
			if(rps != null){
				this.permiss = new String[rps.size()];
					for(int i = 0 ; i < rps.size() ; i++){
						permiss[i] = rps.get(i).getQxid();
					}
			}
		}
		if(bean == null){
			bean = new TRmsRole();
			//bean.setSfyx(1);
			permiss = new String[]{"view"};
			bean.setSfyx(1);
		}
		
		return FORWARD_SELECT;
	}
	
	/**
	 * 查询数据列表
	 * @return select
	 */
	public String list(){
	//	request.setAttribute("mapper",service.getMapperClass());
		
		return FORWARD_LIST;
	}
	
	
	public String reload() throws IOException{
		Map result = new HashMap();
		try{
			AuthCacheManager.getInstance().reload();
			result.put("status", "1");
		}catch(Exception e){
			result.put("status", "0");
			e.printStackTrace();
		}
		JSONObject obj = JSONObject.fromObject(result);
		response.getWriter().print(obj.toString());
		return null;
	}
	
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		TRmsRole data = service.select(bean);
		List<TRmsRolePermisions> permisions = null;
			if(permiss != null && permiss.length > 0){
				permisions = new ArrayList<TRmsRolePermisions>();
				for(int i = 0 ; i < permiss.length ; i++){
					TRmsRolePermisions  rp = new TRmsRolePermisions();
					 rp.setQxid(permiss[i]);
					 permisions.add(rp);
				}
			}
			if(data != null){
				bean.setXgr(getLoginUser().getUserName());
				bean.setXgsj(new Date());
				service.update(bean,permisions);
			}else{
				isNew = true;
				bean.setCjsj(new Date());
				bean.setCjr(getLoginUser().getUserName());
				service.insert(bean,permisions);
			}
		return FORWARD_SAVEOK;
	}
	
	public String treeList(){
		if(bean != null){
			datas = service.listMenus(bean);
			/**
			 * 为了保证程序的通用性方ֹ面考虑
			 * 用程序来对菜单树进行排序
			 * 在MYSQL ORACLE MSSQL环境下面都是通用的SQL写法。程序来改变这排庿
			 */		
			//过滤 掉无效的菜单 配置数据。保证是一棵树形展示的菜单
			VTree tree  = VTree.buildMapVTree(datas, "CDID", "PCDID", null);		
			List objs = tree.asMapDataList();
			JSONArray json = JSONArray.fromObject(objs);
			request.setAttribute("json", json.toString());
		}
		
		return "treeList";
	}
	
	
	public String listPermissions(){
		if(bean != null){
			datas = service.listMenus(bean);
					Iterator iter = datas.iterator();
					while(iter.hasNext() == true){
						Map map = (Map)iter.next();
						if("TRUE".equalsIgnoreCase(map.get("CHECKED")+"") == false){
							iter.remove();
						}
					}
			/**
			 * 为了保证程序的通用性方ֹ面考虑
			 * 用程序来对菜单树进行排序
			 * 在MYSQL ORACLE MSSQL环境下面都是通用的SQL写法。程序来改变这排庿
			 */		
			VTree tree  = VTree.buildMapVTree(datas, "CDID", "PCDID", null);		
			List objs = tree.asMapDataList();
			if(objs != null && objs.size() > 1){
			//不需要进行数据去除.黄斌2015-08-	09修改
			//	objs = objs.subList(1, objs.size());
				datas = objs;
			}
			
			
					
//			if(datas.isEmpty() == false){
//				iter = datas.iterator();
//				while(iter.hasNext() == true){
//					Map map = (Map)iter.next();
//					int level = calTreeLevel(datas, map, 0,0);
//					map.put("LEVEL", level);
//				}
//			}	
					
			JSONArray json = JSONArray.fromObject(datas);
			request.setAttribute("json", json.toString());
		}
		
		List<IPermissions> perms = AuthCacheManager.getInstance().getAllPermissions();
	 	request.setAttribute("perms", perms);
		
		return "listPermissions";
	}
	
	
//	int calTreeLevel(List datas,Map data,int level,int order){
//		 	Object po = data.get("PCDID");
//			if(po != null){
//				for(Object o : datas){
//					Map m = (Map)o;
//					String pTreeId = m.get("CDID").toString();
//				 	if(pTreeId.equals(po.toString())){
//				 	return	calTreeLevel(datas, m, (++level),order);
//				 	}
//				}
//			}
//		return level;
//	}
//	
	
	
	
	public String listUser(){
		if(bean != null){
			datas = service.listUser(bean);
			if(datas != null){
				for(Object o : datas){
					String type =	PropertyUtil.getMapValue(o, "TYPE");
						if("D".equals(type) == true){
							String bmid = PropertyUtil.getMapValue(o, "YHID");
							boolean matched = false;
							for(Object t : datas){
								String pid = PropertyUtil.getMapValue(t, "BMID","__");
								if(pid.equals(bmid) == true){
									String checked = PropertyUtil.getMapValue(t, "CHECKED");
									if("1".equals(checked) == true){
										PropertyUtil.setMapValue(o, "CHECKED", 1);
										break;
									}
								}
							}
						}
				}
			}
			JSONArray json = JSONArray.fromObject(datas);
			request.setAttribute("json", json.toString());
			/*
			List<ICacheCode> types =  CacheManager.getInstance().getCodes("UNIT_TYPE");
			if(types != null){
				JSONArray arrTypes = JSONArray.fromObject(types);
				request.setAttribute("jsonTypes", arrTypes);
			}*/
		}
		
		return "listUser";
	}
	
	public String saveTree() throws IOException{
		if(menuIds != null && bean != null){
			String arr[] = menuIds.split(",");
			datas = service.listMenus(bean);
			/*
			 * 计算用户对当前的角色选择了添加哪些菜单，删除了哪些菜单
			 * */
			List<TRmsRoleMenu> adds = new ArrayList<TRmsRoleMenu>();
			List<TRmsRoleMenu> dels = new ArrayList<TRmsRoleMenu>();
			for(int i = 0 ; i < datas.size() ; i++){
				Map data = (Map)datas.get(i);
				Object jsid = data.get("JSID");
				String cdid = data.get("CDID").toString();
				if(jsid != null){
					/**
					 * 角色原来就拥有此菜单，判定是否被删除
					 */
						boolean matched = false;
						for(int k = 0 ; k < arr.length ; k++){
							if(arr[k].equals(cdid) == true){
								matched = true;
								break;
							}
						}
						/*
						 * 要对这类菜单进行删除操作
						 * */
						if(matched == false){
							TRmsRoleMenu menu = new TRmsRoleMenu();
							menu.setCdid(Integer.valueOf(cdid));
							menu.setJsid(bean.getJsid());
							dels.add(menu);
						}
				}else{
					boolean matched = false;
					/**
					 * 此类的菜单需要再进行建立关系
					 */
					for(int k = 0 ; k < arr.length ; k++){
						if(arr[k].equals(cdid) == true){
							matched = true;
							break;
						}
					}
					if(matched == true){
						TRmsRoleMenu menu = new TRmsRoleMenu();
						menu.setCdid(Integer.valueOf(cdid));
						adds.add(menu);
					}
				}
				
			}
			Map result = new HashMap();
			result.put("result", 1);
			try{
				service.batchMaintTree(bean, adds,dels);
			}catch(Exception e){
				log.error(e);
				result.put("result", 0);
			}
			JSONObject obj = JSONObject.fromObject(result);
			response.getWriter().print(obj.toString());
		}
		return null;
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
				service.deleteRoleUsers(bean);
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
			List<TRmsUserRole> adds = new ArrayList<TRmsUserRole>();
			List<TRmsUserRole> dels = new ArrayList<TRmsUserRole>();
			for(int i = 0 ; i < datas.size() ; i++){
				/**
				 * 过滤单位组
				 */
				Map data = (Map)datas.get(i);
				if("U".equals(data.get("TYPE")) == false){
					continue;
				}
				//Object jsid = data.get("YHJSGXID");  sql语句中并没有查出YHJSGXID字段
				Object checked = data.get("CHECKED");
				String yhid = data.get("YHID").toString();
				if("TRUE".equals(checked)){
					/**
					 * 原来用户已经有此角色关系
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
							TRmsUserRole user = new TRmsUserRole();
							user.setJsid(bean.getJsid());
							user.setYhid(yhid);
							dels.add(user);
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
						TRmsUserRole user = new TRmsUserRole();
						user.setYhid(yhid);
						adds.add(user);
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
	
	

	public String savePermissions() throws IOException{
		if(menuIds != null){
			/**
			 * 权限ID绑定在menuIds下面
			 */
			String arr[] = menuIds.split(",");
			/**
			 * 权限值绑定在userIds下面
			 */
			String value[] = userIds.split(",");
			/*
			 * 更新权限值
			 * */
			List<TRmsRoleMenu> updates = new ArrayList<TRmsRoleMenu>();
			for(int i = 0 ; i < arr.length ; i++){
				TRmsRoleMenu rm = new TRmsRoleMenu();
				rm.setJscdgxid(Integer.valueOf(arr[i]));
				rm.setQx(Integer.valueOf(value[i]));
				updates.add(rm);
			}
			
			Map result = new HashMap();
			result.put("result", 1);
			try{
				if(updates != null && updates.isEmpty() == false){
					service.batchMaintPermissions(updates);
				}
			}catch(Exception e){
				log.error(e);
				result.put("result", 0);
			}
			JSONObject obj = JSONObject.fromObject(result);
			response.getWriter().print(obj.toString());
		}
		return null;
	}
	
	
	/**
	 * 删除数据
	 * @return select
	 */
	public String delete() throws Exception{
		Map result = new HashMap();
		result.put("status", "0");
		if(bean != null ){
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
					 service.delete(bean);;
					result.put("status", "1");
				}catch(Exception e){
					result.put("status", "2");
					e.printStackTrace();
					result.put("message", "已经存在相关联的数据，请先删除");
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
	
	
	@Autowired
	public void setService(TRmsRoleService service) {
		this.service = service;
	}

	public TRmsRole getBean() {
		return bean;
	}

	public void setBean(TRmsRole bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public String[] getPermiss() {
		return permiss;
	}

	public void setPermiss(String[] permiss) {
		this.permiss = permiss;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	
}
