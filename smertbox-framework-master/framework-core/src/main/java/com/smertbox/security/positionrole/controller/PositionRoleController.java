package com.smertbox.security.positionrole.controller;

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

import com.smertbox.security.positionrole.model.SysPositionRole;
import com.smertbox.security.positionrole.service.PositionRoleService;

@Controller
@RequestMapping("/security/positionrole")
public class PositionRoleController {

	private static Logger logger = LoggerFactory.getLogger(PositionRoleController.class);
	
	@Autowired
	PositionRoleService positionRoleService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String positionId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			positionRoleService.deleteByPositionId(positionId);
			for (int i = 0; i < nd.length; i++) {
				SysPositionRole sysPositionRole = new SysPositionRole();
				sysPositionRole.setPrId(UUID.randomUUID().toString());
				sysPositionRole.setPositionId(positionId);
				sysPositionRole.setRoleId(nd[i]);
				sysPositionRole.setCreateTime(Calendar.getInstance().getTime());
				positionRoleService.insert(sysPositionRole);
			}
			return "1";
		}else if(StringUtils.isNotBlank(positionId)){
			positionRoleService.deleteByPositionId(positionId);
			return "1";
		}
		return "0";
	}
}
