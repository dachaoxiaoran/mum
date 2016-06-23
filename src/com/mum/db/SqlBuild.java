package com.mum.db;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import com.mum.db.pojo.DbField;
import com.mum.db.pojo.DbInfo;
import com.mum.db.pojo.DbTable;

import static com.mum.constant.IConstant.*;

/**
 * 生成sql语句
 * @author 王超
 */
public class SqlBuild {
	
	/**
	 * 生成的sql语句
	 */
	private StringBuilder sqlBuilder = new StringBuilder();
	
	/**
	 * 生成的where语句
	 */
	private StringBuilder whereBuilder = new StringBuilder();
	
	/**
	 * @see com.mum.db.pojo.DbInfo
	 */
	private DbInfo dbInfo;
	
	/**
	 * 传值
	 * @param dbInfo {@link #dbInfo}
	 */
	public SqlBuild(DbInfo dbInfo) {
		this.dbInfo = dbInfo;
	}
	
	/**
	 * 生成insert语句
	 * @param dbTables {@link com.mum.db.pojo.DbTable}数组
	 * @return 生成的insert语句
	 */
	public StringBuilder insert(DbTable... dbTables) {
		sqlBuilder.delete(0, sqlBuilder.length());
		whereBuilder.delete(0, whereBuilder.length());
		for (DbTable dbTable : dbTables) {
			sqlBuilder.append("insert into ").append(dbTable.getName()).append("(");
			
			Map<String, DbField> dbFields = dbTable.getDbFields();
			Iterator<Map.Entry<String, DbField>> iterator = dbFields.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, DbField> entry = iterator.next();
				DbField dbField = entry.getValue();
				sqlBuilder.append(dbField.getName());
				whereBuilder.append("'").append(dbField.getValue()).append("'");
				if (iterator.hasNext()) {		//存在下一个要操作的字段
					sqlBuilder.append(", ");
					whereBuilder.append(", ");
				}
			}
			
			sqlBuilder.append(") values(").append(whereBuilder).append(");");
		}
		
		return sqlBuilder;
	}
	
	/**
	 * 生成delete语句
	 * @param dbTables {@link com.mum.db.pojo.DbTable}数组
	 * @return 生成的delete语句
	 */
	public StringBuilder delete(DbTable... dbTables) {
		sqlBuilder.delete(0, sqlBuilder.length());
		whereBuilder.delete(0, whereBuilder.length());
		for (DbTable dbTable : dbTables) {
			sqlBuilder.append("delete from ").append(dbTable.getName());
			
			Map<String, DbField> dbFields = dbTable.getDbFields();
			if (dbFields != null) {					//字段集合不为null
				Iterator<Map.Entry<String, DbField>> iterator = dbFields.entrySet().iterator();
				while (iterator.hasNext()) {
					Map.Entry<String, DbField> entry = iterator.next();
					DbField dbField = entry.getValue();
					whereBuilder.append(dbField.getName()).append(" = '").append(dbField.getValue()).append("'");
					if (iterator.hasNext()) {		//存在下一个要操作的字段
						whereBuilder.append(" and ");
					}
				}
			}
			if (whereBuilder.length() != 0) {		//存在where条件
				whereBuilder.insert(0, " where ");
				sqlBuilder.append(whereBuilder);
			}
			sqlBuilder.append(";");
		}
		
		return sqlBuilder;
	}
	
	/**
	 * 生成update语句，where条件为主键
	 * @param dbTables {@link com.mum.db.pojo.DbTable}数组
	 * @return 生成的update语句
	 */
	public StringBuilder update(DbTable... dbTables) {
		sqlBuilder.delete(0, sqlBuilder.length());
		whereBuilder.delete(0, whereBuilder.length());
		for (DbTable dbTable : dbTables) {
			Map<String, DbField> dbFields = dbTable.getDbFields();
			Iterator<Map.Entry<String, DbField>> iterator = dbFields.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, DbField> entry = iterator.next();
				DbField dbField = entry.getValue();
				if (dbField.isOperation()) {								//操作字段
					sqlBuilder.append(dbField.getName()).append(" = '").append(dbField.getValue()).append("', ");
				}
				if (dbField.isCondition()) {								//条件字段
					whereBuilder.append(dbField.getName()).append(" = '");
					if (Objects.isNull(dbField.getConditionValue())) {		//没有指定条件值
						whereBuilder.append(dbField.getValue());
					} else {												//制定了条件值，适用于字段既是操作项，又是条件项的情况
						whereBuilder.append(dbField.getConditionValue());
					}
					whereBuilder.append("' and ");
				}
				if (sqlBuilder.length() != 0) {								//有操作项
					sqlBuilder.insert(0, " set ").insert(0, dbTable.getName()).insert(0, "update ").delete(sqlBuilder.length() - 2, sqlBuilder.length());
				}
				if (whereBuilder.length() != 0) {							//有条件项
					whereBuilder.insert(0, " where ").delete(whereBuilder.length() - 5, whereBuilder.length());
				}
			}
			sqlBuilder.append(whereBuilder).append(";");
		}
		
		return sqlBuilder;
	}
	
	/**
	 * 生成select语句
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @return select语句
	 */
	public StringBuilder select(DbTable dbTable) {
		sqlBuilder.delete(0, sqlBuilder.length());
		whereBuilder.delete(0, whereBuilder.length());
		Map<String, DbField> dbFields = dbTable.getDbFields();
		if (dbFields != null) {									//字段集合不为null
			Iterator<Map.Entry<String, DbField>> iterator = dbFields.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, DbField> entry = iterator.next();
				DbField dbField = entry.getValue();
				if (Objects.nonNull(dbField.getValue())) {		//字段存在值
					whereBuilder.append(dbField.getName()).append(" = '").append(dbField.getValue()).append("' and ");
				}
				if (dbField.isOperation()) {					//字段是操作项
					sqlBuilder.append(dbField.getName()).append(", ");
				}
			}
		}
		if (sqlBuilder.length() == 0) {							//查询全部
			sqlBuilder.append("select * from ").append(dbTable.getName());
		} else {												//查询部分字段
			sqlBuilder.insert(0, "select ").delete(sqlBuilder.length() - 2, sqlBuilder.length()).append(" from ").append(dbTable.getName());
		}
		if (whereBuilder.length() != 0) {						//查询条件
			whereBuilder.insert(0, " where ").delete(whereBuilder.length() - 5, whereBuilder.length());
			sqlBuilder.append(whereBuilder);
		}
		sqlBuilder.append(";");
		return sqlBuilder;
	}
	
	/**
	 * 判断某个表的某个字段是否是主键。
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @param dbField {@link com.mum.db.pojo.DbField}
	 * @return true：是主键；false：不是主键。
	 */
	private boolean isPrimary(DbTable dbTable, DbField dbField) {
		return dbInfo.getDbTables().get(dbTable.getName()).getDbFields().get(dbField.getName()).getKey().equals(PRIMARY_KEY);
	}
}