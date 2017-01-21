package com.smertbox.security.userorg.controller;

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

import com.smertbox.security.userorg.model.SysUserOrg;
import com.smertbox.security.userorg.service.UserOrgService;

@Controller
@RequestMapping("/security/userorg")
public class UserOrgController {

	private static Logger logger = LoggerFactory.getLogger(UserOrgController.class);
	
	@Autowired
	UserOrgService userOrgService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String userId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			userOrgService.deleteByUserId(userId);
			for (int i = 0; i < nd.length; i++) {
				SysUserOrg sysUserOrg = new SysUserOrg();
				sysUserOrg.setUoId(UUID.randomUUID().toString());
				sysUserOrg.setUserId(userId);
				sysUserOrg.setOrgId(nd[i]);
				sysUserOrg.setCreateTime(Calendar.getInstance().getTime());
				userOrgService.insert(sysUserOrg);
			}
			return "1";
		}else if(StringUtils.isNotBlank(userId)){
			userOrgService.deleteByUserId(userId);
			return "1";
		}
		return "0";
	}
}
