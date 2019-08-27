package net.DianC.dp.shiro.service;

import java.util.Map;

import net.DianC.dp.common.entity.R;

public interface SysDataTableService {
	
	R listDataTable(Map<String, Object> params);
	
	R listDataTable();
	
	//R getDataTable();

	R remove_TableInfo(Long[] tableInfoId);

}
