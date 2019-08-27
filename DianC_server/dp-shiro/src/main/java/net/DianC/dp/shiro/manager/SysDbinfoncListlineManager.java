package net.DianC.dp.shiro.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysDbinfoQueryEntity;
import net.DianC.dp.shiro.entity.SysDbinfoncListlineEntity;
import net.DianC.dp.shiro.entity.TableStructurezTreeEntity;

/**
 * 
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年7月09日 下午3:38:32
 */
public interface SysDbinfoncListlineManager {

	List<SysDbinfoncListlineEntity> listSysDbinfoncListline(Page<SysDbinfoncListlineEntity> page, Query search);
	
	int saveSysDbinfoncListline(SysDbinfoncListlineEntity SysDbinfoncListline);
	
	SysDbinfoncListlineEntity getSysDbinfoncListlineById(Long id);
	
	int updateSysDbinfonclistline(SysDbinfoncListlineEntity SysDbinfoncListline);
	
	int batchRemove(Long[] id);
	
	List<SysDbinfoncListlineEntity> getSysDbinfoncListlinezTree(int parseInt);

	List<TableStructurezTreeEntity> listlineDbinfoTree();

	List<TableStructurezTreeEntity> listlineTbinfoTree();

	BufferedReader sendSQLSocket(String sqlsript,int startposition,int endposition,String queryType2);

	List<SysDbinfoQueryEntity> getRecords(BufferedReader is, String tableName) throws IOException;

	SysDbinfoQueryEntity getColumn(String tableName);

}
