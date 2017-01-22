package com.smertbox.security.rolerolegroup.controller;

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

import com.smertbox.security.rolerolegroup.model.SysRoleRolegroup;
import com.smertbox.security.rolerolegroup.service.RoleRolegroupService;

@Controller
@RequestMapping("/security/rolerolegroup")
public class RoleRolegroupController {

	private static Logger logger = LoggerFactory.getLogger(RoleRolegroupController.class);
	
	@Autowired
	RoleRolegroupService roleRolegroupService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String rgId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			roleRolegroupService.deleteByRgId(rgId);
			for (int i = 0; i < nd.length; i++) {
				SysRoleRolegroup sysRoleRolegroup = new SysRoleRolegroup();
				sysRoleRolegroup.setId(UUID.randomUUID().toString());
				sysRoleRolegroup.setRgId(rgId);
				sysRoleRolegroup.setRoleId(nd[i]);
				sysRoleRolegroup.setCreateTime(Calendar.getInstance().getTime());
				roleRolegroupService.insert(sysRoleRolegroup);
			}
			return "1";
		}else if(StringUtils.isNotBlank(rgId)){
			roleRolegroupService.deleteByRgId(rgId);
			return "1";
		}
		return "0";
	}
}
