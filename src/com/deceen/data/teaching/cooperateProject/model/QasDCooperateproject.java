package	com.deceen.data.teaching.cooperateProject.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDCooperateproject.java   序号
* @Description: qas_d_cooperateproject   
* @author upaths@gmail.com  
* @date 2017-11-24 12:25:18
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDCooperateproject extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //项目名称 
	private String projectname;
	 //专业方向 
	private String directionid;
	 //课题内容 
	private String content;
	 //合作企业名称 
	private String companyid;
	 //类别 
	private String projecttype;
	 //项目级别 
	private String grade;
	 //项目负责人(校方) 
	private String employeeid;
	 //立项部门 
	private String departmentid;
	 //立项文件名称、文号 
	private String file;
	 //是否横向课题 
	private String ishorizontal;
	 //金额（万元） 
	private Integer amount;
	 //开始时间 
	private Date starttime;
	 //结束时间	 
	private Date endtime;
	 //当前状态	 
	private String curstatus;
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
		 public void setProjectname(String projectname){
			this.projectname = projectname;
		}
	  
		public String getProjectname(){
			return this.projectname;
		}
		 public void setDirectionid(String directionid){
			this.directionid = directionid;
		}
	  
		public String getDirectionid(){
			return this.directionid;
		}
		 public void setContent(String content){
			this.content = content;
		}
	  
		public String getContent(){
			return this.content;
		}
		 public void setCompanyid(String companyid){
			this.companyid = companyid;
		}
	  
		public String getCompanyid(){
			return this.companyid;
		}
		 public void setProjecttype(String projecttype){
			this.projecttype = projecttype;
		}
	  
		public String getProjecttype(){
			return this.projecttype;
		}
		 public void setGrade(String grade){
			this.grade = grade;
		}
	  
		public String getGrade(){
			return this.grade;
		}
		 public void setEmployeeid(String employeeid){
			this.employeeid = employeeid;
		}
	  
		public String getEmployeeid(){
			return this.employeeid;
		}
		 public void setDepartmentid(String departmentid){
			this.departmentid = departmentid;
		}
	  
		public String getDepartmentid(){
			return this.departmentid;
		}
		 public void setFile(String file){
			this.file = file;
		}
	  
		public String getFile(){
			return this.file;
		}
		 public void setIshorizontal(String ishorizontal){
			this.ishorizontal = ishorizontal;
		}
	  
		public String getIshorizontal(){
			return this.ishorizontal;
		}
		 public void setAmount(Integer amount){
			this.amount = amount;
		}
	  
		public Integer getAmount(){
			return this.amount;
		}
		 public void setStarttime(Date starttime){
			this.starttime = starttime;
		}
	  
		public Date getStarttime(){
			return this.starttime;
		}
		 public void setEndtime(Date endtime){
			this.endtime = endtime;
		}
	  
		public Date getEndtime(){
			return this.endtime;
		}
		 public void setCurstatus(String curstatus){
			this.curstatus = curstatus;
		}
	  
		public String getCurstatus(){
			return this.curstatus;
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
