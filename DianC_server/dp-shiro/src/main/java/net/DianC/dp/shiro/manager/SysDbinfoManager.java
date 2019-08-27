package net.DianC.dp.shiro.manager;

import java.util.List;
import java.util.Map;

import net.DianC.dp.shiro.entity.SysDbinfoEntity;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysDbinfoEntity;
import net.DianC.dp.shiro.entity.SysEquipmentEntity;

public interface SysDbinfoManager {
	
	//List<SysDbinfoEntity> listDbinfoByParentCode(Query query);
	
	List<SysDbinfoEntity> listDbinfo(Query query);

	List<SysDbinfoEntity> listForPage(Page<SysDbinfoEntity> page, Query query);

	int saveDbinfo(SysDbinfoEntity dbinfo);
	
	SysDbinfoEntity getDbinfoById(Long id);

	int updateDbinfo(SysDbinfoEntity dbinfo);
	
	int batchRemove(Long[] id);

}
