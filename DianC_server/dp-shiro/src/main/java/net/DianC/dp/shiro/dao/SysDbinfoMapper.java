package net.DianC.dp.shiro.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import net.DianC.dp.common.dao.BaseMapper;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysDbinfoEntity;

@MapperScan
public interface SysDbinfoMapper extends BaseMapper<SysDbinfoEntity> {
	
	/*List<SysDbinfoEntity> listDbinfoByParentCode(Query query);     ////////////////
	
	int countDbinfoChildren(Long dbinfoId);*/

}
