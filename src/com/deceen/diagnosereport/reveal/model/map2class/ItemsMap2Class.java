package com.deceen.diagnosereport.reveal.model.map2class;

/**
 * 用于封装所有项目的总结和雷达图数据的类
 * @author lbh
 */
public class ItemsMap2Class {
	private String itemsAndObj;//各个项目名称拼接；“专业建设与规划,教育教学改革,学生成长与发展”
	
	private String standardRate;//合格达标率
	
	private String itemsData;//[{value:[2,8,9.6,18,7.2,9.8,8,14],name:'合格率'},{value:[2,10,12,18,8,20,16,14],name:'权重'}]
	
	private String itemsName;//[{name:'专业建设与规划',max:_max},{name:'教育教学改革',max:_max},{name:'学生成长与发展',max:_max}]
	//雷达图路劲
	private String radar;

	public ItemsMap2Class() {
		super();
	}

	public ItemsMap2Class(String itemsAndObj, String standardRate,
			String itemsData, String itemsName) {
		super();
		this.itemsAndObj = itemsAndObj;
		this.standardRate = standardRate;
		this.itemsData = itemsData;
		this.itemsName = itemsName;
	}

	public String getItemsAndObj() {
		return itemsAndObj;
	}

	public void setItemsAndObj(String itemsAndObj) {
		this.itemsAndObj = itemsAndObj;
	}

	public String getStandardRate() {
		return standardRate;
	}

	public void setStandardRate(String standardRate) {
		this.standardRate = standardRate;
	}

	public String getItemsData() {
		return itemsData;
	}

	public void setItemsData(String itemsData) {
		this.itemsData = itemsData;
	}

	public String getItemsName() {
		return itemsName;
	}

	public void setItemsName(String itemsName) {
		this.itemsName = itemsName;
	}
	
	public String getRadar() {
		return radar;
	}

	public void setRadar(String radar) {
		this.radar = radar;
	}
	
	
}
