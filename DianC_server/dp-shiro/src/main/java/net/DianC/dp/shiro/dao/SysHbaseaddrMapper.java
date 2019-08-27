package net.DianC.dp.shiro.dao;

import org.mybatis.spring.annotation.MapperScan;
import net.DianC.dp.common.dao.BaseMapper;
import net.DianC.dp.shiro.entity.SysHbaseaddrEntity;
/**
 * 数据集
 * @author zhangk
 *
 */
@MapperScan
public interface SysHbaseaddrMapper extends BaseMapper<SysHbaseaddrEntity> {
	/**
	 * 根据给出地址类型，返回对应的地址实体
	 * @param hbaseType
	 * @return
	 */
	SysHbaseaddrEntity getItemByhbaseType(String hbaseType);

}
