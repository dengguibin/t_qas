package com.upath.plat.common.cache;


import com.upath.plat.common.exception.PlatformException;

/**
 * 
* @ClassName: ISystemCache
* @Description: (对实现系统缓存加载接口的数据，如果在Spring 当中进行配置后系统会默认调用 接口)
* @author upaths@gmail.com  
* @date Jul 13, 2012 2:28:07 PM
* @version V1.0   
*
 */
public interface ISystemCache {
	
	/*起动时进行加载*/
	public void  load() throws PlatformException;
	
	/*重新进行加载*/
	public void reload() throws PlatformException;
	
	public void  release() throws PlatformException;
	
	public void remove(String cacheCode) throws PlatformException;
	
	public void reload(String cacheCode) throws PlatformException;
	
	/*系统加载功能的用途描述*/
	public String getDescription();
	
	
}
