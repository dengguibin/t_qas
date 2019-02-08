package com.upath.plat.quartz.scheduling.quartz;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;

import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.scheduling.QuartzJobFactory;

/**
 *
 * 类名:ScheduleUtil 说明:任务调度工具类。
 *  日期:2015年5月14日 下午6:53:03
 * 
 * @version 1.0.0
 *
 */

public class ScheduleUtil {

	/**
	 * 更改安全策略初始化一个JobDetail。
	 * 
	 * @param policy
	 *            安全策略
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static JobDetail initJobDetail(TCommonScheduling scheduling) throws ClassNotFoundException {
		String name = scheduling.getTaskid();
		JobDetail jobDetail = new JobDetail(name, name + "Group", QuartzJobFactory.class);
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("scheduling", scheduling);
		jobDetail.setJobDataMap(jobDataMap);
		return jobDetail;
	}

	/**
	 * 根据给定的策略名称和时间表达式初始化一个CronTrigger。
	 * 
	 * @param name
	 *            策略名称
	 * @param cronExpression
	 *            时间表达式
	 * @return
	 * @throws ParseException
	 */
	public static CronTrigger initCronTrigger(String name, String cronExpression) throws ParseException {
		CronTrigger cronTrigger = new CronTrigger(name + "Trigger", name + "TriggerGroup");
		CronExpression cexp = new CronExpression(cronExpression);
		cronTrigger.setCronExpression(cexp);
		return cronTrigger;
	}

	/**
	 * 根据给定的策略名称和时间表达式初始化一个CronTrigger。
	 * 
	 * @param name
	 *            策略名称
	 * @param cronExpression
	 *            时间表达式
	 * @return
	 * @throws ParseException
	 */
	public static SimpleTrigger initSimpleTrigger(String name) throws ParseException {
		SimpleTrigger trigger = new SimpleTrigger(name + "Trigger", name + "TriggerGroup", new Date(), null, 0, 0L);
		return trigger;
	}
}
