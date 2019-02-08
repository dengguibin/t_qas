package	com.deceen.diagnoseformat.task.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasTDiagnosetaskobj.java   
* @Description: qas_t_diagnosetaskobj   
* @author upaths@gmail.com  
* @date 2017-12-6 14:43:56
* @version V1.0   
*/
@SuppressWarnings("serial")
public class QasTDiagnosetaskobj extends Pagination implements Serializable{ 	
	
	// @PrimaryKey
	private String id;
	// 诊断任务Id
	private String diagnosetaskid;
	// 诊断对象Id
	private String diagnoseobjid;
	// 诊断对象名称
	private String diagnoseobjname;
	// 诊断对象类型
	private String diagnoseobjidtype;
	// 租户
	private String tenantid;
	
	private String parentName;    //该对象的上级名称

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setDiagnosetaskid(String diagnosetaskid) {
		this.diagnosetaskid = diagnosetaskid;
	}

	public String getDiagnosetaskid() {
		return this.diagnosetaskid;
	}

	public void setDiagnoseobjid(String diagnoseobjid) {
		this.diagnoseobjid = diagnoseobjid;
	}

	public String getDiagnoseobjid() {
		return this.diagnoseobjid;
	}

	public void setDiagnoseobjname(String diagnoseobjname) {
		this.diagnoseobjname = diagnoseobjname;
	}

	public String getDiagnoseobjname() {
		return this.diagnoseobjname;
	}

	public String getDiagnoseobjidtype() {
		return diagnoseobjidtype;
	}

	public void setDiagnoseobjidtype(String diagnoseobjidtype) {
		this.diagnoseobjidtype = diagnoseobjidtype;
	}

	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}

	public String getTenantid() {
		return this.tenantid;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
