/**
*/
package	com.upath.plat.quartz.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: TCommonScheduling.java   任务ID
* @Description: t_common_scheduling   
* @author upaths@gmail.com  
* @date 2015-7-9 19:13:31
* @version V1.0   
*/
@SuppressWarnings({"serial"})
public class TCommonScheduling extends Pagination implements Serializable{ 	
	
	 //任务ID @PrimaryKey
	private String taskid;
	 //任务名称 
	private String taskname;
	 //JOB实例方式(1:Spring容器，2：全类加载) 
	private Integer istmed;
	 //任务实现类 
	private String jobclass;
	 //是否有效 
	private Integer valid;
	 //任务类型( 1 : 单次 2: 循环) 
	private Integer type;
	 //cron表达式 
	private String cron;
	 //任务状态(0:禁用，1：启用) 
	private String states;
	 //任务参数JSON数据 
	private String params;
	 //排序号 
	private Integer seq;
	 //备注说明 
	private String des;
	 //已运行次数 
	private Integer runtimes;
	 //创建人 
	private String creator;
	 //创建时间 
	private Date cdate;
	 //修改时间 
	private Date udate;
	 //修改人 
	private String updator;

		 public void setTaskid(String taskid){
			this.taskid = taskid;
		}
	  
		public String getTaskid(){
			return this.taskid;
		}
		 public void setTaskname(String taskname){
			this.taskname = taskname;
		}
	  
		public String getTaskname(){
			return this.taskname;
		}
		 public void setIstmed(Integer istmed){
			this.istmed = istmed;
		}
	  
		public Integer getIstmed(){
			return this.istmed;
		}
		 public void setJobclass(String jobclass){
			this.jobclass = jobclass;
		}
	  
		public String getJobclass(){
			return this.jobclass;
		}
		 public void setValid(Integer valid){
			this.valid = valid;
		}
	  
		public Integer getValid(){
			return this.valid;
		}
		 public void setType(Integer type){
			this.type = type;
		}
	  
		public Integer getType(){
			return this.type;
		}
		 public void setCron(String cron){
			this.cron = cron;
		}
	  
		public String getCron(){
			return this.cron;
		}
		 public void setStates(String states){
			this.states = states;
		}
	  
		public String getStates(){
			return this.states;
		}
		 public void setParams(String params){
			this.params = params;
		}
	  
		public String getParams(){
			return this.params;
		}
		 public void setSeq(Integer seq){
			this.seq = seq;
		}
	  
		public Integer getSeq(){
			return this.seq;
		}
		 public void setDes(String des){
			this.des = des;
		}
	  
		public String getDes(){
			return this.des;
		}
		 public void setRuntimes(Integer runtimes){
			this.runtimes = runtimes;
		}
	  
		public Integer getRuntimes(){
			return this.runtimes;
		}
		 public void setCreator(String creator){
			this.creator = creator;
		}
	  
		public String getCreator(){
			return this.creator;
		}
		 public void setCdate(Date cdate){
			this.cdate = cdate;
		}
	  
		public Date getCdate(){
			return this.cdate;
		}
		 public void setUdate(Date udate){
			this.udate = udate;
		}
	  
		public Date getUdate(){
			return this.udate;
		}
		 public void setUpdator(String updator){
			this.updator = updator;
		}
	  
		public String getUpdator(){
			return this.updator;
		}
}
