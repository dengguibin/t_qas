/**
*/
package	com.deceen.data.fund.fundCostStatistics.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDFundcoststatistics.java   序号
* @Description: qas_d_fundcoststatistics   
* @author upaths@gmail.com  
* @date 2017-11-23 12:16:28
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDFundcoststatistics extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //学校总支出（万元） 
	private Integer schoolexpenditure;
	 //其中<-->征地（万元） 
	private Integer landrequisition;
	 //其中<-->基础设施建设（万元） 
	private Integer infrastructureconstruction;
	 //其中<-->设备采购（万元）<-->合计 
	private Integer equipmentprocurementtotal;
	 //其中<-->日常教学经费（万元）<-->合计 
	private Integer teachingfundtotal;
	 //其中<-->日常教学经费（万元）<-->实(验)训耗材 
	private Integer trainingequipment;
	 //其中<-->日常教学经费（万元）<-->实习专项 
	private Integer pacticefee;
	 //其中<-->日常教学经费（万元）<-->聘请兼职教师经费 
	private Integer hireteacherfee;
	 //其中<-->日常教学经费（万元）<-->体育维持费 
	private Integer sportsfee;
	 //其中<-->日常教学经费（万元）<-->其他 
	private Integer othersfee;
	 //其中<-->教学改革及研究<-->合计（万元） 
	private Integer teachingresearchtotal;
	 //其中<-->师资建设<-->合计（万元） 
	private Integer teacherconstructiontotal;
	 //其中<-->师资建设<-->教师培训专项经费 
	private Integer teachertrainingfee;
	 //其中<-->图书购置费（万元） 
	private Integer bookacquisitionfee;
	 //其中<-->其他支出总额（万元） 
	private Integer others;
	 //还贷金额（万元） 
	private Integer amountofrepayment;
	 //状态 
	private Integer status;
	 //创建人 
	private String createdby;
	 //创建时间 
	private Date createdtime;
	 //修改人 
	private String updatedby;
	 //修改时间 
	private Date updatedtime;
	 //租户 
	private String tenantid;
	 //入库时间（接口传输，导入） 
	private Date storagetime;
	
	
	//学校总支出范围(表中无此字段，只是为了条件选择新增的)
	private String schoolexpenditureScope;


	public QasDFundcoststatistics() {
		super();
	}


	public QasDFundcoststatistics(Integer schoolexpenditure,
			Integer landrequisition, Integer infrastructureconstruction,
			Integer equipmentprocurementtotal, Integer teachingfundtotal,
			Integer trainingequipment, Integer pacticefee,
			Integer hireteacherfee, Integer sportsfee, Integer othersfee,
			Integer teachingresearchtotal, Integer teacherconstructiontotal,
			Integer teachertrainingfee, Integer bookacquisitionfee,
			Integer others, Integer amountofrepayment, Integer status,
			String createdby, Date createdtime, String updatedby,
			Date updatedtime, String tenantid, Date storagetime,
			String schoolexpenditureScope) {
		super();
		this.schoolexpenditure = schoolexpenditure;
		this.landrequisition = landrequisition;
		this.infrastructureconstruction = infrastructureconstruction;
		this.equipmentprocurementtotal = equipmentprocurementtotal;
		this.teachingfundtotal = teachingfundtotal;
		this.trainingequipment = trainingequipment;
		this.pacticefee = pacticefee;
		this.hireteacherfee = hireteacherfee;
		this.sportsfee = sportsfee;
		this.othersfee = othersfee;
		this.teachingresearchtotal = teachingresearchtotal;
		this.teacherconstructiontotal = teacherconstructiontotal;
		this.teachertrainingfee = teachertrainingfee;
		this.bookacquisitionfee = bookacquisitionfee;
		this.others = others;
		this.amountofrepayment = amountofrepayment;
		this.status = status;
		this.createdby = createdby;
		this.createdtime = createdtime;
		this.updatedby = updatedby;
		this.updatedtime = updatedtime;
		this.tenantid = tenantid;
		this.storagetime = storagetime;
		this.schoolexpenditureScope = schoolexpenditureScope;
	}


	public QasDFundcoststatistics(String id, Integer schoolexpenditure,
			Integer landrequisition, Integer infrastructureconstruction,
			Integer equipmentprocurementtotal, Integer teachingfundtotal,
			Integer trainingequipment, Integer pacticefee,
			Integer hireteacherfee, Integer sportsfee, Integer othersfee,
			Integer teachingresearchtotal, Integer teacherconstructiontotal,
			Integer teachertrainingfee, Integer bookacquisitionfee,
			Integer others, Integer amountofrepayment, Integer status,
			String createdby, Date createdtime, String updatedby,
			Date updatedtime, String tenantid, Date storagetime,
			String schoolexpenditureScope) {
		super();
		this.id = id;
		this.schoolexpenditure = schoolexpenditure;
		this.landrequisition = landrequisition;
		this.infrastructureconstruction = infrastructureconstruction;
		this.equipmentprocurementtotal = equipmentprocurementtotal;
		this.teachingfundtotal = teachingfundtotal;
		this.trainingequipment = trainingequipment;
		this.pacticefee = pacticefee;
		this.hireteacherfee = hireteacherfee;
		this.sportsfee = sportsfee;
		this.othersfee = othersfee;
		this.teachingresearchtotal = teachingresearchtotal;
		this.teacherconstructiontotal = teacherconstructiontotal;
		this.teachertrainingfee = teachertrainingfee;
		this.bookacquisitionfee = bookacquisitionfee;
		this.others = others;
		this.amountofrepayment = amountofrepayment;
		this.status = status;
		this.createdby = createdby;
		this.createdtime = createdtime;
		this.updatedby = updatedby;
		this.updatedtime = updatedtime;
		this.tenantid = tenantid;
		this.storagetime = storagetime;
		this.schoolexpenditureScope = schoolexpenditureScope;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Integer getSchoolexpenditure() {
		return schoolexpenditure;
	}


	public void setSchoolexpenditure(Integer schoolexpenditure) {
		this.schoolexpenditure = schoolexpenditure;
	}


	public Integer getLandrequisition() {
		return landrequisition;
	}


	public void setLandrequisition(Integer landrequisition) {
		this.landrequisition = landrequisition;
	}


	public Integer getInfrastructureconstruction() {
		return infrastructureconstruction;
	}


	public void setInfrastructureconstruction(Integer infrastructureconstruction) {
		this.infrastructureconstruction = infrastructureconstruction;
	}


	public Integer getEquipmentprocurementtotal() {
		return equipmentprocurementtotal;
	}


	public void setEquipmentprocurementtotal(Integer equipmentprocurementtotal) {
		this.equipmentprocurementtotal = equipmentprocurementtotal;
	}


	public Integer getTeachingfundtotal() {
		return teachingfundtotal;
	}


	public void setTeachingfundtotal(Integer teachingfundtotal) {
		this.teachingfundtotal = teachingfundtotal;
	}


	public Integer getTrainingequipment() {
		return trainingequipment;
	}


	public void setTrainingequipment(Integer trainingequipment) {
		this.trainingequipment = trainingequipment;
	}


	public Integer getPacticefee() {
		return pacticefee;
	}


	public void setPacticefee(Integer pacticefee) {
		this.pacticefee = pacticefee;
	}


	public Integer getHireteacherfee() {
		return hireteacherfee;
	}


	public void setHireteacherfee(Integer hireteacherfee) {
		this.hireteacherfee = hireteacherfee;
	}


	public Integer getSportsfee() {
		return sportsfee;
	}


	public void setSportsfee(Integer sportsfee) {
		this.sportsfee = sportsfee;
	}


	public Integer getOthersfee() {
		return othersfee;
	}


	public void setOthersfee(Integer othersfee) {
		this.othersfee = othersfee;
	}


	public Integer getTeachingresearchtotal() {
		return teachingresearchtotal;
	}


	public void setTeachingresearchtotal(Integer teachingresearchtotal) {
		this.teachingresearchtotal = teachingresearchtotal;
	}


	public Integer getTeacherconstructiontotal() {
		return teacherconstructiontotal;
	}


	public void setTeacherconstructiontotal(Integer teacherconstructiontotal) {
		this.teacherconstructiontotal = teacherconstructiontotal;
	}


	public Integer getTeachertrainingfee() {
		return teachertrainingfee;
	}


	public void setTeachertrainingfee(Integer teachertrainingfee) {
		this.teachertrainingfee = teachertrainingfee;
	}


	public Integer getBookacquisitionfee() {
		return bookacquisitionfee;
	}


	public void setBookacquisitionfee(Integer bookacquisitionfee) {
		this.bookacquisitionfee = bookacquisitionfee;
	}


	public Integer getOthers() {
		return others;
	}


	public void setOthers(Integer others) {
		this.others = others;
	}


	public Integer getAmountofrepayment() {
		return amountofrepayment;
	}


	public void setAmountofrepayment(Integer amountofrepayment) {
		this.amountofrepayment = amountofrepayment;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getCreatedby() {
		return createdby;
	}


	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}


	public Date getCreatedtime() {
		return createdtime;
	}


	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}


	public String getUpdatedby() {
		return updatedby;
	}


	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}


	public Date getUpdatedtime() {
		return updatedtime;
	}


	public void setUpdatedtime(Date updatedtime) {
		this.updatedtime = updatedtime;
	}


	public String getTenantid() {
		return tenantid;
	}


	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}


	public Date getStoragetime() {
		return storagetime;
	}


	public void setStoragetime(Date storagetime) {
		this.storagetime = storagetime;
	}

	
	public String getSchoolexpenditureScope() {
		return schoolexpenditureScope;
	}

	public void setSchoolexpenditureScope(String schoolexpenditureScope) {
		this.schoolexpenditureScope = schoolexpenditureScope;
	}


	@Override
	public String toString() {
		return "QasDFundcoststatistics [amountofrepayment=" + amountofrepayment
				+ ", bookacquisitionfee=" + bookacquisitionfee + ", createdby="
				+ createdby + ", createdtime=" + createdtime
				+ ", equipmentprocurementtotal=" + equipmentprocurementtotal
				+ ", hireteacherfee=" + hireteacherfee + ", id=" + id
				+ ", infrastructureconstruction=" + infrastructureconstruction
				+ ", landrequisition=" + landrequisition + ", others=" + others
				+ ", othersfee=" + othersfee + ", pacticefee=" + pacticefee
				+ ", schoolexpenditure=" + schoolexpenditure
				+ ", schoolexpenditureScope=" + schoolexpenditureScope
				+ ", sportsfee=" + sportsfee + ", status=" + status
				+ ", storagetime=" + storagetime
				+ ", teacherconstructiontotal=" + teacherconstructiontotal
				+ ", teachertrainingfee=" + teachertrainingfee
				+ ", teachingfundtotal=" + teachingfundtotal
				+ ", teachingresearchtotal=" + teachingresearchtotal
				+ ", tenantid=" + tenantid + ", trainingequipment="
				+ trainingequipment + ", updatedby=" + updatedby
				+ ", updatedtime=" + updatedtime + "]";
	}
	
}
