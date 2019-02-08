package	com.deceen.data.school.informationConstruction.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDInformationconstruction.java   序号
* @Description: qas_d_informationconstruction   
* @author upaths@gmail.com  
* @date 2017-11-22 17:45:56
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDInformationconstruction extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //出口总带宽（Mbps） 
	private Integer exportbandwidth;
	 //校园网主干最大带宽（Mbps） 
	private Integer campusnetwork;
	 //网络信息点数（个） 
	private Integer networkinformationpoint;
	 //管理信息系统数据总量（GB） 
	private Integer accountofmis;
	 //电子邮件系统用户数（个） 
	private Integer emailusercount;
	 //上网课程数（门） 
	private Integer onlinecoursecount;
	 //数字资源量(GB)<-->合计 
	private Integer totaldigitalresource;
	 //数字资源量(GB)<-->电子图书 
	private Integer electronicbook;
	 //多媒体教学资源库总容量（TB） 
	private Integer multimediacapacity;
	 //国家级职业教育专业教学资源库数量 
	private Integer nationallevelresource;
	 //省级职业教育专业教学资源库数量 
	private Integer provincialresource;
	 //一卡通使用	 
	private Integer allinonecardusage;
	 //无线覆盖情况	 
	private Integer wirelesscoverage;
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
	
	 //出口总带宽（Mbps） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String exportbandwidthScope;
	 //校园网主干最大带宽（Mbps） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String campusnetworkScope;
	 //网络信息点数（个） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String networkinformationpointScope;
	 //管理信息系统数据总量（GB） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String accountofmisScope;
	 //电子邮件系统用户数（个） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String emailusercountScope;
	 //上网课程数（门） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String onlinecoursecountScope;
	 //数字资源量(GB)<-->合计 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String totaldigitalresourceScope;

	
		 public String getExportbandwidthScope() {
		return exportbandwidthScope;
	}

	public void setExportbandwidthScope(String exportbandwidthScope) {
		this.exportbandwidthScope = exportbandwidthScope;
	}

	public String getCampusnetworkScope() {
		return campusnetworkScope;
	}

	public void setCampusnetworkScope(String campusnetworkScope) {
		this.campusnetworkScope = campusnetworkScope;
	}

	public String getNetworkinformationpointScope() {
		return networkinformationpointScope;
	}

	public void setNetworkinformationpointScope(String networkinformationpointScope) {
		this.networkinformationpointScope = networkinformationpointScope;
	}

	public String getAccountofmisScope() {
		return accountofmisScope;
	}

	public void setAccountofmisScope(String accountofmisScope) {
		this.accountofmisScope = accountofmisScope;
	}

	public String getEmailusercountScope() {
		return emailusercountScope;
	}

	public void setEmailusercountScope(String emailusercountScope) {
		this.emailusercountScope = emailusercountScope;
	}

	public String getOnlinecoursecountScope() {
		return onlinecoursecountScope;
	}

	public void setOnlinecoursecountScope(String onlinecoursecountScope) {
		this.onlinecoursecountScope = onlinecoursecountScope;
	}

	public String getTotaldigitalresourceScope() {
		return totaldigitalresourceScope;
	}

	public void setTotaldigitalresourceScope(String totaldigitalresourceScope) {
		this.totaldigitalresourceScope = totaldigitalresourceScope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setExportbandwidth(Integer exportbandwidth){
			this.exportbandwidth = exportbandwidth;
		}
	  
		public Integer getExportbandwidth(){
			return this.exportbandwidth;
		}
		 public void setCampusnetwork(Integer campusnetwork){
			this.campusnetwork = campusnetwork;
		}
	  
		public Integer getCampusnetwork(){
			return this.campusnetwork;
		}
		 public void setNetworkinformationpoint(Integer networkinformationpoint){
			this.networkinformationpoint = networkinformationpoint;
		}
	  
		public Integer getNetworkinformationpoint(){
			return this.networkinformationpoint;
		}
		 public void setAccountofmis(Integer accountofmis){
			this.accountofmis = accountofmis;
		}
	  
		public Integer getAccountofmis(){
			return this.accountofmis;
		}
		 public void setEmailusercount(Integer emailusercount){
			this.emailusercount = emailusercount;
		}
	  
		public Integer getEmailusercount(){
			return this.emailusercount;
		}
		 public void setOnlinecoursecount(Integer onlinecoursecount){
			this.onlinecoursecount = onlinecoursecount;
		}
	  
		public Integer getOnlinecoursecount(){
			return this.onlinecoursecount;
		}
		 public void setTotaldigitalresource(Integer totaldigitalresource){
			this.totaldigitalresource = totaldigitalresource;
		}
	  
		public Integer getTotaldigitalresource(){
			return this.totaldigitalresource;
		}
		 public void setElectronicbook(Integer electronicbook){
			this.electronicbook = electronicbook;
		}
	  
		public Integer getElectronicbook(){
			return this.electronicbook;
		}
		 public void setMultimediacapacity(Integer multimediacapacity){
			this.multimediacapacity = multimediacapacity;
		}
	  
		public Integer getMultimediacapacity(){
			return this.multimediacapacity;
		}
		 public void setNationallevelresource(Integer nationallevelresource){
			this.nationallevelresource = nationallevelresource;
		}
	  
		public Integer getNationallevelresource(){
			return this.nationallevelresource;
		}
		 public void setProvincialresource(Integer provincialresource){
			this.provincialresource = provincialresource;
		}
	  
		public Integer getProvincialresource(){
			return this.provincialresource;
		}
		 public void setAllinonecardusage(Integer allinonecardusage){
			this.allinonecardusage = allinonecardusage;
		}
	  
		public Integer getAllinonecardusage(){
			return this.allinonecardusage;
		}
		 public void setWirelesscoverage(Integer wirelesscoverage){
			this.wirelesscoverage = wirelesscoverage;
		}
	  
		public Integer getWirelesscoverage(){
			return this.wirelesscoverage;
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
