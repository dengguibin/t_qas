/**
*/
package	com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TCommonTemplate.java   主键
* @Description: T_COMMON_TEMPLATE   
* @author upaths@gmail.com  
* @date 2013-5-15 10:21:37
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TCommonTemplate extends Pagination implements Serializable{ 	
	
	//主键 @PrimaryKey
	private String tid;
	//模板 
	private String template;
	//父节点 
	private String pid;
	//模板类型 
	private Integer mblx;
	//扩展属性 
	private String kzss;
	//排序号 
	private Integer pxh;
	//是否有效 
	private Integer sfyx;
	//参数配置 
	private String params;
	//所属人 
	private String owner;
	//备注 
	private String marks;
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
	public void setTemplate(String template){
		this.template = template;
	}
  
	public String getTemplate(){
		return this.template;
	}
	public void setPid(String pid){
		this.pid = pid;
	}
  
	public String getPid(){
		return this.pid;
	}
	public void setMblx(Integer mblx){
		this.mblx = mblx;
	}
  
	public Integer getMblx(){
		return this.mblx;
	}
	public void setKzss(String kzss){
		this.kzss = kzss;
	}
  
	public String getKzss(){
		return this.kzss;
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
	public void setParams(String params){
		this.params = params;
	}
  
	public String getParams(){
		return this.params;
	}
	public void setOwner(String owner){
		this.owner = owner;
	}
  
	public String getOwner(){
		return this.owner;
	}
	public void setMarks(String marks){
		this.marks = marks;
	}
  
	public String getMarks(){
		return this.marks;
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
