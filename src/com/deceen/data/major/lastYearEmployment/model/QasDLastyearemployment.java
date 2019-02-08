package	com.deceen.data.major.lastYearEmployment.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDLastyearemployment.java   序号
* @Description: qas_d_lastyearemployment   
* @author upaths@gmail.com  
* @date 2017-11-23 16:14:22
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDLastyearemployment extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //专业方向 
	private String directionid;
	 //毕业生数（人） 
	private Integer gradnum;
	 //毕业生就业情况<-->就业数(人) 
	private Integer empnum;
	 //毕业生就业情况<-->升迁数（人） 
	private Integer promotion;
	 //毕业生就业情况<-->转岗数（人） 
	private Integer tranwork;
	 //毕业生用人单位满意情况<-->满意或基本满意人数 
	private Integer satisfied;
	 //毕业生用人单位满意情况<-->一般满意人数 
	private Integer nomal;
	 //毕业生用人单位满意情况<-->不满意人数 
	private Integer dissatisfied;
	 //毕业生的教学满意人数 
	private Integer satisfiedwithteaching;
	 //毕业生对母校的满意人数 
	private Integer satisfiedwithcollege;
	 //毕业生工作与职业期待吻合人数 
	private Integer workandcareerexpectationsmatch;
	 //毕业生对基本工作能力总体满足人数 
	private Integer satisfiedwithworkability;
	 //毕业生对核心知识的总体满足人数 
	private Integer satisfiedwithcoreknowledge;
	 //毕业生的就业现状满意人数  
	private Integer satisfiedwithemployment;
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
		 public void setDirectionid(String directionid){
			this.directionid = directionid;
		}
	  
		public String getDirectionid(){
			return this.directionid;
		}
		 public void setGradnum(Integer gradnum){
			this.gradnum = gradnum;
		}
	  
		public Integer getGradnum(){
			return this.gradnum;
		}
		 public void setEmpnum(Integer empnum){
			this.empnum = empnum;
		}
	  
		public Integer getEmpnum(){
			return this.empnum;
		}
		 public void setPromotion(Integer promotion){
			this.promotion = promotion;
		}
	  
		public Integer getPromotion(){
			return this.promotion;
		}
		 public void setTranwork(Integer tranwork){
			this.tranwork = tranwork;
		}
	  
		public Integer getTranwork(){
			return this.tranwork;
		}
		 public void setSatisfied(Integer satisfied){
			this.satisfied = satisfied;
		}
	  
		public Integer getSatisfied(){
			return this.satisfied;
		}
		 public void setNomal(Integer nomal){
			this.nomal = nomal;
		}
	  
		public Integer getNomal(){
			return this.nomal;
		}
		 public void setDissatisfied(Integer dissatisfied){
			this.dissatisfied = dissatisfied;
		}
	  
		public Integer getDissatisfied(){
			return this.dissatisfied;
		}
		 public void setSatisfiedwithteaching(Integer satisfiedwithteaching){
			this.satisfiedwithteaching = satisfiedwithteaching;
		}
	  
		public Integer getSatisfiedwithteaching(){
			return this.satisfiedwithteaching;
		}
		 public void setSatisfiedwithcollege(Integer satisfiedwithcollege){
			this.satisfiedwithcollege = satisfiedwithcollege;
		}
	  
		public Integer getSatisfiedwithcollege(){
			return this.satisfiedwithcollege;
		}
		 public void setWorkandcareerexpectationsmatch(Integer workandcareerexpectationsmatch){
			this.workandcareerexpectationsmatch = workandcareerexpectationsmatch;
		}
	  
		public Integer getWorkandcareerexpectationsmatch(){
			return this.workandcareerexpectationsmatch;
		}
		 public void setSatisfiedwithworkability(Integer satisfiedwithworkability){
			this.satisfiedwithworkability = satisfiedwithworkability;
		}
	  
		public Integer getSatisfiedwithworkability(){
			return this.satisfiedwithworkability;
		}
		 public void setSatisfiedwithcoreknowledge(Integer satisfiedwithcoreknowledge){
			this.satisfiedwithcoreknowledge = satisfiedwithcoreknowledge;
		}
	  
		public Integer getSatisfiedwithcoreknowledge(){
			return this.satisfiedwithcoreknowledge;
		}
		 public void setSatisfiedwithemployment(Integer satisfiedwithemployment){
			this.satisfiedwithemployment = satisfiedwithemployment;
		}
	  
		public Integer getSatisfiedwithemployment(){
			return this.satisfiedwithemployment;
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
