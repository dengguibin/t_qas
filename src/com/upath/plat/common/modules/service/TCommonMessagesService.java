/**
 */
package com.upath.plat.common.modules.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.facade.IUser;
import com.upath.plat.auth.mapper.TRmsUserMapper;
import com.upath.plat.auth.model.TRmsUser;
import com.upath.plat.common.PlatConstant;
import com.upath.plat.common.PlatConstant.MessageStatus;
import com.upath.plat.common.PlatConstant.MessageTypes;
import com.upath.plat.common.mail.MailSenderImpl;
import com.upath.plat.common.modules.mapper.TCommonMessagesMapper;
import com.upath.plat.common.modules.mapper.TCommonMessagesReciversMapper;
import com.upath.plat.common.modules.model.TCommonMessages;
import com.upath.plat.common.modules.model.TCommonMessagesRecivers;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.StringUtil;

/**
 * 
 * @ClassName: TCommonMessagesAction.java
 * @Description: t_common_messages
 * @author upaths@gmail.com
 * @date 2015-3-23 17:57:04
 * @version V1.0
 */
@Component("tCommonMessagesService")
@SuppressWarnings({ "rawtypes", "unchecked"})
public class TCommonMessagesService extends CommonService {

	private TCommonMessagesMapper mapper;
	
	private TRmsUserMapper userMapper;

	private MailSenderImpl mailSender;

	private TCommonMessagesReciversMapper rmapper;
	
	/**
	 * 邮件信息查看
	 * @return
	 */
	public List listMailMessages(TCommonMessages params) {
		if(params == null){ params = new TCommonMessages();}
		params.setMtype(1);
		return list(params);
	}
	
	/**
	 * 系统消息查看
	 * @return
	 */
	public List listSystemMessages(TCommonMessages params) {
		if(params == null){ params = new TCommonMessages();}
		params.setMtype(2);
		return list(params);
	}
	
	/**
	 * 短信消息查看
	 * @return
	 */
	public List listShortMessages(TCommonMessages params) {
		if(params == null){ params = new TCommonMessages();}
		params.setMtype(0);
		return list(params);
	}
	
	

	public List<TCommonMessages> queryWaitMessges(int count) {
		return mapper.listqueue(count);
	}
	
	public List<TCommonMessagesRecivers> queryWaitRecs(int count) {
		return rmapper.listqueue(count);
	}
	
	public TCommonMessages select(Object id) {
		TCommonMessages message = mapper.select(id);
		message.setRecivers(rmapper.list(id));
		return message;
	}
	
	public Map queryUserMessageInfos(String userId){
		Map querys =new HashMap();
		if(userId != null){
			querys.put("userId", userId);
		}
		Map map = mapper.queryUserMessageInfos(querys);
		Map infos = null;
		MessageTypes[] types = MessageTypes.values();
		if(map != null && types != null){
			infos = new HashMap();
			for(int i = 0 ; i < types.length ; i++){
				MessageTypes type = types[i];
				Object value = map.get(type.getTypes());
				if( value != null){
					infos.put(type, value);
				}else{
					infos.put(type, 0);
				}
			}
		}
		return infos;
	}
	
	
	public int sendMail(TCommonMessages bean) {
		int ret = checkAndSendMailMsg(bean);
		if (ret > 0) {
			ret = insert(bean);
			bean.setXgr(bean.getCjr());
			bean.setXgsj(new Date());
			update(bean);
		}
		return ret;
	}

