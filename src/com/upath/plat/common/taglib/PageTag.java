package com.upath.plat.common.taglib;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.upath.plat.common.dao.IMapper;
import com.upath.plat.common.page.ICount;
import com.upath.plat.common.page.IPagination;
import com.upath.plat.common.page.Ipage;
import com.upath.plat.common.page.Page;

/**
 * @author upaths version 1.0.0 create date :2012-9-22 upath plat call
 *         116856645.com modify time  分页标签使用，如果在ACTION
 *         当中调用查询出数据然后在前台进行展示。在一些大数据进行查询的时候
 *         页面会显得加载很慢。所以考虑在页面层来查询数据。当然这样做会失去一些代码可读性。但是可以提高用户的体验性 在这里考虑通过所有的查询参数在
 *         ACTION中进行初始化后，把查询参数传入页面。然后再通过标签调用 MYBATIS来 进行数据分页袜。
 */
@SuppressWarnings({ "rawtypes", "serial", "unchecked"})
public class PageTag extends BaseTage {

	private static final Logger logger = Logger.getLogger(PageTag.class);
	
	private Object params;

	/* mybatis 的数据库查询描述 */
	private String stmt;

	private String pvar = "pdata";

	/* 为缩小调用者减少输入量，允许用户传入某个mapper ,stmt根据传入的mapper 来自动计算描述 */
	private Class<IMapper> mapperClass;

	/* 使用的sqlSession 来进行数据查询 */
	private String sqlSession = "sqlSession";

	public int doEndTag() throws JspException {
		// spring 的上下文环境
		try{
			WebApplicationContext wctx = null;
			StringBuffer statement = new StringBuffer();
				if(mapperClass != null){
					statement.append(mapperClass.getName()).append(".");
				}
				statement.append(stmt);
				Ipage page = null;
				/*有可能是不需要参数进行查询默认分页信息*/
				if(params == null){
					Map querys = new HashMap();
						querys.put("page", new Page());
						//设置默认使用此参数进行数据查询
						setParams(querys);
				}
				
				if(params instanceof IPagination){
					IPagination pagination = (IPagination)params;
					page = pagination.getPage();
					if(page == null){
						page = new Page();
						pagination.setPage(page);
					}
				}else if(params instanceof Map){
					Map mapQuerys = (Map) params;
						Object temp  = mapQuerys.get("page");
							if(temp != null){
								if(temp instanceof Ipage){
									page = (Ipage)temp;
								}
							}
					if(page == null){
						page = new Page();
						mapQuerys.put("page", page);
					}		
				}
			
				wctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.pageContext.getServletContext());
				SqlSessionTemplate template = (SqlSessionTemplate)wctx.getBean(sqlSession);
				
				if(page != null){
					//默认状况下面 总行数是 -1 ，标识此数据前是未查询总行数，如果进行一下行或者跳转行查询。提高性能，不再
					//继续查询行数
					if(page.getRows() == -1){
						//设置此时需要 查询总行数阙状态
						page.setStatus(0);
						
						Object  rows =	template.selectOne(statement.toString(), params);
						//查询语句设置的返回参数 是 IPagination实例。
						if(rows instanceof ICount){
							ICount count = (ICount)rows;
							page.setRows(count.getRows());
						}else if(rows instanceof Map){
							Map pagination = (Map)rows;
							Object temp = pagination.get("ROWNS");
							page.setRows(Integer.valueOf(temp.toString()));
						}else{
							logger.info("查询分页设置的返回参数不对：必须是 Map或者是IPagination子类。返回实际值:"+rows.getClass().getName());
						}
					}
					//如果查询到有相关数据进行提取详细信息
					page.init();
					List datas = null;
					if(page.getRows() > 0){
						page.setStatus(1);
						datas = template.selectList(statement.toString(), params);
					}else{
						datas = Collections.EMPTY_LIST;
					}
					//数据绑定到request 上下文环境当中
					bindScopeData(var, datas);
					//分页信息绑定 到request 上下文环境当中
					bindScopeData(pvar, page);
				}
		}finally{
			release();
		}
		return SKIP_BODY;
	}

	public String getPvar() {
		return pvar;
	}

	public String getStmt() {
		return stmt;
	}

	public void setStmt(String stmt) {
		this.stmt = stmt;
	}

	public void setPvar(String pvar) {
		this.pvar = pvar;
	}

	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}

	public String getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(String sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public Class<IMapper> getMapperClass() {
		return mapperClass;
	}

	public void setMapperClass(Class<IMapper> mapperClass) {
		this.mapperClass = mapperClass;
	}

	public void release() {
		super.release();
		this.params = null;
		this.mapperClass = null;
	}


}
