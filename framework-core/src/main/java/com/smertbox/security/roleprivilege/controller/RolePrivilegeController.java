package com.smertbox.security.roleprivilege.controller;

import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smertbox.security.roleprivilege.model.SysRolePrivilege;
import com.smertbox.security.roleprivilege.service.RolePrivilegeService;

@Controller
@RequestMapping("/security/roleprivilege")
public class RolePrivilegeController {
	
	@Autowired
	RolePrivilegeService rolePrivilegeService;

	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String roleId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			rolePrivilegeService.deleteByRoleId(roleId);
			for (int i = 0; i < nd.length; i++) {
				SysRolePrivilege sysRolePrivilege = new SysRolePrivilege();
				sysRolePrivilege.setRpId(UUID.randomUUID().toString());
				sysRolePrivilege.setRoleId(roleId);
				sysRolePrivilege.setPvgId(nd[i]);
				sysRolePrivilege.setCreateTime(Calendar.getInstance().getTime());
				rolePrivilegeService.insert(sysRolePrivilege);
			}
			return "1";
		}else if(StringUtils.isNotBlank(roleId)){
			rolePrivilegeService.deleteByRoleId(roleId);
			return "1";
		}
		return "0";
	}
}
