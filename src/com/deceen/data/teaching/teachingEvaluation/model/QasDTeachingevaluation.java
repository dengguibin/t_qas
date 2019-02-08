package	com.deceen.data.teaching.teachingEvaluation.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDTeachingevaluation.java   序号
* @Description: qas_d_teachingevaluation   
* @author upaths@gmail.com  
* @date 2017-11-24 12:17:34
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDTeachingevaluation extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //评教起始日期（年月） 
	private String teachingevaluationstarttime;
	 //评教终止日期（年月） 
	private String teachingevaluationendtime;
	 //评教客体（教师）<-->评教客体（教师）<-->参与数（人） 
	private Integer numofparticipantteacher;
	 //评教客体（教师）<-->评教客体（教师）<-->总数（人） 
	private Integer totalnumofteacher;
	 //评教主体参与度<-->学生<-->参与数（人） 
	private Integer numofstudent;
	 //评教主体参与度<-->学生<-->总数（人） 
	private Integer totalnumofstudent;
	 //评教主体参与度<-->同行<-->参与数（人） 
	private Integer numofparticipantschoolmate;
	 //评教主体参与度<-->同行<-->总数（人） 
	private Integer totalnumofschoolmate;
	 //评教主体参与度<-->校领导<-->参与数（人） 
	private Integer numofparticipantleader;
	 //评教主体参与度<-->校领导<-->总数（人） 
	private Integer totalnumofleader;
	 //评教主体参与度<-->社会<-->参与数（人） 
	private Integer numofparticipantsociety;
	 //评教主体参与度<-->社会<-->总数（人） 
	private Integer totalnumofsociety;
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
		 public void setTeachingevaluationstarttime(String teachingevaluationstarttime){
			this.teachingevaluationstarttime = teachingevaluationstarttime;
		}
	  
		public String getTeachingevaluationstarttime(){
			return this.teachingevaluationstarttime;
		}
		 public void setTeachingevaluationendtime(String teachingevaluationendtime){
			this.teachingevaluationendtime = teachingevaluationendtime;
		}
	  
		public String getTeachingevaluationendtime(){
			return this.teachingevaluationendtime;
		}
		 public void setNumofparticipantteacher(Integer numofparticipantteacher){
			this.numofparticipantteacher = numofparticipantteacher;
		}
	  
		public Integer getNumofparticipantteacher(){
			return this.numofparticipantteacher;
		}
		 public void setTotalnumofteacher(Integer totalnumofteacher){
			this.totalnumofteacher = totalnumofteacher;
		}
	  
		public Integer getTotalnumofteacher(){
			return this.totalnumofteacher;
		}
		 public void setNumofstudent(Integer numofstudent){
			this.numofstudent = numofstudent;
		}
	  
		public Integer getNumofstudent(){
			return this.numofstudent;
		}
		 public void setTotalnumofstudent(Integer totalnumofstudent){
			this.totalnumofstudent = totalnumofstudent;
		}
	  
		public Integer getTotalnumofstudent(){
			return this.totalnumofstudent;
		}
		 public void setNumofparticipantschoolmate(Integer numofparticipantschoolmate){
			this.numofparticipantschoolmate = numofparticipantschoolmate;
		}
	  
		public Integer getNumofparticipantschoolmate(){
			return this.numofparticipantschoolmate;
		}
		 public void setTotalnumofschoolmate(Integer totalnumofschoolmate){
			this.totalnumofschoolmate = totalnumofschoolmate;
		}
	  
		public Integer getTotalnumofschoolmate(){
			return this.totalnumofschoolmate;
		}
		 public void setNumofparticipantleader(Integer numofparticipantleader){
			this.numofparticipantleader = numofparticipantleader;
		}
	  
		public Integer getNumofparticipantleader(){
			return this.numofparticipantleader;
		}
		 public void setTotalnumofleader(Integer totalnumofleader){
			this.totalnumofleader = totalnumofleader;
		}
	  
		public Integer getTotalnumofleader(){
			return this.totalnumofleader;
		}
		 public void setNumofparticipantsociety(Integer numofparticipantsociety){
			this.numofparticipantsociety = numofparticipantsociety;
		}
	  
		public Integer getNumofparticipantsociety(){
			return this.numofparticipantsociety;
		}
		 public void setTotalnumofsociety(Integer totalnumofsociety){
			this.totalnumofsociety = totalnumofsociety;
		}
	  
		public Integer getTotalnumofsociety(){
			return this.totalnumofsociety;
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
