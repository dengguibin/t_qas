package com.deceen.indicator.indicatorcatalog.model;

import java.io.Serializable;
import java.util.*;

import com.deceen.indicator.indicatorcatalog.mapper.QasTIndicatorcatalogMapper;
import com.upath.plat.common.page.Pagination;

/**
 * 指标目录
 * @ClassName: QasTIndicatorcatalog.java 唯一标识
 * 
 * @Description: qas_t_indicatorcatalog
 * @author upaths@gmail.com
 * @date 2017-11-8 14:18:50
 * @version V1.0
 */
@SuppressWarnings({ "rawtypes", "serial" })
public class QasTIndicatorcatalog extends Pagination implements Serializable {
	
	public static final int ISVALID_DEFAULT = 1;

	// 唯一标识
	private String id;
	// 目录点名称
	private String name_;
	// 目录类型 1:类型 2：项目 3：要素 0：诊断点/指标
	private Integer indicatortype;
	// 排序
	private Integer sort;
	// 父级目录点ID,顶层父节点为"0"
	private String parentid;
	//牵头部门
	private String leadDept;
	//协同部门
	private String synergeticDept;
	// 目录说明
	private String remark;
	//是否支持实时监控：0：不支持，1支持
	private String ismonitor;
	// 是否有效的（0 无效，1 有效）
	private Integer isvalid;
	// 创建人
	private String createdby;
	// 创建时间
	private Date createdtime;
	// 修改人
	private String updatedby;
	// 修改时间
	private Date updatedtime;
	// 子集
	private List children;

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

	public void setIndicatortype(Integer indicatortype) {
		this.indicatortype = indicatortype;
	}

	public Integer getIndicatortype() {
		return this.indicatortype;
	}
	
	public String getLeadDept() {
		return leadDept;
	}

	public void setLeadDept(String leadDept) {
		this.leadDept = leadDept;
	}

	public String getSynergeticDept() {
		return synergeticDept;
	}

	public void setSynergeticDept(String synergeticDept) {
		this.synergeticDept = synergeticDept;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getParentid() {
		return this.parentid;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public String getIsmonitor() {
		return ismonitor;
	}

	public void setIsmonitor(String ismonitor) {
		this.ismonitor = ismonitor;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

	public Integer getIsvalid() {
		return this.isvalid;
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

	public List getChildren() {
		return children;
	}

	public void setChildren(List children) {
		this.children = children;
	}
	
	//获取排序
	public int createSort(QasTIndicatorcatalogMapper mapper, String parentid){
		QasTIndicatorcatalog indicatorcatalog = mapper.queryByParentIdToMaxSort(parentid);
		int sort = 1;
		if(indicatorcatalog != null && indicatorcatalog.getSort()!=null){//判断是否有同级别目录
			sort = indicatorcatalog.getSort()+1;
		}else{
			indicatorcatalog = mapper.select((Object)parentid);
			if(indicatorcatalog != null && indicatorcatalog.getSort()!=null){//判断是否有父级别目录
				sort = indicatorcatalog.getSort()*getMultiplier(indicatorcatalog.getIndicatortype())+1;
			}
		}
		return sort;
	}
	
	//排序生成规则
	/**
	 * @param type	父级类型
	 * @return
	 */
	private int getMultiplier(Integer type){
		int multiplier = 100;	//一个要素下最多99个指标
		if(type == 1){
			multiplier = 100;	//一个类型下最多99个项目
		}else if(type == 2){
			multiplier = 100;	//一个项目下最多99个要素
		}
		return multiplier;
	}

}
