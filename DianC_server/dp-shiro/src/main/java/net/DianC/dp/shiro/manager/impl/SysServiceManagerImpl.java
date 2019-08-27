package net.DianC.dp.shiro.manager.impl;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.dao.SysServiceMapper;
import net.DianC.dp.shiro.entity.SysServiceEntity;
import net.DianC.dp.shiro.manager.SysServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("sysServiceManager")
public class SysServiceManagerImpl implements SysServiceManager{

	@Autowired
	private SysServiceMapper sysServiceMapper;

	@Override
	public List<SysServiceEntity> listService(Query query) {
		// TODO Auto-generated method stub
		return sysServiceMapper.list(query);
	}

	@Override
	public List<SysServiceEntity> listForPage(Page<SysServiceEntity> page, Query query) {
		// TODO Auto-generated method stub
		return sysServiceMapper.listForPage(page, query);
	}

	@Override
	public int saveService(SysServiceEntity service) {
		// TODO Auto-generated method stub
		return sysServiceMapper.save(service);
	}
	
	@Override
	public SysServiceEntity getServiceById(Long id) {
		// TODO Auto-generated method stub
		return sysServiceMapper.getObjectById(id);
	}

	@Override
	public int updateService(SysServiceEntity service) {
		// TODO Auto-generated method stub
		//-2147482646
//		System.out.println(service);
//		System.out.println(sysServiceMapper.update(service));
		return sysServiceMapper.update(service);
	}
	
	@Override
	public int batchRemove(Long[] id) {
		// TODO Auto-generated method stub
		return sysServiceMapper.batchRemove(id);
	}

	/*
	 * @Author zhy
	 * @Date 2019/08/26
	 * */
	@Override
	public List<String> serviceTypeAll() {
		// TODO Auto-generated method stub
		return sysServiceMapper.serviceTypeAll();
	}


}
