package net.DianC.dp.shiro.entity;

import java.io.Serializable;

/**
 * 设备
 * @author niulijie
 *
 */
public class SysWrapperEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 封装器id
	 */
	private Integer id;
	/*
	 * 封装器名称
	 */
	private String name;
	/*
	 * 封装器文件地址
	 */
	private String fileAddress;
	
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
	public String getFileAddress() {
		return fileAddress;
	}
	public void setFileAddress(String fileAddress) {
		this.fileAddress = fileAddress;
	}
	
	
	
}
