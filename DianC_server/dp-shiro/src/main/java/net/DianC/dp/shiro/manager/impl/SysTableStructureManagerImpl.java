package net.DianC.dp.shiro.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.dao.SysTableStructureMapper;
import net.DianC.dp.shiro.entity.SysIndexInfoEntity;
import net.DianC.dp.shiro.entity.SysTableStructureEntity;
import net.DianC.dp.shiro.entity.SysTableinfoEntity;
import net.DianC.dp.shiro.entity.SysTablerecordEntity;
import net.DianC.dp.shiro.entity.TableStructurezTreeEntity;
import net.DianC.dp.shiro.manager.SysDbinfoncManager;
import net.DianC.dp.shiro.manager.SysTableStructureManager;
//------------------------
import net.DianC.dp.shiro.dao.SysDbinfoncMapper;
/**
 * @author zhangk
 * 表结构管理
 *
 */

@Component("sysTableStructureManager")
public class SysTableStructureManagerImpl implements SysTableStructureManager {

	@Autowired
	private SysTableStructureMapper sysTableStructureMapper;
	/* (non-Javadoc)
	 * @see net.DianC.dp.shiro.manager.SysTableStructureManager#listForPage(net.DianC.dp.common.entity.Page, net.DianC.dp.common.entity.Query)
	 */
	@Override
	public List<SysTableStructureEntity> listForPage(Page<SysTableStructureEntity> page, Query query) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.listForPage(page, query);
	}

	/* (non-Javadoc)
	 * @see net.DianC.dp.shiro.manager.SysTableStructureManager#saveTableStructure(net.DianC.dp.shiro.entity.SysTableStructureEntity)
	 */
	@Override
	public int saveTableStructure(SysTableStructureEntity tablestructure) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.save(tablestructure);
	}

	/* (non-Javadoc)
	 * @see net.DianC.dp.shiro.manager.SysTableStructureManager#updateTableStructure(net.DianC.dp.shiro.entity.SysTableStructureEntity)
	 */
	@Override
	public int updateTableStructure(SysTableStructureEntity tablestructure) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.update(tablestructure);
	}

	/* (non-Javadoc)
	 * @see net.DianC.dp.shiro.manager.SysTableStructureManager#batchRemove(java.lang.Long[])
	 */
	@Override
	public int batchRemove(Long[] id) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.batchRemove(id);
	}

/*	@Override
	public int getTableInfoId(int dbinfoId) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.getTableInfoId(dbinfoId);
	}*/

	@Override
	public int syncTablestructure(SysTableStructureEntity tablestructure) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.sync(tablestructure);
	}

	@Override
	public String getTableName(int tableInfoId) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.getTableName(tableInfoId);
	}
/**
 * 
 * @param Count----------------------
 * @return
 */
	
	
	//@Override
	public int getKeysCount(int tableInfoId)  {
		// TODO Auto-generated method stub
		//用来去表中systablestructuremapper获取主键
		return sysTableStructureMapper.getKeysCount(tableInfoId);
		
	}
	
	@Override
	public SysTableStructureEntity getTablestructureById(Long id) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.getObjectById(id);
	}

	@Override
	public List<TableStructurezTreeEntity> getTableStructurezTree(int dbinfoId) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.getTableStructurezTree(dbinfoId);
	}

	@Override
	public List<String> getAllName(int tableInfoId) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.getAllName(tableInfoId);
	}
	
	
	
	@Override
	public int saveTableinfo(SysTableinfoEntity tableinfo) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.savetableinfo(tableinfo);
	}

	@Override
	public int saveTablerecord(SysTablerecordEntity tablerecord) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.savetablerecord(tablerecord);
	}

	@Override
	public int getTableInfoId(String tableName) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.getTableInfoIdByTableName(tableName);
	}

	@Override
	public int getDbInfoId(String tableName) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.getDbInfoIdByTableName(tableName);
	}

	@Override
	public int countByTableInfoId(int tableInfoId) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.countByTableInfoId(tableInfoId);
	}
/*
	@Override
	public int saveIndexInfo(SysIndexInfoEntity indexinfo) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.saveIndexInfo(indexinfo);
	}
*/
	
	
	@Override
	public String getTableId(int tableInfoId){
		// TODO Auto-generated method stub
		return sysTableStructureMapper.getTableId(tableInfoId);
	}
	
	@Override
	public int insertOrUpdate(SysIndexInfoEntity indexinfo) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.insertOrUpdate(indexinfo);
	}
	
	
	@Override
	public int removeIndexInfo(int tableInfoId, String columName) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.removeIndexInfo(tableInfoId,columName);
	}

	@Override
	public int remove_IndexInfo(Long[] tableInfoId) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.remove_IndexInfo(tableInfoId);
	}
	
	
	
	@Override
	public int setStatusTrue(int tableInfoId) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.setStatusTrue(tableInfoId);
		//return sysTableStructureMapper.setStatusTrue(tableInfoId);
	}

	@Override
	public int setStatusFalse(int tableInfoId) {
		// TODO Auto-generated method stub
		return sysTableStructureMapper.setStatusFalse(tableInfoId);
		//return sysTableStructureMapper.setStatusFalse(tableInfoId );
	}
	
//	@Override
//	public int getDataTable(SysTableStructureEntity tablestructure) {
//		// TODO Auto-generated method stub
//		return sysTableStructureMapper.tablestructure(tablestructure);
//	}
}
