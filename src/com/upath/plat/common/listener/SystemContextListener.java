package com.upath.plat.common.listener;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.context.WebApplicationContext;

import com.upath.plat.common.util.DateConvert;
import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.scheduling.ScheduleCenter;

/**
 * 
 * @author upaths
 * 2015-05-20
 * 修改当服务器进行正常关闭时
 * 调度框架的调度功能没有正常被关闭造成
 * implements ServletContextListener 
 *  [startQuertz_Worker-2] buthas  failed to stop it. This is very likely to create a memory leak. 
 *
 *系统的一些初始化和关闭操作都在此类里面进行实现
 *
 */
@SuppressWarnings({ "unused" })
public class SystemContextListener implements ServletContextListener  {

	private final static Logger logger = Logger.getLogger(SystemContextListener.class);
	
	public void contextDestroyed(ServletContextEvent event) {
//		WebApplicationContext webApplicationContext = (WebApplicationContext) event.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		logger.info("服务器关闭，关闭调度的线程程序，防止内存出问题");
//		if(webApplicationContext != null){
//			String qid = event.getServletContext().getInitParameter("quartzSpringId");
//			if(qid != null && "".equals(qid) == false){
//				org.quartz.impl.StdScheduler startQuertz = (org.quartz.impl.StdScheduler) webApplicationContext.getBean(qid);
//				if(startQuertz != null) {
//					startQuertz.shutdown();
//				}else{
//					logger.warn("Spring 上下文环境 中没有找到 "+qid+"这个实例，请检查配置");
//				}
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}else{
//				logger.warn("WEB.XML 没有配置 调度 quartzSpringId 的ID值，请配置");
//			}
//		}
		
		
		try {
			List<String> JobNameList = ScheduleCenter.getSchedulerManager().getJobNameList();
			for (String jobName : JobNameList) {
				try {
					logger.warn("服务器关闭时关闭任务:"+jobName);
					ScheduleCenter.getSchedulerManager().deleteJob(jobName);
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			logger.warn("服务器关闭时关闭任务异常", e);
		}
		
		
	}

	/**
	 * 
	 * 定时执行添加新分区
	 * schedulingTask.setCron("0 0 24 * * ?") ：每天凌晨0点执行此任务
	 * TimingPartitionTask ：添加新分区
	 * 
	 * 定时任务知识参考：Myjob.java,Test.java
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	public void cycleNewPartition() throws Exception{
		TCommonScheduling schedulingTask = new TCommonScheduling();
		
		schedulingTask.setTaskid("taskId1");
		schedulingTask.setTaskname("taskName1");
		schedulingTask.setType(2);
		schedulingTask.setIstmed(2); //类加载方式 --2, 全类加载
		schedulingTask.setCron("0 0 0 1-31 1-12 ? ");
		schedulingTask.setJobclass("com.deceen.diagnosereport.analy.job.TimingPartitionTask");
		
		ScheduleCenter.getSchedulerManager().addJob(schedulingTask);
	}


	public void contextInitialized(ServletContextEvent evt) {
		//定时执行添加新分区
		try {
			cycleNewPartition();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		/**
		 * 对日期类型的转换进行注册
		 */
			ConvertUtils.register(new DateConvert(), java.util.Date.class);     
	        ConvertUtils.register(new DateConvert(), java.sql.Date.class);     
	        logger.info("BeanUtils 对日期类型的转换进行注册");
	        /**
	         * 增加下面的新功能，对log4j进行动态配置
	         * 1：如果在同一应用使用热部署的情况 下面使用同一套代码，
	         * 不同的数据库来进行系统软件多部署应用，按照系统部署的名称来命名日志文件
	         */
	        String key = evt.getServletContext().getInitParameter("log4jFileKey");
	        String prefix = evt.getServletContext().getContextPath();
	        //如果WEB.XML没有配置此信息或者是上下文名称是根路径不进行调整
	        if(key != null && prefix != null && "".equals(prefix.trim()) == false){
	        	logger.info("log4j日志功能准备动态配置日志文件名称");
	        	 URL url = 	Thread.currentThread().getContextClassLoader().getResource("log4j.properties");
	        	 try {
	        		if(url != null){
	        			File file = new File(url.toURI());
						Properties props = new Properties();
						props.load(new FileInputStream(file));
						String fileLoation = props.getProperty(key);
						if(fileLoation != null){
							int index = fileLoation.lastIndexOf("/");
							if(index > 1){
								String newLoction = fileLoation.substring(0,index+1)+prefix+"_"+fileLoation.substring(index+1);
								props.put( key, newLoction);
								PropertyConfigurator.configure(props);
								logger.info("系统重新定位log4j日志文件信息:"+newLoction);
							}
						}
	        		}else{
	        			logger.info("系统加载没有发现log4j.properties配置文件");
	        		} 
					
				} catch (Exception e) {
					logger.error(e);
				}
	        }
	}

}
