package com.mum.db.pojo;

/**
 * 数据库表字段，用于更新，操作字段
 * @author 王超
 *
 */
public class DbFieldUpdateOperation extends DbField {
	
	/**
	 * 字段值
	 */
	private String value;
	
	/**
	 * 传值
	 * @param name 字段名
	 * @param value 字段值
	 */
	public DbFieldUpdateOperation(String name, String value) {
		super(name);
		this.value = value;
	}

	/**
	 * get {@link #value}
	 * @return {@link #value}
	 */
	public String getValue() {
		return value;
	}

	/**
	 * set {@link #value}
	 * @param value {@link #value}
	 * @return this{@link com.mum.db.pojo.DbFieldUpdateOperation}对象
	 */
	public DbFieldUpdateOperation setValue(String value) {
		this.value = value;
		return this;
	}
}
