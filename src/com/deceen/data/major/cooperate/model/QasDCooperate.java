package	com.deceen.data.major.cooperate.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDCooperate.java   序号
* @Description: qas_d_cooperate   
* @author upaths@gmail.com  
* @date 2017-11-23 16:09:27
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDCooperate extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //专业方向 
	private String directionid;
	 //产学合作企业总数（个) 
	private Integer companies;
	 //订单培养数（人） 
	private Integer ordercount;
	 //共同开发课程数（门） 
	private Integer teachcourse;
	 //共同开发教材数（种） 
	private Integer teachmaterial;
	 //支持学校兼职教师数（人） 
	private Integer parttimetch;
	 //接受顶岗实习学生数（人） 
	private Integer practicestud;
	 //对学校捐赠设备总值（万元） 
	private Integer donatedevval;
	 //对学校准捐赠设备总值（万元） 
	private Integer readydonateval;
	 //接受毕业生就业数（人） 
	private Integer accesswork;
	 //学校为企业技术服务年收入（万元） 
	private Integer servicevalue;
	 //学校为企业年培训员工数（人天） 
	private Integer traincount;
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
		 public void setCompanies(Integer companies){
			this.companies = companies;
		}
	  
		public Integer getCompanies(){
			return this.companies;
		}
		 public void setOrdercount(Integer ordercount){
			this.ordercount = ordercount;
		}
	  
		public Integer getOrdercount(){
			return this.ordercount;
		}
		 public void setTeachcourse(Integer teachcourse){
			this.teachcourse = teachcourse;
		}
	  
		public Integer getTeachcourse(){
			return this.teachcourse;
		}
		 public void setTeachmaterial(Integer teachmaterial){
			this.teachmaterial = teachmaterial;
		}
	  
		public Integer getTeachmaterial(){
			return this.teachmaterial;
		}
		 public void setParttimetch(Integer parttimetch){
			this.parttimetch = parttimetch;
		}
	  
		public Integer getParttimetch(){
			return this.parttimetch;
		}
		 public void setPracticestud(Integer practicestud){
			this.practicestud = practicestud;
		}
	  
		public Integer getPracticestud(){
			return this.practicestud;
		}
		 public void setDonatedevval(Integer donatedevval){
			this.donatedevval = donatedevval;
		}
	  
		public Integer getDonatedevval(){
			return this.donatedevval;
		}
		 public void setReadydonateval(Integer readydonateval){
			this.readydonateval = readydonateval;
		}
	  
		public Integer getReadydonateval(){
			return this.readydonateval;
		}
		 public void setAccesswork(Integer accesswork){
			this.accesswork = accesswork;
		}
	  
		public Integer getAccesswork(){
			return this.accesswork;
		}
		 public void setServicevalue(Integer servicevalue){
			this.servicevalue = servicevalue;
		}
	  
		public Integer getServicevalue(){
			return this.servicevalue;
		}
		 public void setTraincount(Integer traincount){
			this.traincount = traincount;
		}
	  
		public Integer getTraincount(){
			return this.traincount;
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
