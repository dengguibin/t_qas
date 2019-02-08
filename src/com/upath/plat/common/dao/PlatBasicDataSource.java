package com.upath.plat.common.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

/**
 * 黄斌
 * 2015-05-21
 * @author 在服务器关闭的时候
 * 数据库连接和驱动没有及时被关闭，重写数据源的关闭方法
 *
 */
public class PlatBasicDataSource extends BasicDataSource {
	
	private final static Logger logger = Logger.getLogger(PlatBasicDataSource.class);
	
	public synchronized void close() throws SQLException {
		
		logger.info("服务器关闭注销数据库驱动程序");
        DriverManager.deregisterDriver(DriverManager.getDriver(url));
        super.close();
       
    }
}
