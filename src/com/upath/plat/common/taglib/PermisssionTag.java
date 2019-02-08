package com.upath.plat.common.taglib;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import com.upath.plat.auth.facade.IFunction;
import com.upath.plat.auth.facade.IMenu;
import com.upath.plat.auth.facade.IPermissions;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.util.RequestHelper;
@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
public class PermisssionTag extends BaseTage{

	String menuId;
	
	//是否要严格验证访问路径权限
	/**
	 * 验证方法是通过用户拥有的菜单路径来进行匹配
	 */
	boolean verify = true;

	public boolean isVerify() {
		return verify;
	}

	public void setVerify(boolean verify) {
		this.verify = verify;
	}

	@SuppressWarnings("static-access")
	public int doEndTag() throws JspException {
		Map map = new HashMap();
		IUser user = RequestHelper.getInstance().getLoginUser();
		/**
		 * 在这里所有的实现不使用功能的点来进行权限的控制
		 * 如果需要实现那就需要改下面的计算方法
		 * 使用IFunction 的点来进行实现
		 * 
		 * 重写 这个方法  getPermissions
		 */
		if(this.menuId != null){
			if(user != null){
				List<IPermissions> ps =	user.getPermissions(menuId);
				if(ps != null && ps.isEmpty() == false){
					for(int i = 0 ; i < ps.size() ; i++){
						IPermissions p = ps.get(i);
						map.put(p.getId(), true);
					}
				}
			}
		}
		//如果是超级管理员则不进行验证
		if(verify == true && user.isAdmin() == false){
			String actionURI = RequestHelper.getInstance().getActionURI();
			if(actionURI != null && user != null){
				HttpServletRequest requst =  (HttpServletRequest) this.pageContext.getRequest();
				String content = requst.getContextPath();
				int index = actionURI.indexOf(content);
				if(index > -1){
					actionURI = actionURI.substring(index+content.length());
				}
				List<IMenu> menus = 	user.getMenus();
				boolean hasPermission = false;
				if(menus != null){
					for(int i = 0 ; i < menus.size() ; i++){
						IMenu menu = menus.get(i);
						String configUrl  = menu.getUrl();
						if(configUrl != null && configUrl.startsWith(actionURI) == true){
							hasPermission = true;
							break;
						}
					}
				}
				
				/**
				 * 进行功能验证
				 */
				if(hasPermission == false){
					List<IFunction> funcs = user.getFunctions();
					if(funcs != null){
						for(int i = 0 ; i < funcs.size() ; i++){
							IFunction func = funcs.get(i);
							String configUrl  = func.getUrl();
							if(configUrl != null && configUrl.startsWith(actionURI) == true){
								hasPermission = true;
								break;
							}
						}
					}
					
				}
				
				
				if(hasPermission == false){
					try {
						this.pageContext.getResponse().reset();
						requst.getRequestDispatcher("/pages/plat/common/error/403.jsp").forward(requst, this.pageContext.getResponse());
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		this.bindScopeData(this.var, map);
		return this.SKIP_BODY;
	}
	
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
}
