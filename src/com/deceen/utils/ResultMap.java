package com.deceen.utils;

import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;

public class ResultMap {

	private boolean success = true;// 是否成功
	private String msg = "操作成功";// 提示信息
	private Object obj = null;// 其他信息
	private Map<String, Object> data = new HashMap<String, Object>();// 其他参数
	
	public void put(String key,Object value){
		data.put(key, value);
	}
	
	public void put(Map<String, Object> data){
		this.data = data;
	}
	
	public Map<String, Object> getData() {
		return data;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getJsonStr(){
		JSONObject obj = new JSONObject();
		obj.put("success", this.isSuccess());
		obj.put("msg", this.getMsg());
		obj.put("obj", this.obj);
		obj.put("data", this.data);
		return obj.toString();
	} 
	
}
