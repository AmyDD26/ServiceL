package net.DianC.dp.shiro.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysDbinfoEntity;
import net.DianC.dp.shiro.entity.SysEquipmentEntity;
import net.DianC.dp.shiro.manager.SysDbinfoManager;
import net.DianC.dp.shiro.dao.SysDbinfoMapper;

@Component("sysDbinfoManager")
public class SysDbinfoManagerImpl implements SysDbinfoManager{

	@Autowired
	private SysDbinfoMapper sysDbinfoMapper;

	
	@Override
	public List<SysDbinfoEntity> listDbinfo(Query query) {
		// TODO Auto-generated method stub
		return sysDbinfoMapper.list(query);
	}
	
	
	@Override
	public List<SysDbinfoEntity> listForPage(Page<SysDbinfoEntity> page, Query query) {
		// TODO Auto-generated method stub
		return sysDbinfoMapper.listForPage(page, query);
	}

	@Override
	public int saveDbinfo(SysDbinfoEntity dbinfo) {
		// TODO Auto-generated method stub
		return sysDbinfoMapper.save(dbinfo);
	}
	
	
	@Override
	public SysDbinfoEntity getDbinfoById(Long id) {
		// TODO Auto-generated method stub
		return sysDbinfoMapper.getObjectById(id);
	}

	@Override
	public int updateDbinfo(SysDbinfoEntity dbinfo) {
		// TODO Auto-generated method stub
		return sysDbinfoMapper.update(dbinfo);
	}
	@Override
	public int batchRemove(Long[] id) {
		// TODO Auto-generated method stub
		return sysDbinfoMapper.batchRemove(id);
	}

	/*@Override
	public List<SysDbinfoEntity> listDbinfo(Query query) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
	
	////////////////////////////////////////////
	/*@Override
	public List<SysDbinfoEntity> listDbinfoByParentCode(Query query) {
		return sysDbinfoMapper.listDbinfoByParentCode(query);
	}*/
	///////////////////////////////////////////
	
	
	
	
}
