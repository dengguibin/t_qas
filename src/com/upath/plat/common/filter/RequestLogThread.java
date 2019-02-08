package com.upath.plat.common.filter;

import java.util.Map;

import net.sf.json.JSONObject;

import com.upath.plat.common.modules.model.TRmsAlllogs;
import com.upath.plat.common.modules.service.TRmsAlllogsService;
@SuppressWarnings({ "rawtypes" })
public class RequestLogThread implements Runnable {

	TRmsAlllogs log;
	TRmsAlllogsService service;
	Map params;
	
	public RequestLogThread(TRmsAlllogs log,TRmsAlllogsService service,Map params){
		this.log = log;
		this.service = service;
		this.params = params;
	}
	
	public void run() {
		if(this.log != null && this.service != null){
			if(this.params != null){
				String jsonString = JSONObject.fromObject(params).toString();
				log.setContents(jsonString);
			}
			service.insert(log);
		}
		
	}

}
