package net.DianC.dp.shiro.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.common.utils.CommonUtils;
import net.DianC.dp.shiro.entity.SysEquipmentEntity;
import net.DianC.dp.shiro.manager.SysEquipmentManager;
import net.DianC.dp.shiro.service.SysEquipmentService;

@Service("sysEquipmentService")
public class SysEquipmentServiceImpl implements SysEquipmentService{

	@Autowired
	private SysEquipmentManager sysEquipmentManager;
	
	@Override
	public Page<SysEquipmentEntity> listEquipment(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query query = new Query(params);
		Page<SysEquipmentEntity> page = new Page<SysEquipmentEntity>(query);
		sysEquipmentManager.listForPage(page, query);
		return page;
	}             //

	@Override
	public R saveEquipment(SysEquipmentEntity equipment) {
		int count = sysEquipmentManager.saveEquipment(equipment);
		return CommonUtils.msg(count);
	}             //

	@Override
	public R getEquipmentById(Long id) {
		// TODO Auto-generated method stub
		SysEquipmentEntity equipment = sysEquipmentManager.getEquipmentById(id);
		return CommonUtils.msg(equipment);
	}             //

	@Override
	public R udpateEquipment(SysEquipmentEntity equipment) {
		int count = sysEquipmentManager.updateEquipment(equipment);
		return CommonUtils.msg(count);
	}            //

	@Override
	public R batchRemove(Long[] id) {
		int count = sysEquipmentManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}            //

}
