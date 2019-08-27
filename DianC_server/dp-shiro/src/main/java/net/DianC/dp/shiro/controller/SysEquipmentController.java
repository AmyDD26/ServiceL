package net.DianC.dp.shiro.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.DianC.dp.common.annotation.SysLog;
import net.DianC.dp.common.controller.AbstractController;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysEquipmentEntity;
import net.DianC.dp.shiro.service.SysEquipmentService;

/**
 * 设备组controller
 * @author niulijie
 *
 */
@RestController
@RequestMapping("/sys/equipment")
public class SysEquipmentController extends AbstractController{
	
	@Resource
	private SysEquipmentService sysEquipmentService;
	
	@RequestMapping("/list")
	public Page<SysEquipmentEntity> listEquipment(@RequestBody Map<String, Object> params) {
		return sysEquipmentService.listEquipment(params);
	}
	
	@RequestMapping("save")
	public R saveEquioment(@RequestBody SysEquipmentEntity equipment) {
		equipment.setInTime(new Timestamp(new Date().getTime()));/////
		return sysEquipmentService.saveEquipment(equipment);
	}
	
	@RequestMapping("info")
	public R info(@RequestBody Long id) {
		return sysEquipmentService.getEquipmentById(id);
	}
	
	@RequestMapping("update")
	public R updateEquioment(@RequestBody SysEquipmentEntity equipment) {
		return sysEquipmentService.udpateEquipment(equipment);
	}
	
	@SysLog("删除设备")
	@RequestMapping("/remove")
	public R remove(@RequestBody Long[] id) {
		return sysEquipmentService.batchRemove(id);
	} 
}
