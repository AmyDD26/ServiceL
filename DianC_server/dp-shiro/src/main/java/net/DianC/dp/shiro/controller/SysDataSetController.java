package net.DianC.dp.shiro.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.DianC.dp.common.controller.AbstractController;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.service.SysDataSetService;

/**
 * 设备组controller
 * @author niulijie
 *
 */
@RestController
@RequestMapping("/sys/dataset")
public class SysDataSetController extends AbstractController{
	
	@Resource
	private SysDataSetService sysDataSetService;
	
	@RequestMapping("/list")
	public R listDataSet() {
		return sysDataSetService.listDataSet();
	}
	
//	@RequestMapping("/save")
//	public R save(@RequestBody SysDataSetEntity dataSet) {
//		return sysDataSetService.saveDataSet(dataSet);
//	}
}
