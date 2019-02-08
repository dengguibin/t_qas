/**
*/
package	com.deceen.diagnosereport.analy.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasTDiagnosticproductiveindicator.java   唯一标识
* @Description: qas_t_diagnosticproductiveindicator   
* @author upaths@gmail.com  
* @date 2017-12-6 11:23:46
* @version V1.0   
*/
@SuppressWarnings("serial")
public class QasTDiagnosticproductiveindicator extends Pagination implements Serializable{ 	
	
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
	 //标志性成果级别分为国家、省级、校级 
	private Integer productivelevel;
	 //是否达成 
	private Object isreach;
	 //诊断分数 
	private Integer diagnosticscore;
	 //住户Id 
	private String tenantid;

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
		 public void setProductivelevel(Integer productivelevel){
			this.productivelevel = productivelevel;
		}
	  
		public Integer getProductivelevel(){
			return this.productivelevel;
		}
		 public void setIsreach(Object isreach){
			this.isreach = isreach;
		}
	  
		public Object getIsreach(){
			return this.isreach;
		}
		 public void setDiagnosticscore(Integer diagnosticscore){
			this.diagnosticscore = diagnosticscore;
		}
	  
		public Integer getDiagnosticscore(){
			return this.diagnosticscore;
		}
		 public void setTenantid(String tenantid){
			this.tenantid = tenantid;
		}
	  
		public String getTenantid(){
			return this.tenantid;
		}
}
