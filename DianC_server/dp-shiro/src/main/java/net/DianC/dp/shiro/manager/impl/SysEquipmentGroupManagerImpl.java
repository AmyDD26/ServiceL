package net.DianC.dp.shiro.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysEquipmentGroupEntity;
import net.DianC.dp.shiro.manager.SysEquipmentGroupManager;
import net.DianC.dp.shiro.dao.SysEquipmentGroupMapper;

@Component("sysEquipmentGroupManager")
public class SysEquipmentGroupManagerImpl implements SysEquipmentGroupManager{

	@Autowired
	private SysEquipmentGroupMapper sysEquipmentGroupMapper;
	
	@Override
	public List<SysEquipmentGroupEntity> listEquipmentGroup(Query query) {
		// TODO Auto-generated method stub
		return sysEquipmentGroupMapper.list(query);
	}

	@Override
	public List<SysEquipmentGroupEntity> listForPage(Page<SysEquipmentGroupEntity> page, Query query) {
		// TODO Auto-generated method stub
		return sysEquipmentGroupMapper.listForPage(page, query);
	}

	@Override
	public int saveEquipmentGroup(SysEquipmentGroupEntity equipmentgroup) {
		return sysEquipmentGroupMapper.save(equipmentgroup);
	}

	@Override
	public int batchRemove(Long[] id) {
		// TODO Auto-generated method stub
		return sysEquipmentGroupMapper.batchRemove(id);
	}

	@Override
	public SysEquipmentGroupEntity getEquipmentGroupById(Long id) {
		// TODO Auto-generated method stub
		return sysEquipmentGroupMapper.getObjectById(id);
	}

	@Override
	public int updateEquipmentGroup(SysEquipmentGroupEntity equipmentGroup) {
		// TODO Auto-generated method stub
		return sysEquipmentGroupMapper.update(equipmentGroup);
	}

}
