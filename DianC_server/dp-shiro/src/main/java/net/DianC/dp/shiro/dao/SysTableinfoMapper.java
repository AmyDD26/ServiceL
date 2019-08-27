package net.DianC.dp.shiro.dao;

import org.mybatis.spring.annotation.MapperScan;

import net.DianC.dp.common.dao.BaseMapper;
import net.DianC.dp.shiro.entity.SysDbinfoEntity;
import net.DianC.dp.shiro.entity.SysTableinfoEntity;

@MapperScan
public interface SysTableinfoMapper extends BaseMapper<SysTableinfoEntity> {

}
