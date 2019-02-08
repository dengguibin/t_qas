package	com.deceen.data.teacher.teacherPublishedPaper.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDTeacherpublishedpaper.java   序号
* @Description: qas_d_teacherpublishedpaper   
* @author upaths@gmail.com  
* @date 2017-11-23 12:33:51
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDTeacherpublishedpaper extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //教工名称 
	private String employeeid;
	 //公开出版著作与公开发表论文名称(全称) 
	private String name;
	 //出版社或杂志社 
	private String company;
	 //出版或发表日期（年月） 
	private String publisheddate;
	 //作者顺序 
	private String authororder;
	 //著作与论文分类 
	private String kind;
	 //核心或非核心论文 
	private String ismain;
	 //是否属于教研教改论文 
	private String isresearch;
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
		 public void setName(String name){
			this.name = name;
		}
	  
		public String getName(){
			return this.name;
		}
		 public void setCompany(String company){
			this.company = company;
		}
	  
		public String getCompany(){
			return this.company;
		}
		 public void setPublisheddate(String publisheddate){
			this.publisheddate = publisheddate;
		}
	  
		public String getPublisheddate(){
			return this.publisheddate;
		}
		 public void setAuthororder(String authororder){
			this.authororder = authororder;
		}
	  
		public String getAuthororder(){
			return this.authororder;
		}
		 public void setKind(String kind){
			this.kind = kind;
		}
	  
		public String getKind(){
			return this.kind;
		}
		 public void setIsmain(String ismain){
			this.ismain = ismain;
		}
	  
		public String getIsmain(){
			return this.ismain;
		}
		 public void setIsresearch(String isresearch){
			this.isresearch = isresearch;
		}
	  
		public String getIsresearch(){
			return this.isresearch;
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
