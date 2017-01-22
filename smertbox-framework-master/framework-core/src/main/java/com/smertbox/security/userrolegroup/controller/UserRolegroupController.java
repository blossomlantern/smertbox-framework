package com.smertbox.security.userrolegroup.controller;

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

import com.smertbox.security.userrolegroup.model.SysUserRolegroup;
import com.smertbox.security.userrolegroup.service.UserRolegroupService;

@Controller
@RequestMapping("/security/userrolegroup")
public class UserRolegroupController {

	private static Logger logger = LoggerFactory.getLogger(UserRolegroupController.class);
	
	@Autowired
	UserRolegroupService userRolegroupService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String userId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			userRolegroupService.deleteByUserId(userId);
			for (int i = 0; i < nd.length; i++) {
				SysUserRolegroup sysUserRolegroup = new SysUserRolegroup();
				sysUserRolegroup.setUrId(UUID.randomUUID().toString());
				sysUserRolegroup.setUserId(userId);
				sysUserRolegroup.setRgId(nd[i]);
				sysUserRolegroup.setCreateTime(Calendar.getInstance().getTime());
				userRolegroupService.insert(sysUserRolegroup);
			}
			return "1";
		}else if(StringUtils.isNotBlank(userId)){
			userRolegroupService.deleteByUserId(userId);
			return "1";
		}
		return "0";
	}
}
