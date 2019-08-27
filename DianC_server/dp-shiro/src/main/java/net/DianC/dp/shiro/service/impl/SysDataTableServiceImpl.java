package net.DianC.dp.shiro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.common.utils.CommonUtils;
import net.DianC.dp.shiro.entity.SysDataTableEntity;
import net.DianC.dp.shiro.manager.SysDataTableManager;
import net.DianC.dp.shiro.service.SysDataTableService;

@Service("sysDataTableService")
public class SysDataTableServiceImpl implements SysDataTableService{
	
	@Autowired
	private SysDataTableManager sysDataTableManager;
	
	@Override
	public R listDataTable(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysDataTableEntity> dataTableList = sysDataTableManager.listDataTable(query);
		return R.ok().put("dataTableList", dataTableList);
	}
	 
	@Override
	public R listDataTable() {
		List<SysDataTableEntity> dataTableList = sysDataTableManager.listDataTable();
		return R.ok().put("dataTableList", dataTableList);
	}
	@Override
	public R remove_TableInfo(Long[] id) {
		// TODO Auto-generated method stub
		int count = sysDataTableManager.remove_TableInfo(id);
		return CommonUtils.msg(id, count);
	}

}
