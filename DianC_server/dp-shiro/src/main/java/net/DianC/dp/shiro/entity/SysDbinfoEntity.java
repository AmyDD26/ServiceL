package net.DianC.dp.shiro.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 数据集
 * @author niulijie
 *
 */
public class SysDbinfoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 数据集id
	 */
	private Integer id;
	
	/*
	 * 数据集名称 
	 */
	private String dbName;
	/*
	 * 创建时间
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
	 * 数据集用户名
	 */
	//private String dbUserName;
	/*
	 * 密码
	 */
	//private String dbPassword;
	/*
	 * ip地址
	 */
	//private String dbIP;
	
	
	//private String storedataType;
	
	private Integer datasetTypeID;//
	
	private String datasetTypeName;
	
	private String orgId;
	
	
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
//	public String getPublishTime() {
//		return publishTime;
//	}
//	public void setPublishTime(String publishTime) {
//		this.publishTime = publishTime;
//	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	//public String getStoredataType() {
		//return "感知数据";
	//}
	public Integer getDatasetTypeID() {
		return datasetTypeID;
	}
	public void setDatasetTypeID(Integer datasetTypeID) {
		this.datasetTypeID = datasetTypeID;
		int typeId = this.getDatasetTypeID();
		if (typeId == 1) {
			this.datasetTypeName = "HBase";
		} else {
			this.datasetTypeName = "HDFS";
		}
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	public String getDatasetTypeName() {
		return datasetTypeName;
	}
	public void setDatasetTypeName(String datasetTypeName) {
		this.datasetTypeName = datasetTypeName;
	}
}
