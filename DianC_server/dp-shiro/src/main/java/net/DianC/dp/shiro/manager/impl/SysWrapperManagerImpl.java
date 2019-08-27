package net.DianC.dp.shiro.manager.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.DianC.dp.common.entity.Query;
import net.DianC.dp.shiro.entity.SysWrapperEntity;
import net.DianC.dp.shiro.manager.SysWrapperManager;
import net.DianC.dp.shiro.dao.SysDataFlowMapper;
import net.DianC.dp.shiro.dao.SysWrapperMapper;

@Component("sysWrapperManager")
public class SysWrapperManagerImpl implements SysWrapperManager{

	@Autowired
	private SysWrapperMapper sysWrapperMapper;

	private SysDataFlowMapper sysDataFlowMapper;

	@Override
	public List<SysWrapperEntity> listWrapper(Query query) {
		// TODO Auto-generated method stub
		return sysWrapperMapper.list(query);
	}

	@Override
	public int saveWrapper(SysWrapperEntity wrapper) {
		// TODO Auto-generated method stub
		return sysWrapperMapper.save(wrapper);
	}

	@Override
	public List<SysWrapperEntity> listWrapper() {
		// TODO Auto-generated method stub
		return sysWrapperMapper.list();
	}
	
	@Override
	public Map<String, Object> uploadFile(HttpServletRequest request, HttpServletResponse response) {
		// TODO 自动生成的方法存根
		Map<String, Object> json = null;
		try {
			request.setCharacterEncoding("UTF-8");
			json = new HashMap<String, Object>();
	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;   
	        String tempath = request.getRealPath("/FileReceived/");       
	        //创建文件 
	        File dir=new File(tempath);
	        if(!dir.exists()){
	            dir.mkdirs();
	        }   
	        

	        /** 页面控件的文件流* */
	        MultipartFile multipartFile = null;
	        Map map =multipartRequest.getFileMap();
	         for (Iterator i = map.keySet().iterator(); i.hasNext();) {
	                Object obj = i.next();
	                multipartFile=(MultipartFile) map.get(obj);
	               }
	        /** 获取文件的后缀* */
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	        
	        String filename = df.format(new Date()) + "_" +  multipartFile.getOriginalFilename();   
	        multipartFile.transferTo(new File(tempath+"\\"+filename)); 	
	        System.out.println("文件夹！"); 	
	        String fileAddress = filename;
	        sysDataFlowMapper.saveFileAddress(fileAddress);
	        System.out.println("写入地址成功！"); 	        
	        json.put("message", "文件上传成功");
	        json.put("status", true);
	        

	        
		} catch (IllegalStateException | IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        return json;	
	}

}
