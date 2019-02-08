package com.deceen.personal.monitoring.model;

import java.util.ArrayList;
import java.util.List;

/*
 * 要素表
 */
public class ElementChart {
	private String elementId;
	private String elementName;
	
	private List<Molecule> indicatorList = new ArrayList<>();//指标

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public List<Molecule> getIndicatorList() {
		return indicatorList;
	}

	public void setIndicatorList(List<Molecule> indicatorList) {
		this.indicatorList = indicatorList;
	}
	
	
}
