package com.deceen.diagnosereport.reveal.model.molecule;

import java.util.List;

import com.deceen.diagnosereport.reveal.model.map2class.TableMap2Class;

public class Molecule {
	
	/**达标率、诊断结论的字体颜色 ,合格：col-2*/
	public static final String STATE_CLASS_Y = "col-2";
	/**达标率、诊断结论的字体颜色 ,不合格、改进：col-1*/
	public static final String STATE_CLASS_N = "col-1";
	/**echarts图*/
	public static final byte TYPE_ECHARTS = 1;
	/**单选表格*/
	public static final byte TYPE_TABLE = 2;

	private String stateClass;				//样式class
	private String stateName;				//指标诊断后的状态（合格，不合格）
	private String indicatorName;			//指标名称
	private String echartsFunction;			//echarts的函数
	private String echartsData;				//echarts的数据
	private TableMap2Class tableMap;		//用于封装单选表格的内容
	private String conclusion;				//总结结论
	private byte type;						//类型，单选表格、echarts图
	
	private String firstDesc;				//echarts双柱状图中第一个数据的说明
	private String secondDesc;				//echarts双柱状图中第二个数据的说明
	private String sinpleDesc;				//echarts单柱状图中数据的说明
	
	private float qualifiedValue;			//合格值
	
	private String detailhre;				//指标详情链接的地址
	
	private List<String>	headTable;//指标详情的表头内容
	private List<List<String>>	detailList;//指标详情的表格内容
	
	
	
	
	
	
	

	public List<String> getHeadTable() {
		return headTable;
	}

	public void setHeadTable(List<String> headTable) {
		this.headTable = headTable;
	}

	public List<List<String>> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<List<String>> detailList) {
		this.detailList = detailList;
	}

	public String getDetailhre() {
		return detailhre;
	}

	public void setDetailhre(String detailhre) {
		this.detailhre = detailhre;
	}

	public float getQualifiedValue() {
		return qualifiedValue;
	}

	public void setQualifiedValue(float qualifiedValue) {
		this.qualifiedValue = qualifiedValue;
	}

	public String getFirstDesc() {
		return firstDesc;
	}

	public void setFirstDesc(String firstDesc) {
		this.firstDesc = firstDesc;
	}

	public String getSecondDesc() {
		return secondDesc;
	}

	public void setSecondDesc(String secondDesc) {
		this.secondDesc = secondDesc;
	}

	public String getSinpleDesc() {
		return sinpleDesc;
	}

	public void setSinpleDesc(String sinpleDesc) {
		this.sinpleDesc = sinpleDesc;
	}

	public String getStateClass() {
		return stateClass;
	}

	public void setStateClass(String stateClass) {
		this.stateClass = stateClass;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getIndicatorName() {
		return indicatorName;
	}

	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}

	public String getEchartsFunction() {
		return echartsFunction;
	}

	public void setEchartsFunction(String echartsFunction) {
		this.echartsFunction = echartsFunction;
	}

	public String getEchartsData() {
		return echartsData;
	}

	public void setEchartsData(String echartsData) {
		this.echartsData = echartsData;
	}


	public TableMap2Class getTableMap() {
		return tableMap;
	}

	public void setTableMap(TableMap2Class tableMap) {
		this.tableMap = tableMap;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

}
