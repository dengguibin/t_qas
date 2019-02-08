package	com.deceen.data.student.associationAndRedCrossAward.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDAssociationandredcrossaward.java   记录标识
* @Description: qas_d_associationandredcrossaward   
* @author upaths@gmail.com  
* @date 2017-11-24 10:29:35
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDAssociationandredcrossaward extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //社团 
	private String communityid;
	 //项目名称(全称) 
	private String subjectname;
	 //获奖级别 
	private String awardlevel;
	 //获奖日期（年月） 
	private String awarddate;
	 //颁奖单位 
	private String awardingunit;
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
		 public void setCommunityid(String communityid){
			this.communityid = communityid;
		}
	  
		public String getCommunityid(){
			return this.communityid;
		}
		 public void setSubjectname(String subjectname){
			this.subjectname = subjectname;
		}
	  
		public String getSubjectname(){
			return this.subjectname;
		}
		 public void setAwardlevel(String awardlevel){
			this.awardlevel = awardlevel;
		}
	  
		public String getAwardlevel(){
			return this.awardlevel;
		}
		 public void setAwarddate(String awarddate){
			this.awarddate = awarddate;
		}
	  
		public String getAwarddate(){
			return this.awarddate;
		}
		 public void setAwardingunit(String awardingunit){
			this.awardingunit = awardingunit;
		}
	  
		public String getAwardingunit(){
			return this.awardingunit;
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
