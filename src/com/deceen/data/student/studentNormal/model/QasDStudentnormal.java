package	com.deceen.data.student.studentNormal.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDStudentnormal.java   记录标识 
* @Description: qas_d_studentnormal   
* @author upaths@gmail.com  
* @date 2017-11-24 10:39:24
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDStudentnormal extends Pagination implements Serializable{ 	
	
	 //记录标识  @PrimaryKey
	private String id;
	 //学生名称 
	private String studentid;
	 //缺课次数 
	private Integer absence;
	 //迟到次数 
	private Integer tardiness;
	 //早退次数 
	private Integer prematureleave;
	 //早退次数 
	private Integer leaves;
	 //学生综合测评积分 
	private Integer evaluationpoint;
	 //学期内违纪次数 
	private Integer discipline;
	 //学期内犯罪次数 
	private Integer crime;
	 //学期内群体事件次数 
	private Integer groupevent;
	 //学期内责任性伤亡 
	private Integer casualties;
	 //处分次数 
	private Integer punishmenttime;
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
		 public void setStudentid(String studentid){
			this.studentid = studentid;
		}
	  
		public String getStudentid(){
			return this.studentid;
		}
		 public void setAbsence(Integer absence){
			this.absence = absence;
		}
	  
		public Integer getAbsence(){
			return this.absence;
		}
		 public void setTardiness(Integer tardiness){
			this.tardiness = tardiness;
		}
	  
		public Integer getTardiness(){
			return this.tardiness;
		}
		 public void setPrematureleave(Integer prematureleave){
			this.prematureleave = prematureleave;
		}
	  
		public Integer getPrematureleave(){
			return this.prematureleave;
		}
		 public void setLeaves(Integer leaves){
			this.leaves = leaves;
		}
	  
		public Integer getLeaves(){
			return this.leaves;
		}
		 public void setEvaluationpoint(Integer evaluationpoint){
			this.evaluationpoint = evaluationpoint;
		}
	  
		public Integer getEvaluationpoint(){
			return this.evaluationpoint;
		}
		 public void setDiscipline(Integer discipline){
			this.discipline = discipline;
		}
	  
		public Integer getDiscipline(){
			return this.discipline;
		}
		 public void setCrime(Integer crime){
			this.crime = crime;
		}
	  
		public Integer getCrime(){
			return this.crime;
		}
		 public void setGroupevent(Integer groupevent){
			this.groupevent = groupevent;
		}
	  
		public Integer getGroupevent(){
			return this.groupevent;
		}
		 public void setCasualties(Integer casualties){
			this.casualties = casualties;
		}
	  
		public Integer getCasualties(){
			return this.casualties;
		}
		 public void setPunishmenttime(Integer punishmenttime){
			this.punishmenttime = punishmenttime;
		}
	  
		public Integer getPunishmenttime(){
			return this.punishmenttime;
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
