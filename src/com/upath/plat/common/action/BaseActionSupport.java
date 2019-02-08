package com.upath.plat.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.page.Ipage;
import com.upath.plat.common.util.RequestHelper;

public class BaseActionSupport extends ActionSupport implements IBaseAction,ServletRequestAware,ServletResponseAware {
	
	private static final long serialVersionUID = 8086856617130333767L;

	public static final String  FORWARD_LIST = "list";
	
	public static final String  FORWARD_TOEDIT = "toEdit";
	
	public static final String  FORWARD_SELECT = "select";
	
	public static final String  FORWARD_SAVE = "save";
	
	public static final String  FORWARD_SAVEOK = "saveOK";
	
	public static final String  FORWARD_MENUTAGS = "menuTags";
	
	protected String  menuId;

	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	public Ipage getCurrentPagination() {
		Ipage ipage = RequestHelper.getInstance().getCurrentPagination();
		return ipage;
	}

	public void setServletRequest(HttpServletRequest request) {
			this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
			this.response = response;
	}

	public IUser getLoginUser() {
		RequestHelper helper = getRequestHelper();
		IUser user = null;
		if(helper != null){
			user = helper.getLoginUser();
		}
		return user;
	}

	public RequestHelper getRequestHelper() {
		return RequestHelper.getInstance();
	}
	
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
}
