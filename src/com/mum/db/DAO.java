package com.mum.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mum.db.init.Conn;
import com.mum.db.pojo.DbOperateEnum;
import com.mum.db.pojo.DbTable;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

/**
 * 数据库操作
 * @author 王超
 */
public class DAO {
	
	/**
	 * 类静态对象，唯一
	 */
	private static DAO dao;
	
	/**
	 * @see com.mum.db.init.Conn
	 */
	private static Conn conn;
	
	/**
	 * @see com.mum.db.SqlBuild
	 */
	private static SqlBuild sqlBuild;
	
	/**
	 * {@link com.mum.db.pojo.DbTable}列表
	 */
	private static List<DbTable> dbTables;
	
	/**
	 * 初始化{@link #conn}和{@link #sqlBuild}
	 */
	static {
		try {
			conn = new Conn();
		} catch (ClassNotFoundException | SQLException e) {
			throw new ExceptionInInitializerError(e);
		}
		dao = new DAO();
		sqlBuild = new SqlBuild();
		dbTables = new ArrayList<>();
	}
	
	/**
	 * 不允许实例化
	 */
	private DAO() {}

	/**
	 * 数据库增删改操作
	 * @param dbTables {@link com.mum.db.pojo.DbTable}数组
	 * @return 增删改操作的行数
	 * @throws SQLException
	 */
	public static int[] modify(DbTable... dbTables) throws SQLException {
		try(Statement statement = (Statement) conn.getConnection().createStatement()) {
			for (DbTable dbTable : DAO.dbTables) statement.addBatch(sqlBuild(dbTable));
			for (DbTable dbTable : dbTables) statement.addBatch(sqlBuild(dbTable));
			int[] res = statement.executeBatch();
			statement.getConnection().commit();
			DAO.dbTables.clear();
			return res;
		}
	}
	
	/**
	 * 数据库查询操作
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @return 查询得到的数据
	 * @throws SQLException
	 */
	public static List<Map<String, String>> select(DbTable dbTable) throws SQLException {
		List<Map<String, String>> selectList = new ArrayList<>();
		try(Statement statement = (Statement) conn.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sqlBuild.select(dbTable).toString())) {
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
	
	/**
	 * 为{@link #dbTables}添加元素
	 * @param dbTables {@link com.mum.db.pojo.DbTable}数组
	 * @return this{@link com.mum.db.DAO}的唯一静态对象
	 */
	public static DAO addTables(DbTable... dbTables) {
		for (DbTable dbTable : dbTables) DAO.dbTables.add(dbTable);
		return dao;
	}
	
	/**
	 * 生成sql语句
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @return sql语句
	 */
	private static String sqlBuild(DbTable dbTable) {
		if (dbTable.getDbOperateEnum() == DbOperateEnum.INSERT) return sqlBuild.insert(dbTable).toString();			//插入
		else if (dbTable.getDbOperateEnum() == DbOperateEnum.UPDATE) return sqlBuild.update(dbTable).toString();	//更新
		else if (dbTable.getDbOperateEnum() == DbOperateEnum.DELETE) return sqlBuild.delete(dbTable).toString();	//删除
		throw new RuntimeException("dbTable的getDbOperateEnum为null，表名为：".concat(dbTable.getName()));
	}
}
