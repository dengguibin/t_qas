package com.deceen.kettle.model;

public class DatabaseRepositoryInfo {
	
	/**
	 * 登录资源库的用户名密码信息不可为空
	 */
	private ConnectParameter connectParameter;
	
	/**
	 * 资源库id，名称等不可为空
	 */
	private RepositoryParameter repositoryParameter;
	
	/**
	 * 资源库地址等信息  不可为空
	 */
	private DatabaseMetaParameter databaseMetaParameter;

	public ConnectParameter getConnectParameter() {
		return connectParameter;
	}

	public void setConnectParameter(ConnectParameter connectParameter) {
		this.connectParameter = connectParameter;
	}

	public RepositoryParameter getRepositoryParameter() {
		return repositoryParameter;
	}

	public void setRepositoryParameter(RepositoryParameter repositoryParameter) {
		this.repositoryParameter = repositoryParameter;
	}

	public DatabaseMetaParameter getDatabaseMetaParameter() {
		return databaseMetaParameter;
	}

	public void setDatabaseMetaParameter(DatabaseMetaParameter databaseMetaParameter) {
		this.databaseMetaParameter = databaseMetaParameter;
	}

}
