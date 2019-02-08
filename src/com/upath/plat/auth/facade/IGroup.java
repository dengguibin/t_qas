package com.upath.plat.auth.facade;

import java.util.List;

public interface IGroup {

	String getGroupId();
	
	String getGroupName();
	
	IGroup getParent();
	
	List<IGroup> getChildren();
	
	boolean hasChildren();
	
	boolean hasParent();
	
	List<IUser> getGroupUsers();
	
}
