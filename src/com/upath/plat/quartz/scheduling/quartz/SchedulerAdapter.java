package com.upath.plat.quartz.scheduling.quartz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.scheduling.SchedulerManager;

/**
 *
 * 类名:SchedulerAdapter 说明:任务调度管理类。 
 *  日期:2015年5月14日 下午6:52:23
 * 
 * @version 1.0.0
 *
 */
public class SchedulerAdapter implements SchedulerManager {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private Scheduler scheduler;

	/**
	 * @see com.deceen.es.back.common.scheduling.SchedulerManager#start()
	 */
	@Override
	public void start() throws SchedulerException {
		scheduler.start();

	}

	/**
	 * @see com.deceen.es.back.common.scheduling.SchedulerManager#stop()
	 */
	@Override
	public void stop() throws Exception {
		scheduler.shutdown(true);
	}

	/**
	 * @see com.deceen.es.back.common.scheduling.SchedulerManager#addJob(String, String)
	 */
	@Override
	public boolean addJob(TCommonScheduling scheduling) throws Exception {
		JobDetail jobDetail = ScheduleUtil.initJobDetail(scheduling);
		if (1 == scheduling.getType()) {
			// 执行一次
			logger.info("添加单次JOB: " + scheduling.getTaskid());
			SimpleTrigger simpleTrigger = ScheduleUtil.initSimpleTrigger(scheduling.getTaskid());
			scheduler.scheduleJob(jobDetail, simpleTrigger);
		} else if (2 == scheduling.getType()) {
			logger.info("添加循环JOB: " + scheduling.getTaskid() + " " + scheduling.getCron());
			CronTrigger cronTrigger = ScheduleUtil.initCronTrigger(scheduling.getTaskid(), scheduling.getCron());
			scheduler.scheduleJob(jobDetail, cronTrigger);
		} else
			return false;

		return true;
	}

	@Override
	public boolean deleteJob(String jobName) throws Exception {
		logger.info("删除JOB: " + jobName);
		scheduler.deleteJob(jobName, jobName + "Group");
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getCurrentlyExecutingJobs() throws Exception {
		return scheduler.getCurrentlyExecutingJobs();

	}

	/**
	 * @see com.deceen.es.back.common.scheduling.SchedulerManager#getJobNameList()
	 */
	@Override
	public List<String> getJobNameList() throws Exception {
		List<String> jobNameList = new ArrayList<String>();
		String[] groupNames = scheduler.getJobGroupNames();

		if (groupNames != null && groupNames.length > 0) {
			for (String groupName : groupNames) {
				String[] jobNames = scheduler.getJobNames(groupName);

				if (jobNames != null && jobNames.length > 0) {
					for (String jobName : jobNames) {
						jobNameList.add(jobName);
					}
				}
			}
		}

		return jobNameList;
	}

	@Override
	public void pauseJob(String jobName) throws Exception {
		logger.info("暂停JOB： " + jobName);
		scheduler.pauseJob(jobName, jobName + "Group");

	}

	@Override
	public void replaceJob(TCommonScheduling scheduling) throws Exception {
		String name = scheduling.getTaskid();
		logger.info("替换JOB： " + name);
		scheduler.deleteJob(name, name + "Group");
		addJob(scheduling);
	}

	@Override
	public void resumeJob(String jobName) throws Exception {
		logger.info("重启JOB： " + jobName);
		scheduler.resumeJob(jobName, jobName + "Group");

	}

	public void scheduleJob(JobDetail jobDetail, CronTrigger cronTrigger) throws SchedulerException {
		scheduler.scheduleJob(jobDetail, cronTrigger);
	}

	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	@Override
	public boolean isJobExist(String jobName) throws Exception {
		if (StringUtils.isEmpty(jobName))
			return false;
		String[] groupNames = scheduler.getJobGroupNames();
		if (groupNames != null && groupNames.length > 0) {
			for (String groupName : groupNames) {
				String[] jobNames = scheduler.getJobNames(groupName);
				if (jobNames != null && jobNames.length > 0) {
					for (String job : jobNames) {
						if (jobName.equals(job))
							return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	// STATE_BLOCKED 4
	// STATE_COMPLETE 2
	// STATE_ERROR 3
	// STATE_NONE -1
	// STATE_NORMAL 0
	// STATE_PAUSED 1
	public boolean isJobRuning(String jobName) throws Exception {
		if (StringUtils.isEmpty(jobName))
			return false;
		int i = scheduler.getTriggerState(jobName + "Trigger", jobName + "TriggerGroup");
		if (i == Trigger.STATE_PAUSED || Trigger.STATE_NONE == i || Trigger.STATE_NORMAL == i)
			return false;
		return true;
	}

	public int getJobState(String jobName) throws Exception {
		return scheduler.getTriggerState(jobName + "Trigger", jobName + "TriggerGroup");
	}
}
