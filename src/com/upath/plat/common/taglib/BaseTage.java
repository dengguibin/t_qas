package com.upath.plat.common.taglib;

import javax.servlet.jsp.tagext.TagSupport;


/**
 * @author upaths
 * version 1.0.0
 * create date :2012-9-22 
 * modify time
 */
@SuppressWarnings("serial")
public class BaseTage extends TagSupport{
	
	public static final String pageScope = "pageScope";
	public static final String requestScope = "requestScope";
	public static final String sessionScope = "sessionScope";
	public static final String applicationScope = "applicationScope";
	
	//保存范围 pageScope requestScope  sessionScope applicationScope
	protected String scope = "pageScope";
	
	//把结果放入 上下文当中 
	protected String var;

	
	/**
	 * 绑定数据值到当前的scope 上下文范围当中
	 * @param variable
	 * @param datas
	 */
   protected void bindScopeData(String variable,Object datas){
		if(pageScope.equals(scope) == true){
			this.pageContext.setAttribute(variable, datas);
		}else if(requestScope.equals(scope) == true){
			this.pageContext.getRequest().setAttribute(variable, datas);
		}else if(sessionScope.equals(scope) == true){
			this.pageContext.getSession().setAttribute(variable, datas);
		}else if(applicationScope.equals(scope) == true) {
			this.pageContext.getServletContext().setAttribute(variable, datas);
		}
	}
	
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

}
