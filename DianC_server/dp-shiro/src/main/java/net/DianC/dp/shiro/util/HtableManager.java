package net.DianC.dp.shiro.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.shiro.entity.SysDbinfoncListlineEntity;

import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
// import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
// import org.apache.hadoop.hbase.io.hfile.Compression.Algorithm;
import org.apache.hadoop.hbase.util.Bytes;

import edu.emory.mathcs.backport.java.util.Arrays;




public class HtableManager {

	//private List<String> data;
	//private HTable htable;
	private xmlHtable htableConf;
	private static int pageCount;
	

	public HtableManager(xmlHtable htableConf) {
		this.htableConf = htableConf;
	}

	public void createTable() throws Exception {
		Configuration conf = XmlclusterConfigure.getconf();
		HBaseAdmin hAdmin = new HBaseAdmin(conf);
		if (hAdmin.tableExists(this.htableConf.getHtableName())) {
			System.out.println("表已经存在");
		} else {
			// 新建一个scores表的描述
			HTableDescriptor tableDesc = new HTableDescriptor(
					this.htableConf.getHtableName());
			// 在描述里添加列族
			List<xmlcolumnFamily> families = this.htableConf.getFamilies();
			for (xmlcolumnFamily columnFamily : families) {
				HColumnDescriptor hcd = new HColumnDescriptor(columnFamily
						.getColumnFamilyName());
				// hcd.setCompactionCompressionType(Algorithm.SNAPPY);
				tableDesc.addFamily(hcd);
			}
			// 根据配置好的描述建表
			hAdmin.createTable(tableDesc);
			System.out.println("创建表成功");

		}

	}

	// 删除数据库表
	public void deleteTable() throws Exception {
		// 新建一个数据库管理员
		Configuration conf = XmlclusterConfigure.getconf();
		HBaseAdmin hAdmin = new HBaseAdmin(conf);
		String tableName= this.htableConf.getHtableName();
		if (hAdmin.tableExists(tableName)) {
			// 关闭一个表
			hAdmin.disableTable(tableName);
			// 删除一个表
			hAdmin.deleteTable(tableName);
			System.out.println("删除表成功");
		} else {
			System.out.println("删除的表不存在");
			System.exit(0);
		}
	}

