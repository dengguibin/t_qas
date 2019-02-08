package com.upath.plat.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.DefaultParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.log4j.Logger;

import com.upath.plat.common.page.Ipage;
import com.upath.plat.common.taglib.PageHandler;

/**
 * Mybatis - 通用分页拦截器
 * @author liuzh/abel533/isea
 * Created by liuzh on 14-4-15.
 */
@SuppressWarnings({"unused" })
@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) })
public class PageHelperPlug implements Interceptor {
   
	private static final Logger logger = Logger.getLogger(PageHelperPlug.class);

    public static final ThreadLocal<Ipage> localPage = new ThreadLocal<Ipage>();

    private String dbType;
    
  
	/**
     * 结束分页并返回结果，该方法必须被调用，否则localPage会一直保存下去，直到下一次startPage
     * @return
     */
    public static Ipage endPage() {
    	Ipage page = localPage.get();
        localPage.remove();
        return page;
    }
    
    public static void startPage(Ipage page) {  
        localPage.set(page);  
    }  

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
    	 final Object[] args = invocation.getArgs();
        if (localPage.get() == null) {
            return invocation.proceed();
        }
        if (invocation.getTarget() instanceof StatementHandler) {
        	 Connection connection = (Connection)invocation.getArgs()[0];
        	 StatementHandler statementHandler = (StatementHandler) invocation.getTarget(); 
             MetaObject metaObject =    MetaObject.forObject(statementHandler);
             Ipage page = localPage.get();
             BoundSql boundSql = statementHandler.getBoundSql();
             String sql = boundSql.getSql();
             String sql_key = "delegate.boundSql.sql";
             PageHandler hander = new PageHandler(dbType, sql, page);
             String countSql = hander.getCountSql();
             Object parameterObject = boundSql.getParameterObject();
             MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");  
             PreparedStatement countStmt = connection.prepareStatement(countSql);    
             DefaultParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);  
             parameterHandler.setParameters(countStmt);  
             ResultSet rs = countStmt.executeQuery();  
             int totpage=0;  
             if (rs.next()) {    
               totpage = rs.getInt(1);    
             }  
             countStmt.close();
             page.setRows(totpage);
             page.init();
             	sql = hander.getListSql();
             	metaObject.setValue(sql_key, sql);
             	Object result = invocation.proceed();
            return invocation.proceed();
        } else if (invocation.getTarget() instanceof ResultSetHandler) {
            Object result = invocation.proceed();
            return result;
        }
        return null;
    }

    /**
     * 只拦截这两种类型的
     * <br>StatementHandler
     * <br>ResultSetHandler
     * @param target
     * @return
     */
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }
    
    
    

    @Override
    public void setProperties(Properties properties) {
    	this.dbType = properties.getProperty("dbType");
    }

   
    public String getDbType() {
  		return dbType;
  	}

  	public void setDbType(String dbType) {
  		this.dbType = dbType;
  	}

}
