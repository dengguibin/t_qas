/**
 */
package com.upath.plat.auth.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: TRmsUserPortlets.java 主键
 * @Description: t_rms_user_portlets
 * @author upaths@gmail.com
 * @date 2015-6-9 13:59:14
 * @version V1.0
 */

@SuppressWarnings("serial")
public class TRmsUserPortlets extends Pagination implements Serializable {

	// 主键 @PrimaryKey
	private String cid;
	// 用户ID
	private String userid;
	// 项目ID
	private String proid;
	// 模块ID
	private String moduleid;
	// 门户中纵坐标
	private String col_y;
	// 门户中横坐标
	private Integer row_x;
	// 是当前进行显示(1：显示，0:不显示)
	private Integer sfyx;
	// 创建时间
	private Date cjsj;
	// 创建人
	private String cjr;
	// 修改时间
	private Date xgsj;
	// 修改人
	private String xgr;
	//跨行
	private Integer colcount;
	//跨列
	private Integer rowcount;

	public Integer getColcount() {
		return colcount;
	}

	public void setColcount(Integer colcount) {
		this.colcount = colcount;
	}

	public Integer getRowcount() {
		return rowcount;
	}

	public void setRowcount(Integer rowcount) {
		this.rowcount = rowcount;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCid() {
		return this.cid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setProid(String proid) {
		this.proid = proid;
	}

	public String getProid() {
		return this.proid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}

	public String getModuleid() {
		return this.moduleid;
	}

	public String getCol_y() {
		return col_y;
	}

	public void setCol_y(String col_y) {
		this.col_y = col_y;
	}

	public void setRow_x(Integer row_x) {
		this.row_x = row_x;
	}

	public Integer getRow_x() {
		return this.row_x;
	}

	public void setSfyx(Integer sfyx) {
		this.sfyx = sfyx;
	}

	public Integer getSfyx() {
		return this.sfyx;
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
}
