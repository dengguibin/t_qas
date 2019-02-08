package com.upath.plat.common.util;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.PlatConstant;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.page.Ipage;

/**
 * 
 * @author upaths version 1.0.0 create date :2012-9-29 upath plat call
 *         116856645.com modify time
 */
@SuppressWarnings({ "rawtypes"})
public class RequestHelper {

	private static final Logger logger = Logger.getLogger(RequestHelper.class);

	private HttpServletRequest request = null;
	/**
	 * 请求参数
	 */
	private Map parameterMap = null;


	public static RequestHelper getInstance() {
		RequestHelper reqHelper = null;
		//如果考虑更好，最好是使用 ThreadLocal来实现此数据的绑定，保证不受到框架的限制
		reqHelper = (RequestHelper) ServletActionContext.getContext().get(PlatConstant.VAR__REQUESTHELPER);
		if (reqHelper != null) {
			return reqHelper;
		}
		HttpServletRequest req = ServletActionContext.getRequest();
		if (req == null ) {
			logger.error("ReuestHelper必须在请求上下文环境存在中进行使用。");
			throw new PlatformException("ReuestHelper必须在请求上下文环境存在中进行使用。");
		} else {
			reqHelper = new RequestHelper(req);
			ServletActionContext.getContext().put(PlatConstant.VAR__REQUESTHELPER, reqHelper);
		}
		return reqHelper;
	}

	RequestHelper(HttpServletRequest request) {
		this.request = request;
		this.parameterMap = this.request.getParameterMap();
		if (this.parameterMap == null) {
			this.parameterMap = Collections.EMPTY_MAP;
		}
	}

	public HttpServletRequest getReuest() {
		return request;
	}

	/**
	 * 当前提交页面中的分页信息
	 * 
	 * @return
	 */
	public Ipage getCurrentPagination() {
		Ipage ipage = null;
		if (ActionContext.getContext() != null) {
			Map params = ActionContext.getContext().getParameters();
			if (params != null) {
				Object obj = params.get(PlatConstant.VAR_PAGINATION);
				if (obj != null) {
					ipage = (Ipage) obj;
				}
			}
		} else {
			logger.error("调用此方法必须在请求上下文环境中使用。");
		}
		return ipage;
	}
	
	
	/**
	 * 当前提交页面中的访问的ACTION访问路径
	 * 
	 * @return
	 */
	public String getActionURI() {
		String result = null;
		if (ActionContext.getContext() != null) {
			Map params = ActionContext.getContext().getParameters();
			if (params != null) {
				Object obj = params.get(PlatConstant.VAR_REQUEST_ACTION_URI);
				if (obj != null) {
					result = obj.toString();
				}
			}
		} else {
			logger.error("调用此方法必须在请求上下文环境中使用。");
		}
		return result;
	}
	
	/**
	 * 当前提交页面中的访问的ACTION访问的类名
	 * @return
	 */
	public String getActionClassName() {
		String result = null;
		if (ActionContext.getContext() != null) {
			Object obj = ActionContext.getContext().get(ActionContext.ACTION_INVOCATION);
			if(obj != null){
				if(obj instanceof ActionInvocation){
					ActionInvocation actx = (ActionInvocation)obj;
					result = actx.getAction().getClass().getName();
				}
			}
		} else {
			logger.error("调用此方法必须在请求上下文环境中使用。");
		}
		return result;
	}
	
	
	
	//出现代理的情况下面使用此该来来获取，用户的实际IP，而非代理IP
	public String getRemoteAddr(){
		return getRemoteAddr(request);
	}
	
	public static String getRemoteAddr(HttpServletRequest request){
		String ip = request.getRemoteAddr();
		//使用代理的IP地址
		 if(request.getHeader("x-forwarded-for") != null){
			 ip = request.getRemoteAddr();
		 }
		return ip;
	}

	/**
	 * @return 会话中登陆的用户
	 */
	public IUser getLoginUser() {
		IUser user = null;
		if (request != null) {
			Object obj = request.getSession().getAttribute(
					PlatConstant.SESSION_USER);
			if (obj != null && obj instanceof IUser) {
				user = (IUser) obj;
			}
		}
		return user;
	}

	public WebApplicationContext getSpringContext() {
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
		return ctx;
	}

	public String getStr(String key, String _default) {
		Object obj = parameterMap.get(key);
		if (obj == null) {
			return _default;
		} else {
			return obj.toString();
		}
	}

	public int getInt(String key, int _default) {
		String value = getStr(key, null);
		if (value == null) {
			return _default;
		} else {
			return Integer.valueOf(value);
		}
	}

	public long getLong(String key, long _default) {
		String value = getStr(key, null);
		if (value == null) {
			return _default;
		} else {
			return Long.valueOf(value);
		}
	}
	
	public float getLong(String key, float _default) {
		String value = getStr(key, null);
		if (value == null) {
			return _default;
		} else {
			return Float.valueOf(value);
		}
	}
	
	/**
	 * @param key
	 * @param fmt
	 * @return
	 */
	public Date getDate(String key,String fmt){
		String value = getStr(key, null);
			if(value == null){
				return null;
			}else{
				return null;
			}
	}

	
	public String getReqStr(String key, String _default) {
		Object obj = request.getAttribute(key);
		if (obj == null) {
			return _default;
		} else {
			return obj.toString();
		}
	}

	public int getReqInt(String key, int _default) {
		String value = getReqStr(key, null);
		if (value == null) {
			return _default;
		} else {
			return Integer.valueOf(value);
		}
	}

	public long getReqLong(String key, long _default) {
		String value = getReqStr(key, null);
		if (value == null) {
			return _default;
		} else {
			return Long.valueOf(value);
		}
	}
	
	public float getReqLong(String key, float _default) {
		String value = getReqStr(key, null);
		if (value == null) {
			return _default;
		} else {
			return Float.valueOf(value);
		}
	}
	
}
