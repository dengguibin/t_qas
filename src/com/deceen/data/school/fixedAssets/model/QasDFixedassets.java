package	com.deceen.data.school.fixedAssets.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDFixedassets.java   序号	Id	varchar	36
            全校总值	ValueOfFixedAsset	decimal	3
            教学、科研仪器设备<-->资产总值	ValueOfResearchEquipment	decimal	3
            教学、科研仪器设备<-->当年新增资产值	ValueOfNewResearchEquipment	decimal	3
            序号
* @Description: qas_d_fixedassets   
* @author upaths@gmail.com  
* @date 2017-11-22 17:47:30
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDFixedassets extends Pagination implements Serializable{ 	
	
	 //序号	Id	varchar	36
//            全校总值	ValueOfFixedAsset	decimal	3
//            教学、科研仪器设备<-->资产总值	ValueOfResearchEquipment	decimal	3
//            教学、科研仪器设备<-->当年新增资产值	ValueOfNewResearchEquipment	decimal	3
     //序号 @PrimaryKey
	private String id;
	 //全校总值 
	private Integer valueoffixedasset;
	 //教学、科研仪器设备<-->资产总值 
	private Integer valueofresearchequipment;
	 //教学、科研仪器设备<-->当年新增资产值 
	private Integer valueofnewresearchequipment;
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
	
	 //全校总值 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String valueoffixedassetScope;
	 //教学、科研仪器设备<-->资产总值 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String valueofresearchequipmentScope;
	 //教学、科研仪器设备<-->当年新增资产值 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String valueofnewresearchequipmentScope;
	
	
		 public String getValueoffixedassetScope() {
		return valueoffixedassetScope;
	}

	public void setValueoffixedassetScope(String valueoffixedassetScope) {
		this.valueoffixedassetScope = valueoffixedassetScope;
	}

	public String getValueofresearchequipmentScope() {
		return valueofresearchequipmentScope;
	}

	public void setValueofresearchequipmentScope(
			String valueofresearchequipmentScope) {
		this.valueofresearchequipmentScope = valueofresearchequipmentScope;
	}

	public String getValueofnewresearchequipmentScope() {
		return valueofnewresearchequipmentScope;
	}

	public void setValueofnewresearchequipmentScope(
			String valueofnewresearchequipmentScope) {
		this.valueofnewresearchequipmentScope = valueofnewresearchequipmentScope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setValueoffixedasset(Integer valueoffixedasset){
			this.valueoffixedasset = valueoffixedasset;
		}
	  
		public Integer getValueoffixedasset(){
			return this.valueoffixedasset;
		}
		 public void setValueofresearchequipment(Integer valueofresearchequipment){
			this.valueofresearchequipment = valueofresearchequipment;
		}
	  
		public Integer getValueofresearchequipment(){
			return this.valueofresearchequipment;
		}
		 public void setValueofnewresearchequipment(Integer valueofnewresearchequipment){
			this.valueofnewresearchequipment = valueofnewresearchequipment;
		}
	  
		public Integer getValueofnewresearchequipment(){
			return this.valueofnewresearchequipment;
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
