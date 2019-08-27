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
import net.DianC.dp.shiro.entity.SysHbaseaddrEntity;
import net.DianC.dp.shiro.service.SysHbaseaddrService;
/**
 * Hbaseaddr controller
 * @author zhangk
 *
 */
@RestController
@RequestMapping("/sys/hbaseaddr")
public class SysHbaseaddrController extends AbstractController {

	@Resource
	private SysHbaseaddrService sysHbaseaddrService;

	@RequestMapping("/list")
	public Page<SysHbaseaddrEntity> listHbaseaddr(@RequestBody Map<String, Object> params) {

		return sysHbaseaddrService.listHbaseaddr(params);
	}

	@SysLog("add_Hbaseaddr")
	@RequestMapping("/save")
	public R saveHbaseaddr(@RequestBody SysHbaseaddrEntity hbaseaddr) {
		//System.out.println(hbaseaddr.getHbaseAddress() + ":" + hbaseaddr.getHbasePort());
		return sysHbaseaddrService.saveHbaseaddr(hbaseaddr);
	}

	@RequestMapping("/info")
	public R info(@RequestBody Long id) {
		return sysHbaseaddrService.getHbaseaddrById(id);
	}

	@SysLog("update_Hbaseaddr")
	@RequestMapping("/update")
	public R updateHbaseaddr(@RequestBody SysHbaseaddrEntity hbaseaddr) {
		return sysHbaseaddrService.udpateHbaseaddr(hbaseaddr);
	}

	@SysLog("remove_Hbaseaddr")
	@RequestMapping("/remove")
	public R remove(@RequestBody Long[] id) {
		return sysHbaseaddrService.batchRemove(id);
	}
}