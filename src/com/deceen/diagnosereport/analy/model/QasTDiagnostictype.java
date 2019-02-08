/**
*/
package	com.deceen.diagnosereport.analy.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasTDiagnostictype.java   唯一标识
* @Description: qas_t_diagnostictype   
* @author upaths@gmail.com  
* @date 2017-12-6 11:23:46
* @version V1.0   
*/
@SuppressWarnings("serial")
public class QasTDiagnostictype extends Pagination implements Serializable{ 	
	
	 //唯一标识 @PrimaryKey
	private String id;
	 //诊断中介id 
	private String diagnosticintermediaryid;
	 //catalog.id 
	private String indicatorcatalogid;
	 //catalog.UniqueId 
	private String indicatorcataloguniqueid;
	 //总体概况 
	private String overview;
	 //存在问题 
	private String problems;
	 //改进建议 
	private String suggestions;
	 //结论 
	private String conclusion;
	 //住户Id 
	private String tenantid;
	 //计分权重 
	private Float weight;
	 //排序 
	private Integer sort;

		 public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setDiagnosticintermediaryid(String diagnosticintermediaryid){
			this.diagnosticintermediaryid = diagnosticintermediaryid;
		}
	  
		public String getDiagnosticintermediaryid(){
			return this.diagnosticintermediaryid;
		}
		 public void setIndicatorcatalogid(String indicatorcatalogid){
			this.indicatorcatalogid = indicatorcatalogid;
		}
	  
		public String getIndicatorcatalogid(){
			return this.indicatorcatalogid;
		}
		 public void setIndicatorcataloguniqueid(String indicatorcataloguniqueid){
			this.indicatorcataloguniqueid = indicatorcataloguniqueid;
		}
	  
		public String getIndicatorcataloguniqueid(){
			return this.indicatorcataloguniqueid;
		}
		 public void setOverview(String overview){
			this.overview = overview;
		}
	  
		public String getOverview(){
			return this.overview;
		}
		 public void setProblems(String problems){
			this.problems = problems;
		}
	  
		public String getProblems(){
			return this.problems;
		}
		 public void setSuggestions(String suggestions){
			this.suggestions = suggestions;
		}
	  
		public String getSuggestions(){
			return this.suggestions;
		}
		 public void setConclusion(String conclusion){
			this.conclusion = conclusion;
		}
	  
		public String getConclusion(){
			return this.conclusion;
		}
		 public void setTenantid(String tenantid){
			this.tenantid = tenantid;
		}
	  
		public String getTenantid(){
			return this.tenantid;
		}
		 public void setWeight(Float weight){
			this.weight = weight;
		}
	  
		public Float getWeight(){
			return this.weight;
		}
		 public void setSort(Integer sort){
			this.sort = sort;
		}
	  
		public Integer getSort(){
			return this.sort;
		}
}
