package net.DianC.dp.shiro.entity;

import java.io.Serializable;

/**
 * Hbase环境监控Region服务器信息
 * @author zhangk
 *
 */
public class SysHbaseMoniRegServEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * 服务器名
	 */
	private String ServerName;
	/*
	 * 服务器IP
	 */
	//private String ServerIp;
	/*
	 * 服务器状态
	 */
	private String ServerStatus;//需要转换
	/*
	 * region数
	 */
	private String RegionNum;
	/*
	 * JVM内存大小(MB)
	 */
	private String UserHeap;
	/*
	 * 已用JVM内存(MB)
	 */
	private String MaxHeap;
	/*
	 * 存储文件大小(MB)
	 */
	private String FileSize;
	
	public String getServerName() {
		return ServerName;
	}
	public void setServerName(String serverName) {
		ServerName = serverName;
	}
	/*public String getServerIp() {
		return ServerIp;
	}
	public void setServerIp(String serverIp) {
		ServerIp = serverIp;
	}*/
	public String getServerStatus() {
		return ServerStatus;
	}
	public void setServerStatus(String serverStatus) {
		ServerStatus = serverStatus;
	}
	public String getRegionNum() {
		return RegionNum;
	}
	public void setRegionNum(String regionNum) {
		RegionNum = regionNum;
	}
	public String getUserHeap() {
		return UserHeap;
	}
	public void setUserHeap(String userHeap) {
		UserHeap = userHeap;
	}
	public String getMaxHeap() {
		return MaxHeap;
	}
	public void setMaxHeap(String maxHeap) {
		MaxHeap = maxHeap;
	}
	public String getFileSize() {
		return FileSize;
	}
	public void setFileSize(String fileSize) {
		FileSize = fileSize;
	}
	
}
