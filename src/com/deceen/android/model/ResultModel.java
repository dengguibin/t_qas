package com.deceen.android.model;

public class ResultModel<T> {
	
	/**
	 * 响应状态
	 */
	private String status;
	
	private String msg;
	
	/**
	 * 响应数据
	 */
	private T datas;
	

	public ResultModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	//操作成功调用返回方法
	public void getSuccessfulResults(T data){
		this.datas = data;
		this.msg = "ok";
		this.status = "2000";
		
	}
	//操作失败调用返回方法
	public void getFailResults(String msg,T data){
		this.status = "0";
		this.msg = msg;
		this.datas = data;
	}
	//操作失败使用默认msg响应消息的调用返回方法
	public void getFailResultsDefaultMsg(T data){
		this.status = "0";
		this.msg = "gets a fail";
		this.datas = data;
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getData() {
		return datas;
	}

	public void setData(T data) {
		this.datas = data;
	}
	
	
}
