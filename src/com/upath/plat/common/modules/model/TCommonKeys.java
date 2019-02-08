/**
*/
package	com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.Date;

import com.upath.plat.common.page.Pagination;

/**
* 
* @ClassName: TCommonKeys.java   字典键值
* @Description: t_common_keys   
* @author upaths@gmail.com  
* @date 2012-10-25 22:01:03
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TCommonKeys  extends Pagination implements Serializable { 	
	
	//字典键值 @PrimaryKey
	private String code;
	//字典键值 
	private String pcode;
	//字典名称 
	private String cname;
	//是否有效 
	private Integer valid;
	//子键表参数1名称 
	private String pname1;
	//子键表参数2名称 
	private String pname2;
	//排序号 
	private Integer seq;
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
	public void setPcode(String pcode){
		this.pcode = pcode;
	}
  
	public String getPcode(){
		return this.pcode;
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
	public void setPname1(String pname1){
		this.pname1 = pname1;
	}
  
	public String getPname1(){
		return this.pname1;
	}
	public void setPname2(String pname2){
		this.pname2 = pname2;
	}
  
	public String getPname2(){
		return this.pname2;
	}
	public void setSeq(Integer seq){
		this.seq = seq;
	}
  
	public Integer getSeq(){
		return this.seq;
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
