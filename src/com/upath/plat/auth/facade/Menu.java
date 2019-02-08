package com.upath.plat.auth.facade;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.util.HtmlUtils;

import com.upath.plat.auth.model.TRmsMenuinfo;
import com.upath.plat.common.cache.AuthCacheManager;
@SuppressWarnings({ "rawtypes", "serial", "unchecked"})
public class Menu extends TRmsMenuinfo implements IMenu,Serializable,Cloneable {
	
	public Integer getDepth() {
		return this.getCdcj();
	}

	public Integer getType(){
		return getLjlx();
	}

	public Integer getMenuId(){
		return getCdid();
	}

	public String getMenuName() {
		return getCdmc();
	}

	public String getParams() {
		return getCdcs();
	}

	public Integer getPId() {
		return getPcdid();
	}

	/**
	 * 页面调用连接的时候会有特殊字条的转义字符，需要进行特殊处理。
	 */
	public String getUrl() {
		String dz = getLjdz();
		if(dz != null){
			dz = HtmlUtils.htmlUnescape(dz);
		}
		return dz;
	}

	public boolean isValid() {
		Integer valid = getSfyx();
		return (valid != null && valid == 1);
	}

	public IMenu getParent() {
		if(getPId() != null){
			return AuthCacheManager.getInstance().getMenu(getPId());
		}
		return null;
		
	}

	public boolean hasParent(){
		return getParent() != null;
	}
	
	public boolean hasChilden(){
		List<IMenu>  childen = getChildren();
		return childen != null && ( childen.isEmpty() == false);
	}
	
	public List<IMenu> getChildren() {
		return AuthCacheManager.getInstance().getChildenById(getMenuId());
	}

	/**
	 * 判定是否是某个指定菜单节点的子孙后代节点
	 */
	public boolean isDescendants(IMenu menu){
		boolean result = false;
		if(menu != null){
			IMenu parent = getParent();
			while(parent != null){
				Integer mid = 	parent.getMenuId();
				if(mid != null && mid.equals(menu.getMenuId()) ){
					result = true;
					break;
				}else{
					parent = parent.getParent();
				}
			}
		}
		return result;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		if(getParent() != null){
			buffer.append(getParent().toString());
			buffer.append(" > ");
		}
		buffer.append(getMenuName());
		return buffer.toString();
	}

	/**
	 * 是否往上追束上级的功能
	 */
	public List<IFunction> getFunctions(boolean include) {
		List funcs =  AuthCacheManager.getInstance().getFunctions(this);
		if(include == false || getParent() == null){
			return funcs;
		}else{
			if(getParent() != null){
				funcs.addAll(getParent().getFunctions(true));
			}
		}
		return funcs;
	}

}
