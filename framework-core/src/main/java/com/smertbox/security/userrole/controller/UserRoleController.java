package com.smertbox.security.userrole.controller;

import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smertbox.security.userrole.model.SysUserRole;
import com.smertbox.security.userrole.service.UserRoleService;

@Controller
@RequestMapping("/security/userrole")
public class UserRoleController {

	private static Logger logger = LoggerFactory.getLogger(UserRoleController.class);
	
	@Autowired
	UserRoleService userRoleService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String userId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			userRoleService.deleteByUserId(userId);
			for (int i = 0; i < nd.length; i++) {
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setUrId(UUID.randomUUID().toString());
				sysUserRole.setUserId(userId);
				sysUserRole.setRoleId(nd[i]);
				sysUserRole.setCreateTime(Calendar.getInstance().getTime());
				userRoleService.insert(sysUserRole);
			}
			return "1";
		}else if(StringUtils.isNotBlank(userId)){
			userRoleService.deleteByUserId(userId);
			return "1";
		}
		return "0";
	}
}
