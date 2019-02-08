package	com.deceen.data.school.trainingBaseOutOfCampusStatistics.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDTrainingbaseoutofcampusstatistics.java   记录标识
* @Description: qas_d_trainingbaseoutofcampusstatistics   
* @author upaths@gmail.com  
* @date 2017-11-22 17:58:43
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDTrainingbaseoutofcampusstatistics extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //校外实践基地 
	private String practicebaseincampusid;
	 //面向专业  
	private String majorid;
	 //项目数 
	private Integer numoftrainingproject;
	 //实习实训项目<-->项目 
	private String numofprojectname;
	 //接待学生量(人次)	 
	private Integer numofstureceived;
	 //基地使用时间（天） 
	private Integer baseusetime;
	 //接受半年顶岗实习学生数 
	private Integer halfyearinternshipstudent;
	 //是否有住宿条件	 
	private String isaccommodationconditions;
	 //基地是否发放学生实习补贴 
	private String studentinternshipallowance;
	 //向基地支付专项实习经费（元/生） 
	private Integer specialpracticefund;
	 //派指导教师/学生管理人员（人次） 
	private Integer schooltutorcount;
	 //接收应届毕业生就业数	 
	private Integer numofgraduateemployed;
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
	
	 //项目数 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String numoftrainingprojectScope;
	 //接待学生量(人次)范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000	 
	private String numofstureceivedScope;
	 //基地使用时间（天） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String baseusetimeScope;
	 //接受半年顶岗实习学生数 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String halfyearinternshipstudentScope;
	
		 public String getNumoftrainingprojectScope() {
		return numoftrainingprojectScope;
	}

	public void setNumoftrainingprojectScope(String numoftrainingprojectScope) {
		this.numoftrainingprojectScope = numoftrainingprojectScope;
	}

	public String getNumofstureceivedScope() {
		return numofstureceivedScope;
	}

	public void setNumofstureceivedScope(String numofstureceivedScope) {
		this.numofstureceivedScope = numofstureceivedScope;
	}

	public String getBaseusetimeScope() {
		return baseusetimeScope;
	}

	public void setBaseusetimeScope(String baseusetimeScope) {
		this.baseusetimeScope = baseusetimeScope;
	}

	public String getHalfyearinternshipstudentScope() {
		return halfyearinternshipstudentScope;
	}

	public void setHalfyearinternshipstudentScope(
			String halfyearinternshipstudentScope) {
		this.halfyearinternshipstudentScope = halfyearinternshipstudentScope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setPracticebaseincampusid(String practicebaseincampusid){
			this.practicebaseincampusid = practicebaseincampusid;
		}
	  
		public String getPracticebaseincampusid(){
			return this.practicebaseincampusid;
		}
		 public void setMajorid(String majorid){
			this.majorid = majorid;
		}
	  
		public String getMajorid(){
			return this.majorid;
		}
		 public void setNumoftrainingproject(Integer numoftrainingproject){
			this.numoftrainingproject = numoftrainingproject;
		}
	  
		public Integer getNumoftrainingproject(){
			return this.numoftrainingproject;
		}
		 public void setNumofprojectname(String numofprojectname){
			this.numofprojectname = numofprojectname;
		}
	  
		public String getNumofprojectname(){
			return this.numofprojectname;
		}
		 public void setNumofstureceived(Integer numofstureceived){
			this.numofstureceived = numofstureceived;
		}
	  
		public Integer getNumofstureceived(){
			return this.numofstureceived;
		}
		 public void setBaseusetime(Integer baseusetime){
			this.baseusetime = baseusetime;
		}
	  
		public Integer getBaseusetime(){
			return this.baseusetime;
		}
		 public void setHalfyearinternshipstudent(Integer halfyearinternshipstudent){
			this.halfyearinternshipstudent = halfyearinternshipstudent;
		}
	  
		public Integer getHalfyearinternshipstudent(){
			return this.halfyearinternshipstudent;
		}
		 public void setIsaccommodationconditions(String isaccommodationconditions){
			this.isaccommodationconditions = isaccommodationconditions;
		}
	  
		public String getIsaccommodationconditions(){
			return this.isaccommodationconditions;
		}
		 public void setStudentinternshipallowance(String studentinternshipallowance){
			this.studentinternshipallowance = studentinternshipallowance;
		}
	  
		public String getStudentinternshipallowance(){
			return this.studentinternshipallowance;
		}
		 public void setSpecialpracticefund(Integer specialpracticefund){
			this.specialpracticefund = specialpracticefund;
		}
	  
		public Integer getSpecialpracticefund(){
			return this.specialpracticefund;
		}
		 public void setSchooltutorcount(Integer schooltutorcount){
			this.schooltutorcount = schooltutorcount;
		}
	  
		public Integer getSchooltutorcount(){
			return this.schooltutorcount;
		}
		 public void setNumofgraduateemployed(Integer numofgraduateemployed){
			this.numofgraduateemployed = numofgraduateemployed;
		}
	  
		public Integer getNumofgraduateemployed(){
			return this.numofgraduateemployed;
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
