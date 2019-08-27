package net.DianC.dp.shiro.controller;

import net.DianC.dp.common.annotation.SysLog;
import net.DianC.dp.common.controller.AbstractController;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysServiceEntity;
import net.DianC.dp.shiro.service.SysServiceService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/sys/service")
public class SysServiceController extends AbstractController{
	
	@Resource
	private  SysServiceService sysServiceService;
	
	@RequestMapping("/list")
	public Page<SysServiceEntity> listService(@RequestBody Map<String, Object> params) {
		return sysServiceService.listService(params);
	}
	
	@SysLog("新增服务")
	@RequestMapping("save")
    @Transactional(propagation = Propagation.REQUIRED)
	public R saveService(@RequestBody SysServiceEntity service) {
		return sysServiceService.saveService(service);
	}
	
	@RequestMapping("info")
	public R info(@RequestBody Long id) {
		return sysServiceService.getServiceById(id);
	}

	@SysLog("修改服务")
	@RequestMapping("update")
	public R updateService(@RequestBody SysServiceEntity service) {
		System.out.println(service.getApiName()+"的身份验证有：" + service.getAuthenticationModel());
		System.out.println(service.getApiName()+"的身份验证有：" + service.getAuthenticationModel().get(0));
		return sysServiceService.udpateService(service);
	}
	@SysLog("删除服务")
	@RequestMapping("/remove")
	public R remove(@RequestBody Long[] id) {
		return sysServiceService.batchRemove(id);
	}


	/*
	* @Author zhy
	* @Date 2019/08/26
	* */
	@SysLog("服务类型")
	@RequestMapping("/serviceTypeAll")
	public R serviceTypeAll() {
		return sysServiceService.serviceTypeAll();
	}

}
