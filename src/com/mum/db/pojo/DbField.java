package com.mum.db.pojo;

import java.util.Map;

import com.mum.db.function.FunctionEnum;

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
	 * 是否是操作字段。true：是；false：不是
	 */
	private boolean isOperation;
	
	/**
	 * 条件值
	 */
	private String conditionValue;
	
	/**
	 * 外键集合，key是表名
	 */
	private Map<String, DbField> foreignFields;
	
	/**
	 * 函数
	 */
	private FunctionEnum functionEnum;
	
	/**
	 * 传值
	 * @param name {@link #name}
	 */
	public DbField(String name) {
		this.name = name;
	}
	
	/**
	 * 传值
	 * @param name {@link #name}
	 * @param value {@link #value}
	 */
	public DbField(String name, String value) {
		this(name);
		this.value = value;
	}
	
	/**
	 * 传值
	 * @param name {@link #name}
	 * @param value {@link #value}
	 * @param isOperation {@link #isOperation}
	 */
	public DbField(String name, String value, boolean isOperation) {
		this(name, value);
		this.isOperation = isOperation;
	}
	
	/**
	 * 传值
	 * @param name {@link #name}
	 * @param value {@link #value}
	 * @param conditionValue {@link #conditionValue}
	 */
	public DbField(String name, String value, String conditionValue) {
		this(name, value);
		this.conditionValue = conditionValue;
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
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setType(String type) {
		this.type = type;
		return this;
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
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setCollation(String collation) {
		this.collation = collation;
		return this;
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
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setNull_(String null_) {
		this.null_ = null_;
		return this;
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
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setKey(String key) {
		this.key = key;
		return this;
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
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setDefault_(String default_) {
		this.default_ = default_;
		return this;
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
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setExtra(String extra) {
		this.extra = extra;
		return this;
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
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setPrivileges(String privileges) {
		this.privileges = privileges;
		return this;
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
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setComment(String comment) {
		this.comment = comment;
		return this;
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
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setValue(String value) {
		this.value = value;
		return this;
	}

	/**
	 * 获得{@link #isOperation}
	 * @return {@link #isOperation}
	 */
	public boolean isOperation() {
		return isOperation;
	}

	/**
	 * 设置{@link #isOperation}
	 * @param isOperation {@link #isOperation}
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setOperation(boolean isOperation) {
		this.isOperation = isOperation;
		return this;
	}

	/**
	 * 获得{@link #conditionValue}
	 * @return {@link #conditionValue}
	 */
	public String getConditionValue() {
		return conditionValue;
	}

	/**
	 * 设置{@link #conditionValue}
	 * @param conditionValue {@link #conditionValue}
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
		return this;
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
	 * @return this{@link com.mum.db.pojo.DbField}对象
	 */
	public DbField setForeignFields(Map<String, DbField> foreignFields) {
		this.foreignFields = foreignFields;
		return this;
	}

	/**
	 * 获得{@link #functionEnum}
	 * @return {@link #functionEnum}
	 */
	public FunctionEnum getFunctionEnum() {
		return functionEnum;
	}

	/**
	 * 设置{@link #functionEnum}
	 * @param functionEnum {@link #functionEnum}
	 */
	public void setFunctionEnum(FunctionEnum functionEnum) {
		this.functionEnum = functionEnum;
	}
}