package com.mum.db.init;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * 数据库连接
 * @author 王超
 */
public class Conn {
	
	/**
	 *  com.mysql.jdbc.Statement
	 */
	private Statement statement;
	
	/**
	 * 初始化{@link #connection}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Conn() throws ClassNotFoundException, SQLException {
		DbInfoInjector dbInfoInjector = new DbInfoInjector();
		Class.forName(dbInfoInjector.getDbInfo().getDriver());
		Connection connection = (Connection) DriverManager.getConnection(dbInfoInjector.getDbInfo().getUrl(), dbInfoInjector.getDbInfo().getUser(), dbInfoInjector.getDbInfo().getPwd());
		connection.setAutoCommit(false);
		statement = (Statement) connection.createStatement();
	}

	/**
	 * 获得{@link #statement}
	 * @return {@link #statement}
	 */
	public Statement getStatement() {
		return statement;
	}
}
