package net.DianC.dp.shiro.entity;

import java.io.Serializable;

/**
 * 数据集
 * @author zhangk
 *
 */
public class SysHbaseaddrEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * hbsae地址id
	 */
	private Integer id;
	
	/*
	 * hbase地址 
	 */
	private String hbaseAddress;
	
	/*
	 * hbase端口 
	 */
	private String hbasePort;
	
	/*
	 * hbase地址类型 
	 */
	private String hbaseType;
	
	public SysHbaseaddrEntity() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHbaseAddress() {
		return hbaseAddress;
	}
	public void setHbaseAddress(String hbaseAddress) {
		this.hbaseAddress = hbaseAddress;
	}
	public String getHbasePort() {
		return hbasePort;
	}
	public void setHbasePort(String hbasePort) {
		this.hbasePort = hbasePort;
	}

	public String getHbaseType() {
		return hbaseType;
	}

	public void setHbaseType(String hbaseType) {
		this.hbaseType = hbaseType;
	}

}
