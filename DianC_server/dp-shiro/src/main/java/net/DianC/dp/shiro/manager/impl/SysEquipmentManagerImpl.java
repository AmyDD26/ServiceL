package net.DianC.dp.shiro.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysEquipmentEntity;
import net.DianC.dp.shiro.manager.SysEquipmentManager;
import net.DianC.dp.shiro.dao.SysEquipmentMapper;

@Component("sysEquipmentManager")
public class SysEquipmentManagerImpl implements SysEquipmentManager{

	@Autowired
	private SysEquipmentMapper sysEquipmentMapper;
	
	@Override
	public List<SysEquipmentEntity> listEquipment(Query query) {
		// TODO Auto-generated method stub
		return sysEquipmentMapper.list(query);
	}

	@Override
	public List<SysEquipmentEntity> listForPage(Page<SysEquipmentEntity> page, Query query) {
		// TODO Auto-generated method stub
		return sysEquipmentMapper.listForPage(page, query);
	}

	@Override
	public int saveEquipment(SysEquipmentEntity equipment) {
		
		return sysEquipmentMapper.save(equipment);
	}

	@Override
	public SysEquipmentEntity getEquipmentById(Long id) {
		// TODO Auto-generated method stub
		return sysEquipmentMapper.getObjectById(id);
	}

	@Override
	public int updateEquipment(SysEquipmentEntity equipment) {
		// TODO Auto-generated method stub
		return sysEquipmentMapper.update(equipment);
	}

	@Override
	public int batchRemove(Long[] id) {
		// TODO Auto-generated method stub
		return sysEquipmentMapper.batchRemove(id);
	}

}
