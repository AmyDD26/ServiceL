package net.DianC.dp.shiro.manager;

import java.util.List;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysEquipmentGroupEntity;

public interface SysEquipmentGroupManager {

	List<SysEquipmentGroupEntity> listEquipmentGroup(Query query);

	List<SysEquipmentGroupEntity> listForPage(Page<SysEquipmentGroupEntity> page, Query query);

	int saveEquipmentGroup(SysEquipmentGroupEntity equipmentgroup);

	int batchRemove(Long[] id);

	SysEquipmentGroupEntity getEquipmentGroupById(Long id);

	int updateEquipmentGroup(SysEquipmentGroupEntity equipmentGroup);

}
