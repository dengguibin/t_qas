package	com.deceen.diagnoseformat.task.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 诊断任务
* @ClassName: QasTDiagnosetask.java   
* @Description: qas_t_diagnosetask   
* @author upaths@gmail.com  
* @date 2017-11-20 10:19:20
* @version V1.0   
*/
@SuppressWarnings("serial")
public class QasTDiagnosetask extends Pagination implements Serializable{ 	

	// @PrimaryKey
	private String id;
	// 父Id（任务分发备用）
	private String pid;
	// 模型Id
	private String schemeid;
	//关联角色Id;
	private String roleid;
	// 任务名称
	private String taskname;
	// 起始时间
	public Date starttime;
	// 截止时间
	private Date endtime;
	// 诊断频率
	private Integer frequency;
	// 发布时间
	private Date publishtime;
	// 发布状态
	private Integer publishstatus;
	// 是否是主任务（0 否 1是）
	private Integer ismajor;
	// 创建人
	private String createdby;
	// 创建时间
	private Date createdtime;
	// 修改人
	private String updatedby;
	// 修改时间
	private Date updatedtime;
	// 模型的适用范围类型(4学校，5学院，6专业，7课程，8教师，9学生)
	private int rangeType;//该字段用于查询诊断对象是的参数传递

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPid() {
		return this.pid;
	}

	public void setSchemeid(String schemeid) {
		this.schemeid = schemeid;
	}

	public String getSchemeid() {
		return this.schemeid;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTaskname() {
		return this.taskname;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Integer getFrequency() {
		return this.frequency;
	}

	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	public Date getPublishtime() {
		return this.publishtime;
	}

	public void setPublishstatus(Integer publishstatus) {
		this.publishstatus = publishstatus;
	}

	public Integer getPublishstatus() {
		return this.publishstatus;
	}

	public void setIsmajor(Integer ismajor) {
		this.ismajor = ismajor;
	}

	public Integer getIsmajor() {
		return this.ismajor;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public Date getCreatedtime() {
		return this.createdtime;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public String getUpdatedby() {
		return this.updatedby;
	}

	public void setUpdatedtime(Date updatedtime) {
		this.updatedtime = updatedtime;
	}

	public Date getUpdatedtime() {
		return this.updatedtime;
	}

	public int getRangeType() {
		return rangeType;
	}

	public void setRangeType(int rangeType) {
		this.rangeType = rangeType;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

}
