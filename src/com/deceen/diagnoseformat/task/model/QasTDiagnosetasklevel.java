package	com.deceen.diagnoseformat.task.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasTDiagnosetasklevel.java    
* @Description: qas_t_diagnosetasklevel   
* @author upaths@gmail.com  
* @date 2017-11-20 18:39:49
* @version V1.0   
*/
@SuppressWarnings("serial")
public class QasTDiagnosetasklevel extends Pagination implements Serializable{ 	
	
	// @PrimaryKey
	private String id;
	//诊断任务Id 
	private String diagnosetaskid;
	//左值 
	private Integer leftvalue;
	//右值 
	private Integer rightvalue;
	//诊断任务评级 
	private Integer tasklevel;
	//Face.net公式 
	private String formula;
	//排序 
	private Integer sort;
	//租户 
	private String tenantid;

	public void setId(String id){
		this.id = id;
	}
  
	public String getId(){
		return this.id;
	}
	public void setDiagnosetaskid(String diagnosetaskid){
		this.diagnosetaskid = diagnosetaskid;
	}
  
	public String getDiagnosetaskid(){
		return this.diagnosetaskid;
	}
	public void setLeftvalue(Integer leftvalue){
		this.leftvalue = leftvalue;
	}
  
	public Integer getLeftvalue(){
		return this.leftvalue;
	}
	public void setRightvalue(Integer rightvalue){
		this.rightvalue = rightvalue;
	}
  
	public Integer getRightvalue(){
		return this.rightvalue;
	}
	public void setTasklevel(Integer tasklevel){
		this.tasklevel = tasklevel;
	}
  
	public Integer getTasklevel(){
		return this.tasklevel;
	}
	public void setFormula(String formula){
		this.formula = formula;
	}
  
	public String getFormula(){
		return this.formula;
	}
	public void setSort(Integer sort){
		this.sort = sort;
	}
  
	public Integer getSort(){
		return this.sort;
	}
	public void setTenantid(String tenantid){
		this.tenantid = tenantid;
	}
  
	public String getTenantid(){
		return this.tenantid;
	}
}
