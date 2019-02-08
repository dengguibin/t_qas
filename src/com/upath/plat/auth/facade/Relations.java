package com.upath.plat.auth.facade;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Relations implements Serializable {

	private String id;
	
	private String key;
	
	private String value;
	
	private Integer stat;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getStat() {
		return stat;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}
	
}
