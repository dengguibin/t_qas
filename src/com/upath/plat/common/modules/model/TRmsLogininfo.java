/**
*/
package	com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TRmsLogininfo.java   用户ID
* @Description: T_RMS_LOGININFO   
* @author upaths@gmail.com  
* @date 2015-2-9 15:07:41
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TRmsLogininfo extends Pagination implements Serializable{ 	
	
	//用户ID @PrimaryKey
	private String logid;
	//会话ID值 
	private String sid;
	//登陆系统ID 
	private String platid;
	//登陆帐号 
	private String account;
	//操作结果(1:为操作成功) 
	private Integer opresult;
	//消息内容 
	private String contents;
	//最近登陆时间 
	private Date logtime;
	//登陆IP 
	private String addr;
	//登陆次数 
	private Integer nums;
	//访问路径 
	private String url;
	//日志备注(参数) 
	private String params;
	//是否有效 
	private Integer sfyx;
	//创建时间 
	private Date cjsj;

	private Date outtime;
	
	
	//查询开始时间
		private String startTime;
		
		//查询结束时间
		private String endTime;
		
		

		public String getStartTime() {
			return startTime;
		}

		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}

		public String getEndTime() {
			return endTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
	
	private Integer outstate;
	
	
	public Date getOuttime() {
		return outtime;
	}

	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}

	public Integer getOutstate() {
		return outstate;
	}

	public void setOutstate(Integer outstate) {
		this.outstate = outstate;
	}

	public void setLogid(String logid){
		this.logid = logid;
	}
  
	public String getLogid(){
		return this.logid;
	}
	public void setSid(String sid){
		this.sid = sid;
	}
  
	public String getSid(){
		return this.sid;
	}
	public void setPlatid(String platid){
		this.platid = platid;
	}
  
	public String getPlatid(){
		return this.platid;
	}
	public void setAccount(String account){
		this.account = account;
	}
  
	public String getAccount(){
		return this.account;
	}
	public void setOpresult(Integer opresult){
		this.opresult = opresult;
	}
  
	public Integer getOpresult(){
		return this.opresult;
	}
	public void setContents(String contents){
		this.contents = contents;
	}
  
	public String getContents(){
		return this.contents;
	}
	public void setLogtime(Date logtime){
		this.logtime = logtime;
	}
  
	public Date getLogtime(){
		return this.logtime;
	}
	public void setAddr(String addr){
		this.addr = addr;
	}
  
	public String getAddr(){
		return this.addr;
	}
	public void setNums(Integer nums){
		this.nums = nums;
	}
  
	public Integer getNums(){
		return this.nums;
	}
	public void setUrl(String url){
		this.url = url;
	}
  
	public String getUrl(){
		return this.url;
	}
	public void setParams(String params){
		this.params = params;
	}
  
	public String getParams(){
		return this.params;
	}
	public void setSfyx(Integer sfyx){
		this.sfyx = sfyx;
	}
  
	public Integer getSfyx(){
		return this.sfyx;
	}
	public void setCjsj(Date cjsj){
		this.cjsj = cjsj;
	}
  
	public Date getCjsj(){
		return this.cjsj;
	}
}
