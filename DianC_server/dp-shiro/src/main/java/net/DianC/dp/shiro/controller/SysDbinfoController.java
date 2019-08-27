package net.DianC.dp.shiro.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.DianC.dp.shiro.entity.SysDbinfoEntity;
import net.DianC.dp.common.annotation.SysLog;
import net.DianC.dp.common.controller.AbstractController;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysDbinfoncListlineEntity;
import net.DianC.dp.shiro.entity.SysEquipmentEntity;
import net.DianC.dp.shiro.service.SysDbinfoService;
import net.DianC.dp.shiro.service.SysDbinfoncListlineService;
/**
 * 数据集controller
 * @author niulijie
 *
 */
@RestController
@RequestMapping("/sys/dbinfo")
public class SysDbinfoController extends AbstractController{
	
	@Resource
	private SysDbinfoService sysDbinfoService;
	
	@RequestMapping("/list")
	public Page<SysDbinfoEntity> listDbinfo(@RequestBody Map<String, Object> params) {
		return sysDbinfoService.listDbinfo(params);
	}
	
	/////////////////////////////////////////////////////////
	/*@RequestMapping("/select")
	public List<SysDbinfoEntity> select(@RequestParam String areaCode) {
		return sysDbinfoService.listDbinfoByParentCode(areaCode);
	}*/
	//////////////////////////////////////////////////////////
	
	
	

	/////////////////////////////////////////////////////////
	/*@RequestMapping("/select")
	public List<SysDbinfoEntity> select(@RequestParam String areaCode) {
		return sysDbinfoService.listDbinfoByParentCode(areaCode);
	}*/
	//////////////////////////////////////////////////////////

	@SysLog("新增数据集")
	@RequestMapping("/save")
	public R saveDbinfo(@RequestBody SysDbinfoEntity dbinfo) {
		return sysDbinfoService.saveDbinfo(dbinfo);
	}
	
	@RequestMapping("/info")
	public R info(@RequestBody Long id) {
		return sysDbinfoService.getDbinfoById(id);
	}

	@RequestMapping("/update")
	public R updateDbinfo(@RequestBody SysDbinfoEntity dbinfo) {
		return sysDbinfoService.udpateDbinfo(dbinfo);
	}
	@SysLog("删除设备")
	@RequestMapping("/remove")
	public R remove(@RequestBody Long[] id) {
		System.out.println("sysdbc ctrl: " +id);
		return sysDbinfoService.batchRemove(id);
	} 
	
}
