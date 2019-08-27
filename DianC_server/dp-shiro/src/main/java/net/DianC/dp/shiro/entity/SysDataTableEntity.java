package net.DianC.dp.shiro.entity;

import java.io.Serializable;

public class SysDataTableEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * 数据表id
	 */
	private Integer id;
	
	/*
	 * 数据表名称
	 */
	private String name;
	
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

}
