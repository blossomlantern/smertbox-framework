package com.smertbox.security.pvggroup.controller;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.smertbox.security.privilege.model.PrivilegeNode;
import com.smertbox.security.privilege.service.PrivilegeService;
import com.smertbox.security.pvggroup.model.SysPvggroup;
import com.smertbox.security.pvggroup.service.PvggroupService;
import com.smertbox.security.pvgpvggroup.service.PvgPvggroupService;
import com.smertbox.util.page.DataTablePage;

@Controller
@RequestMapping("/security/privilegegroup")
public class PvggroupController {

	private static Logger logger = LoggerFactory.getLogger(PvggroupController.class);
	
	@Autowired
	PvggroupService privilegeGroupService;
	@Autowired
	PrivilegeService privilegeService;
	@Autowired
	PvgPvggroupService pvgPvggroupService;
	
	/**
	 * @description 资源页面请求
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/listPage")
	public String listPage(Model model,HttpServletRequest request){
		
		return "security/privilegegroup/list";
	}
	
	/**
	 * @description 资源分页
	 * @param model
	 * @param page
	 * @param request
	 * @param SysPvggroup
	 * @return JSON数据
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,SysPvggroup sysPrivilegeGroup){
		sysPrivilegeGroup.setPage(request);// 设置查询分页信息参数
		List<SysPvggroup> data = privilegeGroupService.selectPage(sysPrivilegeGroup);
		int total = privilegeGroupService.selectPageSize(sysPrivilegeGroup);
		if(data!=null&&data.size()>0){
			page.setData(data);
			page.setRecordsFiltered(total);
			page.setRecordsTotal(total);
		}
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPage(Model model,HttpServletRequest request){
		
		return "security/privilegegroup/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Model model,HttpServletRequest request,SysPvggroup sysPrivilegeGroup){
		if(sysPrivilegeGroup!=null){
			sysPrivilegeGroup.setPgId(UUID.randomUUID().toString());
			sysPrivilegeGroup.setCreateTime(Calendar.getInstance().getTime());
			privilegeGroupService.insert(sysPrivilegeGroup);
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPage(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysPvggroup sysPrivilegeGroup = privilegeGroupService.selectByPrimaryKey(id);
			model.addAttribute("vobj", sysPrivilegeGroup);
		}
		return "security/privilegegroup/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String edit(Model model,HttpServletRequest request,SysPvggroup sysPrivilegeGroup){
		if(sysPrivilegeGroup!=null){
			privilegeGroupService.update(sysPrivilegeGroup);
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysPvggroup sysPrivilegeGroup = privilegeGroupService.selectByPrimaryKey(id);
			model.addAttribute("vobj", sysPrivilegeGroup);
		}
		return "security/privilegegroup/detail";
	}
	
	@RequestMapping(value = "/assignation", method = RequestMethod.GET)
	public String assignation(Model model,HttpServletRequest request,SysPvggroup sysPrivilegeGroup){
		model.addAttribute("privileges", JSONObject.toJSONString(pvgPvggroupService.selectAll(sysPrivilegeGroup.getPgId())));
		model.addAttribute("pg", sysPrivilegeGroup);
		return "security/privilegegroup/assignation";
	}
	
	@RequestMapping(value = "/privilegeTree", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String resourceTree(Model model,HttpServletRequest request){
		List<PrivilegeNode> list = privilegeService.selectResourceTree();
		if(list.size()>0){
			return JSONObject.toJSONString(list);
		}
		return "-1";
	}
	
	@RequestMapping(value = "/isExist", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String isExist(Model model,HttpServletRequest request,SysPvggroup sysPvggroup,int max){
		int size = privilegeGroupService.selectPageSize(sysPvggroup);
		if(size <= max){
			return "0";
		}
		return "1";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String delete(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			String[] ids = id.split(",");
			for (int i = 0; i < ids.length; i++) {
				privilegeGroupService.delete(ids[i]);
			}
			return "1";
		}
		return "0";
	}
}
