/**
 * 
 */
package net.DianC.dp.shiro.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import net.DianC.dp.common.dao.BaseMapper;
import net.DianC.dp.shiro.entity.SysIndexInfoEntity;
import net.DianC.dp.shiro.entity.SysTableStructureEntity;
import net.DianC.dp.shiro.entity.SysTableinfoEntity;
import net.DianC.dp.shiro.entity.SysTablerecordEntity;
import net.DianC.dp.shiro.entity.TableStructurezTreeEntity;

/**
 * @author 290615
 *
 */
@MapperScan
public interface SysTableStructureMapper extends BaseMapper<SysTableStructureEntity>{

	//int getTableInfoId(int dbinfoId);

	String getTableName(int tableInfoId);

	int sync(SysTableStructureEntity tablestructure);

	List<TableStructurezTreeEntity> getTableStructurezTree(int dbinfoId);
	
	List<String> getAllName(int tableInfoId);
	
	int savetableinfo(SysTableinfoEntity tableinfo);
	
	int savetablerecord(SysTablerecordEntity tablerecord);

	int getTableInfoIdByTableName(String tableName);

	int getDbInfoIdByTableName(String tableName);

	int countByTableInfoId(int tableInfoId);

	int saveIndexInfo(SysIndexInfoEntity indexinfo);
	
	String getTableId(int tableInfoId);
	
	int insertOrUpdate(SysIndexInfoEntity indexinfo);

	int removeIndexInfo(int tableInfoId, String columName);
	
	int remove_IndexInfo(Object[] tableInfoId);

	int getKeysCount(int tableInfoId);

	//int setStatusFalse(int tableInfoId);

	//int setStatusTrue(int tableInfoId);
	
	int setStatusFalse(int tableInfoId);

	int setStatusTrue(int tableInfoId);

}
