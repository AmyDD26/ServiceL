package net.DianC.dp.shiro.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 设备组
 * @author niulijie
 *
 */
public class SysEquipmentGroupEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 设备组id
	 */
	private Integer id;
	/*
	 * 用户id
	 */
	private Integer userID;
	/*
	 * 创建用户名
	 */
	private String creater;
	/*
	 * 创建时间
	 */
	private Timestamp publishTime;
	
	/*
	 * 设备组名称
	 */
	private String name;
	
	/*
	 * 设备组描述
	 */
	private String description;
	
	private String registerCode;
	private String protocol;
	private Integer saveTag;
	private Integer dataSetID;
	/*
	 * 数据集名称
	 */
	private String dataSetName;
	private Integer tableID;
	/*
	 * 数据表名称
	 */
	private String dataTableName;
	private Integer dataflowID;
	/*
	 * 数据流名称
	 */
	private String dataFlowName;
	private String msServer;
	private Integer dataWrapperID;
	/*
	 * 封装器名称
	 */
	private String dataWrapperName;
	
	private String orgId;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	public String getRegisterCode() {
		return registerCode;
	}
	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public Integer getSaveTag() {
		return saveTag;
	}
	public void setSaveTag(Integer saveTag) {
		this.saveTag = saveTag;
	}
	public Integer getDataSetID() {
		return dataSetID;
	}
	public void setDataSetID(Integer dataSetID) {
		this.dataSetID = dataSetID;
	}
	public Integer getTableID() {
		return tableID;
	}
	public void setTableID(Integer tableID) {
		this.tableID = tableID;
	}
	public Integer getDataflowID() {
		return dataflowID;
	}
	public void setDataflowID(Integer dataflowID) {
		this.dataflowID = dataflowID;
	}
	public String getMsServer() {
		return msServer;
	}
	public void setMsServer(String msServer) {
		this.msServer = msServer;
	}
	public Integer getDataWrapperID() {
		return dataWrapperID;
	}
	public void setDataWrapperID(Integer dataWrapperID) {
		this.dataWrapperID = dataWrapperID;
	}
	public String getDataSetName() {
		return dataSetName;
	}
	public void setDataSetName(String dataSetName) {
		this.dataSetName = dataSetName;
	}
	public String getDataTableName() {
		return dataTableName;
	}
	public void setDataTableName(String dataTableName) {
		this.dataTableName = dataTableName;
	}
	public String getDataFlowName() {
		return dataFlowName;
	}
	public void setDataFlowName(String dataFlowName) {
		this.dataFlowName = dataFlowName;
	}
	public String getDataWrapperName() {
		return dataWrapperName;
	}
	public void setDataWrapperName(String dataWrapperName) {
		this.dataWrapperName = dataWrapperName;
	}
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	
}
