package net.DianC.dp.shiro.manager;

import java.util.List;

import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysDataFlowEntity;

public interface SysDataFlowManager {

	List<SysDataFlowEntity> listDataFlow(Query query);

//	int saveDataSet(SysWrapperEntity wrapper);

	List<SysDataFlowEntity> listDataFlow();


}
