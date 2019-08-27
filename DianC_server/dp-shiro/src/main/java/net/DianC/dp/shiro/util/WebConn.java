package net.DianC.dp.shiro.util;

import java.util.ArrayList;
import java.util.List;


public class WebConn {
	public List getConn(){
	List<String> list=new ArrayList<String>();
	//Configuration config = new Configuration();
	//String hbaseAddress=config.getItemValue("WedAddress","hbaseAddress");
	//String hadoopAddress=config.getItemValue("WedAddress", "hadoopAddress");
	String hbaseAddress=new String("http://master:60010/master-status");
	String hadoopAddress=new String("http://master:50070/dfshealth.jsp");
	list.add(hadoopAddress);
	list.add(hbaseAddress);
	return list;
	}
}
