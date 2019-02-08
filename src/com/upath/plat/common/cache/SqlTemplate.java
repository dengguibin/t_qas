package com.upath.plat.common.cache;

import com.upath.plat.common.modules.model.TCommonSql;


/**
 * @author upaths
 * version 1.0.0
 * create date :2012-11-29 
 * modify time
 */
@SuppressWarnings({ "rawtypes" })
public class SqlTemplate implements ISqlTemplate {

	private String id;

	private String name;

	private Class rClass;

	private String sClass;

	private String resultType;

	private String scripts;

	private String type;
	
	private String category;

	public SqlTemplate() {

	}

	public SqlTemplate(TCommonSql bean) {
		this.id = bean.getTid() + "";
		if(bean.getPtid() != null){
			this.category = bean.getPtid()+"";
		}
		this.name = bean.getName();
		this.sClass = bean.getCpath();
		this.resultType = bean.getResult();
		this.scripts = bean.getScripts();
		this.type = bean.getType();

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Class getResultClass() {
		return null;
	}

	public String getResultType() {
		return resultType;
	}

	public String getScripts() {
		return scripts;
	}

	public String getType() {
		return type;
	}

	public boolean isNested() {
		return false;
	}

	public Class getRClass() {
		return rClass;
	}

	public void setRClass(Class class1) {
		rClass = class1;
	}

	public String getSClass() {
		return sClass;
	}

	public void setSClass(String class1) {
		sClass = class1;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setScripts(String scripts) {
		this.scripts = scripts;

	}

	public String getCategary(){
		return this.category;
	}
}
