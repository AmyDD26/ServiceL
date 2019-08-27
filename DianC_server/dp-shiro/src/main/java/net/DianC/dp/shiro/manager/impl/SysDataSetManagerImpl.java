package net.DianC.dp.shiro.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysDataSetEntity;
import net.DianC.dp.shiro.manager.SysDataSetManager;
import net.DianC.dp.shiro.dao.SysDataSetMapper;

@Component("sysDataSetManager")
public class SysDataSetManagerImpl implements SysDataSetManager{

	@Autowired
	private SysDataSetMapper sysDataSetMapper;

	@Override
	public List<SysDataSetEntity> listDataSet(Query query) {
		// TODO Auto-generated method stub
		return sysDataSetMapper.list(query);
	}

//	@Override
//	public int saveDataSet(SysDataSetEntity wrapper) {
//		// TODO Auto-generated method stub
//		return sysWrapperMapper.save(wrapper);
//	}

	@Override
	public List<SysDataSetEntity> listDataSet() {
		// TODO Auto-generated method stub
		return sysDataSetMapper.list();
	}

}
