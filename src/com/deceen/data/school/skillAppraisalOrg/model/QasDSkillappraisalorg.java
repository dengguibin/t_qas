package	com.deceen.data.school.skillAppraisalOrg.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDSkillappraisalorg.java   职业技能鉴定站（所）唯一标识
* @Description: qas_d_skillappraisalorg   
* @author upaths@gmail.com  
* @date 2017-11-22 17:59:15
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDSkillappraisalorg extends Pagination implements Serializable{ 	
	
	 //职业技能鉴定站（所）唯一标识 @PrimaryKey
	private String id;
	 //职业技能鉴定站（所）全称 
	private String name;
	 //建立单位<-->级别 
	private String grade;
	 //建立单位<-->部门 
	private String department;
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
		 public void setName(String name){
			this.name = name;
		}
	  
		public String getName(){
			return this.name;
		}
		 public void setGrade(String grade){
			this.grade = grade;
		}
	  
		public String getGrade(){
			return this.grade;
		}
		 public void setDepartment(String department){
			this.department = department;
		}
	  
		public String getDepartment(){
			return this.department;
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
