package	com.deceen.data.teaching.scholarship.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDScholarship.java   序号
* @Description: qas_d_scholarship   
* @author upaths@gmail.com  
* @date 2017-11-24 12:19:49
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDScholarship extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //项目名称(全称) 
	private String subjectname;
	 //项目种类 
	private String subjecttype;
	 //奖助范围 
	private String rangeofreward;
	 //奖助人数 
	private Integer rewardnum;
	 //奖助金额（万元） 
	private Integer rewardamount;
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
		 public void setSubjectname(String subjectname){
			this.subjectname = subjectname;
		}
	  
		public String getSubjectname(){
			return this.subjectname;
		}
		 public void setSubjecttype(String subjecttype){
			this.subjecttype = subjecttype;
		}
	  
		public String getSubjecttype(){
			return this.subjecttype;
		}
		 public void setRangeofreward(String rangeofreward){
			this.rangeofreward = rangeofreward;
		}
	  
		public String getRangeofreward(){
			return this.rangeofreward;
		}
		 public void setRewardnum(Integer rewardnum){
			this.rewardnum = rewardnum;
		}
	  
		public Integer getRewardnum(){
			return this.rewardnum;
		}
		 public void setRewardamount(Integer rewardamount){
			this.rewardamount = rewardamount;
		}
	  
		public Integer getRewardamount(){
			return this.rewardamount;
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
