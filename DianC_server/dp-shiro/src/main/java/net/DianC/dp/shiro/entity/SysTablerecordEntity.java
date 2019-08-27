/**
 * 
 */
package net.DianC.dp.shiro.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author zhangk
 *
 */
public class SysTablerecordEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 表id
	 */
	private Integer id;
	
	/*
	 * 表名 
	 */
	private String name;
	/*
	 * 计数
	 */
	private int count;
	/*
	 * 时间
	 */
	private Timestamp time;
	/*
	 * 日期
	 */
	private int day;
	/*
	 * 行键字符串
	 */
	private String rowkeystr;
	/*
	 * 是否可以接收
	 */
	private int isRecevie;
	/*
	 * tableInfoID
	 */
	private int tableInfoID;
	/*
	 * 
	 */
	private int sIndex;//
	/*
	 * dbinfoID
	 */
	private int dbID;
	
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp timestamp) {
		this.time = timestamp;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getRowkeystr() {
		return rowkeystr;
	}
	public void setRowkeystr(String rowkeystr) {
		this.rowkeystr = rowkeystr;
	}
	public int getIsRecevie() {
		return isRecevie;
	}
	public void setIsRecevie(int isRecevie) {
		this.isRecevie = isRecevie;
	}
	public int getTableInfoID() {
		return tableInfoID;
	}
	public void setTableInfoID(int tableInfoID) {
		this.tableInfoID = tableInfoID;
	}
	public int getsIndex() {
		return sIndex;
	}
	public void setsIndex(int sIndex) {
		this.sIndex = sIndex;
	}
	public int getDbID() {
		return dbID;
	}
	public void setDbID(int dbID) {
		this.dbID = dbID;
	}
}
