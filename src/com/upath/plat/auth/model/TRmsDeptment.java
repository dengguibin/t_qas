/**
*/
package	com.upath.plat.auth.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
* 
* @ClassName: TRmsDeptment.java   单位部门ID
* @Description: t_rms_deptment   
* @author upaths@gmail.com  
* @date 2012-11-3 22:06:26
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TRmsDeptment extends Pagination implements Serializable { 	
	
	//单位部门ID @PrimaryKey
	private String bmid;
	//父部门ID 
	private String fbmid;
	//部门编号 
	private String bmbh;
	//部门名称 
	private String bmmc;
	//部门类型 
	private String unit_type;
	
	//排序号 
	private Integer pxh;
	//部门负责人 
	private String bmhjr;
	//部门职能描述 
	private String bmms;
	//层级 
	private Integer cj;
	//创建时间 
	private Date cjsj;
	//创建人 
	private String cjr;
	//修改时间 
	private Date xgsj;
	//修改人 
	private String xgr;
	/**
	 * 2015-05-07 黄斌新增加到平台
	 */
	//部门类型(复合控制码)
	private Integer style;
	
	//FDNCODE(部门全编号)
	private String fdncode;
	
	
	
	public Integer getStyle() {
		return style;
	}

	public void setStyle(Integer style) {
		this.style = style;
	}

	public String getFdncode() {
		return fdncode;
	}

	public void setFdncode(String fdncode) {
		this.fdncode = fdncode;
	}

	public String getBmid() {
		return bmid;
	}

	public void setBmid(String bmid) {
		this.bmid = bmid;
	}

	public String getFbmid() {
		return fbmid;
	}

	public void setFbmid(String fbmid) {
		this.fbmid = fbmid;
	}

	public void setBmbh(String bmbh){
		this.bmbh = bmbh;
	}
  
	public String getBmbh(){
		return this.bmbh;
	}
	public void setBmmc(String bmmc){
		this.bmmc = bmmc;
	}
  
	public String getBmmc(){
		return this.bmmc;
	}
	
	public void setBmhjr(String bmhjr){
		this.bmhjr = bmhjr;
	}
  
	public String getBmhjr(){
		return this.bmhjr;
	}
	public void setBmms(String bmms){
		this.bmms = bmms;
	}
  
	public String getBmms(){
		return this.bmms;
	}
	public void setCj(Integer cj){
		this.cj = cj;
	}
  
	public Integer getCj(){
		return this.cj;
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
  
	public String getUnit_type() {
		return unit_type;
	}

	public void setUnit_type(String unit_type) {
		this.unit_type = unit_type;
	}

	public String getXgr(){
		return this.xgr;
	}

	public Integer getPxh() {
		return pxh;
	}

	public void setPxh(Integer pxh) {
		this.pxh = pxh;
	}
}
