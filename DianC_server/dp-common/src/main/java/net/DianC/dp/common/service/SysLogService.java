package net.DianC.dp.common.service;

import java.util.Map;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.common.entity.SysLogEntity;

/**
 * 系统日志
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月14日 下午8:40:52
 */
public interface SysLogService {

	Page<SysLogEntity> listLog(Map<String, Object> params);
	
	R batchRemove(Long[] id);
	
	R batchRemoveAll();
	
}
