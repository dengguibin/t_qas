/**
*/
package	com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.cache.ICacheCode;
import com.upath.plat.common.page.Pagination;

/**
* 
* @ClassName: TCommonSubkeys.java   字典键值
* @Description: t_common_subkeys   
* @author upaths@gmail.com  
* @date 2012-10-28 20:29:26
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TCommonSubkeys  extends Pagination implements ICacheCode,Serializable { 	
	
	//字典键值 @PrimaryKey
	private String code;
	//代码子键 @PrimaryKey
	private String subcode;
	//子键ID 
	private String tid;
	//代码名称 
	private String cname;
	//是否有效、1 有效 
	private Integer valid;
	//排序号 
	private Integer seq;
	//参数1、扩展配置 
	private String params1;
	//参数2、扩展配置 
	private String params2;
	//备注说明 
	private String des;
	//创建时间 
	private Date cjsj;
	//创建人 
	private String cjr;
	//修改人
	private String xgr;
	// 修改时间 
	private Date xgsj;

	public void setCode(String code){
		this.code = code;
	}
  
	public String getCode(){
		return this.code;
	}
	public void setSubcode(String subcode){
		this.subcode = subcode;
	}
  
	public String getSubcode(){
		return this.subcode;
	}
	public void setTid(String tid){
		this.tid = tid;
	}
  
	public String getTid(){
		return this.tid;
	}
	public void setCname(String cname){
		this.cname = cname;
	}
  
	public String getCname(){
		return this.cname;
	}
	public void setValid(Integer valid){
		this.valid = valid;
	}
  
	public Integer getValid(){
		return this.valid;
	}
	public void setSeq(Integer seq){
		this.seq = seq;
	}
  
	public Integer getSeq(){
		return this.seq;
	}
	public void setParams1(String params1){
		this.params1 = params1;
	}
  
	public String getParams1(){
		return this.params1;
	}
	public void setParams2(String params2){
		this.params2 = params2;
	}
  
	public String getParams2(){
		return this.params2;
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
