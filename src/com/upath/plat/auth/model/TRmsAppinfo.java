/**
*/
package	com.upath.plat.auth.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
* 
* @ClassName: TRmsAppinfo.java   系统ID
* @Description: t_rms_appinfo   
* @author upaths@gmail.com  
* @date 2012-9-21 23:23:14
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TRmsAppinfo extends Pagination implements Serializable{ 	
	
	//系统ID @PrimaryKey
	private Integer appid;
	//组织ID 
	private String orgid;
	//系统描述 
	private String xtms;
	//系统默认首页 
	private String xtmrsy;
	//系统当前版本 
	private String xtdqbb;
	//开发维护人 
	private String kfwfr;
	//当前部署路径 
	private String dqbslj;
	//邮件联系方式 
	private String yjlxfs;
	//电话方式 
	private String dhfs;
	//创建时间 
	private Date cjsj;
	//创建人 
	private String cjr;
	//修改人
	private String xgr;
	// 修改时间 
	private Date xgsj;

	public void setAppid(Integer appid){
		this.appid = appid;
	}
  
	public Integer getAppid(){
		return this.appid;
	}
	public void setOrgid(String orgid){
		this.orgid = orgid;
	}
  
	public String getOrgid(){
		return this.orgid;
	}
	public void setXtms(String xtms){
		this.xtms = xtms;
	}
  
	public String getXtms(){
		return this.xtms;
	}
	public void setXtmrsy(String xtmrsy){
		this.xtmrsy = xtmrsy;
	}
  
	public String getXtmrsy(){
		return this.xtmrsy;
	}
	public void setXtdqbb(String xtdqbb){
		this.xtdqbb = xtdqbb;
	}
  
	public String getXtdqbb(){
		return this.xtdqbb;
	}
	public void setKfwfr(String kfwfr){
		this.kfwfr = kfwfr;
	}
  
	public String getKfwfr(){
		return this.kfwfr;
	}
	public void setDqbslj(String dqbslj){
		this.dqbslj = dqbslj;
	}
  
	public String getDqbslj(){
		return this.dqbslj;
	}
	public void setYjlxfs(String yjlxfs){
		this.yjlxfs = yjlxfs;
	}
  
	public String getYjlxfs(){
		return this.yjlxfs;
	}
	public void setDhfs(String dhfs){
		this.dhfs = dhfs;
	}
  
	public String getDhfs(){
		return this.dhfs;
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

	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	public Date getXgsj() {
		return xgsj;
	}

	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}
	
}
