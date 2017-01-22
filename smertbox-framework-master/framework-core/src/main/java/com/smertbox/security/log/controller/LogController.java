package com.smertbox.security.log.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smertbox.security.log.model.SysLog;
import com.smertbox.security.log.service.LogService;
import com.smertbox.util.page.DataTablePage;

@Controller
@RequestMapping("/system/log")
public class LogController {

	private Logger logger = Logger.getLogger(LogController.class);
	
	@Autowired
	LogService logService;
	
	@RequestMapping("/listPage")
	public String listPage(Model model,HttpServletRequest request){
		
		return "system/log/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,SysLog sysLog){
		sysLog.setPage(request);// 设置查询分页信息参数
		List<SysLog> data = logService.selectPage(sysLog);
		int total = logService.selectPageSize(sysLog);
		if(data!=null&&data.size()>0){
			page.setData(data);
			page.setRecordsFiltered(total);
			page.setRecordsTotal(total);
		}
		return page;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String delete(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			String[] ids = id.split(",");
			for (int i = 0; i < ids.length; i++) {
				SysLog sysLog = logService.selectByPrimaryKey(ids[i]);
				logService.delete(sysLog.getLogId());
			}
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/clean", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String clean(Model model,HttpServletRequest request){
		try{
			logService.clean();
			return "1";
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "0";
	}
}
