/**
*/
package	com.upath.plat.auth.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
* 
* @ClassName: TRmsPermissionsinfo.java   权限ID
* @Description: t_rms_permissionsinfo   
* @author upaths@gmail.com  
* @date 2012-11-11 21:51:25
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TRmsPermissionsinfo extends Pagination implements Serializable{ 	
	
	//权限ID @PrimaryKey
	private String qxid;
	//权限名称 
	private String qxmc;
	//权限描述 
	private String qxms;
	//排序号 
	private Integer pxh;
	//是否有效 
	private Integer sfyx;
	//创建时间 
	private Date cjsj;
	//创建人 
	private String cjr;
	//修改时间 
	private Date xgsj;
	//修改人 
	private String xgr;


	public String getQxid() {
		return qxid;
	}

	public void setQxid(String qxid) {
		this.qxid = qxid;
	}

	public void setQxmc(String qxmc){
		this.qxmc = qxmc;
	}
  
	public String getQxmc(){
		return this.qxmc;
	}
	public void setQxms(String qxms){
		this.qxms = qxms;
	}
  
	public String getQxms(){
		return this.qxms;
	}
	public void setPxh(Integer pxh){
		this.pxh = pxh;
	}
  
	public Integer getPxh(){
		return this.pxh;
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
