/**
 * 
 */
package net.DianC.dp.shiro.entity;

import java.io.Serializable;

/**
 * @author zhangk
 *
 */
public class SysIndexInfoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * id
	 */
	private Integer id;
	/*
	 * 名称 
	 */
	private String name;	
	/*
	 * 列名称 
	 */
	private String columName;
	/*
	 * 类型 
	 */
	private String type;
	/*
	 * tableinfoid
	 */
	private Integer tableInfoId;
	/*
	 * dbinfoid
	 */
	private Integer dbInfoId;
	/*
	 * 表名称 
	 */
	private String tableName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColumName() {
		return columName;
	}
	public void setColumName(String columName) {
		this.columName = columName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getTableInfoId() {
		return tableInfoId;
	}
	public void setTableInfoId(Integer tableInfoId) {
		this.tableInfoId = tableInfoId;
	}
	public Integer getDbInfoId() {
		return dbInfoId;
	}
	public void setDbInfoId(Integer dbInfoId) {
		this.dbInfoId = dbInfoId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
