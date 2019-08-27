package net.DianC.dp.shiro.util;

import java.util.ArrayList;
import java.util.List;

public class ClusterConn {
	public List<String> getConn(){
		List<String> list=new ArrayList<String>();
		//Configuration config = new Configuration();
		//String zookeeperAddress=config.getItemValue("HbaseAddress","habse.zookeeper.quorum");
		//String port=config.getItemValue("HbaseAddress", "hbase.zookeeper.property.clientPort");
		String zookeeperAddress=new String("master");
		String port=new String("2181");
		list.add(zookeeperAddress);
		list.add(port);
		return list;
		}
}
