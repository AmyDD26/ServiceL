package net.DianC.dp.shiro.service;

import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysWrapperEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface SysWrapperService {

	R listWrapper(Map<String, Object> params);

	R saveWrapper(SysWrapperEntity wrapper);

	R listWrapper();

	Map<String,Object> uploadFile(HttpServletRequest request,HttpServletResponse response);
}
