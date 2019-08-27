package net.DianC.dp.shiro.manager;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysServiceEntity;

import java.util.List;

public interface SysServiceManager {
	
	List<SysServiceEntity> listService(Query query);

	List<SysServiceEntity> listForPage(Page<SysServiceEntity> page, Query query);

	int saveService(SysServiceEntity service);
	
	SysServiceEntity getServiceById(Long id);

	int updateService(SysServiceEntity service);
	
	int batchRemove(Long[] id);

	/*
	 * @Author zhy
	 * @Date 2019/08/26
	 * */
	List<String> serviceTypeAll();


}
