package net.DianC.dp.shiro.entity;

import java.io.Serializable;

public class SysDbinfoQueryEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * 数据集名称
	 */
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
