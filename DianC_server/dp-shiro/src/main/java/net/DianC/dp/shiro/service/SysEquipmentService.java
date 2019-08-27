package net.DianC.dp.shiro.service;

import java.util.Map;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysEquipmentEntity;

/**
 * 设备Service
 * @author niulijie
 *
 */
public interface SysEquipmentService {

	Page<SysEquipmentEntity> listEquipment(Map<String, Object> params);

	R saveEquipment(SysEquipmentEntity equipment);

	R getEquipmentById(Long id);

	R udpateEquipment(SysEquipmentEntity equipment);

	R batchRemove(Long[] id);
	
}
