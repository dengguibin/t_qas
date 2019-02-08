package	com.deceen.data.major.majorCourse.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDMajorcourse.java   序号
* @Description: qas_d_majorcourse   
* @author upaths@gmail.com  
* @date 2017-11-23 16:07:46
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDMajorcourse extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //专业方向 
	private String directionid;
	 //课程名称 
	private String courseid;
	 //课程性质 
	private String coursenature;
	 //教学计划规定课时数（学时） 
	private Integer planhours;
	 //实践课课时数 
	private Integer normalhours;
	 //授课年级 
	private String classgrade;
	 //主要授课地点 
	private String classaddress;
	 //主要授课方式 
	private String classtype;
	 //考试/考核主要方法 
	private String examemethod;
	 //课证融通课程 
	private String papertocourse;
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
		 public void setCoursenature(String coursenature){
			this.coursenature = coursenature;
		}
	  
		public String getCoursenature(){
			return this.coursenature;
		}
		 public void setPlanhours(Integer planhours){
			this.planhours = planhours;
		}
	  
		public Integer getPlanhours(){
			return this.planhours;
		}
		 public void setNormalhours(Integer normalhours){
			this.normalhours = normalhours;
		}
	  
		public Integer getNormalhours(){
			return this.normalhours;
		}
		 public void setClassgrade(String classgrade){
			this.classgrade = classgrade;
		}
	  
		public String getClassgrade(){
			return this.classgrade;
		}
		 public void setClassaddress(String classaddress){
			this.classaddress = classaddress;
		}
	  
		public String getClassaddress(){
			return this.classaddress;
		}
		 public void setClasstype(String classtype){
			this.classtype = classtype;
		}
	  
		public String getClasstype(){
			return this.classtype;
		}
		 public void setExamemethod(String examemethod){
			this.examemethod = examemethod;
		}
	  
		public String getExamemethod(){
			return this.examemethod;
		}
		 public void setPapertocourse(String papertocourse){
			this.papertocourse = papertocourse;
		}
	  
		public String getPapertocourse(){
			return this.papertocourse;
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
