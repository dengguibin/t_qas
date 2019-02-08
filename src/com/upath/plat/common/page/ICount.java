package com.upath.plat.common.page;
/**
 * 
 * @author upaths
 * version 1.0.0
 * create date :2012-9-22 
 * modify time
 * 如果要对 Mybatis 做分页处理查询，返回的对象要实现此接口
 */
public interface ICount {
	/**
	 * 在数据收集时，先要收集总的数据有多少行
	 * @return 
	 */
	int getRows();
	
	void setRows(int rows);
}
