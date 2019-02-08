/**
*/
package	com.deceen.diagnosereport.analy.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;
/**
 * 主要用于存储诊断报告路径
 * 
 * @author hanwenhai
 *
 */
@SuppressWarnings("serial")	
public class QasTDiagnosticinterdoc extends Pagination implements Serializable{ 	
	
	 //唯一标识 @PrimaryKey
	private String id;
	 //诊断报告id 
	private String diagnosticreportid;
	 //诊断对象Id 
	private String diagnosticobjid;
	 //诊断对象名称 
	private String diagnosticobjname;
	//文档导出路径
	private String wordurl;

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
	
	
	
	public String getWordurl() {
		return wordurl;
	}
	public void setWordurl(String wordurl) {
		this.wordurl = wordurl;
	}

}
