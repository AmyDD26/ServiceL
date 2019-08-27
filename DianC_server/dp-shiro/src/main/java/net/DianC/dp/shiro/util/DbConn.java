package net.DianC.dp.shiro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConn {
	public Connection getConnect(){
		Connection con = null;
		//Configuration config = new Configuration();
		/*
		String svnip = config.getItemValue("SvnserverConn", "ip");
		String svndbname = config.getItemValue("SvnserverConn", "dbname");
		String userName = config.getItemValue("SvnserverConn", "username");
		String pass = config.getItemValue("SvnserverConn", "password");
		String svnport=config.getItemValue("SvnserverConn", "port");
		String driver = "com.mysql.jdbc.Driver";
		*/
		String svnip = new String("10.61.6.160");
		String svndbname= new String("decloud");
		String userName= new String("root");
		String pass= new String("sigsit^Y&U*I123");
		String svnport= new String("3306");
		String driver= "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://"+svnip+":"+svnport+"/"+svndbname+"?useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
