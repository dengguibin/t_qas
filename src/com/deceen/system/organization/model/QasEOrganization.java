/**
*/
package	com.deceen.system.organization.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasEOrganization.java   
* @Description: qas_e_organization   
* @author upaths@gmail.com  
* @date 2017-12-4 17:06:26
* @version V1.0   
*/
	
@SuppressWarnings({"serial","rawtypes"})

public class QasEOrganization extends Pagination implements Serializable{ 	
	
	 // @PrimaryKey
	private String id;
	 //父机构ID 
	private String parentid;
	 //类型ID,来自数据库 
	private String typeid;
	 //机构号 
	private String orgcode;
	 //机构名称 
	private String orgname;
	 //简称 
	private String abbreviation;
	 //简拼 
	private String jianpin;
	 //机构地址 
	private String address;
	 //排序 
	private Integer sort;
	 //是否是实体 
	private Integer isphysical;
	 //层级 
	private Integer layer;
	 // 
	private String remark;
	 //组织状态: 0有效 1:无效 
	private Integer status;
	 // 
	private String createdby;
	 // 
	private Date createdtime;
	 // 
	private String updatedby;
	 // 
	private Date updatedtime;
	 //租户 
	private String tenantid;
	//子集
	private List children;
	

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setParentid(String parentid){
			this.parentid = parentid;
		}
	  
		public String getParentid(){
			return this.parentid;
		}
		 public void setTypeid(String typeid){
			this.typeid = typeid;
		}
	  
		public String getTypeid(){
			return this.typeid;
		}
		 public void setOrgcode(String orgcode){
			this.orgcode = orgcode;
		}
	  
		public String getOrgcode(){
			return this.orgcode;
		}
		 public void setOrgname(String orgname){
			this.orgname = orgname;
		}
	  
		public String getOrgname(){
			return this.orgname;
		}
		 public void setAbbreviation(String abbreviation){
			this.abbreviation = abbreviation;
		}
	  
		public String getAbbreviation(){
			return this.abbreviation;
		}
		 public void setJianpin(String jianpin){
			this.jianpin = jianpin;
		}
	  
		public String getJianpin(){
			return this.jianpin;
		}
		 public void setAddress(String address){
			this.address = address;
		}
	  
		public String getAddress(){
			return this.address;
		}
		 public void setSort(Integer sort){
			this.sort = sort;
		}
	  
		public Integer getSort(){
			return this.sort;
		}
		 public void setIsphysical(Integer isphysical){
			this.isphysical = isphysical;
		}
	  
		public Integer getIsphysical(){
			return this.isphysical;
		}
		 public void setLayer(Integer layer){
			this.layer = layer;
		}
	  
		public Integer getLayer(){
			return this.layer;
		}
		 public void setRemark(String remark){
			this.remark = remark;
		}
	  
		public String getRemark(){
			return this.remark;
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

		public List getChildren() {
			return children;
		}

		public void setChildren(List children) {
			this.children = children;
		}
		
		
}
