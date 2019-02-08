package com.upath.plat.quartz.scheduling;

import java.util.List;

import com.upath.plat.quartz.model.TCommonScheduling;

/**
 *
 * 类名:SchedulerManager 说明:任务调度管理接口。  
 * 日期:2015年5月14日 下午6:53:57
 * 
 * @version 1.0.0
 *
 */
public interface SchedulerManager {

	/**
	 * 启动定时任务。
	 * 
	 * @throws Exception
	 */
	public void start() throws Exception;

	/**
	 * 停止定时任务。
	 * 
	 * @throws Exception
	 */
	public void stop() throws Exception;

	/**
	 * 取得当前正在执行的任务实例。
	 * 
	 * @throws Exception
	 */

	@SuppressWarnings("rawtypes")
	public List getCurrentlyExecutingJobs() throws Exception;

	/**
	 * 取得任务名称列表。
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<String> getJobNameList() throws Exception;

	/**
	 * 添加一个任务。
	 * 
	 * @param policy
	 *            策略
	 * @return
	 * @throws Exception
	 */
	public boolean addJob(TCommonScheduling scheduling) throws Exception;

	/**
	 * 删除指定名称的任务。
	 * 
	 * @param jobName
	 *            任务名称
	 * @return
	 * @throws Exception
	 */
	public boolean deleteJob(String jobName) throws Exception;

	/**
	 * 暂停指定名称的任务。
	 * 
	 * @param jobName
	 *            任务名称
	 * @throws Exception
	 */
	public void pauseJob(String jobName) throws Exception;

	/**
	 * 重新运行暂停的任务。
	 * 
	 * @param jobName
	 *            任务名称
	 * @throws Exception
	 */
	public void resumeJob(String jobName) throws Exception;

	/**
	 * 用新的策略替换已有的任务。
	 * 
	 * @param policy
	 *            策略
	 * @throws Exception
	 */
	public void replaceJob(TCommonScheduling scheduling) throws Exception;

	/**
	 * 用新的策略替换已有的任务。
	 * 
	 */
	public boolean isJobExist(String jobName) throws Exception;

	/**
	 * 方法描述:判断Job当前状态
	 *
	 */
	public boolean isJobRuning(String jobName) throws Exception;

	public int getJobState(String jobName) throws Exception;
}
