/**
 * 
 */
package com.upath.plat.quartz.scheduling;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.model.TCommonSchedulingLogs;
import com.upath.plat.quartz.service.TCommonSchedulingLogsService;
import com.upath.plat.quartz.service.TCommonSchedulingService;

/** 
 * @author pmhere 
 * @author E-mail: 358025872@qq.com 
 * @date 创建时间：2015年7月8日 下午6:23:30 
 * @version 1.0 
 * @parameter  
 * @notice 
 *  */
/**
 * @author wangyajun
 *
 */
public abstract class BaseStatefulJob{
	public Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 调度日志
	 */
	private TCommonSchedulingLogs bean = new TCommonSchedulingLogs();
	
	private StringBuffer  logBuffers  = new StringBuffer();
	
	//默认运行成功
	String states  = "1";
	
	StringWriter sw = new StringWriter();
	
	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	public void execute(TCommonScheduling scheduling) throws JobExecutionException {
		// TODO Auto-generated method stub
		if (scheduling == null) {
			logger.error("scheduling == null!");
			return;
		}

		String jobType = "单次JOB";
		if (2 == scheduling.getType()) {
			jobType = "循环JOB";
		} else if (1 == scheduling.getType()) {
			jobType = "定时单次JOB";
		}
		logger.info(String.format("%s==%s(%s)", jobType, scheduling.getTaskname(), scheduling.getTaskid()) + " 开始执行");
		
		//默认运行成功
		try {
			executejob(scheduling);
		} catch (Exception e) {
			//运行失败
			states = "0";
			PrintWriter p = new PrintWriter(sw, true);
			e.printStackTrace(p);
			logger.error(e.getMessage(), e);
		} finally {
			insertSchedulingLogsService(scheduling);
		}
		logger.info(String.format("%s==%s(%s)", jobType, scheduling.getTaskname(), scheduling.getTaskid()) + " 执行完毕");
	}
	
	/**
	 * 写入日志
	 * @param scheduling
	 */
	private void insertSchedulingLogsService(TCommonScheduling scheduling){
		try {
			InetAddress address = InetAddress.getLocalHost();
	
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            //ni.getInetAddresses().nextElement().getAddress();  
            byte[] mac = ni.getHardwareAddress();
            String worker = address.getHostName();
            String workIp = address.getHostAddress();  
            String sMAC = "";  
            Formatter formatter = new Formatter();
            if(mac!=null)
            for (int i = 0; i < mac.length; i++) {  
                sMAC = formatter.format(Locale.getDefault(), "%02X%s", mac[i],  
                        (i < mac.length - 1) ? "-" : "").toString();  
  
            }  

			bean.setWorker(worker);
			bean.setWorkip(workIp);
			bean.setMac(sMAC);
		} catch (Exception e) {
			logger.error("BaseStatefulJob 获取IP，MAC 异常", e);
		}  
		
		bean.setTaskid(scheduling.getTaskid());
		bean.setStates(states);
		bean.setDes("定时调度");
		logBuffers.append(sw.toString());
		bean.setMarks(logBuffers.toString());
		bean.setRundate(new Date());
		bean.setCdate(new Date());
		
		//扩展日志
		
		TCommonSchedulingLogsService schedulingLogsService = (TCommonSchedulingLogsService) PlatUtil.getApplicationContext().getBean("tCommonSchedulingLogsService");
		schedulingLogsService.insert(bean);
		try {
			//执行次数
			TCommonSchedulingService schedulingService = (TCommonSchedulingService) PlatUtil.getApplicationContext().getBean("tCommonSchedulingService");
			TCommonScheduling tCommonScheduling = schedulingService.select(scheduling.getTaskid());
			int Runtimes = tCommonScheduling.getRuntimes();
			tCommonScheduling.setRuntimes( ++ Runtimes );
			schedulingService.updateData(tCommonScheduling);
		} catch (Exception e) {
		}
	}
	
	
	/**
	 * 扩展日志方法 
	 * @param bean
	 */
	public void writeLogs(String logs){
		if(logs != null && "".equals(logs) == false){
			logBuffers.append(logs);
		}
		
	};

	/**
	 * 业务调度执行方法
	 * @param policy
	 */
	public abstract void executejob(TCommonScheduling scheduling) throws Exception;

}
