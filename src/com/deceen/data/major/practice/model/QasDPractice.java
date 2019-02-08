package	com.deceen.data.major.practice.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDPractice.java   序号
* @Description: qas_d_practice   
* @author upaths@gmail.com  
* @date 2017-11-23 16:08:21
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDPractice extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //专业方向 
	private Integer directionid;
	 //应届毕业生顶岗实习<-->顶岗实习毕业生总数（人） 
	private Integer gradpracticenum;
	 //应届毕业生顶岗实习<-->企业录用顶岗实习毕业生数（人） 
	private Integer recruitednum;
	 //应届毕业生顶岗实习<-->顶岗实习对口毕业生数（人） 
	private Integer samepfsnum;
	 //顶岗实习与保险情况<-->顶岗实习单位总数（个） 
	private Integer companynum;
	 //顶岗实习与保险情况<-->参加保险学生数（人） 
	private String joinednum;
	 //顶岗实习与保险情况<-->保险险种名称(全称)（保险费出资方） 
	private String insurancename;
	 //顶岗实习情况<-->主要实习岗位 
	private String practice_posts;
	 //顶岗实习情况<-->主要实习单位 
	private String practice_compy;
	 //顶岗实习情况<-->实习人数（人） 
	private Integer practicenum;
	 //顶岗实习情况<-->实习时间（月） 
	private Integer practicetime;
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
		 public void setDirectionid(Integer directionid){
			this.directionid = directionid;
		}
	  
		public Integer getDirectionid(){
			return this.directionid;
		}
		 public void setGradpracticenum(Integer gradpracticenum){
			this.gradpracticenum = gradpracticenum;
		}
	  
		public Integer getGradpracticenum(){
			return this.gradpracticenum;
		}
		 public void setRecruitednum(Integer recruitednum){
			this.recruitednum = recruitednum;
		}
	  
		public Integer getRecruitednum(){
			return this.recruitednum;
		}
		 public void setSamepfsnum(Integer samepfsnum){
			this.samepfsnum = samepfsnum;
		}
	  
		public Integer getSamepfsnum(){
			return this.samepfsnum;
		}
		 public void setCompanynum(Integer companynum){
			this.companynum = companynum;
		}
	  
		public Integer getCompanynum(){
			return this.companynum;
		}
		 public void setJoinednum(String joinednum){
			this.joinednum = joinednum;
		}
	  
		public String getJoinednum(){
			return this.joinednum;
		}
		 public void setInsurancename(String insurancename){
			this.insurancename = insurancename;
		}
	  
		public String getInsurancename(){
			return this.insurancename;
		}
		 public void setPractice_posts(String practice_posts){
			this.practice_posts = practice_posts;
		}
	  
		public String getPractice_posts(){
			return this.practice_posts;
		}
		 public void setPractice_compy(String practice_compy){
			this.practice_compy = practice_compy;
		}
	  
		public String getPractice_compy(){
			return this.practice_compy;
		}
		 public void setPracticenum(Integer practicenum){
			this.practicenum = practicenum;
		}
	  
		public Integer getPracticenum(){
			return this.practicenum;
		}
		 public void setPracticetime(Integer practicetime){
			this.practicetime = practicetime;
		}
	  
		public Integer getPracticetime(){
			return this.practicetime;
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
