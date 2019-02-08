package com.deceen.utils.jfreechart;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class JsonToList {

	public String name;
	public String value;
	public String value1;
	public String value2;
	
	
	
	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {

		String gameListStr = "[{'gameId':'1','gameName':'哈哈'},{'gameId':'2','gameName':'呵呵'}]";
		List<JsonToList> gameList = JSONObject.parseArray(gameListStr,
				JsonToList.class);

		for (JsonToList game : gameList) {
			
		}

   }
}