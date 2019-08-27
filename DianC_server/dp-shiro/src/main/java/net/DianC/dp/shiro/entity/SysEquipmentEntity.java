package net.DianC.dp.shiro.entity;

import java.io.Serializable;
import java.sql.Timestamp;




/**
 * 设备
 * @author niulijie
 *
 */
public class SysEquipmentEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 设备id
	 */
	private Integer id;
	/*
	 * 设备名称
	 */
	private String name;
	/*
	 * 设备描述
	 */
	private String description;
	/*
	 * 标识
	 */
	private String tagID;
	
	/*
	 * 设备组id
	 */
	private Integer groupID;
	
	/*
	 * 部署位置
	 */
	private String lat;                             //
	private String lon;                             //
	
	
	/*
	 * 状态
	 */
	private String status;
	
	/*
	 * 接入时间
	 */
	private Timestamp inTime;
	
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

	public String getTagID() {
		return tagID;
	}
	public void setTagID(String tagID) {
		this.tagID = tagID;
	}
	
	public Integer getGroupID() {
		return groupID;
	}
	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}
	
	
	
	public  String getLat() {                     //+","+lon
		return lat;
	}
	public void setLat(String lat) {              //
		this.lat = lat;
	}
	
	public  String getLon() {                     //
		return lon;
	}
	
	public void setLon(String lon) {              //
		this.lon = lon;
	}
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public  Timestamp getInTime() {
		return inTime;
	}
	public void setInTime( Timestamp inTime) {
		this.inTime = inTime;
	}
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	 
}
