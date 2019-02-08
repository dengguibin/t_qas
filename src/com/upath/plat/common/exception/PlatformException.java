package com.upath.plat.common.exception;

public class PlatformException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6242402663624010113L;

	public PlatformException() {
		super();
	}

	public PlatformException(String msg) {
		super(msg);
	}

	public PlatformException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlatformException(Throwable cause) {
		super(cause);
	}
}
