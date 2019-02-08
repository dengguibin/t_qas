package com.deceen.diagnosereport.reveal.model;

import java.util.List;
import java.util.Map;

import com.deceen.diagnosereport.reveal.model.map2class.ProblemAndImprovement;
import com.deceen.diagnosereport.reveal.model.molecule.item.ItemAnaly;

public class ItemFruitPage {

	private ItemAnaly itemAnaly;							// 用于封装项目分析结果
	private List<ProblemAndImprovement> questionList; 		// 用于封装问题描述与改进意见 列表
	private List<Map<String, Object>> indicatorAnalyList; 	// 用于封装要素和指标的分析结果
	private String indexDetail; 							// 用于封装指标明细的文件名

	public ItemAnaly getItemAnaly() {
		return itemAnaly;
	}

	public void setItemAnaly(ItemAnaly itemAnaly) {
		this.itemAnaly = itemAnaly;
	}

	public List<ProblemAndImprovement> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<ProblemAndImprovement> questionList) {
		this.questionList = questionList;
	}

	public List<Map<String, Object>> getIndicatorAnalyList() {
		return indicatorAnalyList;
	}

	public void setIndicatorAnalyList(List<Map<String, Object>> indicatorAnalyList) {
		this.indicatorAnalyList = indicatorAnalyList;
	}

	public String getIndexDetail() {
		return indexDetail;
	}

	public void setIndexDetail(String indexDetail) {
		this.indexDetail = indexDetail;
	}

}
