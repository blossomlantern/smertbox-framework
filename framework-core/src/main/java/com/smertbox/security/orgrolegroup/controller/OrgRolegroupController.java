package com.smertbox.security.orgrolegroup.controller;

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

import com.smertbox.security.orgrolegroup.model.SysOrgRolegroup;
import com.smertbox.security.orgrolegroup.service.OrgRolegroupService;

@Controller
@RequestMapping("/security/orgrolegroup")
public class OrgRolegroupController {

	private static Logger logger = LoggerFactory.getLogger(OrgRolegroupController.class);
	
	@Autowired
	OrgRolegroupService orgRolegroupService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String orgId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			orgRolegroupService.deleteByOrgId(orgId);
			for (int i = 0; i < nd.length; i++) {
				SysOrgRolegroup sysOrgRolegroup = new SysOrgRolegroup();
				sysOrgRolegroup.setOrId(UUID.randomUUID().toString());
				sysOrgRolegroup.setOrgId(orgId);
				sysOrgRolegroup.setRgId(nd[i]);
				sysOrgRolegroup.setCreateTime(Calendar.getInstance().getTime());
				orgRolegroupService.insert(sysOrgRolegroup);
			}
			return "1";
		}else if(StringUtils.isNotBlank(orgId)){
			orgRolegroupService.deleteByOrgId(orgId);
			return "1";
		}
		return "0";
	}
}
