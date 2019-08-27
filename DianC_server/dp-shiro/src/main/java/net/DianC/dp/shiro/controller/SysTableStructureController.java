package net.DianC.dp.shiro.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.DianC.dp.common.annotation.SysLog;
import net.DianC.dp.common.controller.AbstractController;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysOrgEntity;
import net.DianC.dp.shiro.entity.SysTableStructureEntity;
import net.DianC.dp.shiro.entity.SysTableinfoEntity;
import net.DianC.dp.shiro.entity.TableStructurezTreeEntity;
import net.DianC.dp.shiro.service.SysTableStructureService;

/**
 * @author zhangk
 *表结构controller
 */

@RestController
@RequestMapping("/sys/tablestructure")
public class SysTableStructureController extends AbstractController{

	@Resource
	private SysTableStructureService sysTableStructureService;
	
	/**
	 * 树形机构列表，机构新增、编辑
	 * @return
	 */
	@RequestMapping("/select")
	public List<TableStructurezTreeEntity> getTableStructurezTree(String dbInfoID,String dbName) {
		return sysTableStructureService.getTableStructurezTree(dbInfoID,dbName);
	}
	
/*	@SysLog("sync_Tablestructure")
	@RequestMapping("/sync")
	public R syncTableStructure(@RequestBody Map<String, Object> params) throws IOException {
		返回参数为dbinfoId，格式{"dbinfoId","001"}
		return sysTableStructureService.syncTableStructure(params);
	}*/
	
	@RequestMapping("/list")
	public Page<SysTableStructureEntity> listTableStructure(@RequestBody Map<String, Object> params) {
		return sysTableStructureService.listTableStructure(params);
	}
	@SysLog("save_Tablestructure")
	@RequestMapping("/save")
	public R saveTableStructure(@RequestBody SysTableStructureEntity tablestructure) {
		return sysTableStructureService.saveTableStructure(tablestructure);
	}
	@SysLog("update_Tablestructure")
	@RequestMapping("/update")
	public R updateTableStructure(@RequestBody SysTableStructureEntity tablestructure) {
		return sysTableStructureService.updateTableStructure(tablestructure);
	}
	@RequestMapping("/info")
	public R infoTableStructure(@RequestBody Long id) {
		System.out.println(id);
		return sysTableStructureService.getTableStructureById(id);
	}
	@SysLog("remove_Tablestructure")
	@RequestMapping("/remove")
	public R removeTableStructure(@RequestBody Long[] id) {
		//System.out.println("systable control:"+id);
		return sysTableStructureService.batchRemove(id);
	}
	
	@SysLog("save_Table")
	@RequestMapping("/save_table")
	public R saveTable(@RequestBody SysTableinfoEntity tableinfo) {
		return sysTableStructureService.saveTable(tableinfo);
	}
	
	/*
	@RequestMapping("/removeIndexInfo")
	public R removeIndexInfo(@RequestBody int tableInfoId, String columName) {
		return sysTableStructureService.removeIndexInfo(tableInfoId, columName);
	}
	*/
	
}
