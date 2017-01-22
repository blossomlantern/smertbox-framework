package com.smertbox.security.position.controller;

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
import com.smertbox.security.position.model.SysPosition;
import com.smertbox.security.position.service.PositionService;
import com.smertbox.security.positionrole.model.SysPositionRole;
import com.smertbox.security.positionrole.service.PositionRoleService;
import com.smertbox.security.positionrolegroup.model.SysPositionRolegroup;
import com.smertbox.security.positionrolegroup.service.PositionRolegroupService;
import com.smertbox.security.role.model.SysRole;
import com.smertbox.security.role.service.RoleService;
import com.smertbox.security.rolegroup.model.SysRolegroup;
import com.smertbox.security.rolegroup.service.RolegroupService;
import com.smertbox.util.page.DataTablePage;

@Controller
@RequestMapping("/security/position")
public class PositionController {

	private static Logger logger = LoggerFactory.getLogger(PositionController.class);
	
	@Autowired
	PositionService positionService;
	@Autowired
	RoleService roleService;
	@Autowired
	RolegroupService rolegroupService;
	@Autowired
	PositionRoleService positionRoleService;
	@Autowired
	PositionRolegroupService positionRolegroupService;
	
	/**
	 * @description 职位页面请求
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/listPage")
	public String listPage(Model model,HttpServletRequest request){
		
		return "security/position/list";
	}
	
	/**
	 * @description 职位分页
	 * @param model
	 * @param page
	 * @param request
	 * @param sysPosition
	 * @return JSON数据
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,SysPosition sysPosition){
		sysPosition.setPage(request);// 设置查询分页信息参数
		List<SysPosition> data = positionService.selectPage(sysPosition);
		int total = positionService.selectPageSize(sysPosition);
		if(data!=null&&data.size()>0){
			page.setData(data);
			page.setRecordsFiltered(total);
			page.setRecordsTotal(total);
		}
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPage(Model model,HttpServletRequest request){
		return "security/position/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Model model,HttpServletRequest request,SysPosition sysPosition){
		try{
			if(sysPosition!=null){
				sysPosition.setPositionId(UUID.randomUUID().toString());
				sysPosition.setCtTime(Calendar.getInstance().getTime());
				sysPosition.setCtUserId(SecurityUtil.getCurrentUserName());
				sysPosition.setDel((short) 0);
				positionService.insert(sysPosition);
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
			SysPosition sysPosition = positionService.selectByPrimaryKey(id);
			model.addAttribute("vobj", sysPosition);
		}
		return "security/position/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String edit(Model model,HttpServletRequest request,SysPosition sysPosition){
		try{
			if(sysPosition!=null){
				sysPosition.setUpTime(Calendar.getInstance().getTime());
				sysPosition.setUpUserId(SecurityUtil.getCurrentUserName());
				positionService.update(sysPosition);
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
			SysPosition sysPosition = positionService.selectByPrimaryKey(id);
			model.addAttribute("vobj", sysPosition);
		}
		return "security/position/detail";
	}
	
	@RequestMapping(value = "/isExist", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String isExist(Model model,HttpServletRequest request,SysPosition sysPosition,int max){
		int size = positionService.selectPageSize(sysPosition);
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
				SysPosition sysPosition = positionService.selectByPrimaryKey(ids[i]);
				sysPosition.setDel((short) 1);
				positionService.update(sysPosition);
			}
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/assignationRole", method = RequestMethod.GET)
	public String assignationRole(Model model,HttpServletRequest request,String id){
		SysPositionRole sysPositionRole = new SysPositionRole();
		sysPositionRole.setPositionId(id);
		sysPositionRole.setStart(-1);
		model.addAttribute("roles", JSONObject.toJSONString(positionRoleService.selectPage(sysPositionRole)));
		
		SysRole sysRole = new SysRole();
		sysRole.setOrderByClause("role_name");
		sysRole.setOrderByType("asc");
		sysRole.setStart(-1);
		model.addAttribute("alls", roleService.selectPageData(sysRole));
		model.addAttribute("positionId", id);
		return "security/position/assignationRole";
	}
	
	@RequestMapping(value = "/assignationRolegroup", method = RequestMethod.GET)
	public String assignation(Model model,HttpServletRequest request,String id){
		SysPositionRolegroup sysPositionRolegroup = new SysPositionRolegroup();
		sysPositionRolegroup.setPositionId(id);
		sysPositionRolegroup.setStart(-1);
		model.addAttribute("rolegroups", JSONObject.toJSONString(positionRolegroupService.selectPage(sysPositionRolegroup)));
		SysRolegroup sysRoleGroup = new SysRolegroup();
		sysRoleGroup.setStart(-1);
		model.addAttribute("alls", rolegroupService.selectPage(sysRoleGroup));
		model.addAttribute("positionId", id);
		return "security/position/assignationRolegroup";
	}
}
