package net.DianC.dp.shiro.service;

import java.util.Map;

import net.DianC.dp.common.entity.R;

public interface SysDataSetService {

	R listDataSet(Map<String, Object> params);

//	R saveWrapper(SysWrapperEntity wrapper);

	R listDataSet();

}
