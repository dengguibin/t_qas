/**
 */
package com.upath.plat.common.modules.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: TCommonMessagesRecivers.java 消息主键
 * @Description: t_common_messages_recivers
 * @author upaths@gmail.com
 * @date 2015-3-23 17:47:13
 * @version V1.0
 */

@SuppressWarnings("serial")
public class TCommonMessagesRecivers extends Pagination implements Serializable {

	// 消息主键
	private String ptid;
	// 接收主键 @PrimaryKey
	private String tid;
	// 消息类型，1：短信，2：邮件，3，两者都要。
	private Integer mtype;
	// 接收人名称
	private String reciver;
	// 接收人邮件
	private String address;
	// 接收人手机
	private String phone;
	// 接收人单位
	private String unid;
	// 消息发送结果
	private Integer sresult;
	// 消息发送结果描述
	private String smark;
	// 发送时间
	private Date sdate;
	// 发送状态
	private Integer stat;
	// 创建时间
	private Date cjsj;
	// 创建人
	private String cjr;
	// 修改时间
	private Date xgsj;
	// 修改人
	private String xgr;

	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

	public String getPtid() {
		return this.ptid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTid() {
		return this.tid;
	}

	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}

	public Integer getMtype() {
		return this.mtype;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public String getReciver() {
		return this.reciver;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public String getUnid() {
		return this.unid;
	}

	public void setSresult(Integer sresult) {
		this.sresult = sresult;
	}

	public Integer getSresult() {
		return this.sresult;
	}

	public void setSmark(String smark) {
		this.smark = smark;
	}

	public String getSmark() {
		return this.smark;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getSdate() {
		return this.sdate;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}

	public Integer getStat() {
		return this.stat;
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

	public Date getXgsj() {
		return xgsj;
	}

	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}

	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}
}
