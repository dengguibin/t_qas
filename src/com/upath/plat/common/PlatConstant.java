package com.upath.plat.common;

public class PlatConstant {
	/**
	 * 保存当前请分页信息
	 */
	public static final String VAR_PAGINATION = "_PAGINATION";

	public static final String VAR_REQUEST_ACTION_URI = "_REQUEST_URI";
	
	public static final String VAR_REQUEST_ACTION_NAME = "_REQUEST_ACTION_NAME";
	
	public static final String VAR__REQUESTHELPER = "_REQUESTHELPER";

	/**
	 * 保存会话中的用户信息
	 */
	public static final String SESSION_USER = "_SESSION_USER";
	/**
	 * 对于每次请求把当前用户信息放到讲求上下文环境当中进行调用
	 */
	public static final String REQEUST_USER = "user";

	public static final String SESSION_PATCHCA = "_SESSION_PATCHCA";

	public static final String OPEN_DYNACODE = "_OPEN";
	
	
	
	
	// 消息状态
	public enum UserStatus {
		
		STATUS_INIT(1 << 0,"初始密码"),
		STATUS_DISABLE(1 << 1,"禁用"), 
		STATUS_LOCKED(1 << 2,"锁定");
		
		private UserStatus(Integer status,String name) {
			this.status = status;
			this.name = name;
		}
		private int status;
		private String name;
		
		public int getStatus() {
			return status;
		}
		
		public static String getName(int status){
			UserStatus uStatus[] = 	UserStatus.values();
			String name = null;
			for(int j = 0 ; j < uStatus.length ; j++){
				UserStatus st = uStatus[j];
				if((status & st.getStatus()) > 0){
					if(name == null){
						name = st.getName();
					}else{
						name += "/"+st.getName();
					}
				}
			}
			return name;
		}

		public String getName() {
			return name;
		}
		
		
	}
	// 消息状态
	public enum MessageStatus {
		NOT_SEND(0), SEND(1), SEND_FAILED(2);
		private Integer status;

		private MessageStatus(Integer status) {
			this.status = status;
		}

		public int getValue() {
			return status;
		}
	}
	
	// 消息类型
		public enum MessageTypes {
			
			MESSAGE_ALL("MESSAGE_ALL","所有消息"), 
			SMS_ALL("SMS_ALL","所有短信"),
			SMS_UNSEND("SMS_UNSEND","未发送的短信"),
			SMS_SEND("SMS_SEND","已经发送的短信"),
			SMS_FAILED("SMS_FAILED","发送失败的短信"),
			MAIL_ALL("MAIL_ALL","所有邮件"),
			MAIL_UNSEND("MAIL_UNSEND","未发送的邮件"),
			MAIL_SEND("MAIL_SEND","已发送的邮件"),
			MAIL_FAILED("MAIL_FAILED","发送失败的邮件"),
			SYSTEM_ALL("SYSTEM_ALL","所有系统消息"),
			SYSTEM_UNREAD("SYSTEM_UNREAD","未读系统消息"),
			SYSTEM_READ("SYSTEM_READ","已读系统消息");
			
			private String types;
			
			public String getTypes() {
				return types;
			}

			public String getName() {
				return name;
			}

			private String name;

			private MessageTypes(String types,String name) {
				this.types = types;
				this.name = name;
			}

			public String toString(){
				return this.types;
			}
		}

}
