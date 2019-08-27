package net.DianC.dp.shiro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.DianC.dp.shiro.entity.SysDbinfoEntity;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.common.utils.CommonUtils;
import net.DianC.dp.shiro.entity.SysDbinfoEntity;
import net.DianC.dp.shiro.entity.SysEquipmentEntity;
import net.DianC.dp.shiro.entity.SysTableinfoEntity;
import net.DianC.dp.shiro.manager.SysDbinfoManager;
import net.DianC.dp.shiro.manager.SysEquipmentManager;
import net.DianC.dp.shiro.manager.SysTableinfoManager;
import net.DianC.dp.shiro.service.SysDbinfoService;

@Service("sysDbinfoService")
public class SysDbinfoServiceImpl implements SysDbinfoService{

	@Autowired
	private SysDbinfoManager sysDbinfoManager; //B
	//@Autowired
	//private SysTableinfoManager sysTableinfoManager;
	
	@Override
	public Page<SysDbinfoEntity> listDbinfo(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query query = new Query(params);
		Page<SysDbinfoEntity> page = new Page<SysDbinfoEntity>(query);
		sysDbinfoManager.listForPage(page, query);
		return page;
	}

	@Override
	public R saveDbinfo(SysDbinfoEntity dbinfo) {//Map<String, Object> params
		//SysDbinfoEntity dbinfo = (SysDbinfoEntity) params.get("dbinfo");
		//SysTableinfoEntity tableinfo = (SysTableinfoEntity) params.get("tableInfo");
		int count = sysDbinfoManager.saveDbinfo(dbinfo);
		return CommonUtils.msg(count);
	}
	
	
	
	@Override
	public R getDbinfoById(Long id) {
		// TODO Auto-generated method stub
		SysDbinfoEntity dbinfo = sysDbinfoManager.getDbinfoById(id);
		return CommonUtils.msg(dbinfo);
	}             //

	@Override
	public R udpateDbinfo(SysDbinfoEntity dbinfo) {
		int count = sysDbinfoManager.updateDbinfo(dbinfo);
		return CommonUtils.msg(count);
	}            //
	@Override
	public R batchRemove(Long[] id) {
		int count = sysDbinfoManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}  
	
	
	///////////////////////////////////////////
	/*@Override
	public R listDbinfoByParentCode(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysDbinfoEntity> areas = sysDbinfoManager.listDbinfoByParentCode(query);
		return CommonUtils.msg(areas);
	}*/
	///////////////////////////////////////////

	/*@Override
	public List<SysDbinfoEntity> listDbinfoByParentCode(String dbinfoCode) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
	
}

