package	com.deceen.data.school.practiceBaseInCampus.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDPracticebaseincampus.java   实践基地唯一标识
* @Description: qas_d_practicebaseincampus   
* @author upaths@gmail.com  
* @date 2017-11-22 17:51:44
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDPracticebaseincampus extends Pagination implements Serializable{ 	
	
	 //实践基地唯一标识 @PrimaryKey
	private String id;
	 //实践基地名称 
	private String name;
	 //实训基地项目<-->立项部门 
	private String supportdepartment;
	 //实训基地项目<-->批准日期（年） 
	private String approvaldate;
	 //建筑面积（平方米） 
	private Integer constructionarea;
	 //是否校企共建 
	private String iscoconstruction;
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
	
	 //建筑面积（平方米） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String constructionareaScope;

		 public String getConstructionareaScope() {
		return constructionareaScope;
	}

	public void setConstructionareaScope(String constructionareaScope) {
		this.constructionareaScope = constructionareaScope;
	}

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
		 public void setSupportdepartment(String supportdepartment){
			this.supportdepartment = supportdepartment;
		}
	  
		public String getSupportdepartment(){
			return this.supportdepartment;
		}
		 public void setApprovaldate(String approvaldate){
			this.approvaldate = approvaldate;
		}
	  
		public String getApprovaldate(){
			return this.approvaldate;
		}
		 public void setConstructionarea(Integer constructionarea){
			this.constructionarea = constructionarea;
		}
	  
		public Integer getConstructionarea(){
			return this.constructionarea;
		}
		 public void setIscoconstruction(String iscoconstruction){
			this.iscoconstruction = iscoconstruction;
		}
	  
		public String getIscoconstruction(){
			return this.iscoconstruction;
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
