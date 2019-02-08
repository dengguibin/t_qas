package com.upath.plat.common.filter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.upath.plat.common.PlatConstant;
import com.upath.plat.common.page.IPagination;
import com.upath.plat.common.page.Ipage;
import com.upath.plat.common.page.Page;

/**
 * @author upaths
 * version 1.0.0
 * create date :2012-11-9 
 * modify time
 */
@SuppressWarnings({ "rawtypes", "serial", "unchecked", "unused" })
public class WebActionInterceptor  extends AbstractInterceptor{

	private final static Logger logger = Logger.getLogger(WebActionInterceptor.class);
	
	public String intercept(ActionInvocation ctx) throws Exception {
			Map params = ctx.getInvocationContext().getParameters();
			if(params != null){
				String[]  obj = 	(String[])params.get("pagination");
					if(obj != null && obj.length >0){
						Ipage page = new Page(obj[0]);
						Object action =	ctx.getAction();
						if(action instanceof IPagination){
							IPagination iPagination = (IPagination)action;
								iPagination.setPage(page);
						}
						params.put(PlatConstant.VAR_PAGINATION, page);
					}
			}
			HttpServletRequest request = 	(HttpServletRequest) ctx.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
			if(request != null){
				String uri = request.getRequestURI();
				params.put(PlatConstant.VAR_REQUEST_ACTION_URI, uri);
				if(ctx.getAction() != null){
					request.setAttribute(PlatConstant.VAR_REQUEST_ACTION_NAME, ctx.getAction().getClass().getName());
				}
			}
		return ctx.invoke();
	}

}
