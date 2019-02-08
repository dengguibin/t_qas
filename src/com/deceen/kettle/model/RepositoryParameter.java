package com.deceen.kettle.model;

public class RepositoryParameter {
	
	
	/**
	 * 资源库ID,.kettle\repositories.xml里面可以获得
	 */
	private String id;
	
	/**
	 * 资源库名称
	 */
	private String name;
	
	/**
	 * 资源库描述
	 */
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
