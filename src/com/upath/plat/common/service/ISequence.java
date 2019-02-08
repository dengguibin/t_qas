package com.upath.plat.common.service;


public interface ISequence {
	
	public static String DEFAULT_SEQ_NAME = "default"; 
	
	public static String DEFAULT_SEQ_TYPE = "default";
	
	/**
	 * 获取系统设置默认的一个整数，整体应用中需保证此ID的唯一性
	 * @return
	 */
	int getNextId();
	
	/**
	 * @param subject 获取配置下面默认的唯一ID ，保证 subject 类这个ID 是唯一的
	 * @return
	 */
	int getNextId(String seqName);
	
	int getNextDeaultId(String seqType);
	
	int[] getNextDeaultId(String seqType, int nums);
	
	/**
	 * @param subject 获取配置下面默认的多个ID值 ，保证 subject 类这个ID 是唯一的
	  * @param seqName sequence 的定义名称
	 * @return
	 */
	int[] getNextId(String seqName,int nums);
	
	/**
	 * @param subject 获取配置下面默认的唯一ID ，保证 subject,seqType 类这个ID 是唯一的
	 * @param seqName sequence 的定义名称
	 * @param seqType sequence 下面的子类型
	 * @return
	 */
	int getNextId(String seqName,String seqType);
	
	/**
	 * @param subject 获取配置下面默认的唯一ID ，
	 * 保证 subject,seqType 类这个ID 是唯一的,一次性取多个序列号
	 * @return
	 */
	int[] getNextId(String seqName,String seqType,int nums) ;
	
	/**
	 * 释放  指定类型下面的  seq ,实现必须检测如果有释放值的情况 下应该要 
	 * 以释放的值取的优先权 
	 * @param seqName sequence 的定义名称
	 * @param seqType sequence 下面的子类型
	 * @param seq  要释放的序列号
	 * @return
	 */
	boolean freeSeq(String seqName,String seqType,int seq);
	
	/**
	 * 释放多个指定类型下面的seq序列号 ,实现必须检测如果有释放值的情况下应该要 
	 * 以释放的值取的优先权 
	 * @param seqName sequence 的定义名称
	 * @param seqType sequence 下面的子类型
	 * @param seq  要释放的序列号
	 * @return
	 */
	boolean freeSeq(String seqName,String seqType,int[] seq);

}
