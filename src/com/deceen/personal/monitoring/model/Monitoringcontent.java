package com.deceen.personal.monitoring.model;

public class Monitoringcontent {
	//指标名称
	private String name_;
	//指标id
	private String id;
	//指标类型（单柱状图、双柱状图）
	private int type;
    //echarts图表数据
	private String barData;
	
	public String getBarData() {
		return barData;
	}
	public void setBarData(String barData) {
		this.barData = barData;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName_() {
		return name_;
	}
	public void setName_(String name_) {
		this.name_ = name_;
	}
	
}
