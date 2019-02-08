package com.upath.plat.common.cache;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.upath.plat.common.exception.CacheBeanException;
import com.upath.plat.common.exception.PlatformException;

public class BeanPostProcessorImp implements BeanPostProcessor {
	
	private static final Logger log = Logger.getLogger(CacheManager.class);

	/**
	 * spring 加载 完成后 初始化
	 */
	public Object postProcessAfterInitialization(Object obj, String arg1)
			throws BeansException {
		if(obj instanceof ISystemCache){
			log.info("系统缓存类开始加载 : "+obj.getClass());
			ISystemCache cache = (ISystemCache)obj;
			log.info("功能描述："+cache.getDescription());
				try {
					cache.load();
				} catch (PlatformException e) {
					log.error(e);
					throw new CacheBeanException("系统缓存类加载失败",e);
				}
		}
		return obj;
	}


	public Object postProcessBeforeInitialization(Object obj, String arg1)
			throws BeansException {
		return obj;
	}

}
