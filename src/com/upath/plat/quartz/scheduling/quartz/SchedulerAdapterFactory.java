package com.upath.plat.quartz.scheduling.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;


/**
 *
 * 类名:SchedulerAdapterFactory
 * 说明:任务调度管理工厂类。
 * 日期:2015年5月14日 下午6:52:36
 * 
 * @version 1.0.0
 *
 */
public class SchedulerAdapterFactory {

	/**
	 * 返回一个任务调度管理类。
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	public static SchedulerAdapter getScheduleAdapter() throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory("org/quartz/quartz.properties");
		Scheduler scheduler = schedulerFactory.getScheduler();

		SchedulerAdapter adapter = new SchedulerAdapter();
		adapter.setScheduler(scheduler);

		return adapter;
	}
}
