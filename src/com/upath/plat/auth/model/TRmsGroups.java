/**
*/
package	com.upath.plat.auth.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TRmsGroups.java   用户组ID
* @Description: t_rms_groups   
* @author upaths@gmail.com  
* @date 2012-11-17 17:22:21
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TRmsGroups extends Pagination implements Serializable{ 	
	
	//用户组ID @PrimaryKey
	private Integer yhzid;
	//父用户组ID 
	private Integer fyhzid;
	//用户组名称 
	private String yhzmc;
	//用户组描述 
	private String yhzms;
	//组层级 
	private Integer zcj;
	//排序号 
	private Integer pxh;
	//用户组类型 
	private Integer yhzlx;
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

	public void setYhzid(Integer yhzid){
		this.yhzid = yhzid;
	}
  
	public Integer getYhzid(){
		return this.yhzid;
	}
	public void setFyhzid(Integer fyhzid){
		this.fyhzid = fyhzid;
	}
  
	public Integer getFyhzid(){
		return this.fyhzid;
	}
	public void setYhzmc(String yhzmc){
		this.yhzmc = yhzmc;
	}
  
	public String getYhzmc(){
		return this.yhzmc;
	}
	public void setYhzms(String yhzms){
		this.yhzms = yhzms;
	}
  
	public String getYhzms(){
		return this.yhzms;
	}
	public void setZcj(Integer zcj){
		this.zcj = zcj;
	}
  
	public Integer getZcj(){
		return this.zcj;
	}
	public void setPxh(Integer pxh){
		this.pxh = pxh;
	}
  
	public Integer getPxh(){
		return this.pxh;
	}
	public void setYhzlx(Integer yhzlx){
		this.yhzlx = yhzlx;
	}
  
	public Integer getYhzlx(){
		return this.yhzlx;
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
