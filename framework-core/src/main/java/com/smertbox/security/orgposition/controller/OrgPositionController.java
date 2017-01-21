package com.smertbox.security.orgposition.controller;

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

import com.smertbox.security.orgposition.model.SysOrgPosition;
import com.smertbox.security.orgposition.service.OrgPositionService;

@Controller
@RequestMapping("/security/orgposition")
public class OrgPositionController {

	private static Logger logger = LoggerFactory.getLogger(OrgPositionController.class);
	
	@Autowired
	OrgPositionService orgPositionService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String orgId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			orgPositionService.deleteByOrgId(orgId);
			for (int i = 0; i < nd.length; i++) {
				SysOrgPosition sysOrgPosition = new SysOrgPosition();
				sysOrgPosition.setOpId(UUID.randomUUID().toString());
				sysOrgPosition.setOrgId(orgId);
				sysOrgPosition.setPositionId(nd[i]);
				sysOrgPosition.setCreateTime(Calendar.getInstance().getTime());
				orgPositionService.insert(sysOrgPosition);
			}
			return "1";
		}else if(StringUtils.isNotBlank(orgId)){
			orgPositionService.deleteByOrgId(orgId);
			return "1";
		}
		return "0";
	}
}
