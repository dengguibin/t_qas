package com.deceen.diagnosereport.reveal.model.molecule.indicator;

public class IndicatorResult {
	
	private String name;				//指标名称
	private String result;				//诊断结果
	private String acceptanceValue ;	//合格值
	private String classStyle = "tr-3";//tr-1红色，tr-黄色，tr-3绿色
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getClassStyle() {
		return classStyle;
	}

	public void setClassStyle(String classStyle) {
		this.classStyle = classStyle;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAcceptanceValue() {
		return acceptanceValue;
	}

	public void setAcceptanceValue(String acceptanceValue) {
		this.acceptanceValue = acceptanceValue;
	}

}
