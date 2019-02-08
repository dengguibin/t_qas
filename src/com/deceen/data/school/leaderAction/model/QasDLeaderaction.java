package	com.deceen.data.school.leaderAction.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDLeaderaction.java   记录标识
* @Description: qas_d_leaderaction   
* @author upaths@gmail.com  
* @date 2017-11-22 17:43:40
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDLeaderaction extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //教工名称 
	private String employeeid;
	 //关注教学和学生情况<-->听课（节） 
	private Integer lecturecount;
	 //关注教学和学生情况<-->走访学生寝室（次） 
	private Integer interviewcount;
	 //关注教学和学生情况<-->走访校外实习点（次） 
	private Integer practicalsessioncount;
	 //关注教学和学生情况<-->参与学生社团文体活动（次） 
	private Integer studentassociationcount;
	 //兼课量（学时） 
	private Integer parttimecount;
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
	
	 //关注教学和学生情况<-->听课（节） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String lecturecountScope;
	 //关注教学和学生情况<-->走访学生寝室（次） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String interviewcountScope;
	 //关注教学和学生情况<-->走访校外实习点（次） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String practicalsessioncountScope;
	 //关注教学和学生情况<-->参与学生社团文体活动（次） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String studentassociationcountScope;
	 //兼课量（学时） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String parttimecountScope;
	
		 public String getLecturecountScope() {
		return lecturecountScope;
	}

	public void setLecturecountScope(String lecturecountScope) {
		this.lecturecountScope = lecturecountScope;
	}

	public String getInterviewcountScope() {
		return interviewcountScope;
	}

	public void setInterviewcountScope(String interviewcountScope) {
		this.interviewcountScope = interviewcountScope;
	}

	public String getPracticalsessioncountScope() {
		return practicalsessioncountScope;
	}

	public void setPracticalsessioncountScope(String practicalsessioncountScope) {
		this.practicalsessioncountScope = practicalsessioncountScope;
	}

	public String getStudentassociationcountScope() {
		return studentassociationcountScope;
	}

	public void setStudentassociationcountScope(String studentassociationcountScope) {
		this.studentassociationcountScope = studentassociationcountScope;
	}

	public String getParttimecountScope() {
		return parttimecountScope;
	}

	public void setParttimecountScope(String parttimecountScope) {
		this.parttimecountScope = parttimecountScope;
	}

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
		 public void setLecturecount(Integer lecturecount){
			this.lecturecount = lecturecount;
		}
	  
		public Integer getLecturecount(){
			return this.lecturecount;
		}
		 public void setInterviewcount(Integer interviewcount){
			this.interviewcount = interviewcount;
		}
	  
		public Integer getInterviewcount(){
			return this.interviewcount;
		}
		 public void setPracticalsessioncount(Integer practicalsessioncount){
			this.practicalsessioncount = practicalsessioncount;
		}
	  
		public Integer getPracticalsessioncount(){
			return this.practicalsessioncount;
		}
		 public void setStudentassociationcount(Integer studentassociationcount){
			this.studentassociationcount = studentassociationcount;
		}
	  
		public Integer getStudentassociationcount(){
			return this.studentassociationcount;
		}
		 public void setParttimecount(Integer parttimecount){
			this.parttimecount = parttimecount;
		}
	  
		public Integer getParttimecount(){
			return this.parttimecount;
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
