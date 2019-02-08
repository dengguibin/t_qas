package	com.deceen.data.student.dropoutList.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDDropoutlist.java   记录标识
* @Description: qas_d_dropoutlist   
* @author upaths@gmail.com  
* @date 2017-11-24 10:32:29
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDDropoutlist extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //班级名称 
	private String gradeid;
	 //学号 
	private String no;
	 //姓名 
	private String name;
	 //性别 
	private String sex;
	 //辍学原因 
	private String dropoutreson;
	 //辍学日期（年月） 
	private String dropoutdate;
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
		 public void setGradeid(String gradeid){
			this.gradeid = gradeid;
		}
	  
		public String getGradeid(){
			return this.gradeid;
		}
		 public void setNo(String no){
			this.no = no;
		}
	  
		public String getNo(){
			return this.no;
		}
		 public void setName(String name){
			this.name = name;
		}
	  
		public String getName(){
			return this.name;
		}
		 public void setSex(String sex){
			this.sex = sex;
		}
	  
		public String getSex(){
			return this.sex;
		}
		 public void setDropoutreson(String dropoutreson){
			this.dropoutreson = dropoutreson;
		}
	  
		public String getDropoutreson(){
			return this.dropoutreson;
		}
		 public void setDropoutdate(String dropoutdate){
			this.dropoutdate = dropoutdate;
		}
	  
		public String getDropoutdate(){
			return this.dropoutdate;
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
