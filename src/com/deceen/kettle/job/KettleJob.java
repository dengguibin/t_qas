package com.deceen.kettle.job;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;

import org.apache.commons.io.FileUtils;

import com.deceen.datacollector.model.TDatasCollector;
import com.deceen.datacollector.service.TDatasCollectorService;
import com.deceen.kettle.service.KettleService;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.util.RequestHelper;
import com.upath.plat.common.util.SpringContextUtil;
import com.upath.plat.common.util.StringUtil;
import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.scheduling.BaseStatefulJob;
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class KettleJob  extends BaseStatefulJob {
	String foldPath="kettleFiles";
	@Override
	public void executejob(TCommonScheduling scheduling) throws Exception {
		// TODO Auto-generated method stub
		TDatasCollector tdatasCollector = new TDatasCollector();
		tdatasCollector.setValid(1);
		TDatasCollectorService tDatasCollectorService =(TDatasCollectorService)SpringContextUtil.getBean("tDatasCollectorService");
		KettleService kettleService =(KettleService)SpringContextUtil.getBean("kettleService");
		List list = tDatasCollectorService.list(tdatasCollector);
		IUser user = RequestHelper.getInstance().getLoginUser();
		if(list!=null && list.size()>0){
			int size =list.size();
			for(int i=0;i<size;i++){
				Map<String,Object> obj =(Map<String,Object>)list.get(i);
				TDatasCollector bean = tDatasCollectorService.select(obj.get("TID"));
				Date startDate = new Date();
				int state=0;
				Map<String,String> resultMap = new HashMap<String, String>();
				String cpath;
				try {
					cpath = getPath();
					String fileUrl=cpath+foldPath+"/"+bean.getTid()+".ktr";
					File file = new File(fileUrl);
					if(!file.exists()&&StringUtil.isNotBlank(bean.getSource())){
						FileUtils.writeStringToFile(file, bean.getSource());
					}
					if(file.exists()){
						Map<String,String>variableMap = new HashMap<String, String>();
						String params=bean.getParams();
						if(StringUtil.isNotBlank(params)){
							JSONArray ja = JSONArray.fromObject(params);
							Object arrayObject = JSONArray.toArray(ja,HashMap.class);
							 if(arrayObject!=null){
									Object[] array = (Object[])arrayObject;
									int len =array.length;
									for(int j=0;j<len ;j++){
										Map<String,String> hm=(HashMap)array[j];
										if(hm!=null){
											Set<Entry<String, String>> entrySet = hm.entrySet();
											for(Entry<String, String>entry:entrySet){
												variableMap.put(entry.getKey(), entry.getValue());
											}
										}
									}
							 }
						}
						Map<String, Object> reMap = kettleService.excuteTran(fileUrl, variableMap, null, null);
						String trnResult = String.valueOf(reMap.get("result"));
						bean.setLogs(String.valueOf(reMap.get("logTextBuffer")));
						if(StringUtil.equals("success", trnResult)){
							resultMap.put("msg", "执行完成");
							state=1;
						}else{
							resultMap.put("msg", "执行出错");
						}
					}else{
						resultMap.put("msg", "没有可以执行的附件");
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					resultMap.put("msg", "执行失败");
				}finally{
					Date endDate = new Date();
					bean.setState(state);
					bean.setRdate(startDate);
					long cos = (endDate.getTime() - startDate.getTime())/1000;
					bean.setCosts((int)cos);
					bean.setUdate(new Date());
					bean.setUpdator(user.getUserId());
					tDatasCollectorService.update(bean);
				}
			}
		}
	}
	private String getPath() throws UnsupportedEncodingException {
		URL path = Thread.currentThread().getContextClassLoader().getResource("");
		String cpath=path.getPath();
		cpath=URLDecoder.decode(cpath, "UTF-8");
		return cpath;
	}
}
