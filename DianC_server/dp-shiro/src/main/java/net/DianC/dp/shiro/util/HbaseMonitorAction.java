package net.DianC.dp.shiro.util;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.util.Bytes;

import net.DianC.dp.shiro.entity.SysHbaseMoniAttrEntity;
import net.DianC.dp.shiro.entity.SysHbaseMoniRegInfoEntity;
import net.DianC.dp.shiro.entity.SysHbaseMoniRegServEntity;
import net.DianC.dp.shiro.entity.SysHbaseMoniTableEntity;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;

@SuppressWarnings("serial")
public class HbaseMonitorAction extends Object{
	private List<SysHbaseMoniAttrEntity> attributesList = new ArrayList<SysHbaseMoniAttrEntity>();
	private List<SysHbaseMoniRegServEntity> serverList = new ArrayList<SysHbaseMoniRegServEntity>();
	private List<SysHbaseMoniRegInfoEntity> regionList = new ArrayList<SysHbaseMoniRegInfoEntity>();
	private List<SysHbaseMoniTableEntity> tableList = new ArrayList<SysHbaseMoniTableEntity>();
	//private GetIpDao ipdao=new GetIpDao();
	private static ClusterConn clustercon=new ClusterConn();
	private List<String> listc=new ArrayList<String>();	
	private String servername=null;
	
