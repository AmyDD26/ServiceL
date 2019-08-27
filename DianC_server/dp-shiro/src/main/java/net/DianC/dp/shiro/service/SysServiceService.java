package net.DianC.dp.shiro.service;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysServiceEntity;

import java.util.Map;

public interface SysServiceService {
	
	Page<SysServiceEntity> listService(Map<String, Object> params);

	R saveService(SysServiceEntity dbinfo);
	
	R getServiceById(Long id);

	R udpateService(SysServiceEntity dbinfo);
	
	R batchRemove(Long[] id);

	/*
	 * @Author zhy
	 * @Date 2019/08/26
	 * */
	R serviceTypeAll();
}
