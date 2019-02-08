package	com.deceen.data.teacher.teacherAward.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDTeacheraward.java   序号
* @Description: qas_d_teacheraward   
* @author upaths@gmail.com  
* @date 2017-11-23 12:32:07
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDTeacheraward extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //教工名称 
	private String employeeid;
	 //获奖日期（年月） 
	private String awarddate;
	 //获奖名称(全称) 
	private String awardname;
	 //级别 
	private String awardgrade;
	 //颁奖单位 
	private String awardingunit;
	 //是否主持 
	private String awardishost;
	 //获奖类别 
	private String awardtype;
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
		 public void setAwarddate(String awarddate){
			this.awarddate = awarddate;
		}
	  
		public String getAwarddate(){
			return this.awarddate;
		}
		 public void setAwardname(String awardname){
			this.awardname = awardname;
		}
	  
		public String getAwardname(){
			return this.awardname;
		}
		 public void setAwardgrade(String awardgrade){
			this.awardgrade = awardgrade;
		}
	  
		public String getAwardgrade(){
			return this.awardgrade;
		}
		 public void setAwardingunit(String awardingunit){
			this.awardingunit = awardingunit;
		}
	  
		public String getAwardingunit(){
			return this.awardingunit;
		}
		 public void setAwardishost(String awardishost){
			this.awardishost = awardishost;
		}
	  
		public String getAwardishost(){
			return this.awardishost;
		}
		 public void setAwardtype(String awardtype){
			this.awardtype = awardtype;
		}
	  
		public String getAwardtype(){
			return this.awardtype;
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
