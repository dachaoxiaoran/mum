package com.mum.db.init;

import com.mum.db.Conn;
import com.mum.db.pojo.DbField;
import com.mum.db.pojo.DbInfo;
import com.mum.db.pojo.DbTable;
import com.mysql.jdbc.PreparedStatement;

import static com.mum.constant.IConstant.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 将数据库信息存入POJO
 * @author 王超
 */
public class Injection {
	
	/**
	 * @see com.mum.db.Conn
	 */
	private Conn conn;
	
	/**
	 * @see com.mum.db.pojo.DbInfo
	 */
	private DbInfo dbInfo;
	
	/**
	 * 传值
	 * @param conn {@link #conn}
	 * @param dbInfo {@link #dbInfo}
	 */
	public Injection(Conn conn, DbInfo dbInfo) {
		this.conn = conn;
		this.dbInfo = dbInfo;
	}
	
	/**
	 * 将数据库信息注入pojo中
	 */
	public void inject() throws SQLException {
		injectTables();
		injectFields();
		injectForeigns();
	}
	
	/**
	 * 向pojo中注入表信息
	 * @throws SQLException
	 */
	private void injectTables() throws SQLException {
		Map<String, DbTable> dbTables = new HashMap<>();
		dbInfo.setDbTables(dbTables);
		try (PreparedStatement preparedStatement = (PreparedStatement) conn.getConnection().prepareStatement(SHOW_TABLES);
			ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				DbTable dbTable = new DbTable();
				dbTable.setName(resultSet.getString(TABLES_IN_MUM));
				dbTables.put(resultSet.getString(TABLES_IN_MUM), dbTable);
			}
		}
	}
	
	/**
	 * 向pojo中注入表字段信息
	 * @throws SQLException
	 */
	private void injectFields() throws SQLException {
		Iterator<Map.Entry<String, DbTable>> iterator = dbInfo.getDbTables().entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, DbTable> entry = iterator.next();
			String tableName = entry.getKey();
			DbTable dbTable = entry.getValue();
			
			Map<String, DbField> dbFields = new HashMap<>();
			dbTable.setDbFields(dbFields);
			
			try (PreparedStatement preparedStatement = (PreparedStatement) conn.getConnection().prepareStatement(String.format(SHOW_FIELDS, tableName));
				ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					DbField dbField = new DbField();
					dbField.setName(resultSet.getString(FIELD));
					dbField.setType(resultSet.getString(TYPE));
					dbField.setCollation(resultSet.getString(COLLATION));
					dbField.setNull_(resultSet.getString(NULL));
					dbField.setKey(resultSet.getString(KEY));
					dbField.setDefault_(resultSet.getString(DEFAULT));
					dbField.setExtra(resultSet.getString(EXTRA));
					dbField.setPrivileges(resultSet.getString(PRIVILEGES));
					dbField.setComment(resultSet.getString(COMMENT));
					dbField.setForeignFields(new HashMap<>());
					
					dbFields.put(resultSet.getString(FIELD), dbField);
				}
			}
		}
	}
	
	/**
	 * 向pojo中注入表外键信息
	 * @throws SQLException
	 */
	private void injectForeigns() throws SQLException {
		try (PreparedStatement preparedStatement = (PreparedStatement) conn.getConnection().prepareStatement(SHOW_FOREIGNS)) {
			Iterator<Map.Entry<String, DbTable>> iterator = dbInfo.getDbTables().entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, DbTable> entry = iterator.next();
				String tableName = entry.getKey();
				
				preparedStatement.setString(1, tableName);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						String masterTableName = resultSet.getString(MASTER_TABLE_NAME);
						String masterFieldName = resultSet.getString(MASTER_FIELD_NAME);
						String subjectTableName = resultSet.getString(SUBJECT_TABLE_NAME);
						String subjectFieldName = resultSet.getString(SUBJECT_FIELD_NAME);
						
						DbField masterDbField = dbInfo.getDbTables().get(masterTableName).getDbFields().get(masterFieldName);
						DbField subjectDbField = dbInfo.getDbTables().get(subjectTableName).getDbFields().get(subjectFieldName);
						masterDbField.getForeignFields().put(subjectTableName, subjectDbField);
					}
				}
			}
		}
	}
}