package com.deceen.diagnosereport.reveal.model;

import java.util.List;

import com.deceen.diagnosereport.reveal.model.map2class.ItemsMap2Class;
import com.deceen.diagnosereport.reveal.model.map2class.ProblemAndImprovement;
import com.deceen.diagnosereport.reveal.model.molecule.general.ItemGeneral;
import com.deceen.diagnosereport.reveal.model.molecule.general.ObjGeneralMolecule;
import com.deceen.diagnosereport.reveal.model.molecule.general.GeneralOverview;

/**
 * 用于封装总体概述和分析结果
 * @author YYH
 * 2017年12月11日12:22:43
 */
public class AnalyGeneral {
	
	private GeneralOverview generalOverview;			// 用于封装总体概述总体诊断结果
	private String indexDetail; 					// 用于封装指标明细的文件名
	private List<ItemGeneral> itemList; 			// 用于封装所有项目里指标的诊断结果
	private ItemsMap2Class itemsMap;			// 用于封装所有项目的总结和雷达图数据
	private List<ProblemAndImprovement> questionList; // 用于封装问题描述与改进意见 列表
	private ObjGeneralMolecule objGeneralMolecule;	// 用于封装横向对比的图表数据
	private List<ItemFruitPage> itemFruitPageList;	// 用于封装所有项目的分析结果
	
	public GeneralOverview getGeneralOverview() {
		return generalOverview;
	}

	public void setGeneralOverview(GeneralOverview generalOverview) {
		this.generalOverview = generalOverview;
	}

	public String getIndexDetail() {
		return indexDetail;
	}

	public void setIndexDetail(String indexDetail) {
		this.indexDetail = indexDetail;
	}

	public List<ItemGeneral> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemGeneral> itemList) {
		this.itemList = itemList;
	}


	public ItemsMap2Class getItemsMap() {
		return itemsMap;
	}

	public void setItemsMap(ItemsMap2Class itemsMap) {
		this.itemsMap = itemsMap;
	}

	public List<ProblemAndImprovement> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<ProblemAndImprovement> questionList) {
		this.questionList = questionList;
	}

	public ObjGeneralMolecule getObjGeneralMolecule() {
		return objGeneralMolecule;
	}

	public void setObjGeneralMolecule(ObjGeneralMolecule objGeneralMolecule) {
		this.objGeneralMolecule = objGeneralMolecule;
	}

	public List<ItemFruitPage> getItemFruitPageList() {
		return itemFruitPageList;
	}

	public void setItemFruitPageList(List<ItemFruitPage> itemFruitPageList) {
		this.itemFruitPageList = itemFruitPageList;
	}

}
