package com.smertbox.security.organization.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.smertbox.security.organization.model.SysOrganization;
import com.smertbox.security.organization.service.OrganizationService;
import com.smertbox.security.orgposition.model.SysOrgPosition;
import com.smertbox.security.orgposition.service.OrgPositionService;
import com.smertbox.security.orgrole.model.SysOrgRole;
import com.smertbox.security.orgrole.service.OrgRoleService;
import com.smertbox.security.orgrolegroup.model.SysOrgRolegroup;
import com.smertbox.security.orgrolegroup.service.OrgRolegroupService;
import com.smertbox.security.position.model.SysPosition;
import com.smertbox.security.position.service.PositionService;
import com.smertbox.security.role.model.SysRole;
import com.smertbox.security.role.service.RoleService;
import com.smertbox.security.rolegroup.model.SysRolegroup;
import com.smertbox.security.rolegroup.service.RolegroupService;
import com.smertbox.util.map.MapUtil;
import com.smertbox.util.page.DataTablePage;
import com.smertbox.util.tree.model.TreeNode;

@Controller
@RequestMapping("/security/organization")
public class OrganizationController {

	private static Logger logger = LoggerFactory.getLogger(OrganizationController.class);
	
	@Autowired
	OrganizationService organizationService;
	@Autowired
	RoleService roleService;
	@Autowired
	RolegroupService rolegroupService;
	@Autowired
	OrgRoleService orgRoleService;
	@Autowired
	OrgRolegroupService orgRolegroupService;
	@Autowired
	OrgPositionService orgPositionService;
	@Autowired
	PositionService positionService;
	
