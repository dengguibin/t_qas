package com.upath.plat.common.mail;

import java.io.File;
import java.util.List;

public interface MailSender {
	/**
	 * 发送邮件.
	 * @param toList  收件人邮箱列表.
	 * @param subject 邮件主题.
	 * @param text    邮件内容.
	 * @return true : 发邮件成功，false : 发邮件失败.
	 */
	boolean send(final List<String> toList,final String subject,final String text);
	
	/**
	 * 发送邮件.
	 * @param toList  收件人邮箱列表.
	 * @param ccList  抄送人邮箱列表.
	 * @param bccList 密送人邮箱列表.
	 * @param subject 邮件主题.
	 * @param text    邮件内容.
	 * @return true : 发邮件成功，false : 发邮件失败.
	 */
	boolean send(final List<String>toList,final List<String> ccList,
			final List<String> bccList,final String subject,final String text);
	
	/**
	 * 发送邮件.
	 * @param toList  收件人邮箱列表.
	 * @param ccList  抄送人邮箱列表.
	 * @param bccList 密送人邮箱列表.
	 * @param subject 邮件主题.
	 * @param text    邮件内容.
	 * @param attachmentFileList 附件列表.
	 * @return true : 发邮件成功，false : 发邮件失败.
	 */
	boolean send(final List<String>toList,final List<String> ccList,
			final List<String> bccList,final String subject,final String text,final List<File> attachmentFileList);
}