package com.upath.plat.common.job;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.sun.tools.jdi.LinkedHashMap;
import com.upath.plat.auth.facade.IMenu;
import com.upath.plat.common.cache.AuthCacheManager;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.modules.model.TRmsAlllogs;
import com.upath.plat.common.modules.service.TRmsAlllogsService;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.scheduling.BaseStatefulJob;
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class ClearAllLogJob extends BaseStatefulJob{
	
	private static final Logger log = Logger.getLogger(ClearAllLogJob.class);
	
	//配置的路径匹配信息
	private Map<String, String> logConfigs  = null;
	//需要忽略的路径信息
	private Map<String, String> ignores = null;
	
	//配置的清理的天数，最少是30天才删除数据
	private int clearDay = 30;
	
	private int clearRow = 30;
	
	private TRmsAlllogsService service;
	/**
	 * 初始化是否成功
	 */
	boolean init = false;
	
	@Override
	public void executejob(TCommonScheduling scheduling) throws Exception {
		service = (TRmsAlllogsService) PlatUtil.getApplicationContext().getBean("tRmsAlllogsService");
		run();
		
	}
	
	
	public synchronized void run(){
		try {
			initConfigs();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlatformException("日志管理器加载配置失败",e);
		}
		if(init == false || logConfigs == null || ignores == null){
			throw new PlatformException("日志管理器加载配置失败");
		}
		String[] regexCon = new String[logConfigs.keySet().size()] ;
		logConfigs.keySet().toArray(regexCon);
		String[] regexIgn = new String[ignores.keySet().size()] ;
		ignores.keySet().toArray(regexIgn);
			
		List datas = service.listParseLogs(clearRow);
			while(datas != null && datas.isEmpty() == false){
				for(int i = 0 ; i < datas.size() ; i++){
					TRmsAlllogs logBean = (TRmsAlllogs) datas.get(i);
					logBean.setXgsj(new Date());
					//是否丢弃
					boolean ignred = false;
					String input = logBean.getUrl();
					if(input != null){
						String contents = logBean.getContents();
						if(contents != null){
							try{
								JSONObject json = JSONObject.fromObject(contents);
								String menuId = null;
								if(json != null && json.has("menuId")){
									Object obj = json.get("menuId");
									if(obj instanceof JSONArray){
										JSONArray arr = (JSONArray)obj;
										menuId = arr.get(0).toString();
									}else{
										menuId = obj.toString();
									}
								}
								if(menuId != null && menuId.matches(("\\d+"))){
									IMenu menu =	AuthCacheManager.getInstance().getMenu(Integer.valueOf(menuId));
									if(menu != null){
										logBean.setMenu(menu.toString());
									}
								}
							}catch(Exception e){
								log.error("解释JSON数据失败");
							}
						}
						for(int j =  regexIgn.length -1 ; j >= 0 ; j-- ){
							if(input.matches(regexIgn[j]) == true ){
								ignred = true;
								logBean.setSfyx(-1);
								logBean.setStatus(2);
								logBean.setDescr(ignores.get(regexIgn[j]));
								break;
							}
						}
						
						if(ignred == false){
							for(int j = regexCon.length -1  ; j >= 0  ; j-- ){
								if(input.matches(regexCon[j]) == true ){
									ignred = true;
									logBean.setSfyx(1);
									logBean.setStatus(1);
									logBean.setDescr(logConfigs.get(regexCon[j]));
									break;
								}
							}
						}
						
						if(logBean.getStatus() == 0){
							logBean.setSfyx(-1);
							logBean.setStatus(2);
							logBean.setDescr("丢弃");
						}
						
					}else{
						logBean.setSfyx(-1);
						logBean.setStatus(2);
						logBean.setDescr("丢弃");
					}
				}
				service.updateBatch(datas);
				//测试清空
				datas = null;
				datas = service.listParseLogs(clearRow);
			}
		
	}
	
	
	
	public static void main(String[] args) {
		URL dir = 	ClearAllLogJob.class.getClassLoader().getResource("");
		String path = "/config/prop/log-rule.xml";
		try {
			File dirFile = new File(dir.toURI());
			File logConfig = new File(dirFile, path);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		String url = "/e4safe.web/plat/common/tCommonMessage!queryUserMsgInfos.action";
		String regex = "[^\\s]*/plat/[^\\s]*tCommonMessage![^\\s]*.action";
		System.out.println(Pattern.matches(regex, url));
		try {
			//new ClearAllLogJob().initConfigs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
		void initConfigs() throws Exception{
			URL dir = 	ClearAllLogJob.class.getClassLoader().getResource("/config/prop/log-rule.xml");
				File logConfig = new File(dir.toURI());
			//	logConfig = new File("D:\\log-rule.xml");
			Document document = null;
			String xmlInfo = FileUtils.readFileToString(logConfig, "UTF-8");
			try {
				document = DocumentHelper.parseText(xmlInfo);
			} catch (DocumentException e) {
				e.printStackTrace();
				throw new PlatformException("无法解释的XML文档", e);
			}
			Element root = document.getRootElement();
			Element eleDays = root.element("clear-day");
				if(eleDays != null){
					int day = Integer.valueOf(eleDays.getText());
					clearDay = day > clearDay ? day : clearDay;
				}
				
				eleDays = root.element("clear-rows");
				if(eleDays != null){
					int rows = Integer.valueOf(eleDays.getText());
					clearRow = rows > clearRow ? rows : clearDay;
				}
		
				Element logsEle = root.element("includes");
				
				if (logsEle != null) {
					List<Element> cats = logsEle.elements();
					for (int i = 0; i < cats.size(); i++) {
						Element element  = cats.get(i);
						String name = element.attribute("name").getValue();
						String regex = element.getText();
						try{
							Pattern.compile(regex);
						}catch(Exception e){
							log.error(regex + "：无法编译的正则表达式");
							throw new PlatformException(e);
						}
						if(logConfigs == null){
							logConfigs = new LinkedHashMap();
						}
						logConfigs.put(regex, name);
					}
			}
				
				logsEle = root.element("ignore");
				if (logsEle != null) {
					List<Element> cats = logsEle.elements();
					for (int i = 0; i < cats.size(); i++) {
						Element element  = cats.get(i);
						String name = element.attribute("name").getValue();
						String regex = element.getText();
						try{
							Pattern.compile(regex);
						}catch(Exception e){
							log.error(regex + "：无法编译的正则表达式");
							throw new PlatformException(e);
						}
						if(this.ignores == null){
							ignores = new LinkedHashMap();
						}
						ignores.put(regex,name );
					}
			}
				init = true;
		}
		
		public TRmsAlllogsService getService() {
			return service;
		}



		public void setService(TRmsAlllogsService service) {
			this.service = service;
		}


}
