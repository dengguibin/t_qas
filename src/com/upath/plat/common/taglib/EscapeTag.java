package com.upath.plat.common.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.util.HtmlUtils;

/** 
 * 描述: 对页面中的数据进行 解码使用，主要防止 XSS 脚本 
 * @author upaths@gmail.com
 * @version V1.0
 * @date {@link EscapeTag}
 * @see 
 */
@SuppressWarnings({ "serial"})
public class EscapeTag  extends TagSupport{

	//保存范围 pageScope requestScope  sessionScope applicationScope
	private String scope = "pageScope";
	
	//把结果放入 上下文当中 
	private String var;
	
	
	private Object value;
	
	//默认是进行解码械
	private boolean escape = true;
	
	

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@SuppressWarnings("static-access")
	public int doEndTag() throws JspException {
		if(value != null){
			String result = null;
			if(escape == true){
				result = 	HtmlUtils.htmlEscape(value.toString());
			}else{
				result = HtmlUtils.htmlUnescape(value.toString());
			}
			if(var == null){
				try {
					this.pageContext.getOut().print(result);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				this.builderScope(result, var);
			}
		}
		return this.SKIP_BODY;
	}

	void builderScope(Object datas,String variable){
		if("pageScope".equals(scope) == true){
			this.pageContext.setAttribute(variable, datas);
		}else if("requestScope".equals(scope) == true){
			this.pageContext.getRequest().setAttribute(variable, datas);
		}else if("sessionScope".equals(scope) == true){
			this.pageContext.getSession().setAttribute(variable, datas);
		}else if("applicationScope".equals(scope) == true) {
			this.pageContext.getServletContext().setAttribute(variable, datas);
		}
	}
	
	
	
	public int doStartTag() throws JspException {
		return super.doStartTag();
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

	public boolean isEscape() {
		return escape;
	}

	public void setEscape(boolean escape) {
		this.escape = escape;
	}

	
}
