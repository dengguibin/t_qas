package com.upath.plat.common.modules.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.PlatConstant.MessageStatus;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.cache.CacheManager;
import com.upath.plat.common.modules.model.TCommonMessages;
import com.upath.plat.common.modules.model.TCommonMessagesRecivers;
import com.upath.plat.common.modules.model.TCommonSubkeys;
import com.upath.plat.common.modules.service.TCommonMessagesService;
import com.upath.plat.common.modules.service.TCommonSubkeysService;

@Scope("prototype")
@Component("tCommonMessageAction")
@SuppressWarnings({ "rawtypes", "serial", "unchecked", "unused" })
public class TCommonMessageAction extends BaseActionSupport {

	/* 服务类 */
	private TCommonSubkeysService service;

	/* 邮件类 */
	private TCommonMessagesService mailService;

	/* 操作实体 */
	private TCommonSubkeys bean;
	// 主题
	private String title;
	// 内容
	private String contents;
	// 接收人
	private String receivers;

	private TCommonMessages message;
	
	private List datas;

	/**
	 * 查询数据列表
	 * 
	 * @return select
	 */
	public String list() {
		request.setAttribute("mapper", service.getMapperClass());
		return "list";
	}
	
	/**
	 * 邮件信息查看
	 * @return
	 */
	public String listMailMessages() {
		datas = mailService.listMailMessages(message);
		return "listMail";
	}
	
	/**
	 * 系统消息查看
	 * @return
	 */
	public String listSystemMessages() {
		datas = mailService.listSystemMessages(message);
		return "listSystem";
	}
	
	/**
	 * 用户接受系统消息查看
	 * @return
	 */
	public String listUserSysMsgs() {
		if(message == null){
			message = new TCommonMessages();
		}
		if(getLoginUser() != null){
			message.setUserId(getLoginUser().getUserId());
			datas = mailService.listSystemMessages(message);
		}
		return "listUserSysMsgs";
	}
	
	/**
	 * 短信消息查看
	 * @return
	 */
	public String listShortMessages() {
		datas = mailService.listShortMessages(message);
		return "listShort";
	}
	
	
	

	public String select() {
		TCommonSubkeys data = service.select(bean);
		if (data != null) {
			bean = data;
		}

		if (bean != null) {
			bean.setValid(1);
		}
		return "select";
	}
	


	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	
	public TCommonMessages getMessage() {
		return message;
	}

	public void setMessage(TCommonMessages message) {
		this.message = message;
	}
	
	/**
	 * 避免进行令牌环的限制
	 * @return
	 * @throws Exception
	 */
	public String updateParam() throws Exception {
		return save();
	}

	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * 
	 * @return select
	 */
	public String save() throws Exception {
		TCommonSubkeys data = service.select(bean);
		Map result = new HashMap();
		result.put("status", "0");
		try{
			if (data != null) {
				//消息配置里面只配置这一个值
				data.setParams1(bean.getParams1());
				service.update(data);
			} else {
				service.insert(bean);
			}
			result.put("status", "1");
		}catch(Exception e){
			e.printStackTrace();
			result.put("message", e.getMessage());
		}
		
		// 返回到列表重新再进行增加
		if (bean != null) {
			// 清空字段，在查询时不需使用此字段来查询
			bean.setSubcode(null);
		}
		CacheManager.getInstance().reload(bean.getCode());
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}

