package	com.upath.plat.auth.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.facade.IMenu;
import com.upath.plat.auth.facade.IRole;
import com.upath.plat.auth.model.TRmsMenuinfo;
import com.upath.plat.auth.model.TRmsRoleMenu;
import com.upath.plat.auth.service.TRmsMenuinfoService;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.cache.AuthCacheManager;
import com.upath.plat.common.exception.PlatformException;



/**
* strut2 config :
* spring config :
* @ClassName: TRmsMenuinfoAction.java
* @Description: t_rms_menuinfo
* @author upaths@gmail.com  
* @date2012-10-20 21:50:35
* @version V1.0   
*/
@Scope("prototype")
@Component("tRmsMenuinfoAction")
@SuppressWarnings({ "rawtypes", "serial", "unchecked", "unused" })
public class TRmsMenuinfoAction extends BaseActionSupport {

	/**服务类*/
	private  TRmsMenuinfoService service;
	
	/**操作实体*/
	private TRmsMenuinfo bean;
	
	/**查询列表数据*/
	private List datas ;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TRmsMenuinfo data = null;
		List roles = 	AuthCacheManager.getInstance().getAllRoles();
		Map roleMenuInfo = new HashMap();
		if(bean != null && bean.getCdid() != null){
			data = service.select(bean);
			if(data != null){
				bean = data;
			}
		}
		if( bean == null ){
			bean = new TRmsMenuinfo();
		}
		if( bean.getCdid() == null){
			bean.setSfyx(1);
			bean.setLjlx(1);
		}	
		if(bean.getPcdid() != null){
			data  = new TRmsMenuinfo();
			data.setCdid(bean.getPcdid());
			data = service.select(data);
			if(data != null){
				bean.setXtid(data.getXtid());
			}
			request.setAttribute("pmenu", data);
		}
		if(roles != null && roles.isEmpty() == false){
			List<TRmsRoleMenu> rmsInfo  = null;
			if(bean != null && bean.getCdid() != null){
				rmsInfo = service.listRolesByMenuId(bean.getCdid());
			}
			for(int i = 0 ; i < roles.size() ; i++){
				IRole role = (IRole)roles.get(i);
				String roleId = role.getRoleId();
				boolean mathched = false;
				if(rmsInfo != null){
					for(TRmsRoleMenu rm : rmsInfo){
						if((rm.getJsid()+"").equals(roleId) == true){
							mathched = true;
							break;
						}
					}
					
				}
				if(mathched == true){
					//已经选中
					roleMenuInfo.put(role, 1);
				}else{
					roleMenuInfo.put(role, 0);
				}
			}
		}
		request.setAttribute("roleInfo", roleMenuInfo);
		return FORWARD_SELECT;
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
		TRmsMenuinfo data = service.select(bean);
			if(data != null){
				bean.setXgsj(new Date());
				service.update(bean);
			}else{
				isNew = true;
				bean.setCjsj(new Date());
				service.insert(bean);
			}
			//重新加载 数据,添加菜单及系统管理员可以同步看到菜单的信息
			AuthCacheManager.getInstance().reload(AuthCacheManager.CODE_MENUS);
			
		return FORWARD_SAVEOK;
	}
	
	/**
	 * 删除数据
	 * @return select
	 */
	public String delete() throws Exception{
		Map result = new HashMap();
		result.put("status", "0");
		if(bean != null && bean.getCdid() != null){
			try{
				service.delete(bean);
				//重新加载 数据,添加菜单及系统管理员可以同步看到菜单的信息
				AuthCacheManager.getInstance().reload(AuthCacheManager.CODE_MENUS);
				result.put("status", "1");
			}catch(Exception e){
				result.put("status", "2");
				e.printStackTrace();
				result.put("message", e.getMessage());
			}
		}else{
			result.put("message","错误参数");
		}
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	public String manage(){
		return "manage";
	}
	
	public String redirect(){
		TRmsMenuinfo data = null;
		if(bean != null && bean.getCdid() != null){
			data = (TRmsMenuinfo)AuthCacheManager.getInstance().getMenu(bean.getCdid());
		}
		if(data != null){
			String mId = data.getCdid()+"";
			List<IMenu> allMenus = getLoginUser().getMenus();
			boolean hasMenu = false;
			if(allMenus != null && mId != null){
				for(int i = 0 ; i < allMenus.size() ; i++){
					if(mId.equals(allMenus.get(i).getMenuId()+"") == true){
						hasMenu = true;
						break;
					}
				}
			}
			if(hasMenu == false){
				throw new PlatformException("对不起，你没有访问此功能的["+data.getCdmc()+"]的权限，你可以联系管理员进行权限分配。");
			}
			bean = data;
			if(bean.getLjdz() != null){
				String url = bean.getLjdz();
					if(url.indexOf("?") > -1){
						url += "&menuId="+bean.getCdid();
					}else{
						url += "?menuId="+bean.getCdid();
					}
				request.setAttribute("location", url);	
			}
		}
		return "redirect";
	}
	
	@Autowired
	public void setService(TRmsMenuinfoService service) {
		this.service = service;
	}

	public TRmsMenuinfo getBean() {
		return bean;
	}

	public void setBean(TRmsMenuinfo bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
