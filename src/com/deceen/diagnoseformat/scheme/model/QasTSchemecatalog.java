package com.deceen.diagnoseformat.scheme.model;

import java.io.Serializable;
import java.util.Date;

import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;
import com.upath.plat.common.page.Pagination;


/**
 * 模型指标关联
 * @ClassName: QasTSchemecatalog.java 唯一标识
 * 
 * @Description: qas_t_schemecatalog
 * @author upaths@gmail.com
 * @date 2017-11-15 18:15:21
 * @version V1.0
 */
@SuppressWarnings("serial")
public class QasTSchemecatalog extends Pagination implements Serializable {

	// 唯一标识
	private String id;
	// 模型id
	private String schemeid;
	// 指标目录id
	private String indicatorcatalogid;
	// 指标目录
	private QasTIndicatorcatalog indicatorcatalog;
	// 指标样式id
	private String atomstyleid;
	//是否有效的（0 无效，1 有效）
	private Integer isvalid;
	// 总分
	private Integer score;
	// 计分权重
	private Float weight;
	// 创建人
	private String createdby;
	// 创建时间
	private Date createdtime;
	// 修改人
	private String updatedby;
	// 修改时间
	private Date updatedtime;
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

	public void setIndicatorcatalogid(String indicatorcatalogid) {
		this.indicatorcatalogid = indicatorcatalogid;
	}

	public String getIndicatorcatalogid() {
		return this.indicatorcatalogid;
	}

	public void setAtomstyleid(String atomstyleid) {
		this.atomstyleid = atomstyleid;
	}

	public QasTIndicatorcatalog getIndicatorcatalog() {
		return indicatorcatalog;
	}

	public void setIndicatorcatalog(QasTIndicatorcatalog indicatorcatalog) {
		this.indicatorcatalog = indicatorcatalog;
	}

	public String getAtomstyleid() {
		return this.atomstyleid;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getWeight() {
		return this.weight;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public Date getCreatedtime() {
		return this.createdtime;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public String getUpdatedby() {
		return this.updatedby;
	}

	public void setUpdatedtime(Date updatedtime) {
		this.updatedtime = updatedtime;
	}

	public Date getUpdatedtime() {
		return this.updatedtime;
	}

	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}

	public String getTenantid() {
		return this.tenantid;
	}
}
