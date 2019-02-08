package com.upath.plat.common.filter;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.util.RequestHelper;

/**
 * 
 * @author Administrator
 *
 *此功能暂时不使用
 */
public class ValidateUserInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 332605420895359162L;
	
	private final static Logger logger = Logger.getLogger(SystemFilter.class);

	public String intercept(ActionInvocation invocation) throws Exception {
		String result = null; 
		IUser user = RequestHelper.getInstance().getLoginUser();
		 if(user != null){
			 logger.info("当前操作用户已经登陆，拦截器不允许再出登陆,当前用户ID："+user.getUserId());
			 return "success";
		 }else{
			 result  = invocation.invoke();
		 }
		return result;
	}

}
