package com.deceen.diagnosereport.reveal.model.map2class;

import java.io.Serializable;

/**
 * 标志性成果指标类	
 * @author lbh
 */
public class SignMap2Class implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String num;//标志性成果指标的数量
	
	private String achieve;//标志性成果达成度
	
	private String resultCount;

	public SignMap2Class() {
		super();
	}

	public SignMap2Class(String num, String achieve, String resultCount) {
		super();
		this.num = num;
		this.achieve = achieve;
		this.resultCount = resultCount;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getAchieve() {
		return achieve;
	}

	public void setAchieve(String achieve) {
		this.achieve = achieve;
	}

	public String getResultCount() {
		return resultCount;
	}

	public void setResultCount(String resultCount) {
		this.resultCount = resultCount;
	}
	
}
