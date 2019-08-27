package net.DianC.dp.shiro.service.impl;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.common.utils.CommonUtils;
import net.DianC.dp.shiro.entity.SysServiceEntity;
import net.DianC.dp.shiro.manager.SysServiceManager;
import net.DianC.dp.shiro.service.SysServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("sysServiceService")//
public class SysServiceServiceImpl implements SysServiceService{
	
	@Autowired
	private SysServiceManager sysServiceManager; 
	
	@Override
	public Page<SysServiceEntity> listService(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysServiceEntity> page = new Page<SysServiceEntity>(query);
		sysServiceManager.listForPage(page, query);
		return page;
	}

	@Override
	public R saveService(SysServiceEntity service) {
		int count = sysServiceManager.saveService(service);
		return CommonUtils.msg(count);
	}
	
	@Override
	public R getServiceById(Long id) {
		// TODO Auto-generated method stub
		SysServiceEntity service = sysServiceManager.getServiceById(id);
		return CommonUtils.msg(service);
	}

	@Override
	public R udpateService(SysServiceEntity service) {
		int count = sysServiceManager.updateService(service);
		return CommonUtils.msg(count);
	}
	@Override
	public R batchRemove(Long[] id) {
		int count = sysServiceManager.batchRemove(id);
		System.out.println("count" + count);
		System.out.println(id);
		return CommonUtils.msg(id, count);
	}

	/*
	 * @Author zhy
	 * @Date 2019/08/26
	 * */
	@Override
	public R serviceTypeAll() {
		List<String> list = sysServiceManager.serviceTypeAll();
		return R.ok().put("dataFlowList", list);
	}

}
