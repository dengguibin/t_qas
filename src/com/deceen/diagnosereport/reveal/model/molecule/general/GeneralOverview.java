package com.deceen.diagnosereport.reveal.model.molecule.general;

import com.deceen.diagnosereport.reveal.model.map2class.QuantitativeMap2Class;
import com.deceen.diagnosereport.reveal.model.map2class.SignMap2Class;

public class GeneralOverview {
	
	private String onjId;		//诊断对象的名称id
	private String objName;		// 诊断对象的名称
	private String score;		// 综合评分
	private String ranking;		// 本次排名
	private String fruit;		// 结果：合格，预警，不合格
	private QuantitativeMap2Class quantitativeMap;	// 量化指标
	private SignMap2Class signMap;			// 标志性成果指标

	private String color;//任务等级颜色
	
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getOnjId() {
		return onjId;
	}
	
	public void setOnjId(String onjId) {
		this.onjId = onjId;
	}
	
	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}


	public QuantitativeMap2Class getQuantitativeMap() {
		return quantitativeMap;
	}

	public void setQuantitativeMap(QuantitativeMap2Class quantitativeMap) {
		this.quantitativeMap = quantitativeMap;
	}

	public SignMap2Class getSignMap() {
		return signMap;
	}

	public void setSignMap(SignMap2Class signMap) {
		this.signMap = signMap;
	}

}
