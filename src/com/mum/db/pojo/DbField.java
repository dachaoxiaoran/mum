package com.mum.db.pojo;

import java.util.Map;

/**
 * 数据库表字段
 * @author 王超
 */
public class DbField {

	/**
	 * 字段名
	 */
	private String name;
	
	/**
	 * 字段类型
	 */
	private String type;
	
	/**
	 * 编码
	 */
	private String collation;
	
	/**
	 * 是否允许为空
	 */
	private String null_;
	
	/**
	 * 键
	 */
	private String key;
	
	/**
	 * 默认值
	 */
	private String default_;
	
	/**
	 * 额外信息
	 */
	private String extra;
	
	/**
	 * 权限
	 */
	private String privileges;
	
	/**
	 * 字段注释
	 */
	private String comment;
	
	/**
	 * 字段值
	 */
	private String value;
	
	/**
	 * 外键集合，key是表名
	 */
	private Map<String, DbField> foreignFields;

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
	 * 获得{@link #type}
	 * @return {@link #type}
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置{@link #type}
	 * @param type {@link #type}
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获得{@link #collation}
	 * @return {@link #collation}
	 */
	public String getCollation() {
		return collation;
	}

	/**
	 * 设置{@link #collation}
	 * @param collation {@link #collation}
	 */
	public void setCollation(String collation) {
		this.collation = collation;
	}

	/**
	 * 获得{@link #null_}
	 * @return {@link #null_}
	 */
	public String getNull_() {
		return null_;
	}

	/**
	 * 设置{@link #null_}
	 * @param null_ {@link #null_}
	 */
	public void setNull_(String null_) {
		this.null_ = null_;
	}

	/**
	 * 获得{@link #key}
	 * @return {@link #key}
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 设置{@link #key}
	 * @param key {@link #key}
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 获得{@link #default_}
	 * @return {@link #default_}
	 */
	public String getDefault_() {
		return default_;
	}

	/**
	 * 设置{@link #default_}
	 * @param default_ {@link #default_}
	 */
	public void setDefault_(String default_) {
		this.default_ = default_;
	}

	/**
	 * 获得{@link #extra}
	 * @return {@link #extra}
	 */
	public String getExtra() {
		return extra;
	}

	/**
	 * 设置{@link #extra}
	 * @param extra {@link #extra}
	 */
	public void setExtra(String extra) {
		this.extra = extra;
	}

	/**
	 * 获得{@link #privileges}
	 * @return {@link #privileges}
	 */
	public String getPrivileges() {
		return privileges;
	}

	/**
	 * 设置{@link #privileges}
	 * @param privileges {@link #privileges}
	 */
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	/**
	 * 获得{@link #comment}
	 * @return {@link #comment}
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 设置{@link #comment}
	 * @param comment {@link #comment}
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * 获得{@link #value}
	 * @return {@link #value}
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 设置{@link #value}
	 * @param value {@link #value}
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 获得{@link #foreignFields}
	 * @return {@link #foreignFields}
	 */
	public Map<String, DbField> getForeignFields() {
		return foreignFields;
	}

	/**
	 * 设置{@link #foreignFields}
	 * @param foreignFields {@link #foreignFields}
	 */
	public void setForeignFields(Map<String, DbField> foreignFields) {
		this.foreignFields = foreignFields;
	}
}