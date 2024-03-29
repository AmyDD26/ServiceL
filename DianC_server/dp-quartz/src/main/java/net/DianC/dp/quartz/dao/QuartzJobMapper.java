package net.DianC.dp.quartz.dao;

import org.mybatis.spring.annotation.MapperScan;

import net.DianC.dp.common.dao.BaseMapper;
import net.DianC.dp.quartz.entity.QuartzJobEntity;

/**
 * 定时任务
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月20日 下午11:19:55
 */
@MapperScan
public interface QuartzJobMapper extends BaseMapper<QuartzJobEntity> {

}
