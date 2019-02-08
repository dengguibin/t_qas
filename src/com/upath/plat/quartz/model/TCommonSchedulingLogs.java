/**
*/
package	com.upath.plat.quartz.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TCommonSchedulingLogs.java   日志ID
* @Description: t_common_scheduling_logs   
* @author upaths@gmail.com  
* @date 2015-7-9 19:13:31
* @version V1.0   
*/
@SuppressWarnings({"serial" })
public class TCommonSchedulingLogs extends Pagination implements Serializable{ 	
	
	 //日志ID @PrimaryKey
	private String logid;
	 //任务ID 
	private String taskid;
	 //运行状态(0:失败，1：成功) 
	private String states;
	 //运行日志(失败的异常数据) 
	private String  marks;
	 //工作计算机 
	private String worker;
	 //计算机IP 
	private String workip;
	 //计算机MAC 
	private String mac;
	 //备注说明 
	private String des;
	 //运行时间 
	private Date rundate;
	 //创建时间 
	private Date cdate;
	
	private String taskname;
	
		 public void setLogid(String logid){
			this.logid = logid;
		}
	  
		public String getLogid(){
			return this.logid;
		}
		 public void setTaskid(String taskid){
			this.taskid = taskid;
		}
	  
		public String getTaskid(){
			return this.taskid;
		}
		 public void setStates(String states){
			this.states = states;
		}
	  
		public String getStates(){
			return this.states;
		}
	     public void setMarks(String marks){
			this.marks = marks;
		}
	  
		public String getMarks(){
			return this.marks;
		}
		 public void setWorker(String worker){
			this.worker = worker;
		}
	  
		public String getWorker(){
			return this.worker;
		}
		 public void setWorkip(String workip){
			this.workip = workip;
		}
	  
		public String getWorkip(){
			return this.workip;
		}
		 public void setMac(String mac){
			this.mac = mac;
		}
	  
		public String getMac(){
			return this.mac;
		}
		 public void setDes(String des){
			this.des = des;
		}
	  
		public String getDes(){
			return this.des;
		}
		 public void setRundate(Date rundate){
			this.rundate = rundate;
		}
	  
		public Date getRundate(){
			return this.rundate;
		}
		 public void setCdate(Date cdate){
			this.cdate = cdate;
		}
	  
		public Date getCdate(){
			return this.cdate;
		}

		public String getTaskname() {
			return taskname;
		}

		public void setTaskname(String taskname) {
			this.taskname = taskname;
		}
		
		
}
