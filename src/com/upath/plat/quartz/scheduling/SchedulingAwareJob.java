package com.upath.plat.quartz.scheduling;

import com.upath.plat.quartz.model.TCommonScheduling;


/**
 *
 * 类名:PolicyAwareJob
 * 说明:策略更新接口
  * 日期:2015年5月14日 下午6:53:16
 * 
 * @version 1.0.0
 *
 */
public interface SchedulingAwareJob {

	/**
	 * 更新策略
	 * 
	 * @param policyBody
	 */
	public void updateScheduling(String md5, TCommonScheduling scheduling);
}
