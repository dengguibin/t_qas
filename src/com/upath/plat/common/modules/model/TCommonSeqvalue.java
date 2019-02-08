/**
*/
package	com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
* 
* @ClassName: TCommonSeqvalue.java   序列号ID
* @Description: t_common_seqvalue   
* @author upaths@gmail.com  
* @date 2012-10-31 21:16:23
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TCommonSeqvalue extends Pagination implements Serializable{ 	
	
	//序列号ID @PrimaryKey
	private Integer seqid;
	//预警类型 @PrimaryKey
	private String seqtype;
	//应用ID 
	private String tid;
	//序列当前使用值 
	private Integer cvalue;
	//存取次数 
	private Integer nums;
	//回滚标识(实现ID回滚) 
	private Integer flag;
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
	public void setSeqtype(String seqtype){
		this.seqtype = seqtype;
	}
  
	public String getSeqtype(){
		return this.seqtype;
	}
	public void setTid(String tid){
		this.tid = tid;
	}
  
	public String getTid(){
		return this.tid;
	}
	public void setCvalue(Integer cvalue){
		this.cvalue = cvalue;
	}
  
	public Integer getCvalue(){
		return this.cvalue;
	}
	public void setNums(Integer nums){
		this.nums = nums;
	}
  
	public Integer getNums(){
		return this.nums;
	}
	public void setFlag(Integer flag){
		this.flag = flag;
	}
  
	public Integer getFlag(){
		return this.flag;
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
