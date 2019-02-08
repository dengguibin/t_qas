package com.deceen.android.model;

import java.io.Serializable;

public class DataReportingMenuBean<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private T rankOne;
	
	private T rankTwo;

	public T getRankOne() {
		return rankOne;
	}

	public void setRankOne(T rankOne) {
		this.rankOne = rankOne;
	}

	public T getRankTwo() {
		return rankTwo;
	}

	public void setRankTwo(T rankTwo) {
		this.rankTwo = rankTwo;
	}
	
	
}
