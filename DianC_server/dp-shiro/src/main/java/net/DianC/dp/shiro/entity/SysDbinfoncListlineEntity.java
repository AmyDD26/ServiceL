package net.DianC.dp.shiro.entity;

import java.util.List;

public class SysDbinfoncListlineEntity {
	/**
	 * @author hejh
	 */	
	/*
	 * 数据集内容
	 */
	private String END_TIME;
	private String ID;
	private String SETTEMP;
	private String START_TIME;
	private String TEMP0;
	private String TIME;
	private String WINDSIZE;
	private String rowKey;
	
	/*
	 * 数据集id
	 */
	private Integer id;
	
	private String content;
	
	
	/*
	 *数据内容 表  树
	*/
	private Integer dbId;
	
	private Integer tbid;
	
	private String name;
	
	private String chName;
	
	private String description;
	
	//private int pid;
	
	private List<?> list;
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEND_TIME() {
		return END_TIME;
	}

	public void setEND_TIME(String eND_TIME) {
		END_TIME = eND_TIME;
	}

	public String getSETTEMP() {
		return SETTEMP;
	}

	public void setSETTEMP(String sETTEMP) {
		SETTEMP = sETTEMP;
	}

	public String getSTART_TIME() {
		return START_TIME;
	}

	public void setSTART_TIME(String sTART_TIME) {
		START_TIME = sTART_TIME;
	}

	public String getTEMP0() {
		return TEMP0;
	}

	public void setTEMP0(String tEMP0) {
		TEMP0 = tEMP0;
	}

	public String getTIME() {
		return TIME;
	}

	public void setTIME(String tIME) {
		TIME = tIME;
	}

	public String getWINDSIZE() {
		return WINDSIZE;
	}

	public void setWINDSIZE(String wINDSIZE) {
		WINDSIZE = wINDSIZE;
	}

	public String getRowKey() {
		return rowKey;
	}

	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDbId() {
		return dbId;
	}

	public void setDbId(int dbId) {
		this.dbId = dbId;
	}

	public Integer getTbid() {
		return tbid;
	}

	public void setTbid(Integer tbid) {
		this.tbid = tbid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
*/
	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	
	
}
