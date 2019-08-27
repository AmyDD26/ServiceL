package net.DianC.dp.shiro.dao;

import net.DianC.dp.common.dao.BaseMapper;
import net.DianC.dp.shiro.entity.SysServiceEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface SysServiceMapper extends BaseMapper<SysServiceEntity>{
    List<String> serviceTypeAll();
}
