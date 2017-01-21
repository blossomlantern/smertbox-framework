package com.smertbox.security.role.controller;

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
import com.smertbox.security.privilege.model.PrivilegeNode;
import com.smertbox.security.privilege.service.PrivilegeService;
import com.smertbox.security.pvggroup.model.SysPvggroup;
import com.smertbox.security.pvggroup.service.PvggroupService;
import com.smertbox.security.role.model.SysRole;
import com.smertbox.security.role.service.RoleService;
import com.smertbox.security.roleprivilege.model.SysRolePrivilege;
import com.smertbox.security.roleprivilege.service.RolePrivilegeService;
import com.smertbox.security.rolepvggroup.service.RolePvggroupService;
import com.smertbox.util.page.DataTablePage;

@Controller
@RequestMapping("/security/role")
public class RoleController {

	private static Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	RoleService roleService;
	@Autowired
	PrivilegeService privilegeService;
	@Autowired
	RolePrivilegeService rolePrivilegeService;
	@Autowired
	RolePvggroupService rolePvggroupService;
	@Autowired
	PvggroupService pvggroupService;
	
	/**
	 * @description 资源页面请求
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/listPage")
	public String listPage(Model model,HttpServletRequest request){
		
		return "security/role/list";
	}
	
	/**
	 * @description 资源分页
	 * @param model
	 * @param page
	 * @param request
	 * @param SysRole
	 * @return JSON数据
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,SysRole sysRole){
		sysRole.setPage(request);// 设置查询分页信息参数
		List<SysRole> data = roleService.selectPageData(sysRole);
		int total = roleService.selectPageDataSize(sysRole);
		if(data!=null&&data.size()>0){
			page.setData(data);
			page.setRecordsFiltered(total);
			page.setRecordsTotal(total);
		}
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPage(Model model,HttpServletRequest request){
		
		return "security/role/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Model model,HttpServletRequest request,SysRole sysRole){
		try{
			if(sysRole!=null){
				sysRole.setRoleId(UUID.randomUUID().toString());
				sysRole.setCtTime(Calendar.getInstance().getTime());
				sysRole.setCtUserId(SecurityUtil.getCurrentUserName());
				sysRole.setDel((short)0);
				roleService.insert(sysRole);
				return "1";
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "0";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPage(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysRole sysRole = roleService.selectByPrimaryKey(id);
			model.addAttribute("vobj", sysRole);
		}
		return "security/role/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String edit(Model model,HttpServletRequest request,SysRole SysRole){
		try{
			if(SysRole!=null){
				SysRole.setUpTime(Calendar.getInstance().getTime());
				SysRole.setUpUserId(SecurityUtil.getCurrentUserName());
				roleService.update(SysRole);
				return "1";
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "0";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysRole sysRole = roleService.selectByPrimaryKey(id);
			model.addAttribute("vobj", sysRole);
		}
		return "security/role/detail";
	}
	
	@RequestMapping(value = "/assignation", method = RequestMethod.GET)
	public String assignation(Model model,HttpServletRequest request,SysRolePrivilege sysRolePrivilege){
		model.addAttribute("privileges", JSONObject.toJSONString(rolePrivilegeService.selectPage(sysRolePrivilege)));
		model.addAttribute("roleId", sysRolePrivilege.getRoleId());
		return "security/role/assignation";
	}
	
	@RequestMapping(value = "/assignationGroup", method = RequestMethod.GET)
	public String assignationGroup(Model model,HttpServletRequest request,String roleId){
		model.addAttribute("groups", JSONObject.toJSONString(rolePvggroupService.selectAll(roleId)));
		SysPvggroup sysPvggroup = new SysPvggroup();
		sysPvggroup.setOrderByClause("pg_name");
		sysPvggroup.setOrderByType("asc");
		sysPvggroup.setStart(-1);
		model.addAttribute("alls", pvggroupService.selectPage(sysPvggroup));
		model.addAttribute("roleId", roleId);
		return "security/role/assignationGroup";
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
	public String isExist(Model model,HttpServletRequest request,SysRole sysRole,int max){
		int size = roleService.selectPageDataSize(sysRole);
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
				SysRole sysRole = roleService.selectByPrimaryKey(ids[i]);
				sysRole.setDel((short) 1);
				roleService.update(sysRole);
			}
			return "1";
		}
		return "0";
	}
}
