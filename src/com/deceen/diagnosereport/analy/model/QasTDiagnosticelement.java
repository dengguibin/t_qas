package	com.deceen.diagnosereport.analy.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasTDiagnosticelement.java   唯一标识
* @Description: qas_t_diagnosticelement   
* @author upaths@gmail.com  
* @date 2017-12-6 11:23:46
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasTDiagnosticelement extends Pagination implements Serializable{ 	
	
	// 唯一标识 @PrimaryKey
	private String id;
	//
	private String diagnosticprojectid;
	// catalog.id
	private String indicatorcatalogid;
	// catalog.UniqueId
	private String indicatorcataloguniqueid;
	//
	private String elementname;
	// 要素状态(预警 合格 不合格)
	private Integer elementstate;
	// 住户Id
	private String tenantid;
	// 计分权重
	private Float weight;
	// 排序
	private Integer sort;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setDiagnosticprojectid(String diagnosticprojectid) {
		this.diagnosticprojectid = diagnosticprojectid;
	}

	public String getDiagnosticprojectid() {
		return this.diagnosticprojectid;
	}

	public void setIndicatorcatalogid(String indicatorcatalogid) {
		this.indicatorcatalogid = indicatorcatalogid;
	}

	public String getIndicatorcatalogid() {
		return this.indicatorcatalogid;
	}

	public void setIndicatorcataloguniqueid(String indicatorcataloguniqueid) {
		this.indicatorcataloguniqueid = indicatorcataloguniqueid;
	}

	public String getIndicatorcataloguniqueid() {
		return this.indicatorcataloguniqueid;
	}

	public void setElementname(String elementname) {
		this.elementname = elementname;
	}

	public String getElementname() {
		return this.elementname;
	}

	public void setElementstate(Integer elementstate) {
		this.elementstate = elementstate;
	}

	public Integer getElementstate() {
		return this.elementstate;
	}

	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}

	public String getTenantid() {
		return this.tenantid;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getWeight() {
		return this.weight;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}
}
