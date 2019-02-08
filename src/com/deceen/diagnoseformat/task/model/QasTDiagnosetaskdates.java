package	com.deceen.diagnoseformat.task.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasTDiagnosetaskdates.java   
* @Description: qas_t_diagnosetaskdates   
* @author upaths@gmail.com  
* @date 2017-11-20 18:39:49
* @version V1.0   
*/
@SuppressWarnings("serial")
public class QasTDiagnosetaskdates extends Pagination implements Serializable{ 	
	
	// @PrimaryKey
	private String id;
	//任务Id 
	private String diagnosetaskid;
	//诊断状态 
	private Integer diagnosestatus;
	//任务执行日期 
	private Date executedate;
	//诊断对应时间区间 
	private String diagnosefortime;
	//租户 
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
	public void setDiagnosestatus(Integer diagnosestatus){
		this.diagnosestatus = diagnosestatus;
	}
  
	public Integer getDiagnosestatus(){
		return this.diagnosestatus;
	}
	public void setExecutedate(Date executedate){
		this.executedate = executedate;
	}
  
	public Date getExecutedate(){
		return this.executedate;
	}
	public void setDiagnosefortime(String diagnosefortime){
		this.diagnosefortime = diagnosefortime;
	}
  
	public String getDiagnosefortime(){
		return this.diagnosefortime;
	}
	public void setTenantid(String tenantid){
		this.tenantid = tenantid;
	}
  
	public String getTenantid(){
		return this.tenantid;
	}
}
