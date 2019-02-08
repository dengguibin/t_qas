/**
*/
package	com.deceen.diagnosereport.analy.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasTDiagnosticreportsummry.java   唯一标识
* @Description: qas_t_diagnosticreportsummry   
* @author upaths@gmail.com  
* @date 2017-12-6 11:23:46
* @version V1.0   
*/
@SuppressWarnings("serial")	
public class QasTDiagnosticreportsummry extends Pagination implements Serializable{ 	
	
	 //唯一标识 @PrimaryKey
	private String id;
	 //根据权重计算的量化成果总分 
	private Integer quantitativetotalscore;
	 //根据权重计算的标志性成果总分 
	private Integer productivetotalscore;
	 //等级 
	private String rankstring;
	 //排名 
	private Integer precedence;
	 //总体概况 
	private String overview;
	 //存在问题 
	private String problems;
	 //改进建议 
	private String suggestions;
	 //量化指标总分 
	private Integer quantitativeratescore;
	 //标志性成果指标总分(%) 
	private Integer productiveratescore;
	 //综合评分 
	private Integer overallscore;
	 //住户Id 
	private String tenantid;

		 public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setQuantitativetotalscore(Integer quantitativetotalscore){
			this.quantitativetotalscore = quantitativetotalscore;
		}
	  
		public Integer getQuantitativetotalscore(){
			return this.quantitativetotalscore;
		}
		 public void setProductivetotalscore(Integer productivetotalscore){
			this.productivetotalscore = productivetotalscore;
		}
	  
		public Integer getProductivetotalscore(){
			return this.productivetotalscore;
		}
		 public void setRankstring(String rankstring){
			this.rankstring = rankstring;
		}
	  
		public String getRankstring(){
			return this.rankstring;
		}
		 public void setPrecedence(Integer precedence){
			this.precedence = precedence;
		}
	  
		public Integer getPrecedence(){
			return this.precedence;
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
		 public void setQuantitativeratescore(Integer quantitativeratescore){
			this.quantitativeratescore = quantitativeratescore;
		}
	  
		public Integer getQuantitativeratescore(){
			return this.quantitativeratescore;
		}
		 public void setProductiveratescore(Integer productiveratescore){
			this.productiveratescore = productiveratescore;
		}
	  
		public Integer getProductiveratescore(){
			return this.productiveratescore;
		}
		 public void setOverallscore(Integer overallscore){
			this.overallscore = overallscore;
		}
	  
		public Integer getOverallscore(){
			return this.overallscore;
		}
		 public void setTenantid(String tenantid){
			this.tenantid = tenantid;
		}
	  
		public String getTenantid(){
			return this.tenantid;
		}
}
