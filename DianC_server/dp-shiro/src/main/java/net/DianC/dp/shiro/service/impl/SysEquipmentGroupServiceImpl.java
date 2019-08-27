package net.DianC.dp.shiro.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.common.entity.SysUserEntity;
import net.DianC.dp.common.utils.CommonUtils;
import net.DianC.dp.common.utils.ShiroUtils;
import net.DianC.dp.shiro.entity.SysEquipmentGroupEntity;
import net.DianC.dp.shiro.manager.SysEquipmentGroupManager;
import net.DianC.dp.shiro.service.SysEquipmentGroupService;

@Service("sysEquipmentGroupService")
public class SysEquipmentGroupServiceImpl implements SysEquipmentGroupService{

	@Autowired
	private SysEquipmentGroupManager sysEquipmentGroupManager;
	
	@Override
	public Page<SysEquipmentGroupEntity> listEquipmentGroup(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query query = new Query(params);
		Page<SysEquipmentGroupEntity> page = new Page<SysEquipmentGroupEntity>(query);
		sysEquipmentGroupManager.listForPage(page, query);
		return page;
	}

	@Override
	public R saveEquipmentGroup(SysEquipmentGroupEntity equipmentgroup) {
		//用户名
		SysUserEntity currUser = ShiroUtils.getUserEntity();
		if(CommonUtils.isNullOrEmpty(currUser)) {
			equipmentgroup.setCreater("");
		} else {
			equipmentgroup.setCreater(currUser.getUsername());
		}
		int count = sysEquipmentGroupManager.saveEquipmentGroup(equipmentgroup);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = sysEquipmentGroupManager.batchRemove(id);
		return CommonUtils.msg(count);
	}

	@Override
	public R getEquipmentGroupById(Long id) {
		SysEquipmentGroupEntity equipmentGroup = sysEquipmentGroupManager.getEquipmentGroupById(id);
		return CommonUtils.msg(equipmentGroup);
	}

	@Override
	public R updateEquipmentGroup(SysEquipmentGroupEntity equipmentGroup) {
		int count = sysEquipmentGroupManager.updateEquipmentGroup(equipmentGroup);
		return CommonUtils.msg(count);
	}

}
