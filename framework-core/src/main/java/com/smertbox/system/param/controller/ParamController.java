package com.smertbox.system.param.controller;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

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

import com.alibaba.fastjson.JSONObject;
import com.smertbox.security.core.util.SecurityUtil;
import com.smertbox.system.param.model.CmParameter;
import com.smertbox.system.param.service.ParamService;
import com.smertbox.util.page.DataTablePage;

@Controller
@RequestMapping("/system/param")
public class ParamController {

	private static Logger logger = LoggerFactory.getLogger(ParamController.class);
	
	@Autowired
	ParamService paramService;
	
	/**
	 * 页面
	 */
	@RequestMapping("/listPage")
	public String listPage(Model model,HttpServletRequest request){
		
		return "system/param/list";
	}
	
	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,CmParameter cmParameter){
		cmParameter.setPage(request);// 设置查询分页信息参数
		List<CmParameter> data = paramService.selectPage(cmParameter);
		int total = paramService.selectPageSize(cmParameter);
		if(data!=null&&data.size()>0){
			page.setData(data);
			page.setRecordsFiltered(total);
			page.setRecordsTotal(total);
		}
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPage(Model model,HttpServletRequest request,CmParameter cmParameter){
		CmParameter cp = new CmParameter();
		cp.setParPid(cmParameter.getParId());
		cp.setParLevel(cmParameter.getParLevel());
		model.addAttribute("vobj", cp);
		return "system/param/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Model model,HttpServletRequest request,CmParameter cmParameter){
		try{
			if(cmParameter!=null){
				cmParameter.setParId(UUID.randomUUID().toString());
				cmParameter.setCtTime(Calendar.getInstance().getTime());
				cmParameter.setDel((short) 0);
				cmParameter.setCtUserId(SecurityUtil.getCurrentUserName());
				paramService.insert(cmParameter);
				return "1";
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "0";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPage(Model model,HttpServletRequest request,CmParameter cmParameter){
		try{
			if(StringUtils.isNotBlank(cmParameter.getParId())){
				CmParameter cp= paramService.selectByPrimaryKey(cmParameter.getParId());
				cp.setUpTime(Calendar.getInstance().getTime());
				cp.setUpUserId(SecurityUtil.getCurrentUserName());
				model.addAttribute("vobj", cp);
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "system/param/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String edit(Model model,HttpServletRequest request,CmParameter cmParameter){
		try{
			if(cmParameter!=null){
				paramService.update(cmParameter);
				return "1";
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "0";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model,HttpServletRequest request,String id){
		try{
			if(StringUtils.isNotBlank(id)){
				CmParameter cmParameter= paramService.selectByPrimaryKey(id);
				model.addAttribute("vobj", cmParameter);
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "system/param/detail";
	}
	
	@RequestMapping(value = "/paramTree", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String paramTree(Model model,HttpServletRequest request){
		try{
			List<CmParameter> list = paramService.selectParamTree();
			CmParameter root = new CmParameter();
			root.setParId("0");
			root.setParKey("root");
			root.setParValue("参数树");
			root.setParLevel("0");
			root.setParType("root");
			if(list != null){
				list.add(root);
				return JSONObject.toJSONString(list);
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "0";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String delete(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			String[] ids = id.split(",");
			for (int i = 0; i < ids.length; i++) {
				//CmParameter cmParameter = paramService.selectByPrimaryKey(ids[i]);
				//cmParameter.setDel((short) 1);
				//paramService.update(cmParameter);
				paramService.delete(ids[i]);
			}
			return "1";
		}
		return "0";
	}
	
	/**
	 * 级联删除
	 */
	@RequestMapping(value = "/deleteCascade", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String deleteCascade(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			String[] ids = id.split(",");
			for (int i = 0; i < ids.length; i++) {
				paramService.deleteCascade(ids[i]);
			}
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/parKeyIsExist", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String parKeyIsExist(Model model,HttpServletRequest request,CmParameter cmParameter,int max){
		try {
			int size = paramService.selectPageSize(cmParameter);
			if(size <= max){
				return "0";
			}
			return "1";
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
			return "0";
		}
	}
}
