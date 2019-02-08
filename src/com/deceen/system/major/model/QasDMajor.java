/**
*/
package	com.deceen.system.major.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDMajor.java   专业唯一标识
* @Description: qas_d_major   
* @author upaths@gmail.com  
* @date 2017-11-30 10:54:53
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDMajor extends Pagination implements Serializable{ 	
	
	 //专业唯一标识 @PrimaryKey
	private String id;
	 //所属系部编号 
	private String organizationid;
	 //专业代码 
	private String majorcode;
	 //专业名称 
	private String majorname;
	 //专业文理类别 
	private String divisiontype;
	 //是否招生 
	private String isenroll;
	 //新增年月 
	private String enrolldate;
	 //停招年月 
	private String notenrolldate;
	 //撤销年月 
	private String revokemajorcount;
	 //状态 
	private Integer status;
	 //创建人 
	private String createdby;
	 //创建时间 
	private Date createdtime;
	 //修改人 
	private String updatedby;
	 //修改时间 
	private Date updatedtime;
	 //租户 
	private String tenantid;
	 //入库时间（接口传输，导入） 
	private Date storagetime;
	
	private String checked;
	
	private String unit_type;

		 public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setOrganizationid(String organizationid){
			this.organizationid = organizationid;
		}
	  
		public String getOrganizationid(){
			return this.organizationid;
		}
		 public void setMajorcode(String majorcode){
			this.majorcode = majorcode;
		}
	  
		public String getMajorcode(){
			return this.majorcode;
		}
		 public void setMajorname(String majorname){
			this.majorname = majorname;
		}
	  
		public String getMajorname(){
			return this.majorname;
		}
		 public void setDivisiontype(String divisiontype){
			this.divisiontype = divisiontype;
		}
	  
		public String getDivisiontype(){
			return this.divisiontype;
		}
		 public void setIsenroll(String isenroll){
			this.isenroll = isenroll;
		}
	  
		public String getIsenroll(){
			return this.isenroll;
		}
		 public void setEnrolldate(String enrolldate){
			this.enrolldate = enrolldate;
		}
	  
		public String getEnrolldate(){
			return this.enrolldate;
		}
		 public void setNotenrolldate(String notenrolldate){
			this.notenrolldate = notenrolldate;
		}
	  
		public String getNotenrolldate(){
			return this.notenrolldate;
		}
		 public void setRevokemajorcount(String revokemajorcount){
			this.revokemajorcount = revokemajorcount;
		}
	  
		public String getRevokemajorcount(){
			return this.revokemajorcount;
		}
		
		 public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public void setCreatedby(String createdby){
			this.createdby = createdby;
		}
	  
		public String getCreatedby(){
			return this.createdby;
		}
		 public void setCreatedtime(Date createdtime){
			this.createdtime = createdtime;
		}
	  
		public Date getCreatedtime(){
			return this.createdtime;
		}
		 public void setUpdatedby(String updatedby){
			this.updatedby = updatedby;
		}
	  
		public String getUpdatedby(){
			return this.updatedby;
		}
		 public void setUpdatedtime(Date updatedtime){
			this.updatedtime = updatedtime;
		}
	  
		public Date getUpdatedtime(){
			return this.updatedtime;
		}
		 public void setTenantid(String tenantid){
			this.tenantid = tenantid;
		}
	  
		public String getTenantid(){
			return this.tenantid;
		}
		 public void setStoragetime(Date storagetime){
			this.storagetime = storagetime;
		}
	  
		public Date getStoragetime(){
			return this.storagetime;
		}

		public String getChecked() {
			return checked;
		}

		public void setChecked(String checked) {
			this.checked = checked;
		}

		public String getUnit_type() {
			return unit_type;
		}

		public void setUnit_type(String unit_type) {
			this.unit_type = unit_type;
		}
		
		
		
		
}
