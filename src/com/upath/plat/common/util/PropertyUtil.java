package com.upath.plat.common.util;

import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.upath.plat.common.exception.PlatformException;

/**
 * 实用类，处理字符和常用方法
 * 
 * @author upaths version 1.0.0 create date :2012-9-29 upath plat call
 *         116856645.com modify time
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PropertyUtil  extends PropertyUtils{

	private static final Logger logger = Logger.getLogger(PropertyUtil.class);

	
	public static String getMapValue(Object map,String key){
		return getMapValue(map, key, null);
	}
	
	public static String getMapValue(Object map,String key,String _default){
				String result = _default;
				if(map instanceof Map){
					Map m = (Map)map;
						Object o = m.get(key);
							if(o != null){
								result = o.toString();
							}
				}else{
					throw new PlatformException("setMapValue 传入的每一个参数必须为 Map 的实例");
				}
				return result;
		
	}
	
	/**
	 * 获取MAP的INT数据
	 * @param map
	 * @param key
	 * @return 如果为空，默认返回 0 
	 */
	public static int getMapIntValue(Object map,String key){
		return getMapIntValue(map,key,0);
	}
	
	/**
	 * 获取MAP的INT数据
	 * @param map
	 * @param key
	 * @param _default 如果为空的时候默认返回值 
	 * @return
	 */
	public static int getMapIntValue(Object map,String key,int _default){
		String result = getMapValue(map,key,null);
		if(result != null){
			try{
				return Integer.valueOf(result);
			}catch(Exception e){
				logger.warn(e);
			}
		}
		return _default;
	}
	
	public static void setMapValue(Object map,Object key,Object value){
		if(map instanceof Map){
			Map m = (Map)map;
				m.put(key, value);
		}else{
			throw new PlatformException("setMapValue 传入的每一个参数必须为 Map 的实例");
		}
	}
	

}
