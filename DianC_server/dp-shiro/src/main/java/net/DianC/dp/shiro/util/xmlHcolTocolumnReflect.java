package net.DianC.dp.shiro.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class xmlHcolTocolumnReflect {
 private Map <String,String>reflectMap;
//采用格式为<linecolumn,"colmnfamilyname:columnname">
 public xmlHcolTocolumnReflect()
 {
	 this.reflectMap=new HashMap();
 }
 public void addReflect(String colFamilyName,String colname,String linecolumnName)
 {
	 String key=linecolumnName;
	 String value=colFamilyName+":"+colname;
	 this.reflectMap.put(key, value);
 }
 public String getlinecolumnName(String lineColname)
 {
	 String key=lineColname;
	 String value=this.reflectMap.get(key);
	 return value;
 }
@Override
public Object clone() throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	 xmlHcolTocolumnReflect  reflect=new  xmlHcolTocolumnReflect ();
	 Map <String,String>map=new HashMap();
	for( Entry<String,String> entry : this.reflectMap.entrySet())
	{
		 String strkey = entry.getKey();
		 
         String strval = entry.getValue();
         map.put(strkey, strval);
	}
	reflect.setReflectMap(map);
	return reflect;
}
public Map<String, String> getReflectMap() {
	return reflectMap;
}
public void setReflectMap(Map<String, String> reflectMap) {
	this.reflectMap = reflectMap;
}
}
