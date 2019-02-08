package com.upath.plat.common.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.cache.AuthCacheManager;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.mail.MailSenderImpl;
import com.upath.plat.common.modules.mapper.TCommonMessagesMapper;
import com.upath.plat.common.modules.mapper.TCommonMessagesReciversMapper;
import com.upath.plat.common.modules.model.TCommonMessages;
import com.upath.plat.common.modules.model.TCommonMessagesRecivers;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.RequestHelper;

@Component("tMessageService")
@SuppressWarnings({ "unused" })
public class MessageService extends CommonService implements IMessageService {

	private TCommonMessagesMapper mapper;

	private TCommonMessagesReciversMapper recMapper;
	
	private MailSenderImpl mailSender;
	
	public boolean addSysMsg(String userId, String title, String contents)
			throws PlatformException {
		   return addSysMsg(new String[]{userId},title,contents)[0];
	}

	public boolean[] addSysMsg(String[] userId, String title, String contents)
			throws PlatformException {
		boolean results[][]  = addMsg(userId, title, contents, SYS_MSG_STYLE);
		return calResults(results,2);
	}
	
	private boolean[] calResults(boolean results[][],int index){
		boolean rs[] = new boolean[results.length];
		for(int i = 0 ; i < results.length ; i++){
			rs[i] = results[i][index];
		}
		return rs;
	}

	public boolean[] addSysMsgByOrg(String orgId, String title, String contents)
			throws PlatformException {
		return addSysMsgByOrg(new String[]{orgId}, title, contents);
	}

	public boolean[] addSysMsgByOrg(String[] orgId, String title,
			String contents) throws PlatformException {
		boolean results[][] = addMsgByOrg(orgId, title, contents, SYS_MSG_STYLE);
		return calResults(results,2);
	}

	
	public boolean addSmsMsg(String userId, String title, String contents)
			throws PlatformException {
			return addSmsMsg(new String[]{userId}, title, contents)[0];
	}

	public boolean[] addSmsMsg(String[] userId, String title, String contents)
			throws PlatformException {
		boolean results[][] =  addMsg(userId, title, contents, SMS_MSG_STYLE);
		return calResults(results,0);
	}

	
	public boolean[] addSmsMsgByOrg(String orgId, String title, String contents)
			throws PlatformException {
		boolean results[][] =  addMsgByOrg(orgId, title, contents, SMS_MSG_STYLE);
		return calResults(results,0);
	}

	
	public boolean[] addSmsMsgByOrg(String[] orgId, String title,
			String contents) throws PlatformException {
		boolean results[][] =  addMsgByOrg(orgId, title, contents, SMS_MSG_STYLE);
		return calResults(results,0);
	}

	public boolean addSmsMsgByPhone(String phoneNumbser, String title,
			String contents) throws PlatformException {
		return addSmsMsgByPhone(new String[]{phoneNumbser}, title, contents)[0];
	}
	
	public boolean[] addSmsMsgByPhone(String[] phoneNumbser, String title,
			String contents) throws PlatformException {
//		if(1 == 1){
		if(true){
			throw new PlatformException("功能暂未实现，请关注");
		}
		return null;
	}

	public boolean addMailMsg(String userId, String title, String contents)
			throws PlatformException {
		return  addMailMsg(new String[]{userId}, title, contents)[0];
	}

	public boolean[] addMailMsg(String[] userId, String title, String contents)
			throws PlatformException {
		boolean results[][] =    addMsg(userId, title, contents, MAIL_MSG_STYLE);
		return this.calResults(results, 1);
	}

	public boolean addMailMsgByAddress(String address, String title,
			String contents) throws PlatformException {
		return addMailMsgByAddress(new String[]{address}, title, contents)[0];
	}

	public boolean[] addMailMsgByAddress(String[] address, String title,
			String contents) throws PlatformException {
//		if(1 == 1){
		if(true){
			throw new PlatformException("功能暂未实现，请关注");
		}
		return null;
	}

	public boolean[] addMailMsgByOrg(String orgId, String title, String contents)
			throws PlatformException {
		return addMailMsgByOrg(new String[]{orgId}, title, contents);
	}

	public boolean[] addMailMsgByOrg(String[] orgId, String title,
			String contents) throws PlatformException {
		boolean results[][]  = addMsgByOrg(orgId, title, contents, MAIL_MSG_STYLE);
		return this.calResults(results, 1);
	}

	
	public boolean[] addMsg(String userId, String title, String contents,
			int msgStyle) throws PlatformException {
		return addMsg(new String[]{userId},title,contents,msgStyle)[0];
	}
	
	public boolean[][] addMsg(String[] userId, String title, String contents,
			int msgStyle) throws PlatformException {
		return addMsg(userId, title, contents, msgStyle, false);
	}
	/**
	 * 适合于自动下发逻辑，不会取任务产生的userid
	 * @param userId
	 * @param title
	 * @param contents
	 * @param msgStyle
	 * @return
	 * @throws PlatformException
	 */
	public boolean[][] addAutoMsg(String[] userId, String title, String contents,
			int msgStyle) throws PlatformException {
		return addMsg(userId, title, contents, msgStyle, true);
	}
	
