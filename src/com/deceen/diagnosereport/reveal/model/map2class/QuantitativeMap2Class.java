package com.deceen.diagnosereport.reveal.model.map2class;

import java.io.Serializable;

/**
 *  量化指标数据封装类
 * @author lbh
 */
public class QuantitativeMap2Class implements Serializable{

	private static final long serialVersionUID = 1L;

	private String num;//量化指标的数量
	
	private String score;//得分
	
	private int qualifiedNum;//合格数量
	
	private int earlyWarningNum;//预警数量
	
	private int unqualifiedNum;//不合格数量

	public QuantitativeMap2Class() {
		super();
	}

	public QuantitativeMap2Class(String num, String score, int qualifiedNum,
			int earlyWarningNum, int unqualifiedNum) {
		super();
		this.num = num;
		this.score = score;
		this.qualifiedNum = qualifiedNum;
		this.earlyWarningNum = earlyWarningNum;
		this.unqualifiedNum = unqualifiedNum;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public int getQualifiedNum() {
		return qualifiedNum;
	}

	public void setQualifiedNum(int qualifiedNum) {
		this.qualifiedNum = qualifiedNum;
	}

	public int getEarlyWarningNum() {
		return earlyWarningNum;
	}

	public void setEarlyWarningNum(int earlyWarningNum) {
		this.earlyWarningNum = earlyWarningNum;
	}

	public int getUnqualifiedNum() {
		return unqualifiedNum;
	}

	public void setUnqualifiedNum(int unqualifiedNum) {
		this.unqualifiedNum = unqualifiedNum;
	}
	
}
