package net.DianC.dp.shiro.service;

import java.util.List;
import java.util.Map;

import net.DianC.dp.shiro.entity.SysDbinfoEntity;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysDbinfoEntity;
import net.DianC.dp.shiro.entity.SysEquipmentEntity;

/**
 * 设备Service
 * @author niulijie
 *
 */
public interface SysDbinfoService {

	/*List<SysDbinfoEntity> listDbinfoByParentCode(String dbinfoCode);     //////////////////////////
	
	R listDbinfoByParentCode(Map<String, Object> params);  */      /////////////////////////
	
	Page<SysDbinfoEntity> listDbinfo(Map<String, Object> params);

	R saveDbinfo(SysDbinfoEntity dbinfo);
	
	
	R getDbinfoById(Long id);//

	R udpateDbinfo(SysDbinfoEntity dbinfo);//
	
	R batchRemove(Long[] id);        //

	
	
}




