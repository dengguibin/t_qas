package	com.deceen.data.school.rooms.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDRooms.java   序号
* @Description: qas_d_rooms   
* @author upaths@gmail.com  
* @date 2017-11-22 17:45:25
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDRooms extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //阅览室座位数（个) 
	private Integer numofreadingroomseat;
	 //计算机数（台）<-->合计 
	private Integer numofcomputer;
	 //计算机数（台）<-->教学用计算机<-->合计	 
	private Integer numofteachingcomputer;
	 //计算机数（台）<-->教学用计算机<-->平板电脑 
	private Integer numofteachingpad;
	 //计算机数（台）<-->机房用计算机<-->公共机房 
	private Integer numofpubliccomputerroom;
	 //计算机数（台）<-->机房用计算机<-->专业机房 
	private Integer numofspecialcomputerroom;
	 //教室（间）<-->合计 
	private Integer numofclassroom;
	 //教室（间）<-->网络多媒体教室 
	private Integer numofmediaroom;
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
	
	
	 //阅览室座位数（个) 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String numofreadingroomseatScope;
	 //计算机数（台）<-->合计 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String numofcomputerScope;
	 //计算机数（台）<-->教学用计算机<-->合计	 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String numofteachingcomputerScope;
	 //计算机数（台）<-->教学用计算机<-->平板电脑 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String numofteachingpadScope;
	 //计算机数（台）<-->机房用计算机<-->公共机房 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String numofpubliccomputerroomScope;
	 //计算机数（台）<-->机房用计算机<-->专业机房 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String numofspecialcomputerroomScope;
	 //教室（间）<-->合计 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String numofclassroomScope;
	 //教室（间）<-->网络多媒体教室 范围(表中无此字段，只是为了条件选择新增的)eg:1000-2000
	private String numofmediaroomScope;
	
	
		 public String getNumofreadingroomseatScope() {
		return numofreadingroomseatScope;
	}

	public void setNumofreadingroomseatScope(String numofreadingroomseatScope) {
		this.numofreadingroomseatScope = numofreadingroomseatScope;
	}

	public String getNumofcomputerScope() {
		return numofcomputerScope;
	}

	public void setNumofcomputerScope(String numofcomputerScope) {
		this.numofcomputerScope = numofcomputerScope;
	}

	public String getNumofteachingcomputerScope() {
		return numofteachingcomputerScope;
	}

	public void setNumofteachingcomputerScope(String numofteachingcomputerScope) {
		this.numofteachingcomputerScope = numofteachingcomputerScope;
	}

	public String getNumofteachingpadScope() {
		return numofteachingpadScope;
	}

	public void setNumofteachingpadScope(String numofteachingpadScope) {
		this.numofteachingpadScope = numofteachingpadScope;
	}

	public String getNumofpubliccomputerroomScope() {
		return numofpubliccomputerroomScope;
	}

	public void setNumofpubliccomputerroomScope(String numofpubliccomputerroomScope) {
		this.numofpubliccomputerroomScope = numofpubliccomputerroomScope;
	}

	public String getNumofspecialcomputerroomScope() {
		return numofspecialcomputerroomScope;
	}

	public void setNumofspecialcomputerroomScope(
			String numofspecialcomputerroomScope) {
		this.numofspecialcomputerroomScope = numofspecialcomputerroomScope;
	}

	public String getNumofclassroomScope() {
		return numofclassroomScope;
	}

	public void setNumofclassroomScope(String numofclassroomScope) {
		this.numofclassroomScope = numofclassroomScope;
	}

	public String getNumofmediaroomScope() {
		return numofmediaroomScope;
	}

	public void setNumofmediaroomScope(String numofmediaroomScope) {
		this.numofmediaroomScope = numofmediaroomScope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setNumofreadingroomseat(Integer numofreadingroomseat){
			this.numofreadingroomseat = numofreadingroomseat;
		}
	  
		public Integer getNumofreadingroomseat(){
			return this.numofreadingroomseat;
		}
		 public void setNumofcomputer(Integer numofcomputer){
			this.numofcomputer = numofcomputer;
		}
	  
		public Integer getNumofcomputer(){
			return this.numofcomputer;
		}
		 public void setNumofteachingcomputer(Integer numofteachingcomputer){
			this.numofteachingcomputer = numofteachingcomputer;
		}
	  
		public Integer getNumofteachingcomputer(){
			return this.numofteachingcomputer;
		}
		 public void setNumofteachingpad(Integer numofteachingpad){
			this.numofteachingpad = numofteachingpad;
		}
	  
		public Integer getNumofteachingpad(){
			return this.numofteachingpad;
		}
		 public void setNumofpubliccomputerroom(Integer numofpubliccomputerroom){
			this.numofpubliccomputerroom = numofpubliccomputerroom;
		}
	  
		public Integer getNumofpubliccomputerroom(){
			return this.numofpubliccomputerroom;
		}
		 public void setNumofspecialcomputerroom(Integer numofspecialcomputerroom){
			this.numofspecialcomputerroom = numofspecialcomputerroom;
		}
	  
		public Integer getNumofspecialcomputerroom(){
			return this.numofspecialcomputerroom;
		}
		 public void setNumofclassroom(Integer numofclassroom){
			this.numofclassroom = numofclassroom;
		}
	  
		public Integer getNumofclassroom(){
			return this.numofclassroom;
		}
		 public void setNumofmediaroom(Integer numofmediaroom){
			this.numofmediaroom = numofmediaroom;
		}
	  
		public Integer getNumofmediaroom(){
			return this.numofmediaroom;
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
