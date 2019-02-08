package com.upath.plat.auth.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.upath.plat.auth.model.TRmsDeptment;
import com.upath.plat.common.cache.AuthCacheManager;

@SuppressWarnings("serial")
public class DepartMent extends TRmsDeptment implements IDepartMent,Cloneable,Serializable {

	public List<IDepartMent> getChildren() {
		return AuthCacheManager.getInstance().getSubDepartMent(getDeptId());
	}

	public List<IUser> getDepartUsers() {
		return AuthCacheManager.getInstance().getDeptUsers(this);
	}

	public String getDeptId() {
		return getBmid()+"";
	}

	public String getDeptName() {
		return getBmmc();
	}

	public IUser getMaster() {
		IUser user = null;
		if(getBmhjr() != null){
			AuthCacheManager.getInstance().getUserById(getBmhjr());
		}
		return user;
	}

	public String getOrgId() {
		return getBmid()+"";
	}

	public IDepartMent getParent() {
		return AuthCacheManager.getInstance().getDepartMent(getFbmid()+"");
	}

	public boolean hasChilden() {
		return getChildren() != null;
	}

	public boolean hasParent() {
		return getParent() != null;
	}
	
	public static IDepartMent[] partitionUsers(IUser[] users){
		if(users == null) return null;
		IDepartMent[] depats = null;
		List<IDepartMent>  list = new ArrayList<IDepartMent>();
		DepartMent other = null;
		for(IUser u : users){
			IDepartMent deptMent = u.getDepartMent();
			if(deptMent == null){
				//未分配机构单位的用户统一建立一个新的临时部门来存放
				if(other ==  null){
					other = new DepartMent();
					other.setBmmc("其它");
					other.setBmid("other");
				}
				other.getDepartUsers().add(u);
				continue;
			}
			int index = list.indexOf(deptMent);
			IDepartMent data = null;
			if(index < 0){
				try {
					data = (DepartMent)((DepartMent)deptMent).clone();
					data.getDepartUsers().clear();
					list.add(data);
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}else{
				data = 	list.get(index);
			}
			data.getDepartUsers().add(u);
		}
		
		if(other != null){
			list.add(other);
		}
		
		if(list.isEmpty() == false){
			depats = list.toArray(new IDepartMent[list.size()]);
		}
		return depats;
	}

	
	

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final DepartMent other = (DepartMent) obj;
		if (getBmid() == null) {
			if (other.getBmid() != null)
				return false;
		} else if (!getBmid().equals(other.getBmid()))
			return false;
		return true;
	}

	public List<IUser> getAllUsers() {
		List<IUser> users = new ArrayList<IUser>();
			List<IUser> dsUsers = getDepartUsers();
			if(dsUsers != null && dsUsers.isEmpty() == false){
				users.addAll(dsUsers);
			}
			List<IDepartMent> depts = getChildren();
			if(depts != null && depts.size() > 0){
				for(int i = 0 ; i < depts.size() ; i++){
					IDepartMent dept = depts.get(i);
					List<IUser> us = dept.getAllUsers();
					if(us != null){
						users.addAll(us);
					}
				}
			}
		return users;
	}
	
}
