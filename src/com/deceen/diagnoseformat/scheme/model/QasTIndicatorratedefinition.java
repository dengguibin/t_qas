package com.deceen.diagnoseformat.scheme.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: QasTIndicatorratedefinition.java
 * @Description: qas_t_indicatorratedefinition
 * @author upaths@gmail.com
 * @date 2017-11-29 15:49:01
 * @version V1.0
 */

public class QasTIndicatorratedefinition extends Pagination implements Serializable {

	private static final long serialVersionUID = 1L;
	// @PrimaryKey
	private String id;
	// 诊断模型Id
	private String schemeid;
	// 指标ID
	private String indicatorcontentid;
	// 左值
	private Integer leftvalue;
	// 右值
	private Integer rightvalue;
	// 运算符
	private String operator;
	// 得分
	private Integer score;
	// 预警等级
	private Integer warninggrade;
	// Face.net公式
	private String formula;
	// 排序
	private Integer sort;
	// 租户
	private String tenantid;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setSchemeid(String schemeid) {
		this.schemeid = schemeid;
	}

	public String getSchemeid() {
		return this.schemeid;
	}

	public void setIndicatorcontentid(String indicatorcontentid) {
		this.indicatorcontentid = indicatorcontentid;
	}

	public String getIndicatorcontentid() {
		return this.indicatorcontentid;
	}

	public void setLeftvalue(Integer leftvalue) {
		this.leftvalue = leftvalue;
	}

	public Integer getLeftvalue() {
		return this.leftvalue;
	}

	public void setRightvalue(Integer rightvalue) {
		this.rightvalue = rightvalue;
	}

	public Integer getRightvalue() {
		return this.rightvalue;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setWarninggrade(Integer warninggrade) {
		this.warninggrade = warninggrade;
	}

	public Integer getWarninggrade() {
		return this.warninggrade;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getFormula() {
		return this.formula;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}

	public String getTenantid() {
		return this.tenantid;
	}
}
