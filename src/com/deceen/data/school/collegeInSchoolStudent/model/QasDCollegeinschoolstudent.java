package	com.deceen.data.school.collegeInSchoolStudent.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDCollegeinschoolstudent.java   记录标识
* @Description: qas_d_collegeinschoolstudent   
* @author upaths@gmail.com  
* @date 2017-11-22 17:42:22
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDCollegeinschoolstudent extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //折合在校生数（人） 
	private Integer offnum;
	 //全日制学历教育在校生数（人） 
	private Integer edustunum;
	 //全日制普通高职学历教育在校生总数（人） 
	private Integer senioredustunum;
	 //其中<-->高中起点 
	private Integer hightpfsstunum;
	 //其中<-->中职起点<-->合计 
	private Integer middlepfsstunum;
	 //其中<-->中职起点<-->五年制后二年 
	private Integer middleschtwoyearbehandnum;
	 //其中<-->其他 
	private Integer othernum;
	 //全日制普通中职学历教育在校生（人)<-->合计 
	private Integer fulltimestunum;
	 //全日制普通中职学历教育在校生（人)<-->五年制前三年 
	private Integer fulltimestuthreeyearbeforenum;
	 //全日制普通中职学历教育在校生（人)<-->新型职业农民 
	private Integer fulltimestufarmernum;
	 //全日制成人高职在校生（人） 
	private Integer adultcollegestunum;
	 //全日制成人中职在校生（人） 
	private Integer adultmiddlestunum;
	 //非全日制专科学历教育注册生（人） 
	private Integer parttimepfseduregnum;
	 //非全日制本科学历教育注册生（人） 
	private Integer parttimesenioreduregnum;
	 //培训(人天)<-->社会 
	private Integer trainsocietynum;
	 //培训(人天)<-->在校生 
	private Integer trainstunum;
	 //培训对象（人次）<-->特定群体 
	private Integer trainspecificgroup;
	 //培训对象（人次）<-->小微企业 
	private Integer trainsmallcompany;
	 //留学生数<-->境外 
	private Integer oversea;
	 //留学生数<-->国外 
	private Integer abroad;
	 //预科生、进修生、成人脱产班学生数合计 
	private Integer adultstudent;
	 //夜大（业余）学生数 
	private Integer eveninguniversitystudent;
	 //函授生数 
	private Integer correspondencestudent;
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
	
	
	
	 //折合在校生数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String offnumScope;
	 //全日制学历教育在校生数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String edustunumScope;
	 //全日制普通高职学历教育在校生总数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String senioredustunumScope;
	 //全日制普通中职学历教育在校生（人)<-->新型职业农民 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String fulltimestufarmernumScope;
	 //全日制成人高职在校生（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String adultcollegestunumScope;
	 //非全日制专科学历教育注册生（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String parttimepfseduregnumScope;
	 //非全日制本科学历教育注册生（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String parttimesenioreduregnumScope;
	
	
		 public String getOffnumScope() {
		return offnumScope;
	}

	public void setOffnumScope(String offnumScope) {
		this.offnumScope = offnumScope;
	}

	public String getEdustunumScope() {
		return edustunumScope;
	}

	public void setEdustunumScope(String edustunumScope) {
		this.edustunumScope = edustunumScope;
	}

	public String getSenioredustunumScope() {
		return senioredustunumScope;
	}

	public void setSenioredustunumScope(String senioredustunumScope) {
		this.senioredustunumScope = senioredustunumScope;
	}

	public String getFulltimestufarmernumScope() {
		return fulltimestufarmernumScope;
	}

	public void setFulltimestufarmernumScope(String fulltimestufarmernumScope) {
		this.fulltimestufarmernumScope = fulltimestufarmernumScope;
	}

	public String getAdultcollegestunumScope() {
		return adultcollegestunumScope;
	}

	public void setAdultcollegestunumScope(String adultcollegestunumScope) {
		this.adultcollegestunumScope = adultcollegestunumScope;
	}

	public String getParttimepfseduregnumScope() {
		return parttimepfseduregnumScope;
	}

	public void setParttimepfseduregnumScope(String parttimepfseduregnumScope) {
		this.parttimepfseduregnumScope = parttimepfseduregnumScope;
	}

	public String getParttimesenioreduregnumScope() {
		return parttimesenioreduregnumScope;
	}

	public void setParttimesenioreduregnumScope(String parttimesenioreduregnumScope) {
		this.parttimesenioreduregnumScope = parttimesenioreduregnumScope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setOffnum(Integer offnum){
			this.offnum = offnum;
		}
	  
		public Integer getOffnum(){
			return this.offnum;
		}
		 public void setEdustunum(Integer edustunum){
			this.edustunum = edustunum;
		}
	  
		public Integer getEdustunum(){
			return this.edustunum;
		}
		 public void setSenioredustunum(Integer senioredustunum){
			this.senioredustunum = senioredustunum;
		}
	  
		public Integer getSenioredustunum(){
			return this.senioredustunum;
		}
		 public void setHightpfsstunum(Integer hightpfsstunum){
			this.hightpfsstunum = hightpfsstunum;
		}
	  
		public Integer getHightpfsstunum(){
			return this.hightpfsstunum;
		}
		 public void setMiddlepfsstunum(Integer middlepfsstunum){
			this.middlepfsstunum = middlepfsstunum;
		}
	  
		public Integer getMiddlepfsstunum(){
			return this.middlepfsstunum;
		}
		 public void setMiddleschtwoyearbehandnum(Integer middleschtwoyearbehandnum){
			this.middleschtwoyearbehandnum = middleschtwoyearbehandnum;
		}
	  
		public Integer getMiddleschtwoyearbehandnum(){
			return this.middleschtwoyearbehandnum;
		}
		 public void setOthernum(Integer othernum){
			this.othernum = othernum;
		}
	  
		public Integer getOthernum(){
			return this.othernum;
		}
		 public void setFulltimestunum(Integer fulltimestunum){
			this.fulltimestunum = fulltimestunum;
		}
	  
		public Integer getFulltimestunum(){
			return this.fulltimestunum;
		}
		 public void setFulltimestuthreeyearbeforenum(Integer fulltimestuthreeyearbeforenum){
			this.fulltimestuthreeyearbeforenum = fulltimestuthreeyearbeforenum;
		}
	  
		public Integer getFulltimestuthreeyearbeforenum(){
			return this.fulltimestuthreeyearbeforenum;
		}
		 public void setFulltimestufarmernum(Integer fulltimestufarmernum){
			this.fulltimestufarmernum = fulltimestufarmernum;
		}
	  
		public Integer getFulltimestufarmernum(){
			return this.fulltimestufarmernum;
		}
		 public void setAdultcollegestunum(Integer adultcollegestunum){
			this.adultcollegestunum = adultcollegestunum;
		}
	  
		public Integer getAdultcollegestunum(){
			return this.adultcollegestunum;
		}
		 public void setAdultmiddlestunum(Integer adultmiddlestunum){
			this.adultmiddlestunum = adultmiddlestunum;
		}
	  
		public Integer getAdultmiddlestunum(){
			return this.adultmiddlestunum;
		}
		 public void setParttimepfseduregnum(Integer parttimepfseduregnum){
			this.parttimepfseduregnum = parttimepfseduregnum;
		}
	  
		public Integer getParttimepfseduregnum(){
			return this.parttimepfseduregnum;
		}
		 public void setParttimesenioreduregnum(Integer parttimesenioreduregnum){
			this.parttimesenioreduregnum = parttimesenioreduregnum;
		}
	  
		public Integer getParttimesenioreduregnum(){
			return this.parttimesenioreduregnum;
		}
		 public void setTrainsocietynum(Integer trainsocietynum){
			this.trainsocietynum = trainsocietynum;
		}
	  
		public Integer getTrainsocietynum(){
			return this.trainsocietynum;
		}
		 public void setTrainstunum(Integer trainstunum){
			this.trainstunum = trainstunum;
		}
	  
		public Integer getTrainstunum(){
			return this.trainstunum;
		}
		 public void setTrainspecificgroup(Integer trainspecificgroup){
			this.trainspecificgroup = trainspecificgroup;
		}
	  
		public Integer getTrainspecificgroup(){
			return this.trainspecificgroup;
		}
		 public void setTrainsmallcompany(Integer trainsmallcompany){
			this.trainsmallcompany = trainsmallcompany;
		}
	  
		public Integer getTrainsmallcompany(){
			return this.trainsmallcompany;
		}
		 public void setOversea(Integer oversea){
			this.oversea = oversea;
		}
	  
		public Integer getOversea(){
			return this.oversea;
		}
		 public void setAbroad(Integer abroad){
			this.abroad = abroad;
		}
	  
		public Integer getAbroad(){
			return this.abroad;
		}
		 public void setAdultstudent(Integer adultstudent){
			this.adultstudent = adultstudent;
		}
	  
		public Integer getAdultstudent(){
			return this.adultstudent;
		}
		 public void setEveninguniversitystudent(Integer eveninguniversitystudent){
			this.eveninguniversitystudent = eveninguniversitystudent;
		}
	  
		public Integer getEveninguniversitystudent(){
			return this.eveninguniversitystudent;
		}
		 public void setCorrespondencestudent(Integer correspondencestudent){
			this.correspondencestudent = correspondencestudent;
		}
	  
		public Integer getCorrespondencestudent(){
			return this.correspondencestudent;
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
