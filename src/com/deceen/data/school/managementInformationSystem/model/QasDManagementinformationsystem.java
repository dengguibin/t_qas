package	com.deceen.data.school.managementInformationSystem.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDManagementinformationsystem.java   信息系统唯一标识
* @Description: qas_d_managementinformationsystem   
* @author upaths@gmail.com  
* @date 2017-11-22 17:50:47
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDManagementinformationsystem extends Pagination implements Serializable{ 	
	
	 //信息系统唯一标识 @PrimaryKey
	private String id;
	 //类型 
	private String type;
	 //系统名称(全称) 
	private String systemname;
	 //来源 
	private String source;
	 //开发单位名称(全称) 
	private String developmentunit;
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
		 public void setType(String type){
			this.type = type;
		}
	  
		public Object getType(){
			return this.type;
		}
		 public void setSystemname(String systemname){
			this.systemname = systemname;
		}
	  
		public Object getSystemname(){
			return this.systemname;
		}
		 public void setSource(String source){
			this.source = source;
		}
	  
		public Object getSource(){
			return this.source;
		}
		 public void setDevelopmentunit(String developmentunit){
			this.developmentunit = developmentunit;
		}
	  
		public Object getDevelopmentunit(){
			return this.developmentunit;
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
