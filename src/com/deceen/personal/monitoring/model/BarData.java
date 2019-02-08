package com.deceen.personal.monitoring.model;

public class BarData {
	//单柱状图数据
	String singleDesc;
	float singleValue;
	
	
	//双柱状图数据
	String doubleFirstDesc;
	float doubleValue1;
	String doublceSecondDesc;
	float doubleValue2;
	public String getSingleDesc() {
		return singleDesc;
	}
	public void setSingleDesc(String singleDesc) {
		this.singleDesc = singleDesc;
	}
	public float getSingleValue() {
		return singleValue;
	}
	public void setSingleValue(float singleValue) {
		this.singleValue = singleValue;
	}
	public String getDoubleFirstDesc() {
		return doubleFirstDesc;
	}
	public void setDoubleFirstDesc(String doubleFirstDesc) {
		this.doubleFirstDesc = doubleFirstDesc;
	}
	public float getDoubleValue1() {
		return doubleValue1;
	}
	public void setDoubleValue1(float doubleValue1) {
		this.doubleValue1 = doubleValue1;
	}
	public String getDoublceSecondDesc() {
		return doublceSecondDesc;
	}
	public void setDoublceSecondDesc(String doublceSecondDesc) {
		this.doublceSecondDesc = doublceSecondDesc;
	}
	public float getDoubleValue2() {
		return doubleValue2;
	}
	public void setDoubleValue2(float doubleValue2) {
		this.doubleValue2 = doubleValue2;
	}
	
	
}
