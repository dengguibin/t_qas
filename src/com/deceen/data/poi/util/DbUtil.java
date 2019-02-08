package com.deceen.data.poi.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public enum DbUtil {

	/**
	 * 定义一个枚举的元素，它代表此类的一个实例
	 */
	instance;

	/**
	 * @param 连接mysql数据库
	 */
	private Connection connection = null;

	static {
		try {
			Class.forName(Config.MYSQL_DRIVER);
			instance.connection = (Connection) DriverManager.getConnection(
					Config.MYSQL_URL, Config.MYSQL_USERNAME, Config.MYSQL_PASSWORD);
			instance.connection.setAutoCommit(false);// 关闭自动提交
			System.out.println("连接数据库成功：" + instance.connection);
		} catch (Exception e) {
			System.out.println("数据库连接异常...");
			e.printStackTrace();
		}
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return instance.connection;
	}

	/**
	 * 获取连接操作
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Statement getConnectionStatement() throws SQLException {
		return instance.connection.createStatement();
	}

	/**
	 * 提交，有异常回滚！
	 */
	public void commit() {
		try {
			if (instance.connection != null) {
				instance.connection.commit();
			}
		} catch (SQLException e) {
			if (instance.connection != null) {
				try {
					instance.connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
//			if (instance.connection != null) {
//				try {
//					instance.connection.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}

}
