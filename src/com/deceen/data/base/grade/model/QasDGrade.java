package	com.deceen.data.base.grade.model;

import java.io.Serializable;
import java.util.Date;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDGrade.java   班级唯一标识
* @Description: qas_d_grade   
* @author upaths@gmail.com  
* @date 2017-11-22 15:41:25
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDGrade extends Pagination implements Serializable{ 	
	
	 //班级唯一标识 @PrimaryKey
	private String id;
	 //专业方向名称 
	private String directioniddirectionid;
	 //班级代码 
	private String gradecode;
	 //班级名称 
	private String gradename;
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
		 public void setDirectioniddirectionid(String directioniddirectionid){
			this.directioniddirectionid = directioniddirectionid;
		}
	  
		public String getDirectioniddirectionid(){
			return this.directioniddirectionid;
		}
		 public void setGradecode(String gradecode){
			this.gradecode = gradecode;
		}
	  
		public String getGradecode(){
			return this.gradecode;
		}
		 public void setGradename(String gradename){
			this.gradename = gradename;
		}
	  
		public String getGradename(){
			return this.gradename;
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
