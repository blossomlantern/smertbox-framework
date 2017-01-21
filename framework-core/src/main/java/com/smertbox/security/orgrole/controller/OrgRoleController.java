package com.smertbox.security.orgrole.controller;

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

import com.smertbox.security.orgrole.model.SysOrgRole;
import com.smertbox.security.orgrole.service.OrgRoleService;

@Controller
@RequestMapping("/security/orgrole")
public class OrgRoleController {

	private static Logger logger = LoggerFactory.getLogger(OrgRoleController.class);
	
	@Autowired
	OrgRoleService orgRoleService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String orgId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			orgRoleService.deleteByOrgId(orgId);
			for (int i = 0; i < nd.length; i++) {
				SysOrgRole sysOrgRole = new SysOrgRole();
				sysOrgRole.setOrId(UUID.randomUUID().toString());
				sysOrgRole.setOrgId(orgId);
				sysOrgRole.setRoleId(nd[i]);
				sysOrgRole.setCreateTime(Calendar.getInstance().getTime());
				orgRoleService.insert(sysOrgRole);
			}
			return "1";
		}else if(StringUtils.isNotBlank(orgId)){
			orgRoleService.deleteByOrgId(orgId);
			return "1";
		}
		return "0";
	}
}
