package com.mum.db.pojo;

import java.util.Map;

/**
 * 数据库表
 * @author 王超
 */
public class DbTable {

	/**
	 * 表名
	 */
	private String name;
	
	/**
	 * 表字段集合，key是字段名
	 */
	private Map<String, DbField> dbFields;

	/**
	 * 获得{@link #name}
	 * @return {@link #name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置{@link #name}
	 * @param name {@link #name}
	 * @return this{@link com.mum.db.pojo.DbTable}对象
	 */
	public DbTable setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 获得{@link #dbFields}
	 * @return {@link #dbFields}
	 */
	public Map<String, DbField> getDbFields() {
		return dbFields;
	}

	/**
	 * 设置{@link #dbFields}
	 * @param dbFields {@link #dbFields}
	 * @return this{@link com.mum.db.pojo.DbTable}对象
	 */
	public DbTable setDbFields(Map<String, DbField> dbFields) {
		this.dbFields = dbFields;
		return this;
	}
}