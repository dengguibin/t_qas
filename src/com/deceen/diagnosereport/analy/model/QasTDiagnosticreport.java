/**
*/
package	com.deceen.diagnosereport.analy.model;

import java.io.Serializable;
import java.util.Date;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasTDiagnosticreport.java   唯一标识
* @Description: qas_t_diagnosticreport   
* @author upaths@gmail.com  
* @date 2017-12-6 11:23:46
* @version V1.0   
*/
@SuppressWarnings("serial")	
public class QasTDiagnosticreport extends Pagination implements Serializable{ 	
	
	 //唯一标识 @PrimaryKey
	private String id;
	 //诊断任务Id 
	private String diagnosetaskid;
	 //诊断数据时间 
	private String diagnosedatatime;
	 //诊断方式：1手动，2自动 
	private Integer diagnoseway;
	 //创建人 
	private String createdby;
	 //创建时间 
	private Date createdtime;
	 //修改人 
	private String updatedby;
	 //修改时间 
	private Date updatedtime;
	 //住户Id 
	private String tenantid;
	

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setDiagnosetaskid(String diagnosetaskid){
			this.diagnosetaskid = diagnosetaskid;
		}
	  
		public String getDiagnosetaskid(){
			return this.diagnosetaskid;
		}
		 public void setDiagnosedatatime(String diagnosedatatime){
			this.diagnosedatatime = diagnosedatatime;
		}
	  
		public String getDiagnosedatatime(){
			return this.diagnosedatatime;
		}
		 public void setDiagnoseway(Integer diagnoseway){
			this.diagnoseway = diagnoseway;
		}
	  
		public Integer getDiagnoseway(){
			return this.diagnoseway;
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
}
