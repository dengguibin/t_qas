package com.deceen.mty.atom.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: TMtyAtom.java 主键
 * @Description: t_mty_atom
 * @author upaths@gmail.com
 * @date 2017-11-5 11:00:49
 * @version V1.0
 */
@SuppressWarnings("serial")
public class TMtyAtom extends Pagination implements Serializable {

	// 主键 @PrimaryKey
	private String id;
	// 名称，以便运维，加atom后缀是为了与数据库的关键字区分
	private String name_atom;
	// 前面的标签片段
	private String front_html;
	//页面上的内容或id,表中没有该字段。
	private String contentOrId;
	// 后面的标签片段
	private String back_html;
	// 前面的Js片段
	private String front_js;
	//表中没有该字段，由用到的标签决定。
	private String url;
	// 后面的Js片段
	private String back_js;
	// 备注
	private String remark;
	// 创建人
	private String cjr;
	// 创建时间
	private Date cjsj;
	// 修改人
	private String xgr;
	// 修改时间
	private Date xgsj;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setName_atom(String name_atom) {
		this.name_atom = name_atom;
	}

	public String getName_atom() {
		return this.name_atom;
	}

	public void setFront_html(String front_html) {
		this.front_html = front_html;
	}

	public String getFront_html() {
		return this.front_html;
	}

	public void setBack_html(String back_html) {
		this.back_html = back_html;
	}

	public String getBack_html() {
		return this.back_html;
	}

	public void setFront_js(String front_js) {
		this.front_js = front_js;
	}

	public String getFront_js() {
		return this.front_js;
	}

	public void setBack_js(String back_js) {
		this.back_js = back_js;
	}

	public String getBack_js() {
		return this.back_js;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setCjr(String cjr) {
		this.cjr = cjr;
	}

	public String getCjr() {
		return this.cjr;
	}

	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}

	public Date getCjsj() {
		return this.cjsj;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	public String getXgr() {
		return this.xgr;
	}

	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}

	public Date getXgsj() {
		return this.xgsj;
	}

	public String getContentOrId() {
		return contentOrId;
	}

	public void setContentOrId(String contentOrId) {
		this.contentOrId = contentOrId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
