package net.DianC.dp.shiro.manager;

import java.util.List;

import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysDataTableEntity;

public interface SysDataTableManager {
	
	List<SysDataTableEntity> listDataTable(Query query);
	
	List<SysDataTableEntity> listDataTable();

	int remove_TableInfo(Long[] id);

}
