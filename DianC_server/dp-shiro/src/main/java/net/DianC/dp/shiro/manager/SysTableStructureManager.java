package net.DianC.dp.shiro.manager;

import java.util.List;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysIndexInfoEntity;
import net.DianC.dp.shiro.entity.SysTableStructureEntity;
import net.DianC.dp.shiro.entity.SysTableinfoEntity;
import net.DianC.dp.shiro.entity.SysTablerecordEntity;
import net.DianC.dp.shiro.entity.TableStructurezTreeEntity;

public interface SysTableStructureManager {
	
	List<SysTableStructureEntity> listForPage(Page<SysTableStructureEntity>page, Query query);
		
	int saveTableStructure(SysTableStructureEntity tablestructure);
	
	int updateTableStructure(SysTableStructureEntity tablestructure);
	
	int batchRemove(Long[] id);

	//int getTableInfoId(int dbinfoId);

	int syncTablestructure(SysTableStructureEntity tablestructure);

	String getTableName(int tableInfoId);

	SysTableStructureEntity getTablestructureById(Long id);

	List<TableStructurezTreeEntity> getTableStructurezTree(int parseInt);

	int saveTableinfo(SysTableinfoEntity tableinfo);
	
	int saveTablerecord(SysTablerecordEntity tablerecord);

	int getTableInfoId(String tableName);

	int getDbInfoId(String tableName);

	int countByTableInfoId(int tableInfoId);

	String getTableId(int tableInfoId);
	
//	int saveIndexInfo(SysIndexInfoEntity indexinfo);
	
	int insertOrUpdate(SysIndexInfoEntity indexinfo);

	int getKeysCount(int tableInfoId);

	int setStatusTrue(int tableInfoId);

	int setStatusFalse(int tableInfoId);

	int removeIndexInfo(int tableInfoId, String columName);

	int remove_IndexInfo(Long[] tableInfoId);

	List<String> getAllName(int tableInfoId);

	
	//int getDataTable(int tableinfoID);

	
	

}