	 public static List getResultScann(String tableName) throws IOException {
		 System.setProperty("hadoop.home.dir", "c:/windows/hadoop-2.6.1");
		 System.setProperty("hbase.home.dir", "c:/windows/hbase-1.2.6");
		 Scan scan = new Scan();
		 String line;
		 SysDbinfoncListlineEntity set = new SysDbinfoncListlineEntity();
	        ResultScanner rs = null;
	        List<SysDbinfoncListlineEntity> sb = new ArrayList<SysDbinfoncListlineEntity>();
	    	ByteArrayOutputStream bout=new ByteArrayOutputStream();
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(bout ));
	        HTable table = new HTable(XmlclusterConfigure.getconf(), Bytes.toBytes(tableName));
	        try {
	            rs = table.getScanner(scan);
	           // System.out.println(bout);
	            int count=0;
	            for (Result r : rs) {
	            	count++;//统计条数
	            	List<KeyValue> lst=r.list();
	            	int length=r.list().size();
	            	int i = 0;
	                for (i = 0; i < length - 1 ; i++) {
	                	KeyValue kv = lst.get(i);
	                	line = Bytes.toString(kv.getValue());
	                	//System.out.println(kv);
	    					switch(i % 6){
	    						case 0:{
	    							set.setEND_TIME(line);
	    							//System.out.println(line);
	    							break;
	    						}
	    						case 1:{
	    							set.setID(line);
	    							//System.out.println(line);
	    							break;
	    						}
	    						case 2:{
	    							set.setSETTEMP(line);System.out.println(line);
	    							break;
	    						}
	    						case 3:{
	    							set.setSTART_TIME(line);System.out.println(line);
	    							break;
	    						}
	    						case 4: {
	    							set.setTEMP0(line);System.out.println(line);
	    							break;
	    						}	
	    						case 5: {
	    							set.setTIME(line);System.out.println(line);
	    							break;
	    						}
	    						/*case 6:{
	    							set.setWINDSIZE(line);
	    							System.out.println(line);
	    							break;
	    						}
	    						case 7:{
	    							set.setRowKey(line);
	    							System.out.println(line);
	    							break;
	    						}*/
	    					}
	                	//set.setContent(line);
	                	
	                }
	                sb.add(set);
	                pageCount ++;
	                if(count>3){//最多导出1000条数据
	                	break;
	                }
	            }
	        } 
	        finally {
	            rs.close();
	        }
	        bw.flush();
	        bw.close();
	        return sb; 
	    }

	 public static ByteArrayOutputStream  getResultScann2(String tableName) throws IOException {
		 System.setProperty("hadoop.home.dir", "c:/windows/hadoop-2.6.1");
		    Scan scan = new Scan();
	        ResultScanner rs = null;
	    	ByteArrayOutputStream bout=new ByteArrayOutputStream();
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(bout ));
	        HTable table = new HTable(XmlclusterConfigure.getconf(), Bytes.toBytes(tableName));
	        try {
	            rs = table.getScanner(scan);
	            int count=0;
	            for (Result r : rs) {
	            	StringBuilder sb=new StringBuilder();
	            	count++;//统计条数
	            	List<KeyValue> lst=r.list();
	            	int length=r.list().size();
	            	int i=0;
	                for ( i=0;i<(length-1); i++) {
	                	KeyValue kv=lst.get(i);
	                	sb.append(Bytes.toString(kv.getQualifier())+":"+Bytes.toString(kv.getValue()));
	                	sb.append(",");
	                }
	                KeyValue kv=lst.get(i);
	                sb.append(Bytes.toString(kv.getQualifier())+":"+Bytes.toString(kv.getValue()));
	                sb.append(",rowKey:"+Bytes.toString(kv.getRow()));
	                bw.write(sb.toString());
	                bw.newLine();
	                if(count>100)//最多导出50000条数据
	                {
	                	break;
	                }
	            }
	        } finally {
	        	if(rs != null){
	        		rs.close();
	        	}
	        }
	        bw.flush();
	        bw.close();
	        return bout;
	    }

	 public static void deleteTable(String name) throws Exception
	 {
		 xmlHtable htableConf = new xmlHtable(name,"ID");
		 HtableManager m=new HtableManager(htableConf);
		 m.deleteTable();
	 }

		/*
		 * 	String[] splitedbycomma = line.split(",");
			for(int c = 0; c < splitedbycomma .length; c++)
			{
				String [] splitedbycolon = splitedbycomma[c].split(":",2);
				String [] value = new String[2];
				for(int a = 1; a <= splitedbycolon.length; a += 2){
					value[(a+1)/2] = splitedbycolon[a];
				}
				for (int b = 0; b < value.length; b++){
					switch(b % 8){
						case 0:{
							END_TIME[a1] = value[b];
							set.setEND_TIME(END_TIME[a1++]);
						}
						case 1:{
							ID[a2] = value[b];
							set.setID(ID[a2++]);
						}
						case 2:{
							SETTEMP[a3] = value[b];
							set.setSETTEMP(SETTEMP[a3++]);
						}
						case 3:{
							START_TIME[a4] = value[b];
							set.setSTART_TIME(START_TIME[a4++]);
						}
						case 4: {
							TEMP0[a5] = value[b];
							set.setTEMP0(TEMP0[a5++]);
						}	
						case 5: {
							TIME[a6] = value[b];
							set.setTIME(TIME[a6++]);
						}
						case 6:{
							WINDSIZE[a7] = value[b];
							set.setWINDSIZE(WINDSIZE[a7++]);
						}
						case 7:{
							rowKey[a8] = value[b];
							set.setRowKey(rowKey[a8++]);
						}
					}
				}
			}	
			//System.out.println(a3);
			 * 
			 * 
			 
	 private static String [] END_TIME = new String [2000];
	 private static String [] ID = new String [2000];
	 private static String [] SETTEMP = new String [2000];
	 private static String [] START_TIME = new String [2000];
	 private static String [] TEMP0 = new String [2000];
	 private static String [] TIME = new String [2000];
	 private static String[] WINDSIZE = new String [2000];
	 private static String[] rowKey = new String [2000];*/

	 public static List<SysDbinfoncListlineEntity> scanTable(String name) throws IOException
	 {
			ByteArrayOutputStream bout=HtableManager.getResultScann2(name);
			BufferedReader br=new BufferedReader(new InputStreamReader(new BufferedInputStream(new ByteArrayInputStream(bout.toByteArray()))));
			List<SysDbinfoncListlineEntity> string = new ArrayList<SysDbinfoncListlineEntity>();
			String line=null;
			int m = 0;
			//int a1=0;int a2=0;int a3=0;int a4=0;int a5=0;int a6=0;int a7=0;int a8=0;
			while((line=br.readLine()) != null)	
			{
				SysDbinfoncListlineEntity set = new SysDbinfoncListlineEntity();
				set.setContent(line);
				set.setId(m++);
				
				string.add(set);
			}
			/*for(int i = 0; i < 47; i++){
				System.out.println(END_TIME[i]+":"+ID[i]+","+SETTEMP[i]+","+START_TIME[i]+","+TEMP0[i]+","+TIME[i]+","+WINDSIZE[i]+","+rowKey[i]);
			}*/
			return string;
	 }
	 
	 
	 
	public static void main(String[] args) throws Exception {
		String tableName="DNQ";
		//scanTable(tableName);
		getResultScann(tableName);
		
		//deleteTable(tableName);
	}

	public static int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
