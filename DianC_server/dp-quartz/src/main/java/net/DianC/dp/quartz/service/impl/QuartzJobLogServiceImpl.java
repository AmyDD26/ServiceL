package net.DianC.dp.quartz.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.common.utils.CommonUtils;
import net.DianC.dp.quartz.entity.QuartzJobLogEntity;
import net.DianC.dp.quartz.manager.QuartzJobLogManager;
import net.DianC.dp.quartz.service.QuartzJobLogService;

/**
 * 定时任务日志
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月21日 上午11:18:22
 */
@Service("quartzJobLogService")
public class QuartzJobLogServiceImpl implements QuartzJobLogService {

	@Autowired
	private QuartzJobLogManager quartzJobLogManager;
	
	@Override
	public Page<QuartzJobLogEntity> listForPage(Map<String, Object> params) {
		Query query = new Query(params);
		Page<QuartzJobLogEntity> page = new Page<QuartzJobLogEntity>(query);
		quartzJobLogManager.listForPage(page, query);
		return page;
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = quartzJobLogManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R batchRemoveAll() {
		int count = quartzJobLogManager.batchRemoveAll();
		return CommonUtils.msg(count);
	}


}
