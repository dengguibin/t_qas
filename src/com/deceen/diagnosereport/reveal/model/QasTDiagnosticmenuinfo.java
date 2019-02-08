package	com.deceen.diagnosereport.reveal.model;

import com.upath.plat.auth.model.TRmsMenuinfo;
/**
* 
* @ClassName: QasTDiagnosticmenuinfo.java   菜单ID
* @Description: qas_t_diagnosticmenuinfo   
* @author upaths@gmail.com  
* @date 2017-12-9 10:33:46
* @version V1.0   
*/
@SuppressWarnings("serial")
public class QasTDiagnosticmenuinfo extends TRmsMenuinfo { 	
	
	private String diagnosticintermediaryid;	//诊断中介id

	public void setDiagnosticintermediaryid(String diagnosticintermediaryid) {
		this.diagnosticintermediaryid = diagnosticintermediaryid;
	}

	public String getDiagnosticintermediaryid() {
		return this.diagnosticintermediaryid;
	}
}
