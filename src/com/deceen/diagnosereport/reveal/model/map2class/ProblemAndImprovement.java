package com.deceen.diagnosereport.reveal.model.map2class;

import java.io.Serializable;

	/**
	 * 用于封装问题描述与改进意见列表的类
	 */
public class ProblemAndImprovement implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String name; //问题名称
	
	private String questioninfo; //问题详情
	
	private String suggestioninfo; //具体建议

	public ProblemAndImprovement() {
		super();
	}

	public ProblemAndImprovement(String name, String questioninfo,
			String suggestioninfo) {
		super();
		this.name = name;
		this.questioninfo = questioninfo;
		this.suggestioninfo = suggestioninfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestioninfo() {
		return questioninfo;
	}

	public void setQuestioninfo(String questioninfo) {
		this.questioninfo = questioninfo;
	}

	public String getSuggestioninfo() {
		return suggestioninfo;
	}

	public void setSuggestioninfo(String suggestioninfo) {
		this.suggestioninfo = suggestioninfo;
	}
	
}
