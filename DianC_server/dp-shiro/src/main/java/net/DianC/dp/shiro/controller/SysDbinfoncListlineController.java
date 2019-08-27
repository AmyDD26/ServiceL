package net.DianC.dp.shiro.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import net.DianC.dp.common.controller.AbstractController;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.shiro.entity.SysDbinfoQueryEntity;
import net.DianC.dp.shiro.entity.SysDbinfoncListlineEntity;
import net.DianC.dp.shiro.entity.TableStructurezTreeEntity;
import net.DianC.dp.shiro.service.SysDbinfoncListlineService;

@RestController
@RequestMapping("/sys/dbinfoncListline")
public class SysDbinfoncListlineController extends AbstractController{
	
	@Resource
	private SysDbinfoncListlineService sysDbinfoncListlineService;
	
	@RequestMapping("/listline")
	public Page<SysDbinfoncListlineEntity> listDbinfoncListline(@RequestBody Map<String, Object> params) {
		return sysDbinfoncListlineService.listSysDbinfoncListline(params);
	}

	@RequestMapping("/listtree")
	public List<TableStructurezTreeEntity> ListlineTree(){
		return sysDbinfoncListlineService.ListlineTree();
	}
	@RequestMapping("/query")
	public Page<SysDbinfoQueryEntity> sendSQLSocket(@RequestBody Map<String, Object> params) throws IOException {
		return sysDbinfoncListlineService.sendSQLSocket(params);
	}
}
