package net.DianC.dp.shiro.controller;

import net.DianC.dp.common.controller.AbstractController;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.shiro.entity.SysHbaseMoniAttrEntity;
import net.DianC.dp.shiro.entity.SysHbaseMoniRegInfoEntity;
import net.DianC.dp.shiro.entity.SysHbaseMoniRegServEntity;
import net.DianC.dp.shiro.entity.SysHbaseMoniTableEntity;
import net.DianC.dp.shiro.util.HbaseMonitorAction;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hbase环境监控Controller
 * @author zhangk
 *
 */

@RestController
@RequestMapping("/sys/hbasemoni")
public class SysHbaseMoniController extends AbstractController {
	
	@RequestMapping("/list_Hbasemoniattr")
	public Page<SysHbaseMoniAttrEntity> listHbasemoniattr() throws MasterNotRunningException, ZooKeeperConnectionException, IOException{
		List<SysHbaseMoniAttrEntity> attributesList = new ArrayList<SysHbaseMoniAttrEntity>();
		Page<SysHbaseMoniAttrEntity> page = new Page<SysHbaseMoniAttrEntity>();
		HbaseMonitorAction HMAction = new HbaseMonitorAction();
		attributesList = HMAction.getAttributes();
		page.setRows(attributesList);
		return page;
	}
	
	@RequestMapping("/list_Hbasemoniregserv")
	public Page<SysHbaseMoniRegServEntity> listHbasemoniregserv() throws MasterNotRunningException, ZooKeeperConnectionException, IOException, ParseException{
		List<SysHbaseMoniRegServEntity> serverList = new ArrayList<SysHbaseMoniRegServEntity>();
		Page<SysHbaseMoniRegServEntity> page = new Page<SysHbaseMoniRegServEntity>();
		HbaseMonitorAction HMAction = new HbaseMonitorAction();
		serverList = HMAction.getRegionServers();
		page.setRows(serverList);
		return page;
	}
	
	@RequestMapping("/list_Hbasemonireginfo")
	public Page<SysHbaseMoniRegInfoEntity> listHbasemonireginfo(String servername) throws MasterNotRunningException, ZooKeeperConnectionException, IOException, ParseException{
		List<SysHbaseMoniRegInfoEntity> regionList = new ArrayList<SysHbaseMoniRegInfoEntity>();
		Page<SysHbaseMoniRegInfoEntity> page = new Page<SysHbaseMoniRegInfoEntity>();
		HbaseMonitorAction HMAction = new HbaseMonitorAction();
		HMAction.setServername(servername);
		regionList = HMAction.getRegionInfo();
		page.setRows(regionList);
		return page;
	}
	
	@RequestMapping("/list_Hbasemonitable")
	public Page<SysHbaseMoniTableEntity> listHbasemonitable(){
		List<SysHbaseMoniTableEntity> tableList = new ArrayList<SysHbaseMoniTableEntity>();
		Page<SysHbaseMoniTableEntity> page = new Page<SysHbaseMoniTableEntity>();
		HbaseMonitorAction HMAction = new HbaseMonitorAction();
		tableList = HMAction.getTableInfo();
		page.setRows(tableList);
		return page;
	}
}
