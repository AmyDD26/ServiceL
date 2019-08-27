package net.DianC.dp.shiro.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysDataFlowEntity;
import net.DianC.dp.shiro.manager.SysDataFlowManager;
import net.DianC.dp.shiro.dao.SysDataFlowMapper;

@Component("sysDataFlowManager")
public class SysDataFlowManagerImpl implements SysDataFlowManager{

	@Autowired
	private SysDataFlowMapper sysDataFlowMapper;

	@Override
	public List<SysDataFlowEntity> listDataFlow(Query query) {
		// TODO Auto-generated method stub
		return sysDataFlowMapper.list(query);
	}

//	@Override
//	public int saveDataSet(SysDataSetEntity wrapper) {
//		// TODO Auto-generated method stub
//		return sysWrapperMapper.save(wrapper);
//	}

	@Override
	public List<SysDataFlowEntity> listDataFlow() {
		// TODO Auto-generated method stub
		return sysDataFlowMapper.list();
	}

}
