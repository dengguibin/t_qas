/**
*/
package	com.upath.plat.auth.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TRmsMenufunc.java   功能ID
* @Description: t_rms_menufunc   
* @author upaths@gmail.com  
* @date 2015-5-20 15:03:17
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class TRmsMenufunc extends Pagination implements Serializable{ 	
	
	 //功能ID @PrimaryKey
	private Integer funcid;
	 //菜单ID 
	private Integer cdid;
	 //功能名称 
	private String name;
	 //权限码 
	private String code;
	 //权限名称 
	private String fcname;
	 //功能连接地址 
	private String url;
	 //功能类型 
	private String lx;
	 //功能描述 
	private String descrip;
	 //备注 
	private String marks;
	 //创建时间 
	private Date cjsj;
	 //创建人 
	private String cjr;
	 //修改时间 
	private Date xgsj;
	 //修改人 
	private String xgr;

		 public void setFuncid(Integer funcid){
			this.funcid = funcid;
		}
	  
		public Integer getFuncid(){
			return this.funcid;
		}
		 public void setCdid(Integer cdid){
			this.cdid = cdid;
		}
	  
		public Integer getCdid(){
			return this.cdid;
		}
		 public void setName(String name){
			this.name = name;
		}
	  
		public String getName(){
			return this.name;
		}
		 public void setCode(String code){
			this.code = code;
		}
	  
		public String getCode(){
			return this.code;
		}
		 public void setFcname(String fcname){
			this.fcname = fcname;
		}
	  
		public String getFcname(){
			return this.fcname;
		}
		 public void setUrl(String url){
			this.url = url;
		}
	  
		public String getUrl(){
			return this.url;
		}
		 public void setLx(String lx){
			this.lx = lx;
		}
	  
		public String getLx(){
			return this.lx;
		}
		 public void setDescrip(String descrip){
			this.descrip = descrip;
		}
	  
		public String getDescrip(){
			return this.descrip;
		}
		 public void setMarks(String marks){
			this.marks = marks;
		}
	  
		public String getMarks(){
			return this.marks;
		}
		 public void setCjsj(Date cjsj){
			this.cjsj = cjsj;
		}
	  
		public Date getCjsj(){
			return this.cjsj;
		}
		 public void setCjr(String cjr){
			this.cjr = cjr;
		}
	  
		public String getCjr(){
			return this.cjr;
		}
		 public void setXgsj(Date xgsj){
			this.xgsj = xgsj;
		}
	  
		public Date getXgsj(){
			return this.xgsj;
		}
		 public void setXgr(String xgr){
			this.xgr = xgr;
		}
	  
		public String getXgr(){
			return this.xgr;
		}
}
