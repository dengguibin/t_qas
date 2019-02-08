package	com.deceen.data.student.qualification.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDQualification.java   序号
* @Description: qas_d_qualification   
* @author upaths@gmail.com  
* @date 2017-11-24 10:17:24
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDQualification extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //专业方向 
	private String directionid;
	 //学生获取的符合专业面向职业资格证书<-->名称(全称) 
	private String certname;
	 //学生获取的符合专业面向职业资格证书<-->等级 
	private String certlevel;
	 //学生获取的符合专业面向职业资格证书<-->人数 
	private String certcount;
	 //学生获取的符合专业面向职业资格证书<-->发证机构 
	private String issuingdepartment;
	 //学生获取的符合专业面向职业资格证书<-->鉴定地点 
	private String identificationsite;
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
	
	//学生获取的符合专业面向职业资格证书<-->人数 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String certcountScope;
	
		 public String getCertcountScope() {
		return certcountScope;
	}

	public void setCertcountScope(String certcountScope) {
		this.certcountScope = certcountScope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setDirectionid(String directionid){
			this.directionid = directionid;
		}
	  
		public String getDirectionid(){
			return this.directionid;
		}
		 public void setCertname(String certname){
			this.certname = certname;
		}
	  
		public String getCertname(){
			return this.certname;
		}
		 public void setCertlevel(String certlevel){
			this.certlevel = certlevel;
		}
	  
		public String getCertlevel(){
			return this.certlevel;
		}
		 public void setCertcount(String certcount){
			this.certcount = certcount;
		}
	  
		public String getCertcount(){
			return this.certcount;
		}
		 public void setIssuingdepartment(String issuingdepartment){
			this.issuingdepartment = issuingdepartment;
		}
	  
		public String getIssuingdepartment(){
			return this.issuingdepartment;
		}
		 public void setIdentificationsite(String identificationsite){
			this.identificationsite = identificationsite;
		}
	  
		public String getIdentificationsite(){
			return this.identificationsite;
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
