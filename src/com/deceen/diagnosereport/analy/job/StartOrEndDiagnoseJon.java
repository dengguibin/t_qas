package com.deceen.diagnosereport.analy.job;

import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.util.HtmlUtils;

import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.scheduling.BaseStatefulJob;
import com.upath.plat.quartz.service.TCommonSchedulingService;

public class StartOrEndDiagnoseJon  extends BaseStatefulJob{
	
	@Override
	public void executejob(TCommonScheduling scheduling) throws Exception {
		//参数获取
		JSONObject jsonObject = JSONObject.fromObject(HtmlUtils.htmlUnescape(scheduling.getParams().toString()));
		String taskId = jsonObject.getString("taskId");
		TCommonSchedulingService commonSchedulingService = (TCommonSchedulingService) PlatUtil.getApplicationContext().getBean("tCommonSchedulingService");
		TCommonScheduling Schedul = commonSchedulingService.select(taskId);
		String status = jsonObject.getString("status");
		if("0".endsWith(status)){//激活任务
			//生成结束的调度任务
			TCommonScheduling SchedulEnd = new TCommonScheduling();
			BeanUtils.copyProperties( SchedulEnd,Schedul);
			JSONObject json = new JSONObject();
			SchedulEnd.setTaskid(IDGenerator.getUUID());
			SchedulEnd.setTaskname("结束："+jsonObject.getString("taskName"));
			SchedulEnd.setJobclass(jsonObject.getString("jobClass"));
			SchedulEnd.setStates("1");
			SchedulEnd.setCron(jsonObject.getString("cron"));
			json.put("taskId", jsonObject.getString("taskId"));
			json.put("status", "1");
			SchedulEnd.setParams(json.toString());
			commonSchedulingService.insert(SchedulEnd);
			//执行任务
			Schedul.setStates("1");
			Schedul.setUdate(new Date());
			commonSchedulingService.update(Schedul);
			
			//删除当前激活任务
			commonSchedulingService.delete((Object)scheduling.getTaskid());
		}else{//结束任务
			//执行任务
			Schedul.setStates("0");
			Schedul.setUdate(new Date());
			commonSchedulingService.update(Schedul);
			
			//删除当前结束任务
			commonSchedulingService.delete((Object)scheduling.getTaskid());
		}
	}

}
