package com.upath.plat.common.mail;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.upath.plat.common.cache.CacheManager;
import com.upath.plat.common.cache.ICacheCode;
import com.upath.plat.common.exception.PlatformException;

@Component("mailSender")
public class MailSenderImpl implements MailSender {
	// 邮件父键
	private static final String MAIL = "MAIL";
	// 邮件服务器
	private static final String HOST = "HOST";
	// 默认用户名
	private static final String USERNAME = "USERNAME";
	// 默认密码
	private static final String PASSWORD = "PASSWORD";
	// 发件人邮箱.
	private static final String FROM = "FROM";
	// 发件人名称.
	private static final String FROMNAME = "FROMNAME";
	// 设置认证开关
	private static final String AUTH = "AUTH";
	// 设置调试开关
	private static final String DEBUG = "DEBUG";
	// 编码格式
	private static final String DEFAULTENCODING = "gb2312";

	private String from;
	
	private String fromName;
	
	public void setFrom(String from) {
		this.from = from;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	private JavaMailSender javaMailSender;

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public boolean send(final List<String> toList, final String subject, final String text) {
		return send(toList, null, null, subject, text, null);
	}

	public boolean send(final List<String> toList, final List<String> ccList, final List<String> bccList,
			final String subject, final String text) {
		return send(toList, ccList, bccList, subject, text, null);
	}

	public boolean send(final List<String> toList, final List<String> ccList, final List<String> bccList,
			final String subject, final String text, final List<File> attachmentFileList) {
		if (javaMailSender == null) {
			// 初始化邮件服务
			initMailSender();
		}
		boolean ret = true;
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		try {
			// 包装MimeMessage，以简化对MimeMessage的操作
			MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
			// 设置邮件元数据信息
			// mmh.setTo("wujhupaths@gmail.com");
			// mmh.setFrom("wujhupaths@gmail.com", "测试用户");
			// 发件人邮箱，发件人姓名
			mmh.setFrom(from, fromName);

			if (toList != null && toList.size() > 0) {
				for (String to : toList) {
					mmh.addTo(to);
				}
			} else {
				return false;
			}

			if (ccList != null && ccList.size() > 0) {
				for (String cc : ccList) {
					mmh.addCc(cc);
				}
			}

			if (bccList != null && bccList.size() > 0) {
				for (String bcc : bccList) {
					mmh.addBcc(bcc);
				}
			}

			mmh.setSubject(subject);

			// 添加HTML、内嵌资源
			mmh.setText(text, true);

			if (attachmentFileList != null && attachmentFileList.size() > 0) {
				for (int i = 0; i < attachmentFileList.size(); i++) {
					String attachmentFilename = attachmentFileList.get(i).getName();
					mmh.addAttachment(attachmentFilename, attachmentFileList.get(i));
				}
			}

			javaMailSender.send(mimeMessage);
		} catch (Exception e) {
			ret = false;
			throw new PlatformException("发送邮件失败", e);
		}
		return ret;
	}

	private void initMailSender() {
		javaMailSender = new JavaMailSenderImpl();
		List<?> list = CacheManager.getInstance().getCodes(MAIL);
		if (list == null) {
			throw new PlatformException("邮件参数未设置");
		} else {
			ICacheCode code = CacheManager.getInstance().getCode(MAIL, HOST);

			// 邮件服务器
			if (code == null || StringUtils.isEmpty(code.getParams1())) {
				throw new PlatformException("邮件服务器设置不正确");
			} else {
				((JavaMailSenderImpl) javaMailSender).setHost(code.getParams1());
			}

			code = CacheManager.getInstance().getCode(MAIL, USERNAME);
			// 默认用户名
			if (code == null || StringUtils.isEmpty(code.getParams1())) {
				throw new PlatformException("邮件服务器默认用户名设置不正确");
			} else {
				((JavaMailSenderImpl) javaMailSender).setUsername(code.getParams1());
			}

			code = CacheManager.getInstance().getCode(MAIL, PASSWORD);
			// 默认密码
			if (code == null || StringUtils.isEmpty(code.getParams1())) {
				throw new PlatformException("邮件服务器默认密码设置不正确");
			} else {
				((JavaMailSenderImpl) javaMailSender).setPassword(code.getParams1());
			}

			code = CacheManager.getInstance().getCode(MAIL, AUTH);
			// 设置认证开关
			boolean auth = true;
			if (code != null && StringUtils.isEmpty(code.getParams1())) {
				auth = Boolean.parseBoolean(code.getParams1());
			}
			((JavaMailSenderImpl) javaMailSender).getJavaMailProperties().put("mail.smtp.auth", auth);

			code = CacheManager.getInstance().getCode(MAIL, DEBUG);
			// 设置调试开关
			boolean debug = true;
			if (code != null && StringUtils.isEmpty(code.getParams1())) {
				debug = Boolean.parseBoolean(code.getParams1());
			}
			((JavaMailSenderImpl) javaMailSender).getJavaMailProperties().put("mail.debug", debug);
			// 设置编码格式
			((JavaMailSenderImpl) javaMailSender).setDefaultEncoding(DEFAULTENCODING);
			// 读取发件人邮箱及姓名
			code = CacheManager.getInstance().getCode(MAIL, FROM);
			setFrom(code.getParams1());
			code = CacheManager.getInstance().getCode(MAIL, FROMNAME);
			setFromName(code.getParams1());
		}

	}
}
