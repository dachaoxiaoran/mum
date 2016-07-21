package com.mum.db;

import java.util.Map;
import java.util.Objects;

import com.mum.db.pojo.DbField;
import com.mum.db.pojo.DbFieldDelete;
import com.mum.db.pojo.DbFieldInsert;
import com.mum.db.pojo.DbFieldSelectCondition;
import com.mum.db.pojo.DbFieldSelectOperation;
import com.mum.db.pojo.DbFieldUpdateCondition;
import com.mum.db.pojo.DbFieldUpdateOperation;
import com.mum.db.pojo.DbTable;

/**
 * 生成sql语句
 * @author 王超
 */
public class SqlBuild {
	
	/**
	 * 生成的sql语句
	 */
	private StringBuilder sqlBuilder;
	
	/**
	 * 生成的where语句
	 */
	private StringBuilder whereBuilder;
	
	/**
	 * 初始化{@link #sqlBuilder}和{@link #whereBuilder}
	 */
	public SqlBuild() {
		sqlBuilder = new StringBuilder();
		whereBuilder = new StringBuilder();
	}
	
	/**
	 * 生成insert语句
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @return 生成的insert语句
	 */
	public StringBuilder insert(DbTable dbTable) {
		clear();
		sqlBuilder.append("insert into ").append(dbTable.getName()).append("(");
		Map<String, DbField> dbFields = dbTable.getDbFields();
		dbFields.forEach((name, dbField) -> {
			sqlBuilder.append(dbField.getName()).append(", ");
			whereBuilder.append("'").append(((DbFieldInsert) dbField).getValue()).append("'").append(", ");
		});
		
		sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length());
		whereBuilder.delete(whereBuilder.length() - 2, whereBuilder.length());
		
		sqlBuilder.append(") values(").append(whereBuilder).append(")");
		
		return sqlBuilder;
	}
	
	/**
	 * 生成delete语句
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @return 生成的delete语句
	 */
	public StringBuilder delete(DbTable dbTable) {
		clear();
		sqlBuilder.append("delete from ").append(dbTable.getName());
		Map<String, DbField> dbFields = dbTable.getDbFields();
		if (Objects.nonNull(dbFields)) dbFields.forEach((name, dbField) -> whereBuilder.append(dbField.getName()).append(" = '").append(((DbFieldDelete) dbField).getValue()).append("'").append(" and "));	//字段集合不为null
			
		if (whereBuilder.length() != 0) {		//存在where条件
			whereBuilder.insert(0, " where ");
			whereBuilder.delete(whereBuilder.length() - 5, whereBuilder.length());
			sqlBuilder.append(whereBuilder);
		}
		
		return sqlBuilder;
	}
	
	/**
	 * 生成update语句，where条件为主键
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @return 生成的update语句
	 */
	public StringBuilder update(DbTable dbTable) {
		clear();
		Map<String, DbField> dbFields = dbTable.getDbFields();
		dbFields.forEach((name, dbField) -> {
			if (dbField instanceof DbFieldUpdateOperation) sqlBuilder.append(dbField.getName()).append(" = '").append(((DbFieldUpdateOperation) dbField).getValue()).append("', ");	//操作字段
			else {													//条件字段
				whereBuilder.append(dbField.getName()).append(" = '");
				whereBuilder.append(((DbFieldUpdateCondition) dbField).getValue());
				whereBuilder.append("' and ");
			}
		});
		if (sqlBuilder.length() != 0) sqlBuilder.insert(0, " set ").insert(0, dbTable.getName()).insert(0, "update ").delete(sqlBuilder.length() - 2, sqlBuilder.length());	//有操作项

		if (whereBuilder.length() != 0) whereBuilder.insert(0, " where ").delete(whereBuilder.length() - 5, whereBuilder.length());		//有条件项

		sqlBuilder.append(whereBuilder);
		
		return sqlBuilder;
	}
	
	/**
	 * 生成select语句
	 * @param dbTable {@link com.mum.db.pojo.DbTable}
	 * @return select语句
	 */
	public StringBuilder select(DbTable dbTable) {
		clear();
		Map<String, DbField> dbFields = dbTable.getDbFields();
		if (Objects.nonNull(dbFields)) {																										//字段集合不为null
			dbFields.forEach((name, dbField) -> {
				if (dbField instanceof DbFieldSelectOperation) sqlBuilder.append(dbField.getName()).append(", ");	//查询字段
				else whereBuilder.append(dbField.getName()).append(" = '").append(((DbFieldSelectCondition) dbField).getValue()).append("' and ");	//查询条件
			});
		}
		if (sqlBuilder.length() == 0) sqlBuilder.append("select * from ").append(dbTable.getName());											//查询全部
		else sqlBuilder.insert(0, "select ").delete(sqlBuilder.length() - 2, sqlBuilder.length()).append(" from ").append(dbTable.getName());	//查询部分字段
			
		if (whereBuilder.length() != 0) {																										//查询条件
			whereBuilder.insert(0, " where ").delete(whereBuilder.length() - 5, whereBuilder.length());
			sqlBuilder.append(whereBuilder);
		}
		return sqlBuilder;
	}
	
	/**
	 * 清空{@link #sqlBuilder}和{@link #whereBuilder}
	 */
	private void clear() {
		sqlBuilder.delete(0, sqlBuilder.length());
		whereBuilder.delete(0, whereBuilder.length());
	}
}