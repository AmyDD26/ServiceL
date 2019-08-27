package net.DianC.dp.shiro.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xmlHtable {
	private String rokeyName;
	private String HtableName;
	private List<xmlcolumnFamily>families;
	private  xmlHcolTocolumnReflect reflect;
	public xmlHtable(){}
	public String getHtableName() {
		return HtableName;
	}
	public void setHtableName(String htableName) {
		HtableName = htableName;
	}
	public xmlHtable(String HtableName,String rokeyName)
	{
		this.rokeyName=rokeyName;
		this.HtableName=HtableName;
		this.families=new ArrayList();
	}
	public String getRokeyName() {
		return rokeyName;
	}
	public void setRokeyName(String rokeyName) {
		this.rokeyName = rokeyName;
	}
	public List<xmlcolumnFamily> getFamilies() {
		return families;
	}
	public void setFamilies(List<xmlcolumnFamily> families) {
		this.families = families;
	}
	public xmlHcolTocolumnReflect getReflect() {
		return reflect;
	}
	public void setReflect(xmlHcolTocolumnReflect reflect) {
		this.reflect = reflect;
	}
	@Override
public Object clone() throws CloneNotSupportedException {
		xmlHtable table=new xmlHtable(this.HtableName,this.rokeyName);
		Iterator it=this.families.iterator();
		List<xmlcolumnFamily> famlist=new ArrayList();
		while(it.hasNext())
		{
			xmlcolumnFamily fam=(xmlcolumnFamily) ((xmlcolumnFamily)it.next()).clone();
			famlist.add(fam);
		}
		table.setFamilies(famlist);
		xmlHcolTocolumnReflect ref=(xmlHcolTocolumnReflect)this.reflect.clone();
		table.setReflect(ref);
		return table;
	}

}