	/**
	 * @description 页面请求
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/listPage")
	public String listPage(Model model,HttpServletRequest request){
		
		return "security/organization/list";
	}
	
	/**
	 * @description 分页
	 * @param model
	 * @param page
	 * @param request
	 * @param sysOrganization
	 * @return JSON数据
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,SysOrganization sysOrganization){
		sysOrganization.setPage(request);// 设置查询分页信息参数
		List<SysOrganization> data = organizationService.selectPage(sysOrganization);
		int total = organizationService.selectPageSize(sysOrganization);
		if(data!=null&&data.size()>0){
			page.setData(data);
			page.setRecordsFiltered(total);
			page.setRecordsTotal(total);
		}
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPage(Model model,HttpServletRequest request){
		return "security/organization/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Model model,HttpServletRequest request,SysOrganization sysOrganization){
		if(sysOrganization!=null){
			try {
				if(sysOrganization!=null){
					sysOrganization.setOrgId(UUID.randomUUID().toString());
					sysOrganization.setCtTime(Calendar.getInstance().getTime());
					sysOrganization.setCtUserId(SecurityUtil.getCurrentUserName());
					sysOrganization.setDel((short) 0);
					organizationService.insert(sysOrganization);
					return "1";
				}
			} catch (Exception e) {
				logger.error(ExceptionUtils.getFullStackTrace(e));
			}
		}
		return "0";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPage(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysOrganization sysOrganization = organizationService.selectByPrimaryKey(id);
			SysOrganization parentOrganization = sysOrganization != null ? organizationService.selectByPrimaryKey(sysOrganization.getOrgPid()) : null;
			if(parentOrganization != null){
				sysOrganization.setOrgPname(parentOrganization.getOrgName());
			}
			model.addAttribute("vobj", sysOrganization);
		}
		return "security/organization/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String edit(Model model,HttpServletRequest request,SysOrganization sysOrganization){
		try{
			if(sysOrganization!=null){
				sysOrganization.setUpTime(Calendar.getInstance().getTime());
				sysOrganization.setUpUserId(SecurityUtil.getCurrentUserName());
				organizationService.update(sysOrganization);
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
			SysOrganization sysOrganization = organizationService.selectByPrimaryKey(id);
			SysOrganization parentOrganization = sysOrganization != null ? organizationService.selectByPrimaryKey(sysOrganization.getOrgPid()) : null;
			if(parentOrganization != null){
				sysOrganization.setOrgPname(parentOrganization.getOrgName());
			}
			model.addAttribute("vobj", sysOrganization);
		}
		return "security/organization/detail";
	}
	
	@RequestMapping(value = "/isExist", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String isExist(Model model,HttpServletRequest request,SysOrganization sysOrganization,int max){
		int size = organizationService.selectPageSize(sysOrganization);
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
				SysOrganization sysOrganization = organizationService.selectByPrimaryKey(ids[i]);
				sysOrganization.setDel((short) 1);
				organizationService.update(sysOrganization);
			}
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/orgTree", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String orgTree(Model model,HttpServletRequest request){
		try{
			List<TreeNode> list = organizationService.selectOrganizationTree(SecurityUtil.getCurrentUserName());
			if(list.size()>0){
				return JSONObject.toJSONString(list);
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "-1";
	}
	
	@RequestMapping(value = "/assignationRole", method = RequestMethod.GET)
	public String assignationRole(Model model,HttpServletRequest request,String id){
		SysOrgRole sysOrgRole = new SysOrgRole();
		sysOrgRole.setOrgId(id);
		sysOrgRole.setStart(-1);
		model.addAttribute("roles", JSONObject.toJSONString(orgRoleService.selectPage(sysOrgRole)));
		
		SysRole sysRole = new SysRole();
		sysRole.setOrderByClause("role_name");
		sysRole.setOrderByType("asc");
		sysRole.setStart(-1);
		model.addAttribute("alls", roleService.selectPageData(sysRole));
		model.addAttribute("orgId", id);
		return "security/organization/assignationRole";
	}
	
	@RequestMapping(value = "/assignationRolegroup", method = RequestMethod.GET)
	public String assignation(Model model,HttpServletRequest request,String id){
		SysOrgRolegroup sysOrgRolegroup = new SysOrgRolegroup();
		sysOrgRolegroup.setOrgId(id);
		sysOrgRolegroup.setStart(-1);
		model.addAttribute("rolegroups", JSONObject.toJSONString(orgRolegroupService.selectPage(sysOrgRolegroup)));
		SysRolegroup sysRoleGroup = new SysRolegroup();
		sysRoleGroup.setStart(-1);
		model.addAttribute("alls", rolegroupService.selectPage(sysRoleGroup));
		model.addAttribute("orgId", id);
		return "security/organization/assignationRolegroup";
	}
	
	@RequestMapping(value = "/assignationPosition", method = RequestMethod.GET)
	public String assignationPosition(Model model,HttpServletRequest request,String id){
		SysOrgPosition sysOrgPosition = new SysOrgPosition();
		sysOrgPosition.setOrgId(id);
		sysOrgPosition.setStart(-1);
		model.addAttribute("positions", JSONObject.toJSONString(orgPositionService.selectPage(sysOrgPosition)));
		
		/*SysPosition sysPosition = new SysPosition();
		sysPosition.setOrderByClause("role_name");
		sysPosition.setOrderByType("asc");
		sysPosition.setStart(-1);*/
		Map<String, List<?>> map= new HashMap<String, List<?>>();
		List<SysPosition> list = positionService.selectAllHaveParam();
		List<String> types = positionService.selectAllPositionType();
		for (int i = 0; i < types.size(); i++) {
			List<SysPosition> add = new ArrayList<SysPosition>();
			String typeValue = null;
			for (int j = 0; j < list.size(); j++) {
				if(types.get(i).equals(list.get(j).getPositionType())){
					typeValue = list.get(j).getPositionTypeValue();
					add.add(list.get(j));
				}
			}
			map.put(typeValue, add);
		}
		map = MapUtil.sortByKeyASC(map);
		model.addAttribute("map", map);
		model.addAttribute("orgId", id);
		return "security/organization/assignationPosition";
	}
}
