package com.upath.plat.common.action;

import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.page.Ipage;
import com.upath.plat.common.util.RequestHelper;

public interface IBaseAction {

	/**
	 * 当前分页信息
	 * @return
	 */
	public Ipage getCurrentPagination();
	
	public IUser getLoginUser();
	
	public RequestHelper getRequestHelper();
}
