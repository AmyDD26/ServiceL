package net.DianC.dp.shiro.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.DianC.dp.common.controller.AbstractController;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysDbinfoncEntity;
import net.DianC.dp.shiro.service.SysDbinfoncService;

@RestController
@RequestMapping("/sys/dbinfonc")

public class SysDbinfoncController extends AbstractController{
	
	@Resource
	private SysDbinfoncService sysDbinfoncService;
	
	@RequestMapping("/list")
	public Page<SysDbinfoncEntity> listDbinfonc(@RequestBody Map<String, Object> params) {
		return sysDbinfoncService.listDbinfonc(params);
	}
	@RequestMapping("/sendreceive")
	public R sendReceiveToDBproxy(String tableInfoId, String tableName) {
		return sysDbinfoncService.sendReceiveToDBproxy(tableInfoId, tableName);
	}
	@RequestMapping("/remove")
	public R removeTable(@RequestBody Long[]  tableInfoId) {
		return sysDbinfoncService.removeTable(tableInfoId);
	}
}
