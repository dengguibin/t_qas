/**
*/
package	com.deceen.system.majordirection.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDMajordirection.java   专业方向唯一标识
* @Description: qas_d_majordirection   
* @author upaths@gmail.com  
* @date 2017-11-30 10:31:54
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDMajordirection extends Pagination implements Serializable{ 	
	
	 //专业方向唯一标识 @PrimaryKey
	private String id;
	 //专业编号 
	private String majorid;
	 //专业方向代码 
	private String directioncode;
	 //专业方向名称 
	private String directionname;
	 //批准设置日期 
	private Date setupdate;
	 //首次招生日期 
	private Date firstrecruitdate;
	 //修业年限（年） 
	private Integer studyduration;
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

		 public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setMajorid(String majorid){
			this.majorid = majorid;
		}
	  
		public String getMajorid(){
			return this.majorid;
		}
		 public void setDirectioncode(String directioncode){
			this.directioncode = directioncode;
		}
	  
		public String getDirectioncode(){
			return this.directioncode;
		}
		 public void setDirectionname(String directionname){
			this.directionname = directionname;
		}
	  
		public String getDirectionname(){
			return this.directionname;
		}
		 public void setSetupdate(Date setupdate){
			this.setupdate = setupdate;
		}
	  
		public Date getSetupdate(){
			return this.setupdate;
		}
		 public void setFirstrecruitdate(Date firstrecruitdate){
			this.firstrecruitdate = firstrecruitdate;
		}
	  
		public Date getFirstrecruitdate(){
			return this.firstrecruitdate;
		}
		 public void setStudyduration(Integer studyduration){
			this.studyduration = studyduration;
		}
	  
		public Integer getStudyduration(){
			return this.studyduration;
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
