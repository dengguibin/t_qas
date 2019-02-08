package com.deceen.data.school.areaOfStructure.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: QasDAreaofstructure.java 序号
 * @Description: qas_d_areaofstructure
 * @author upaths@gmail.com
 * @date 2017-11-22 17:44:17
 * @version V1.0
 */
@SuppressWarnings("serial")
public class QasDAreaofstructure extends Pagination implements Serializable {

	// 序号 @PrimaryKey
	private String id;
	// 占地面积
	private Integer areacovered;
	// 总建筑面积
	private Integer constructionarea;
	// 其中<-->学校产权校舍建筑面积<-->合计
	private Integer schoolbuildingarea;
	// 其中<-->学校产权校舍建筑面积<-->当年新增校舍
	private Integer schooladdbuilding;
	// 其中<-->非学校产权校舍建筑面积
	private Integer nonschoolpropertyarea;
	// 教学科研及辅助用房
	private Integer researchandauxiliary;
	// 其中<-->教室
	private Integer classroom;
	// 其中<-->图书馆
	private Integer library;
	// 其中<-->实验室、实习场所
	private Integer laboratoryandpractice;
	// 其中<-->专用科研用房
	private Integer specialresearch;
	// 其中<-->体育馆
	private Integer stadium;
	// 其中<-->会堂
	private Integer hall;
	// 行政办公用房
	private Integer office;
	// 生活用房
	private Integer livingroom;
	// 其中<-->学生宿舍（公寓）
	private Integer studentdormitory;
	// 其中<-->学生食堂
	private Integer studentcanteen;
	// 其中<-->教工宿舍（公寓）
	private Integer employeedormitory;
	// 其中<-->教工食堂
	private Integer employeecanteen;
	// 其中<-->生活福利及附属用房
	private Integer welfarehouse;
	// 教工住宅
	private Integer facultyresidence;
	// 其他用房
	private Integer otherresidence;
	// 一体化教室
	private Integer integratedclassroom;
	// 占地面积<-->绿化用
	private Integer acreage;
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
	
	//占地面积范围(表中无此字段，只是为了条件选择新增的)
	private String areacoveredScope;
	
	//范围(表中无此字段，只是为了条件选择新增的)
	private String schoolbuildingareaScope;
	
	//范围(表中无此字段，只是为了条件选择新增的)
	private String researchandauxiliaryScope;
	
	//行政办公用房面积范围(表中无此字段，只是为了条件选择新增的)
	private String officeScope;
	
	//生活用房面积范围(表中无此字段，只是为了条件选择新增的)
	private String livingroomScope;
	
	//范围(表中无此字段，只是为了条件选择新增的)
	private String facultyresidenceScope;
	
	//范围(表中无此字段，只是为了条件选择新增的)
	private String otherresidenceScope;
	
	//范围(表中无此字段，只是为了条件选择新增的)
	private String integratedclassroomScope;
	

	public String getAreacoveredScope() {
		return areacoveredScope;
	}

	public void setAreacoveredScope(String areacoveredScope) {
		this.areacoveredScope = areacoveredScope;
	}

	public String getSchoolbuildingareaScope() {
		return schoolbuildingareaScope;
	}

	public void setSchoolbuildingareaScope(String schoolbuildingareaScope) {
		this.schoolbuildingareaScope = schoolbuildingareaScope;
	}

	public String getResearchandauxiliaryScope() {
		return researchandauxiliaryScope;
	}

	public void setResearchandauxiliaryScope(String researchandauxiliaryScope) {
		this.researchandauxiliaryScope = researchandauxiliaryScope;
	}

	public String getOfficeScope() {
		return officeScope;
	}

	public void setOfficeScope(String officeScope) {
		this.officeScope = officeScope;
	}

	public String getLivingroomScope() {
		return livingroomScope;
	}

	public void setLivingroomScope(String livingroomScope) {
		this.livingroomScope = livingroomScope;
	}

	public String getFacultyresidenceScope() {
		return facultyresidenceScope;
	}

	public void setFacultyresidenceScope(String facultyresidenceScope) {
		this.facultyresidenceScope = facultyresidenceScope;
	}

	public String getOtherresidenceScope() {
		return otherresidenceScope;
	}

	public void setOtherresidenceScope(String otherresidenceScope) {
		this.otherresidenceScope = otherresidenceScope;
	}

