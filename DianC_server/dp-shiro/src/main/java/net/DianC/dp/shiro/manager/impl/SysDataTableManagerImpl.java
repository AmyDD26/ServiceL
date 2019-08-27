package net.DianC.dp.shiro.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.dao.SysDataTableMapper;
import net.DianC.dp.shiro.entity.SysDataTableEntity;
import net.DianC.dp.shiro.manager.SysDataTableManager;

@Component("sysDataTableManager")
public class SysDataTableManagerImpl implements SysDataTableManager{
	
	@Autowired
	private SysDataTableMapper sysDataTableMapper;

	@Override
	public List<SysDataTableEntity> listDataTable(Query query) {
		// TODO Auto-generated method stub
		return sysDataTableMapper.list(query);
	}
	
	@Override
	public List<SysDataTableEntity> listDataTable() {
		// TODO Auto-generated method stub
		return sysDataTableMapper.list();
	}
	@Override
	public int remove_TableInfo(Long[] id) {
		// TODO Auto-generated method stub
		return sysDataTableMapper.remove_TableInfo(id);
	}
}
