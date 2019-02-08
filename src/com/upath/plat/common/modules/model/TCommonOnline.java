/**
*/
package	com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TCommonOnline.java   主键
* @Description: t_common_online   
* @author upaths@gmail.com  
* @date 2012-11-28 22:24:13
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TCommonOnline extends Pagination implements Serializable{ 	
	
	//主键 @PrimaryKey
	private String tid;
	//会话ID 
	private String sessionid;
	//登陆时间 
	private Date logintime;
	//登出时间 
	private Date logouttime;
	//当前状况 
	private Integer status;
	//是否在线 
	private Integer online;
	//登陆人 
	private String userid;
	//客户端IP 
	private String cip;
	//创建时间 
	private Date cjsj;
	//创建人 
	private String cjr;
	//修改时间 
	private Date xgsj;
	//修改人 
	private String xgr;

	public void setTid(String tid){
		this.tid = tid;
	}
  
	public String getTid(){
		return this.tid;
	}
	public void setSessionid(String sessionid){
		this.sessionid = sessionid;
	}
  
	public String getSessionid(){
		return this.sessionid;
	}
	public void setLogintime(Date logintime){
		this.logintime = logintime;
	}
  
	public Date getLogintime(){
		return this.logintime;
	}
	public void setLogouttime(Date logouttime){
		this.logouttime = logouttime;
	}
  
	public Date getLogouttime(){
		return this.logouttime;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
  
	public Integer getStatus(){
		return this.status;
	}
	public void setOnline(Integer online){
		this.online = online;
	}
  
	public Integer getOnline(){
		return this.online;
	}
	public void setUserid(String userid){
		this.userid = userid;
	}
  
	public String getUserid(){
		return this.userid;
	}
	public void setCip(String cip){
		this.cip = cip;
	}
  
	public String getCip(){
		return this.cip;
	}
	public void setCjsj(Date cjsj){
		this.cjsj = cjsj;
	}
  
	public Date getCjsj(){
		return this.cjsj;
	}
	public void setCjr(String cjr){
		this.cjr = cjr;
	}
  
	public String getCjr(){
		return this.cjr;
	}
	public void setXgsj(Date xgsj){
		this.xgsj = xgsj;
	}
  
	public Date getXgsj(){
		return this.xgsj;
	}
	public void setXgr(String xgr){
		this.xgr = xgr;
	}
  
	public String getXgr(){
		return this.xgr;
	}
}
