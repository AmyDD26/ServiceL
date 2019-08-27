package net.DianC.dp.shiro.entity;

import java.io.Serializable;

/**
 * Hbase环境监控该服务器上的Region信息
 * @author zhangk
 *
 */
public class SysHbaseMoniRegInfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * 服务器名
	 */
	private String ServerName;
	/*
	 * region
	 */
	private String Region;
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
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getFileSize() {
		return FileSize;
	}
	public void setFileSize(String fileSize) {
		FileSize = fileSize;
	}
		
}
