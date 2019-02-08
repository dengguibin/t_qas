/**
*/
package	com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
* 
* @ClassName: TCommonSeq.java   序列号ID
* @Description: t_common_seq   
* @author upaths@gmail.com  
* @date 2012-10-31 21:16:23
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TCommonSeq extends Pagination implements Serializable{ 	
	
	//序列号ID @PrimaryKey
	private Integer seqid;
	//序列名称 
	private String name;
	//序列所有者 
	private String owners;
	//最小值 
	private Integer minval;
	//最大值 
	private Integer maxval;
	//开始位置 
	private Integer spos;
	//步长 
	private Integer steps;
	//备注说明 
	private String des;
	//创建时间 
	private Date cjsj;
	//创建人 
	private String cjr;
	//修改时间 
	private Date xgsj;
	//修改人 
	private String xgr;

	public void setSeqid(Integer seqid){
		this.seqid = seqid;
	}
  
	public Integer getSeqid(){
		return this.seqid;
	}
	public void setName(String name){
		this.name = name;
	}
  
	public String getName(){
		return this.name;
	}
	public void setOwners(String owners){
		this.owners = owners;
	}
  
	public String getOwners(){
		return this.owners;
	}
	public void setMinval(Integer minval){
		this.minval = minval;
	}
  
	public Integer getMinval(){
		return this.minval;
	}
	public void setMaxval(Integer maxval){
		this.maxval = maxval;
	}
  
	public Integer getMaxval(){
		return this.maxval;
	}
	public void setSpos(Integer spos){
		this.spos = spos;
	}
  
	public Integer getSpos(){
		return this.spos;
	}
	public void setSteps(Integer steps){
		this.steps = steps;
	}
  
	public Integer getSteps(){
		return this.steps;
	}
	public void setDes(String des){
		this.des = des;
	}
  
	public String getDes(){
		return this.des;
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
