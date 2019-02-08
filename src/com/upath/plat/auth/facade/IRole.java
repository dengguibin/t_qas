package com.upath.plat.auth.facade;

import java.util.List;

public interface IRole {

	List<IUser> getRoleUsers();
	
	List<IMenu> getMenus();
	
	String getRoleId();
	
	String getRoleName();
	
	
	boolean hasMenu(IMenu menu);
	
	boolean isAdmin();
	
	//权限控制代码
	int getPermCode();
}
