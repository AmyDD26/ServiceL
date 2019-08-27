package net.DianC.dp.shiro.manager;
import java.util.List;
import java.util.Map;
import net.DianC.dp.common.entity.Page;
import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysHbaseaddrEntity;;
/**
 * 数据集
 * @author zhangk
 *
 */
public interface SysHbaseaddrManager {

	List<SysHbaseaddrEntity> listHbaseaddr(Query query);
	
	List<SysHbaseaddrEntity> listForPage(Page<SysHbaseaddrEntity> page, Query query);

	int saveHbaseaddr(SysHbaseaddrEntity hbaseaddr);
	
	SysHbaseaddrEntity getHbaseaddrById(Long id);
	
	int updateHbaseaddr(SysHbaseaddrEntity hbaseaddr);
	
	int batchRemove(Long[] id);
	
	SysHbaseaddrEntity getItemByhbaseType(String hbaseType);

}