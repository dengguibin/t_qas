package	com.deceen.data.teaching.filesOfTeachingManageMent.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDFilesofteachingmanagement.java   序号
* @Description: qas_d_filesofteachingmanagement   
* @author upaths@gmail.com  
* @date 2017-11-24 12:13:39
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDFilesofteachingmanagement extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //文件名称(全称)及文号 
	private String name;
	 //发布日期（年月） 
	private String publisheddate;
	 //发布部门	 
	private String publisheddepartment;
	 //变更情况（新增、修改、取消） 
	private String modify;
	 //变更日期（年月） 
	private String modifidate;
	 //负责部门 
	private String responsibledepartment;
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
		 public void setName(String name){
			this.name = name;
		}
	  
		public String getName(){
			return this.name;
		}
		 public void setPublisheddate(String publisheddate){
			this.publisheddate = publisheddate;
		}
	  
		public String getPublisheddate(){
			return this.publisheddate;
		}
		 public void setPublisheddepartment(String publisheddepartment){
			this.publisheddepartment = publisheddepartment;
		}
	  
		public String getPublisheddepartment(){
			return this.publisheddepartment;
		}
		 public void setModify(String modify){
			this.modify = modify;
		}
	  
		public String getModify(){
			return this.modify;
		}
		 public void setModifidate(String modifidate){
			this.modifidate = modifidate;
		}
	  
		public String getModifidate(){
			return this.modifidate;
		}
		 public void setResponsibledepartment(String responsibledepartment){
			this.responsibledepartment = responsibledepartment;
		}
	  
		public String getResponsibledepartment(){
			return this.responsibledepartment;
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
