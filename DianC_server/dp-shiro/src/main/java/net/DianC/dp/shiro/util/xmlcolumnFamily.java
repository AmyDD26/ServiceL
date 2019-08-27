package net.DianC.dp.shiro.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xmlcolumnFamily {//列族
 private String columnFamilyName;
 private List<String>colNames;
 public xmlcolumnFamily(String columnFamilyName)
 {
	 this.columnFamilyName=columnFamilyName;
	 this.colNames=new ArrayList();
 }
public String getColumnFamilyName() {
	return columnFamilyName;
}
public void setColumnFamilyName(String columnFamilyName) {
	this.columnFamilyName = columnFamilyName;
}
public List<String> getColName() {
	return colNames;
}
public void setColName(List<String> colNames) {
	this.colNames = colNames;
}
public void addColumn(String colname)
{
	this.colNames.add(colname);
}
@Override
protected Object clone() throws CloneNotSupportedException {
	xmlcolumnFamily family=new xmlcolumnFamily(this.columnFamilyName);
	List<String>lst=new ArrayList();
	Iterator it=this.colNames.iterator();
	while(it.hasNext())
	{
		String colname=(String)it.next();
		lst.add(colname);
		
	}
	family.setColName(lst);
	return family;
}
 
}
