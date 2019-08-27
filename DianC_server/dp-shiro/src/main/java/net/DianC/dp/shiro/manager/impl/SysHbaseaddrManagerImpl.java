package net.DianC.dp.shiro.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.dao.SysHbaseaddrMapper;
import net.DianC.dp.shiro.entity.SysHbaseaddrEntity;
import net.DianC.dp.shiro.manager.SysHbaseaddrManager;
/**
 * 数据集
 * @author zhangk
 *
 */
@Component("sysHbaseaddrManager")
public class SysHbaseaddrManagerImpl implements SysHbaseaddrManager{

	@Autowired
	private SysHbaseaddrMapper sysHbaseaddrMapper;
	
	@Override
	public List<SysHbaseaddrEntity> listHbaseaddr(Query query) {
		// TODO Auto-generated method stub
		return sysHbaseaddrMapper.list(query);
	}
	@Override
	public List<SysHbaseaddrEntity> listForPage(Page<SysHbaseaddrEntity> page, Query query) {
		// TODO Auto-generated method stub
		return sysHbaseaddrMapper.listForPage(page, query);
	}

	@Override
	public int saveHbaseaddr(SysHbaseaddrEntity hbaseaddr) {
		// TODO Auto-generated method stub
		return sysHbaseaddrMapper.save(hbaseaddr);
	}

	@Override
	public SysHbaseaddrEntity getHbaseaddrById(Long id) {
		// TODO Auto-generated method stub
		return sysHbaseaddrMapper.getObjectById(id);
	}

	@Override
	public int updateHbaseaddr(SysHbaseaddrEntity hbaseaddr) {
		// TODO Auto-generated method stub
		return sysHbaseaddrMapper.update(hbaseaddr);
	}

	@Override
	public int batchRemove(Long[] id) {
		// TODO Auto-generated method stub
		return sysHbaseaddrMapper.batchRemove(id);
	}
	@Override
	public SysHbaseaddrEntity getItemByhbaseType(String hbaseType) {
		// TODO Auto-generated method stub
		return sysHbaseaddrMapper.getItemByhbaseType(hbaseType);
	}

}
