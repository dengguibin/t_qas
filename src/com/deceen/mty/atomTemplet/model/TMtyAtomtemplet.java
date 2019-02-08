package com.deceen.mty.atomTemplet.model;

import java.io.Serializable;

import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: TMtyAtomtemplet.java 中间表主键
 * @Description: t_mty_atomtemplet
 * @author upaths@gmail.com
 * @date 2017-11-10 12:04:39
 * @version V1.0
 */

@SuppressWarnings("serial")
public class TMtyAtomtemplet extends Pagination implements Serializable {

	// 中间表主键 @PrimaryKey
	private String id;
	// 关联原子样式表的外键
	private String atomid;
	// 关联前端模板表的外键
	private String templetid;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setAtomid(String atomid) {
		this.atomid = atomid;
	}

	public String getAtomid() {
		return this.atomid;
	}

	public void setTempletid(String templetid) {
		this.templetid = templetid;
	}

	public String getTempletid() {
		return this.templetid;
	}
}
