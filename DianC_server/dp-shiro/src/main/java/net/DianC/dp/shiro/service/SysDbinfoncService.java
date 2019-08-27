package net.DianC.dp.shiro.service;

import java.util.Map;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysDbinfoncEntity;

public interface SysDbinfoncService {
	
	Page<SysDbinfoncEntity> listDbinfonc(Map<String, Object> params);

	R sendReceiveToDBproxy(String tableInfoId, String tableName);

	R removeTable(Long[] tableInfoId);


}
