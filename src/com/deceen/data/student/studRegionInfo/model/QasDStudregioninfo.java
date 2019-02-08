package	com.deceen.data.student.studRegionInfo.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDStudregioninfo.java   记录标识
* @Description: qas_d_studregioninfo   
* @author upaths@gmail.com  
* @date 2017-11-24 10:33:04
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDStudregioninfo extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //在校生总数(人) 
	private Integer studentinschoolnum;
	 //其中<-->外省学生数（人） 
	private Integer otherprivincestudent;
	 //其中<-->西部地区学生数（人） 
	private Integer weststudent;
	 //其中<-->常住户口所在地为农村的学生数（人） 
	private Integer countrysidestudent;
	 //其中<-->贫困地区学生数（人） 
	private Integer poorstudent;
	 //其中<-->少数民族学生数（人） 
	private Integer minoritystudent;
	 //国际学生数（人） 
	private Integer internationalstudent;
	 //境外学生数（人） 
	private Integer overseastudent;
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
		 public void setStudentinschoolnum(Integer studentinschoolnum){
			this.studentinschoolnum = studentinschoolnum;
		}
	  
		public Integer getStudentinschoolnum(){
			return this.studentinschoolnum;
		}
		 public void setOtherprivincestudent(Integer otherprivincestudent){
			this.otherprivincestudent = otherprivincestudent;
		}
	  
		public Integer getOtherprivincestudent(){
			return this.otherprivincestudent;
		}
		 public void setWeststudent(Integer weststudent){
			this.weststudent = weststudent;
		}
	  
		public Integer getWeststudent(){
			return this.weststudent;
		}
		 public void setCountrysidestudent(Integer countrysidestudent){
			this.countrysidestudent = countrysidestudent;
		}
	  
		public Integer getCountrysidestudent(){
			return this.countrysidestudent;
		}
		 public void setPoorstudent(Integer poorstudent){
			this.poorstudent = poorstudent;
		}
	  
		public Integer getPoorstudent(){
			return this.poorstudent;
		}
		 public void setMinoritystudent(Integer minoritystudent){
			this.minoritystudent = minoritystudent;
		}
	  
		public Integer getMinoritystudent(){
			return this.minoritystudent;
		}
		 public void setInternationalstudent(Integer internationalstudent){
			this.internationalstudent = internationalstudent;
		}
	  
		public Integer getInternationalstudent(){
			return this.internationalstudent;
		}
		 public void setOverseastudent(Integer overseastudent){
			this.overseastudent = overseastudent;
		}
	  
		public Integer getOverseastudent(){
			return this.overseastudent;
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
