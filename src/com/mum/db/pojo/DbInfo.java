package com.mum.db.pojo;

import java.util.Map;

/**
 * 数据库信息
 * @author 王超
 */
public class DbInfo {
	
	/**
	 * 驱动
	 */
	private String driver;
	
	/**
	 * 统一资源定位符
	 */
	private String url;
	
	/**
	 * 用户名
	 */
	private String user;
	
	/**
	 * 密码
	 */
	private String pwd;
	
	/**
	 * 数据库表集合，key是表名
	 */
	private Map<String, DbTable> dbTables;

	/**
	 * 获得{@link #driver}
	 * @return {@link #driver}
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * 设置{@link #driver}
	 * @param driver {@link #driver}
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * 获得{@link #url}
	 * @return {@link #url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置{@link #url}
	 * @param url {@link #url}
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获得{@link #user}
	 * @return {@link #user}
	 */
	public String getUser() {
		return user;
	}

	/**
	 * 设置{@link #user}
	 * @param user {@link #user}
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * 获得{@link #pwd}
	 * @return {@link #pwd}
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * 设置{@link #pwd}
	 * @param pwd {@link #pwd}
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * 获得{@link #dbTables}
	 * @return {@link #dbTables}
	 */
	public Map<String, DbTable> getDbTables() {
		return dbTables;
	}

	/**
	 * 设置{@link #dbTables}
	 * @param dbTables {@link #dbTables}
	 */
	public void setDbTables(Map<String, DbTable> dbTables) {
		this.dbTables = dbTables;
	}
}