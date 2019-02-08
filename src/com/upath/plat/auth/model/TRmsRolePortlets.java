/**
 */
package com.upath.plat.auth.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.auth.facade.IRole;
import com.upath.plat.common.page.Pagination;

/**
 * 
 * @ClassName: TRmsRolePortlets.java 主键
 * @Description: t_rms_role_portlets
 * @author upaths@gmail.com
 * @date 2015-6-9 13:59:14
 * @version V1.0
 */

@SuppressWarnings("serial")
public class TRmsRolePortlets extends Pagination implements Serializable {

	// 主键 @PrimaryKey
	private String cid;
	// 角色ID
	private Integer jsid;
	// 项目ID
	private String proid;
	// 模块ID
	private String moduleid;
	// 排序号
	private Integer pxh;
	// 是否有效
	private Integer sfyx;
	// 创建时间
	private Date cjsj;
	// 创建人
	private String cjr;
	// 修改时间
	private Date xgsj;

	private List<IRole> roleList;

	// 修改人
	private String xgr;

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCid() {
		return this.cid;
	}

	public void setJsid(Integer jsid) {
		this.jsid = jsid;
	}

	public Integer getJsid() {
		return this.jsid;
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

	public void setPxh(Integer pxh) {
		this.pxh = pxh;
	}

	public Integer getPxh() {
		return this.pxh;
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

	public List<IRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<IRole> roleList) {
		this.roleList = roleList;
	}

}
