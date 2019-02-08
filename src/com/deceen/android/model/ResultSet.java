package com.deceen.android.model;

public class ResultSet{
	//操作成功调用返回方法
	public static <T> ResultModel<T> getSuccessfulResults(T data){
		ResultModel<T> res = new ResultModel<T>();
		res.getSuccessfulResults(data);
		return res;
	}
	//操作成功调用返回方法
		public static <T> ResultModel<T> getSuccessfulResultsSetMsg(String msg,T data){
			ResultModel<T> res = new ResultModel<T>();
			res.getSuccessfulResults(data);
			res.setMsg(msg);
			return res;
		}
	//操作失败调用返回方法
	public static <T> ResultModel<T> getFailResults(String msg,T data){
		ResultModel<T> res = new ResultModel<T>();
		res.getFailResults(msg, data);
		return res;
	}
	//操作失败使用默认msg响应消息的调用返回方法
	public static <T> ResultModel<T> getFailResultsDefaultMsg(T data){
		ResultModel<T> res = new ResultModel<T>();
		res.getFailResultsDefaultMsg(data);
		return res;
	}
	
}