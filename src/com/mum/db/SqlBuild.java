package com.mum.db;

import java.util.Iterator;
import java.util.Map;

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
	 * @see java.lang.StringBuilder
	 */
	private StringBuilder stringBuilder = new StringBuilder();
	
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
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @return 生成的insert语句
	 */
	public StringBuilder insert(DbTable dbTable) {
		stringBuilder.delete(0, stringBuilder.length());
		stringBuilder.append("insert into ");
		stringBuilder.append(dbTable.getName());
		
		String fieldSql = "";
		String valuesSql = "";
		Map<String, DbField> dbFields = dbTable.getDbFields();
		Iterator<Map.Entry<String, DbField>> iterator = dbFields.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, DbField> entry = iterator.next();
			DbField dbField = entry.getValue();
			fieldSql = fieldSql.concat(dbField.getName()).concat(", ");
			valuesSql = valuesSql.concat("'").concat(dbField.getValue()).concat("', ");
		}
		fieldSql = fieldSql.substring(0, fieldSql.length() - 2);
		valuesSql = valuesSql.substring(0, valuesSql.length() - 2);
		
		stringBuilder.append("(");
		stringBuilder.append(fieldSql);
		stringBuilder.append(") values(");
		stringBuilder.append(valuesSql);
		stringBuilder.append(");");
		
		return stringBuilder;
	}
	
	/**
	 * 生成delete语句
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @return 生成的delete语句
	 */
	public StringBuilder delete(DbTable dbTable) {
		stringBuilder.delete(0, stringBuilder.length());
		stringBuilder.append("delete from ");
		stringBuilder.append(dbTable.getName());
		stringBuilder.append(" where ");
		
		Map<String, DbField> dbFields = dbTable.getDbFields();
		Iterator<Map.Entry<String, DbField>> iterator = dbFields.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, DbField> entry = iterator.next();
			DbField dbField = entry.getValue();
			stringBuilder.append(dbField.getName());
			stringBuilder.append(" = '");
			stringBuilder.append(dbField.getValue());
			stringBuilder.append("'");
			if (iterator.hasNext()) {
				stringBuilder.append(" and ");
			}
		}
		return stringBuilder;
	}
	
	/**
	 * 生成update语句，where条件为主键
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @return 生成的update语句
	 */
	public StringBuilder update(DbTable dbTable) {
		stringBuilder.delete(0, stringBuilder.length());
		stringBuilder.append("update ");
		stringBuilder.append(dbTable.getName());
		stringBuilder.append(" set ");
		StringBuilder whereSql = new StringBuilder(" where ");
		
		Map<String, DbField> dbFields = dbTable.getDbFields();
		Iterator<Map.Entry<String, DbField>> iterator = dbFields.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, DbField> entry = iterator.next();
			DbField dbField = entry.getValue();
			if (dbInfo.getDbTables().get(dbTable.getName()).getDbFields().get(dbField.getName()).getKey().equals(PRIMARY_KEY)) {	//主键字段
				whereSql.append(dbField.getName());
				whereSql.append(" = '");
				whereSql.append(dbField.getValue());
				whereSql.append("' and ");
			} else {																												//非主键字段
				stringBuilder.append(dbField.getName());
				stringBuilder.append(" = '");
				stringBuilder.append(dbField.getValue());
				stringBuilder.append("', ");
				
			}
		}
		stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
		whereSql.delete(whereSql.length() - 5, whereSql.length());
		stringBuilder.append(whereSql);
		
		return stringBuilder;
	}
}