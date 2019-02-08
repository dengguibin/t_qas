package com.deceen.indicator.indicatorcatalogextend.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: QasTIndicatorcatalogextend.java 唯一标识
 * 
 * @Description: qas_t_indicatorcatalogextend
 * @author upaths@gmail.com
 * @date 2017-11-24 12:26:46
 * @version V1.0
 */
@SuppressWarnings("serial")
public class QasTIndicatorcatalogextend extends Pagination implements Serializable {

	// 唯一标识
	private String id;
	// IndicatorCatalog.Id
	private String indicatorcatalogid;
	// 目录唯一标识
	private String indicatorcataloguniqueid;
	// 存在问题-概况
	private String problemoverview;
	// 存在问题-明细
	private String problemdetail;
	// 改进建议-概况
	private String suggestionoverview;
	// 改进建议-明细
	private String suggestiondetail;
	// 租户
	private String tenantid;

	private String indicatorcatalogName;
	
	private int indicatorType;//1:类型 2：项目 3：要素 0：指标

	
	public int getIndicatorType() {
		return indicatorType;
	}

	public void setIndicatorType(int indicatorType) {
		this.indicatorType = indicatorType;
	}

	public String getIndicatorcatalogName() {
		return indicatorcatalogName;
	}

	public void setIndicatorcatalogName(String indicatorcatalogName) {
		this.indicatorcatalogName = indicatorcatalogName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
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

	public void setProblemoverview(String problemoverview) {
		this.problemoverview = problemoverview;
	}

	public String getProblemoverview() {
		return this.problemoverview;
	}

	public void setProblemdetail(String problemdetail) {
		this.problemdetail = problemdetail;
	}

	public String getProblemdetail() {
		return this.problemdetail;
	}

	public void setSuggestionoverview(String suggestionoverview) {
		this.suggestionoverview = suggestionoverview;
	}

	public String getSuggestionoverview() {
		return this.suggestionoverview;
	}

	public void setSuggestiondetail(String suggestiondetail) {
		this.suggestiondetail = suggestiondetail;
	}

	public String getSuggestiondetail() {
		return this.suggestiondetail;
	}

	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}

	public String getTenantid() {
		return this.tenantid;
	}
}
