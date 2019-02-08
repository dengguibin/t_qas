package	com.deceen.data.base.student.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDStudent.java   学生唯一标识
* @Description: qas_d_student   
* @author upaths@gmail.com  
* @date 2017-11-25 10:28:59
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDStudent extends Pagination implements Serializable{ 	
	
	 //学生唯一标识 @PrimaryKey
	private String id;
	 //班级名称 
	private String gradeid;
	 //学号 
	private String no;
	 //姓名 
	private String name;
	 //性别 
	private String sex;
	 //民族 
	private String nation;
	 //电子邮箱 
	private String email;
	 //出生日期 
	private String birthday;
	 //生源地 
	private String birthplace;
	 //来自军队 
	private String fromarmy;
	 //招生方式 
	private String enrollment;
	 //生源类型 
	private String typeofstudent;
	 //是否常住户口在农村 
	private String isresidentsincountry;
	 //是否订单（定向）培养 
	private String isspecialtraining;
	 //是否建档立卡贫困家庭	 
	private String ispovertyfamily;
	 //年级 
	private String grade;
	 //学制 
	private String lengthofschooling;
	 //入学日期（年月） 
	private String admissiondate;
	 //是否毕业 
	private String isgraduation;
	 //欠费金额（元） 
	private Integer arrearage;
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
		 public void setGradeid(String gradeid){
			this.gradeid = gradeid;
		}
	  
		public String getGradeid(){
			return this.gradeid;
		}
		 public void setNo(String no){
			this.no = no;
		}
	  
		public String getNo(){
			return this.no;
		}
		 public void setName(String name){
			this.name = name;
		}
	  
		public String getName(){
			return this.name;
		}
		 public void setSex(String sex){
			this.sex = sex;
		}
	  
		public String getSex(){
			return this.sex;
		}
		 public void setNation(String nation){
			this.nation = nation;
		}
	  
		public String getNation(){
			return this.nation;
		}
		 public void setEmail(String email){
			this.email = email;
		}
	  
		public String getEmail(){
			return this.email;
		}
		 public void setBirthday(String birthday){
			this.birthday = birthday;
		}
	  
		public String getBirthday(){
			return this.birthday;
		}
		 public void setBirthplace(String birthplace){
			this.birthplace = birthplace;
		}
	  
		public String getBirthplace(){
			return this.birthplace;
		}
		 public void setFromarmy(String fromarmy){
			this.fromarmy = fromarmy;
		}
	  
		public String getFromarmy(){
			return this.fromarmy;
		}
		 public void setEnrollment(String enrollment){
			this.enrollment = enrollment;
		}
	  
		public String getEnrollment(){
			return this.enrollment;
		}
		 public void setTypeofstudent(String typeofstudent){
			this.typeofstudent = typeofstudent;
		}
	  
		public String getTypeofstudent(){
			return this.typeofstudent;
		}
		 public void setIsresidentsincountry(String isresidentsincountry){
			this.isresidentsincountry = isresidentsincountry;
		}
	  
		public String getIsresidentsincountry(){
			return this.isresidentsincountry;
		}
		 public void setIsspecialtraining(String isspecialtraining){
			this.isspecialtraining = isspecialtraining;
		}
	  
		public String getIsspecialtraining(){
			return this.isspecialtraining;
		}
		 public void setIspovertyfamily(String ispovertyfamily){
			this.ispovertyfamily = ispovertyfamily;
		}
	  
		public String getIspovertyfamily(){
			return this.ispovertyfamily;
		}
		 public void setGrade(String grade){
			this.grade = grade;
		}
	  
		public String getGrade(){
			return this.grade;
		}
		 public void setLengthofschooling(String lengthofschooling){
			this.lengthofschooling = lengthofschooling;
		}
	  
		public String getLengthofschooling(){
			return this.lengthofschooling;
		}
		 public void setAdmissiondate(String admissiondate){
			this.admissiondate = admissiondate;
		}
	  
		public String getAdmissiondate(){
			return this.admissiondate;
		}
		 public void setIsgraduation(String isgraduation){
			this.isgraduation = isgraduation;
		}
	  
		public String getIsgraduation(){
			return this.isgraduation;
		}
		 public void setArrearage(Integer arrearage){
			this.arrearage = arrearage;
		}
	  
		public Integer getArrearage(){
			return this.arrearage;
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
