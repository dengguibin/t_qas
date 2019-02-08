package com.deceen.mty.templet.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: TMtyTemplet.java 主键
 * @Description: t_mty_templet
 * @author upaths@gmail.com
 * @date 2017-11-10 10:41:30
 * @version V1.0
 */

@SuppressWarnings("serial")
public class TMtyTemplet extends Pagination implements Serializable {

	// 主键 @PrimaryKey
	private String id;
	// 模板名称
	private String name_templet;
	// 相对路劲
	private String path_relative;
	// 备注
	private String remark;
	// 创建时间
	private Date cjsj;
	// 创建人
	private String cjr;
	// 修改时间
	private Date xgsj;
	// 修改人
	private String xgr;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setName_templet(String name_templet) {
		this.name_templet = name_templet;
	}

	public String getName_templet() {
		return this.name_templet;
	}

	public void setPath_relative(String path_relative) {
		this.path_relative = path_relative;
	}

	public String getPath_relative() {
		return this.path_relative;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
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
