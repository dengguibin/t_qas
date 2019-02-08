package	com.deceen.data.student.retiredSoldiers.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDRetiredsoldiers.java   状态
* @Description: qas_d_retiredsoldiers   
* @author upaths@gmail.com  
* @date 2017-11-24 10:37:22
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDRetiredsoldiers extends Pagination implements Serializable{ 	
	
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
	 //记录标识 @PrimaryKey
	private String id;
	 //当年招生数（人）<-->合计 
	private Integer enrolltotal;
	 //当年招生数（人）<-->复转军人 
	private Integer enrollarmymen;
	 //当年招生数（人）<-->退役士兵 
	private Integer enrollretiredsoldier;
	 //在校生数(人)<-->合计 
	private Integer inschooltotal;
	 //在校生数(人)<-->复转军人 
	private Integer inschoolarmymen;
	 //在校生数(人)<-->退役士兵 
	private Integer inschoolretiredsoldier;
	 //社会培训（人次）<-->合计 
	private Integer societytrainingtotal;
	 //社会培训（人次）<-->复转军人 
	private Integer societytrainingarmymen;
	 //社会培训（人次）<-->退役士兵 
	private Integer societytrainingretiredsoldier;
	
	 //当年招生数（人）<-->合计 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String enrolltotalScope;
	 //当年招生数（人）<-->复转军人 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String enrollarmymenScope;
	 //当年招生数（人）<-->退役士兵 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String enrollretiredsoldierScope;
	 //在校生数(人)<-->合计 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String inschooltotalScope;
	 //在校生数(人)<-->复转军人 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String inschoolarmymenScope;
	 //在校生数(人)<-->退役士兵 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String inschoolretiredsoldierScope;
	 //社会培训（人次）<-->合计 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String societytrainingtotalScope;
	 //社会培训（人次）<-->复转军人 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String societytrainingarmymenScope;
	 //社会培训（人次）<-->退役士兵 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String societytrainingretiredsoldierScope;
	
	
		 public String getEnrolltotalScope() {
		return enrolltotalScope;
	}

	public void setEnrolltotalScope(String enrolltotalScope) {
		this.enrolltotalScope = enrolltotalScope;
	}

	public String getEnrollarmymenScope() {
		return enrollarmymenScope;
	}

	public void setEnrollarmymenScope(String enrollarmymenScope) {
		this.enrollarmymenScope = enrollarmymenScope;
	}

	public String getEnrollretiredsoldierScope() {
		return enrollretiredsoldierScope;
	}

	public void setEnrollretiredsoldierScope(String enrollretiredsoldierScope) {
		this.enrollretiredsoldierScope = enrollretiredsoldierScope;
	}

	public String getInschooltotalScope() {
		return inschooltotalScope;
	}

	public void setInschooltotalScope(String inschooltotalScope) {
		this.inschooltotalScope = inschooltotalScope;
	}

	public String getInschoolarmymenScope() {
		return inschoolarmymenScope;
	}

	public void setInschoolarmymenScope(String inschoolarmymenScope) {
		this.inschoolarmymenScope = inschoolarmymenScope;
	}

	public String getInschoolretiredsoldierScope() {
		return inschoolretiredsoldierScope;
	}

	public void setInschoolretiredsoldierScope(String inschoolretiredsoldierScope) {
		this.inschoolretiredsoldierScope = inschoolretiredsoldierScope;
	}

	public String getSocietytrainingtotalScope() {
		return societytrainingtotalScope;
	}

	public void setSocietytrainingtotalScope(String societytrainingtotalScope) {
		this.societytrainingtotalScope = societytrainingtotalScope;
	}

	public String getSocietytrainingarmymenScope() {
		return societytrainingarmymenScope;
	}

	public void setSocietytrainingarmymenScope(String societytrainingarmymenScope) {
		this.societytrainingarmymenScope = societytrainingarmymenScope;
	}

	public String getSocietytrainingretiredsoldierScope() {
		return societytrainingretiredsoldierScope;
	}

	public void setSocietytrainingretiredsoldierScope(
			String societytrainingretiredsoldierScope) {
		this.societytrainingretiredsoldierScope = societytrainingretiredsoldierScope;
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
		 public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setEnrolltotal(Integer enrolltotal){
			this.enrolltotal = enrolltotal;
		}
	  
		public Integer getEnrolltotal(){
			return this.enrolltotal;
		}
		 public void setEnrollarmymen(Integer enrollarmymen){
			this.enrollarmymen = enrollarmymen;
		}
	  
		public Integer getEnrollarmymen(){
			return this.enrollarmymen;
		}
		 public void setEnrollretiredsoldier(Integer enrollretiredsoldier){
			this.enrollretiredsoldier = enrollretiredsoldier;
		}
	  
		public Integer getEnrollretiredsoldier(){
			return this.enrollretiredsoldier;
		}
		 public void setInschooltotal(Integer inschooltotal){
			this.inschooltotal = inschooltotal;
		}
	  
		public Integer getInschooltotal(){
			return this.inschooltotal;
		}
		 public void setInschoolarmymen(Integer inschoolarmymen){
			this.inschoolarmymen = inschoolarmymen;
		}
	  
		public Integer getInschoolarmymen(){
			return this.inschoolarmymen;
		}
		 public void setInschoolretiredsoldier(Integer inschoolretiredsoldier){
			this.inschoolretiredsoldier = inschoolretiredsoldier;
		}
	  
		public Integer getInschoolretiredsoldier(){
			return this.inschoolretiredsoldier;
		}
		 public void setSocietytrainingtotal(Integer societytrainingtotal){
			this.societytrainingtotal = societytrainingtotal;
		}
	  
		public Integer getSocietytrainingtotal(){
			return this.societytrainingtotal;
		}
		 public void setSocietytrainingarmymen(Integer societytrainingarmymen){
			this.societytrainingarmymen = societytrainingarmymen;
		}
	  
		public Integer getSocietytrainingarmymen(){
			return this.societytrainingarmymen;
		}
		 public void setSocietytrainingretiredsoldier(Integer societytrainingretiredsoldier){
			this.societytrainingretiredsoldier = societytrainingretiredsoldier;
		}
	  
		public Integer getSocietytrainingretiredsoldier(){
			return this.societytrainingretiredsoldier;
		}
}
