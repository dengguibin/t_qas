package	com.deceen.data.teaching.studentManagement.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDStudentmanagement.java   序号
* @Description: qas_d_studentmanagement   
* @author upaths@gmail.com  
* @date 2017-11-24 12:14:24
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDStudentmanagement extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //教工名称 
	private String employeeid;
	 //本岗位工作年限（年 
	private Integer postage;
	 //从事教学管理年限（年） 
	private Integer managerage;
	 //是否专职政治辅导员 
	private String ispoliticalinstructor;
	 //是否专职心理咨询师 
	private String ispsychologist;
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
		 public void setEmployeeid(String employeeid){
			this.employeeid = employeeid;
		}
	  
		public String getEmployeeid(){
			return this.employeeid;
		}
		 public void setPostage(Integer postage){
			this.postage = postage;
		}
	  
		public Integer getPostage(){
			return this.postage;
		}
		 public void setManagerage(Integer managerage){
			this.managerage = managerage;
		}
	  
		public Integer getManagerage(){
			return this.managerage;
		}
		 public void setIspoliticalinstructor(String ispoliticalinstructor){
			this.ispoliticalinstructor = ispoliticalinstructor;
		}
	  
		public String getIspoliticalinstructor(){
			return this.ispoliticalinstructor;
		}
		 public void setIspsychologist(String ispsychologist){
			this.ispsychologist = ispsychologist;
		}
	  
		public String getIspsychologist(){
			return this.ispsychologist;
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
