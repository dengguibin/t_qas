package com.deceen.kettle.model;

import java.io.Serializable;

public class DatabaseMetaParameter implements Serializable {
	
	private static final long serialVersionUID = 3024290957201428816L;
	/**
	 * 共享连接名称   唯一
	 */
	private String name;
	/**
	 * 数据库类型  比如 "MySQL"
	 */
	private String type;
	/**
	 * 访问方式 比如"JDBC"
	 */
	private String access;
	/**
	 * 主机
	 */
	private String host;
	/**
	 * 数据库名称
	 */
	private String db;
	/**
	 * 端口
	 */
	private String port;
	/**
	 * 用户名
	 */
	private String user;
	/**
	 * 密码
	 */
	private String pass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
