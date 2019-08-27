package net.DianC.dp.shiro.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.common.utils.CommonUtils;
import net.DianC.dp.shiro.entity.SysDbinfoQueryEntity;
import net.DianC.dp.shiro.entity.SysDbinfoncListlineEntity;
import net.DianC.dp.shiro.entity.TableStructurezTreeEntity;
import net.DianC.dp.shiro.manager.SysDbinfoncListlineManager;
import net.DianC.dp.shiro.service.SysDbinfoncListlineService;

/**
 * 
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年7月09日 下午3:38:32
 **/


@Service("/sys/DbinfonclistlineService")
public class SysDbinfoncListlineServiceImpl implements SysDbinfoncListlineService {

	@Autowired
	private SysDbinfoncListlineManager SysDbinfonclistlineManager;

	@Override
	public Page<SysDbinfoncListlineEntity> listSysDbinfoncListline(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysDbinfoncListlineEntity> page = new Page<>(query);
		SysDbinfonclistlineManager.listSysDbinfoncListline(page, query);
		return page;
	}

	@Override
	public R saveSysDbinfoncListline(SysDbinfoncListlineEntity role) {
		int count = SysDbinfonclistlineManager.saveSysDbinfoncListline(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getSysDbinfoncListlineById(Long id) {
		SysDbinfoncListlineEntity SysDbinfonclistline = SysDbinfonclistlineManager.getSysDbinfoncListlineById(id);
		return CommonUtils.msg(SysDbinfonclistline);
	}

	@Override
	public R updateSysDbinfoncListline(SysDbinfoncListlineEntity SysDbinfonclistline) {
		int count = SysDbinfonclistlineManager.updateSysDbinfonclistline(SysDbinfonclistline);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = SysDbinfonclistlineManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}
	
	@Override
	public List<SysDbinfoncListlineEntity> getDbinfoncListlinezTree(String dbInfoID,String dbName,String tableId) {
		// TODO Auto-generated method stub
		List<SysDbinfoncListlineEntity> dbinfoncListline = SysDbinfonclistlineManager.getSysDbinfoncListlinezTree(Integer.parseInt(dbInfoID));
		SysDbinfoncListlineEntity sysDbinfoncListlineztree = new SysDbinfoncListlineEntity();
		sysDbinfoncListlineztree.setName(dbName);
		sysDbinfoncListlineztree.setId(Integer.parseInt(dbInfoID));
		sysDbinfoncListlineztree.setTbid(Integer.parseInt(tableId));
		dbinfoncListline.add(sysDbinfoncListlineztree);
		return dbinfoncListline;
	}

	@Override
	public List<TableStructurezTreeEntity> ListlineTree() {
		// TODO Auto-generated method stub
		List<TableStructurezTreeEntity> list = SysDbinfonclistlineManager.listlineTbinfoTree();;
		TableStructurezTreeEntity tablestructureztree = new TableStructurezTreeEntity();
		tablestructureztree.setName("数据集");
		tablestructureztree.setDbID(-1);
		tablestructureztree.setId(0);
		tablestructureztree.setOpen(true);
		list.add(tablestructureztree);		
		List<TableStructurezTreeEntity> tblist = SysDbinfonclistlineManager.listlineDbinfoTree();
		for(int i = 0; i < tblist.size(); i++){
			tblist.get(i).setDbID(0);
			list.add(tblist.get(i));
		}
		return list;
	}

	@Override
	public Page<SysDbinfoQueryEntity> sendSQLSocket(Map<String, Object> params) throws IOException {
		// TODO Auto-generated method stub
		Page<SysDbinfoQueryEntity> page = new Page<SysDbinfoQueryEntity>();
		String sqlsript = params.get("sqlsript").toString().replaceAll("&lt;", "<").replaceAll("&gt;", ">");//恢复">","<"
		String regex = "from\\s";
		String tableName = sqlsript.split(regex)[1].split(" ")[0].toUpperCase();
		//String sqlsript = params.get("sqlsript").toString();
		int startposization = 0,endposization = 20;
		String queryType2 = "0";
		BufferedReader is = SysDbinfonclistlineManager.sendSQLSocket(sqlsript,startposization,endposization,queryType2);
		List<SysDbinfoQueryEntity> result = SysDbinfonclistlineManager.getRecords(is,tableName);
		page.setRows(result);
		return page;
	}


}
