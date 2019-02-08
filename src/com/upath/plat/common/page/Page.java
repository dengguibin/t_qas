package com.upath.plat.common.page;

import org.springframework.web.util.HtmlUtils;

import net.sf.json.JSONObject;

public class Page implements Ipage {

	int current = -1;
	/*默认未查询时所有行数标识为-1*/
	int rows = -1;
	/*系统默认每页显示15行*/
	/**
	 * 政府项目默认显示10条
	 */
	int pageSize = 10;
	/*默认开始时为第一行开始*/
	int rowstart  = 1;
	/*结束行为页面行记录数*/
	int rowend = pageSize;
	/*初始状态*/
	int status = 0;
	/*总共多少页*/
	int pages = 0;
	
	boolean first;
	
	boolean last;
	
	//分页的模式的实现
	int mode = 0;

	
	public Page(){
		
	}
	
	public Page(String json){
			JSONObject obj = 	JSONObject.fromObject(HtmlUtils.htmlUnescape(json));
			this.current = obj.getInt("current");
			this.pageSize = obj.getInt("pageSize");
			obj.clear();
	}
	
	/**
	 * 数据初始化。按照总行数和页码计算对应的关系
	 */
	public void init() {
		if(rows > 0 && pageSize >= 0){
			pages = rows / pageSize;
			int mp = rows % pageSize;
			/*最后一页有数据值*/
				if(mp != 0){
					pages++;
				}
				if(current < 0){
					current = 0;
				}
				/*如果页码记录数已经超过总记录数，current 要重新计算*/
				if(current * pageSize > rows){
					current = pages - 1;
				}
				mp = current * pageSize;
				
				
				rowstart = mp;
				rowend = mp + pageSize;
				
				first = (current == 0);
				last = (current == pages - 1);
			
		}else{
			/*如果是无数据，那么 当前行是第一页，也是最后 一页*/
			this.first = true;
			this.last = true;
		}
		
	}
	
	public boolean isFirst() {
		return first;
	}

	public boolean isLast() {
		return last;
	}
	
	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getRowstart() {
		return rowstart;
	}

	public void setRowstart(int rowstart) {
		this.rowstart = rowstart;
	}

	public int getRowend() {
		return rowend;
	}

	public void setRowend(int rowend) {
		this.rowend = rowend;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}


	public void beforePage() {
		
	}

	public void nextPage() {
		
	}

	public void toPage(int page) {
		
	}

	/**
	 * 以JSON 格式 数据返回到客户端口
	 */
	public String toString() {
		JSONObject obj = JSONObject.fromObject(this);
		return obj.toString();
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

}
