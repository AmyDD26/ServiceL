package net.DianC.dp.shiro.entity;

import java.io.Serializable;


public class SysDbinfoncEntity implements Serializable{
	
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
	private String name;
	
	/*
	 * 数据量
	 */
	private Integer count;
	
	/*
	 * 接收开关
	 */
	private String isRecevie;
	
	/*
	 * 状态值
	 */
	private Integer status;
	
	private String statusName;
	
	/*
	 * tableInfoID
	 */
	private Integer tableInfoID;

	
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getIsRecevie() {
		return isRecevie;
	}
	public void setIsRecevie(String isRecevie) {
		this.isRecevie = isRecevie;
	}
	public Integer getTableInfoID() {
		return tableInfoID;
	}
	public void setTableInfoID(Integer tableInfoID) {
		this.tableInfoID = tableInfoID;
	}
	//添加 status函数
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
		
		if (status == 1) {
			this.statusName = "缺主键";
		} else {
			this.statusName = "正常";
		}
		
	}
	
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	
}

