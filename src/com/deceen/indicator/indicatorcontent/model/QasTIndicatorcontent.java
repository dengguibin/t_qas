package com.deceen.indicator.indicatorcontent.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: QasTIndicatorcontent.java 指标Id，同一个Id,表示不同方案的同一个指标
 * @Description: qas_t_indicatorcontent
 * @author upaths@gmail.com
 * @date 2017-11-9 15:56:08
 * @version V1.0
 */
@SuppressWarnings("serial")
public class QasTIndicatorcontent extends Pagination implements Serializable {
	
	public static final int ISVALID_DEFAULT = 1;

	// 唯一标识 @PrimaryKey
	private String id;
	// 名称
	private String name_;
	// 指标目录Id,取最新的Version
	private String indicatorcatalogid;
	// 诊断数据类型:1：数值型，2：判断型
	private Integer indicatordatatype;
	//上行指标还是下行指标，数值越大越好还是越小越好(0:上行，1：下行)
	private Integer indicatordatatrend;
	// 指标查询SQL语句
	private String sqlstring;
	// 普通院校标准
	private String standard;
	// 说明
	private String remark;
	// 指标样式id
	private String atomid;
	// 创建人
	private String createdby;
	// 创建时间
	private Date createdtime;
	// 修改人
	private String updatedby;
	// 修改时间
	private Date updatedtime;
	
	// 父节点ID（用于添加指标的传值）
	private String parentindicatorcontentid;
	
	
	public Integer getIndicatordatatrend() {
		return indicatordatatrend;
	}

	public void setIndicatordatatrend(Integer indicatordatatrend) {
		this.indicatordatatrend = indicatordatatrend;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setName_(String name_) {
		this.name_ = name_;
	}

	public String getName_() {
		return this.name_;
	}

	public void setIndicatorcatalogid(String indicatorcatalogid) {
		this.indicatorcatalogid = indicatorcatalogid;
	}

	public String getIndicatorcatalogid() {
		return this.indicatorcatalogid;
	}

	public void setAtomid(String atomid) {
		this.atomid = atomid;
	}

	public String getAtomid() {
		return this.atomid;
	}

	public void setSqlstring(String sqlstring) {
		this.sqlstring = sqlstring;
	}

	public String getSqlstring() {
		return this.sqlstring;
	}

	public void setIndicatordatatype(Integer indicatordatatype) {
		this.indicatordatatype = indicatordatatype;
	}

	public Integer getIndicatordatatype() {
		return this.indicatordatatype;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
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

	public String getParentindicatorcontentid() {
		return parentindicatorcontentid;
	}

	public void setParentindicatorcontentid(String parentindicatorcontentid) {
		this.parentindicatorcontentid = parentindicatorcontentid;
	}

}
