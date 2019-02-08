package	com.deceen.data.student.studAssociation.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDStudassociation.java   社团唯一标识
* @Description: qas_d_studassociation   
* @author upaths@gmail.com  
* @date 2017-11-24 10:29:01
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDStudassociation extends Pagination implements Serializable{ 	
	
	 //社团唯一标识 @PrimaryKey
	private String id;
	 //社团代码 
	private String communitycode;
	 //社团名称(全称)	 
	private String communityname;
	 //社团类别 
	private String communitytype;
	 //登记情况<-->登记日期（年月） 
	private String registrationdate;
	 //登记情况<-->批准单位（部门） 
	private String approvalunit;
	 //注册单位 
	private String registrationunit;
	 //现有成员（人） 
	private Integer membercount;
	 //负责人情况<-->姓名 
	private String headname;
	 //负责人情况<-->所在年级 
	private String headingrade;
	 //负责人情况<-->单位职务 
	private String headduty;
	 //是否设有学分（学时） 
	private String iscredit;
	 //学校指导部门	 
	private String guidancedepartment;
	 //指导教师名单	 
	private String guidanceteacher;
	 //主要活动内容 
	private String activitycontent;
	 //学校分管部门 
	private String management;
	 //活动经费（元） 
	private Integer activityfund;
	 //是否有获奖项目 
	private String isaward;
	 //来源	 
	private String source;
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

		 public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setCommunitycode(String communitycode){
			this.communitycode = communitycode;
		}
	  
		public String getCommunitycode(){
			return this.communitycode;
		}
		 public void setCommunityname(String communityname){
			this.communityname = communityname;
		}
	  
		public String getCommunityname(){
			return this.communityname;
		}
		 public void setCommunitytype(String communitytype){
			this.communitytype = communitytype;
		}
	  
		public String getCommunitytype(){
			return this.communitytype;
		}
		 public void setRegistrationdate(String registrationdate){
			this.registrationdate = registrationdate;
		}
	  
		public String getRegistrationdate(){
			return this.registrationdate;
		}
		 public void setApprovalunit(String approvalunit){
			this.approvalunit = approvalunit;
		}
	  
		public String getApprovalunit(){
			return this.approvalunit;
		}
		 public void setRegistrationunit(String registrationunit){
			this.registrationunit = registrationunit;
		}
	  
		public String getRegistrationunit(){
			return this.registrationunit;
		}
		 public void setMembercount(Integer membercount){
			this.membercount = membercount;
		}
	  
		public Integer getMembercount(){
			return this.membercount;
		}
		 public void setHeadname(String headname){
			this.headname = headname;
		}
	  
		public String getHeadname(){
			return this.headname;
		}
		 public void setHeadingrade(String headingrade){
			this.headingrade = headingrade;
		}
	  
		public String getHeadingrade(){
			return this.headingrade;
		}
		 public void setHeadduty(String headduty){
			this.headduty = headduty;
		}
	  
		public String getHeadduty(){
			return this.headduty;
		}
		 public void setIscredit(String iscredit){
			this.iscredit = iscredit;
		}
	  
		public String getIscredit(){
			return this.iscredit;
		}
		 public void setGuidancedepartment(String guidancedepartment){
			this.guidancedepartment = guidancedepartment;
		}
	  
		public String getGuidancedepartment(){
			return this.guidancedepartment;
		}
		 public void setGuidanceteacher(String guidanceteacher){
			this.guidanceteacher = guidanceteacher;
		}
	  
		public String getGuidanceteacher(){
			return this.guidanceteacher;
		}
		 public void setActivitycontent(String activitycontent){
			this.activitycontent = activitycontent;
		}
	  
		public String getActivitycontent(){
			return this.activitycontent;
		}
		 public void setManagement(String management){
			this.management = management;
		}
	  
		public String getManagement(){
			return this.management;
		}
		 public void setActivityfund(Integer activityfund){
			this.activityfund = activityfund;
		}
	  
		public Integer getActivityfund(){
			return this.activityfund;
		}
		 public void setIsaward(String isaward){
			this.isaward = isaward;
		}
	  
		public String getIsaward(){
			return this.isaward;
		}
		 public void setSource(String source){
			this.source = source;
		}
	  
		public String getSource(){
			return this.source;
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
