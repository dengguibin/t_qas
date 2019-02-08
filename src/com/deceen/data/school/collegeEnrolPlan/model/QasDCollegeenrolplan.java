package	com.deceen.data.school.collegeEnrolPlan.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDCollegeenrolplan.java   记录标识
* @Description: qas_d_collegeenrolplan   
* @author upaths@gmail.com  
* @date 2017-11-22 17:40:49
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDCollegeenrolplan extends Pagination implements Serializable{ 	
	
	 //记录标识 @PrimaryKey
	private String id;
	 //全日制高职专业设置数（不含方向）  
	private Integer column_9;
	 //全日制高职招生专业数（不含方向） 
	private Integer column_10;
	 //全日制高职招生数 
	private Integer column_11;
	 //普通高中生<-->招生数（人） 
	private Integer column_12;
	 //"三校生"<-->招生数（人） 
	private Integer column_13;
	 //"3＋2"<-->招生数（人） 
	private Integer column_14;
	 //五年制高职第4学年<-->招生数（人） 
	private Integer column_15;
	 //其他<-->招生数（人） 
	private Integer column_16;
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
	
	
	 //全日制高职专业设置数（不含方向） 人数范围，eg:400-900 
	private String column_9Scope;
	 //全日制高职招生专业数（不含方向） 人数范围，eg:400-900 
	private String column_10Scope;
	 //全日制高职招生数 人数范围，eg:400-900 
	private String column_11Scope;
	 //普通高中生<-->招生数（人） 人数范围，eg:400-900 
	private String column_12Scope;
	 //"三校生"<-->招生数（人） 人数范围，eg:400-900 
	private String column_13Scope;
	 //"3＋2"<-->招生数（人） 人数范围，eg:400-900 
	private String column_14Scope;
	 //五年制高职第4学年<-->招生数（人） 人数范围，eg:400-900 
	private String column_15Scope;
	

		 public String getColumn_9Scope() {
		return column_9Scope;
	}

	public void setColumn_9Scope(String column_9Scope) {
		this.column_9Scope = column_9Scope;
	}

	public String getColumn_10Scope() {
		return column_10Scope;
	}

	public void setColumn_10Scope(String column_10Scope) {
		this.column_10Scope = column_10Scope;
	}

	public String getColumn_11Scope() {
		return column_11Scope;
	}

	public void setColumn_11Scope(String column_11Scope) {
		this.column_11Scope = column_11Scope;
	}

	public String getColumn_12Scope() {
		return column_12Scope;
	}

	public void setColumn_12Scope(String column_12Scope) {
		this.column_12Scope = column_12Scope;
	}

	public String getColumn_13Scope() {
		return column_13Scope;
	}

	public void setColumn_13Scope(String column_13Scope) {
		this.column_13Scope = column_13Scope;
	}

	public String getColumn_14Scope() {
		return column_14Scope;
	}

	public void setColumn_14Scope(String column_14Scope) {
		this.column_14Scope = column_14Scope;
	}

	public String getColumn_15Scope() {
		return column_15Scope;
	}

	public void setColumn_15Scope(String column_15Scope) {
		this.column_15Scope = column_15Scope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setColumn_9(Integer column_9){
			this.column_9 = column_9;
		}
	  
		public Integer getColumn_9(){
			return this.column_9;
		}
		 public void setColumn_10(Integer column_10){
			this.column_10 = column_10;
		}
	  
		public Integer getColumn_10(){
			return this.column_10;
		}
		 public void setColumn_11(Integer column_11){
			this.column_11 = column_11;
		}
	  
		public Integer getColumn_11(){
			return this.column_11;
		}
		 public void setColumn_12(Integer column_12){
			this.column_12 = column_12;
		}
	  
		public Integer getColumn_12(){
			return this.column_12;
		}
		 public void setColumn_13(Integer column_13){
			this.column_13 = column_13;
		}
	  
		public Integer getColumn_13(){
			return this.column_13;
		}
		 public void setColumn_14(Integer column_14){
			this.column_14 = column_14;
		}
	  
		public Integer getColumn_14(){
			return this.column_14;
		}
		 public void setColumn_15(Integer column_15){
			this.column_15 = column_15;
		}
	  
		public Integer getColumn_15(){
			return this.column_15;
		}
		 public void setColumn_16(Integer column_16){
			this.column_16 = column_16;
		}
	  
		public Integer getColumn_16(){
			return this.column_16;
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
