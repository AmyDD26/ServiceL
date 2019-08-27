package net.DianC.dp.shiro.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.common.utils.CommonUtils;
import net.DianC.dp.shiro.entity.SysHbaseaddrEntity;
import net.DianC.dp.shiro.manager.SysHbaseaddrManager;
import net.DianC.dp.shiro.service.SysHbaseaddrService;

@Service("sysHbaseaddrService")
public class SysHbaseaddrServiceImpl implements SysHbaseaddrService {

	@Autowired
	private SysHbaseaddrManager sysHbaseaddrManager;
	@Override
	public Page<SysHbaseaddrEntity> listHbaseaddr(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query query = new Query(params);
		Page<SysHbaseaddrEntity> page = new Page<SysHbaseaddrEntity>(query);
		sysHbaseaddrManager.listForPage(page, query);
		return page;
	}

	@Override
	public R saveHbaseaddr(SysHbaseaddrEntity hbaseaddr) {
		// TODO Auto-generated method stub
		//SysHbaseaddrEntity hbaseaddr = (SysHbaseaddrEntity) params.get("hbaseaddr");
		int count = sysHbaseaddrManager.saveHbaseaddr(hbaseaddr);
		return CommonUtils.msg(count);
	}

	@Override
	public R getHbaseaddrById(Long id) {
		// TODO Auto-generated method stub
		SysHbaseaddrEntity hbaseaddr = sysHbaseaddrManager.getHbaseaddrById(id);
		return CommonUtils.msg(hbaseaddr);
	}

	@Override
	public R udpateHbaseaddr(SysHbaseaddrEntity hbaseaddr) {
		// TODO Auto-generated method stub
		int count = sysHbaseaddrManager.updateHbaseaddr(hbaseaddr);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		// TODO Auto-generated method stub
		int count = sysHbaseaddrManager.batchRemove(id);
		return CommonUtils.msg(id,count);
	}

	@Override
	public SysHbaseaddrEntity getItemByhbaseType(String hbaseType) {
		// TODO Auto-generated method stub
		return sysHbaseaddrManager.getItemByhbaseType(hbaseType);
	}

}
