package	com.deceen.data.major.graduateEmployment.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDGraduateemployment.java   序号
* @Description: qas_d_graduateemployment   
* @author upaths@gmail.com  
* @date 2017-11-23 16:13:42
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDGraduateemployment extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //专业方向 
	private String directionid;
	 //毕业生就业情况<-->就业数（人） 
	private Integer empnum;
	 //毕业生就业情况<-->本地市<-->就业数（人） 
	private Integer cityempnum;
	 //毕业生就业情况<-->本省市<-->就业数（人） 
	private Integer privincenum;
	 //毕业生就业情况<-->本区域<-->就业数（人） 
	private Integer column_13areanum;
	 //毕业生就业情况<-->其他<-->就业数（人） 
	private Integer othernum;
	 //毕业生就业情况<-->起薪线 
	private Integer empsalary;
	 //毕业生就业情况<-->对口就业<-->就业数（人） 
	private Integer samepfsnum;
	 //毕业生普通高中生<-->毕业生数（人） 
	private Integer hightschgradnum;
	 //毕业生普通高中生<-->就业数（人） 
	private Integer hightschnum;
	 //毕业生“三校生”<-->毕业生数（人） 
	private Integer trischgradnum;
	 //毕业生“三校生”<-->就业数（人） 
	private Integer trischnum;
	 //毕业生“3＋2”<-->毕业生数（人） 
	private Integer threeaddtowgradnum;
	 //毕业生“3＋2”<-->就业数（人） 
	private Integer threeaddtownum;
	 //毕业生五年制高职<-->毕业生数（人） 
	private Integer collegegradnum;
	 //毕业生五年制高职<-->就业数（人） 
	private Integer collegenum;
	 //毕业生基于不同招生方式生源的就业情况<-->基于高考的“知识+技能”招生<-->毕业生数（人） 
	private Integer difsknowskgrad;
	 //毕业生基于不同招生方式生源的就业情况<-->基于高考的“知识+技能”招生<-->就业数（人） 
	private Integer difsknowsknum;
	 //毕业生基于不同招生方式生源的就业情况<-->对口招生<-->毕业生数（人） 
	private Integer difssamepfsgrad;
	 //毕业生基于不同招生方式生源的就业情况<-->对口招生<-->就业数（人） 
	private Integer difssamepfsnum;
	 //毕业生基于不同招生方式生源的就业情况<-->单独考试招生<-->毕业生数（人）	 
	private Integer difssglexamgrad;
	 //毕业生基于不同招生方式生源的就业情况<-->单独考试招生<-->就业数（人） 
	private Integer difssglexamnum;
	 //毕业生基于不同招生方式生源的就业情况<-->综合评价招生<-->毕业生数（人） 
	private Integer difsmulestgrad;
	 //毕业生基于不同招生方式生源的就业情况<-->综合评价招生<-->就业数（人） 
	private Integer difsmulestnum;
	 //毕业生基于不同招生方式生源的就业情况<-->中高职贯通的招生<-->毕业生数（人） 
	private Integer difsmidhiggrad;
	 //毕业生基于不同招生方式生源的就业情况<-->中高职贯通的招生<-->就业数（人） 
	private Integer difsmidhignum;
	 //毕业生基于不同招生方式生源的就业情况<-->技能拨尖人才免试招生<-->毕业生数（人） 
	private Integer difsnoexamgrad;
	 //毕业生基于不同招生方式生源的就业情况<-->技能拨尖人才免试招生<-->就业数（人） 
	private Integer difsnoexamnum;
	 //毕业生基于不同招生方式生源的就业情况<-->其他<-->毕业生数（人） 
	private Integer difsothergrad;
	 //毕业生基于不同招生方式生源的就业情况<-->其他<-->就业数（人） 
	private Integer difsothernum;
	 //毕业生数 
	private Integer gradnum;
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
		 public void setEmpnum(Integer empnum){
			this.empnum = empnum;
		}
	  
		public Integer getEmpnum(){
			return this.empnum;
		}
		 public void setCityempnum(Integer cityempnum){
			this.cityempnum = cityempnum;
		}
	  
		public Integer getCityempnum(){
			return this.cityempnum;
		}
		 public void setPrivincenum(Integer privincenum){
			this.privincenum = privincenum;
		}
	  
		public Integer getPrivincenum(){
			return this.privincenum;
		}
		 public void setColumn_13areanum(Integer column_13areanum){
			this.column_13areanum = column_13areanum;
		}
	  
		public Integer getColumn_13areanum(){
			return this.column_13areanum;
		}
		 public void setOthernum(Integer othernum){
			this.othernum = othernum;
		}
	  
		public Integer getOthernum(){
			return this.othernum;
		}
		 public void setEmpsalary(Integer empsalary){
			this.empsalary = empsalary;
		}
	  
		public Integer getEmpsalary(){
			return this.empsalary;
		}
		 public void setSamepfsnum(Integer samepfsnum){
			this.samepfsnum = samepfsnum;
		}
	  
		public Integer getSamepfsnum(){
			return this.samepfsnum;
		}
		 public void setHightschgradnum(Integer hightschgradnum){
			this.hightschgradnum = hightschgradnum;
		}
	  
		public Integer getHightschgradnum(){
			return this.hightschgradnum;
		}
		 public void setHightschnum(Integer hightschnum){
			this.hightschnum = hightschnum;
		}
	  
		public Integer getHightschnum(){
			return this.hightschnum;
		}
		 public void setTrischgradnum(Integer trischgradnum){
			this.trischgradnum = trischgradnum;
		}
	  
		public Integer getTrischgradnum(){
			return this.trischgradnum;
		}
		 public void setTrischnum(Integer trischnum){
			this.trischnum = trischnum;
		}
	  
		public Integer getTrischnum(){
			return this.trischnum;
		}
		 public void setThreeaddtowgradnum(Integer threeaddtowgradnum){
			this.threeaddtowgradnum = threeaddtowgradnum;
		}
	  
		public Integer getThreeaddtowgradnum(){
			return this.threeaddtowgradnum;
		}
		 public void setThreeaddtownum(Integer threeaddtownum){
			this.threeaddtownum = threeaddtownum;
		}
	  
		public Integer getThreeaddtownum(){
			return this.threeaddtownum;
		}
		 public void setCollegegradnum(Integer collegegradnum){
			this.collegegradnum = collegegradnum;
		}
	  
		public Integer getCollegegradnum(){
			return this.collegegradnum;
		}
		 public void setCollegenum(Integer collegenum){
			this.collegenum = collegenum;
		}
	  
		public Integer getCollegenum(){
			return this.collegenum;
		}
		 public void setDifsknowskgrad(Integer difsknowskgrad){
			this.difsknowskgrad = difsknowskgrad;
		}
	  
		public Integer getDifsknowskgrad(){
			return this.difsknowskgrad;
		}
		 public void setDifsknowsknum(Integer difsknowsknum){
			this.difsknowsknum = difsknowsknum;
		}
	  
		public Integer getDifsknowsknum(){
			return this.difsknowsknum;
		}
		 public void setDifssamepfsgrad(Integer difssamepfsgrad){
			this.difssamepfsgrad = difssamepfsgrad;
		}
	  
		public Integer getDifssamepfsgrad(){
			return this.difssamepfsgrad;
		}
		 public void setDifssamepfsnum(Integer difssamepfsnum){
			this.difssamepfsnum = difssamepfsnum;
		}
	  
		public Integer getDifssamepfsnum(){
			return this.difssamepfsnum;
		}
		 public void setDifssglexamgrad(Integer difssglexamgrad){
			this.difssglexamgrad = difssglexamgrad;
		}
	  
		public Integer getDifssglexamgrad(){
			return this.difssglexamgrad;
		}
		 public void setDifssglexamnum(Integer difssglexamnum){
			this.difssglexamnum = difssglexamnum;
		}
	  
		public Integer getDifssglexamnum(){
			return this.difssglexamnum;
		}
		 public void setDifsmulestgrad(Integer difsmulestgrad){
			this.difsmulestgrad = difsmulestgrad;
		}
	  
		public Integer getDifsmulestgrad(){
			return this.difsmulestgrad;
		}
		 public void setDifsmulestnum(Integer difsmulestnum){
			this.difsmulestnum = difsmulestnum;
		}
	  
		public Integer getDifsmulestnum(){
			return this.difsmulestnum;
		}
		 public void setDifsmidhiggrad(Integer difsmidhiggrad){
			this.difsmidhiggrad = difsmidhiggrad;
		}
	  
		public Integer getDifsmidhiggrad(){
			return this.difsmidhiggrad;
		}
		 public void setDifsmidhignum(Integer difsmidhignum){
			this.difsmidhignum = difsmidhignum;
		}
	  
		public Integer getDifsmidhignum(){
			return this.difsmidhignum;
		}
		 public void setDifsnoexamgrad(Integer difsnoexamgrad){
			this.difsnoexamgrad = difsnoexamgrad;
		}
	  
		public Integer getDifsnoexamgrad(){
			return this.difsnoexamgrad;
		}
		 public void setDifsnoexamnum(Integer difsnoexamnum){
			this.difsnoexamnum = difsnoexamnum;
		}
	  
		public Integer getDifsnoexamnum(){
			return this.difsnoexamnum;
		}
		 public void setDifsothergrad(Integer difsothergrad){
			this.difsothergrad = difsothergrad;
		}
	  
		public Integer getDifsothergrad(){
			return this.difsothergrad;
		}
		 public void setDifsothernum(Integer difsothernum){
			this.difsothernum = difsothernum;
		}
	  
		public Integer getDifsothernum(){
			return this.difsothernum;
		}
		 public void setGradnum(Integer gradnum){
			this.gradnum = gradnum;
		}
	  
		public Integer getGradnum(){
			return this.gradnum;
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
