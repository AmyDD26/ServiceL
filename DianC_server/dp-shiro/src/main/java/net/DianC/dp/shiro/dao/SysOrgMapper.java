package net.DianC.dp.shiro.dao;

import org.mybatis.spring.annotation.MapperScan;

import net.DianC.dp.common.dao.BaseMapper;
import net.DianC.dp.shiro.entity.SysOrgEntity;

/**
 * 组织架构
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月17日 上午11:26:05
 */
@MapperScan
public interface SysOrgMapper extends BaseMapper<SysOrgEntity> {

	int countOrgChildren(Long parentId);
	
}
