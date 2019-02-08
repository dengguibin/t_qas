package com.deceen.diagnoseformat.scheme.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: QasTDiagnosescheme.java 主键Id
 * @Description: qas_t_diagnosescheme
 * @author upaths@gmail.com
 * @date 2017-11-15 17:50:55
 * @version V1.0
 */
@SuppressWarnings("serial")
public class QasTDiagnosescheme extends Pagination implements Serializable {

	// 主键Id @PrimaryKey
	private String id;
	// 源模型Id,模型复制用
	private String sourceschemeid;
	// 模型名称
	private String schemename;
	// 模型类别（0 任务模型 1 系统模型）
	private Integer schemetype;
	// 适用范围类型(4学校，5学院，6专业，7课程，8教师，9学生)
	private Integer rangetype;
	// 状态(是否发布，0 否 1是)
	private Integer status;
	// 创建人
	private String createdby;
	// 创建时间
	private Date createdtime;
	// 修改人
	private String updatedby;
	// 修改时间
	private Date updatedtime;
	//年份
	private String year;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setSourceschemeid(String sourceschemeid) {
		this.sourceschemeid = sourceschemeid;
	}

	public String getSourceschemeid() {
		return this.sourceschemeid;
	}

	public void setSchemename(String schemename) {
		this.schemename = schemename;
	}

	public String getSchemename() {
		return this.schemename;
	}

	public void setSchemetype(Integer schemetype) {
		this.schemetype = schemetype;
	}

	public Integer getSchemetype() {
		return this.schemetype;
	}

	public void setRangetype(Integer rangetype) {
		this.rangetype = rangetype;
	}

	public Integer getRangetype() {
		return this.rangetype;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
