package com.smertbox.security.resource.controller;

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
import com.smertbox.security.privilege.model.SysPrivilege;
import com.smertbox.security.privilege.service.PrivilegeService;
import com.smertbox.security.resource.model.ResourceNode;
import com.smertbox.security.resource.model.SysResources;
import com.smertbox.security.resource.service.ResourcesService;
import com.smertbox.security.resourceprivilege.model.SysResPvg;
import com.smertbox.security.resourceprivilege.service.ResourcePrivilegeService;
import com.smertbox.util.page.DataTablePage;

@Controller
@RequestMapping("/security/resource")
public class ResourceController {

	private static Logger logger = LoggerFactory.getLogger(ResourceController.class);
	
	@Autowired
	ResourcesService resourcesService;
	@Autowired
	PrivilegeService privilegeService;
	@Autowired
	ResourcePrivilegeService resourcePrivilegeService;
	
	/**
	 * @description 资源页面请求
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/listPage")
	public String listPage(Model model,HttpServletRequest request){
		
		return "security/resource/list";
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
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,SysResources resources){
		resources.setPage(request);// 设置查询分页信息参数
		List<SysResources> data = resourcesService.selectPageData(resources);
		int total = resourcesService.selectPageDataSize(resources);
		if(data!=null&&data.size()>0){
			page.setData(data);
			page.setRecordsFiltered(total);
			page.setRecordsTotal(total);
		}
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPage(Model model,HttpServletRequest request){
		return "security/resource/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Model model,HttpServletRequest request,SysResources resources){
		try{
			if(resources!=null){
				resources.setResId(UUID.randomUUID().toString());
				resources.setCtTime(Calendar.getInstance().getTime());
				resources.setCtUserId(SecurityUtil.getCurrentUserName());
				resources.setDel((short) 0);
				resourcesService.insert(resources);
				
				// 是否同步添加权限
				String isSynchronizeAddPrivilege = request.getParameter("synchronize");
				if("1".equals(isSynchronizeAddPrivilege)){
					// 添加权限表
					SysPrivilege sysPrivilege = new SysPrivilege();
					sysPrivilege.setPvgName(resources.getResName());
					sysPrivilege.setPvgDesc(resources.getResDesc());
					sysPrivilege.setPvgPid(resources.getResPid());
					sysPrivilege.setPvgId(resources.getResId());
					sysPrivilege.setAllowDel((short) 1);
					sysPrivilege.setAllowEdit((short) 1);
					sysPrivilege.setCtTime(Calendar.getInstance().getTime());
					sysPrivilege.setCtUserId(SecurityUtil.getCurrentUserName());
					sysPrivilege.setDel((short) 0);
					privilegeService.insert(sysPrivilege);
					
					// 添加资源权限中间表数据
					SysResPvg sysResPvg = new SysResPvg();
					sysResPvg.setResPvgId(resources.getResId());
					sysResPvg.setResId(resources.getResId());
					sysResPvg.setPvgId(sysPrivilege.getPvgId());
					sysResPvg.setAllowDel((short) 1);
					sysResPvg.setAllowEdit((short) 1);
					sysResPvg.setCtTime(Calendar.getInstance().getTime());
					sysResPvg.setCtUserId(SecurityUtil.getCurrentUserName());
					sysResPvg.setDel((short) 0);
					resourcePrivilegeService.insert(sysResPvg);
				}
				
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
			SysResources sysResources = resourcesService.selectByPrimaryKey(id);
			SysResources parentResource = sysResources != null ? resourcesService.selectByPrimaryKey(sysResources.getResPid()) : null;
			if(parentResource != null){
				sysResources.setResPidName(parentResource.getResName());
			}
			model.addAttribute("vobj", sysResources);
		}
		return "security/resource/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String edit(Model model,HttpServletRequest request,SysResources resources){
		try{
			if(resources!=null){
				resources.setUpTime(Calendar.getInstance().getTime());
				resources.setUpUserId(SecurityUtil.getCurrentUserName());
				resourcesService.update(resources);
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
			SysResources sysResources = resourcesService.selectByPrimaryKey(id);
			SysResources parentResource = sysResources != null ? resourcesService.selectByPrimaryKey(sysResources.getResPid()) : null;
			if(parentResource != null){
				sysResources.setResPidName(parentResource.getResName());
			}
			model.addAttribute("vobj", sysResources);
		}
		return "security/resource/detail";
	}
	
	@RequestMapping(value = "/resourceTree", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String resourceTree(Model model,HttpServletRequest request){
		List<ResourceNode> list = resourcesService.selectResourceTree();
		if(list.size()>0){
			return JSONObject.toJSONString(list);
		}
		return "-1";
	}
	
	@RequestMapping(value = "/isExist", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String isExist(Model model,HttpServletRequest request,SysResources resources,int max){
		int size = resourcesService.selectPageDataSize(resources);
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
				SysResources sysResources = resourcesService.selectByPrimaryKey(ids[i]);
				sysResources.setDel((short) 1);
				resourcesService.update(sysResources);
			}
			return "1";
		}
		return "0";
	}
}
