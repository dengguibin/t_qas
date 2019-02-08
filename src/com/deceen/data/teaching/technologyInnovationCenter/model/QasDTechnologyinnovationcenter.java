package	com.deceen.data.teaching.technologyInnovationCenter.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDTechnologyinnovationcenter.java   序号
* @Description: qas_d_technologyinnovationcenter   
* @author upaths@gmail.com  
* @date 2017-11-24 12:22:05
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDTechnologyinnovationcenter extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //项目名称 
	private String projectname;
	 //专业 
	private String majorid;
	 //类别 
	private String projecttype;
	 //项目级别 
	private String grade;
	 //项目负责人 
	private String employeeid;
	 //授予部门 
	private String department;
	 //立项文件名称、文号 
	private String file;
	 //开始时间 
	private Date starttime;
	 //结束时间 
	private Date endtime;
	 //当前状态 
	private String curstatus;
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
		 public void setProjectname(String projectname){
			this.projectname = projectname;
		}
	  
		public String getProjectname(){
			return this.projectname;
		}
		 public void setMajorid(String majorid){
			this.majorid = majorid;
		}
	  
		public String getMajorid(){
			return this.majorid;
		}
		 public void setProjecttype(String projecttype){
			this.projecttype = projecttype;
		}
	  
		public String getProjecttype(){
			return this.projecttype;
		}
		 public void setGrade(String grade){
			this.grade = grade;
		}
	  
		public String getGrade(){
			return this.grade;
		}
		 public void setEmployeeid(String employeeid){
			this.employeeid = employeeid;
		}
	  
		public String getEmployeeid(){
			return this.employeeid;
		}
		 public void setDepartment(String department){
			this.department = department;
		}
	  
		public String getDepartment(){
			return this.department;
		}
		 public void setFile(String file){
			this.file = file;
		}
	  
		public String getFile(){
			return this.file;
		}
		 public void setStarttime(Date starttime){
			this.starttime = starttime;
		}
	  
		public Date getStarttime(){
			return this.starttime;
		}
		 public void setEndtime(Date endtime){
			this.endtime = endtime;
		}
	  
		public Date getEndtime(){
			return this.endtime;
		}
		 public void setCurstatus(String curstatus){
			this.curstatus = curstatus;
		}
	  
		public String getCurstatus(){
			return this.curstatus;
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
