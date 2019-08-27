package net.DianC.dp.shiro.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import net.DianC.dp.common.dao.BaseMapper;
import net.DianC.dp.shiro.entity.SysDbinfoncListlineEntity;
import net.DianC.dp.shiro.entity.SysHbaseaddrEntity;
import net.DianC.dp.shiro.entity.TableStructurezTreeEntity;

/**
 * 
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年7月09日 下午3:38:32
 */
@MapperScan
public interface SysDbinfoncListlineMapper extends BaseMapper<SysDbinfoncListlineEntity> {

	List<SysDbinfoncListlineEntity> getSysDbinfoncListlinezTree(int dbinfoId);

	List<TableStructurezTreeEntity> listlineDbinfoTree();

	List<TableStructurezTreeEntity> listlineTbinfoTree();

	SysHbaseaddrEntity getItemByhbaseType(String string);
}
