/**
 */
package com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: TCommonMessages.java 消息主键
 * @Description: t_common_messages
 * @author upaths@gmail.com
 * @date 2015-3-23 17:57:04
 * @version V1.0
 */

@SuppressWarnings("serial")
public class TCommonMessages extends Pagination implements Serializable {

	// 消息主键 @PrimaryKey
	private String tid;
	// 消息标题
	private String title;
	// 发送状态
	private Integer stat;
	// 消息内容
	private String contents;
	// 消息类型
	private Integer mtype;
	// 消息业务类型
	private String btype;
	// 消息业务源
	private String bsource;
	// 业务调度时间
	private Date rdate;
	// 创建时间
	private Date cjsj;
	// 创建人
	private String cjr;
	// 修改时间
	private Date xgsj;
	// 修改人
	private String xgr;
	// 接收人
	

	//查询开始时间
	private String startTime;
	
	//查询结束时间
	private String endTime;
	
	//消息所以属人
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	
	
	
	private List<TCommonMessagesRecivers> recivers;

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTid() {
		return this.tid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}

	public Integer getStat() {
		return this.stat;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getContents() {
		return this.contents;
	}

	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}

	public Integer getMtype() {
		return this.mtype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public String getBtype() {
		return this.btype;
	}

	public void setBsource(String bsource) {
		this.bsource = bsource;
	}

	public String getBsource() {
		return this.bsource;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public Date getRdate() {
		return this.rdate;
	}

	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}

	public Date getCjsj() {
		return this.cjsj;
	}

	public void setCjr(String cjr) {
		this.cjr = cjr;
	}

	public String getCjr() {
		return this.cjr;
	}

	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}

	public Date getXgsj() {
		return this.xgsj;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	public String getXgr() {
		return this.xgr;
	}

	public List<TCommonMessagesRecivers> getRecivers() {
		return recivers;
	}

	public void setRecivers(List<TCommonMessagesRecivers> recivers) {
		this.recivers = recivers;
	}

	public void addReciver(TCommonMessagesRecivers rev) {
		if (recivers == null) {
			recivers = new ArrayList<TCommonMessagesRecivers>();
		}
		recivers.add(rev);
	}
}
