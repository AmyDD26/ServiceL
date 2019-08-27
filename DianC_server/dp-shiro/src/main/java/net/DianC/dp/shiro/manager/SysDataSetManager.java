package net.DianC.dp.shiro.manager;

import java.util.List;

import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysDataSetEntity;

public interface SysDataSetManager {

	List<SysDataSetEntity> listDataSet(Query query);

//	int saveDataSet(SysWrapperEntity wrapper);

	List<SysDataSetEntity> listDataSet();


}