	private boolean[][] addMsg(String[] userId, String title, String contents,
			int msgStyle, boolean isAuto) throws PlatformException {
		if(userId == null || userId.length == 0 ){
			throw new PlatformException("发送消息的用户ID不能为空");
		}
		if(title == null || "".equals(title.trim() ) ){
			throw new PlatformException("发送消息的标题不能为空");
		}
		if(contents == null || "".equals(contents.trim() ) ){
			throw new PlatformException("发送消息的内容不能为空");
		}
		int len = 0 ;
		if((msgStyle & SYS_MSG_STYLE) > 0){
			len++;
		}
		if((msgStyle & SMS_MSG_STYLE) > 0){
			len++;
		}
		if((msgStyle & MAIL_MSG_STYLE) > 0){
			len++;
		}
		if(len == 0){
			throw new PlatformException("msgStyle 格式错误，未找到对应的消息格式");
		}
		IUser users[] = new IUser[userId.length];
		for(int i = 0 ; i < userId.length ; i++){
			users[i] = AuthCacheManager.getInstance().getUserById(userId[i]);
			if(users[i] == null){
				throw new PlatformException("系统中不存在的用户["+userId[i]+"]");
			}
		}
		boolean results[][] = new boolean[userId.length][3];
		TCommonMessages bean = new TCommonMessages();
		bean.setTid(IDGenerator.getUUID());
		bean.setTitle(title);
		bean.setContents(contents);
		bean.setCjsj(new Date());
		// 系统自动job不需关联具体的创建人
		if (!isAuto) {
			RequestHelper requestHelper = 	RequestHelper.getInstance();
			if(requestHelper != null){
			   IUser user  =	requestHelper.getLoginUser(); 
			   if(user != null){
				   bean.setCjr(user.getUserId());
			   }
			}
		} else {
			bean.setCjr("auto");
		}
		bean.setMtype(msgStyle);
		bean.setStat(0);
		for(int i = 0 ; i < users.length ; i++){
			IUser user = users[i];
			if((msgStyle & SMS_MSG_STYLE) > 0){
				if(user.getPhoneNumber() != null && "".equals(user.getPhoneNumber().toString()) == false){
					TCommonMessagesRecivers rev = createNewReciver(bean, isAuto);
					rev.setMtype(0);
					rev.setPhone(user.getPhoneNumber());
					rev.setReciver(user.getUserId());
					rev.setUnid(user.getDepartMent() != null ? user.getDepartMent().getDeptId() : null);
					bean.addReciver(rev);
					results[i][0] = true;
					
				}
			}
			
			if((msgStyle & MAIL_MSG_STYLE) > 0){
				if(user.getEmailAddress() != null && "".equals(user.getEmailAddress().toString()) == false){
					TCommonMessagesRecivers rev = createNewReciver(bean, isAuto);
					rev.setMtype(1);
					rev.setReciver(user.getUserId());
					rev.setUnid(user.getDepartMent() != null ? user.getDepartMent().getDeptId() : null);
					rev.setAddress(user.getEmailAddress());
					bean.addReciver(rev);
					results[i][1] = true;
				}
			}
			
			if((msgStyle & SYS_MSG_STYLE) > 0){
				TCommonMessagesRecivers rev = createNewReciver(bean, isAuto);
				rev.setMtype(2);
				rev.setReciver(user.getUserId());
				rev.setUnid(user.getDepartMent() != null ? user.getDepartMent().getDeptId() : null);
				bean.addReciver(rev);
				results[i][2] = true;
			}
		}
		
		if(bean.getRecivers() != null && bean.getRecivers().isEmpty() == false){
		this.mapper.insert(bean);
		batchInsert(bean.getRecivers(), TCommonMessagesReciversMapper.class.getName()+".insert");
		}
		return results;
	}
	
	protected  TCommonMessagesRecivers createNewReciver(TCommonMessages msg, boolean isAuto){
		TCommonMessagesRecivers recivers = new TCommonMessagesRecivers();
		recivers.setCjsj(new Date());
		// 系统自动job不需关联具体的创建人
		if (!isAuto) {
			RequestHelper requestHelper = 	RequestHelper.getInstance();
			if(requestHelper != null){
			   IUser user  =	requestHelper.getLoginUser(); 
			   if(user != null){
				   recivers.setCjr(user.getUserId());
			   }
			}
		} else {
			recivers.setCjr("auto");
		} 
		
		recivers.setPtid(msg.getTid());
		recivers.setTid(IDGenerator.getUUID());
		recivers.setStat(0);
		return recivers;
	}
	
	public boolean[][] addMsgByOrg(String orgId, String title, String contents,
			int msgStyle) throws PlatformException {
		return addMsgByOrg(new String[]{orgId}, title, contents, msgStyle);
	}

	public boolean[][] addMsgByOrg(String[] orgId, String title, String contents,
			int msgStyle) throws PlatformException {
		if(orgId == null || orgId.length == 0){
			throw new PlatformException("单位ID不允许为空");
		}
		List<IUser> users = AuthCacheManager.getInstance().getAllUsers();
		if(users == null){
			throw new PlatformException("系统中无法查找到用户相信信息");
		}
		Set<String> sets = new HashSet<String>();
		for(int i = 0 ; i < orgId.length ; i++){
			String deptId = orgId[i];
			for(int j = 0 ; j < users.size() ; j++){
				IUser user = users.get(j);
				if(deptId.equals(user.getDepartId())){
					sets.add(user.getUserId());
				}
			}
		}
		if(sets.isEmpty() == true){
			throw new PlatformException("通过单位在系统中无法查找到用户相信信息");
		}
		String[] userIds = new String[sets.size()];
		sets.toArray(userIds);
		return addMsg(userIds, title, contents, msgStyle);
	}

	
	
	public TCommonMessagesMapper getMapper() {
		return mapper;
	}

	public void setMapper(TCommonMessagesMapper mapper) {
		this.mapper = mapper;
	}

	public TCommonMessagesReciversMapper getRecMapper() {
		return recMapper;
	}

	public void setRecMapper(TCommonMessagesReciversMapper recMapper) {
		this.recMapper = recMapper;
	}

	public MailSenderImpl getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

}
