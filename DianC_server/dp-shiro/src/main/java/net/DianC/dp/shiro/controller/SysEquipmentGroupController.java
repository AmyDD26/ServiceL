package net.DianC.dp.shiro.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.DianC.dp.common.annotation.SysLog;
import net.DianC.dp.common.controller.AbstractController;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysEquipmentGroupEntity;
import net.DianC.dp.shiro.service.SysEquipmentGroupService;

/**
 * 设备组controller
 * @author niulijie
 *
 */
@RestController
@RequestMapping("/sys/equipmentgroup")
public class SysEquipmentGroupController extends AbstractController{
	
	@Resource
	private SysEquipmentGroupService sysEquipmentGroupService;
	
	@RequestMapping("/list")
	public Page<SysEquipmentGroupEntity> listEquipmentGroup(@RequestBody Map<String, Object> params) {
		return sysEquipmentGroupService.listEquipmentGroup(params);
	}
	
	@SysLog("新增设备组")
	@RequestMapping("/save")
	public R Save(@RequestBody SysEquipmentGroupEntity equipmentgroup) {
		return sysEquipmentGroupService.saveEquipmentGroup(equipmentgroup);
	} 
	
	/**
	 * 修改设备组
	 * @param menu
	 * @return
	 */
	@SysLog("修改设备组")
	@RequestMapping("/update")
	public R update(@RequestBody SysEquipmentGroupEntity equipmentGroup) {
		return sysEquipmentGroupService.updateEquipmentGroup(equipmentGroup);
	}
	
	@SysLog("删除设备组")
	@RequestMapping("/remove")
	public R Save(@RequestBody Long[] id) {
		return sysEquipmentGroupService.batchRemove(id);
	} 
	
	/**
	 * 查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R info(@RequestBody Long id) {
		return sysEquipmentGroupService.getEquipmentGroupById(id);
	}
}
