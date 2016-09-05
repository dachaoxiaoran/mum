package com.mum.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mum.db.init.Conn;
import com.mysql.jdbc.ResultSetMetaData;

/**
 * 数据库操作
 * @author 王超
 */
public class DAO {
	
	/**
	 * @see com.mum.db.init.Conn
	 */
	private static Conn conn;
	
	/**
	 * 初始化{@link #conn}和{@link #sqlBuild}
	 */
	static {
		try {
			conn = new Conn();
		} catch (ClassNotFoundException | SQLException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/**
	 * 不允许实例化
	 */
	private DAO() {}

	/**
	 * 数据库增删改操作
	 * @param sqls sql语句数组
	 * @return 增删改操作的行数
	 * @throws SQLException
	 */
	public static int[] modify(String... sqls) throws SQLException {
		for (String sql : sqls) conn.getStatement().addBatch(sql);
		int[] res = conn.getStatement().executeBatch();
		conn.getStatement().getConnection().commit();
		return res;
	}
	
	/**
	 * 数据库查询操作
	 * @param sql sql语句
	 * @return 查询得到的数据
	 * @throws SQLException
	 */
	public static List<Map<String, String>> select(String sql) throws SQLException {
		List<Map<String, String>> selectList = new ArrayList<>();
		try(ResultSet resultSet = conn.getStatement().executeQuery(sql)) {
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
			while (resultSet.next()) {
				Map<String, String> selectMap = new HashMap<>();
				for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
					Object resultSetElm = resultSet.getObject(i);
					selectMap.put(resultSetMetaData.getColumnName(i), resultSetElm == null ? null : resultSetElm.toString());
				}
				selectList.add(selectMap);
			}
		}
		return selectList;
	}
}