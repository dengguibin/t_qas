/**
*/
package	com.deceen.diagnosereport.analy.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasTDiagnosticquantitativeindicator.java   唯一标识
* @Description: qas_t_diagnosticquantitativeindicator   
* @author upaths@gmail.com  
* @date 2017-12-6 11:23:46
* @version V1.0   
*/
@SuppressWarnings("serial")	
public class QasTDiagnosticquantitativeindicator extends Pagination implements Serializable{ 	
	
	 //唯一标识 @PrimaryKey
	private String id;
	 //要素id 
	private String diagnosticelementid;
	 //content.id 
	private String indicatorcontentid;
	 //content.UniqueId 
	private String indicatorcontentuniqueid;
	 // 
	private String indicatorname;
	 //诊断数据类型:定量，定性，标志性成果 
	private Integer indicatordatatype;
	 //总体概况 
	private String overview;
	 //合格值 
	private Integer qualifiedscore;
	 //诊断分数 
	private Integer diagnosticscore;
	 //当为定性指标，存储为字符串.比如：是 
	private String diagnosticvalue;
	 //指标状态(预警合格不合格),标志性成果达成率用合格不合格表示 
	private Integer indicatorstate;
	 //标志性成果，判断属于哪个级别 
	private Integer classification;
	 //合格定义 
	private String qualifieddefined;
	 //预警定义 
	private String warndefined;
	 //图形类别 
	private Integer chartstype;
	 //不合格定义 
	private String noqualifieddefined;
	 //住户Id 
	private String tenantid;
	 //指标总分 
	private Integer indicatortotalscore;
	 //返回值类型 0:double,1:.百分号,2:string;3:bool; 
	private Integer returntype;
	 //排序 
	private Integer sort;

		 public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setDiagnosticelementid(String diagnosticelementid){
			this.diagnosticelementid = diagnosticelementid;
		}
	  
		public String getDiagnosticelementid(){
			return this.diagnosticelementid;
		}
		 public void setIndicatorcontentid(String indicatorcontentid){
			this.indicatorcontentid = indicatorcontentid;
		}
	  
		public String getIndicatorcontentid(){
			return this.indicatorcontentid;
		}
		 public void setIndicatorcontentuniqueid(String indicatorcontentuniqueid){
			this.indicatorcontentuniqueid = indicatorcontentuniqueid;
		}
	  
		public String getIndicatorcontentuniqueid(){
			return this.indicatorcontentuniqueid;
		}
		 public void setIndicatorname(String indicatorname){
			this.indicatorname = indicatorname;
		}
	  
		public String getIndicatorname(){
			return this.indicatorname;
		}
		 public void setIndicatordatatype(Integer indicatordatatype){
			this.indicatordatatype = indicatordatatype;
		}
	  
		public Integer getIndicatordatatype(){
			return this.indicatordatatype;
		}
		 public void setOverview(String overview){
			this.overview = overview;
		}
	  
		public String getOverview(){
			return this.overview;
		}
		 public void setQualifiedscore(Integer qualifiedscore){
			this.qualifiedscore = qualifiedscore;
		}
	  
		public Integer getQualifiedscore(){
			return this.qualifiedscore;
		}
		 public void setDiagnosticscore(Integer diagnosticscore){
			this.diagnosticscore = diagnosticscore;
		}
	  
		public Integer getDiagnosticscore(){
			return this.diagnosticscore;
		}
		 public void setDiagnosticvalue(String diagnosticvalue){
			this.diagnosticvalue = diagnosticvalue;
		}
	  
		public String getDiagnosticvalue(){
			return this.diagnosticvalue;
		}
		 public void setIndicatorstate(Integer indicatorstate){
			this.indicatorstate = indicatorstate;
		}
	  
		public Integer getIndicatorstate(){
			return this.indicatorstate;
		}
		 public void setClassification(Integer classification){
			this.classification = classification;
		}
	  
		public Integer getClassification(){
			return this.classification;
		}
		 public void setQualifieddefined(String qualifieddefined){
			this.qualifieddefined = qualifieddefined;
		}
	  
		public String getQualifieddefined(){
			return this.qualifieddefined;
		}
		 public void setWarndefined(String warndefined){
			this.warndefined = warndefined;
		}
	  
		public String getWarndefined(){
			return this.warndefined;
		}
		 public void setChartstype(Integer chartstype){
			this.chartstype = chartstype;
		}
	  
		public Integer getChartstype(){
			return this.chartstype;
		}
		 public void setNoqualifieddefined(String noqualifieddefined){
			this.noqualifieddefined = noqualifieddefined;
		}
	  
		public String getNoqualifieddefined(){
			return this.noqualifieddefined;
		}
		 public void setTenantid(String tenantid){
			this.tenantid = tenantid;
		}
	  
		public String getTenantid(){
			return this.tenantid;
		}
		 public void setIndicatortotalscore(Integer indicatortotalscore){
			this.indicatortotalscore = indicatortotalscore;
		}
	  
		public Integer getIndicatortotalscore(){
			return this.indicatortotalscore;
		}
		 public void setReturntype(Integer returntype){
			this.returntype = returntype;
		}
	  
		public Integer getReturntype(){
			return this.returntype;
		}
		 public void setSort(Integer sort){
			this.sort = sort;
		}
	  
		public Integer getSort(){
			return this.sort;
		}
}
