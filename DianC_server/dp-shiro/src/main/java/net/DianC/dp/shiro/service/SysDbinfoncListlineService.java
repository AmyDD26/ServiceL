package net.DianC.dp.shiro.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.R;
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
public interface SysDbinfoncListlineService {

	Page<SysDbinfoncListlineEntity> listSysDbinfoncListline(Map<String, Object> params);
	
	R saveSysDbinfoncListline(SysDbinfoncListlineEntity SysDbinfonclistline);
	
	R getSysDbinfoncListlineById(Long id);
	
	R updateSysDbinfoncListline(SysDbinfoncListlineEntity SysDbinfonclistline);
	
	R batchRemove(Long[] id);

	List<SysDbinfoncListlineEntity> getDbinfoncListlinezTree(String dbInfoID, String dbName, String description);

	List<TableStructurezTreeEntity> ListlineTree();

	Page<SysDbinfoQueryEntity> sendSQLSocket(Map<String, Object> params) throws IOException;

	
}
