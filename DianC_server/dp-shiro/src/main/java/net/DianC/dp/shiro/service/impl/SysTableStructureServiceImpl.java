package net.DianC.dp.shiro.service.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.DianC.dp.common.constant.MsgConstant;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.common.utils.CommonUtils;
import net.DianC.dp.shiro.entity.SysDbinfoncEntity;
import net.DianC.dp.shiro.entity.SysIndexInfoEntity;
import net.DianC.dp.shiro.entity.SysTableStructureEntity;
import net.DianC.dp.shiro.entity.SysTableinfoEntity;
import net.DianC.dp.shiro.entity.SysTablerecordEntity;
import net.DianC.dp.shiro.entity.TableStructurezTreeEntity;
import net.DianC.dp.shiro.manager.SysTableStructureManager;
import net.DianC.dp.shiro.service.SysTableStructureService;
import net.DianC.dp.shiro.util.GetHbaseColumn;
import net.DianC.dp.shiro.util.HbaseDatabase;
import net.DianC.dp.shiro.entity.SysTableStructureEntity;


/**
 * @author zhangk
 * 表结构Service实现
 *
 */
@Service("sysTableStructureService")
public class SysTableStructureServiceImpl implements SysTableStructureService {

	@Autowired
	private SysTableStructureManager sysTableStructureManager;
	
