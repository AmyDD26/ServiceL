package net.DianC.dp.shiro.dao;

import org.mybatis.spring.annotation.MapperScan;

import net.DianC.dp.common.dao.BaseMapper;
import net.DianC.dp.shiro.entity.SysDataTableEntity;

@MapperScan
public interface SysDataTableMapper extends BaseMapper<SysDataTableEntity>{

	int remove_TableInfo(Object[] id);
}
