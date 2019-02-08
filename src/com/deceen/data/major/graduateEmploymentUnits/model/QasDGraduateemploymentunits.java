package	com.deceen.data.major.graduateEmploymentUnits.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDGraduateemploymentunits.java   记录标识
* @Description: qas_d_graduateemploymentunits   
* @author upaths@gmail.com  
* @date 2017-11-23 16:11:24
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDGraduateemploymentunits extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //应届毕业生主要就业单位名称(全称) 
	private String mainemploymentunit;
	 //是否做过雇主调查 
	private String isemployersurvey;
	 //就业单位联系人信息<-->姓名 
	private String contactname;
	 //就业单位联系人信息<-->职务 
	private String contactduty;
	 //就业单位联系人信息<-->区号－电话号码 
	private String contactphone;
	 //就业单位联系人信息<-->电子邮箱 
	private String contactemail;
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

		 public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setMainemploymentunit(String mainemploymentunit){
			this.mainemploymentunit = mainemploymentunit;
		}
	  
		public String getMainemploymentunit(){
			return this.mainemploymentunit;
		}
		 public void setIsemployersurvey(String isemployersurvey){
			this.isemployersurvey = isemployersurvey;
		}
	  
		public String getIsemployersurvey(){
			return this.isemployersurvey;
		}
		 public void setContactname(String contactname){
			this.contactname = contactname;
		}
	  
		public String getContactname(){
			return this.contactname;
		}
		 public void setContactduty(String contactduty){
			this.contactduty = contactduty;
		}
	  
		public String getContactduty(){
			return this.contactduty;
		}
		 public void setContactphone(String contactphone){
			this.contactphone = contactphone;
		}
	  
		public String getContactphone(){
			return this.contactphone;
		}
		 public void setContactemail(String contactemail){
			this.contactemail = contactemail;
		}
	  
		public String getContactemail(){
			return this.contactemail;
		}
		 public void setStatus(Integer status){
			this.status = status;
		}
	  
		public Integer getStatus(){
			return this.status;
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
}
