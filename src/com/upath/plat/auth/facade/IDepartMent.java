package com.upath.plat.auth.facade;

import java.util.List;

public interface IDepartMent {

	String getOrgId();
	
	String getDeptId();
	
	String getDeptName();
	
	//只获取跟此部门ID相关的用户数据，直辖用户
	List<IUser> getDepartUsers();
	
	//获取部门下面所有的用户，包括此部门的子部门用户数据
	List<IUser> getAllUsers();
	
	IDepartMent getParent();
	 
	boolean hasParent();
	
	boolean hasChilden();
	
	List<IDepartMent> getChildren();
	/**
	 * 部门负责人
	 * @return
	 */
	IUser getMaster();
	
}
