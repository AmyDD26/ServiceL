package net.DianC.dp.shiro.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.DianC.dp.common.controller.AbstractController;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.TableStructurezTreeEntity;
import net.DianC.dp.shiro.service.SysDataTableService;
import net.DianC.dp.shiro.service.SysTableStructureService;

@RestController
@RequestMapping("/sys/datatable")
public class SysDataTableController extends AbstractController{
	
	@Resource
	private SysDataTableService sysDataTableService;
	
	@Resource	
	private SysTableStructureService sysTableStructureService;
	
	@RequestMapping("/list")
	public R listDataTable() {
		return sysDataTableService.listDataTable();
	}
	
	@RequestMapping("/get")
	public List<TableStructurezTreeEntity> getDataTable(String dbInfoID) {
		System.out.println("dbInfoID:"+dbInfoID);
		return sysTableStructureService.getDataTable(dbInfoID);
	}
}