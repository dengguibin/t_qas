package com.upath.plat.common.cache;
@SuppressWarnings({ "rawtypes" })
public interface ISqlTemplate {

	String getId();
	
	String getName();
	
	String getCategary();
	
	String getScripts();
	
	void setScripts(String scripts);
	
	/**
	 * 此模板 的类型 SELETE DELETE UPDATE INSERT
	 * @return
	 */
	String getType();
	
	String getResultType();
	
	Class  getResultClass();
	
	/**
	 * 是否允许嵌入的模板
	 * @return
	 */
	boolean isNested();
	
	
	
}
