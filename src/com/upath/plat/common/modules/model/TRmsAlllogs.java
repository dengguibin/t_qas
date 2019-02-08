/**
*/
package	com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TRmsAlllogs.java   用户ID
* @Description: T_RMS_ALLLOGS   
* @author upaths@gmail.com  
* @date 2015-2-11 16:20:31
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TRmsAlllogs extends Pagination implements Serializable{ 	
	
	//用户ID @PrimaryKey
	private String logid;
	//会话ID值 
	private String sid;
	//登陆系统ID 
	private String platid;
	//工作计算机 
	private String worker;
	//计算机IP 
	private String workip;
	//计算机MAC 
	private String mac;
	//登陆帐号 
	private String account;
	//操作结果(1:为操作成功) 
	private Integer opresult;
	//异常描述 
	private String errors;
	//消息内容 
	private String contents;
	//最近登陆时间 
	private Date logtime;
	//访问IP 
	private String addr;
	//访问路径 
	private String url;
	//查询参数 
	private String params;
	//是否有效 
	private Integer sfyx;
	//日志处理状态(1为已经处理，2:为丢弃,0为未解释) 
	private Integer status;
	//创建时间 
	private Date cjsj;
	
	
	private Date xgsj;
	
	private String descr;
	
	private String menu;
	
	
	public Date getXgsj() {
		return xgsj;
	}

	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

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
	public void setWorker(String worker){
		this.worker = worker;
	}
  
	public String getWorker(){
		return this.worker;
	}
	public void setWorkip(String workip){
		this.workip = workip;
	}
  
	public String getWorkip(){
		return this.workip;
	}
	public void setMac(String mac){
		this.mac = mac;
	}
  
	public String getMac(){
		return this.mac;
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
	public void setErrors(String errors){
		this.errors = errors;
	}
  
	public String getErrors(){
		return this.errors;
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
	public void setStatus(Integer status){
		this.status = status;
	}
  
	public Integer getStatus(){
		return this.status;
	}
	public void setCjsj(Date cjsj){
		this.cjsj = cjsj;
	}
  
	public Date getCjsj(){
		return this.cjsj;
	}
}
