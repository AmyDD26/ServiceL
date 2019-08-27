package net.DianC.dp.shiro.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.DianC.dp.shiro.util.WebConn;

//import com.mysql.jdbc.Statement;





public class HbaseMSizeDao {	
	private static WebConn webcon=new WebConn();
	private List<String> list=new ArrayList<String>();	
	private static List<String> list2=new ArrayList<String>();	
	private static String url1=null;
	
	public List crawinfo(){
		list2=webcon.getConn();
		url1=list2.get(0);
		//2018.4.8修改正則表達式順序，原來為"<td id=\"col3\"> (.+?)<tr class=\"rowAlt\">(.+?)<td id=\"col3\"> (.+?)<tr class=\"rowNormal\">"
		String infostr="<td id=\"col3\"> (.+?)<tr class=\"rowNormal\">(.+?)<td id=\"col3\"> (.+?)<tr class=\"rowAlt\">";
		Pattern pinfo=Pattern.compile(infostr);
		try {
			URL url=new URL(url1); //连接网页
			BufferedReader  rd=new BufferedReader(new InputStreamReader(url.openStream())); //获取网页源码
			String line=null;
			while((line=rd.readLine())!=null){
				Matcher minfo=pinfo.matcher(line);
				while(minfo.find()){
					list.add(minfo.group(1));
					list.add(minfo.group(3));
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
}
	public List userTable(){
		list2=webcon.getConn();
		url1=list2.get(1);
		String infostr="<td><a(.+?)>(.+?)</a> </td>";
		String regionnum=" <td>[0-9]+";
		Pattern pinfo=Pattern.compile(infostr);
		Pattern prnum=Pattern.compile(regionnum);
		try {
			URL url=new URL(url1); //连接网页
			BufferedReader  rd=new BufferedReader(new InputStreamReader(url.openStream())); //获取网页源码
			String line=null;
			//2018.4.8根据源码类型，修改了读表逻辑
			while((line=rd.readLine())!=null){
				Matcher minfo=pinfo.matcher(line);
				if (minfo.find()) {
					list.add(minfo.group(2));
					line = rd.readLine();//多读一行空格
					line = rd.readLine();//在线region数
					Matcher mregion = prnum.matcher(line);
					if (mregion.find()) {
						Pattern prnum1 = Pattern.compile("[0-9]+");
						Matcher mregion1 = prnum1.matcher(line);
						if (mregion1.find()) {
							list.add(mregion1.group());
						}
					}
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public String getTableNum() {
		String num = null;
		list2=webcon.getConn();
		url1=list2.get(1);
		String tablennum="<p> (.+?) table";
		Pattern ptable=Pattern.compile(tablennum);
		try {
			URL url=new URL(url1); //连接网页
			BufferedReader  rd=new BufferedReader(new InputStreamReader(url.openStream())); //获取网页源码
			String line=null;
			while((line=rd.readLine())!=null){
				Matcher mtable=ptable.matcher(line);
				if(mtable.find()){
					num=mtable.group(1);
					}
				}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public  List<String> unregionInfo() {
	//public static void main(String args[]){
		list2=webcon.getConn();
		url1=list2.get(1);
		String infostr="<tr><td>[A-Za-z0-9]{3,10},60020";
		String infostr1="<tr><td>(.+?),";
		Pattern pinfo=Pattern.compile(infostr);
		Pattern pinfo1=Pattern.compile(infostr1);
		try {
			URL url=new URL(url1); //连接网页
			BufferedReader  rd=new BufferedReader(new InputStreamReader(url.openStream())); //获取网页源码
			String line=null;
			while((line=rd.readLine())!=null){
				Matcher minfo=pinfo.matcher(line);
				while(minfo.find()){
					Matcher minfo1=pinfo1.matcher(minfo.group());
					if(minfo1.find())
					list.add(minfo1.group(1));
					}
				}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
