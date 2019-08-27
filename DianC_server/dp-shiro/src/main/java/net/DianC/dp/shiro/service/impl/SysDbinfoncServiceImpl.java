package net.DianC.dp.shiro.service.impl;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.common.utils.CommonUtils;
import net.DianC.dp.shiro.entity.SysDbinfoncEntity;
import net.DianC.dp.shiro.entity.SysHbaseaddrEntity;
import net.DianC.dp.shiro.manager.SysDbinfoncManager;
import net.DianC.dp.shiro.manager.SysHbaseaddrManager;
import net.DianC.dp.shiro.service.SysDbinfoncService;
import net.DianC.dp.shiro.service.SysDataTableService;
import net.DianC.dp.shiro.service.SysTableStructureService;
@Service("sysDbinfoncService") 

public class SysDbinfoncServiceImpl implements SysDbinfoncService{
	
	@Autowired
	private SysDbinfoncManager sysDbinfoncManager;
	
	@Autowired
	private SysDataTableService sysDataTableService;
	
	@Autowired
	private SysTableStructureService sysTableStructureService;
	
	@Override
	public Page<SysDbinfoncEntity> listDbinfonc(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query query = new Query(params);
		Page<SysDbinfoncEntity> page = new Page<SysDbinfoncEntity>(query);
		sysDbinfoncManager.listForPage(page, query);
		return page;
	}

	@Override
	public R sendReceiveToDBproxy(String tableInfoId, String tableName) {
		// TODO Auto-generated method stub
		int isRecevie = sysDbinfoncManager.getIsRecevie(Integer.parseInt(tableInfoId));
		if(isRecevie == 0) {
			//sendReceive
			String dbName = sysDbinfoncManager.getdbName(Integer.parseInt(tableInfoId));
			String dataSource = "kafka";
			SysHbaseaddrEntity sysHbaseaddr = sysDbinfoncManager.getItemByhbaseType("DBPROXYRECIVE");
			try {
				String socketIP = sysHbaseaddr.getHbaseAddress();
				int socketPort = Integer.parseInt(sysHbaseaddr.getHbasePort());
				Socket socket = new Socket(socketIP,socketPort);
				PrintWriter os = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"),true);
				System.out.println(dbName+"***************************");
				os.println(dataSource);
				os.println(tableName);
				os.println(dbName);
			} catch(ConnectException e) {
				e.printStackTrace();
				return R.error("连接DBproxy失败，请联系管理员");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return R.error("打开接收开关失败，请联系管理员");
			}
			sysDbinfoncManager.updateIsRecevie(Integer.parseInt(tableInfoId),1);
			return R.ok();
		}
		else {
			//closeReceive
			sysDbinfoncManager.updateIsRecevie(Integer.parseInt(tableInfoId),0);
			return R.ok();
		}
	} 
	
	@Override
	public R removeTable(Long[] tableInfoId) {
		// TODO Auto-generated method stub
		
		sysDataTableService.remove_TableInfo(tableInfoId);
		
		sysTableStructureService.remove_IndexInfo(tableInfoId);
		
		int count = sysDbinfoncManager.remove_TableRecord(tableInfoId);
		return CommonUtils.msg(tableInfoId,count);
	}

}
