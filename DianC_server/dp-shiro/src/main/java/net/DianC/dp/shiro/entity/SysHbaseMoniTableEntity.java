package net.DianC.dp.shiro.entity;

import java.io.Serializable;

/**
 * Hbase环境监控表信息
 * @author zhangk
 *
 */
public class SysHbaseMoniTableEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * 表名
	 */
	private String TableName;
	/*
	 * 在线region数
	 */
	private String OnlineRegionNum;
	
	public String getTableName() {
		return TableName;
	}
	public void setTableName(String tableName) {
		TableName = tableName;
	}
	public String getOnlineRegionNum() {
		return OnlineRegionNum;
	}
	public void setOnlineRegionNum(String onlineRegionNum) {
		OnlineRegionNum = onlineRegionNum;
	}

}
