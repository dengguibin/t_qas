package com.upath.plat.common.exception;

public class WorkflowException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8881997702414207332L;

	public WorkflowException() {
		super();
	}

	public WorkflowException(String msg) {
		super(msg);
	}

	public WorkflowException(String message, Throwable cause) {
		super(message, cause);
	}

	public WorkflowException(Throwable cause) {
		super(cause);
	}
}
