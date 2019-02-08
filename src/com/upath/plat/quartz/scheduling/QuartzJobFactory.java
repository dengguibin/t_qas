package com.upath.plat.quartz.scheduling;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.upath.plat.quartz.model.TCommonScheduling;

/**
 * 
 * @Description: 计划任务执行处 无状态
 * @author chenjianlin
 * @date 2014年4月24日 下午5:05:47
 */
public class QuartzJobFactory implements Job {
	public final Logger log = Logger.getLogger(this.getClass());

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		TCommonScheduling scheduleJob = (TCommonScheduling) context.getMergedJobDataMap().get("scheduling");
		TaskUtils.invokMethod(scheduleJob);
	}
}