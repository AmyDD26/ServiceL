package net.DianC.dp.shiro.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import net.DianC.dp.shiro.util.DbConn;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GetIpDao extends HibernateDaoSupport{
	private static DbConn dbconn=new DbConn();
	private static Connection conn=(Connection) dbconn.getConnect();
	public List<String> findAll() {
	//public static void main(String[] args){
		//Connection conn=(Connection) dbconn.getConnect();
		String sql="select ip from clusternode";
		List<String> list=new ArrayList<String>();
		 try{
			   Statement stmt=(Statement) conn.createStatement();
			   java.sql.ResultSet rs=stmt.executeQuery(sql);
			   while(rs.next()){
				  list.add(rs.getString(1));
			   }
		   }catch(SQLException e){
			   e.printStackTrace();
		   }
		return list;
	}
	
	public List<String> getNodeInfo(String ip) {
		String sql="select ip,name from clusternode where ip='"+ip+"'";
		List<String> list=new ArrayList<String>();
		 try{
			   Statement stmt=(Statement) conn.createStatement();
			   java.sql.ResultSet rs=stmt.executeQuery(sql);
			   while(rs.next()){
				   list.add(rs.getString(1));
				   list.add(rs.getString(2));
			   }
		   }catch(SQLException e){
			   e.printStackTrace();
		   }
		return list;
	}

	public static List<String> getunregionInfo(String name) {
		String sql="select name,ip from clusternode where name='"+name+"'";
		List<String> list=new ArrayList<String>();
		 try{
			   Statement stmt=(Statement) conn.createStatement();
			   java.sql.ResultSet rs=stmt.executeQuery(sql);
			   while(rs.next()){
				   list.add(rs.getString(1));
				   list.add(rs.getString(2));
			   }
		   }catch(SQLException e){
			   e.printStackTrace();
		   }
		return list;
	}

	public String getServerIp(String servername) {
		String sql="select ip from clusternode where name='"+servername+"'";
		String ip=null;
		 try{
			   Statement stmt=(Statement) conn.createStatement();
			   java.sql.ResultSet rs=stmt.executeQuery(sql);
			   while(rs.next()){
				   ip=rs.getString(1);
			   }
		   }catch(SQLException e){
			   e.printStackTrace();
		   }
		return ip;
	}
}
