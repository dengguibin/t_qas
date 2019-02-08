package	com.deceen.data.teaching.majorSysInnovation.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDMajorsysinnovation.java   序号
* @Description: qas_d_majorsysinnovation   
* @author upaths@gmail.com  
* @date 2017-11-24 12:20:23
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDMajorsysinnovation extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //项目名称(全称) 
	private String subjectname;
	 //主要创新点 
	private String maininnovation;
	 //实施日期（年月） 
	private String implementationdate;
	 //主要成果	 
	private String mainachievement;
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
		 public void setMaininnovation(String maininnovation){
			this.maininnovation = maininnovation;
		}
	  
		public String getMaininnovation(){
			return this.maininnovation;
		}
		 public void setImplementationdate(String implementationdate){
			this.implementationdate = implementationdate;
		}
	  
		public String getImplementationdate(){
			return this.implementationdate;
		}
		 public void setMainachievement(String mainachievement){
			this.mainachievement = mainachievement;
		}
	  
		public String getMainachievement(){
			return this.mainachievement;
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
