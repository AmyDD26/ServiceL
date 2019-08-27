package net.DianC.dp.shiro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysDataFlowEntity;
import net.DianC.dp.shiro.manager.SysDataFlowManager;
import net.DianC.dp.shiro.service.SysDataFlowService;

@Service("sysDataFlowService")
public class SysDataFlowServiceImpl implements SysDataFlowService{
	
	@Autowired
	private SysDataFlowManager sysDataFlowManager;

	@Override
	public R listDataFlow(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysDataFlowEntity> dataFlowList = sysDataFlowManager.listDataFlow(query);
		return R.ok().put("dataFlowList", dataFlowList);
	}

//	@Override
//	public R saveWrapper(SysWrapperEntity wrapper) {
//		int count = sysWrapperManager.saveWrapper(wrapper);
//		return CommonUtils.msg(count);
//	}

	@Override
	public R listDataFlow() {
		List<SysDataFlowEntity> dataFlowList = sysDataFlowManager.listDataFlow();
		return R.ok().put("dataFlowList", dataFlowList);
	}

}
