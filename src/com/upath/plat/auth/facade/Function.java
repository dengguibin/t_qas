package com.upath.plat.auth.facade;

import java.io.Serializable;

import com.upath.plat.auth.model.TRmsMenufunc;

public class Function extends TRmsMenufunc implements IFunction,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getFuncName() {
		return getName();
	}

	public Integer getMenuId() {
		return getCdid();
	}

}
