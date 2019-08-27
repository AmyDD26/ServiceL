package net.DianC.dp.shiro.service;

import java.util.List;
import java.util.Map;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysTableStructureEntity;
import net.DianC.dp.shiro.entity.SysTableinfoEntity;
import net.DianC.dp.shiro.entity.TableStructurezTreeEntity;

/**
 * 表结构Service
 * @author zhangk
 *
 */
public interface SysTableStructureService {

	Page<SysTableStructureEntity> listTableStructure(Map<String, Object> params);
	
	//R syncTableStructure(Map<String, Object> params);
	
	R saveTableStructure(SysTableStructureEntity tablestructure);
	
	R updateTableStructure(SysTableStructureEntity tablestructure);
	
	R batchRemove(Long[] id);

	R getTableStructureById(Long id);

	List<TableStructurezTreeEntity> getTableStructurezTree(String dbInfoID,String dbName);

	R saveTable(SysTableinfoEntity tableinfo);

	R removeIndexInfo(int tableInfoId, String columName);

	R remove_IndexInfo(Long[] tableInfoId);

	List<TableStructurezTreeEntity> getDataTable(String dbInfoID);
}
