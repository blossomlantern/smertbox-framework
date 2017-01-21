package com.smertbox.security.userposition.controller;

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

import com.smertbox.security.userposition.model.SysUserPosition;
import com.smertbox.security.userposition.service.UserPositionService;

@Controller
@RequestMapping("/security/userposition")
public class UserPositionController {

	private static Logger logger = LoggerFactory.getLogger(UserPositionController.class);
	
	@Autowired
	UserPositionService userPositionService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String userId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			userPositionService.deleteByUserId(userId);
			for (int i = 0; i < nd.length; i++) {
				SysUserPosition sysUserPosition = new SysUserPosition();
				sysUserPosition.setUpId(UUID.randomUUID().toString());
				sysUserPosition.setUserId(userId);
				sysUserPosition.setPositionId(nd[i]);
				sysUserPosition.setCreateTime(Calendar.getInstance().getTime());
				userPositionService.insert(sysUserPosition);
			}
			return "1";
		}else if(StringUtils.isNotBlank(userId)){
			userPositionService.deleteByUserId(userId);
			return "1";
		}
		return "0";
	}
}
