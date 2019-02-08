package com.upath.plat.auth.facade;

import java.io.Serializable;
import java.util.List;

import com.upath.plat.auth.model.TRmsRole;
import com.upath.plat.common.cache.AuthCacheManager;

@SuppressWarnings("serial")
public class Role extends TRmsRole implements IRole , Serializable{

	public List<IMenu> getMenus() {
		return AuthCacheManager.getInstance().getMenus(this);
	}

	public String getRoleId() {
		
		return getJsid()+"";
	}

	public String getRoleName() {
		return getJsmc();
	}

	public List<IUser> getRoleUsers() {
		return AuthCacheManager.getInstance().getRoleUsers(this);
	}

	public boolean isAdmin() {
		if("admin".equals(getRoleName()) == true){
			return true;
		}
		return false;
	}



	public boolean hasMenu(IMenu menu) {
		List<IMenu> menus =  getMenus();
		if(menu != null && menus != null && menus.isEmpty() == false){
			return menus.contains(menu);
		}
		return false;
	}



	public int getPermCode() {
		int qxCode = 0 ;
		List<IPermissions> perms = AuthCacheManager.getInstance().getRolePermissions(this);
			if(perms != null){
				for(int i = 0 ; i < perms.size() ; i++){
					IPermissions permissions = perms.get(i);
					qxCode = qxCode | permissions.getStat();
				}
			}
		return qxCode;
	}

}
