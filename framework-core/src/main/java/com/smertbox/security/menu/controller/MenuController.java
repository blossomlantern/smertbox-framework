package com.smertbox.security.menu.controller;

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
import com.smertbox.security.menu.model.SysMenu;
import com.smertbox.security.menu.service.MenuService;
import com.smertbox.security.resource.model.SysResources;
import com.smertbox.security.resource.service.ResourcesService;
import com.smertbox.util.page.DataTablePage;
import com.smertbox.util.tree.model.TreeNode;

@Controller
@RequestMapping("/security/menu")
public class MenuController {

	private static Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	MenuService menuService;
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
		
		return "security/menu/list";
	}
	
	/**
	 * @description 资源分页
	 * @param model
	 * @param page
	 * @param request
	 * @param sysMenu
	 * @return JSON数据
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,SysMenu sysMenu){
		sysMenu.setPage(request);// 设置查询分页信息参数
		List<SysMenu> data = menuService.selectPage(sysMenu);
		int total = menuService.selectPageSize(sysMenu);
		if(data!=null&&data.size()>0){
			page.setData(data);
			page.setRecordsFiltered(total);
			page.setRecordsTotal(total);
		}
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPage(Model model,HttpServletRequest request){
		return "security/menu/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Model model,HttpServletRequest request,SysMenu sysMenu){
		if(sysMenu!=null){
			sysMenu.setMenuId(UUID.randomUUID().toString());
			sysMenu.setCreateTime(Calendar.getInstance().getTime());
			sysMenu.setDel((short) 0);
			menuService.insert(sysMenu);
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPage(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysMenu sysMenu= menuService.selectByPrimaryKey(id);
			SysMenu parentMenu = sysMenu != null ? menuService.selectByPrimaryKey(sysMenu.getMenuPid()) : null;
			SysResources resource = sysMenu != null ? resourcesService.selectByPrimaryKey(sysMenu.getMenuUrl()) : null;
			if(parentMenu != null){
				sysMenu.setMenuPname(parentMenu.getMenuName());
			}
			if(resource != null){
				sysMenu.setMenuUrlValue(resource.getResName());
			}
			model.addAttribute("vobj", sysMenu);
		}
		return "security/menu/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String edit(Model model,HttpServletRequest request,SysMenu sysMenu){
		if(sysMenu!=null){
			menuService.update(sysMenu);
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysMenu sysMenu= menuService.selectByPrimaryKey(id);
			SysMenu parentMenu = sysMenu != null ? menuService.selectByPrimaryKey(sysMenu.getMenuPid()) : null;
			SysResources resource = sysMenu != null ? resourcesService.selectByPrimaryKey(sysMenu.getMenuUrl()) : null;
			if(parentMenu != null){
				sysMenu.setMenuPname(parentMenu.getMenuName());
			}
			if(resource != null){
				sysMenu.setMenuUrlValue(resource.getResUrl());
			}
			model.addAttribute("vobj", sysMenu);
		}
		return "security/menu/detail";
	}
	
	@RequestMapping(value = "/menuTree", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String menuTree(Model model,HttpServletRequest request){
		List<TreeNode> list = menuService.selectMenuTree();
		if(list.size()>0){
			return JSONObject.toJSONString(list);
		}
		return "-1";
	}
	
	@RequestMapping(value = "/resourceTree", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String resourceTree(Model model,HttpServletRequest request){
		List<TreeNode> list = menuService.selectResourceTree();
		if(list.size()>0){
			return JSONObject.toJSONString(list);
		}
		return "-1";
	}
	
	@RequestMapping(value = "/isExist", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String isExist(Model model,HttpServletRequest request,SysMenu sysMenu,int max){
		int size = menuService.selectPageSize(sysMenu);
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
				SysMenu sysMenu = menuService.selectByPrimaryKey(ids[i]);
				sysMenu.setDel((short) 1);
				menuService.update(sysMenu);
			}
			return "1";
		}
		return "0";
	}
}
