package	com.deceen.data.school.socialDonation.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDSocialdonation.java   记录标识
* @Description: qas_d_socialdonation   
* @author upaths@gmail.com  
* @date 2017-11-22 18:00:58
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDSocialdonation extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //捐赠单位 
	private String donationdepartment;
	 //捐赠项目 
	private String donationproject;
	 //捐赠日期（年月） 
	private String donationdate;
	 //捐赠性质 
	private String donationnature;
	 //捐赠价值（万元） 
	private Integer donationvalue;
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
	
	//捐赠价值（万元） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String donationvalueScope;
	
		 public String getDonationvalueScope() {
		return donationvalueScope;
	}

	public void setDonationvalueScope(String donationvalueScope) {
		this.donationvalueScope = donationvalueScope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setDonationdepartment(String donationdepartment){
			this.donationdepartment = donationdepartment;
		}
	  
		public String getDonationdepartment(){
			return this.donationdepartment;
		}
		 public void setDonationproject(String donationproject){
			this.donationproject = donationproject;
		}
	  
		public String getDonationproject(){
			return this.donationproject;
		}
		 public void setDonationdate(String donationdate){
			this.donationdate = donationdate;
		}
	  
		public String getDonationdate(){
			return this.donationdate;
		}
		 public void setDonationnature(String donationnature){
			this.donationnature = donationnature;
		}
	  
		public String getDonationnature(){
			return this.donationnature;
		}
		 public void setDonationvalue(Integer donationvalue){
			this.donationvalue = donationvalue;
		}
	  
		public Integer getDonationvalue(){
			return this.donationvalue;
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
