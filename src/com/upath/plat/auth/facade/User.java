package com.upath.plat.auth.facade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.log4j.Logger;

import com.upath.plat.auth.model.TRmsUser;
import com.upath.plat.common.cache.AuthCacheManager;
import com.upath.plat.common.modules.model.TRmsLogininfo;
import com.upath.plat.common.modules.service.TRmsLogininfoService;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.common.util.VTree;
@SuppressWarnings({ "serial", "unchecked" })
public class User extends TRmsUser implements IUser,HttpSessionBindingListener, Serializable {

	private static final Logger log = Logger.getLogger(User.class);
	
	private IRole role = null;
	
	private String logId;
	
	/**用来区分 用户是点击安全退出，还是系统自然会话状态退出*/
	private String logOutState;
	
	/**用于装诊断分析的菜单*/
	private List<IMenu> menuAnaly;

	
	public List<IMenu> getMenuAnaly() {
		return menuAnaly;
	}

	public void setMenuAnaly(List<IMenu> menuAnaly) {
		this.menuAnaly = menuAnaly;
	}

	public IDepartMent getDepartMent() {
		return AuthCacheManager.getInstance().getDepartMent(getBmid()+"");
	}

	public List<IGroup> getGroups() {
		return AuthCacheManager.getInstance().getGroups(this);
	}

	public List<IMenu> getMenus() {
		return AuthCacheManager.getInstance().getMenus(this);
	}

	public String getPassword() {
		return getYhmm();
	}

	public List<IRole> getRoles() {
		//如果 是管理员。将返回系统使用的角色清单 
		if(this.isAdmin() == true){
			return AuthCacheManager.getInstance().getAllRoles();
		}
		return AuthCacheManager.getInstance().getRoles(this);
	}

	public String getUserId() {
		return getYhid();
	}

	public String getUserName() {
		return getYhmc();
	}

	public boolean isAdmin() {
		List<IRole> roles = AuthCacheManager.getInstance().getRoles(this);
			if(roles != null){
				for(IRole r : roles){
					if(r.isAdmin() == true){
						return true;
					}
				}
			}
		return false;
	}

	public String getHomePage() {
		return getGrzy();
	}

	public boolean isValid() {
		Integer valid = getSfyx();
		return (valid != null && valid == 1);
	}
	
	public List<IPermissions> getPermissions(String menuId){
			return AuthCacheManager.getInstance().getMenuPermissions(menuId, this);
	}
	
	/**
	 * 侦听用户登陆时进行消息管理
	 */
	public void valueBound(HttpSessionBindingEvent event) {
		log.info("session HttpSessionBindingEvent"+getUserId());
	}

	/**
	 * 侦听用户退出登陆时进行消息管理
	 */
	public void valueUnbound(HttpSessionBindingEvent event) {
		try{
			TRmsLogininfoService  service = (TRmsLogininfoService) PlatUtil.getApplicationContext().getBean("tRmsLogininfoService");
			TRmsLogininfo bean = new TRmsLogininfo();
			bean.setLogid(getLogId());
			bean.setOuttime(new Date());
			if(getLogOutState() == null){
				bean.setOutstate(0);
			}else{
				bean.setOutstate(1);
			}
			service.update(bean);
		}catch(Exception e){
			log.error("更新用户退出登陆信息失败");
			e.printStackTrace();
		}
		log.info("用户注销:session sessionDestroyed ");
	}

	public IRole getCurrentRole() {
		return this.role;
	}

	/**
	 * 切换成指定角色。切换后用户的相关拥有的菜单和权限管理将会改变。
	 */
	public boolean switchRoles(IRole role) {
		boolean result = false;
		if(role == null){
			this.role = role;
			result = true;
		}
		List<IRole> roles = this.getRoles();
			if(roles != null && roles.isEmpty() == false){
				for(int i = 0 ; i < roles.size() ; i++){
					IRole cRole = roles.get(i);
					if(cRole == role || cRole.getRoleId().equals(role.getRoleId()) == true){
						this.role = role;
						result = true;
						break;
					}
				}
			}
		return result;
	}

	/**
	 * 从用户的权限菜单中的一个节点开始查找下面所有的子节点树
	 */
	public List<IMenu> getMenus(String rootId) {
		List<IMenu> menus = getMenus();
		if(menus != null && menus.isEmpty() == false){
			try {
				VTree vTree = 	VTree.buildVTree(menus, "menuId", "pcdid", rootId);
				return vTree.asDataList();
			} catch (Exception e) {
				log.error("转换用户树失败");
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getLogOutState() {
		return logOutState;
	}

	public void setLogOutState(String logOutState) {
		this.logOutState = logOutState;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public void setPassword(String pwd) {
		this.setYhmm(pwd);
	}

	/**
	 * 获取用户下面所有的菜单功能分配情况
	 */
	public List<IFunction> getFunctions() {
		return AuthCacheManager.getInstance().getFunctions(this);
	}

	public String getPhoneNumber() {
		return getSjhm();
	}

	public String getEmailAddress() {
		return getDzyj();
	}

	public String getDepartId() {
		return getBmid();
	}

	public int getStatus() {
		return getYhzt();
	}

	public String getUUID() {
		return getUid();
	}

}
