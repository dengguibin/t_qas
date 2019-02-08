package com.upath.plat.common.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import com.upath.plat.auth.facade.IMenu;
import com.upath.plat.common.cache.AuthCacheManager;
@SuppressWarnings({ "serial" })
public class MenuCacheTag extends BaseTage{
	
	
	//字典主科目
	//保存范围 pageScope requestScope  sessionScope applicationScope
	private String scope = "pageScope";
	
	private Integer menuId;
	
	//把结果放入 上下文当中 
	private String var;

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
	
	@SuppressWarnings("static-access")
	public int doEndTag() throws JspException {
			IMenu menu = AuthCacheManager.getInstance().getMenu(menuId);
				if(menu != null){
					if(var != null){
						bindScopeData(var, menu);
					}else{
						try {
							this.pageContext.getOut().print(menu);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
				}
		return this.SKIP_BODY;
	}
	
}
