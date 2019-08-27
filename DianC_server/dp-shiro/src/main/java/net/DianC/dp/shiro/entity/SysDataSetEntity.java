package net.DianC.dp.shiro.entity;

import java.io.Serializable;

/**
 * 数据集
 * @author niulijie
 *
 */
public class SysDataSetEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 数据集id
	 */
	private Integer id;
	/*
	 * 数据集英文名称
	 */
	private String dbName;
	
	/*
	 * 数据集中文名称
	 */
	private String chName;
	
	/*
	 * 数据集描述
	 */
	private String description;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
