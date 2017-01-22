package com.smertbox.security.rolepvggroup.controller;

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

import com.smertbox.security.rolepvggroup.model.SysRolePvggroup;
import com.smertbox.security.rolepvggroup.service.RolePvggroupService;

@Controller
@RequestMapping("/security/rolepvggroup")
public class RolePvggroupController {

	private static Logger logger = LoggerFactory.getLogger(RolePvggroupController.class);
	
	@Autowired
	RolePvggroupService rolePvggroupService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String roleId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			rolePvggroupService.deleteByPgId(roleId);
			for (int i = 0; i < nd.length; i++) {
				SysRolePvggroup sysRolePvggroup = new SysRolePvggroup();
				sysRolePvggroup.setId(UUID.randomUUID().toString());
				sysRolePvggroup.setRoleId(roleId);
				sysRolePvggroup.setPvggroupId(nd[i]);
				sysRolePvggroup.setCreateTime(Calendar.getInstance().getTime());
				rolePvggroupService.insert(sysRolePvggroup);
			}
			return "1";
		}else if(StringUtils.isNotBlank(roleId)){
			rolePvggroupService.deleteByPgId(roleId);
			return "1";
		}
		return "0";
	}
}
