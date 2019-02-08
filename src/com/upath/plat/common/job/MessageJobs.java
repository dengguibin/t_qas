package com.upath.plat.common.job;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.upath.plat.common.PlatConstant;
import com.upath.plat.common.mail.MailSender;
import com.upath.plat.common.modules.model.TCommonMessages;
import com.upath.plat.common.modules.model.TCommonMessagesRecivers;
import com.upath.plat.common.modules.service.TCommonMessagesService;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.scheduling.BaseStatefulJob;

/**
 * @ClassName: MessageJobs
 * @Description: 邮件自动发送任务
 * @author liyyupaths@gmail.com
 * @date 3 24, 2015 11:04:49 AM
 * @version V1.0
 * 
 */
public class MessageJobs  extends BaseStatefulJob{

	private TCommonMessagesService service;

	private static final Logger log = Logger.getLogger(MessageJobs.class);
	private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
	// 默认全取
	private static final int COUNT = Integer.MAX_VALUE;
	// 如果短信连续 多少次发送都失败的情况 下面。那么 系统自动标识些短信发送失败不再进行发送。
	private int sendCount = 3;
	// 邮件发送器
	private MailSender mailSender;
	
	@Override
	public void executejob(TCommonScheduling scheduling) throws Exception {
		service = (TCommonMessagesService) PlatUtil.getApplicationContext().getBean("tCommonMessagesService");
		mailSender = (MailSender) PlatUtil.getApplicationContext().getBean("mailSender");
		run();
		
	}
	
	private void buidMessages(List<TCommonMessages> messages, List<TCommonMessagesRecivers> revs) {
		for (int i = 0; i < messages.size(); i++) {
			TCommonMessages msg = messages.get(i);
			for (int j = 0; j < revs.size(); j++) {
				TCommonMessagesRecivers rev = revs.get(j);
				if (rev.getPtid().equals(msg.getTid())) {
					msg.addReciver(rev);
				}
			}
		}
	}

	private void markMessage(TCommonMessages msg) {
		if (msg instanceof TCommonMessages) {
			TCommonMessages cmsg = (TCommonMessages) msg;
			cmsg.setXgsj(new Date());
			cmsg.setRdate(new Date());
			int stat = PlatConstant.MessageStatus.NOT_SEND.getValue();
			if(msg.getRecivers() != null){
			for (TCommonMessagesRecivers rev : msg.getRecivers()) {
				rev.setXgsj(new Date());
				rev.setSdate(new Date());
				Integer count = rev.getSresult();
				if (count == null) {
					count = new Integer(0);
				}
				count += 1;
				rev.setSresult(count);
				if (rev.getStat() != PlatConstant.MessageStatus.SEND.getValue()) {
					if (rev.getSresult() >= sendCount) {
						rev.setStat(PlatConstant.MessageStatus.SEND_FAILED.getValue());
						if (rev.getSmark() == null) {
							rev.setSmark("连续调用" + sendCount + ",后发送失败");
						}
					}
				} else {
					rev.setStat(PlatConstant.MessageStatus.SEND.getValue());
					stat = PlatConstant.MessageStatus.SEND.getValue();
				}
			}
			}
			cmsg.setStat(stat);
		}
	}

	public void run() throws Exception{
		log.info("=======邮件调度程序开始===========");
		int result = 0;
		List<TCommonMessages> messages = service.queryWaitMessges(COUNT);
		result += messages.size();
		log.info("=======共"+result+"封===========");
		List<TCommonMessagesRecivers> revs = service.queryWaitRecs(COUNT);//只找出短信和邮件的接收人
		if(revs==null || revs.isEmpty()){
			return;
		}
		int count = 0;
		buidMessages(messages, revs);
		for(TCommonMessages msg : messages){
			try{
				count += checkAndSendMailMsg(msg);
			}catch (Exception e) {
				log.error("发送邮件信息失败",e);
			}finally{
				markMessage(msg);
			}
		}
		service.updateBatchStatus(messages);
		log.info("邮件调度程序结束，"+fmt.format(new Date())+"，发送邮件："+count+"封。");
	}

	private int checkAndSendMailMsg(TCommonMessages msg) {
		int count = 0;
		if (msg != null) {
			List<TCommonMessagesRecivers> rvs = msg.getRecivers();
			if (rvs != null && rvs.isEmpty() == false) {
				for (int i = 0; i < rvs.size(); i++) {
					TCommonMessagesRecivers rv = rvs.get(i);
					boolean result = false;
					String address = rv.getAddress();
					if (address != null && "".equals(address) == false) {
						String arr[] = address.split(",");
						List<String> toList = Arrays.asList(arr);
						result = this.mailSender.send(toList, msg.getTitle(), msg.getContents());
					}
					rv.setStat(result == true ? 1 : 0);
					count++;
				}
			}
		}
		return count;
	}

	public TCommonMessagesService getService() {
		return service;
	}

	@Autowired
	public void setService(TCommonMessagesService service) {
		this.service = service;
	}

	public int getSendCount() {
		return sendCount;
	}

	public void setSendCount(int sendCount) {
		this.sendCount = sendCount;
	}

	public MailSender getMailSender() {
		return mailSender;
	}
	
	@Autowired
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
}
