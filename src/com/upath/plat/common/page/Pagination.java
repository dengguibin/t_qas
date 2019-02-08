package com.upath.plat.common.page;

public class Pagination implements IPagination ,ICount{
	
	/**
	 * 返回系统默认分页器
	 */
	Ipage page;
	
	int rows;
	
	public Pagination(){
		/*初始化的时候不再进行对分页信息初始化，交给*/
	}
	
	public Ipage getPage() {
		return  page;
	}
	
	public void setPage(Ipage page){
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

}
