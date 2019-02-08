/**
*/
package	com.upath.plat.auth.model;

import java.util.*;

/**
* 
* @ClassName: TRmsRole.java   角色ID
* @Description: t_rms_role   
* @author upaths@gmail.com  
* @date 2012-11-11 21:51:25
* @version V1.0   
*/
	
public class TRmsRole { 	
	
	//角色ID @PrimaryKey
	private Integer jsid;
	//角色名称 
	private String jsmc;
	//角色描述 
	private String jsms;
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

	public void setJsid(Integer jsid){
		this.jsid = jsid;
	}
  
	public Integer getJsid(){
		return this.jsid;
	}
	public void setJsmc(String jsmc){
		this.jsmc = jsmc;
	}
  
	public String getJsmc(){
		return this.jsmc;
	}
	public void setJsms(String jsms){
		this.jsms = jsms;
	}
  
	public String getJsms(){
		return this.jsms;
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
