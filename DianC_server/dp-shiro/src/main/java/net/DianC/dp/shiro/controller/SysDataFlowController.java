package net.DianC.dp.shiro.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.DianC.dp.common.controller.AbstractController;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.service.SysDataFlowService;

/**
 * 设备组controller
 * @author niulijie
 *
 */
@RestController
@RequestMapping("/sys/dataflow")
public class SysDataFlowController extends AbstractController{
	
	@Resource
	private SysDataFlowService sysDataFlowService;
	
	@RequestMapping("/list")
	public R listDataFlow() {
		return sysDataFlowService.listDataFlow();
	}
	
//	@RequestMapping("/save")
//	public R save(@RequestBody SysDataSetEntity dataSet) {
//		return sysDataSetService.saveDataSet(dataSet);
//	}
}