	/**
	 * *集群信息
	 * @throws MasterNotRunningException
	 * @throws ZooKeeperConnectionException
	 * @throws IOException
	 */
	public List<SysHbaseMoniAttrEntity> getAttributes() throws MasterNotRunningException, ZooKeeperConnectionException, IOException{
		int index=0;
		List<String> list=new ArrayList<String>();
		Configuration conf = HBaseConfiguration.create();
		listc=clustercon.getConn();
		conf.set("hbase.zookeeper.quorum", listc.get(0));
		conf.set("hbase.zookeeper.property.clientPort", listc.get(1));
		HbaseMSizeDao hbaseMSize=new HbaseMSizeDao();
		list=hbaseMSize.crawinfo();
		String num=hbaseMSize.getTableNum();
		@SuppressWarnings("resource")
		HBaseAdmin admin = new HBaseAdmin(conf);
		ClusterStatus status=admin.getClusterStatus();
		int i=0;
		for(ServerName server:status.getServers()){
			ServerLoad load=status.getLoad(server);
			i=i+load.getMaxHeapMB();
		}
		
		
		while (index < 13) {
			if (index == 0) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("Hbase版本号");
				object.setAttributeValue(status.getHBaseVersion());
				attributesList.add(object);
			} else if (index == 1) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("集群Region服务器总数量");
				object.setAttributeValue((status.getServersSize() + status.getDeadServers() + ""));
				attributesList.add(object);
			} else if (index == 2) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("集群主节点名");
				object.setAttributeValue(status.getMaster().getHostname());
				attributesList.add(object);
			} else if (index == 3) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("当前可用Region服务器数量");
				object.setAttributeValue(status.getServersSize() + "");
				attributesList.add(object);
			} else if (index == 4) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("当前不可用Region服务器数量");
				object.setAttributeValue(status.getDeadServers() + "");
				attributesList.add(object);
			} else if (index == 5) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("当前集群上的表数量");
				object.setAttributeValue(num);
				attributesList.add(object);
			} else if (index == 6) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("集群总负载量（region总量）");
				object.setAttributeValue(status.getRegionsCount() + "");
				attributesList.add(object);
			} else if (index == 7) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("Region服务器上平均负载");
				object.setAttributeValue(status.getAverageLoad() + "");
				attributesList.add(object);
			} else if (index == 8) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("当前每秒收到的请求数（TPS）");
				object.setAttributeValue(status.getRequestsCount() + "");
				attributesList.add(object);
			} else if (index == 9) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("集群总JVM内存大小");
				object.setAttributeValue(i + "MB");
				attributesList.add(object);
			} else if (index == 10) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("集群磁盘存储空间");
				object.setAttributeValue(list.get(0));
				attributesList.add(object);
			} else if (index == 11) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("集群文件系统已用空间");
				object.setAttributeValue(list.get(2));
				attributesList.add(object);
			} else if (index == 12) {
				SysHbaseMoniAttrEntity object = new SysHbaseMoniAttrEntity();
				object.setAttributeName("集群文件系统剩余空间");
				object.setAttributeValue(list.get(3));
				attributesList.add(object);
			}
			index++;
		}
		return attributesList;
}
	/**
	 * Region服务器信息
	 * @throws MasterNotRunningException
	 * @throws ZooKeeperConnectionException
	 * @throws IOException
	 * @throws ParseException
	 */
	public List<SysHbaseMoniRegServEntity> getRegionServers() throws MasterNotRunningException, ZooKeeperConnectionException, IOException, ParseException{
		//int index=0;
		Configuration conf = HBaseConfiguration.create();
		listc=clustercon.getConn();
		conf.set("hbase.zookeeper.quorum", listc.get(0));
		conf.set("hbase.zookeeper.property.clientPort", listc.get(1));
		@SuppressWarnings("resource")
		HBaseAdmin admin = new HBaseAdmin(conf);
		ClusterStatus status=admin.getClusterStatus();
		String servername=null;
		for(ServerName server:status.getServers()){//每次取出一个服务器名赋给server，直到getServer为空
			SysHbaseMoniRegServEntity object = new SysHbaseMoniRegServEntity();
			//获取服务器名
			String infostr="(.+?),(.+?),(.+?)";
			Pattern pinfo=Pattern.compile(infostr);
			Matcher minfo=pinfo.matcher(server.getServerName());
			while(minfo.find()){
				object.setServerName(minfo.group(1));
				servername=minfo.group(1);
			}
			//String ip = ipdao.getServerIp(servername);
			//object.setServerIp(ip);
			object.setServerStatus(server.getServerName());
			ServerLoad load=status.getLoad(server);
			object.setRegionNum(load.getNumberOfRegions()+"");
			object.setUserHeap(load.getUsedHeapMB()+"");
			object.setMaxHeap(load.getMaxHeapMB()+"");
			object.setFileSize(load.getStorefileSizeInMB()+"");
			serverList.add(object);
		}
		
		return serverList;
	}
	/**
	 * 该服务器上的Region信息
	 * @throws MasterNotRunningException
	 * @throws ZooKeeperConnectionException
	 * @throws IOException
	 * @throws ParseException
	 */
	public List<SysHbaseMoniRegInfoEntity> getRegionInfo() throws MasterNotRunningException, ZooKeeperConnectionException, IOException, ParseException{
		Configuration conf = HBaseConfiguration.create();
		listc=clustercon.getConn();
		conf.set("hbase.zookeeper.quorum", listc.get(0));
		conf.set("hbase.zookeeper.property.clientPort", listc.get(1));
		@SuppressWarnings("resource")
		HBaseAdmin admin = new HBaseAdmin(conf);
		ClusterStatus status=admin.getClusterStatus();
		servername=new String(this.servername.getBytes("ISO-8859-1"),"utf-8");
		//servername = new String("slave1,16020,1520948770207&_dc=1523524823415");
		if (servername.equals("kong"))
			return null;
		else {
			String str = "(.+?),(.+?)";
			Pattern pinfo = Pattern.compile(str);
			for (ServerName server : status.getServers()) {
				Matcher minfo = pinfo.matcher(servername);
				while (minfo.find()) {
					if (minfo.group(1).equals(server.getHostname())) {
						ServerLoad load = status.getLoad(server);
						for (Map.Entry<byte[], RegionLoad> entry : load.getRegionsLoad().entrySet()) {
							SysHbaseMoniRegInfoEntity object = new SysHbaseMoniRegInfoEntity();
							RegionLoad regionLoad = entry.getValue();
							object.setServerName(server.getHostname());
							object.setRegion(Bytes.toStringBinary(entry.getKey()));
							object.setFileSize(regionLoad.getStorefileSizeMB() + "");
							regionList.add(object);
						}
					}
				}
			}
			return regionList;
		}
	}

	/**
	 * 表信息
	 */
	public List<SysHbaseMoniTableEntity> getTableInfo() {
		List<String> list=new ArrayList<String>();
		HbaseMSizeDao hbaseMSize=new HbaseMSizeDao();
		list=hbaseMSize.userTable();
		int i=0;
		while(i<list.size()-1){
			SysHbaseMoniTableEntity object = new SysHbaseMoniTableEntity();
			object.setTableName(list.get(i));
			object.setOnlineRegionNum(list.get(i+1));
			tableList.add(object);
			i=i+2;
		}
		
		return tableList;
	}
	
	public String getServername() {
		return servername;
	}
	public void setServername(String servername) {
		this.servername = servername;
	}
}
