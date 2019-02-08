package com.upath.plat.auth.facade;

import java.util.List;

public interface IMenu {

	Integer getMenuId();
	
	String getMenuName();
	
	Integer getPId();
	
	String getParams();
	
	Integer getType();
	
	boolean isValid();
	
	Integer getDepth();
	
	String  getUrl();

	boolean hasParent();
	
	boolean hasChilden();
	
	public IMenu getParent();
	
	List<IMenu> getChildren();
	
	/**
	 * 检测是否为某一节点的后代子节点
	 * @param menu
	 * @return
	 */
	boolean isDescendants(IMenu menu);
	
	/**
	 * 
	 * @param include 是否包含父菜单的功能点位
	 * @return
	 */
	List<IFunction> getFunctions(boolean include);
		
}
