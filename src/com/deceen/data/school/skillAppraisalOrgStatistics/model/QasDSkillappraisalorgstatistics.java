package	com.deceen.data.school.skillAppraisalOrgStatistics.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDSkillappraisalorgstatistics.java   记录唯一标识
* @Description: qas_d_skillappraisalorgstatistics   
* @author upaths@gmail.com  
* @date 2017-11-22 17:59:47
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDSkillappraisalorgstatistics extends Pagination implements Serializable{ 	
	
	 //记录唯一标识 @PrimaryKey
	private String id;
	 //职业技能鉴定站（所） 
	private String skillappraisalorgid;
	 //鉴定数（人次）<-->社会 
	private Integer society;
	 //鉴定数（人次）<-->在校生 
	private Integer studentinschool;
	 //工种/证书名称(全称) 
	private String certificate;
	 //工种/证书等级 
	private String level;
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
	
	
	 //鉴定数（人次）<-->社会 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String societyScope;
	 //鉴定数（人次）<-->在校生 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String studentinschoolScope;
	
	
		 public String getSocietyScope() {
		return societyScope;
	}

	public void setSocietyScope(String societyScope) {
		this.societyScope = societyScope;
	}

	public String getStudentinschoolScope() {
		return studentinschoolScope;
	}

	public void setStudentinschoolScope(String studentinschoolScope) {
		this.studentinschoolScope = studentinschoolScope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setSkillappraisalorgid(String skillappraisalorgid){
			this.skillappraisalorgid = skillappraisalorgid;
		}
	  
		public String getSkillappraisalorgid(){
			return this.skillappraisalorgid;
		}
		 public void setSociety(Integer society){
			this.society = society;
		}
	  
		public Integer getSociety(){
			return this.society;
		}
		 public void setStudentinschool(Integer studentinschool){
			this.studentinschool = studentinschool;
		}
	  
		public Integer getStudentinschool(){
			return this.studentinschool;
		}
		 public void setCertificate(String certificate){
			this.certificate = certificate;
		}
	  
		public String getCertificate(){
			return this.certificate;
		}
		 public void setLevel(String level){
			this.level = level;
		}
	  
		public String getLevel(){
			return this.level;
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
