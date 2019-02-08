package com.upath.plat.quartz.scheduling;


/**
 *
 * 类名:ScheduleInit
 * 说明:任务调度初始化接口。
 * 
 * 日期:2015年5月14日 下午6:53:44
 * 
 * @version 1.0.0
 *
 */
public interface ScheduleInit {

	/**
	 * 根据配置参数初始化任务调度。
	 * 
	 * @throws Exception
	 */
	public void initScheduleCenter() throws Exception;

	/**
	 * 取得任务调度管理接口
	 * 
	 * @return
	 */
	public SchedulerManager getSchedulerManager();
}
