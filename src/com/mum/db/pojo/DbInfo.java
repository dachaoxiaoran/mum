package com.mum.db.pojo;

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
	 * 获得{@link #driver}
	 * @return {@link #driver}
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * 设置{@link #driver}
	 * @param driver {@link #driver}
	 * @return this{@link com.mum.db.pojo.DbInfo}对象
	 */
	public DbInfo setDriver(String driver) {
		this.driver = driver;
		return this;
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
	 * @return this{@link com.mum.db.pojo.DbInfo}对象
	 */
	public DbInfo setUrl(String url) {
		this.url = url;
		return this;
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
	 * @return this{@link com.mum.db.pojo.DbInfo}对象
	 */
	public DbInfo setUser(String user) {
		this.user = user;
		return this;
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
	 * @return this{@link com.mum.db.pojo.DbInfo}对象
	 */
	public DbInfo setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}
}