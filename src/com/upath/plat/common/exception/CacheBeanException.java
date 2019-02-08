package com.upath.plat.common.exception;

import org.springframework.beans.BeansException;

@SuppressWarnings("serial")
public class CacheBeanException extends BeansException {

	public CacheBeanException(String msg) {
		super(msg);
	}
	
	public CacheBeanException(String msg,Throwable throwable) {
		super(msg,throwable);
	}

}
