package net.DianC.dp.shiro.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.TableNotFoundException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class GetHbaseColumn {
	private List<String> listc=new ArrayList<String>();
	private static ClusterConn clustercon=new ClusterConn();
	
	
	@SuppressWarnings({ "resource", "deprecation" })
	public ArrayList<String> getHbaseColumnName(String tableName) throws MasterNotRunningException, ZooKeeperConnectionException, IOException{
		Configuration conf = HBaseConfiguration.create();
		listc=clustercon.getConn();
		conf.set("hbase.zookeeper.quorum", listc.get(0));
		conf.set("hbase.zookeeper.property.clientPort", listc.get(1));
		HBaseAdmin admin = new HBaseAdmin(conf);
		HColumnDescriptor[] columnFamilies = admin.getTableDescriptor(TableName.valueOf(tableName)).getColumnFamilies();
		System.out.println(admin.getTableDescriptor(TableName.valueOf(tableName)).getTableName());
		System.out.println(columnFamilies.length);
		ArrayList<String> columnsName = new ArrayList<>();
		for (HColumnDescriptor cName : columnFamilies) {
		    String name = Bytes.toString(cName.getName());
		    columnsName.add(name);
		}
		/*for (int i = 0; i < columnFamilies.length; i++) {
			String familyName = columnFamilies[i].getNameAsString();
			columnsName.add(familyName);
		}*/
		return columnsName;
	}
	
	@SuppressWarnings({ "resource", "deprecation" })
	public void printlnColumn(String tableName) throws IOException
    {
		Configuration conf = HBaseConfiguration.create();
		listc=clustercon.getConn();
		conf.set("hbase.zookeeper.quorum", listc.get(0));
		conf.set("hbase.zookeeper.property.clientPort", listc.get(1));
		HTable table = new HTable(conf, tableName);
		Scan scan = new Scan();
		ResultScanner rs = null;
		/* 
		ResultScanner rs= table.getScanner(scan);
		rs.
        Get g = new Get(rowKey.getBytes());
        Result rs = table.get(g);

        for (KeyValue kv : rs.raw())
        {
            System.out.println("--------------------" + new String(kv.getRow()) + "----------------------------");
            System.out.println("Column Family: " + new String(kv.getFamily()));
            System.out.println("Column       :" + new String(kv.getQualifier()));
            System.out.println("value        : " + new String(kv.getValue()));
        }*/
		try {

			rs = table.getScanner(scan);
			for (Result r : rs) {
				//StringBuilder sb = new StringBuilder();
				List<KeyValue> lst = r.list();

				int length = r.list().size();
				int i = 0;
				for (i = 0; i < length; i++) {

					KeyValue kv = lst.get(i);
					System.out.println("Column       :" + Bytes.toString(kv.getQualifier()));

				}
				/*for (i = 0; i < (length - 1); i++) {

					KeyValue kv = lst.get(i);
					sb.append(Bytes.toString(kv.getQualifier()) + ":" + Bytes.toString(kv.getValue()));
					sb.append(",");

				}
				KeyValue kv = lst.get(i);
				sb.append(Bytes.toString(kv.getQualifier()) + ":" + Bytes.toString(kv.getValue()));
				sb.append(",rowKey:" + Bytes.toString(kv.getRow()));
				System.out.println(sb.toString());*/
				//bw.write(sb.toString());
				//bw.newLine();
				/*if (count > 10)// 最多导出50000条数据
				{
					break;
				}*/
				break;

			}
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
    }
	@SuppressWarnings({ "deprecation", "resource" })
	public List<String> getColumn(String tableName) throws IOException, TableNotFoundException
    {
		Configuration conf = HBaseConfiguration.create();
		listc=clustercon.getConn();
		conf.set("hbase.zookeeper.quorum", listc.get(0));
		conf.set("hbase.zookeeper.property.clientPort", listc.get(1));
		HTable table = new HTable(conf, tableName);
		Scan scan = new Scan();
		ResultScanner rs = null;
		List<String> columnList = new ArrayList<String>();
		//空表异常判断（是否需要？）
		try {

			rs = table.getScanner(scan);
			for (Result r : rs) {
				List<KeyValue> lst = r.list();

				int length = r.list().size();
				int i = 0;
				for (i = 0; i < length; i++) {

					KeyValue kv = lst.get(i);
					columnList.add(Bytes.toString(kv.getQualifier()));

				}
				break;

			}
		}catch(TableNotFoundException e){
			columnList.clear();//Hbase中不存在对应表名，返回空的List
			} finally {
			if (rs != null) {
				rs.close();
			}
			table.close();
		}
		return columnList;
    }


}
