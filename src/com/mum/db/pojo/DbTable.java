package com.mum.db.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
	 * 传值
	 * @param name {@link #name}
	 */
	public DbTable(String name) {
		this.name = name;
	}

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
	
	/**
	 * 为{@link #dbFields}添加元素
	 * @param dbField {@link com.mum.db.pojo.DbField}
	 * @return this{@link com.mum.db.pojo.DbTable}对象
	 */
	public DbTable putField(DbField dbField) {
		if (Objects.isNull(this.dbFields)) {		//初始化dbFields
			this.dbFields = new HashMap<>();
		}
		this.dbFields.put(dbField.getName(), dbField);
		return this;
	}
}