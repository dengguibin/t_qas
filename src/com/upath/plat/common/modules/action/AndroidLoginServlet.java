package com.upath.plat.common.modules.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bingoohuang.patchca.utils.encoder.EncoderHelper;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.auth.model.TRmsDeptment;
import com.upath.plat.auth.model.TRmsUser;
import com.upath.plat.common.PlatConstant;
import com.upath.plat.common.PlatConstant.UserStatus;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.modules.model.TRmsLogininfo;
import com.upath.plat.common.modules.service.TRmsLogininfoService;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.common.util.RequestHelper;
import com.upath.plat.common.util.SystemConfig;

/**
 * 
 * @author upaths@gmail.com
 * @version V1.0
 * @date 2018-1-17 上午11:34:19
 * @see
 */
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class AndroidLoginServlet extends HttpServlet {
  
private static final long serialVersionUID = 2786413383877149469L;

static final String  LOGING_ERROR = "LOGING_ERROR";

private TRmsLogininfoService service;

private static final Logger logger = LoggerFactory.getLogger(AndroidLoginServlet.class);


public void init() throws ServletException {
	super.init();
	service = (TRmsLogininfoService) PlatUtil.getApplicationContext().getBean("tRmsLogininfoService");
}


private static Map systemInfo = null;

/**
 * 页面前台的配置信息
 */
	static{
		systemInfo = new HashMap();
		systemInfo.put("SYSTEM_BUILD_UNIT", SystemConfig.SYSTEM_BUILD_UNIT);
		systemInfo.put("SYSTEM_BUILD_UNIT_SITEINFO", SystemConfig.SYSTEM_BUILD_UNIT_SITEINFO);
		systemInfo.put("SYSTEM_TECHNICAL_SUPPORT", SystemConfig.SYSTEM_TECHNICAL_SUPPORT);
		systemInfo.put("SYSTEM_TECHNICAL_SUPPORT_SITEINFO", SystemConfig.SYSTEM_TECHNICAL_SUPPORT_SITEINFO);
	}


protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	//post请求
	doGet(request,response);
}



protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//把配置的信息输出到前台
		request.setAttribute("configs", systemInfo);
		Map result = new HashMap();
		//json对象处理，防止自包含
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		
		IUser eUser = RequestHelper.getInstance().getLoginUser();
		//返回到系统的首页
		if(eUser != null){
			//response.sendRedirect(request.getContextPath()+ passUrl);
			result.put("user", DismantlingInfo(eUser));
			result.put("status", "2");
			result.put("message", "您已登录，不需要重新登录!");
			
			response.setContentType("text/json; charset=UTF-8");
			JSONObject json = JSONObject.fromObject(result,jsonConfig);
			response.getWriter().print(json.toString());
			
			return;
		}
						
		 String userId = request.getParameter("userId");
		 String password = request.getParameter("password");
		 
		 	/**
			 * 不对空验证码进行验证
			 */
		 	/**
		 	 * 在此种情况 下面考虑到如果 黑客使用工具不断提交信息，如果详细记录信息将数据库会有被刷爆的可能
		 	 * 基于如果只是简单的认证情况不通过，系统不考虑记录此日志信息
		 	 * 
		 	 */
		 	boolean logStatus = true;		 	
			String msg = null;
			if(msg == null && userId == null){
				msg = "登陆帐号不能为空。";
				logStatus = false;
			}else if(msg == null && password == null){
				msg = "登陆密码不允许为空。";
				logStatus = false;
			}else if(isOpenDynaCode(request) == true && msg == null){
				request.getSession().removeAttribute(PlatConstant.SESSION_PATCHCA);
			}if(msg == null){
				IUser user = null;
				try{
					user = (IUser)service.queryObject("plat.selectUser", userId);
				}catch(PlatformException e){
					//数据库出现问题了。
					msg = "系统查找用户信息失败，请重试，如果出现重试不成功，请联系管理员。";
				}
				
				if(msg == null){
					if(user == null){
						msg = "系统中不存在此帐号【"+userId+"】的相关信息。";
					}else{
						String str = PlatUtil.encrypt(password);
						if(str.equals(user.getPassword()) == true){
							
							//用户是否有效
							if(user.isValid() == false){
								msg = "帐号已经被设置无效，请联系管理员";
							}else{
								if((user.getStatus()& UserStatus.STATUS_LOCKED.getStatus()) > 0){
									msg = "帐号已经被锁定，请联系管理员";
								}else if((user.getStatus()& UserStatus.STATUS_DISABLE.getStatus()) > 0){
									msg = "帐号已经被禁用，请联系管理员";
								}else{
									//移除会话里面的SESSION信息
									request.getSession().removeAttribute(PlatConstant.SESSION_PATCHCA);
									/**
									 * 解释会话标识未更新的漏洞
									 * 可能会窃取或操纵客户会话和 cookie，它们可能用于模仿合法用户，从而使黑客能够以该用户身份查
									  *看或变更用户记录以及执行事务
									 */
									request.getSession().invalidate();  
									if (request.getCookies() != null) {  
								         Cookie cookie = request.getCookies()[0];// 获取cookie  
								         cookie.setMaxAge(0);// 让cookie过期  
								    } 
									/**
									 * 生成一个新的会话ID,防止用户指定SessionId来控制。
									 */
									HttpSession session = request.getSession(true);
									request.getSession().setAttribute(PlatConstant.SESSION_USER, user);
									result.put("user", DismantlingInfo(user));
								}
							}
						}else{
							msg = "请确认您输入的密码的正确性。";
						}
					}
				}
			
			}
			//初始化信息
			
			
			TRmsLogininfo logBean =  getInitLogBean(request);
			logBean.setAccount(userId);
			if(msg != null){
				//request.setAttribute("msg", msg);
				//登陆失败
				result.put("status", "0");
				result.put("message", msg);
				logBean.setOpresult(0);
				logBean.setContents(msg);
				//request.getRequestDispatcher(authUrl).forward(request, response);
				
			}else{
				IUser user = RequestHelper.getInstance().getLoginUser();
				user.setLogId(logBean.getLogid());
				logBean.setOpresult(1);
				logBean.setContents("登陆成功");
				//登陆成功
				result.put("status", "1");
				result.put("message", "登陆成功");
				//response.sendRedirect(request.getContextPath()+ passUrl);
			}
			
			if(logStatus == true){
				try{
					service.insert(logBean);
				}catch(Exception e){
					logger.error(e.getMessage());
					e.printStackTrace();
				}
			}
			
			response.setContentType("text/json; charset=UTF-8");
			JSONObject json = JSONObject.fromObject(result,jsonConfig);
			response.getWriter().print(json.toString());
			
	
}


	//在系统设计 的时候当用户登陆 N 次不成功后，将启用验证码的功能来防止暴力破解。
	protected boolean isOpenDynaCode(HttpServletRequest request){
		boolean open = false;
		Object  dynaCode =  request.getSession().getAttribute(PlatConstant.SESSION_PATCHCA);
		if(dynaCode != null){
			open = true;
		}else{
			//帐号信息
			 String userId = request.getParameter("userId");
			 //远程 访问IP地址
			 String remoteAdd = RequestHelper.getInstance().getRemoteAddr();
			 //会话ID
			 String sessionId = request.getSession(false).getId();
			 TRmsLogininfo bean = new TRmsLogininfo();
			 bean.setAddr(remoteAdd);
			 bean.setSid(sessionId);
			 bean.setAccount(userId);
			 Calendar cal = Calendar.getInstance();
			 //默认三分钟内如果重复登陆失败将会产生 验证码的功能
			 cal.add(Calendar.MINUTE, -3);
			 bean.setLogtime(cal.getTime());
			 int nums = service.queryLogCountByAddr(bean);
			 if(nums >= 3){
				 open = true;
			 }
		}
	return open;
}
	
	
	protected TRmsLogininfo getInitLogBean(HttpServletRequest request){
		 String sessionId = request.getSession(false).getId();
		 TRmsLogininfo bean = new TRmsLogininfo();
		 bean.setSid(sessionId);
		 bean.setAddr(RequestHelper.getInstance().getRemoteAddr());
		 bean.setLogtime(new Date());
		 bean.setPlatid(SystemConfig.SYSTEM_ID);
		 String url = request.getRequestURL().toString();
		 bean.setUrl(url);
		 bean.setCjsj(new Date());
		 bean.setLogid(IDGenerator.getDateId());
		 return bean;
		
	}
	
	protected TRmsUser DismantlingInfo(IUser iuser){
		//用户信息
		TRmsUser user = new TRmsUser();
		user.setYhid(iuser.getUserId());
		user.setYhmc(iuser.getUserName());
		user.setBmid(iuser.getDepartId());
		user.setYhmm(iuser.getPassword());
		return user;
	}


	public void destroy() {
		super.destroy();
		logger.info("应用服务器正在尝试关闭！");
	}
			
}
