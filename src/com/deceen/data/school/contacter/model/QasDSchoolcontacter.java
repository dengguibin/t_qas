package	com.deceen.data.school.contacter.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDSchoolcontacter.java   记录标识
* @Description: qas_d_schoolcontacter   
* @author upaths@gmail.com  
* @date 2017-11-22 17:30:20
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDSchoolcontacter extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //联系人信息<-->姓名 
	private String contactname;
	 //联系人信息<-->职务 
	private String contactduty;
	 //联系人信息<-->区号-电话号码 
	private String contactphone;
	 //联系人信息<-->区号-传真号 
	private String contactfax;
	 //联系人信息<-->电子邮箱 
	private String contactmobile;
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
		 public void setContactfax(String contactfax){
			this.contactfax = contactfax;
		}
	  
		public String getContactfax(){
			return this.contactfax;
		}
		 public void setContactmobile(String contactmobile){
			this.contactmobile = contactmobile;
		}
	  
		public String getContactmobile(){
			return this.contactmobile;
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
