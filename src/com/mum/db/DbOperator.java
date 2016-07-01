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
public class DbOperator {
	
	/**
	 * @see com.mum.db.init.Conn
	 */
	private Conn conn;
	
	/**
	 * @see com.mum.db.SqlBuild
	 */
	private SqlBuild sqlBuild;
	
	/**
	 * 初始化{@link #conn}和{@link #sqlBuild}
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public DbOperator() throws ClassNotFoundException, SQLException {
		conn = new Conn();
		sqlBuild = new SqlBuild();
	}

	/**
	 * 数据库增删改操作
	 * @param dbTables {@link com.mum.db.pojo.DbTable}数组
	 * @return 增删改操作的行数
	 * @throws SQLException
	 */
	public int[] modify(DbTable... dbTables) throws SQLException {
		try(Statement statement = (Statement) conn.getConnection().createStatement()) {
			for (DbTable dbTable : dbTables) statement.addBatch(sqlBuild(dbTable));
			int[] res = statement.executeBatch();
			statement.getConnection().commit();
			return res;
		}
	}
	
	/**
	 * 数据库查询操作
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @return 查询得到的数据
	 * @throws SQLException
	 */
	public List<Map<String, String>> select(DbTable dbTable) throws SQLException {
		List<Map<String, String>> selectList = new ArrayList<>();
		try(Statement statement = (Statement) conn.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sqlBuild.select(dbTable).toString())) {
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
			while (resultSet.next()) {
				Map<String, String> selectMap = new HashMap<>();
				for (int i = 0; i <= resultSetMetaData.getColumnCount(); i++) selectMap.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i).toString());
				selectList.add(selectMap);
			}
		}
		return selectList;
	}
	
	/**
	 * 生成sql语句
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @return sql语句
	 */
	private String sqlBuild(DbTable dbTable) {
		if (dbTable.getDbOperateEnum() == DbOperateEnum.INSERT) return sqlBuild.insert(dbTable).toString();			//插入
		else if (dbTable.getDbOperateEnum() == DbOperateEnum.UPDATE) return sqlBuild.update(dbTable).toString();	//更新
		else if (dbTable.getDbOperateEnum() == DbOperateEnum.DELETE) return sqlBuild.delete(dbTable).toString();	//删除
		throw new RuntimeException("dbTable的getDbOperateEnum为null，表名为：".concat(dbTable.getName()));
	}
}
