package	com.deceen.data.school.school.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDSchool.java   记录标识
* @Description: qas_d_school   
* @author upaths@gmail.com  
* @date 2017-11-22 17:18:45
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDSchool extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //学校标识码 
	private String code;
	 //学校名称(全称)	 
	private String name;
	 //所在地区（省、自治区、直辖市) 
	private String location;
	 //当前校名启用日期（年月） 
	private String nameuseddate;
	 //建校日期（年月） 
	private String buildeddate;
	 //建校基础	 
	private String buildedbase;
	 //学校举办者<-->名称(全称)   
	private String creatername;
	 //学校举办者<-->性质 
	private String creaternature;
	 //学校举办者<-->级别	 
	private String creatergrade;
	 //学校性质类别 
	private String grade;
	 //校训	 
	private String motto;
	 //通信地址	 
	private String address;
	 //邮政编码 
	private String postcode;
	 //学校网址 
	private String web;
	 //社区教育示范校 
	private String iscommunityedudemonstration;
	 //示范性高等职业院校<-->性质 
	private String exampnature;
	 //示范性高等职业院校<-->级别 
	private String exampgrade;
	 //示范性高等职业院校<-->立项部门 
	private String exampdepartment;
	 //示范性高等职业院校<-->立项日期（年） 
	private String exampbuildedtime;
	 //评估状态<-->第一轮<-->评估日期（年月) 
	private String estimatefirsttime;
	 //评估状态<-->第二轮<-->评估结论 
	private String estimatesecondresult;
	 //评估状态<-->未接受评估 
	private String estimatenorun;
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
		 public void setCode(String code){
			this.code = code;
		}
	  
		public String getCode(){
			return this.code;
		}
		 public void setName(String name){
			this.name = name;
		}
	  
		public String getName(){
			return this.name;
		}
		 public void setLocation(String location){
			this.location = location;
		}
	  
		public String getLocation(){
			return this.location;
		}
		 public void setNameuseddate(String nameuseddate){
			this.nameuseddate = nameuseddate;
		}
	  
		public String getNameuseddate(){
			return this.nameuseddate;
		}
		 public void setBuildeddate(String buildeddate){
			this.buildeddate = buildeddate;
		}
	  
		public String getBuildeddate(){
			return this.buildeddate;
		}
		 public void setBuildedbase(String buildedbase){
			this.buildedbase = buildedbase;
		}
	  
		public String getBuildedbase(){
			return this.buildedbase;
		}
		 public void setCreatername(String creatername){
			this.creatername = creatername;
		}
	  
		public String getCreatername(){
			return this.creatername;
		}
		 public void setCreaternature(String creaternature){
			this.creaternature = creaternature;
		}
	  
		public String getCreaternature(){
			return this.creaternature;
		}
		 public void setCreatergrade(String creatergrade){
			this.creatergrade = creatergrade;
		}
	  
		public String getCreatergrade(){
			return this.creatergrade;
		}
		 public void setGrade(String grade){
			this.grade = grade;
		}
	  
		public String getGrade(){
			return this.grade;
		}
		 public void setMotto(String motto){
			this.motto = motto;
		}
	  
		public String getMotto(){
			return this.motto;
		}
		 public void setAddress(String address){
			this.address = address;
		}
	  
		public String getAddress(){
			return this.address;
		}
		 public void setPostcode(String postcode){
			this.postcode = postcode;
		}
	  
		public String getPostcode(){
			return this.postcode;
		}
		 public void setWeb(String web){
			this.web = web;
		}
	  
		public String getWeb(){
			return this.web;
		}
		 public void setIscommunityedudemonstration(String iscommunityedudemonstration){
			this.iscommunityedudemonstration = iscommunityedudemonstration;
		}
	  
		public String getIscommunityedudemonstration(){
			return this.iscommunityedudemonstration;
		}
		 public void setExampnature(String exampnature){
			this.exampnature = exampnature;
		}
	  
		public String getExampnature(){
			return this.exampnature;
		}
		 public void setExampgrade(String exampgrade){
			this.exampgrade = exampgrade;
		}
	  
		public String getExampgrade(){
			return this.exampgrade;
		}
		 public void setExampdepartment(String exampdepartment){
			this.exampdepartment = exampdepartment;
		}
	  
		public String getExampdepartment(){
			return this.exampdepartment;
		}
		 public void setExampbuildedtime(String exampbuildedtime){
			this.exampbuildedtime = exampbuildedtime;
		}
	  
		public String getExampbuildedtime(){
			return this.exampbuildedtime;
		}
		 public void setEstimatefirsttime(String estimatefirsttime){
			this.estimatefirsttime = estimatefirsttime;
		}
	  
		public String getEstimatefirsttime(){
			return this.estimatefirsttime;
		}
		 public void setEstimatesecondresult(String estimatesecondresult){
			this.estimatesecondresult = estimatesecondresult;
		}
	  
		public String getEstimatesecondresult(){
			return this.estimatesecondresult;
		}
		 public void setEstimatenorun(String estimatenorun){
			this.estimatenorun = estimatenorun;
		}
	  
		public String getEstimatenorun(){
			return this.estimatenorun;
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
