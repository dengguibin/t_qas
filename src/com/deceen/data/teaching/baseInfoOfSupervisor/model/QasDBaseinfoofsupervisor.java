package	com.deceen.data.teaching.baseInfoOfSupervisor.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDBaseinfoofsupervisor.java   序号
* @Description: qas_d_baseinfoofsupervisor   
* @author upaths@gmail.com  
* @date 2017-11-24 12:15:23
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDBaseinfoofsupervisor extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //教工名称 
	private String employeeid;
	 //专业领域 
	private String specialarea;
	 //周工作时数（小时） 
	private Integer hoursperweek;
	 //教龄（年）  
	private Integer teachingyear;
	 //职称 
	private String duty;
	 //来源 
	private String source;
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
		 public void setHoursperweek(Integer hoursperweek){
			this.hoursperweek = hoursperweek;
		}
	  
		public Integer getHoursperweek(){
			return this.hoursperweek;
		}
		 public void setTeachingyear(Integer teachingyear){
			this.teachingyear = teachingyear;
		}
	  
		public Integer getTeachingyear(){
			return this.teachingyear;
		}
		 public void setDuty(String duty){
			this.duty = duty;
		}
	  
		public String getDuty(){
			return this.duty;
		}
		 public void setSource(String source){
			this.source = source;
		}
	  
		public String getSource(){
			return this.source;
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
