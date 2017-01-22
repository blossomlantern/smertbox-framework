package com.smertbox.security.rolegroup.controller;

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
import com.smertbox.security.pvggroup.model.SysPvggroup;
import com.smertbox.security.role.model.SysRole;
import com.smertbox.security.role.service.RoleService;
import com.smertbox.security.rolegroup.model.SysRolegroup;
import com.smertbox.security.rolegroup.service.RolegroupService;
import com.smertbox.security.roleprivilege.model.SysRolePrivilege;
import com.smertbox.security.rolerolegroup.service.RoleRolegroupService;
import com.smertbox.util.page.DataTablePage;

@Controller
@RequestMapping("/security/rolegroup")
public class RolegroupController {

	private static Logger logger = LoggerFactory.getLogger(RolegroupController.class);
	
	@Autowired
	RolegroupService roleGroupService;
	@Autowired
	RoleService roleService;
	@Autowired
	RoleRolegroupService roleRolegroupService;
	
	/**
	 * @description 资源页面请求
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/listPage")
	public String listPage(Model model,HttpServletRequest request){
		
		return "security/rolegroup/list";
	}
	
	/**
	 * @description 资源分页
	 * @param model
	 * @param page
	 * @param request
	 * @param SysRolegroup
	 * @return JSON数据
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,SysRolegroup sysRoleGroup){
		sysRoleGroup.setPage(request);// 设置查询分页信息参数
		List<SysRolegroup> data = roleGroupService.selectPage(sysRoleGroup);
		int total = roleGroupService.selectPageSize(sysRoleGroup);
		if(data!=null&&data.size()>0){
			page.setData(data);
			page.setRecordsFiltered(total);
			page.setRecordsTotal(total);
		}
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPage(Model model,HttpServletRequest request){
		
		return "security/rolegroup/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Model model,HttpServletRequest request,SysRolegroup sysRoleGroup){
		if(sysRoleGroup!=null){
			sysRoleGroup.setRgId(UUID.randomUUID().toString());;
			sysRoleGroup.setCreateTime(Calendar.getInstance().getTime());
			roleGroupService.insert(sysRoleGroup);
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPage(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysRolegroup sysRoleGroup = roleGroupService.selectByPrimaryKey(id);
			model.addAttribute("vobj", sysRoleGroup);
		}
		return "security/rolegroup/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String edit(Model model,HttpServletRequest request,SysRolegroup sysRoleGroup){
		if(sysRoleGroup!=null){
			roleGroupService.update(sysRoleGroup);
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysRolegroup sysRoleGroup = roleGroupService.selectByPrimaryKey(id);
			model.addAttribute("vobj", sysRoleGroup);
		}
		return "security/rolegroup/detail";
	}
	
	@RequestMapping(value = "/assignation", method = RequestMethod.GET)
	public String assignation(Model model,HttpServletRequest request,String rgId){
		model.addAttribute("roles", JSONObject.toJSONString(roleRolegroupService.selectAll(rgId)));
		SysRole sysRole = new SysRole();
		sysRole.setOrderByClause("role_name");
		sysRole.setOrderByType("asc");
		sysRole.setStart(-1);
		model.addAttribute("alls", roleService.selectPageData(sysRole));
		model.addAttribute("rgId", rgId);
		return "security/rolegroup/assignation";
	}
	
	@RequestMapping(value = "/isExist", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String isExist(Model model,HttpServletRequest request,SysRolegroup sysRoleGroup,int max){
		int size = roleGroupService.selectPageSize(sysRoleGroup);
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
				roleGroupService.delete(ids[i]);
			}
			return "1";
		}
		return "0";
	}
}
