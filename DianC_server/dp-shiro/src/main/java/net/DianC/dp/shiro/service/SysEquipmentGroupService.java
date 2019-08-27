package net.DianC.dp.shiro.service;

import java.util.Map;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysEquipmentGroupEntity;

/**
 * 设备组Service
 * @author niulijie
 *
 */
public interface SysEquipmentGroupService {

	Page<SysEquipmentGroupEntity> listEquipmentGroup(Map<String, Object> params);

	R saveEquipmentGroup(SysEquipmentGroupEntity equipmentgroup);

	R batchRemove(Long[] id);

	R getEquipmentGroupById(Long id);

	R updateEquipmentGroup(SysEquipmentGroupEntity equipmentGroup);
	
}
