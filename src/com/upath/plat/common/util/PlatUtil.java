package com.upath.plat.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.service.ICommonService;
import com.upath.plat.common.service.ISequence;

public class PlatUtil implements ApplicationContextAware {

	/**
	 * 系统使用 AES 算法 对 字符串进行加密 
	 */
	public static final String ALGORITHM = "AES";   
	/**
	 * 系统使用加密密钥
	 */
	public static final String PRIVATEKEY = "UPATHS_KEY";
	
	private static final String DEPLOY_KEY = "upath.web.root";
	
	private static final Logger logger = Logger.getLogger(PlatUtil.class);
	
	private static ApplicationContext ctx;
	

	/**
	 * 当前应用的部署目录
	 * @return
	 */
	public static  String getAppDeployDir(){
		return System.getProperty(DEPLOY_KEY);
	}
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
			ctx = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return ctx;
	}

	/**
	 * 返回系统统一的序列管理器,系统管理器的实现取决于数据库中的配置
	 * @return
	 */
	public static ISequence getPlatSequence() {
		return (ISequence) ctx.getBean("iSequence");
	}
	
	
	public static ICommonService getCommonService(){
		return (ICommonService) ctx.getBean("commonService");
	}

	/**
	 * 对文档使用SHA 进行消息摘要
	 * @param str
	 * @return
	 */
	public static String encoderBySHA(String str) {
		if (str == null)
			throw new NullPointerException("SHA 传入的加密字符不能为空。");
		String result = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA1");
			digest.digest(str.getBytes());
			result = new String(Base64.encodeBase64(digest.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 返回系统默认的私钥
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static SecretKey generateSecretKey() throws NoSuchAlgorithmException{
		KeyGenerator	keyGenerator = KeyGenerator.getInstance(ALGORITHM);
		keyGenerator.init(new SecureRandom(PRIVATEKEY.getBytes()));
		SecretKey key = keyGenerator.generateKey();
		return key;
	}
	
	/**
	 * 对传入的字符串使用系统默认的算法进行加密
	 * @param source
	 * @return
	 * @throws PlatformException
	 */
	public static String encrypt(String source) throws PlatformException{
		if (source == null) {
			throw new NullPointerException("加密字符不允许为空");
		}
		String result = null;
		byte[] datas = source.getBytes();
		try {
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, generateSecretKey());
			datas = cipher.doFinal(datas);
			result =( new String(Base64.encodeBase64(datas))).replace("\r", "").replace("\n", "");
		} catch (Exception e) {
			logger.error(e);
			throw new PlatformException("系统加密出错",e);
		}
		return result;
	}

	/**
	 * 对传入的字符串使用系统的解密方法来解密，解密字符串必须是以前加过密的字符
	 * @param source
	 * @return
	 * @throws PlatformException
	 */
	public static String decrypt(String source) throws PlatformException {
		if (source == null) {
			throw new NullPointerException("加密字符不允许为空");
		}
		String result = null;
		try {
			byte[] datas = Base64.decodeBase64(source.getBytes());
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.DECRYPT_MODE, generateSecretKey());
			datas = cipher.doFinal(datas);
			result = new String(datas);
		} catch (Exception e) {
			logger.error(e);
			throw new PlatformException("系统解密出错",e);
		}
		return result;
	}
}
