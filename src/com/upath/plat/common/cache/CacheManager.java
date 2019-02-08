package com.upath.plat.common.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.service.ICommonService;
import com.upath.plat.common.util.PlatUtil;

/**
 * 
 * @ClassName: DictionaryCaceManager
 * @Description: (数据字典缓存管理器，对系统中的常用数据都字典缓存，统一管理)
 * @author upaths@gmail.com
 * @date Jul 13, 2012 2:27:23 PM
 * @version V1.0
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class CacheManager implements ISystemCache {

	private final static Map<String, List<ICacheCode>> caches = new HashMap<String, List<ICacheCode>>();

	private static CacheManager caceManager = null;

	private static final Logger log = Logger.getLogger(CacheManager.class);

	private ICommonService service;

	public CacheManager() {//警告

	}

	public static CacheManager getInstance() {//警告
		if (caceManager == null) {
			caceManager = (CacheManager)PlatUtil.getApplicationContext().getBean("cacheManager");
		}
		return caceManager;
	}

	public void load() throws PlatformException {
		load(null);
	}

	private synchronized void load(String cacheCode) throws PlatformException {//警告
		try{
			List<ICacheCode> list = service.queryList("plat.codeCache", cacheCode);
			if(list != null){
				for (ICacheCode key : list) {
					String code = key.getCode();
					List<ICacheCode> values = caches.get(code);
					if (values == null) {
						values = new ArrayList<ICacheCode>();
						caches.put(code, values);
					}
					values.add(key);
				}
				
			}
			
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
	}

	public void reload() throws PlatformException {
		release();
		load();
	}

	public void reload(String cacheCode) throws PlatformException {
		if (cacheCode != null && "".equals(cacheCode) == false) {
			caches.remove(cacheCode);
			load(cacheCode);
		}

	}

	public Map getDictionarys() {
		return caches;
	}

	public List getCodes(String key) {
		return caches.get(key);
	}

	public ICacheCode getCode(String code, String subcode) {
		List<ICacheCode> codes = getCodes(code);
		for (ICacheCode c : codes) {
			if (c.getSubcode().equals(subcode) == true) {
				return c;
			}
		}
		return null;

	};

	public void remove(String cacheCode) {
		caches.remove(cacheCode);
	}

	public void release() throws PlatformException {
		caches.clear();
	}

	public ICommonService getService() {
		return service;
	}

	public void setService(ICommonService service) {
		this.service = service;
	}

	public String getDescription() {
		return "BaseMapper.xml{menuCache} :字典缓存，字典键绑定{CODES},部门信息绑定{ORGS}，权限信息绑定{PERMISSION}，系统信息绑定{SYSTEMS}";
	}

}
