package net.DianC.dp.shiro.service.impl;

import net.DianC.dp.common.entity.Query;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.common.utils.CommonUtils;
import net.DianC.dp.shiro.entity.SysWrapperEntity;
import net.DianC.dp.shiro.manager.SysWrapperManager;
import net.DianC.dp.shiro.service.SysWrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Service("sysWrapperService")
public class SysWrapperServiceImpl implements SysWrapperService{
	
	@Autowired
	private SysWrapperManager sysWrapperManager;

	@Override
	public R listWrapper(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysWrapperEntity> wrapperList = sysWrapperManager.listWrapper(query);
		return R.ok().put("wrapperList", wrapperList);
	}

	@Override
	public R saveWrapper(SysWrapperEntity wrapper) {
		int count = sysWrapperManager.saveWrapper(wrapper);
		return CommonUtils.msg(count);
	}

	@Override
	public R listWrapper() {
		List<SysWrapperEntity> wrapperList = sysWrapperManager.listWrapper();
		return R.ok().put("wrapperList", wrapperList);
	}

	@Override
	public Map<String, Object> uploadFile(HttpServletRequest request, HttpServletResponse response) {
		// TODO 自动生成的方法存根
		Map<String, Object> json = null;	
		json = sysWrapperManager.uploadFile(request,response); 
        return json;
		
	}

	
}
