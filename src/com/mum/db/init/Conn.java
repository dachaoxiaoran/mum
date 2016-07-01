package com.mum.db.init;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * 数据库连接
 * @author 王超
 */
public class Conn {
	
	/**
	 * @see com.mysql.jdbc.Connection
	 */
	private Connection connection;
	
	/**
	 * 初始化{@link #connection}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Conn() throws ClassNotFoundException, SQLException {
		DbInfoInjector dbInfoInjector = new DbInfoInjector();
		Class.forName(dbInfoInjector.getDbInfo().getDriver());
		connection = (Connection) DriverManager.getConnection(dbInfoInjector.getDbInfo().getUrl(), dbInfoInjector.getDbInfo().getUser(), dbInfoInjector.getDbInfo().getPwd());
		connection.setAutoCommit(false);
	}

	/**
	 * 获得{@link #connection}
	 * @return {@link #connection}
	 */
	public Connection getConnection() {
		return connection;
	}
	
}
