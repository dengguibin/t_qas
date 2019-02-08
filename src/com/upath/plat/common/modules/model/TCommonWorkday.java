/**
*/
package	com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TCommonWorkday.java   主键
* @Description: T_COMMON_WORKDAY   
* @author upaths@gmail.com  
* @date 2013-3-22 14:36:13
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TCommonWorkday extends Pagination implements Serializable{ 	
	
	//主键 @PrimaryKey
	private String tid;
	//节假日列表 
	private String lists;
	//年月值 
	private Integer year;
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
	public void setLists(String lists){
		this.lists = lists;
	}
  
	public String getLists(){
		return this.lists;
	}
	public void setYear(Integer year){
		this.year = year;
	}
  
	public Integer getYear(){
		return this.year;
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
