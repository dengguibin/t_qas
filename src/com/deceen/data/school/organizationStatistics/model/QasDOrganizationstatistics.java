package	com.deceen.data.school.organizationStatistics.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDOrganizationstatistics.java   记录标识
* @Description: qas_d_organizationstatistics   
* @author upaths@gmail.com  
* @date 2017-11-22 17:43:07
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDOrganizationstatistics extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //机构 
	private String departmentid;
	 //教职工数<-->专职 
	private Integer partworknum;
	 //教职工数<-->兼职 
	private Integer fullworknum;
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
	
	 //教职工数<-->专职 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String partworknumScope;
	 //教职工数<-->兼职 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String fullworknumScope;
	
		 public String getPartworknumScope() {
		return partworknumScope;
	}

	public void setPartworknumScope(String partworknumScope) {
		this.partworknumScope = partworknumScope;
	}

	public String getFullworknumScope() {
		return fullworknumScope;
	}

	public void setFullworknumScope(String fullworknumScope) {
		this.fullworknumScope = fullworknumScope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setDepartmentid(String departmentid){
			this.departmentid = departmentid;
		}
	  
		public String getDepartmentid(){
			return this.departmentid;
		}
		 public void setPartworknum(Integer partworknum){
			this.partworknum = partworknum;
		}
	  
		public Integer getPartworknum(){
			return this.partworknum;
		}
		 public void setFullworknum(Integer fullworknum){
			this.fullworknum = fullworknum;
		}
	  
		public Integer getFullworknum(){
			return this.fullworknum;
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
