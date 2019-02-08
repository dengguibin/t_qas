package	com.deceen.data.school.collegeEnrolType.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDCollegeenroltype.java   记录标识
* @Description: qas_d_collegeenroltype   
* @author upaths@gmail.com  
* @date 2017-11-22 17:41:43
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDCollegeenroltype extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //全日制高职招生数 
	private Integer collegenum;
	 //基于高考的“知识+技能”招生<-->招生数（人） 
	private Integer seniorexamnum;
	 //对口招生<-->招生数（人） 
	private Integer samepfsnum;
	 //单独考试招生<-->招生数（人） 
	private Integer singleexamnum;
	 //综合评价招生<-->招生数（人） 
	private Integer mulestimatenum;
	 //中高职贯通的招生<-->招生数（人） 
	private Integer midhigconnum;
	 //技能拔尖人才免试招生<-->招生数（人） 
	private Integer noexamnum;
	 //其他 <-->招生数（人） 
	private Integer othernum;
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
	
	
	
	
	 //全日制高职招生数 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String collegenumScope;
	 //基于高考的“知识+技能”招生<-->招生数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String seniorexamnumScope;
	 //对口招生<-->招生数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String samepfsnumScope;
	 //单独考试招生<-->招生数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String singleexamnumScope;
	 //综合评价招生<-->招生数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String mulestimatenumScope;
	 //中高职贯通的招生<-->招生数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String midhigconnumScope;
	 //技能拔尖人才免试招生<-->招生数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String noexamnumScope;

	
	
		 public String getCollegenumScope() {
		return collegenumScope;
	}

	public void setCollegenumScope(String collegenumScope) {
		this.collegenumScope = collegenumScope;
	}

	public String getSeniorexamnumScope() {
		return seniorexamnumScope;
	}

	public void setSeniorexamnumScope(String seniorexamnumScope) {
		this.seniorexamnumScope = seniorexamnumScope;
	}

	public String getSamepfsnumScope() {
		return samepfsnumScope;
	}

	public void setSamepfsnumScope(String samepfsnumScope) {
		this.samepfsnumScope = samepfsnumScope;
	}

	public String getSingleexamnumScope() {
		return singleexamnumScope;
	}

	public void setSingleexamnumScope(String singleexamnumScope) {
		this.singleexamnumScope = singleexamnumScope;
	}

	public String getMulestimatenumScope() {
		return mulestimatenumScope;
	}

	public void setMulestimatenumScope(String mulestimatenumScope) {
		this.mulestimatenumScope = mulestimatenumScope;
	}

	public String getMidhigconnumScope() {
		return midhigconnumScope;
	}

	public void setMidhigconnumScope(String midhigconnumScope) {
		this.midhigconnumScope = midhigconnumScope;
	}

	public String getNoexamnumScope() {
		return noexamnumScope;
	}

	public void setNoexamnumScope(String noexamnumScope) {
		this.noexamnumScope = noexamnumScope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setCollegenum(Integer collegenum){
			this.collegenum = collegenum;
		}
	  
		public Integer getCollegenum(){
			return this.collegenum;
		}
		 public void setSeniorexamnum(Integer seniorexamnum){
			this.seniorexamnum = seniorexamnum;
		}
	  
		public Integer getSeniorexamnum(){
			return this.seniorexamnum;
		}
		 public void setSamepfsnum(Integer samepfsnum){
			this.samepfsnum = samepfsnum;
		}
	  
		public Integer getSamepfsnum(){
			return this.samepfsnum;
		}
		 public void setSingleexamnum(Integer singleexamnum){
			this.singleexamnum = singleexamnum;
		}
	  
		public Integer getSingleexamnum(){
			return this.singleexamnum;
		}
		 public void setMulestimatenum(Integer mulestimatenum){
			this.mulestimatenum = mulestimatenum;
		}
	  
		public Integer getMulestimatenum(){
			return this.mulestimatenum;
		}
		 public void setMidhigconnum(Integer midhigconnum){
			this.midhigconnum = midhigconnum;
		}
	  
		public Integer getMidhigconnum(){
			return this.midhigconnum;
		}
		 public void setNoexamnum(Integer noexamnum){
			this.noexamnum = noexamnum;
		}
	  
		public Integer getNoexamnum(){
			return this.noexamnum;
		}
		 public void setOthernum(Integer othernum){
			this.othernum = othernum;
		}
	  
		public Integer getOthernum(){
			return this.othernum;
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
