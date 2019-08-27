package net.DianC.dp.shiro.service;

import java.util.Map;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
//import net.DianC.dp.shiro.entity.SysEquipmentEntity;
import net.DianC.dp.shiro.entity.SysHbaseaddrEntity;
/**
 * 设备Service
 * @author zhangk
 *
 */
public interface SysHbaseaddrService {
	
	Page<SysHbaseaddrEntity> listHbaseaddr(Map<String, Object> params);

	R saveHbaseaddr(SysHbaseaddrEntity hbaseaddr);
	
	R getHbaseaddrById(Long id);
	
	R udpateHbaseaddr(SysHbaseaddrEntity hbaseaddr);

	R batchRemove(Long[] id);
	
	SysHbaseaddrEntity getItemByhbaseType(String hbaseType);
}
