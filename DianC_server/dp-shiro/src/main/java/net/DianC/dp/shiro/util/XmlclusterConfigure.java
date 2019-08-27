package net.DianC.dp.shiro.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

public class XmlclusterConfigure {

	   private static Configuration conf = null;//集群参数设置
	   private static String quorum;//默认管理的ip 
	   private static String port;
		
	   
		 public static Configuration getconf()
		 {
			 if(conf==null)
			 {
		        conf = HBaseConfiguration.create();//classPath下的habse-site.xml文
		       // org.sigsit.vinca.sar.util.configuration.Configuration config = new   org.sigsit.vinca.sar.util.configuration.Configuration();
				String url = "10.61.6.161";
				quorum=url;
				String port = "2181";
				//System.out.println("url:"+url+",port:"+port);
		        conf.set("hbase.zookeeper.quorum",quorum);//设置管理的ip地址以及端口号
		        conf.set("hbase.zookeeper.property.clientPort", port);
			 }
			 return conf;
		 }
		public static String getQuorum() {
			return quorum;
		}
		public static void setQuorum(String quorum) {
			XmlclusterConfigure.quorum = quorum;
		}
		public static String getPort() {
			return port;
		}
		public static void setPort(String port) {
			XmlclusterConfigure.port = port;
		}
}
