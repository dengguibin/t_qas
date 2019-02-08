package	com.deceen.data.school.booksInLibrary.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDBooksinlibrary.java   序号
* @Description: qas_d_booksinlibrary   
* @author upaths@gmail.com  
* @date 2017-11-22 17:44:52
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDBooksinlibrary extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //纸质图书（万册）<-->总册数 
	private Integer numofbook;
	 //纸质图书（万册）<-->本学年新增数 
	private Integer numofnewbook;
	 //专业期刊（种）<-->中文纸质专业期刊 
	private Integer chinesejournal;
	 //专业期刊（种）<-->外文纸质专业期刊 
	private Integer foreignjournal;
	 //专业期刊（种）<-->电子专业期刊 
	private Integer electronicjournal;
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
	
	 //纸质图书总册数 范围(表中无此字段，只是为了条件选择新增的)
	private String numofbookScope;
	

		 public String getNumofbookScope() {
		return numofbookScope;
	}

	public void setNumofbookScope(String numofbookScope) {
		this.numofbookScope = numofbookScope;
	}

		public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setNumofbook(Integer numofbook){
			this.numofbook = numofbook;
		}
	  
		public Integer getNumofbook(){
			return this.numofbook;
		}
		 public void setNumofnewbook(Integer numofnewbook){
			this.numofnewbook = numofnewbook;
		}
	  
		public Integer getNumofnewbook(){
			return this.numofnewbook;
		}
		 public void setChinesejournal(Integer chinesejournal){
			this.chinesejournal = chinesejournal;
		}
	  
		public Integer getChinesejournal(){
			return this.chinesejournal;
		}
		 public void setForeignjournal(Integer foreignjournal){
			this.foreignjournal = foreignjournal;
		}
	  
		public Integer getForeignjournal(){
			return this.foreignjournal;
		}
		 public void setElectronicjournal(Integer electronicjournal){
			this.electronicjournal = electronicjournal;
		}
	  
		public Integer getElectronicjournal(){
			return this.electronicjournal;
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
