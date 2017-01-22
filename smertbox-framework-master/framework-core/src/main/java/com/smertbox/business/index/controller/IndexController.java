package com.smertbox.business.index.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smertbox.security.core.util.SecurityUtil;
import com.smertbox.security.menu.service.MenuService;
import com.smertbox.security.position.model.SysPosition;
import com.smertbox.security.position.service.PositionService;
import com.smertbox.security.user.model.SysUser;
import com.smertbox.security.user.service.UserService;

@Controller
@RequestMapping("/")
public class IndexController {

	private static Logger logger = Logger.getLogger(IndexController.class);
	
	@Autowired
	MenuService menuService;
	@Autowired
	PositionService positionService;
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String defaultPage(Model model){
		
	     return "index";  
	}
	
	@RequestMapping(value="/security/manage",method=RequestMethod.GET)
	public String manage(Model model){
		try{
			String loginAccount = SecurityUtil.getCurrentUserName();
			// 用户职位
			StringBuffer position = new StringBuffer();
			if(StringUtils.isNotBlank(loginAccount)){
				String menu = menuService.selectMenuByUser(loginAccount);
				model.addAttribute("menu", menu != null ? menu : "null");
				
				List<SysPosition> positions = positionService.selectByLoginAccount(loginAccount);
				if(positions != null && positions.size() > 0){
					for (int i = 0; i < positions.size(); i++) {
						position.append("、" + positions.get(i).getPositionName());
					}
				}
				
				//SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				//SysUser su = user.getSysUser();
				SysUser user = userService.selectByLoginAccount(loginAccount);
				
				if(user != null && StringUtils.isNotBlank(user.getPhoto())){
					String attachmentId = user.getPhoto().split("=")[user.getPhoto().split("=").length-1];
					String path = "/api/attachment/downloadByWidthHeight?attachmentId=" + attachmentId + "&width=48&height=48";
					user.setPhoto(path);
				}else{
					String path = "/img/manage/default_photo.ico";
					user.setPhoto(path);
				}
				
				model.addAttribute("user", user);
			}
			
			
			
			model.addAttribute("position",position.toString().length() > 1 ? position.toString().substring(1) : "");
		}catch(Exception e){
			logger.error("IndexController manage error: "+ExceptionUtils.getFullStackTrace(e));
		}
		
	    return "manage";  
	}
	
	@RequestMapping(value="/skin-config",method=RequestMethod.GET)
	public String skin_config(Model model){
		
	     return "skin-config";  
	}
	
	@RequestMapping(value="/security/test",method=RequestMethod.GET)
	@ResponseBody
	public String test(Model model){
		//SysUser user = sysUserMapper.selectByPrimaryKey("admin");
		//return sysResourcesMapper.selectAll().toString();
		return null;
	}
}