	public String getIntegratedclassroomScope() {
		return integratedclassroomScope;
	}

	public void setIntegratedclassroomScope(String integratedclassroomScope) {
		this.integratedclassroomScope = integratedclassroomScope;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setAreacovered(Integer areacovered) {
		this.areacovered = areacovered;
	}

	public Integer getAreacovered() {
		return this.areacovered;
	}

	public void setConstructionarea(Integer constructionarea) {
		this.constructionarea = constructionarea;
	}

	public Integer getConstructionarea() {
		return this.constructionarea;
	}

	public void setSchoolbuildingarea(Integer schoolbuildingarea) {
		this.schoolbuildingarea = schoolbuildingarea;
	}

	public Integer getSchoolbuildingarea() {
		return this.schoolbuildingarea;
	}

	public void setSchooladdbuilding(Integer schooladdbuilding) {
		this.schooladdbuilding = schooladdbuilding;
	}

	public Integer getSchooladdbuilding() {
		return this.schooladdbuilding;
	}

	public void setNonschoolpropertyarea(Integer nonschoolpropertyarea) {
		this.nonschoolpropertyarea = nonschoolpropertyarea;
	}

	public Integer getNonschoolpropertyarea() {
		return this.nonschoolpropertyarea;
	}

	public void setResearchandauxiliary(Integer researchandauxiliary) {
		this.researchandauxiliary = researchandauxiliary;
	}

	public Integer getResearchandauxiliary() {
		return this.researchandauxiliary;
	}

	public void setClassroom(Integer classroom) {
		this.classroom = classroom;
	}

	public Integer getClassroom() {
		return this.classroom;
	}

	public void setLibrary(Integer library) {
		this.library = library;
	}

	public Integer getLibrary() {
		return this.library;
	}

	public void setLaboratoryandpractice(Integer laboratoryandpractice) {
		this.laboratoryandpractice = laboratoryandpractice;
	}

	public Integer getLaboratoryandpractice() {
		return this.laboratoryandpractice;
	}

	public void setSpecialresearch(Integer specialresearch) {
		this.specialresearch = specialresearch;
	}

	public Integer getSpecialresearch() {
		return this.specialresearch;
	}

	public void setStadium(Integer stadium) {
		this.stadium = stadium;
	}

	public Integer getStadium() {
		return this.stadium;
	}

	public void setHall(Integer hall) {
		this.hall = hall;
	}

	public Integer getHall() {
		return this.hall;
	}

	public void setOffice(Integer office) {
		this.office = office;
	}

	public Integer getOffice() {
		return this.office;
	}

	public void setLivingroom(Integer livingroom) {
		this.livingroom = livingroom;
	}

	public Integer getLivingroom() {
		return this.livingroom;
	}

	public void setStudentdormitory(Integer studentdormitory) {
		this.studentdormitory = studentdormitory;
	}

	public Integer getStudentdormitory() {
		return this.studentdormitory;
	}

	public void setStudentcanteen(Integer studentcanteen) {
		this.studentcanteen = studentcanteen;
	}

	public Integer getStudentcanteen() {
		return this.studentcanteen;
	}

	public void setEmployeedormitory(Integer employeedormitory) {
		this.employeedormitory = employeedormitory;
	}

	public Integer getEmployeedormitory() {
		return this.employeedormitory;
	}

	public void setEmployeecanteen(Integer employeecanteen) {
		this.employeecanteen = employeecanteen;
	}

	public Integer getEmployeecanteen() {
		return this.employeecanteen;
	}

	public void setWelfarehouse(Integer welfarehouse) {
		this.welfarehouse = welfarehouse;
	}

	public Integer getWelfarehouse() {
		return this.welfarehouse;
	}

	public void setFacultyresidence(Integer facultyresidence) {
		this.facultyresidence = facultyresidence;
	}

	public Integer getFacultyresidence() {
		return this.facultyresidence;
	}

	public void setOtherresidence(Integer otherresidence) {
		this.otherresidence = otherresidence;
	}

	public Integer getOtherresidence() {
		return this.otherresidence;
	}

	public void setIntegratedclassroom(Integer integratedclassroom) {
		this.integratedclassroom = integratedclassroom;
	}

	public Integer getIntegratedclassroom() {
		return this.integratedclassroom;
	}

	public void setAcreage(Integer acreage) {
		this.acreage = acreage;
	}

	public Integer getAcreage() {
		return this.acreage;
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
