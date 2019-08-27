package net.DianC.dp.shiro.manager;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysWrapperEntity;

public interface SysWrapperManager {

	List<SysWrapperEntity> listWrapper(Query query);

	int saveWrapper(SysWrapperEntity wrapper);

	List<SysWrapperEntity> listWrapper();

	Map<String,Object> uploadFile(HttpServletRequest request,HttpServletResponse response);
}
