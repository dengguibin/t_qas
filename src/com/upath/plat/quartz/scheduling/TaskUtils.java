package com.upath.plat.quartz.scheduling;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionException;

import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.quartz.model.TCommonScheduling;
@SuppressWarnings({ "rawtypes", "unused" })
public class TaskUtils {
	public final static Logger logger = Logger.getLogger(TaskUtils.class);

	/**
	 * 通过反射调用scheduleJob中定义的方法
	 * 
	 * @param scheduleJob
	 * @throws JobExecutionException 
	 */
	public static void invokMethod(TCommonScheduling scheduleJob) throws JobExecutionException {
		BaseStatefulJob object = null;
		Class clazz = null;
		if (scheduleJob.getIstmed() == 1) { //spring容器
			object = (BaseStatefulJob) PlatUtil.getApplicationContext().getBean(scheduleJob.getJobclass());
		} else if (scheduleJob.getIstmed() == 2) {
			try {
				clazz = Class.forName(scheduleJob.getJobclass());
				object = (BaseStatefulJob) clazz.newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (object == null) {
			logger.error("任务名称 = [" + scheduleJob.getTaskname() + "]---------------未启动成功，请检查是否配置正确！！！");
			return;
		}
		
		String jobType = "单次JOB";
		if (2 == scheduleJob.getType()) {
			jobType = "循环JOB";
		} else if (1 == scheduleJob.getType()) {
			jobType = "定时单次JOB";
		}
		logger.info(String.format("%s==%s(%s)", jobType, scheduleJob.getTaskname(), scheduleJob.getTaskid()) + " 开始执行");
		
//		clazz = object.getClass();
//		Method method = null;
//		try {
//			method = clazz.getDeclaredMethod("execute");
//		} catch (NoSuchMethodException e) {
//			logger.error("任务名称 = [" + scheduleJob.getTaskname() + "]---------------未启动成功，方法名设置错误！！！");
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (method != null) {
//			try {
//				method.invoke(object, scheduleJob);
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalArgumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		object.execute(scheduleJob);
		logger.info(String.format("%s==%s(%s)", jobType, scheduleJob.getTaskname(), scheduleJob.getTaskid()) + " 执行完毕");
		
	}
}
