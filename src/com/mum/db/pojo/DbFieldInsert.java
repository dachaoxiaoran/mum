package com.mum.db.pojo;

/**
 * 数据库表字段，用于插入
 * @author 王超
 *
 */
public class DbFieldInsert extends DbField {

	/**
	 * 字段值
	 */
	private String value;
	
	/**
	 * 传值
	 * @param name 字段名
	 * @param value 字段值
	 */
	public DbFieldInsert(String name, String value) {
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
	 * @return this{@link com.mum.db.pojo.DbFieldInsert}对象
	 */
	public DbFieldInsert setValue(String value) {
		this.value = value;
		return this;
	}
}