package com.upath.plat.common.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.PlatConstant;
import com.upath.plat.common.service.ICommonService;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.common.util.StringUtil;
@SuppressWarnings({ "unchecked", "unused" })
public class SystemFilter implements Filter {

	private final static Logger logger = Logger.getLogger(SystemFilter.class);
	
	private  static Set<String> excludeURL = Collections.EMPTY_SET;
	
	private final static String COMMA = ",";
	

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		//获取请求头信息，用以区分pc端请求和移动端请求
		String userAgent = request.getHeader("user-agent");
		
		String ctx = request.getContextPath();
		String uri = request.getRequestURI();
		
		//进行 防 XSS 跨站攻击 处理。
		req = new XssRequestWrapper((HttpServletRequest)req);
		
			 uri = uri.substring(ctx.length(), uri.length());
			 if(acceptURI(uri) == false && "/".equals(uri) == false){
				 	IUser opreator =  (IUser)request.getSession().getAttribute(PlatConstant.SESSION_USER);
				 	/**
				 	 * 进行系统对接的时候需要使用传递参数来进行管理会话状态
				 	 * 
				 	 * 在系统调用 工作流的时候初次使用传递参数来实现会话的共享
				 	 */
//以下的代码为 当时系统 在广州MIS系统中对接工作流平台中需要走一个后门，直接进行用户登陆				 	
//				 		String userId = request.getParameter("_userid");
//				 		if(userId != null && "".equals(userId) == false){
//				 			boolean load = true;
//				 			if(opreator != null){
//				 				if(userId.equals(opreator.getUserId()) == false){
//				 					//重新加载会话ID
//				 					load = true;
//				 				}else{
//				 					load = false;
//				 				}
//				 			}
//				 			if(load == true){
//				 				 ICommonService service = (ICommonService) PlatUtil.getApplicationContext().getBean("commonService");
//				 				 IUser user = (IUser)service.queryObject("plat.selectUser", userId);
//				 				 //系统无法找到对应的ID
//				 				 if(user == null){
//				 					response.sendRedirect(ctx);
//				 				 }else{
//				 					request.getSession().setAttribute(PlatConstant.SESSION_USER, user);
//				 					//放入到请求上下文环境当中进行使用此参数
//				 					req.setAttribute(PlatConstant.REQEUST_USER, user);
//				 					chain.doFilter(req, res);
//				 				 }
//				 				
//				 			}else{
//				 				//放入到请求上下文环境当中进行使用此参数
//			 					req.setAttribute(PlatConstant.REQEUST_USER, opreator);
//				 				chain.doFilter(req, res);
//				 				
//				 			}
//				 		}
//				 		
				 		if(opreator != null){
			 				//放入到请求上下文环境当中进行使用此参数
		 					req.setAttribute(PlatConstant.REQEUST_USER, opreator);
				 			chain.doFilter(req, res);
				 		}else{
				 			//如果请求头带有移动端的信息，返回json信息
				 			if(userAgent.indexOf("Android") != -1 || userAgent.indexOf("iPhone") != -1 || userAgent.indexOf("iPad") != -1){
				 				Map<String,Object> result = new HashMap<String,Object>();
				 				result.put("status", "-1");
				 				result.put("msg", "当前链接已失效，请重新登录！");
				 				result.put("data", null);
				 				
				 				response.setContentType("text/json; charset=UTF-8");
				 				JSONObject json = JSONObject.fromObject(result);
				 				response.getWriter().print(json.toString());
				 			}else{
				 				response.sendRedirect(ctx);
				 			}
				 			
				 			return;
				 		}
				 		
			 }else{
//				 IUser opreator =  (IUser)request.getSession().getAttribute(PlatConstant.SESSION_USER);
//				 	//放入到请求上下文环境当中进行使用此参数
//				 	if(opreator != null){
//				 		req.setAttribute(PlatConstant.REQEUST_USER, opreator);
//				 	}
					/**
					 * 如果是过滤页面的情况下面
					 * 上下文环境中的 用户信息不放入到请求上下文环境当中。
					 * 为了避免一些 容易引起误会的 操作 ，确保在这种讲求中是不会存在 用户信息的。
					 * 程序人员在编写的时候会去找这些错误的所在。
					 */
				 chain.doFilter(req, res);
			 }
	}
	
	
	public boolean acceptURI(String uri){
		boolean result = false;
		for(String config : excludeURL){
				if(config.equals(uri) || uri.startsWith(config)){
					result = true;
					break;
				}
		}
		return result;
	}

	public void init(FilterConfig config) throws ServletException {
			String urls = config.getInitParameter("excludeURL");
			logger.info("需要忽略的访问配置："+urls);
			if(StringUtil.isEmpty(urls) == false){
				String arr[] = urls.split(COMMA);
				excludeURL = new HashSet<String>();
					if(arr != null){
							for(int i = 0 ; i < arr.length ; i++){
								excludeURL.add(arr[i]);
							}
					}
			}
	}
	
	public void destroy() {
		
	}

}
