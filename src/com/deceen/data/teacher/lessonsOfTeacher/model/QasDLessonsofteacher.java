package	com.deceen.data.teacher.lessonsOfTeacher.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDLessonsofteacher.java   序号
* @Description: qas_d_lessonsofteacher   
* @author upaths@gmail.com  
* @date 2017-11-23 12:34:30
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDLessonsofteacher extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //教工名称 
	private String employeeid;
	 //专业方向 
	private String directionid;
	 //课程名称 
	private String courseid;
	 //授课任务 
	private String teachingtask;
	 //是否合班授课 
	private String ismergeclass;
	 //是否平行班 
	private String isparallelclass;
	 //教学工作量（学时） 
	private Integer teachingload;
	 //实际授课课时 
	private Integer hour;
	 //主要开设实践项目名称(全称)<-->实验 
	private String experiment;
	 //主要开设实践项目名称(全称)<-->实训 
	private String training;
	 //主要开设实践项目名称(全称)<-->实习 
	private String practice;
	 //是否行政班授课 
	private String isexecutiveclass;
	 //授课学期 
	private String term;
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
		 public void setDirectionid(String directionid){
			this.directionid = directionid;
		}
	  
		public String getDirectionid(){
			return this.directionid;
		}
		 public void setCourseid(String courseid){
			this.courseid = courseid;
		}
	  
		public String getCourseid(){
			return this.courseid;
		}
		 public void setTeachingtask(String teachingtask){
			this.teachingtask = teachingtask;
		}
	  
		public String getTeachingtask(){
			return this.teachingtask;
		}
		 public void setIsmergeclass(String ismergeclass){
			this.ismergeclass = ismergeclass;
		}
	  
		public String getIsmergeclass(){
			return this.ismergeclass;
		}
		 public void setIsparallelclass(String isparallelclass){
			this.isparallelclass = isparallelclass;
		}
	  
		public String getIsparallelclass(){
			return this.isparallelclass;
		}
		 public void setTeachingload(Integer teachingload){
			this.teachingload = teachingload;
		}
	  
		public Integer getTeachingload(){
			return this.teachingload;
		}
		 public void setHour(Integer hour){
			this.hour = hour;
		}
	  
		public Integer getHour(){
			return this.hour;
		}
		 public void setExperiment(String experiment){
			this.experiment = experiment;
		}
	  
		public String getExperiment(){
			return this.experiment;
		}
		 public void setTraining(String training){
			this.training = training;
		}
	  
		public String getTraining(){
			return this.training;
		}
		 public void setPractice(String practice){
			this.practice = practice;
		}
	  
		public String getPractice(){
			return this.practice;
		}
		 public void setIsexecutiveclass(String isexecutiveclass){
			this.isexecutiveclass = isexecutiveclass;
		}
	  
		public String getIsexecutiveclass(){
			return this.isexecutiveclass;
		}
		 public void setTerm(String term){
			this.term = term;
		}
	  
		public String getTerm(){
			return this.term;
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
