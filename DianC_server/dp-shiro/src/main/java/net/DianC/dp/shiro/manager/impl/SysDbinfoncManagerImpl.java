package net.DianC.dp.shiro.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.dao.SysDbinfoncMapper;
import net.DianC.dp.shiro.entity.SysDbinfoncEntity;
import net.DianC.dp.shiro.entity.SysHbaseaddrEntity;
import net.DianC.dp.shiro.manager.SysDbinfoncManager;

@Component("sysDbinfoncManager")
public class SysDbinfoncManagerImpl implements SysDbinfoncManager{
	
	@Autowired
	private SysDbinfoncMapper sysDbinfoncMapper;
	
	@Override
	public List<SysDbinfoncEntity> listDbinfonc(Query query) {
		// TODO Auto-generated method stub
		return sysDbinfoncMapper.list(query);
	}

	@Override
	public List<SysDbinfoncEntity> listForPage(Page<SysDbinfoncEntity> page, Query query) {
		// TODO Auto-generated method stub
		return sysDbinfoncMapper.listForPage(page, query);
	}

	@Override
	public String getdbName(int tableInfoId) {
		// TODO Auto-generated method stub
		return sysDbinfoncMapper.getdbName(tableInfoId);
	}

	@Override
	public SysHbaseaddrEntity getItemByhbaseType(String hbaseType) {
		// TODO Auto-generated method stub
		return sysDbinfoncMapper.getItemByhbaseType(hbaseType);
	}

	@Override
	public int getIsRecevie(int tableInfoId) {
		// TODO Auto-generated method stub
		return sysDbinfoncMapper.getIsRecevie(tableInfoId);
	}

	@Override
	public int updateIsRecevie(int tableInfoId, int isRecevie) {
		// TODO Auto-generated method stub
		return sysDbinfoncMapper.updateIsRecevie(tableInfoId,isRecevie);
	}

	@Override
	public int remove_TableRecord(Long[] tableInfoId) {
		// TODO Auto-generated method stub
		//System.out.println("sys manager:"+tableInfoId);
		return sysDbinfoncMapper.remove_TableRecord(tableInfoId);
	}
}