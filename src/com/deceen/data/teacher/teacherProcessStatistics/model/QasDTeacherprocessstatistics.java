package	com.deceen.data.teacher.teacherProcessStatistics.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDTeacherprocessstatistics.java   序号
* @Description: qas_d_teacherprocessstatistics   
* @author upaths@gmail.com  
* @date 2017-11-23 12:35:03
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDTeacherprocessstatistics extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //教工名称 
	private String employeeid;
	 //课程名称 
	private String courseid;
	 //教师缺课次数 
	private Integer absence;
	 //学生满意度 
	private Integer satisfactiontimes;
	 //因私调停课次数 
	private Integer transferforprivate;
	 //督导评分(平均分) 
	private Integer supervisionscore;
	 //教师授课计划个数 
	private Integer teachingprogram;
	 //备注 
	private String remark;
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
		 public void setCourseid(String courseid){
			this.courseid = courseid;
		}
	  
		public String getCourseid(){
			return this.courseid;
		}
		 public void setAbsence(Integer absence){
			this.absence = absence;
		}
	  
		public Integer getAbsence(){
			return this.absence;
		}
		 public void setSatisfactiontimes(Integer satisfactiontimes){
			this.satisfactiontimes = satisfactiontimes;
		}
	  
		public Integer getSatisfactiontimes(){
			return this.satisfactiontimes;
		}
		 public void setTransferforprivate(Integer transferforprivate){
			this.transferforprivate = transferforprivate;
		}
	  
		public Integer getTransferforprivate(){
			return this.transferforprivate;
		}
		 public void setSupervisionscore(Integer supervisionscore){
			this.supervisionscore = supervisionscore;
		}
	  
		public Integer getSupervisionscore(){
			return this.supervisionscore;
		}
		 public void setTeachingprogram(Integer teachingprogram){
			this.teachingprogram = teachingprogram;
		}
	  
		public Integer getTeachingprogram(){
			return this.teachingprogram;
		}
		 public void setRemark(String remark){
			this.remark = remark;
		}
	  
		public String getRemark(){
			return this.remark;
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
