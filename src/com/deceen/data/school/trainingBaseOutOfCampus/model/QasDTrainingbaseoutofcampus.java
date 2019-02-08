package	com.deceen.data.school.trainingBaseOutOfCampus.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDTrainingbaseoutofcampus.java   实践基地唯一标识
* @Description: qas_d_trainingbaseoutofcampus   
* @author upaths@gmail.com  
* @date 2017-11-22 17:58:05
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDTrainingbaseoutofcampus extends Pagination implements Serializable{ 	
	
	 //实践基地唯一标识 @PrimaryKey
	private String id;
	 //基地名称(全称) 
	private String name;
	 //依托单位 
	private String supportunit;
	 //建立日期（年月） 
	private String establishdate;
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
		 public void setSupportunit(String supportunit){
			this.supportunit = supportunit;
		}
	  
		public String getSupportunit(){
			return this.supportunit;
		}
		 public void setEstablishdate(String establishdate){
			this.establishdate = establishdate;
		}
	  
		public String getEstablishdate(){
			return this.establishdate;
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
