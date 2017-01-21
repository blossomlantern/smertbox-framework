package com.smertbox.security.pvgpvggroup.controller;

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

import com.smertbox.security.pvgpvggroup.model.SysPvgPvggroup;
import com.smertbox.security.pvgpvggroup.service.PvgPvggroupService;

@Controller
@RequestMapping("/security/pvgpvggroup")
public class PvgPvggroupController {

	private static Logger logger = LoggerFactory.getLogger(PvgPvggroupController.class);
	
	@Autowired
	PvgPvggroupService pvgPvggroupService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String save(HttpServletRequest request,String nodes,String pgId){
		if(StringUtils.isNotBlank(nodes)){
			String[] nd = nodes.split(",");
			pvgPvggroupService.deleteByPgId(pgId);
			for (int i = 0; i < nd.length; i++) {
				SysPvgPvggroup sysPvgPvggroup = new SysPvgPvggroup();
				sysPvgPvggroup.setId(UUID.randomUUID().toString());
				sysPvgPvggroup.setPgId(pgId);
				sysPvgPvggroup.setPvgId(nd[i]);
				sysPvgPvggroup.setCreateTime(Calendar.getInstance().getTime());
				pvgPvggroupService.insert(sysPvgPvggroup);
			}
			return "1";
		}else if(StringUtils.isNotBlank(pgId)){
			pvgPvggroupService.deleteByPgId(pgId);
			return "1";
		}
		return "0";
	}
}
