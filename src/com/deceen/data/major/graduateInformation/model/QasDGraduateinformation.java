package	com.deceen.data.major.graduateInformation.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDGraduateinformation.java   记录标识
* @Description: qas_d_graduateinformation   
* @author upaths@gmail.com  
* @date 2017-11-23 16:10:43
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDGraduateinformation extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //学生名称 
	private String studentid;
	 //毕业去向 
	private String graduation;
	 //就业省份 
	private String employmentprovinces;
	 //就业单位名称(全称) 
	private String companyname;
	 //单位性质 
	private String companynature;
	 //单位规模 
	private String companyscale;
	 //是否获得全部学分 
	private String isreceiveallcredits;
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
		 public void setStudentid(String studentid){
			this.studentid = studentid;
		}
	  
		public String getStudentid(){
			return this.studentid;
		}
		 public void setGraduation(String graduation){
			this.graduation = graduation;
		}
	  
		public String getGraduation(){
			return this.graduation;
		}
		 public void setEmploymentprovinces(String employmentprovinces){
			this.employmentprovinces = employmentprovinces;
		}
	  
		public String getEmploymentprovinces(){
			return this.employmentprovinces;
		}
		 public void setCompanyname(String companyname){
			this.companyname = companyname;
		}
	  
		public String getCompanyname(){
			return this.companyname;
		}
		 public void setCompanynature(String companynature){
			this.companynature = companynature;
		}
	  
		public String getCompanynature(){
			return this.companynature;
		}
		 public void setCompanyscale(String companyscale){
			this.companyscale = companyscale;
		}
	  
		public String getCompanyscale(){
			return this.companyscale;
		}
		 public void setIsreceiveallcredits(String isreceiveallcredits){
			this.isreceiveallcredits = isreceiveallcredits;
		}
	  
		public String getIsreceiveallcredits(){
			return this.isreceiveallcredits;
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
