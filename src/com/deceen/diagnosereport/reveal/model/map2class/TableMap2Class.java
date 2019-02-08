package com.deceen.diagnosereport.reveal.model.map2class;

import java.io.Serializable;
import java.util.List;

/**
 * 项目详情里的表格数据封装类
 */

public class TableMap2Class implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List<String> theadList;//表格第一栏时间,eg:2017年08月     2017年09月	2017年10月     2017年11月
	
	private  List<String>  ytdList;//诊断结果为"是"的时候的图标样式    <i class='icon-small qualified'></i>
	
	private  List<String>  ntdList;//诊断结果为"否"的时候的图标样式    <i class='icon-small unqualified'></i>

	private  String  thead;//表格第一栏时间,eg:2017年08月     2017年09月	2017年10月     2017年11月
	
	private   int   ytd;//诊断结果为"是"
	
	private   int   ntd;//诊断结果为"否"
	
	
	public List<String> getTheadList() {
		return theadList;
	}

	public void setTheadList(List<String> theadList) {
		this.theadList = theadList;
	}

	public List<String> getYtdList() {
		return ytdList;
	}

	public void setYtdList(List<String> ytdList) {
		this.ytdList = ytdList;
	}

	public List<String> getNtdList() {
		return ntdList;
	}

	public void setNtdList(List<String> ntdList) {
		this.ntdList = ntdList;
	}

	public TableMap2Class() {
		super();
	}

	public TableMap2Class(List<String> theadList, List<String> ytdList,
			List<String> ntdList) {
		super();
		this.theadList = theadList;
		this.ytdList = ytdList;
		this.ntdList = ntdList;
	}

	public String getThead() {
		return thead;
	}

	public void setThead(String thead) {
		this.thead = thead;
	}

	public int getYtd() {
		return ytd;
	}

	public void setYtd(int ytd) {
		this.ytd = ytd;
	}

	public int getNtd() {
		return ntd;
	}

	public void setNtd(int ntd) {
		this.ntd = ntd;
	}


	
	
	
}
