/**
*/
package	com.deceen.diagnosereport.analy.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasTDiagnosticindicatorparameters.java   唯一标识
* @Description: qas_t_diagnosticindicatorparameters   
* @author upaths@gmail.com  
* @date 2017-12-6 11:23:46
* @version V1.0   
*/
@SuppressWarnings("serial")
public class QasTDiagnosticindicatorparameters extends Pagination implements Serializable{ 	
	
	 //唯一标识 @PrimaryKey
	private String id;
	 // 
	private String diagnosticindicatorid;
	 //参数名称 
	private String parametername;
	 //诊断分数 
	private Integer diagnosticscore;
	 //住户Id 
	private String tenantid;

		 public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setDiagnosticindicatorid(String diagnosticindicatorid){
			this.diagnosticindicatorid = diagnosticindicatorid;
		}
	  
		public String getDiagnosticindicatorid(){
			return this.diagnosticindicatorid;
		}
		 public void setParametername(String parametername){
			this.parametername = parametername;
		}
	  
		public String getParametername(){
			return this.parametername;
		}
		 public void setDiagnosticscore(Integer diagnosticscore){
			this.diagnosticscore = diagnosticscore;
		}
	  
		public Integer getDiagnosticscore(){
			return this.diagnosticscore;
		}
		 public void setTenantid(String tenantid){
			this.tenantid = tenantid;
		}
	  
		public String getTenantid(){
			return this.tenantid;
		}
}
