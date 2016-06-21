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
	 */
	public void setName(String name) {
		this.name = name;
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
	 */
	public void setDbFields(Map<String, DbField> dbFields) {
		this.dbFields = dbFields;
	}
}