package	com.deceen.data.school.practiceBaseInCampusStatistics.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDPracticebaseincampusstatistics.java   记录标识
* @Description: qas_d_practicebaseincampusstatistics   
* @author upaths@gmail.com  
* @date 2017-11-22 17:52:24
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDPracticebaseincampusstatistics extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //校内实践基地 
	private String practicebaseincampusid;
	 //面向专业 
	private String majorid;
	 //学年内基地使用时间 
	private Integer averagetimeperyear;
	 //设备值（万元）<-->设备总值 
	private Integer equipmentvalue;
	 //设备值（万元）<-->当年新增设备值 
	private Integer newequipmentvalue;
	 //当年设备来源(万元）<-->自主研制设备值 
	private Integer selfdevelopedequvalue;
	 //当年设备来源(万元）<-->社会捐赠设备值 
	private Integer societydevelopedequvalue;
	 //当年设备来源(万元）<-->社会准捐赠设备值 
	private Integer socialdonationequvalue;
	 //设备数（台套）<-->设备总数 
	private Integer equimentcount;
	 //设备数（台套）<-->大型设备数 
	private Integer largeequimentcount;
	 //项目个数	 
	private Integer numoftrainingproject;
	 //实训项目名称 
	private Integer numofprojectname;
	 //学年使用频率（人时）<-->校内 
	private Integer frequencyofcampus;
	 //学年使用频率（人时）<-->社会 
	private Integer frequencyofsociology;
	 //工位数(个) 
	private Integer numofworker;
	 //原材料(耗材)费用（万元） 
	private Integer costofconsumptive;
	 //设备维护费用（万元） 
	private Integer costofmaterials;
	 //专职管理人员（名） 
	private Integer fulltimemanagement;
	 //兼职管理人员（名） 
	private Integer parttimemanagement;
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
	
	
	 //学年内基地使用时间 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String averagetimeperyearScope;
	//项目个数	 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String numoftrainingprojectScope;
	 //实训项目名称 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String numofprojectnameScope;
	 //工位数(个) 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String numofworkerScope;
	 //原材料(耗材)费用（万元） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String costofconsumptiveScope;
	 //设备维护费用（万元） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String costofmaterialsScope;
	 //专职管理人员（名） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String fulltimemanagementScope;
	 //兼职管理人员（名） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String parttimemanagementScope;
	
		 public String getAveragetimeperyearScope() {
		return averagetimeperyearScope;
	}

	public void setAveragetimeperyearScope(String averagetimeperyearScope) {
		this.averagetimeperyearScope = averagetimeperyearScope;
	}

	public String getNumoftrainingprojectScope() {
		return numoftrainingprojectScope;
	}

	public void setNumoftrainingprojectScope(String numoftrainingprojectScope) {
		this.numoftrainingprojectScope = numoftrainingprojectScope;
	}

	public String getNumofprojectnameScope() {
		return numofprojectnameScope;
	}

	public void setNumofprojectnameScope(String numofprojectnameScope) {
		this.numofprojectnameScope = numofprojectnameScope;
	}

	public String getNumofworkerScope() {
		return numofworkerScope;
	}

	public void setNumofworkerScope(String numofworkerScope) {
		this.numofworkerScope = numofworkerScope;
	}

	public String getCostofconsumptiveScope() {
		return costofconsumptiveScope;
	}

	public void setCostofconsumptiveScope(String costofconsumptiveScope) {
		this.costofconsumptiveScope = costofconsumptiveScope;
	}

	public String getCostofmaterialsScope() {
		return costofmaterialsScope;
	}

	public void setCostofmaterialsScope(String costofmaterialsScope) {
		this.costofmaterialsScope = costofmaterialsScope;
	}

	public String getFulltimemanagementScope() {
		return fulltimemanagementScope;
	}

	public void setFulltimemanagementScope(String fulltimemanagementScope) {
		this.fulltimemanagementScope = fulltimemanagementScope;
	}

	public String getParttimemanagementScope() {
		return parttimemanagementScope;
	}

	public void setParttimemanagementScope(String parttimemanagementScope) {
		this.parttimemanagementScope = parttimemanagementScope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setPracticebaseincampusid(String practicebaseincampusid){
			this.practicebaseincampusid = practicebaseincampusid;
		}
	  
		public String getPracticebaseincampusid(){
			return this.practicebaseincampusid;
		}
		 public void setMajorid(String majorid){
			this.majorid = majorid;
		}
	  
		public String getMajorid(){
			return this.majorid;
		}
		 public void setAveragetimeperyear(Integer averagetimeperyear){
			this.averagetimeperyear = averagetimeperyear;
		}
	  
		public Integer getAveragetimeperyear(){
			return this.averagetimeperyear;
		}
		 public void setEquipmentvalue(Integer equipmentvalue){
			this.equipmentvalue = equipmentvalue;
		}
	  
		public Integer getEquipmentvalue(){
			return this.equipmentvalue;
		}
		 public void setNewequipmentvalue(Integer newequipmentvalue){
			this.newequipmentvalue = newequipmentvalue;
		}
	  
		public Integer getNewequipmentvalue(){
			return this.newequipmentvalue;
		}
		 public void setSelfdevelopedequvalue(Integer selfdevelopedequvalue){
			this.selfdevelopedequvalue = selfdevelopedequvalue;
		}
	  
		public Integer getSelfdevelopedequvalue(){
			return this.selfdevelopedequvalue;
		}
		 public void setSocietydevelopedequvalue(Integer societydevelopedequvalue){
			this.societydevelopedequvalue = societydevelopedequvalue;
		}
	  
		public Integer getSocietydevelopedequvalue(){
			return this.societydevelopedequvalue;
		}
		 public void setSocialdonationequvalue(Integer socialdonationequvalue){
			this.socialdonationequvalue = socialdonationequvalue;
		}
	  
		public Integer getSocialdonationequvalue(){
			return this.socialdonationequvalue;
		}
		 public void setEquimentcount(Integer equimentcount){
			this.equimentcount = equimentcount;
		}
	  
		public Integer getEquimentcount(){
			return this.equimentcount;
		}
		 public void setLargeequimentcount(Integer largeequimentcount){
			this.largeequimentcount = largeequimentcount;
		}
	  
		public Integer getLargeequimentcount(){
			return this.largeequimentcount;
		}
		 public void setNumoftrainingproject(Integer numoftrainingproject){
			this.numoftrainingproject = numoftrainingproject;
		}
	  
		public Integer getNumoftrainingproject(){
			return this.numoftrainingproject;
		}
		 public void setNumofprojectname(Integer numofprojectname){
			this.numofprojectname = numofprojectname;
		}
	  
		public Integer getNumofprojectname(){
			return this.numofprojectname;
		}
		 public void setFrequencyofcampus(Integer frequencyofcampus){
			this.frequencyofcampus = frequencyofcampus;
		}
	  
		public Integer getFrequencyofcampus(){
			return this.frequencyofcampus;
		}
		 public void setFrequencyofsociology(Integer frequencyofsociology){
			this.frequencyofsociology = frequencyofsociology;
		}
	  
		public Integer getFrequencyofsociology(){
			return this.frequencyofsociology;
		}
		 public void setNumofworker(Integer numofworker){
			this.numofworker = numofworker;
		}
	  
		public Integer getNumofworker(){
			return this.numofworker;
		}
		 public void setCostofconsumptive(Integer costofconsumptive){
			this.costofconsumptive = costofconsumptive;
		}
	  
		public Integer getCostofconsumptive(){
			return this.costofconsumptive;
		}
		 public void setCostofmaterials(Integer costofmaterials){
			this.costofmaterials = costofmaterials;
		}
	  
		public Integer getCostofmaterials(){
			return this.costofmaterials;
		}
		 public void setFulltimemanagement(Integer fulltimemanagement){
			this.fulltimemanagement = fulltimemanagement;
		}
	  
		public Integer getFulltimemanagement(){
			return this.fulltimemanagement;
		}
		 public void setParttimemanagement(Integer parttimemanagement){
			this.parttimemanagement = parttimemanagement;
		}
	  
		public Integer getParttimemanagement(){
			return this.parttimemanagement;
		}
		 public void setStatus(Integer status){
			this.status = status;
		}
	  
		public Integer getStatus(){
			return this.status;
		}
		 public void setCreatedby(String createdby){
			this.createdby = createdby;
		}
	  
		public String getCreatedby(){
			return this.createdby;
		}
		 public void setCreatedtime(Date createdtime){
			this.createdtime = createdtime;
		}
	  
		public Date getCreatedtime(){
			return this.createdtime;
		}
		 public void setUpdatedby(String updatedby){
			this.updatedby = updatedby;
		}
	  
		public String getUpdatedby(){
			return this.updatedby;
		}
		 public void setUpdatedtime(Date updatedtime){
			this.updatedtime = updatedtime;
		}
	  
		public Date getUpdatedtime(){
			return this.updatedtime;
		}
		 public void setTenantid(String tenantid){
			this.tenantid = tenantid;
		}
	  
		public String getTenantid(){
			return this.tenantid;
		}
		 public void setStoragetime(Date storagetime){
			this.storagetime = storagetime;
		}
	  
		public Date getStoragetime(){
			return this.storagetime;
		}
}
