/**
 * 
 */
package com.upath.plat.quartz.scheduling.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.scheduling.ScheduleCenter;


/** 
 * @author pmhere 
 * @author E-mail: 358025872@qq.com 
 * @date 
 * @version 1.0 
 * @parameter  
 * @notice 
 *  */
/**
 * @author wangyajun
 *
 */
public class Test {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public void start(){
		logger.info("------��Job�������---------");
		try {
//			ScheduleCenter scheduleCenter = new ScheduleCenter();
//			scheduleCenter.init();
			
			
			TCommonScheduling scheduling = new TCommonScheduling();
			scheduling.setTaskid("taskId1");
			scheduling.setTaskname("taskName1");
			scheduling.setType(2);
			scheduling.setIstmed(2); //类加载方式 --2, 全类加载
			scheduling.setCron("* * * * * ?");
			scheduling.setJobclass("com.upath.plat.quartz.scheduling.job.MyJob");
			
			
			ScheduleCenter.getSchedulerManager().addJob(scheduling);

//			Thread.sleep(5000);
			//删除任务
			//ScheduleCenter.getSchedulerManager().deleteJob("11");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), logger);
			Thread.currentThread().interrupt();
		}
	}
	
	public static void main(String args[]){
		new Test().start();
	}
}
