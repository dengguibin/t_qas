package com.deceen.diagnosereport.reveal.model.molecule.general;

import java.util.ArrayList;
import java.util.List;

import com.deceen.diagnosereport.reveal.model.molecule.indicator.IndicatorResult;

public class ItemGeneral {
	
	private String itemName;			//项目名称
	private String result;				//项目的分析结果（已达标、预警、未达标）
	private String resultClass;			//项目的分析结果（已达标：qualified结尾、预警：warn结尾、未达标：unqualified结尾）
	private int qualifiedNum;		//合格指标的数量
	private int earlyWarningNum;		//预警指标的数量
	private int unqualifiedNum;		//不合格指标的数量
	private List<IndicatorResult> indicatorResultList = new ArrayList<IndicatorResult>();//用于封装一个项目里所有指标的诊断结果

	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultClass() {
		return resultClass;
	}

	public void setResultClass(String resultClass) {
		this.resultClass = resultClass;
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

	public List<IndicatorResult> getIndicatorResultList() {
		return indicatorResultList;
	}

	public void setIndicatorResultList(List<IndicatorResult> indicatorResultList) {
		this.indicatorResultList = indicatorResultList;
	}

}
