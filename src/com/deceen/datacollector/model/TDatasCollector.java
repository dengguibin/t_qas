/**
 */
package com.deceen.datacollector.model;

import java.io.Serializable;
import java.util.Date;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: TDatasCollector.java 配置主键
 * @Description: t_datas_collector
 * @author upaths@gmail.com
 * @date 2015-7-2 15:51:46
 * @version V1.0
 */

@SuppressWarnings("serial")
public class TDatasCollector extends Pagination implements Serializable {

	// 配置主键 @PrimaryKey
	private String tid;
	// 配置名称
	private String name;
	// 配置类型[扩展使用]
	private String type;
	// 配置参数(JSON数据)
	private String params;
	// 设计附件源
	private String source;// ----
	// 配置描述
	private String remark;
	// 备注
	private String marks;
	// 有效标志(1有效，其它无效)
	private Integer valid;
	// 最后一次运行时间
	private Date rdate;
	private Date rdateEnd;
	private Date rdateStart;
	// 运行状态结果    0:运行错误  ；1运行正常
	private Integer state;
	// 运行耗时秒为单位
	private Integer costs;
	// 运行日志
	private String logs;// ----
	// 创建人
	private String creator;
	// 创建时间
	private Date cdate;
	// 修改人
	private String updator;
	// 修改时间
	private Date udate;

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTid() {
		return this.tid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getParams() {
		return this.params;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return this.source;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getMarks() {
		return this.marks;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Integer getValid() {
		return this.valid;
	}

	public void setRdateEnd(Date rdateEnd) {
		this.rdateEnd = rdateEnd;
	}

	public Date getRdateEnd() {
		return this.rdateEnd;
	}

	public void setRdateStart(Date rdateStart) {
		this.rdateStart = rdateStart;
	}

	public Date getRdateStart() {
		return this.rdateStart;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public Date getRdate() {
		return this.rdate;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getState() {
		return this.state;
	}

	public void setCosts(Integer costs) {
		this.costs = costs;
	}

	public Integer getCosts() {
		return this.costs;
	}

	public void setLogs(String logs) {
		this.logs = logs;
	}

	public String getLogs() {
		return this.logs;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public Date getCdate() {
		return this.cdate;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public String getUpdator() {
		return this.updator;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public Date getUdate() {
		return this.udate;
	}
}
