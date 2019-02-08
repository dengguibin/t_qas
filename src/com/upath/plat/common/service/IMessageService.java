package com.upath.plat.common.service;

import com.upath.plat.common.exception.PlatformException;
/**
 * 
 * 系统消息共用服务类
 * @author upaths
 * 2015-05-28
 *
 */
public interface IMessageService {
	
	//短信消息
	public static int SMS_MSG_STYLE = 1 << 0;
	
	//邮件消息
	public static int MAIL_MSG_STYLE = 1 << 1;
	
	
	//系统消息
	public static int SYS_MSG_STYLE = 1 << 2;
	
	//所有消息
	public static int ALL_MSG_STYLE = (SYS_MSG_STYLE | SMS_MSG_STYLE | MAIL_MSG_STYLE);
	/**
	 * 向系统用户增加一条消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean addSysMsg(String userId,String title,String contents) throws PlatformException;
	
	/**
	 * 向系统用户增加一条消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[] addSysMsg(String userId[],String title,String contents) throws PlatformException;
	
	/**
	 * 向系统部门中所有的用户增加一条消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false 发送的条数 等于  boolean[].length 
	 */
	boolean[] addSysMsgByOrg(String orgId,String title,String contents) throws PlatformException;
	
	/**
	 * 向系统部门中所有的用户一条消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false 发送的条数 等于  boolean[].length 
	 */
	boolean[] addSysMsgByOrg(String orgId[],String title,String contents) throws PlatformException;
	
	/**
	 * 向系统用户增加一条短信消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean addSmsMsg(String userId,String title,String contents) throws PlatformException;
	
	/**
	 * 向系统用户增加一条短信消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[] addSmsMsg(String userId[],String title,String contents) throws PlatformException;
	
	
	/**
	 * 向系统部门中所有的用户增加一条短信消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[] addSmsMsgByOrg(String orgId,String title,String contents) throws PlatformException;
	
	
	/**
	 * 向系统部门中所有的用户增加一条短信消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[] addSmsMsgByOrg(String orgId[],String title,String contents) throws PlatformException;
	
	/**
	 * 向系统部门中所有的用户增加一条短信消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean addSmsMsgByPhone(String phoneNumbser,String title,String contents) throws PlatformException;
	
	/**
	 * 向系统部门中所有的用户增加一条短信消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[] addSmsMsgByPhone(String phoneNumbser[],String title,String contents) throws PlatformException;
	
	
	
	/**
	 * 向系统用户增加一条邮件消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean addMailMsg(String userId,String title,String contents) throws PlatformException;
	
	
	/**
	 * 向系统用户增加一条邮件消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[] addMailMsg(String userId[],String title,String contents) throws PlatformException;
	
	
	/**
	 * 通过指定的邮件地址增加一条邮件消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean addMailMsgByAddress(String address,String title,String contents) throws PlatformException;
	
	
	/**
	 *通过指定的邮件地址增加一条邮件消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[] addMailMsgByAddress(String address[],String title,String contents) throws PlatformException;
	
	
	/**
	 * 向系统部门中所有的用户一条邮件消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[] addMailMsgByOrg(String orgId,String title,String contents) throws PlatformException;
	
	
	/**
	 * 向系统用户增加一条邮件消息
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[] addMailMsgByOrg(String orgId[],String title,String contents) throws PlatformException;
	
	
	/**
	 * 向系统用户增加一条消息 具体由  msgStyle 进行控制 如果 系统多种消息 都支持  msgStyle = ALL_MSG_STYLE = (SYS_MSG_STYLE | SMS_MSG_STYLE | MAIL_MSG_STYLE) 
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[] addMsg(String userId,String title,String contents,int msgStyle) throws PlatformException;
	
	
	/**
	 * 自动向系统用户增加一条消息 具体由  msgStyle 进行控制 如果 系统多种消息 都支持  msgStyle = ALL_MSG_STYLE = (SYS_MSG_STYLE | SMS_MSG_STYLE | MAIL_MSG_STYLE) 
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	public boolean[][] addAutoMsg(String[] userId, String title, String contents,
			int msgStyle) throws PlatformException;
	/**
	 * 向系统用户增加一条消息 具体由  msgStyle 进行控制 如果 系统多种消息 都支持  msgStyle = ALL_MSG_STYLE = (SYS_MSG_STYLE | SMS_MSG_STYLE | MAIL_MSG_STYLE) 
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[][] addMsg(String userId[],String title,String contents,int msgStyle) throws PlatformException;

	
	
	/**
	 * 向系统用户增加一条消息 具体由  msgStyle 进行控制 如果 系统多种消息 都支持  msgStyle = ALL_MSG_STYLE = (SYS_MSG_STYLE | SMS_MSG_STYLE | MAIL_MSG_STYLE) 
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[][] addMsgByOrg(String orgId,String title,String contents,int msgStyle) throws PlatformException;
	
	/**
	 * 向系统用户增加一条消息 具体由  msgStyle 进行控制 如果 系统多种消息 都支持  msgStyle = ALL_MSG_STYLE = (SYS_MSG_STYLE | SMS_MSG_STYLE | MAIL_MSG_STYLE) 
	 * @param userId 系统用户ID
	 * @param title 消息的标题
	 * @param contents 消息的内容
	 * @return 发送消息的对应状态，发送成功为true ,否则为false
	 */
	boolean[][] addMsgByOrg(String orgId[],String title,String contents,int msgStyle) throws PlatformException;

}
