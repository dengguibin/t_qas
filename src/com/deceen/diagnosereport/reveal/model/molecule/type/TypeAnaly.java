package com.deceen.diagnosereport.reveal.model.molecule.type;

import java.util.List;

import com.deceen.diagnosereport.reveal.model.ItemFruitPage;

/**
 * 用于封装分析报告的类型
 * @author YYH
 * 2017年12月11日12:21:19
 */
public class TypeAnaly {
	
	private List<ItemFruitPage> itemFruitPageList;		//某个类型下所有项目的分析结果。
	
	public List<ItemFruitPage> getItemFruitPageList() {
		return itemFruitPageList;
	}

	public void setItemFruitPageList(List<ItemFruitPage> itemFruitPageList) {
		this.itemFruitPageList = itemFruitPageList;
	}

}
