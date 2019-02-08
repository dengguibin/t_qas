package	com.deceen.data.student.skillTraining.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDSkilltraining.java   序号
* @Description: qas_d_skilltraining   
* @author upaths@gmail.com  
* @date 2017-11-24 10:18:01
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDSkilltraining extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //专业方向 
	private String directionid;
	 //毕业生数（人） 
	private Integer gradnum;
	 //获得证书的毕业生<-->初级人数（人） 
	private Integer juniornum;
	 //获得证书的毕业生<-->中级人数（人） 
	private Integer midnum;
	 //获得证书的毕业生<-->高级人数（人） 
	private Integer highnum;
	 //获得证书的毕业生<-->无等级人数（人） 
	private Integer nogradenum;
	 //与专业相关的社会技术培训总数 
	private Integer trainingnum;
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
	
	
	 //毕业生数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String gradnumScope;
	 //获得证书的毕业生<-->初级人数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String juniornumScope;
	 //获得证书的毕业生<-->中级人数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String midnumScope;
	 //获得证书的毕业生<-->高级人数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String highnumScope;
	 //获得证书的毕业生<-->无等级人数（人） 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String nogradenumScope;
	 //与专业相关的社会技术培训总数 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String trainingnumScope;
	
		 public String getGradnumScope() {
		return gradnumScope;
	}

	public void setGradnumScope(String gradnumScope) {
		this.gradnumScope = gradnumScope;
	}

	public String getJuniornumScope() {
		return juniornumScope;
	}

	public void setJuniornumScope(String juniornumScope) {
		this.juniornumScope = juniornumScope;
	}

	public String getMidnumScope() {
		return midnumScope;
	}

	public void setMidnumScope(String midnumScope) {
		this.midnumScope = midnumScope;
	}

	public String getHighnumScope() {
		return highnumScope;
	}

	public void setHighnumScope(String highnumScope) {
		this.highnumScope = highnumScope;
	}

	public String getNogradenumScope() {
		return nogradenumScope;
	}

	public void setNogradenumScope(String nogradenumScope) {
		this.nogradenumScope = nogradenumScope;
	}

	public String getTrainingnumScope() {
		return trainingnumScope;
	}

	public void setTrainingnumScope(String trainingnumScope) {
		this.trainingnumScope = trainingnumScope;
	}

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
		 public void setGradnum(Integer gradnum){
			this.gradnum = gradnum;
		}
	  
		public Integer getGradnum(){
			return this.gradnum;
		}
		 public void setJuniornum(Integer juniornum){
			this.juniornum = juniornum;
		}
	  
		public Integer getJuniornum(){
			return this.juniornum;
		}
		 public void setMidnum(Integer midnum){
			this.midnum = midnum;
		}
	  
		public Integer getMidnum(){
			return this.midnum;
		}
		 public void setHighnum(Integer highnum){
			this.highnum = highnum;
		}
	  
		public Integer getHighnum(){
			return this.highnum;
		}
		 public void setNogradenum(Integer nogradenum){
			this.nogradenum = nogradenum;
		}
	  
		public Integer getNogradenum(){
			return this.nogradenum;
		}
		 public void setTrainingnum(Integer trainingnum){
			this.trainingnum = trainingnum;
		}
	  
		public Integer getTrainingnum(){
			return this.trainingnum;
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
