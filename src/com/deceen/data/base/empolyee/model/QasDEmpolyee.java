package	com.deceen.data.base.empolyee.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDEmpolyee.java   教工唯一标识
* @Description: qas_d_empolyee   
* @author upaths@gmail.com  
* @date 2017-11-22 11:09:27
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDEmpolyee extends Pagination implements Serializable{ 	
	
	 //教工唯一标识 @PrimaryKey
	private String id;
	 //所属系部 
	private String departmentid;
	 //所属专业 
	private String majorid;
	 //教工号 
	private String employeecode;
	 //姓名 
	private String name;
	 //民族 
	private String nation;
	 //职务 
	private String duty;
	 //职称 
	private String title;
	 //学历 
	private String qualification;
	 //学位 
	private String academicdegree;
	 //性别 
	private String sex;
	 //出生日期 
	private String birthday;
	 //区号-电话号码 
	private String phone;
	 //电子邮箱 
	private String email;
	 //工作经历简介 
	private String workexperience;
	 //专业技术职务<-->等级 
	private String majordeep;
	 //专业技术职务<-->名称（全称） 
	private String highmajorname;
	 //专业技术职务<-->发证单位 
	private String grantcompany;
	 //专业技术职务<-->获取日期(年月) 
	private String receiveddate;
	 //是否在编 
	private String isinplan;
	 //岗位职能 
	private String postduty;
	 //科研成果 
	private String achievement;
	 //分管工作 
	private String managework;
	 //教师类型 
	private String teachertype;
	 //专业领域 
	private String specialarea;
	 //专业特长 
	private String specialty;
	 //有无高校教师资格证 
	private String isteacherdegree;
	 //行业、企业一线工作时间<-->历年（年） 
	private Integer workyear;
	 //行业、企业一线工作时间<-->本学年（天） 
	private Integer workincurrentyear;
	 //职业资格证书<-->等级 
	private String qualificationlevel;
	 //职业资格证书<-->名称(全称) 
	private String qualificationname;
	 //职业资格证书<-->发证单位 
	private String qualificationunit;
	 //职业资格证书<-->获取日期（年月） 
	private String qualificationreceivedate;
	 //高校教师资格证书<-->发证单位	 
	private String teacherqualificationunit;
	 //高校教师资格证书<-->获取日期（年月） 
	private String teacherqualificationreceivedate;
	 //是否专业教师 
	private String isprofessionalteacher;
	 //是否为骨干教师 
	private String iscoreteacher;
	 //是否为双师素质教师 
	private String doublequalifiedteacher;
	 //教学名师 
	private String famousteacher;
	 //是否校企双导师 
	private String dualmentor;
	 //是否企业导师 
	private String companymentor;
	 //互聘公培导师 
	private String publictrainingsupervisor;
	 //"千百十"人才培养等级 
	private String traininglevel;
	 //珠江学者 
	private String iszhujiangscholar;
	 //校外教师<-->参加工作日期（年月） 
	private String dateofwork;
	 //校外教师<-->签约情况 
	private String signedstatus;
	 //校外教师<-->当前专职工作背景<-->单位名称 
	private String backgroundunit;
	 //校外教师<-->当前专职工作背景<-->职务 
	private String backgroundduty;
	 //校外教师<-->当前专职工作背景<-->任职日期（年月） 
	private String backgroundappointmentdate;
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
		 public void setDepartmentid(String departmentid){
			this.departmentid = departmentid;
		}
	  
		public String getDepartmentid(){
			return this.departmentid;
		}
		 public void setMajorid(String majorid){
			this.majorid = majorid;
		}
	  
		public String getMajorid(){
			return this.majorid;
		}
		 public void setEmployeecode(String employeecode){
			this.employeecode = employeecode;
		}
	  
		public String getEmployeecode(){
			return this.employeecode;
		}
		 public void setName(String name){
			this.name = name;
		}
	  
		public String getName(){
			return this.name;
		}
		 public void setNation(String nation){
			this.nation = nation;
		}
	  
		public String getNation(){
			return this.nation;
		}
		 public void setDuty(String duty){
			this.duty = duty;
		}
	  
		public String getDuty(){
			return this.duty;
		}
		 public void setTitle(String title){
			this.title = title;
		}
	  
		public String getTitle(){
			return this.title;
		}
		 public void setQualification(String qualification){
			this.qualification = qualification;
		}
	  
		public String getQualification(){
			return this.qualification;
		}
		 public void setAcademicdegree(String academicdegree){
			this.academicdegree = academicdegree;
		}
	  
		public String getAcademicdegree(){
			return this.academicdegree;
		}
		 public void setSex(String sex){
			this.sex = sex;
		}
	  
		public String getSex(){
			return this.sex;
		}
		 public void setBirthday(String birthday){
			this.birthday = birthday;
		}
	  
		public String getBirthday(){
			return this.birthday;
		}
		 public void setPhone(String phone){
			this.phone = phone;
		}
	  
		public String getPhone(){
			return this.phone;
		}
		 public void setEmail(String email){
			this.email = email;
		}
	  
		public String getEmail(){
			return this.email;
		}
		 public void setWorkexperience(String workexperience){
			this.workexperience = workexperience;
		}
	  
		public String getWorkexperience(){
			return this.workexperience;
		}
		 public void setMajordeep(String majordeep){
			this.majordeep = majordeep;
		}
	  
		public String getMajordeep(){
			return this.majordeep;
		}
		 public void setHighmajorname(String highmajorname){
			this.highmajorname = highmajorname;
		}
	  
		public String getHighmajorname(){
			return this.highmajorname;
		}
		 public void setGrantcompany(String grantcompany){
			this.grantcompany = grantcompany;
		}
	  
		public String getGrantcompany(){
			return this.grantcompany;
		}
		 public void setReceiveddate(String receiveddate){
			this.receiveddate = receiveddate;
		}
	  
		public String getReceiveddate(){
			return this.receiveddate;
		}
		 public void setIsinplan(String isinplan){
			this.isinplan = isinplan;
		}
	  
		public String getIsinplan(){
			return this.isinplan;
		}
		 public void setPostduty(String postduty){
			this.postduty = postduty;
		}
	  
		public String getPostduty(){
			return this.postduty;
		}
		 public void setAchievement(String achievement){
			this.achievement = achievement;
		}
	  
		public String getAchievement(){
			return this.achievement;
		}
		 public void setManagework(String managework){
			this.managework = managework;
		}
	  
		public String getManagework(){
			return this.managework;
		}
		 public void setTeachertype(String teachertype){
			this.teachertype = teachertype;
		}
	  
		public String getTeachertype(){
			return this.teachertype;
		}
		 public void setSpecialarea(String specialarea){
			this.specialarea = specialarea;
		}
	  
		public String getSpecialarea(){
			return this.specialarea;
		}
		 public void setSpecialty(String specialty){
			this.specialty = specialty;
		}
	  
		public String getSpecialty(){
			return this.specialty;
		}
		 public void setIsteacherdegree(String isteacherdegree){
			this.isteacherdegree = isteacherdegree;
		}
	  
		public String getIsteacherdegree(){
			return this.isteacherdegree;
		}
		 public void setWorkyear(Integer workyear){
			this.workyear = workyear;
		}
	  
		public Integer getWorkyear(){
			return this.workyear;
		}
		 public void setWorkincurrentyear(Integer workincurrentyear){
			this.workincurrentyear = workincurrentyear;
		}
	  
		public Integer getWorkincurrentyear(){
			return this.workincurrentyear;
		}
		 public void setQualificationlevel(String qualificationlevel){
			this.qualificationlevel = qualificationlevel;
		}
	  
		public String getQualificationlevel(){
			return this.qualificationlevel;
		}
		 public void setQualificationname(String qualificationname){
			this.qualificationname = qualificationname;
		}
	  
		public String getQualificationname(){
			return this.qualificationname;
		}
		 public void setQualificationunit(String qualificationunit){
			this.qualificationunit = qualificationunit;
		}
	  
		public String getQualificationunit(){
			return this.qualificationunit;
		}
		 public void setQualificationreceivedate(String qualificationreceivedate){
			this.qualificationreceivedate = qualificationreceivedate;
		}
	  
		public String getQualificationreceivedate(){
			return this.qualificationreceivedate;
		}
		 public void setTeacherqualificationunit(String teacherqualificationunit){
			this.teacherqualificationunit = teacherqualificationunit;
		}
	  
		public String getTeacherqualificationunit(){
			return this.teacherqualificationunit;
		}
		 public void setTeacherqualificationreceivedate(String teacherqualificationreceivedate){
			this.teacherqualificationreceivedate = teacherqualificationreceivedate;
		}
	  
		public String getTeacherqualificationreceivedate(){
			return this.teacherqualificationreceivedate;
		}
		 public void setIsprofessionalteacher(String isprofessionalteacher){
			this.isprofessionalteacher = isprofessionalteacher;
		}
	  
		public String getIsprofessionalteacher(){
			return this.isprofessionalteacher;
		}
		 public void setIscoreteacher(String iscoreteacher){
			this.iscoreteacher = iscoreteacher;
		}
	  
		public String getIscoreteacher(){
			return this.iscoreteacher;
		}
		 public void setDoublequalifiedteacher(String doublequalifiedteacher){
			this.doublequalifiedteacher = doublequalifiedteacher;
		}
	  
		public String getDoublequalifiedteacher(){
			return this.doublequalifiedteacher;
		}
		 public void setFamousteacher(String famousteacher){
			this.famousteacher = famousteacher;
		}
	  
		public String getFamousteacher(){
			return this.famousteacher;
		}
		 public void setDualmentor(String dualmentor){
			this.dualmentor = dualmentor;
		}
	  
		public String getDualmentor(){
			return this.dualmentor;
		}
		 public void setCompanymentor(String companymentor){
			this.companymentor = companymentor;
		}
	  
		public String getCompanymentor(){
			return this.companymentor;
		}
		 public void setPublictrainingsupervisor(String publictrainingsupervisor){
			this.publictrainingsupervisor = publictrainingsupervisor;
		}
	  
		public String getPublictrainingsupervisor(){
			return this.publictrainingsupervisor;
		}
		 public void setTraininglevel(String traininglevel){
			this.traininglevel = traininglevel;
		}
	  
		public String getTraininglevel(){
			return this.traininglevel;
		}
		 public void setIszhujiangscholar(String iszhujiangscholar){
			this.iszhujiangscholar = iszhujiangscholar;
		}
	  
		public String getIszhujiangscholar(){
			return this.iszhujiangscholar;
		}
		 public void setDateofwork(String dateofwork){
			this.dateofwork = dateofwork;
		}
	  
		public String getDateofwork(){
			return this.dateofwork;
		}
		 public void setSignedstatus(String signedstatus){
			this.signedstatus = signedstatus;
		}
	  
		public String getSignedstatus(){
			return this.signedstatus;
		}
		 public void setBackgroundunit(String backgroundunit){
			this.backgroundunit = backgroundunit;
		}
	  
		public String getBackgroundunit(){
			return this.backgroundunit;
		}
		 public void setBackgroundduty(String backgroundduty){
			this.backgroundduty = backgroundduty;
		}
	  
		public String getBackgroundduty(){
			return this.backgroundduty;
		}
		 public void setBackgroundappointmentdate(String backgroundappointmentdate){
			this.backgroundappointmentdate = backgroundappointmentdate;
		}
	  
		public String getBackgroundappointmentdate(){
			return this.backgroundappointmentdate;
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
