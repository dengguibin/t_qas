package com.upath.plat.auth.facade;

import java.util.List;

public interface IUser {
	
	String getUserId();
	
	//系统的登陆ID号,标识此交登陆的唯一信息，此数据将会被维护到数据库里面进行标识
	String getLogId();
	
	void setLogId(String logId);
	
	String getPassword();
	
	void setPassword(String pwd);
	
	String getPhoneNumber();
	
	String getEmailAddress();
	
	/**
	 *  判定此用户是点击【安全退出】 后正常退出系统的状态，还是因为session过期
	 *  系统自己注销掉的用户，在用户登陆日志中进行使用。
	 * @return
	 */
	String getLogOutState();
	
	void setLogOutState(String state);

	String getUserName();
	
	String getHomePage();
	
	//用户是否是管理员权限，所有资源对管理员都是可见的。
	//跟【业务管理员】 不是同一个概念。此管理员主要在数据维护的时候进行使用。
	boolean isAdmin();
	
	/**
	 * 工作流里面对用户组概念有要求
	 * @return 此用户所在的用户组
	 */
	List<IGroup> getGroups();
	
	/**
	 * 默认从根节点取此用户所有的菜单资源，在菜单资源的维护如果把父菜单设置成无效则会造成数据的不统一
	 * 所以加载的时候此方法如果检测到父菜单资源不可用，则忽略下面的子菜单数据。
	 * @return 用户所可以操作的所有菜单资源
	 */
	List<IMenu> getMenus();
	
	/**
	 * 
	 * @param rootId 菜单资源树的根节点，如果显示菜单树的部分资源此功能将会有用。
	 * @return 从指定的菜单树开始进行权限树的加载
	 */
	List<IMenu> getMenus(String rootId);
	
	/**
	 * 
	 * @return 系统给此用户所配置的相关角色列表。
	 */
	List<IRole> getRoles();
	
	/**
	 * 
	 * @param menuId 菜单资源ID
	 * @return  对此菜单所具备的权限列表。【增、删、改....】等系列权限
	 */
	List<IPermissions> getPermissions(String menuId);
	
	/**
	 * 
	 * @return 此用户所在的部门，最直接的部门关系，跟部门树无关。
	 */
	IDepartMent getDepartMent();
	
	String getDepartId();
	
	boolean isValid();
	
	/**
	 * 切换成指定角色。如果参数为空。则切换到混合角色模式下面进行工作
	 * 此角色一定是用户所所有的角色
	 * 否则切换会失败。
	 * @param role
	 */
	boolean switchRoles(IRole role);
	
	/**
	 * 用户当前的角色
	 * 如果是空则是混合角色模式
	 * @return
	 */
	IRole getCurrentRole();
	
	/**
	 * 获取所有的功能点
	 * @return
	 */
	List<IFunction> getFunctions();
	
	/**
	 * 用户当前状态
	 * @return
	 */
	int getStatus();
	
	/**
	 * 唯一的主键信息
	 * @return
	 */
	String getUUID();
	
	List<IMenu> getMenuAnaly();
	
	void setMenuAnaly(List<IMenu> menuAnaly);
		
}
