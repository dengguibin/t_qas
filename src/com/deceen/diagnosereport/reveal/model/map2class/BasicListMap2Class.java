package com.deceen.diagnosereport.reveal.model.map2class;

import java.io.Serializable;

/**
 * 用于封装要素的诊断结果的类
 */
public class BasicListMap2Class implements Serializable{

	private static final long serialVersionUID = 1L;

	private String basicClass;//要素的诊断结果，后期完善
	
	private String basicName;//要素的名称

	public BasicListMap2Class() {
		super();
	}

	public BasicListMap2Class(String basicClass, String basicName) {
		super();
		this.basicClass = basicClass;
		this.basicName = basicName;
	}

	public String getBasicClass() {
		return basicClass;
	}

	public void setBasicClass(String basicClass) {
		this.basicClass = basicClass;
	}

	public String getBasicName() {
		return basicName;
	}

	public void setBasicName(String basicName) {
		this.basicName = basicName;
	}
	
}
