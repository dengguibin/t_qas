package	com.deceen.data.teacher.teacherTraining.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDTeachertraining.java   序号
* @Description: qas_d_teachertraining   
* @author upaths@gmail.com  
* @date 2017-11-23 12:30:17
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDTeachertraining extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //教工名称 
	private String employeeid;
	 //培训项目名称(全称) 
	private String trainingname;
	 //时间（天） 
	private Integer trainingday;
	 //学时数（小时） 
	private Integer teachinghour;
	 //国家 
	private String nationality;
	 //地点 
	private String trainingsite;
	 //派出部门 
	private String trainingdispatcheddepartment;
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
		 public void setTrainingname(String trainingname){
			this.trainingname = trainingname;
		}
	  
		public String getTrainingname(){
			return this.trainingname;
		}
		 public void setTrainingday(Integer trainingday){
			this.trainingday = trainingday;
		}
	  
		public Integer getTrainingday(){
			return this.trainingday;
		}
		 public void setTeachinghour(Integer teachinghour){
			this.teachinghour = teachinghour;
		}
	  
		public Integer getTeachinghour(){
			return this.teachinghour;
		}
		 public void setNationality(String nationality){
			this.nationality = nationality;
		}
	  
		public String getNationality(){
			return this.nationality;
		}
		 public void setTrainingsite(String trainingsite){
			this.trainingsite = trainingsite;
		}
	  
		public String getTrainingsite(){
			return this.trainingsite;
		}
		 public void setTrainingdispatcheddepartment(String trainingdispatcheddepartment){
			this.trainingdispatcheddepartment = trainingdispatcheddepartment;
		}
	  
		public String getTrainingdispatcheddepartment(){
			return this.trainingdispatcheddepartment;
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
