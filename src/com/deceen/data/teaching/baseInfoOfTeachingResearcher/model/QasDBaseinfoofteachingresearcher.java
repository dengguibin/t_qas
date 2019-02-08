package	com.deceen.data.teaching.baseInfoOfTeachingResearcher.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDBaseinfoofteachingresearcher.java   序号
* @Description: qas_d_baseinfoofteachingresearcher   
* @author upaths@gmail.com  
* @date 2017-11-24 12:15:52
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDBaseinfoofteachingresearcher extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //教工名称 
	private String employeeid;
	 //专业领域 
	private String specialarea;
	 //教研成果<-->数量（项） 
	private Integer researchcount;
	 //教研成果<-->最高等级 
	private String researchlevel;
	 //教研成果<-->合作情况 
	private String researchcooperation;
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
		 public void setSpecialarea(String specialarea){
			this.specialarea = specialarea;
		}
	  
		public String getSpecialarea(){
			return this.specialarea;
		}
		 public void setResearchcount(Integer researchcount){
			this.researchcount = researchcount;
		}
	  
		public Integer getResearchcount(){
			return this.researchcount;
		}
		 public void setResearchlevel(String researchlevel){
			this.researchlevel = researchlevel;
		}
	  
		public String getResearchlevel(){
			return this.researchlevel;
		}
		 public void setResearchcooperation(String researchcooperation){
			this.researchcooperation = researchcooperation;
		}
	  
		public String getResearchcooperation(){
			return this.researchcooperation;
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
