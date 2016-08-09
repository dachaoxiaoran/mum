package com.mum.db.pojo;

/**
 * 数据库表字段
 * @author 王超
 */
public abstract class DbField {

	/**
	 * 字段名
	 */
	private String name;
	
	/**
	 * 传值
	 * @param name {@link #name}
	 */
	public DbField(String name) {
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
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setName(String name) {
		this.name = name;
		return this;
	}
}