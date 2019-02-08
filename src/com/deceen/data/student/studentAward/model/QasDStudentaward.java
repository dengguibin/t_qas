package	com.deceen.data.student.studentAward.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDStudentaward.java   项目标识
* @Description: qas_d_studentaward   
* @author upaths@gmail.com  
* @date 2017-11-24 10:26:48
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDStudentaward extends Pagination implements Serializable{ 	
	
	 //项目标识 @PrimaryKey
	private String id;
	 //项目名称(全称) 
	private String projname;
	 //项目类别 
	private String projtype;
	 //级别 
	private String grade;
	 //获奖日期（年月） 
	private String awarddate;
	 //学生名单 
	private String studentlist;
	 //指导教师名单 
	private String tutors;
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
		 public void setProjname(String projname){
			this.projname = projname;
		}
	  
		public String getProjname(){
			return this.projname;
		}
		 public void setProjtype(String projtype){
			this.projtype = projtype;
		}
	  
		public String getProjtype(){
			return this.projtype;
		}
		 public void setGrade(String grade){
			this.grade = grade;
		}
	  
		public String getGrade(){
			return this.grade;
		}
		 public void setAwarddate(String awarddate){
			this.awarddate = awarddate;
		}
	  
		public String getAwarddate(){
			return this.awarddate;
		}
		 public void setStudentlist(String studentlist){
			this.studentlist = studentlist;
		}
	  
		public String getStudentlist(){
			return this.studentlist;
		}
		 public void setTutors(String tutors){
			this.tutors = tutors;
		}
	  
		public String getTutors(){
			return this.tutors;
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
