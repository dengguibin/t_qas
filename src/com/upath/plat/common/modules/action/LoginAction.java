package com.upath.plat.common.modules.action;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.bingoohuang.patchca.utils.encoder.EncoderHelper;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.auth.model.TRmsUser;
import com.upath.plat.auth.service.TRmsUserService;
import com.upath.plat.common.PlatConstant;
import com.upath.plat.common.PlatConstant.UserStatus;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.service.ICommonService;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.common.util.RequestHelper;


/**
 * @author upaths
 * version 1.0.0
 * create date :2012-11-6 
 * modify time
 */
@Scope("prototype")
@Component("loginAction")
@SuppressWarnings({ "serial","unused" })
public class LoginAction extends BaseActionSupport{

	private static final Logger log = Logger.getLogger(LoginAction.class);
	
	private static final CaptchaConfig cs = new CaptchaConfig();
	
	private String userId;
	
	private String password;
	
	private String newPassword[];

	private String code;
	
	private ICommonService service;
	//初始化状态
	private String initStatus ;

	

	public String authenticate()throws PlatformException{
		/**
		 * 不对空验证码进行验证
		 */
		String msg = null;
		if(msg == null && userId == null){
			msg = "登陆帐号不能为空。";
		}else if(msg == null && password == null){
			msg = "登陆密码不允许为空。";
		}else if(code != null && msg == null){
			Object obj = request.getSession().getAttribute(PlatConstant.SESSION_PATCHCA);
			if(code.equalsIgnoreCase(obj+"") == false){
			msg = "验证码输入不正确";
			}
		}if(msg == null){
			IUser user = (IUser)service.queryObject("plat.selectUser", userId);
		
			if(user == null){
				msg = "系统中不存在此帐号【"+userId+"】的相关信息。";
			}else{
				String str = PlatUtil.encrypt(password);
				if(str.equals(user.getPassword()) == true){
					//移除会话里面的SESSION信息
					request.getSession().removeAttribute(PlatConstant.SESSION_PATCHCA);
					request.getSession().setAttribute(PlatConstant.SESSION_USER, user);
				}else{
					msg = "请确认您输入的密码的正确性。";
				}
			}
		}
		
	 
		if(msg != null){
			request.setAttribute("msg", msg);
			return login();
		}else{
			return SUCCESS;
		}
		
	}
	
	public String login() throws PlatformException{
		password = null;
		code = null;
		return "login";
	}
	
	/**
	 * 心跳检测，每个用户进行主操作界面后应该调用此接口来进行检测
	 * @return
	 * @throws PlatformException
	 */
	public String signal() throws PlatformException{
		String succuss = "{status:1}";
		String failed = "{status:0}";
		IUser user = 	getLoginUser();
		try{
			if(user != null){
				response.getWriter().print(succuss);
			}else{
				response.getWriter().print(failed);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	} 
	
	
	public String logout() throws PlatformException{
		try {
			 IUser user = 	RequestHelper.getInstance().getLoginUser();
			 //标识用户为正常退出状态
			 user.setLogOutState("1");
			 request.getSession().invalidate();
		} catch (Exception e) {
			log.error(e);
		}
		return SUCCESS;
	}
	
	
	public String toModifyPassword() throws PlatformException{
		try {
			IUser user = getLoginUser();
			if((user.getStatus() & UserStatus.STATUS_INIT.getStatus()) > 0){
				initStatus = user.getStatus()+"";
			}
		} catch (Exception e) {
			log.error(e);
		}
		return SUCCESS;
	}
	
	
	public String savePassword() throws PlatformException{
		try {
			if(password == null){
				this.addFieldError("password", "现在使用密码不能为空");
			}
			
			if(code == null){
				this.addFieldError("code", "验证码不允许为空");
			}else{
				Object obj = request.getSession().getAttribute(PlatConstant.SESSION_PATCHCA);
				if(code.equalsIgnoreCase(obj+"") == false){
					String msg = "验证码输入不正确";
					this.addFieldError("code", msg);
				}
			}
		
			
			if(this.newPassword == null){
				this.addFieldError("newPassword", "新设置的密码不能为空");
			}else{
				if(this.newPassword.length != 2 || !this.newPassword[0].equals(this.newPassword[1])){
					this.addFieldError("newPassword", "新设置的密码和确认的密码不一致");
				}
			}
			
			
			
			if(this.getFieldErrors() == null || this.getFieldErrors().size() == 0){
				IUser user = null;
				if(this.userId != null){
					user = (IUser)service.queryObject("plat.selectUser", userId);
				}else{
					user = getLoginUser();
				}
				if(user != null){
					String str = PlatUtil.encrypt(password);
					if(str.equals(user.getPassword()) == true){
						String newWord = PlatUtil.encrypt(newPassword[0]);
						TRmsUserService service =(TRmsUserService)PlatUtil.getApplicationContext().getBean("tRmsUserService");
						user.setPassword(newWord);
						int style = user.getStatus();
						//取消点状态
						style &= ~UserStatus.STATUS_INIT.getStatus();
						TRmsUser rmsUser = (TRmsUser)user;
						rmsUser.setYhzt(style);
						service.updateStatus(rmsUser);
						//更新当前用户的状态信息
						IUser loginUser = getLoginUser();
						rmsUser = (TRmsUser)loginUser;
						rmsUser.setYhzt(style);
					}else{
						this.addFieldError("password", "现在使用的密码信息不正确");
					}
				}else{
					this.addFieldError("userId", "帐号信息不存在");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		if(this.getFieldErrors() == null || this.getFieldErrors().size() == 0){
			
			if(initStatus == null){
				return FORWARD_SAVEOK;
			}else{
				//进行主入口程序
				return "toMain";
			}
			
			
		}else{
			return SUCCESS;
			
		}
		
	}
	
	
	
	
	/**
	 * 
	 * @return 验证码的生成调用 
	 * @throws IOException
	 */
	public String code() throws IOException {
		response.setContentType("image/png");
		response.setHeader("cache", "no-cache");
		HttpSession session = request.getSession(true);
			OutputStream os = response.getOutputStream();
			response.reset();
			String patchca= EncoderHelper.getChallangeAndWriteImage(new CaptchaConfig(), "png", os);
			session.setAttribute(PlatConstant.SESSION_PATCHCA, patchca);
			os.flush();
			os.close();
		return null;
	}
	
	

	public String getInitStatus() {
		return initStatus;
	}

	public void setInitStatus(String initStatus) {
		this.initStatus = initStatus;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

	public String[] getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String[] newPassword) {
		this.newPassword = newPassword;
	}


	@Autowired
	@Qualifier("commonService")
	public void setService(ICommonService service) {
		this.service = service;
	}
	
}
