package com.upath.plat.common.util;

import org.apache.log4j.Logger;

/**
 * @author upaths
 * version 1.0.0
 * create date :2013-7-4 upath 代码生成平台
 * 联系邮箱： upaths@163.com
 * 项目托管地址：https://code.google.com/p/upath/
 * 修改时间： 
 * 
 * 
 * 参数配置。
 * 查看： SystemConfig.properties
 */
public class SystemConfig extends NLS {

	private static final Logger log = Logger.getLogger(SystemConfig.class);
	
	private static final String BUNDLE_NAME = "com.upath.plat.common.util.SystemConfig";
	
		
	static{
		initializeMessages(BUNDLE_NAME, SystemConfig.class);
		 log.info("加载系统配置的相关参数");
	}
	
	


	//系统ID
	public static String SYSTEM_ID;
	//系统名称
	public static String SYSTEM_NAME;
	//系统组织ID号
	public static String SYSTEM_ORGID;
	
	//系统正在加载功能
	public static String SYSTEM_PAGE_LOADING;
	
	//系统使用多次次时使用验证码的功能进行来控制
	public static String SYSTEM_LOGIN_COUNT;
	
	//系统控制多长时间(计算单位为分钟)，比如说当用户停止30分钟后，就暂时不用验证码来进行来干扰
	public static String SYSTEM_LOGIN_TIME;
	
	//系统上传附件可以接收的文档后缀名称
	public static String ATTACHMENT_SUFFIX_TYPE;
	
	//系统上传附件的指定根目录
	public static String ATTACHMENT_SAVE_DIR;
	
	//建设单位
	public static String SYSTEM_BUILD_UNIT;
	
	//建设单位网站信息
	public static String SYSTEM_BUILD_UNIT_SITEINFO;
	
	//技术支持单位信息
	public static String SYSTEM_TECHNICAL_SUPPORT;
	
	//技术支持单位网站信息
	public static String SYSTEM_TECHNICAL_SUPPORT_SITEINFO;
		
	//诊断分析模块的菜单id
	public static String ANALY_MENUID;
	
	//诊断分析模版根目录
	public static String ANALY_FREEMARKER_ROOTDIRF;
	
	//诊断分析静态文件根目录
	public static String ANALY_FREEMARKER_ROOTDIRH;
	
	
}
