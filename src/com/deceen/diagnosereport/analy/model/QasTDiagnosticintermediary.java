/**
*/
package	com.deceen.diagnosereport.analy.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasTDiagnosticintermediary.java   唯一标识
* @Description: qas_t_diagnosticintermediary   
* @author upaths@gmail.com  
* @date 2017-12-6 11:23:46
* @version V1.0   
*/
@SuppressWarnings("serial")	
public class QasTDiagnosticintermediary extends Pagination implements Serializable{ 	
	
	 //唯一标识 @PrimaryKey
	private String id;
	 //诊断报告id 
	private String diagnosticreportid;
	 //报告概述id 
	private String diagnosticreportsummryid;
	 //菜单根id 
	private Integer diagnosticmenuinfocdid;
	 //诊断对象Id 
	private String diagnosticobjid;
	 //诊断对象名称 
	private String diagnosticobjname;
	 //住户Id 
	private String tenantid;
	
		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setDiagnosticreportid(String diagnosticreportid){
			this.diagnosticreportid = diagnosticreportid;
		}
	  
		public String getDiagnosticreportid(){
			return this.diagnosticreportid;
		}
		 public void setDiagnosticreportsummryid(String diagnosticreportsummryid){
			this.diagnosticreportsummryid = diagnosticreportsummryid;
		}
	  
		public String getDiagnosticreportsummryid(){
			return this.diagnosticreportsummryid;
		}
		 public void setDiagnosticmenuinfocdid(Integer diagnosticmenuinfocdid){
			this.diagnosticmenuinfocdid = diagnosticmenuinfocdid;
		}
	  
		public Integer getDiagnosticmenuinfocdid(){
			return this.diagnosticmenuinfocdid;
		}
		 public void setDiagnosticobjid(String diagnosticobjid){
			this.diagnosticobjid = diagnosticobjid;
		}
	  
		public String getDiagnosticobjid(){
			return this.diagnosticobjid;
		}
		 public void setDiagnosticobjname(String diagnosticobjname){
			this.diagnosticobjname = diagnosticobjname;
		}
	  
		public String getDiagnosticobjname(){
			return this.diagnosticobjname;
		}
		 public void setTenantid(String tenantid){
			this.tenantid = tenantid;
		}
	  
		public String getTenantid(){
			return this.tenantid;
		}
		
		//文档导出路径
		private String wordurl;
		public String getWordurl() {
			return wordurl;
		}
		public void setWordurl(String wordurl) {
			this.wordurl = wordurl;
		}

}
