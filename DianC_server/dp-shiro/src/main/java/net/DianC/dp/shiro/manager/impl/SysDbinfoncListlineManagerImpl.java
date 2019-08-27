package net.DianC.dp.shiro.manager.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.dao.SysDbinfoncListlineMapper;
import net.DianC.dp.shiro.entity.SysDbinfoQueryEntity;
import net.DianC.dp.shiro.entity.SysDbinfoncListlineEntity;
import net.DianC.dp.shiro.entity.SysHbaseaddrEntity;
import net.DianC.dp.shiro.entity.TableStructurezTreeEntity;
import net.DianC.dp.shiro.manager.SysDbinfoncListlineManager;
import net.DianC.dp.shiro.util.GetHbaseColumn;
import net.DianC.dp.shiro.entity.SysOrgEntity;
import net.DianC.dp.shiro.entity.SysTableStructureEntity;

/**
 * 
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年7月09日 下午3:38:32
 */

@Component("/sysDbinfoncListlineManager")
public class SysDbinfoncListlineManagerImpl implements SysDbinfoncListlineManager {

	@Autowired
	private SysDbinfoncListlineMapper SysDbinfonclistlineMapper;
	

	@Override
	public List<SysDbinfoncListlineEntity> listSysDbinfoncListline(Page<SysDbinfoncListlineEntity> page, Query search) {
		return SysDbinfonclistlineMapper.listForPage(page, search);
	}

	@Override
	public int saveSysDbinfoncListline(SysDbinfoncListlineEntity SysDbinfonclistline) {
		return SysDbinfonclistlineMapper.save(SysDbinfonclistline);
	}

	@Override
	public SysDbinfoncListlineEntity getSysDbinfoncListlineById(Long id) {
		SysDbinfoncListlineEntity SysDbinfonclistline = SysDbinfonclistlineMapper.getObjectById(id);
		return SysDbinfonclistline;
	}

	@Override
	public int updateSysDbinfonclistline(SysDbinfoncListlineEntity SysDbinfonclistline) {
		return SysDbinfonclistlineMapper.update(SysDbinfonclistline);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = SysDbinfonclistlineMapper.batchRemove(id);
		return count;
	}

/*	public List<SysDbinfoncListlineEntity> getTbid(){
		return  ;
	}*/
	
	@Override
	public List<SysDbinfoncListlineEntity> getSysDbinfoncListlinezTree(int dbinfoId) {
		// TODO Auto-generated method stub
		return SysDbinfonclistlineMapper.getSysDbinfoncListlinezTree(dbinfoId);
	}

	@Override
	public List<TableStructurezTreeEntity> listlineDbinfoTree() {
		// TODO Auto-generated method stub
		return SysDbinfonclistlineMapper.listlineDbinfoTree();
	}

	@Override
	public List<TableStructurezTreeEntity> listlineTbinfoTree() {
		// TODO Auto-generated method stub
		return SysDbinfonclistlineMapper.listlineTbinfoTree();
	}

	@Override
	public BufferedReader sendSQLSocket(String sqlsript,int startposition,int endposition,String queryType2) {
		// TODO Auto-generated method stub
		BufferedReader is = null;
		Socket socket = null;
		SysHbaseaddrEntity sysHbaseaddr = SysDbinfonclistlineMapper.getItemByhbaseType("DBPROXYQUERY");
		try {
			String socketIP = sysHbaseaddr.getHbaseAddress();
			int socketPort = Integer.parseInt(sysHbaseaddr.getHbasePort());
			socket = new Socket(socketIP,socketPort);
			PrintWriter os = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"),true);
			is = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			os.println(sqlsript);
			os.println(startposition);
			os.println(endposition);
			os.println(queryType2);
			os.println("Bye");	//本次查询结束标记
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
	}

	@Override
	public List<SysDbinfoQueryEntity> getRecords(BufferedReader is, String tableName) throws IOException {
		// TODO Auto-generated method stub
		List<SysDbinfoQueryEntity> resList = new ArrayList<SysDbinfoQueryEntity>();
		String readline = is.readLine();
		resList.add(this.getColumn(tableName));
		try {
			while (!(readline = is.readLine()).equals("end")){
				SysDbinfoQueryEntity result = new SysDbinfoQueryEntity();
				String record = readline;
				result.setResult(record);
				resList.add(result);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resList;
/*		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		String readline ;
		
		String count = is.readLine();
		HashMap<String, String> countmap = new HashMap<String, String>();
		countmap.put("rcount", count);
		System.out.println("ccccccccccccccccccccccc"+count);
		result.add(countmap);
		try {
			while (!(readline = is.readLine()).equals("end")){
				String[] lineRecord = readline.split(",");
				HashMap<String, String> record = new HashMap<String, String>();
				for (int i = 0; i < fields.size(); i++) {
					String fieldName = fields.get(i);
					if(i>=lineRecord.length){
						record.put(fieldName, "");
					}else{
						record.put(fieldName, lineRecord[i]);
					}
				}
				result.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;*/
	}

	@Override
	public SysDbinfoQueryEntity getColumn(String tableName) {
		// TODO Auto-generated method stub
		SysDbinfoQueryEntity dbinfoQuery = new SysDbinfoQueryEntity();
		GetHbaseColumn getHC = new GetHbaseColumn();
		List<String> columnList = new ArrayList<String>();
		String resColumn = "";
		int i = 0;
		try {
			//根据tablename获取表的字段
			columnList = getHC.getColumn(tableName);				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(columnList.isEmpty()) {
			//添加警告：Hbase中不存在该表
		}
		else {
			for (i = 0;i < columnList.size() - 1; i++) {
				resColumn = resColumn + columnList.get(i) + ',';
			}
			resColumn = resColumn + columnList.get(i);
		}
		dbinfoQuery.setResult(resColumn);
		return dbinfoQuery;
	}


	/*@Override
	public int updateSysDbinfoncListline(SysDbinfoncListlineEntity SysDbinfonclistline) {
		return 0;
	}
*/
	
}
