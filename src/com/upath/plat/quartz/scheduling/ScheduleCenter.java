package com.upath.plat.quartz.scheduling;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upath.plat.quartz.scheduling.quartz.ScheduleInitImpl;


/**
 *
 * 类名:ScheduleCenter
 * 说明:任务调度中心。
  * 日期:2015年5月14日 下午6:53:30
 * 
 * @version 1.0.0
 *
 */
public class ScheduleCenter {

	/**
	 * 缓存所有定时任务配置参数。
	 */
	private static final ConcurrentHashMap<String, SchedulingAwareJob> schedulingAwareJobMap = new ConcurrentHashMap<String, SchedulingAwareJob>();
	private static SchedulerManager schedulerManager = null;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void init() throws Exception {
		logger.info("初始化任务调度中心。");
		ScheduleInit scheduleInit = new ScheduleInitImpl();
		scheduleInit.initScheduleCenter();
		schedulerManager = scheduleInit.getSchedulerManager();
	}

	public static ConcurrentHashMap<String, SchedulingAwareJob> getSchedulingAwareJobMap() {
		return schedulingAwareJobMap;
	}

	public static SchedulerManager getSchedulerManager() throws Exception {
		if(schedulerManager == null){
			ScheduleCenter  scheduleCenter = new ScheduleCenter();
			//初始化
			scheduleCenter.init();
			// 开启调度
			ScheduleCenter.getSchedulerManager().start();
		}
		return schedulerManager;
	}
}
