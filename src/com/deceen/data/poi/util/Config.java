package com.deceen.data.poi.util;

import org.apache.log4j.Logger;

/**
 * 参数配置。
 * 查看： Config.properties
 */
public class Config extends NLS {

	private static final Logger log = Logger.getLogger(Config.class);
	
	private static final String BUNDLE_NAME = "com.util.Config";
	
		
	static{
		initializeMessages(BUNDLE_NAME, Config.class);
		 log.info("加载系统配置的相关参数");
	}
		
	public static String MONGODB_ADDRESS;
	public static String MONGODB_PORT;
	public static String MONGODB_ADMIN;
	public static String MONGODB_DATABASE;
	public static String MONGODB_USERNAME;
	public static String MONGODB_PASSWORD;
	public static String MYSQL_URL;
	public static String MYSQL_DRIVER;
	public static String MYSQL_USERNAME;
	public static String MYSQL_PASSWORD;
	public static String URL;
	public static String TIME;
		
}
