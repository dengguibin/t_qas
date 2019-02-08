package com.upath.plat.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author upaths version 1.0.0 create date :2012-11-1 upath plat call
 *         116856645.com modify time
 * 
 */
public class IDGenerator {


	
	/**
	 * 方法描述: 返回 System.nanoTime() 以36 进制 编码的唯一ID号 8U03IS2G4
	 */
	public static String getId() {
		return Long.toString(System.nanoTime(), 36).toUpperCase();
	}

	private IDGenerator(){
		
	}
	
	
	
	/**
	 * 方法描述: 返回 System.nanoTime() 以36 进制 加一个序列编号。 序列号以1的进行增长，序列号的长度取决于 传入值
	 * 转字符号的长度 如：8662UXD5Z-0001
	 */
	public static String[] getIds(int nums) {
		return getSpcialIds(1, nums, getId());
	}

	/**
	 * 方法描述: 返回 System.nanoTime() 数字 以36 进制 加一个序列编号。 序列号以1的进行增长，序列号的长度取决于 传入值
	 * 转字符号的长度 start 是序列的开始位置。如：8662UXD5Z-0001
	 */
	public static String[] getIds(int start, int nums) {
		return getSpcialIds(start, nums, getId());
	}

	/**
	 * 
	 * 方法描述:返回的getId()前面加 上一个当前日期的标签 yyyyMMdd 20121101-8662UXD5Z
	 */
	public static String getDateId() {
		String id = getId();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		String str = fmt.format(new Date());
		return str + "-" + id;
	}

	/**
	 * 
	 * 方法描述:返回的getId()前面加 上一个当前日期的标签 yyyyMMdd 序列号以1的进行增长，序列号的长度取决于 传入值 转字符号的长度
	 * 20121101-8662UXD5Z-0001
	 */
	public static String[] getDateIds(int start, int nums) {
		return getSpcialIds(start, nums, getDateId());
	}

	/**
	 * 
	 * 方法描述:getDateIds(1, nums); 20121101-8662UXD5Z-0001
	 */
	public static String[] getDateIds(int nums) {
		return getDateIds(1, nums);
	}

	/**
	 * 
	 * 方法描述: 在start 位置的基础上生成 nums 个 序列号，每个序列号间隔为1 同时生成返回的字符串号的长度跟 nums
	 * 的字面符号长度保持一样，前面补0
	 */
	private static String[] getSpcialIds(int start, int nums, String id) {
		if (start < 0 || nums < 0) {
			return null;
		} else {
			String[] arr = new String[nums];
			int len = Integer.toHexString(nums).length() + 1;
			for (int i = 0; i < nums; i++) {
				arr[i] = id + "-" + String.format("%0" + len + "d", i + start);
			}
			return arr;
		}
	}

	/**
	 * 
	 * 方法描述:以系统时间戳(36进制)-getId() 来表现ID号 H8ZLO2ZY-8U03IS2G4-0001
	 */
	public static String getTimeId() {
		String str = Long.toString(System.currentTimeMillis(), 36)
				.toUpperCase();
		return str + "-" + getId();
	}

	/**
	 * 
	 * 方法描述: getTimeIds(1,int nums) H8ZLO2ZY-8U03IS2G4-0001
	 */
	public static String[] getTimeIds(int nums) {
		return getSpcialIds(1, nums, getTimeId());
	}

	/**
	 * 
	 * 方法描述:getTimeId()+序列号 序列号以1的进行增长，序列号的长度取决于 传入值 转字符号的长度
	 * H8ZLCJII-8662UXD5Z-0001
	 */
	public static String[] getTimeIds(int start, int nums) {
		return getSpcialIds(start, nums, getTimeId());
	}

	/**
	 * 
	 * 方法描述:系统UUID号。全局唯一标识，无字面意思UUID.randomUUID()
	 * E030C65E04E2494EB655D805C99BDE77
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}


}
