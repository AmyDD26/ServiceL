package net.DianC.dp.shiro.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysDbinfoEntity;
import net.DianC.dp.shiro.entity.SysTableinfoEntity;
import net.DianC.dp.shiro.manager.SysDbinfoManager;
import net.DianC.dp.shiro.manager.SysTableinfoManager;
import net.DianC.dp.shiro.dao.SysDbinfoMapper;
import net.DianC.dp.shiro.dao.SysTableinfoMapper;

@Component("sysTableinfoManager")
public class SysTableinfoManagerImpl implements SysTableinfoManager{

	@Autowired
	private SysTableinfoMapper sysTableinfoMapper;

}
