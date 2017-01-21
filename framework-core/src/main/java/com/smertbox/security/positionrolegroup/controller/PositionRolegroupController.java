package com.smertbox.security.positionrolegroup.controller;

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

import com.smertbox.security.positionrolegroup.model.SysPositionRolegroup;
import com.smertbox.security.positionrolegroup.service.PositionRolegroupService;

@Controller
@RequestMapping("/security/positionrolegroup")
public class PositionRolegroupController {

	private static Logger logger = LoggerFactory.getLogger(PositionRolegroupController.class);
	
	@Autowired
	PositionRolegroupService positionRolegroupService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String positionId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			positionRolegroupService.deleteByPositionId(positionId);
			for (int i = 0; i < nd.length; i++) {
				SysPositionRolegroup sysPositionRolegroup = new SysPositionRolegroup();
				sysPositionRolegroup.setPrId(UUID.randomUUID().toString());
				sysPositionRolegroup.setPositionId(positionId);
				sysPositionRolegroup.setRgId(nd[i]);
				sysPositionRolegroup.setCreateTime(Calendar.getInstance().getTime());
				positionRolegroupService.insert(sysPositionRolegroup);
			}
			return "1";
		}else if(StringUtils.isNotBlank(positionId)){
			positionRolegroupService.deleteByPositionId(positionId);
			return "1";
		}
		return "0";
	}
}
