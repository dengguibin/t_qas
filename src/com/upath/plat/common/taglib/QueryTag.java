package com.upath.plat.common.taglib;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.sql.DataSource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.ResultSetDynaClass;
import org.apache.log4j.Logger;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;
import org.apache.taglibs.standard.tag.common.sql.ResultImpl;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.cache.ISqlTemplate;
import com.upath.plat.common.cache.SqlTemplateManager;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.page.Ipage;
import com.upath.plat.common.page.Page;
import com.upath.plat.common.util.RequestHelper;
import com.upath.plat.common.util.StringUtil;
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class QueryTag extends ComponentTagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1652928024303290059L;

	private static final Logger logger = Logger.getLogger(QueryTag.class);

	protected String dataSource;

	/* mybatis 的数据库查询描述 */
	protected String stmt;

	protected String pvar = "pdata";
	
	protected boolean asJson = false;
	
	/**
	 * 分页的模式
	 */
	protected int  mode = -1;
	
	/**
	 * 指定的系统绑定在数据下面
	 */
	protected String var;
	


	protected Integer pageSize;
	
	/**
	 * 可以通过外部的SQL来查询出数据的行数
	 * 可以提高一些对性能要求严格的SQL语句
	 */
	protected Integer rows;
	/**
	 * 指定的域名
	 */
	protected String scope = "page";

	protected String placeHolder = "\\{[^\\{]+?\\}";

	protected String dbType;

	/* 使用的sqlSession 来进行数据查询 */
	protected String sqlSession = "sqlSession";
	
	/**
	 * 指定查询是否进行分页
	 */
	protected boolean paged = true; 
	
	/**
	 * 指定的分页系统来进行查询
	 */
	protected Ipage page = null;

	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		QueryBean bean = new QueryBean(stack, req, res);
		ISqlTemplate sqlTemplate = SqlTemplateManager.getInstance().getTemplate(stmt);
		if(sqlTemplate == null){
			throw new PlatformException("无法通过标识符："+stmt+"定位查询模板");
		}
		bean.setISqlTemplate(sqlTemplate);
		return bean;
	}

	public int doEndTag() throws JspException {
		StringWriter writer = new StringWriter();
		component.end(writer, getBody());
		Pattern pattern = Pattern.compile(placeHolder);
		String sql = writer.toString();
		Scanner scanner = new Scanner(sql);
		StringBuffer buffer = new StringBuffer();
		/**
		 * 去除掉空白的行
		 */
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				if("".equals(line.trim()) == false){
					buffer.append(line+"\r\n");
				}
			}
			sql = buffer.toString();
		try {
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Matcher matcher = pattern.matcher(sql);
		List params = null;
		Map printMaps = new HashMap();
		while (matcher.find() == true) {
			if (params == null) {
				params = new ArrayList();
			}
			String key = matcher.group();
			String exp = key.replace("{", "").replace("}", "").trim();
			Object value = getStack().findValue(exp);
			if(value instanceof String[]){
				String arr[] = (String[])value;
				if(value != null && arr.length >0){
					value = arr[0];
				}
			}
			
			params.add(value);
			printMaps.put(exp, value);
		}

		if (params != null) {
			// 转换成系统点位符号
			sql = matcher.replaceAll(" ? ");
		}
		ISqlTemplate sqlTemplate = ((QueryBean) component).getISqlTemplate();
		Connection con = null;
		try {
			con = getConnection();
			Ipage page = RequestHelper.getInstance().getCurrentPagination();
			if (page == null) {
				page = new Page();
			}
			//增加设置分页模式,解决MYSQL的分页机制慢的问题，在十成数据以上时问题会非常突出
			if(mode > 0){
				page.setMode(mode);
			}
			
			dbType = con.getMetaData().getDatabaseProductName();
			PageHandler handler = new PageHandler(dbType, sql, page);
			handler.setPaged(paged);
			String userName = "";
			IUser user = RequestHelper.getInstance().getLoginUser();
				if(user != null){
					userName = user.getUserName();
				}
			
			int rows  = 0 ;
			if(paged == true){
				if(this.rows != null){
					//在某些情况下面，用户可能使用自己定义的SQL来查询数据的总行数
					/**
					 * 这样可以更精确的控制查询数据效率的问题
					 */
					rows = this.rows;
				}else{
					rows = queryTotalRows(handler, con, params);
				}
				if(pageSize != null && pageSize != 0){
					page.setPageSize(pageSize);
				}
				page.setRows(rows);
				page.init();
				if(asJson == true){
					JSONObject jobj = JSONObject.fromObject(page);
					bindScopeData(pvar, jobj.toString());
				}else{
					bindScopeData(pvar, page);
				}
				
			}else{
				handler.setPaged(false);
			}
			if(paged == true){
				logger.info("Total Rows : " + rows);
			}
			logger.info("Params : "+printMaps);
			
			logger.info("database : "+dbType+",Operator : "+userName+" List >>:" + sqlTemplate.getId() + " "
					+ sqlTemplate.getName() + ":\r\n " + handler.getListSql());
			
			if (rows > 0 || paged == false) {
				
				
				ResultImpl results = queryList(handler, con, params, sqlTemplate);
				/**
				 * 使用JSON 格式输出对象
				 */
				if(asJson == true){
					JSONArray arr = JSONArray.fromObject(results.getRows());
					bindScopeData(var,arr.toString());
				}else{
					bindScopeData(var,results);
				}
			}else{
			//	logger.info(sql);
			}
		} catch (Exception e) {
			logger.error(sql);
			logger.error("数据库查询失败", e);
			//throw new PlatformException("数据库查询失败",e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		component = null;
		return EVAL_PAGE;
	}

	private Connection getConnection() throws SQLException {
		Connection con = null;
		if (StringUtil.isEmpty(dataSource) == false) {
			try {
				InitialContext ctx = new InitialContext();
				String looks = null;
					if(dataSource.startsWith("java:comp/env")){
						looks = dataSource;
					}else{
						looks = "java:/comp/env/"+dataSource;
					}
				DataSource source = (DataSource) ctx.lookup(looks);
				con = source.getConnection();
			} catch (NamingException e) {
				throw new PlatformException("指定的上下文中无法查找到对应的数据源", e);
			}
		} else {
			WebApplicationContext wctx = WebApplicationContextUtils
					.getRequiredWebApplicationContext(this.pageContext
							.getServletContext());
			SqlSessionTemplate sqlManager = (SqlSessionTemplate) wctx
					.getBean(sqlSession);
			con = sqlManager.getConfiguration().getEnvironment()
					.getDataSource().getConnection();
		}
		return con;
	}

	private int queryTotalRows(PageHandler handler, Connection con, List params)
			throws SQLException {
		int result = -1;
		PreparedStatement ps = null;
		try {
			String sql = handler.getCountSql();
			ps = con.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					ps.setObject((i + 1), params.get(i));
				}
			}
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				result = rst.getInt(1);
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
		return result;
	}

	private ResultImpl queryList(PageHandler handler, Connection con,
			List params, ISqlTemplate template) throws SQLException {
		ResultImpl results = null;
		PreparedStatement ps = null;
		try {
			String sql = handler.getListSql();
			ps = con.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					ps.setObject((i + 1), params.get(i));
				}
			}
			ResultSet rst = ps.executeQuery();
			results = new ResultImpl(rst, 0, -1);
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
		return results;
	}
	
	
	private List queryListObjects(PageHandler handler, Connection con,
			List params, ISqlTemplate template) throws SQLException, InstantiationException, 
			IllegalAccessException, InvocationTargetException{
			List datas = new ArrayList();
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(handler.getListSql());
				if (params != null) {
					for (int i = 0; i < params.size(); i++) {
						ps.setObject((i + 1), params.get(i));
					}
				}
				ResultSet rst = ps.executeQuery();
				ResultSetDynaClass rsdc = new ResultSetDynaClass(rst);
				Iterator iter = rsdc.iterator();
					while(iter.hasNext() == true){
						DynaBean bean = (DynaBean)iter.next();
						Object obj = template.getResultClass().newInstance();
						BeanUtils.copyProperties(obj, bean);
						datas.add(obj);
					}
			} finally {
				if (ps != null) {
					ps.close();
				}
			}
			return datas;
		
	}

	
	/**
	 * 绑定数据值到当前的scope 上下文范围当中
	 * @param variable
	 * @param datas
	 */
   protected void bindScopeData(String variable,Object datas){
		if(BaseTage.pageScope.contains(scope) == true){
			this.pageContext.setAttribute(variable, datas);
		}else if(BaseTage.requestScope.contains(scope) == true){
			this.pageContext.getRequest().setAttribute(variable, datas);
		}else if(BaseTage.sessionScope.contains(scope) == true){
			this.pageContext.getSession().setAttribute(variable, datas);
		}else if(BaseTage.applicationScope.contains(scope) == true) {
			this.pageContext.getServletContext().setAttribute(variable, datas);
		}else{
			ActionContext.getContext().put(variable, datas);
		}
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getStmt() {
		return stmt;
	}

	public void setStmt(String stmt) {
		this.stmt = stmt;
	}

	public String getPvar() {
		return pvar;
	}

	public void setPvar(String pvar) {
		this.pvar = pvar;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getPlaceHolder() {
		return placeHolder;
	}

	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}

	public String getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(String sqlSession) {
		this.sqlSession = sqlSession;
	}

	public boolean isPaged() {
		return paged;
	}

	public void setPaged(boolean paged) {
		this.paged = paged;
	}

	public Ipage getPage() {
		return page;
	}

	public void setPage(Ipage page) {
		this.page = page;
	}

	public boolean isAsJson() {
		return asJson;
	}

	public void setAsJson(boolean asJson) {
		this.asJson = asJson;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
}
