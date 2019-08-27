package net.DianC.dp.shiro.dao;

import org.mybatis.spring.annotation.MapperScan;

import net.DianC.dp.common.dao.BaseMapper;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysDbinfoncEntity;
import net.DianC.dp.shiro.entity.SysHbaseaddrEntity;

@MapperScan
public interface SysDbinfoncMapper extends BaseMapper<SysDbinfoncEntity>{

	String getdbName(int tableInfoId);

	SysHbaseaddrEntity getItemByhbaseType(String hbaseType);

	int getIsRecevie(int tableInfoId);

	int updateIsRecevie(int tableInfoId, int isRecevie);

	int remove_TableRecord(Long[] tableInfoId);

}
