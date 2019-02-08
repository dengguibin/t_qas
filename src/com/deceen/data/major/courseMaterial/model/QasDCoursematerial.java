package	com.deceen.data.major.courseMaterial.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDCoursematerial.java   序号
* @Description: qas_d_coursematerial   
* @author upaths@gmail.com  
* @date 2017-11-23 16:07:12
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDCoursematerial extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //课程名称 
	private String courseid;
	 //教材名称（全称） 
	private String bookname;
	 //版本日期（年） 
	private String bookyear;
	 //出版社 
	private String bookpulish;
	 //第一作者 
	private String bookautor;
	 //教材性质 
	private String booknature;
	 //教材类型 
	private String booktype;
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
		 public void setCourseid(String courseid){
			this.courseid = courseid;
		}
	  
		public String getCourseid(){
			return this.courseid;
		}
		 public void setBookname(String bookname){
			this.bookname = bookname;
		}
	  
		public String getBookname(){
			return this.bookname;
		}
		 public void setBookyear(String bookyear){
			this.bookyear = bookyear;
		}
	  
		public String getBookyear(){
			return this.bookyear;
		}
		 public void setBookpulish(String bookpulish){
			this.bookpulish = bookpulish;
		}
	  
		public String getBookpulish(){
			return this.bookpulish;
		}
		 public void setBookautor(String bookautor){
			this.bookautor = bookautor;
		}
	  
		public String getBookautor(){
			return this.bookautor;
		}
		 public void setBooknature(String booknature){
			this.booknature = booknature;
		}
	  
		public String getBooknature(){
			return this.booknature;
		}
		 public void setBooktype(String booktype){
			this.booktype = booktype;
		}
	  
		public String getBooktype(){
			return this.booktype;
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
