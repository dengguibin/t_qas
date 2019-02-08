package com.deceen.personal.monitoring.model;

import java.util.Map;

//一个指标诊断一个对象在不同的年份，一般是五个年份
public class Molecule {

//	map<20180528,name对应的数据>
//	必须是linkedhashmap
	private Map<String, BarData> datasMap;
	
	//指标名字
	private String indicatorName;
	
	//type=1单柱状图，type=2双柱状图
	private int type;


	public Map<String, BarData> getDatasMap() {
		return datasMap;
	}






	public int getType() {
		return type;
	}






	public void setType(int type) {
		this.type = type;
	}






	public void setDatasMap(Map<String, BarData> datasMap) {
		this.datasMap = datasMap;
	}



	public String getIndicatorName() {
		return indicatorName;
	}



	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}
	
	
}
