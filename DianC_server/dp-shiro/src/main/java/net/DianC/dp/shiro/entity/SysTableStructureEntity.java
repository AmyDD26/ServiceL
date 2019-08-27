/**
 * 
 */
package net.DianC.dp.shiro.entity;

import java.io.Serializable;

/**
 * @author zhangk
 * 表结构实体
 *
 */
public class SysTableStructureEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private String fieldType;
	
	/**
	 * 
	 */
	private String defaultValue;
	
	/**
	 * 
	 */
	private String chName;
	
	/**
	 * 
	 */
	private Integer tableInfoId;
	
	/**
	 * 
	 */
	private Integer length;
	
	/**
	 * 
	 */
	private Integer isNull;
	
	/**
	 * here add 
	 */
	private String isNullName;
	
	/**
	 * 
	 */
	private Integer isKey;
	
	/**
	 * 
	 */
	public  String isKeyName;
	
	/**
	 * 
	 */
	private Integer isPartitionColumn;
	
	/**
	 * 
	 */
	private Integer columnPosition;
	
	public SysTableStructureEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLength(Integer length) {
		this.length = length;
	}
	
	public Integer getLength() {
		return length;
	}
	
	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public Integer getTableInfoId() {
		return tableInfoId;
	}

	public void setTableInfoId(Integer tableInfoId) {
		this.tableInfoId = tableInfoId;
	}

	public Integer getIsNull() {
		return isNull;
	}

	public void setIsNull(Integer isNull) {
		this.isNull = isNull;
		if(isNull != null){
			if (isNull == 1) {
				this.isNullName = "非空";
			} else {
				this.isNullName = "可空";
			}
		}
	}
	/*
	 * add fangfa
	 */
	public String getIsNullName() {
		return isNullName;
	}
	public void setIsNullName(String isNullName) {
		this.isNullName = isNullName;
	}
	
	public Integer getIsKey() {
		return isKey;
	}

	public void setIsKey(Integer isKey) {
		this.isKey = isKey;
		if (isKey == 1) {
			this.isKeyName = "主键";
		} else {
			this.isKeyName = "非主键";
		}
		
	}
	
	
	public String getIsKeyName() {
		return isKeyName;
	}
	
	public void setIsKeyName(String isKeyName) {
		
		this.isKeyName = isKeyName;
	}
	
	
	public Integer getIsPartitionColumn() {
		return isPartitionColumn;
	}

	public void setIsPartitionColumn(Integer isPartitionColumn) {
		this.isPartitionColumn = isPartitionColumn;
	}

	public Integer getColumnPosition() {
		return columnPosition;
	}

	public void setColumnPosition(Integer columnPosition) {
		this.columnPosition = columnPosition;
	}
	
}
