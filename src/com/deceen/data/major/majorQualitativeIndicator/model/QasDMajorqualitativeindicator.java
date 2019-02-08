package	com.deceen.data.major.majorQualitativeIndicator.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDMajorqualitativeindicator.java   记录标识
* @Description: qas_d_majorqualitativeindicator   
* @author upaths@gmail.com  
* @date 2017-11-23 16:15:03
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDMajorqualitativeindicator extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //专业 
	private String majorid;
	 //专业建设规划是否及时跟踪市场需求变化和产业结构调整的需要，进行SWOT分析
             
	private String ismajorswotanalysis;
	 //是否明确专业核心岗位和能力要求（职业能力分析） 
	private String isoccupationalanalysis;
	 //人才培养方案是否建立三级的论证审核制度(专业、二级学院、学校) 
	private String ishavethreelevelauditsystem;
	 //人才培养方案是否邀请三位以上行业专家和学生代表进行评审 
	private String isinviterepresentativestoreview;
	 //课程体系的实施是否能实现专业能力的培养（课程体系与能力对照表），全部课程标准是否齐备 
	private String iscurriculumsystemavailable;
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
		 public void setMajorid(String majorid){
			this.majorid = majorid;
		}
	  
		public String getMajorid(){
			return this.majorid;
		}
		 public void setIsmajorswotanalysis(String ismajorswotanalysis){
			this.ismajorswotanalysis = ismajorswotanalysis;
		}
	  
		public String getIsmajorswotanalysis(){
			return this.ismajorswotanalysis;
		}
		 public void setIsoccupationalanalysis(String isoccupationalanalysis){
			this.isoccupationalanalysis = isoccupationalanalysis;
		}
	  
		public String getIsoccupationalanalysis(){
			return this.isoccupationalanalysis;
		}
		 public void setIshavethreelevelauditsystem(String ishavethreelevelauditsystem){
			this.ishavethreelevelauditsystem = ishavethreelevelauditsystem;
		}
	  
		public String getIshavethreelevelauditsystem(){
			return this.ishavethreelevelauditsystem;
		}
		 public void setIsinviterepresentativestoreview(String isinviterepresentativestoreview){
			this.isinviterepresentativestoreview = isinviterepresentativestoreview;
		}
	  
		public String getIsinviterepresentativestoreview(){
			return this.isinviterepresentativestoreview;
		}
		 public void setIscurriculumsystemavailable(String iscurriculumsystemavailable){
			this.iscurriculumsystemavailable = iscurriculumsystemavailable;
		}
	  
		public String getIscurriculumsystemavailable(){
			return this.iscurriculumsystemavailable;
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
