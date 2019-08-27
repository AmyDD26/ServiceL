package net.DianC.dp.shiro.service;

import java.util.Map;

import net.DianC.dp.common.entity.R;

public interface SysDataFlowService {

	R listDataFlow(Map<String, Object> params);

//	R saveWrapper(SysWrapperEntity wrapper);

	R listDataFlow();

}
