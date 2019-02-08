package com.upath.plat.common.page;

public interface Ipage {
	
	/**
	 * 数据初始化。数据进行设置后。调用 进行重新高处各值。
	 */
	void init();
	
	boolean isFirst();
	
	boolean isLast();

	/**
	 * 当前分页的页码
	 * 
	 * @return
	 */
	int getCurrent();

	void setCurrent(int current);

	/**
	 * 记录的最大行数
	 * 
	 * @return
	 */
	int getRows();

	void setRows(int rows);

	/**
	 * 记录当前页码的开始行
	 * @return
	 */
	int getRowstart();

	void setRowstart(int rowstart);

	/**
	 * 记录当前页码的结束行位置
	 * @return
	 */
	int getRowend();

	void setRowend(int rowend);

	/**
	 * 页码包含行大小
	 * @return
	 */
	int getPageSize();

	void setPageSize(int pageSize);

	/**
	 * 状态码，在使用标签查询时，需先查询总行数，然后再查询具体的记录数据
	 * @return
	 */
	int getStatus();
	
	/**
	 * 共计多少页
	 * @return
	 */
	int getPages() ;

	void setPages(int pages) ;

	void setStatus(int status);
	/**
	 * 下一页
	 */
	void nextPage();
	
	/**
	 * 上一页
	 */
	void beforePage();
	
	/**
	 * 跳转到指定页
	 * @param page
	 */
	void toPage(int page);
	
	/**
	 * 分页的模式，主要针对MYSQL对子查询的效率问题，如下的子查询在大量数据下面效率会非常差
	 * SELECT COUNT(1) FROM (
	 *  ${SUBQUERY}
	 * ) VIEW 
	 * 最好的效果应该变成
	 * SELECT COUNT(1) FROM TABLE ,所以针对种模式进行转换
	 * 
	 * 
	 * @return
	 */
	int getMode();
	
	void setMode(int mode);

}
