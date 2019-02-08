package	com.deceen.data.student.studAssociationStatistics.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDStudassociationstatistics.java   记录标识
* @Description: qas_d_studassociationstatistics   
* @author upaths@gmail.com  
* @date 2017-11-24 10:30:46
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDStudassociationstatistics extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //社团 
	private String communityid;
	 //举办活动次数 
	private Integer activitycount;
	 //参与活动总人数 
	private Integer participantinactivity;
	 //会员数量（人）<-->总数	 
	private Integer membertotal;
	 //会员数量（人）<-->教工数 
	private Integer employeemembernum;
	 //会员数量（人）<-->学生数 
	private Integer studentmembernum;
	 //会费情况（元）<-->总数 
	private Integer duenum;
	 //会费情况（元）<-->总数 
	private Integer handinnum;
	 //会费情况（元）<-->留存自用 
	private Integer remainnum;
	 //活动经费来源（元）<-->总数 
	private Integer activityfund;
	 //活动经费来源（元）<-->会费 
	private Integer activitydue;
	 //活动经费来源（元）<-->学校拨款 
	private Integer activityfundfromschool;
	 //活动经费来源（元）<-->留存自用的捐款 
	private Integer activityremain;
	 //活动经费来源（元）<-->其他 
	private Integer activityothers;
	 //捐赠情况（元）<-->总数 
	private Integer donationtotal;
	 //捐赠情况（元）<-->上交业务主管单位	 
	private Integer donationhandin;
	 //捐赠情况（元）<-->留存自用主要活动内容 
	private Integer donationremain;
	 //培训情况<-->总数（人次） 
	private Integer trainingtotal;
	 //培训情况<-->获得证书数（本） 
	private Integer trainingcertcount;
	 //造血干细胞（人次）<-->采集数 
	private Integer hematopoieticstemcellcount;
	 //造血干细胞（人次）<-->配对数	 
	private Integer hematopoieticstemcellpair;
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
		 public void setCommunityid(String communityid){
			this.communityid = communityid;
		}
	  
		public String getCommunityid(){
			return this.communityid;
		}
		 public void setActivitycount(Integer activitycount){
			this.activitycount = activitycount;
		}
	  
		public Integer getActivitycount(){
			return this.activitycount;
		}
		 public void setParticipantinactivity(Integer participantinactivity){
			this.participantinactivity = participantinactivity;
		}
	  
		public Integer getParticipantinactivity(){
			return this.participantinactivity;
		}
		 public void setMembertotal(Integer membertotal){
			this.membertotal = membertotal;
		}
	  
		public Integer getMembertotal(){
			return this.membertotal;
		}
		 public void setEmployeemembernum(Integer employeemembernum){
			this.employeemembernum = employeemembernum;
		}
	  
		public Integer getEmployeemembernum(){
			return this.employeemembernum;
		}
		 public void setStudentmembernum(Integer studentmembernum){
			this.studentmembernum = studentmembernum;
		}
	  
		public Integer getStudentmembernum(){
			return this.studentmembernum;
		}
		 public void setDuenum(Integer duenum){
			this.duenum = duenum;
		}
	  
		public Integer getDuenum(){
			return this.duenum;
		}
		 public void setHandinnum(Integer handinnum){
			this.handinnum = handinnum;
		}
	  
		public Integer getHandinnum(){
			return this.handinnum;
		}
		 public void setRemainnum(Integer remainnum){
			this.remainnum = remainnum;
		}
	  
		public Integer getRemainnum(){
			return this.remainnum;
		}
		 public void setActivityfund(Integer activityfund){
			this.activityfund = activityfund;
		}
	  
		public Integer getActivityfund(){
			return this.activityfund;
		}
		 public void setActivitydue(Integer activitydue){
			this.activitydue = activitydue;
		}
	  
		public Integer getActivitydue(){
			return this.activitydue;
		}
		 public void setActivityfundfromschool(Integer activityfundfromschool){
			this.activityfundfromschool = activityfundfromschool;
		}
	  
		public Integer getActivityfundfromschool(){
			return this.activityfundfromschool;
		}
		 public void setActivityremain(Integer activityremain){
			this.activityremain = activityremain;
		}
	  
		public Integer getActivityremain(){
			return this.activityremain;
		}
		 public void setActivityothers(Integer activityothers){
			this.activityothers = activityothers;
		}
	  
		public Integer getActivityothers(){
			return this.activityothers;
		}
		 public void setDonationtotal(Integer donationtotal){
			this.donationtotal = donationtotal;
		}
	  
		public Integer getDonationtotal(){
			return this.donationtotal;
		}
		 public void setDonationhandin(Integer donationhandin){
			this.donationhandin = donationhandin;
		}
	  
		public Integer getDonationhandin(){
			return this.donationhandin;
		}
		 public void setDonationremain(Integer donationremain){
			this.donationremain = donationremain;
		}
	  
		public Integer getDonationremain(){
			return this.donationremain;
		}
		 public void setTrainingtotal(Integer trainingtotal){
			this.trainingtotal = trainingtotal;
		}
	  
		public Integer getTrainingtotal(){
			return this.trainingtotal;
		}
		 public void setTrainingcertcount(Integer trainingcertcount){
			this.trainingcertcount = trainingcertcount;
		}
	  
		public Integer getTrainingcertcount(){
			return this.trainingcertcount;
		}
		 public void setHematopoieticstemcellcount(Integer hematopoieticstemcellcount){
			this.hematopoieticstemcellcount = hematopoieticstemcellcount;
		}
	  
		public Integer getHematopoieticstemcellcount(){
			return this.hematopoieticstemcellcount;
		}
		 public void setHematopoieticstemcellpair(Integer hematopoieticstemcellpair){
			this.hematopoieticstemcellpair = hematopoieticstemcellpair;
		}
	  
		public Integer getHematopoieticstemcellpair(){
			return this.hematopoieticstemcellpair;
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
