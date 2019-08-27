package net.DianC.dp.shiro.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 表
 * @author niulijie
 *
 */
public class SysTableinfoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 表id
	 */
	private Integer id;
	
	/*
	 * 表名 
	 */
	private String name;
	/*
	 * 时间
	 */
	private Timestamp publishTime;
	/*
	 * 中文名称
	 */
	private String chName;
	/*
	 * 描述
	 */
	private String description;
	/*
	 * 
	 */
	private Boolean hasPartition;
	/*
	 * 
	 */
	private String storedataType;
	/*
	 * 
	 */
	private String keyword;
	/*
	 * 
	 */
	private Integer dbID;//
	/*
	 * 
	 */
	private String topic;
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
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp timestamp) {
		this.publishTime = timestamp;
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
	public Boolean getHasPartition() {
		return hasPartition;
	}
	public void setHasPartition(Boolean hasPartition) {
		this.hasPartition = hasPartition;
	}
	public String getStoredataType() {
		return storedataType;
	}
	public void setStoredataType(String storedataType) {
		this.storedataType = storedataType;
	}
/*	public Integer getDatasetTypeID() {
		return datasetTypeID;
	}
	public void setDatasetTypeID(Integer datasetTypeID) {
		this.datasetTypeID = datasetTypeID;
	}*/
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Integer getDbID() {
		return dbID;
	}
	public void setDbID(Integer dbID) {
		this.dbID = dbID;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	
}
