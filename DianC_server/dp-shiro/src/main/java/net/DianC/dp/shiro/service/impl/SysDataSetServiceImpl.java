package net.DianC.dp.shiro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysDataSetEntity;
import net.DianC.dp.shiro.manager.SysDataSetManager;
import net.DianC.dp.shiro.service.SysDataSetService;

@Service("sysDataSetService")
public class SysDataSetServiceImpl implements SysDataSetService{
	
	@Autowired
	private SysDataSetManager sysDataSetManager;

	@Override
	public R listDataSet(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysDataSetEntity> dataSetList = sysDataSetManager.listDataSet(query);
		return R.ok().put("dataSetList", dataSetList);
	}

//	@Override
//	public R saveWrapper(SysWrapperEntity wrapper) {
//		int count = sysWrapperManager.saveWrapper(wrapper);
//		return CommonUtils.msg(count);
//	}

	@Override
	public R listDataSet() {
		List<SysDataSetEntity> dataSetList = sysDataSetManager.listDataSet();
		return R.ok().put("dataSetList", dataSetList);
	}

}