	/**
	 * 发送测试邮件
	 * 
	 * @return
	 * @throws IOException
	 */
	public String sendMail() throws IOException {
		Map result = new HashMap();
		result.put("status", "0");
		TCommonMessages messages = new TCommonMessages();
		initMessage(messages,1,";");
		try{
			int ret = mailService.sendMail(messages);
			result.put("status", "1");
		}catch(Exception e){
			result.put("message", e.getMessage());
		}
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	
	public String sendMsg() throws IOException {
		Map result = new HashMap();
		result.put("status", "0");
		if(bean != null && bean.getCode() != null){
			TCommonMessages messages = new TCommonMessages();
			if("SMS".equals(bean.getCode()) == true){
				//短信
				initMessage(messages,0,";");
			}else if("MAIL".equals(bean.getCode())){
				//邮件消息
				initMessage(messages,1,";");
			}else if("MSG_SMS".equals(bean.getCode())){
				//系统消息
				initMessage(messages,2,";");
			}
			try{
				int ret = mailService.insert(messages);
				result.put("status", "1");
			}catch(Exception e){
				result.put("message", e.getMessage());
			}
		}
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	/**
	 * 查询个人用户的系统信息列表
	 * @return
	 * @throws IOException
	 */
	public String queryUserMsgInfos() throws IOException {
		Map result = new HashMap();
		if(getLoginUser() != null){
			Map	data = mailService.queryUserMessageInfos(getLoginUser().getUserId());
			if(data != null){
			 Iterator iter = 	data.keySet().iterator();
			 while(iter.hasNext()){
				 Object key = iter.next();
				 result.put(key.toString(), data.get(key));
			 }
			}
		}
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	public String updateMsgStatus() throws IOException {
		Map result = new HashMap();
		result.put("status", "0");
		if(message != null && message.getTid() != null){
			String idArrs[] = message.getTid().split("[,]");
			boolean checkResult = true;
			if(checkResult == true){
				try{
					 mailService.updateBatchStatus(idArrs, MessageStatus.SEND, getLoginUser());
					result.put("status", "1");
				}catch(Exception e){
					e.printStackTrace();
					result.put("message", e.getMessage());
				}
			}else{
				result.put("status", "2");
				result.put("message", "已经存在相关联的数据，请先删除");
			}
		}else{
			result.put("message","错误参数");
		}
		
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	/**
	 * 
	 * @param messages
	 * @param type 0 短信，1 邮件 ，2 系统消息 
	 */
	private void initMessage(TCommonMessages messages,int type,String split){
		messages.setTitle(title);
		messages.setContents(contents);
		messages.setCjr(getLoginUser().getUserId());
		messages.setCjsj(new Date());
		List<TCommonMessagesRecivers> list = new ArrayList<TCommonMessagesRecivers>();
		for (String receive : receivers.split(split)) {
			TCommonMessagesRecivers rev = new TCommonMessagesRecivers();
			if( 0 == type){
				rev.setPhone(receive);
			}else if(1 == type){
				rev.setAddress(receive);
			}else if(2 == type){
				rev.setReciver(receive);
				
			}
			rev.setMtype(type);
			rev.setCjr(getLoginUser().getUserId());
			rev.setCjsj(new Date());
			list.add(rev);
		}
		messages.setRecivers(list);
	}

	/**
	 * 删除数据
	 * 
	 * @return select
	 * @throws IOException
	 */
	public String delete() throws IOException {
		service.delete(bean);
		CacheManager.getInstance().reload(bean.getCode());
		response.getWriter().write("1");
		return null;
	}
	
	
	/**
	 * 删除方法，如果ID 上是以","隔开的字符，会认为是一个数组,批量删除数据
	 */
	public String remove() throws Exception {
		Map result = new HashMap();
		result.put("status", "0");
		if(message != null && message.getTid() != null){
			String idArrs[] = message.getTid().split("[,]");
			boolean checkResult = true;
			if(checkResult == true){
				try{
					int rows = mailService.delete(idArrs);
					result.put("status", "1");
				}catch(Exception e){
					e.printStackTrace();
					result.put("message", e.getMessage());
				}
			}else{
				result.put("status", "2");
				result.put("message", "已经存在相关联的数据，请先删除");
			}
		}else{
			result.put("message","错误参数");
		}
		
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	

	public String toSend() {
		return "toSend";
	}
	
	
	public String toSendSms() {
		return "toSendSms";
	}
	
	
	public String toSendSystemMsg() {
		return "toSendSystemMsg";
	}

	public TCommonSubkeysService getService() {
		return service;
	}

	@Autowired
	public void setService(TCommonSubkeysService service) {
		this.service = service;
	}

	public TCommonMessagesService getMailService() {
		return mailService;
	}

	@Autowired
	public void setMailService(TCommonMessagesService mailService) {
		this.mailService = mailService;
	}

	public TCommonSubkeys getBean() {
		return bean;
	}

	public void setBean(TCommonSubkeys bean) {
		this.bean = bean;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getReceivers() {
		return receivers;
	}

	public void setReceivers(String receivers) {
		this.receivers = receivers;
	}
}
