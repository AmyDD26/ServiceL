package net.DianC.dp.shiro.controller;

import net.DianC.dp.common.controller.AbstractController;
import net.DianC.dp.common.entity.R;
import net.DianC.dp.shiro.entity.SysWrapperEntity;
import net.DianC.dp.shiro.service.SysWrapperService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 设备组controller
 * @author niulijie
 *
 */
@RestController
@RequestMapping("/sys/wrapper")
public class SysWrapperController extends AbstractController{
	
	@Resource
	private SysWrapperService sysWrapperService;
	
	@RequestMapping("/list")
	public R listWrapper() {
		return sysWrapperService.listWrapper();
	}
	
	@RequestMapping("/save")
	public R save(@RequestBody SysWrapperEntity wrapper) {
		return sysWrapperService.saveWrapper(wrapper);
	}

    @RequestMapping(value = "/jar_upload" ,method = RequestMethod.POST)
    public  Map<String, Object> uploadFile(HttpServletRequest request,HttpServletResponse response)
    
            throws Exception {
    	Map<String ,Object> json = sysWrapperService.uploadFile(request,response);
    	return json;
    }
	
	
	
	
	
	
	
}
	
	

