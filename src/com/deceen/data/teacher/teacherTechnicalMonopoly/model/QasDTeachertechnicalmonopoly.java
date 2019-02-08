package	com.deceen.data.teacher.teacherTechnicalMonopoly.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDTeachertechnicalmonopoly.java   序号
* @Description: qas_d_teachertechnicalmonopoly   
* @author upaths@gmail.com  
* @date 2017-11-23 12:32:42
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDTeachertechnicalmonopoly extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //教工名称 
	private String employeeid;
	 //专利类别 
	private String technicalmonopolytype;
	 //获得日期（年月） 
	private String technicalmonopolyreceivedate;
	 //技术专利（发明）名称(全称) 
	private String technicalmonopolyname;
	 //技术专利（发明）编号 
	private String technicalmonopolycode;
	 //是否主持 
	private String technicalmonopolyishost;
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
		 public void setTechnicalmonopolytype(String technicalmonopolytype){
			this.technicalmonopolytype = technicalmonopolytype;
		}
	  
		public String getTechnicalmonopolytype(){
			return this.technicalmonopolytype;
		}
		 public void setTechnicalmonopolyreceivedate(String technicalmonopolyreceivedate){
			this.technicalmonopolyreceivedate = technicalmonopolyreceivedate;
		}
	  
		public String getTechnicalmonopolyreceivedate(){
			return this.technicalmonopolyreceivedate;
		}
		 public void setTechnicalmonopolyname(String technicalmonopolyname){
			this.technicalmonopolyname = technicalmonopolyname;
		}
	  
		public String getTechnicalmonopolyname(){
			return this.technicalmonopolyname;
		}
		 public void setTechnicalmonopolycode(String technicalmonopolycode){
			this.technicalmonopolycode = technicalmonopolycode;
		}
	  
		public String getTechnicalmonopolycode(){
			return this.technicalmonopolycode;
		}
		 public void setTechnicalmonopolyishost(String technicalmonopolyishost){
			this.technicalmonopolyishost = technicalmonopolyishost;
		}
	  
		public String getTechnicalmonopolyishost(){
			return this.technicalmonopolyishost;
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
