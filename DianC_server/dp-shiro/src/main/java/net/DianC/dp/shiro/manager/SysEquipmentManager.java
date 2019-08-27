package net.DianC.dp.shiro.manager;

import java.util.List;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysEquipmentEntity;

public interface SysEquipmentManager {

	List<SysEquipmentEntity> listEquipment(Query query);

	List<SysEquipmentEntity> listForPage(Page<SysEquipmentEntity> page, Query query);

	int saveEquipment(SysEquipmentEntity equipment);

	SysEquipmentEntity getEquipmentById(Long id);

	int updateEquipment(SysEquipmentEntity equipment);

	int batchRemove(Long[] id);

}
