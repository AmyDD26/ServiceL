package net.DianC.dp.shiro.entity;

import java.io.Serializable;

/**
 * Hbase环境监控集群信息
 * @author zhangk
 *
 */
public class SysHbaseMoniAttrEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 属性名称
	 */
	private String AttributeName;
	/*
	 * 属性值
	 */
	private String AttributeValue;
	
	public String getAttributeName() {
		return AttributeName;
	}
	public void setAttributeName(String attributeName) {
		AttributeName = attributeName;
	}
	public String getAttributeValue() {
		return AttributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		AttributeValue = attributeValue;
	}
	
}
