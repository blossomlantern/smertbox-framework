package com.smertbox.system.quartz.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smertbox.system.quartz.model.QrtzJobDetails;
import com.smertbox.system.quartz.service.JobService;
import com.smertbox.util.page.DataTablePage;

@Controller
@RequestMapping("/system/quartz")
public class JobController {

	private static Logger logger = LoggerFactory.getLogger(JobController.class);
	
	@Autowired
	JobService jobService;
	
	/**
	 * @description 资源页面请求
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/listPage")
	public String listPage(Model model,HttpServletRequest request){
		
		return "system/quartz/list";
	}
	
	/**
	 * @description 资源分页
	 * @param model
	 * @param page
	 * @param request
	 * @param resources
	 * @return JSON数据
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,QrtzJobDetails job){
		job.setPage(request);// 设置查询分页信息参数
		List<QrtzJobDetails> data = jobService.selectPage(job);
		data = jobService.selectPageReset(data);
		int total = jobService.selectPageSize(job);
		if(data!=null&&data.size()>0){
			page.setData(data);
			page.setRecordsFiltered(total);
			page.setRecordsTotal(total);
		}
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPage(Model model,HttpServletRequest request){
		return "system/quartz/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Model model,HttpServletRequest request,QrtzJobDetails job){
		try{
			if(job != null){
				jobService.add(job.getJobName(), job.getJobDescription(), job.getTriggerName(), job.getTriggerDescription(), job.getJobClassName(), job.getCronExpression());
				return "1";
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "0";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPage(Model model,HttpServletRequest request,QrtzJobDetails job){
		if(job != null){
			String value = null;
	    	if(StringUtils.isNotBlank(job.getJobName())){
	    		try {
					value = new String(job.getJobName().trim().getBytes("iso8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					logger.error(ExceptionUtils.getFullStackTrace(e));
				}
	    	}
			QrtzJobDetails vobj = jobService.selectByJobName(value);
			model.addAttribute("vobj", vobj);
		}
		return "system/quartz/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String edit(Model model,HttpServletRequest request,QrtzJobDetails job){
		try{
			if(job != null){
				jobService.modify(job.getJobName(),job.getCronExpression());
				return "1";
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "0";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model,HttpServletRequest request,QrtzJobDetails job){
		if(job != null){
			String value = null;
	    	if(StringUtils.isNotBlank(job.getJobName())){
	    		try {
					value = new String(job.getJobName().trim().getBytes("iso8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					logger.error(ExceptionUtils.getFullStackTrace(e));
				}
	    	}
	    	QrtzJobDetails vobj = jobService.selectByJobName(value);
	    	QrtzJobDetails dob = jobService.query(value);
	    	if(vobj != null && dob != null){
	    		vobj.setState(dob.getState());
	    		vobj.setLastTime(dob.getLastTime());
	    		vobj.setNextTime(dob.getNextTime());
	    	}
	    	model.addAttribute("lastFiveRow", jobService.selectLastFiveRow(value));
			model.addAttribute("vobj", vobj);
		}
		return "system/quartz/detail";
	}
	
	@RequestMapping(value = "/execute", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String execute(Model model,HttpServletRequest request,QrtzJobDetails job){
		if(job != null){
			String value = null;
	    	if(StringUtils.isNotBlank(job.getJobName())){
	    		try {
					value = new String(job.getJobName().trim().getBytes("iso8859-1"),"utf-8");
					job.setJobName(value);
				} catch (UnsupportedEncodingException e) {
					logger.error(ExceptionUtils.getFullStackTrace(e));
				}
	    	}
			jobService.trigger(job.getJobName());
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/resume", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String resume(Model model,HttpServletRequest request,QrtzJobDetails job){
		if(job != null){
			String value = null;
	    	if(StringUtils.isNotBlank(job.getJobName())){
	    		try {
					value = new String(job.getJobName().trim().getBytes("iso8859-1"),"utf-8");
					job.setJobName(value);
				} catch (UnsupportedEncodingException e) {
					logger.error(ExceptionUtils.getFullStackTrace(e));
				}
	    	}
			jobService.resume(job.getJobName());
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/pause", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String pause(Model model,HttpServletRequest request,QrtzJobDetails job){
		if(job != null){
			String value = null;
	    	if(StringUtils.isNotBlank(job.getJobName())){
	    		try {
					value = new String(job.getJobName().trim().getBytes("iso8859-1"),"utf-8");
					job.setJobName(value);
				} catch (UnsupportedEncodingException e) {
					logger.error(ExceptionUtils.getFullStackTrace(e));
				}
	    	}
			jobService.pause(job.getJobName());
			return "1";
		}
		return "0";
	}
	
	
	@RequestMapping(value = "/jobClassIsExist", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String jobClassIsExist(Model model,HttpServletRequest request,String jobClass){
		if(StringUtils.isNotBlank(jobClass)){
			try {
				Class<?> classe = Class.forName(jobClass);
				if(classe != null){
					return "1";
				}else{
					return "0";
				}
			} catch (ClassNotFoundException e) {
				logger.error(ExceptionUtils.getFullStackTrace(e));
				return "0";
			}
		}
		return "0";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String delete(Model model,HttpServletRequest request,QrtzJobDetails job){
		if(job != null){
			String value = null;
	    	if(StringUtils.isNotBlank(job.getJobName())){
	    		try {
					value = new String(job.getJobName().trim().getBytes("iso8859-1"),"utf-8");
					job.setJobName(value);
				} catch (UnsupportedEncodingException e) {
					logger.error(ExceptionUtils.getFullStackTrace(e));
				}
	    	}
			jobService.delete(job.getJobName());
			return "1";
		}
		return "0";
	}
}
