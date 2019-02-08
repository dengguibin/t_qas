package com.upath.plat.quartz.scheduling.quartz;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upath.plat.quartz.scheduling.ScheduleCenter;
import com.upath.plat.quartz.scheduling.ScheduleInit;
import com.upath.plat.quartz.scheduling.SchedulerManager;


/**
 *
 * 类名:ScheduleInitImpl
 * 说明:任务调度初始化实现类。
 *
 * 日期:2015年5月14日 下午6:52:10
 * 
 * @version 1.0.0
 *
 */
public class ScheduleInitImpl implements ScheduleInit {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private SchedulerAdapter scheduler;

	public void initScheduleCenter() {
		ScheduleCenter.getSchedulingAwareJobMap().clear();

		try {
			scheduler = SchedulerAdapterFactory.getScheduleAdapter();
			scheduler.start();
		} catch (SchedulerException e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * @see com.deceen.es.back.common.scheduling.ScheduleInit#getSchedulerManager()
	 */
	@Override
	public SchedulerManager getSchedulerManager() {
		return scheduler;
	}
}
