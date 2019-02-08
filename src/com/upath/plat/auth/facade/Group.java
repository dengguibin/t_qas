package com.upath.plat.auth.facade;

import java.io.Serializable;
import java.util.List;

import com.upath.plat.auth.model.TRmsGroups;
import com.upath.plat.common.cache.AuthCacheManager;

@SuppressWarnings("serial")
public class Group extends TRmsGroups implements IGroup,Serializable{

	public List<IGroup> getChildren() {
		return AuthCacheManager.getInstance().getGroupChildren(this);
	}

	public String getGroupId() {
		return getYhzid()+"";
	}

	public String getGroupName() {
		return getYhzmc();
	}

	public List<IUser> getGroupUsers() {
		return AuthCacheManager.getInstance().getGroupUsers(this);
	}

	public IGroup getParent() {
		if(getFyhzid() == null){
			return null;
		}
		return AuthCacheManager.getInstance().getGroup(getFyhzid()+"");
	}

	public boolean hasChildren() {
		return (getChildren() != null && getChildren().isEmpty() == false);
	}

	public boolean hasParent() {
		return getParent() != null;
	}

}
