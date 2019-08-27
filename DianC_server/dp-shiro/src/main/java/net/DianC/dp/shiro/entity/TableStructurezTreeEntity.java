package net.DianC.dp.shiro.entity;

import java.io.Serializable;
import java.util.List;

public class TableStructurezTreeEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * tableInfoID
	 */
	private Integer id;
	/*
	 * dbinfoid
	 */
	private Integer dbID;
	
	/*
	 * 数据表名称
	 */
	private String name;
	
	/**
	 * ztree属性
	 */
	private Boolean open;
	
	private List<?> list;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDbID() {
		return dbID;
	}
	public void setDbID(Integer dbID) {
		this.dbID = dbID;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	



}