	/* (non-Javadoc)
	 * @see net.DianC.dp.shiro.service.SysTableStructureService#listTableStructure(java.util.Map)
	 */
	@Override
	public Page<SysTableStructureEntity> listTableStructure(Map<String, Object> params) {
		// TODO Auto-generated method stub
/*		//获取tableInfoId
		Object tableInfoId = sysTableStructureManager.getTableInfoId((int) params.get("dbinfoId"));
		//获取其他params
		Object pageNumber = params.get("pageNumber");
		Object pageSize = params.get("pageSize");
		Object sortOrder = params.get("sortOrder");
		//重新构建参数paramsEx
		Map<String,Object> paramsEx = new HashMap<String,Object>();
		paramsEx.put("tableInfoId",tableInfoId);
		paramsEx.put("pageNumber",pageNumber);
		paramsEx.put("pageSize",pageSize);
		paramsEx.put("sortOrder",sortOrder);
		Query query = new Query(paramsEx);
*/		
		int tableInfoId = (int)params.get("tableInfoId");
		//查询t_tablestructure中是否存在该tableinfo的记录，如果不存在则解析Hbase数据,添加tablestructure到
		if(sysTableStructureManager.countByTableInfoId(tableInfoId) == 0) {
			String tableName = sysTableStructureManager.getTableName(tableInfoId);
			GetHbaseColumn getHC = new GetHbaseColumn();
			List<String> columnList = new ArrayList<String>();
			try {
				//根据tablename获取表的字段
				columnList = getHC.getColumn(tableName);				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//对字段进行封装
			if(columnList.isEmpty()) {
				//添加警告：Hbase中不存在该表
			}
			else {
				for (int i = 0;i < columnList.size(); i++) {
					SysTableStructureEntity tablestructure = new SysTableStructureEntity();
					tablestructure.setName(columnList.get(i));
					tablestructure.setFieldType("VarChar");
					tablestructure.setDefaultValue(null);
					tablestructure.setChName(columnList.get(i));
					tablestructure.setTableInfoId(tableInfoId);
					tablestructure.setLength(255);
					tablestructure.setIsNull(0);
					tablestructure.setIsKey(0);
					tablestructure.setIsPartitionColumn(0);
					tablestructure.setColumnPosition(i+1);
					sysTableStructureManager.syncTablestructure(tablestructure);
				}
			}
		}
		Query query = new Query(params);
		Page<SysTableStructureEntity> page = new Page<SysTableStructureEntity>(query);
		sysTableStructureManager.listForPage(page, query);
		return page;
	}

	/* (non-Javadoc)
	 * @see net.DianC.dp.shiro.service.SysTableStructureService#saveTablestructure(net.DianC.dp.shiro.entity.SysTableStructureEntity)
	 */
	@Override
	public R saveTableStructure(SysTableStructureEntity tablestructure) {
		// TODO Auto-generated method stub
		int tableInfoId = tablestructure.getTableInfoId();	
		int columnPosition = sysTableStructureManager.countByTableInfoId(tableInfoId) + 1;
		tablestructure.setColumnPosition(columnPosition);
		int count = sysTableStructureManager.saveTableStructure(tablestructure);
		int keyCount =sysTableStructureManager.getKeysCount(tableInfoId);
		if(keyCount == 0) {
			sysTableStructureManager.setStatusFalse(tableInfoId);
		}
		else {
			sysTableStructureManager.setStatusTrue(tableInfoId);
		}
		int iskey = tablestructure.getIsKey();
		if (iskey == 1) {
			String name = "rowkey";			
			List<String> columNameString = sysTableStructureManager.getAllName(tableInfoId);
			String columName = columNameString.get(0);
			for (int i = 1;i < columNameString.size();i++)
			{
				columName += "_"+columNameString.get(i);
			}						
			//String columName = tablestructure.getName();
			String type = "普通行键";
			String tableName = sysTableStructureManager.getTableName(tableInfoId);
			int dbInfoId = sysTableStructureManager.getDbInfoId(tableName);
			SysIndexInfoEntity indexinfo = new SysIndexInfoEntity();		
			int Id;
			if(sysTableStructureManager.getTableId(tableInfoId)==null){
				Id=0;
			}
			else{
				Id=Integer.parseInt(sysTableStructureManager.getTableId(tableInfoId));
			}	
			indexinfo.setId(Id);
			indexinfo.setName(name);
			indexinfo.setColumName(columName);
			indexinfo.setType(type);
			indexinfo.setTableInfoId(tableInfoId);
			indexinfo.setDbInfoId(dbInfoId);
			indexinfo.setTableName(tableName);
			sysTableStructureManager.insertOrUpdate(indexinfo);
			//sysTableStructureManager.saveIndexInfo(indexinfo);
		}
		return CommonUtils.msg(count);
	}

	/* (non-Javadoc)
	 * @see net.DianC.dp.shiro.service.SysTableStructureService#updateTablestructure(net.DianC.dp.shiro.entity.SysTableStructureEntity)
	 */
	@Override
	public R updateTableStructure(SysTableStructureEntity tablestructure) {
		// TODO Auto-generated method stub
		int iskey = tablestructure.getIsKey();
		long id = tablestructure.getId();	
		int ex_iskey = sysTableStructureManager.getTablestructureById(id).getIsKey();
		//移动到此，先执行更新strcture表
		int count = sysTableStructureManager.updateTableStructure(tablestructure);	
		int tableInfoId = tablestructure.getTableInfoId();
		//获取主键数目，存在主键则设置该表的status为0，不存在设为1，不存在删除相关indexInfo记录
		int keyCount =sysTableStructureManager.getKeysCount(tableInfoId);
		if(keyCount == 0) {
			sysTableStructureManager.setStatusFalse(tableInfoId);
			//没有主键则删除
			Long[] tId = {(long) tableInfoId};
			sysTableStructureManager.remove_IndexInfo(tId);
		}
		else {
			sysTableStructureManager.setStatusTrue(tableInfoId);
			//新增或更新	
		if(iskey != ex_iskey) {
			//根据id获取主键名称getAllName 并整合成一句string
			List<String> columNameString = sysTableStructureManager.getAllName(tablestructure.getTableInfoId());
			String columName = columNameString.get(0);
			for (int i = 1;i < columNameString.size();i++)
			{
				columName += "_"+columNameString.get(i);
			}	
	//		if(iskey == 1) {
				String name = "rowkey";
				String type = "普通行键";
				String tableName = sysTableStructureManager.getTableName(tableInfoId);
				//int Id = sysTableStructureManager.getTableId(tableInfoId);
				int Id;
				if(sysTableStructureManager.getTableId(tableInfoId)==null){
					Id=0;
				}
				else{
					Id=Integer.parseInt(sysTableStructureManager.getTableId(tableInfoId));
				}	
				int dbInfoId = sysTableStructureManager.getDbInfoId(tableName);
				SysIndexInfoEntity indexinfo = new SysIndexInfoEntity();
				indexinfo.setId(Id);
				indexinfo.setName(name);
				indexinfo.setColumName(columName);
				indexinfo.setType(type);
				indexinfo.setTableInfoId(tableInfoId);
				indexinfo.setDbInfoId(dbInfoId);
				indexinfo.setTableName(tableName);
				sysTableStructureManager.insertOrUpdate(indexinfo);
				//sysTableStructureManager.saveIndexInfo(indexinfo);
		//	}
			/*
			else {
				//删除记录
				Long[] tId = {(long) tableInfoId};
				sysTableStructureManager.remove_IndexInfo(tId);
				//sysTableStructureManager.removeIndexInfo(tableInfoId,columName);
			}
			*/	
		}
		}
//		int count = sysTableStructureManager.updateTableStructure(tablestructure);
		return CommonUtils.msg(count);
	}

	/* (non-Javadoc)
	 * @see net.DianC.dp.shiro.service.SysTableStructureService#batchRemove(java.lang.Long[])
	 */
	@Override
	public R batchRemove(Long[] id) {
		// TODO Auto-generated method stub
		//删除完之后直接更新一下columName,然后存进去
		//找首个id的tableID
		Long firstId = id[0];
		SysTableStructureEntity tablestructure = sysTableStructureManager.getTablestructureById(firstId);
		int tableInfoId = tablestructure.getTableInfoId();
		//获取到tableID之后删除
		int count = sysTableStructureManager.batchRemove(id);
		//获取主键数目，存在主键则设置该表的status为0，不存在设为1，不存在删除相关indexInfo记录
		int keyCount =sysTableStructureManager.getKeysCount(tableInfoId);	
		if(keyCount == 0) {
			sysTableStructureManager.setStatusFalse(tableInfoId);
			//没有主键则删除
			Long[] tId = {(long) tableInfoId};
			sysTableStructureManager.remove_IndexInfo(tId);
		}
		else {
			sysTableStructureManager.setStatusTrue(tableInfoId);
			//新增或更新	
			//根据id获取主键名称getAllName 并整合成一句string
			List<String> columNameString = sysTableStructureManager.getAllName(tableInfoId);
			String columName = columNameString.get(0);
			for (int i = 1;i < columNameString.size();i++)
			{
				columName += "_"+columNameString.get(i);
			}	
				String name = "rowkey";
				String type = "普通行键";
				String tableName = sysTableStructureManager.getTableName(tableInfoId);
				int Id;
				if(sysTableStructureManager.getTableId(tableInfoId)==null){
					Id=0;
				}
				else{
					Id=Integer.parseInt(sysTableStructureManager.getTableId(tableInfoId));
				}	
				int dbInfoId = sysTableStructureManager.getDbInfoId(tableName);	
				SysIndexInfoEntity indexinfo = new SysIndexInfoEntity();
				indexinfo.setId(Id);
				indexinfo.setName(name);
				indexinfo.setColumName(columName);
				indexinfo.setType(type);
				indexinfo.setTableInfoId(tableInfoId);
				indexinfo.setDbInfoId(dbInfoId);
				indexinfo.setTableName(tableName);
				sysTableStructureManager.insertOrUpdate(indexinfo);
	
		
		}	
		return CommonUtils.msg(id,count);
	}
	
	//msg改...
	@Override
	public R removeIndexInfo(int tableInfoId, String columName) {
		// TODO Auto-generated method stub
		int count = sysTableStructureManager.removeIndexInfo(tableInfoId,columName);
		return CommonUtils.msg(count);
	}
	
	@Override
	public R remove_IndexInfo(Long[] tableInfoId) {
		// TODO Auto-generated method stub
		int count = sysTableStructureManager.remove_IndexInfo(tableInfoId);
		return CommonUtils.msg(count);
	}
/*	@Override
	public R syncTableStructure(Map<String, Object> params) {
		// TODO Auto-generated method stub
		//根据dbinfoId获取tablename
		String tablename = sysTableStructureManager.getTableName((int) params.get("dbinfoId"));
		//根据dbinfoId获取tableinfoid
		int tableinfoid = sysTableStructureManager.getTableInfoId((int) params.get("dbinfoId"));
		GetHbaseColumn getHC = new GetHbaseColumn();
		List<String> columnList = new ArrayList<String>();
		try {
			//根据tablename获取表的字段
			columnList = getHC.getColumn(tablename);				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//对字段进行封装
		if(columnList.isEmpty())
			return R.error(MsgConstant.MSG_TABLE_NAME_NOT_FOUND);
		else {
			for (int i = 0;i < columnList.size(); i++) {
				SysTableStructureEntity tablestructure = new SysTableStructureEntity();
				tablestructure.setName(columnList.get(i));
				tablestructure.setFieldType("VarChar");
				tablestructure.setDefaultValue(null);
				tablestructure.setChName(columnList.get(i));
				tablestructure.setTableInfoId(tableinfoid);
				tablestructure.setLength(255);
				tablestructure.setIsNull(0);
				tablestructure.setIsKey(0);
				tablestructure.setIsPartitionColumn(0);
				tablestructure.setColumnPosition(i+1);
				sysTableStructureManager.syncTablestructure(tablestructure);
			}
			return R.ok();
		}
	}
*/
	@Override
	public R getTableStructureById(Long id) {
		// TODO Auto-generated method stub
		SysTableStructureEntity tablestructure = sysTableStructureManager.getTablestructureById(id);
		return CommonUtils.msg(tablestructure);
	}

	@Override
	public List<TableStructurezTreeEntity> getTableStructurezTree(String dbInfoID,String dbName) {
		// TODO Auto-generated method stub
		List<TableStructurezTreeEntity> dbinfoList = sysTableStructureManager.getTableStructurezTree(Integer.parseInt(dbInfoID));
		TableStructurezTreeEntity tablestructureztree = new TableStructurezTreeEntity();
		tablestructureztree.setName(dbName);
		tablestructureztree.setDbID(-1);
		tablestructureztree.setId(Integer.parseInt(dbInfoID));
		tablestructureztree.setOpen(true);
		dbinfoList.add(tablestructureztree);
		return dbinfoList;
	}
	
	
	@Override
	public List<TableStructurezTreeEntity> getDataTable(String dbInfoID) {
		// TODO Auto-generated method stub
		List<TableStructurezTreeEntity> datatableList = sysTableStructureManager.getTableStructurezTree(Integer.parseInt(dbInfoID));
		//TableStructurezTreeEntity tablestructureztree = new TableStructurezTreeEntity();
		return datatableList;
	}
		
		
		
	@Override
	public R saveTable(SysTableinfoEntity tableinfo) {
		// TODO Auto-generated method stub
		String tableName = tableinfo.getName();
		//写入Hbase
		HbaseDatabase hdb = new HbaseDatabase();
		try {
			hdb.createTable(tableName, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return R.error("在Hbase中创建表出现异常，请联系管理员");
		}
		//写入t_tableinfo
		tableinfo.setPublishTime(new Timestamp(new Date().getTime()));
		int infocount = sysTableStructureManager.saveTableinfo(tableinfo);
		SysTablerecordEntity tablerecord = new SysTablerecordEntity();
		tablerecord.setTime(new Timestamp(new Date().getTime()));
		tablerecord.setName(tableName);
		tablerecord.setCount(0);
		tablerecord.setIsRecevie(0);
		tablerecord.setTableInfoID(sysTableStructureManager.getTableInfoId(tableName));
		tablerecord.setDbID(sysTableStructureManager.getDbInfoId(tableName));
		//写入t_tablerecord
		int recordcount = sysTableStructureManager.saveTablerecord(tablerecord);
		int count  = infocount + recordcount;
		//存在两个插入操作，返回值是插入记录条数之和
		
		int tableInfoId = tablerecord.getTableInfoID();
		//获取主键数目，存在主键则设置该表的status为0，不存在设为1
		int keyCount =sysTableStructureManager.getKeysCount(tableInfoId);
		if(keyCount == 0) {
			sysTableStructureManager.setStatusFalse(tableInfoId);
		}
		else {
			sysTableStructureManager.setStatusTrue(tableInfoId);
		}
		
		return CommonUtils.msg(count);
	}

}
