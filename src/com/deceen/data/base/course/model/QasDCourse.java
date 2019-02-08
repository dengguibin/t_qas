package com.deceen.data.base.course.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: QasDCourse.java 序号
 * @Description: qas_d_course
 * @author upaths@gmail.com
 * @date 2017-11-22 16:32:04
 * @version V1.0
 */

@SuppressWarnings("serial")
public class QasDCourse extends Pagination implements Serializable {

	// 序号 @PrimaryKey
	private String id;
	// 课程代码
	private String coursecode;
	// 课程名称
	private String coursename;
	// 课程类型
	private String coursetype;
	// 课程属性
	private String courseproperty;
	// 是否专业核心课程
	private String isimportant;
	// 是否校企合作开发课程
	private String iscooprate;
	// 精品课程
	private String perfect;
	// 学分
	private Integer score;
	// 创新创业教育专门课程等级
	private String innovation;
	// 是否资格证书课程
	private String isqualificationcertcourse;
	// 是否学院课程改革立项项目
	private String iscollegereformproj;
	// 状态
	private Integer status;
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
	// 入库时间（接口传输，导入）
	private Date storagetime;

	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}

	public String getCoursecode() {
		return this.coursecode;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}

	public String getCoursetype() {
		return this.coursetype;
	}

	public void setCourseproperty(String courseproperty) {
		this.courseproperty = courseproperty;
	}

	public String getCourseproperty() {
		return this.courseproperty;
	}

	public void setIsimportant(String isimportant) {
		this.isimportant = isimportant;
	}

	public String getIsimportant() {
		return this.isimportant;
	}

	public void setIscooprate(String iscooprate) {
		this.iscooprate = iscooprate;
	}

	public String getIscooprate() {
		return this.iscooprate;
	}

	public void setPerfect(String perfect) {
		this.perfect = perfect;
	}

	public String getPerfect() {
		return this.perfect;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setInnovation(String innovation) {
		this.innovation = innovation;
	}

	public String getInnovation() {
		return this.innovation;
	}

	public void setIsqualificationcertcourse(String isqualificationcertcourse) {
		this.isqualificationcertcourse = isqualificationcertcourse;
	}

	public String getIsqualificationcertcourse() {
		return this.isqualificationcertcourse;
	}

	public void setIscollegereformproj(String iscollegereformproj) {
		this.iscollegereformproj = iscollegereformproj;
	}

	public String getIscollegereformproj() {
		return this.iscollegereformproj;
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

	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}

	public String getTenantid() {
		return this.tenantid;
	}

	public void setStoragetime(Date storagetime) {
		this.storagetime = storagetime;
	}

	public Date getStoragetime() {
		return this.storagetime;
	}
}
