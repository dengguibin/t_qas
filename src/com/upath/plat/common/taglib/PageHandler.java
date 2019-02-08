package com.upath.plat.common.taglib;

import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.page.Ipage;

public class PageHandler {

	protected String dbType;
	
	protected String sql ;
	
	protected Ipage page;
	
	protected boolean  paged = true;
	
	public PageHandler(String dbType,String sql,Ipage page){
		this.dbType = dbType;
		this.sql = sql;
		this.page = page;
	}
	
	public String getCountSql(){
		/**
		 * 直接使用替换来查询数据的效果
		 */
		if(page.getMode() == 1){
			String sqlTemp = sql.toUpperCase();
			int index = sqlTemp.lastIndexOf("FROM");
			if(index < 0){
				throw new PlatformException(sql+":此SQL无法使用快速模式查询.");
			}
			StringBuffer buffer = new StringBuffer();
			buffer.append(" SELECT COUNT(1) ROWNS ");
			buffer.append(sql.substring(index));
			return buffer.toString();
		}else{
			StringBuffer buffer = new StringBuffer();
			buffer.append(" SELECT COUNT(1) ROWNS FROM ( \r\n");
			buffer.append(sql);
			buffer.append(" ) V_CVIEWS ");
			return buffer.toString();
		}
	
	}
	
	
	public String getListSql(){
			if(paged == false){
				return getSql();
			}
			StringBuffer buffer = new StringBuffer();
			if("MySQL".equalsIgnoreCase(dbType) == true){
				if(page.getMode() == 1){
					buffer.append(sql);
					buffer.append(" LIMIT ");
					buffer.append(page.getRowstart() +","+page.getPageSize());
				}else{
					buffer.append(" SELECT * FROM ( ");
					buffer.append(sql);
					buffer.append(" ) V_PAGE_ALL WHERE 1 = 1  LIMIT ");
					buffer.append(page.getRowstart() +","+page.getPageSize());
				}
			}else{
				buffer.append(" SELECT VV.* FROM (");
				buffer.append(" SELECT V_PAGE_ALL.*,ROWNUM RM FROM (  \r\n");
				buffer.append(sql);
				buffer.append(" ) V_PAGE_ALL  ");
				buffer.append(" ) VV  WHERE  RM >  ");
				buffer.append(page.getRowstart() +" AND RM <= "+page.getRowend());
			}
			return buffer.toString();
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Ipage getPage() {
		return page;
	}

	public void setPage(Ipage page) {
		this.page = page;
	}

	public boolean isPaged() {
		return paged;
	}

	public void setPaged(boolean paged) {
		this.paged = paged;
	}
}
