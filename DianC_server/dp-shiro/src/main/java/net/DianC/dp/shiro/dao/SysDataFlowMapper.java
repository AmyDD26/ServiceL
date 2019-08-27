package net.DianC.dp.shiro.dao;

import org.mybatis.spring.annotation.MapperScan;

import net.DianC.dp.common.dao.BaseMapper;
import net.DianC.dp.common.entity.SysUserEntity;
import net.DianC.dp.shiro.entity.SysDataFlowEntity;

@MapperScan
public interface SysDataFlowMapper extends BaseMapper<SysDataFlowEntity> {
	
	int saveFileAddress(String fileAddress);

}
