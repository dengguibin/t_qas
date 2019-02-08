package com.upath.plat.auth.facade;

public interface IFunction {
	
	Integer getFuncid();
	
	String getFuncName();
	
	/**
	 * 权限代码
	 * @return
	 */
	String getCode();
	
	/**
	 * 功能对应的URL
	 * @return
	 */
	String getUrl();
	
	Integer getMenuId();
	
	String getMarks();

}
