package com.mum.db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mum.db.pojo.DbInfo;
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
	 * @param dbInfo {@link com.mum.db.pojo.DbInfo}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Conn(DbInfo dbInfo) throws ClassNotFoundException, SQLException {
		Class.forName(dbInfo.getDriver());
		connection = (Connection) DriverManager.getConnection(dbInfo.getUrl(), dbInfo.getUser(), dbInfo.getPwd());
	}

	/**
	 * 获得{@link #connection}
	 * @return {@link #connection}
	 */
	public Connection getConnection() {
		return connection;
	}
	
}
