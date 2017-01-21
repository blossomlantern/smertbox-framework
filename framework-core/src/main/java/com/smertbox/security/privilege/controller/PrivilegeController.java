package com.smertbox.security.privilege.controller;

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
import com.smertbox.security.privilege.model.SysPrivilege;
import com.smertbox.security.privilege.service.PrivilegeService;
import com.smertbox.security.resource.model.SysResources;
import com.smertbox.security.resource.service.ResourcesService;
import com.smertbox.security.resourceprivilege.model.SysResPvg;
import com.smertbox.security.resourceprivilege.service.ResourcePrivilegeService;
import com.smertbox.util.page.DataTablePage;

@Controller
@RequestMapping("/security/privilege")
public class PrivilegeController {

	private static Logger logger = LoggerFactory.getLogger(PrivilegeController.class);
	
	@Autowired
	PrivilegeService privilegeService;
	@Autowired
	ResourcePrivilegeService resourcePrivilegeService;
	@Autowired
	ResourcesService resourcesService;
	
	/**
	 * @description 资源页面请求
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/listPage")
	public String listPage(Model model,HttpServletRequest request){
		
		return "security/privilege/list";
	}
	
	/**
	 * @description 资源分页
	 * @param model
	 * @param page
	 * @param request
	 * @param sysPrivilege
	 * @return JSON数据
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,SysPrivilege sysPrivilege){
		sysPrivilege.setPage(request);// 设置查询分页信息参数
		List<SysPrivilege> data = privilegeService.selectPageData(sysPrivilege);
		int total = privilegeService.selectPageDataSize(sysPrivilege);
		if(data!=null&&data.size()>0){
			page.setData(data);
			page.setRecordsFiltered(total);
			page.setRecordsTotal(total);
		}
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPage(Model model,HttpServletRequest request){
		return "security/privilege/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Model model,HttpServletRequest request,SysPrivilege sysPrivilege){
		try{
			if(sysPrivilege!=null){
				sysPrivilege.setPvgId(UUID.randomUUID().toString());
				sysPrivilege.setCtTime(Calendar.getInstance().getTime());
				sysPrivilege.setCtUserId(SecurityUtil.getCurrentUserName());
				sysPrivilege.setDel((short) 0);
				privilegeService.insert(sysPrivilege);
				addPrivilegeResourceObject(request,sysPrivilege);
				return "1";
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "0";
	}
	
	public void addPrivilegeResourceObject(HttpServletRequest request,SysPrivilege sysPrivilege){
		try{
			String resId = request.getParameter("resId");
			SysResPvg srp = new SysResPvg();
			srp.setResPvgId(UUID.randomUUID().toString());
			srp.setResId(resId);
			srp.setPvgId(sysPrivilege.getPvgId());
			srp.setAllowEdit((short) 1);
			srp.setAllowDel((short) 1);
			srp.setCtTime(Calendar.getInstance().getTime());
			srp.setCtUserId(SecurityUtil.getCurrentUserName());
			srp.setDel((short) 0);
			
			resourcePrivilegeService.insert(srp);
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
	}
	
	public void editPrivilegeResourceObject(HttpServletRequest request,SysPrivilege sysPrivilege){
		try{
			String resId = request.getParameter("resId");
			SysResPvg query = new SysResPvg();
			query.setPvgId(sysPrivilege.getPvgId());
			SysResPvg srp = resourcePrivilegeService.selectPage(query).get(0);
			srp.setResId(resId);
			srp.setUpTime(Calendar.getInstance().getTime());
			srp.setUpUserId(SecurityUtil.getCurrentUserName());
			
			resourcePrivilegeService.update(srp);
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPage(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysPrivilege sysPrivilege = privilegeService.selectByPrimaryKey(id);
			SysPrivilege parent = sysPrivilege != null ? privilegeService.selectByPrimaryKey(sysPrivilege.getPvgPid()) : null;
			SysResPvg query = new SysResPvg();
			query.setPvgId(id);
			SysResPvg srp = resourcePrivilegeService.selectPage(query).get(0);
			SysResources sr = resourcesService.selectByPrimaryKey(srp.getResId());
			if(parent != null){
				sysPrivilege.setPvgPidName(parent.getPvgName());
				sysPrivilege.setResName(sr.getResName());
			}
			model.addAttribute("resId", sr.getResId());
			model.addAttribute("vobj", sysPrivilege);
		}
		return "security/privilege/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String edit(Model model,HttpServletRequest request,SysPrivilege sysPrivilege){
		try{
			if(sysPrivilege!=null){
				sysPrivilege.setUpTime(Calendar.getInstance().getTime());
				sysPrivilege.setUpUserId(SecurityUtil.getCurrentUserName());
				privilegeService.update(sysPrivilege);
				editPrivilegeResourceObject(request,sysPrivilege);
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
			SysPrivilege sysPrivilege = privilegeService.selectByPrimaryKey(id);
			SysPrivilege parent = sysPrivilege != null ? privilegeService.selectByPrimaryKey(sysPrivilege.getPvgPid()) : null;
			SysResPvg query = new SysResPvg();
			query.setPvgId(id);
			SysResPvg srp = resourcePrivilegeService.selectPage(query).get(0);
			SysResources sr = resourcesService.selectByPrimaryKey(srp.getResId());
			if(parent != null){
				sysPrivilege.setPvgPidName(parent.getPvgName());
				sysPrivilege.setResName(sr.getResName());
			}
			model.addAttribute("vobj", sysPrivilege);
		}
		return "security/privilege/detail";
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
	public String isExist(Model model,HttpServletRequest request,SysResPvg sysResPvg,int max){
		int size = resourcePrivilegeService.selectPage(sysResPvg).size();
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
				SysPrivilege sysPrivilege = privilegeService.selectByPrimaryKey(ids[i]);
				sysPrivilege.setDel((short) 1);
				privilegeService.update(sysPrivilege);
			}
			return "1";
		}
		return "0";
	}
}
