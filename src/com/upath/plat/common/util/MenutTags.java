package com.upath.plat.common.util;

public class MenutTags {

	String url;
	
	boolean selected = false;
	
	String tagId;
	
	boolean refresh;
	
	String name;
	
	public MenutTags(String name,String url){
		this(System.nanoTime()+"",name,url);
	}
	
	public MenutTags(String tagId,String name,String url){
			this.tagId = tagId;
			this.name = name;
			this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public boolean isRefresh() {
		return refresh;
	}

	public void setRefresh(boolean refresh) {
		this.refresh = refresh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
