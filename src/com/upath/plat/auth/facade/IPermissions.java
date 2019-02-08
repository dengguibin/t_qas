package com.upath.plat.auth.facade;


public interface IPermissions {

	String	getName();
	
	String getId();
	/**
	 * 权限的位移码
	 * @return
	 */
	Integer getStat();
}
