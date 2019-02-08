package	com.deceen.data.teacher.teacherResearch.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDTeacherresearch.java   序号
* @Description: qas_d_teacherresearch   
* @author upaths@gmail.com  
* @date 2017-11-23 12:33:15
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDTeacherresearch extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //教工名称 
	private String employeeid;
	 //课题性质 
	private String researchnature;
	 //课题分类 
	private String researchtype;
	 //课题名称 
	private String researchname;
	 //是否横向课题 
	private String researchishorizontalissue;
	 //课题级别 
	private String researchlevel;
	 //立项日期（年月） 
	private String researchestablishdate;
	 //经费来源 
	private String researchfund;
	 //到款金额（元） 
	private Integer researchamountreceived;
	 //完成人顺序 
	private String researchcompleteorder;
	 //课题来源 
	private String researchsource;
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
		 public void setResearchnature(String researchnature){
			this.researchnature = researchnature;
		}
	  
		public String getResearchnature(){
			return this.researchnature;
		}
		 public void setResearchtype(String researchtype){
			this.researchtype = researchtype;
		}
	  
		public String getResearchtype(){
			return this.researchtype;
		}
		 public void setResearchname(String researchname){
			this.researchname = researchname;
		}
	  
		public String getResearchname(){
			return this.researchname;
		}
		 public void setResearchishorizontalissue(String researchishorizontalissue){
			this.researchishorizontalissue = researchishorizontalissue;
		}
	  
		public String getResearchishorizontalissue(){
			return this.researchishorizontalissue;
		}
		 public void setResearchlevel(String researchlevel){
			this.researchlevel = researchlevel;
		}
	  
		public String getResearchlevel(){
			return this.researchlevel;
		}
		 public void setResearchestablishdate(String researchestablishdate){
			this.researchestablishdate = researchestablishdate;
		}
	  
		public String getResearchestablishdate(){
			return this.researchestablishdate;
		}
		 public void setResearchfund(String researchfund){
			this.researchfund = researchfund;
		}
	  
		public String getResearchfund(){
			return this.researchfund;
		}
		 public void setResearchamountreceived(Integer researchamountreceived){
			this.researchamountreceived = researchamountreceived;
		}
	  
		public Integer getResearchamountreceived(){
			return this.researchamountreceived;
		}
		 public void setResearchcompleteorder(String researchcompleteorder){
			this.researchcompleteorder = researchcompleteorder;
		}
	  
		public String getResearchcompleteorder(){
			return this.researchcompleteorder;
		}
		 public void setResearchsource(String researchsource){
			this.researchsource = researchsource;
		}
	  
		public String getResearchsource(){
			return this.researchsource;
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
