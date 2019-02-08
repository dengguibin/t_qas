package	com.deceen.data.teacher.teacherSecondment.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDTeachersecondment.java   序号
* @Description: qas_d_teachersecondment   
* @author upaths@gmail.com  
* @date 2017-11-23 14:56:44
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDTeachersecondment extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //教工名称 
	private String employeeid;
	 //单位名称(全称)	 
	private String secondmentdepartmentname;
	 //岗位 
	private String secondmentunit;
	 //时间（天） 
	private Integer secondmentday;
	 //学时数（小时） 
	private Integer secondmenthour;
	 //派出部门 
	private String secondmentdispatcheddepartment;
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
		 public void setSecondmentdepartmentname(String secondmentdepartmentname){
			this.secondmentdepartmentname = secondmentdepartmentname;
		}
	  
		public String getSecondmentdepartmentname(){
			return this.secondmentdepartmentname;
		}
		 public void setSecondmentunit(String secondmentunit){
			this.secondmentunit = secondmentunit;
		}
	  
		public String getSecondmentunit(){
			return this.secondmentunit;
		}
		 public void setSecondmentday(Integer secondmentday){
			this.secondmentday = secondmentday;
		}
	  
		public Integer getSecondmentday(){
			return this.secondmentday;
		}
		 public void setSecondmenthour(Integer secondmenthour){
			this.secondmenthour = secondmenthour;
		}
	  
		public Integer getSecondmenthour(){
			return this.secondmenthour;
		}
		 public void setSecondmentdispatcheddepartment(String secondmentdispatcheddepartment){
			this.secondmentdispatcheddepartment = secondmentdispatcheddepartment;
		}
	  
		public String getSecondmentdispatcheddepartment(){
			return this.secondmentdispatcheddepartment;
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
