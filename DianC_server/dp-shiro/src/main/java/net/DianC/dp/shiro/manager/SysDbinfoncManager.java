package net.DianC.dp.shiro.manager;

import java.util.List;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysDbinfoncEntity;
import net.DianC.dp.shiro.entity.SysHbaseaddrEntity;

public interface SysDbinfoncManager {
	
	List<SysDbinfoncEntity> listDbinfonc(Query query);

	List<SysDbinfoncEntity> listForPage(Page<SysDbinfoncEntity> page, Query query);

	String getdbName(int tableInfoId);

	SysHbaseaddrEntity getItemByhbaseType(String hbaseType);

	int getIsRecevie(int tableInfoId);

	int updateIsRecevie(int tableInfoId, int isRecevie);

	int remove_TableRecord(Long[] tableInfoId);
	
	
}
