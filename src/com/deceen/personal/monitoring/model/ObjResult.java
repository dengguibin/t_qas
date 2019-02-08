package com.deceen.personal.monitoring.model;

import java.util.ArrayList;
import java.util.List;

public class ObjResult {

	private String objId;
	private String objName;
	
	private	List<ElementChart> elementList = new ArrayList<>();

	
	
	
	public List<ElementChart> getElementList() {
		return elementList;
	}

	public void setElementList(List<ElementChart> elementList) {
		this.elementList = elementList;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	
	
	
	
}
