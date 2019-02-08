package com.upath.plat.common.cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.modules.model.TCommonSql;
import com.upath.plat.common.service.ICommonService;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.common.util.StringUtil;

/**
 * @author upaths
 * version 1.0.0
 * create date :2012-11-29 
 * modify time
 */
@SuppressWarnings({"unchecked"})
public class SqlTemplateManager implements ISystemCache {
	
	private static SqlTemplateManager caceManager = null;
	
	private final static List<ISqlTemplate> caches = new ArrayList<ISqlTemplate>();

	private static final Logger log = Logger.getLogger(CacheManager.class);

	private  static String placeHolder = "\\+\\{[^\\}]+?\\}";
	
	private static Pattern pattern = Pattern.compile(placeHolder);
	
	private ICommonService service;
	
	public static SqlTemplateManager getInstance() {
		if (caceManager == null) {
			caceManager = (SqlTemplateManager)PlatUtil.getApplicationContext().getBean("sqlCacheManager");
		}
		return caceManager;
	}
	
	public SqlTemplateManager() {
		
	}
	
	/**
	 * 实现 引用 模板的功能 +{templateId}直接影响公用模型
	 * @param sqlTemplate
	 * @return
	 */
	public boolean joinTemplate(ISqlTemplate sqlTemplate){
		boolean joined = false;
		if(sqlTemplate != null && sqlTemplate.getScripts() != null ){
			String scripts = sqlTemplate.getScripts();
			Matcher matcher = pattern.matcher(scripts);
			int index = 0 ;
			StringBuffer buffer  = new StringBuffer();
			while (matcher.find() == true) {
				int end = matcher.end();
				int start = matcher.start();
				String key = scripts.substring(start+2,end-1).trim();
				buffer.append(scripts.substring(index, start));
				index  = end+1;
				ISqlTemplate temp = getTemplate(key);
				buffer.append(temp.getScripts());
				joined = true;
			}
			if(joined == true){
				buffer.append(scripts.substring(index,scripts.length()));
				sqlTemplate.setScripts(buffer.toString());
			}
			
		}
		
		return joined;
	}
	
	public String getDescription() {
		return "BaseMapper.xml{selectSql} 数据库SQL模板管理器";
	}

	public void load() throws PlatformException {
		reload();
	}

	public void reload() throws PlatformException {
		synchronized (log) {
			List<TCommonSql> list = service.queryList("plat.selectSql", null);
			caches.clear();
			if(list != null && list.isEmpty() == false){
				for(TCommonSql s : list){
					caches.add(new SqlTemplate(s));
				}
				/**
				 * 对进行影响的模板进行预处理
				 */
				for(ISqlTemplate t : caches){
					joinTemplate(t);
				}
			}
		}
		
	}

	public void reload(String cacheCode) throws PlatformException {
			synchronized (log) {
				remove(cacheCode);
				TCommonSql sql = new TCommonSql();
				sql.setTid(Integer.valueOf(cacheCode));
				List<TCommonSql> list = service.queryList("plat.selectSql", sql);
				if(list != null && list.isEmpty() == false){
					for(TCommonSql s : list){
						ISqlTemplate sqlTemplate = new SqlTemplate(s);
						caches.add(sqlTemplate);
						joinTemplate(sqlTemplate);
					}
				}
			}
			
	}
	
	public void reloadCatogory(String pkey){
		synchronized (log) {
			Iterator<ISqlTemplate> iters = caches.iterator();
			while(iters.hasNext() == true){
				ISqlTemplate temp = iters.next();
					if(pkey.equals(temp.getCategary())){
						caches.remove(temp);
						break;
					}
			}
			TCommonSql sql = new TCommonSql();
			sql.setPtid(Integer.valueOf(pkey));
			List<TCommonSql> list = service.queryList("plat.selectSql", sql);
			if(list != null && list.isEmpty() == false){
				for(TCommonSql s : list){
					caches.add(new SqlTemplate(s));
				}
			}
			
		}
		
	}

	public void release() throws PlatformException {
		
	}

	public void remove(String cacheCode) throws PlatformException {
			Iterator<ISqlTemplate> iters = caches.iterator();
				while(iters.hasNext() == true){
					ISqlTemplate temp = iters.next();
						if(cacheCode.equals(temp.getId())){
							caches.remove(temp);
							break;
						}
				}
	}
	
	
	public ISqlTemplate getTemplate(String key){
		if(StringUtil.isEmpty(key) == true){
			throw new IllegalArgumentException("传入的模板查找键不允许为空。");
		}
		ISqlTemplate result = null;
			for(ISqlTemplate temp : caches){
				if(key.equals(temp.getId()) || key.equals(temp.getName())){
					result = temp;
					break;
				}
			}
			return result;
	}

	public ICommonService getService() {
		return service;
	}

	public void setService(ICommonService service) {
		this.service = service;
	}

}
