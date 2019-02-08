package com.deceen.diagnosereport.reveal.model.molecule.item;

import java.util.List;

import com.deceen.diagnosereport.reveal.model.map2class.BasicListMap2Class;
import com.deceen.diagnosereport.reveal.model.map2class.ElementListMap2Class;
import com.deceen.diagnosereport.reveal.model.map2class.ProblemAndImprovement;

public class ItemAnaly {
	
	/**诊断结果，通过的图标是qualified*/
	public static final String BASIC_CLASS_Y = "qualified";
	/**诊断结果，不通过的结果是unqualified*/
	public static final String BASIC_CLASS_N = "unqualified";
	/**达标率、诊断结论的字体颜色 ,合格：col-2*/
	public static final String REACH_CLASS_Y = "col-2";
	/**达标率、诊断结论的字体颜色 ,不合格、改进：col-1*/
	public static final String REACH_CLASS_N = "col-1";
	
	private String name;							//项目的名称
	private String reachClass;						//达标率样式
	private String reachValue;						//达标率
	private List<BasicListMap2Class> basicList;	//用于封装要素的诊断结果
	private List<ElementListMap2Class> elementList;	//用于封装要素下所有指标的诊断结果
	private List<ProblemAndImprovement> questionList; //用于封装问题描述与改进意见 列表
	private String diagnoseConclusion;				//诊断结论
	
	private String schemecatalogId;//类型id
	
	public String getSchemecatalogId() {
		return schemecatalogId;
	}

	public void setSchemecatalogId(String schemecatalogId) {
		this.schemecatalogId = schemecatalogId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReachClass() {
		return reachClass;
	}

	public void setReachClass(String reachClass) {
		this.reachClass = reachClass;
	}

	public String getReachValue() {
		return reachValue;
	}

	public void setReachValue(String reachValue) {
		this.reachValue = reachValue;
	}

	public List<BasicListMap2Class> getBasicList() {
		return basicList;
	}

	public void setBasicList(List<BasicListMap2Class> basicList) {
		this.basicList = basicList;
	}

	public List<ElementListMap2Class> getElementList() {
		return elementList;
	}

	public void setElementList(List<ElementListMap2Class> elementList) {
		this.elementList = elementList;
	}

	public List<ProblemAndImprovement> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<ProblemAndImprovement> questionList) {
		this.questionList = questionList;
	}

	public String getDiagnoseConclusion() {
		return diagnoseConclusion;
	}
	
	public void setDiagnoseConclusion(String diagnoseConclusion) {
		this.diagnoseConclusion = diagnoseConclusion;
	}

}
