/**
 * Hbase数据库操作
 */
package net.DianC.dp.shiro.util;

import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
/**
 * @author zhangk
 *
 */
public class HbaseDatabase {
	
	private static Configuration conf = null;
	private static ClusterConn clustercon=new ClusterConn();
	private static List<String> listc=clustercon.getConn();
	static {
		conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", listc.get(0));
		conf.set("hbase.zookeeper.property.clientPort", listc.get(1));
	}
	public void createTable(String tablename,int inflag) throws Exception{
		String tableName = tablename.toUpperCase();
		try{
		HBaseAdmin hAdmin = new HBaseAdmin(conf);// 新建一个数据库管理员  
		if (hAdmin.tableExists(tableName)) {
			System.out.println("表已经存在");
		} else {
			if(inflag==0){
				System.out.println(tableName);
				// 新建一个scores表的描述
				HTableDescriptor tableDesc = new HTableDescriptor(tableName);
				//添加压缩方式
				HColumnDescriptor hcd = new HColumnDescriptor("A".getBytes());//数据列族 
				HColumnDescriptor hcd1 = new HColumnDescriptor("C".getBytes());//数据量列族
				//hcd.setCompressionType(Algorithm.SNAPPY);
				// 在描述里添加列族
				tableDesc.addFamily(hcd);
				tableDesc.addFamily(hcd1);
				// 根据配置好的描述建表
				hAdmin.createTable(tableDesc);
			}else{
				System.out.println(tableName);
				// 新建一个scores表的描述
				HTableDescriptor tableDesc = new HTableDescriptor(tableName);
				HColumnDescriptor hcd0 = new HColumnDescriptor("A".getBytes());
				HColumnDescriptor hcd1 = new HColumnDescriptor("C".getBytes());
				HColumnDescriptor hcd2 = new HColumnDescriptor("S".getBytes());//二级索引列族
				//hcd.setCompressionType(Algorithm.SNAPPY);
				// 在描述里添加列族
				tableDesc.addFamily(hcd0);
				tableDesc.addFamily(hcd1);
				tableDesc.addFamily(hcd2);
				// 根据配置好的描述建表
				hAdmin.createTable(tableDesc);
			}
			
	}
		}catch(Exception e){
			System.out.println("*****************************9999999999");
			e.printStackTrace();
		}
	}

	public void deleteTable(String tableName) throws Exception {
		// 新建一个数据库管理员
		HBaseAdmin hAdmin = new HBaseAdmin(conf);
		if (hAdmin.tableExists(tableName.toUpperCase())) {
			// 关闭一个表
			hAdmin.disableTable(tableName.toUpperCase());
			// 删除一个表
			hAdmin.deleteTable(tableName.toUpperCase());
			System.out.println("删除表成功");
		} else {
			System.out.println("删除的表不存在");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HbaseDatabase hdb = new HbaseDatabase();
		try {
			//hdb.createTable("666", 0);
			hdb.deleteTable("666");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
