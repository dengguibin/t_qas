package	com.deceen.data.major.majorLeader.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDMajorleader.java   序号
* @Description: qas_d_majorleader   
* @author upaths@gmail.com  
* @date 2017-11-23 16:06:36
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDMajorleader extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //专业 
	private String majorid;
	 //教工名称 
	private String employeeid;
	 //担任专业负责人工作年限（年） 
	private Integer headyear;
	 //担任专业带头人工作年限（年） 
	private Integer leaderyear;
	 //代表性科研成果<-->项目名称 
	private String projectname;
	 //代表性科研成果<-->项目简介 
	private String projectsummary;
	 //代表性科研成果<-->获奖等级	 
	private String projectaward;
	 //代表性科研成果<-->获取日期(年月) 
	private String awarddate;
	 //代表性科研成果<-->合作情况 
	private String coopration;
	 //专业领军人才 
	private String ismajorleading;
	 //是否专业带头人 
	private String ismajorleader;
	 //是否专业负责人 
	private String ismajorhead;
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
		 public void setMajorid(String majorid){
			this.majorid = majorid;
		}
	  
		public String getMajorid(){
			return this.majorid;
		}
		 public void setEmployeeid(String employeeid){
			this.employeeid = employeeid;
		}
	  
		public String getEmployeeid(){
			return this.employeeid;
		}
		 public void setHeadyear(Integer headyear){
			this.headyear = headyear;
		}
	  
		public Integer getHeadyear(){
			return this.headyear;
		}
		 public void setLeaderyear(Integer leaderyear){
			this.leaderyear = leaderyear;
		}
	  
		public Integer getLeaderyear(){
			return this.leaderyear;
		}
		 public void setProjectname(String projectname){
			this.projectname = projectname;
		}
	  
		public String getProjectname(){
			return this.projectname;
		}
		 public void setProjectsummary(String projectsummary){
			this.projectsummary = projectsummary;
		}
	  
		public String getProjectsummary(){
			return this.projectsummary;
		}
		 public void setProjectaward(String projectaward){
			this.projectaward = projectaward;
		}
	  
		public String getProjectaward(){
			return this.projectaward;
		}
		 public void setAwarddate(String awarddate){
			this.awarddate = awarddate;
		}
	  
		public String getAwarddate(){
			return this.awarddate;
		}
		 public void setCoopration(String coopration){
			this.coopration = coopration;
		}
	  
		public String getCoopration(){
			return this.coopration;
		}
		 public void setIsmajorleading(String ismajorleading){
			this.ismajorleading = ismajorleading;
		}
	  
		public String getIsmajorleading(){
			return this.ismajorleading;
		}
		 public void setIsmajorleader(String ismajorleader){
			this.ismajorleader = ismajorleader;
		}
	  
		public String getIsmajorleader(){
			return this.ismajorleader;
		}
		 public void setIsmajorhead(String ismajorhead){
			this.ismajorhead = ismajorhead;
		}
	  
		public String getIsmajorhead(){
			return this.ismajorhead;
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