	public int insert(TCommonMessages bean) {
		String id = IDGenerator.getDateId();
		bean.setTid(id);
		bean.setStat(PlatConstant.MessageStatus.NOT_SEND.getValue());
		// 插入信息
		int ret = mapper.insert(bean);
		// 插入接受者
		List<TCommonMessagesRecivers> recives = new ArrayList<TCommonMessagesRecivers>();
		List<TCommonMessagesRecivers> temps = bean.getRecivers();
		for (TCommonMessagesRecivers r : temps) {
			r.setTid(IDGenerator.getDateId());
			r.setPtid(id);
			r.setStat(PlatConstant.MessageStatus.NOT_SEND.getValue());
			recives.add(r);
		}
		rmapper.batchInsert(recives);
		return ret;
	}
	/**
	 * 
	 * 通过用户id 发送邮件
	 * 
	 * @param title  标题
	 * @param content	邮件内容
	 * @param userid   用户id
	 */
	public void sendMailByUserid(String title,String content,String userid){
		if(StringUtil.isNotEmpty(userid)){
			TRmsUser tusr = new TRmsUser();
			tusr.setYhid(userid);
			TRmsUser user = userMapper.select(tusr);
			TCommonMessages bean =new TCommonMessages();
			bean.setTitle(title);
			bean.setContents(content);
			List<TCommonMessagesRecivers>  listRecs= new  ArrayList<TCommonMessagesRecivers>();
			if(user != null&&StringUtil.isNotEmpty(user.getDzyj())){
				TCommonMessagesRecivers rec = new TCommonMessagesRecivers();
				rec.setAddress(user.getDzyj());
				rec.setPhone(user.getSjhm());
				rec.setUnid(user.getBmid());
				rec.setReciver(user.getYhmc());
				listRecs.add(rec);
				bean.setRecivers(listRecs);
				insert(bean);
			}
		}
	}

	public int update(TCommonMessages bean) {
		bean.setStat(PlatConstant.MessageStatus.SEND.getValue());
		int ret = mapper.update(bean);
		bean = select(bean.getTid());
		for (TCommonMessagesRecivers rec : bean.getRecivers()) {
			rec.setXgr(bean.getXgr());
			rec.setXgsj(bean.getXgsj());
			rec.setSdate(new Date());
			rec.setStat(PlatConstant.MessageStatus.SEND.getValue());
		}
		rmapper.batchUpdate(bean.getRecivers());
		return ret;
	}
	
	public void updateBatchStatus(List<TCommonMessages> msgs) {
		mapper.batchUpdate(msgs);
		List<TCommonMessagesRecivers> revs = new ArrayList<TCommonMessagesRecivers>();
		for (TCommonMessages msg : msgs) {
			if(msg.getRecivers() != null){
				revs.addAll(msg.getRecivers());
			}
		}
		if(revs.isEmpty() == false){
			rmapper.batchUpdate(revs);
		}
	}
	
	
	public void updateBatchStatus(String rids[],MessageStatus status,IUser updator) {
		List<TCommonMessagesRecivers> revs = new ArrayList<TCommonMessagesRecivers>();
		if(rids != null && status != null){
			for(int i = 0 ; i < rids.length ; i++){
				TCommonMessagesRecivers rev = new TCommonMessagesRecivers();
				rev.setTid(rids[i]);
				rev.setStat(status.getValue());
				if(updator != null){
					rev.setXgr(updator.getUserId());
				}
				rev.setXgsj(new Date());
				rev.setSdate(new Date());
				revs.add(rev);
			}
		}
		if(revs.isEmpty() == false){
			rmapper.batchUpdate(revs);
		}
		
	}

	public List list(TCommonMessages bean) {
		return queryPageList(TCommonMessagesMapper.class.getName() + ".list", bean);
	}

	public int delete(Object id) {
		rmapper.deleteByPid(id);
		return mapper.delete(id);
	}

	public int delete(Object[] ids) {
		int result = 0;
		if(ids != null){
			batchDelete(Arrays.asList(ids), TCommonMessagesReciversMapper.class.getName()+".delete");
			result = 1;
		}
		return result;
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
	
	public TCommonMessagesMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(TCommonMessagesMapper mapper) {
		this.mapper = mapper;
	}

	public TRmsUserMapper getUserMapper() {
		return userMapper;
	}
	@Autowired
	public void setUserMapper(TRmsUserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public TCommonMessagesReciversMapper getRmapper() {
		return rmapper;
	}
	
	@Autowired
	public void setRmapper(TCommonMessagesReciversMapper rmapper) {
		this.rmapper = rmapper;
	}

	public MailSenderImpl getMailSender() {
		return mailSender;
	}

	@Autowired
	public void setMailSender(MailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}
}
