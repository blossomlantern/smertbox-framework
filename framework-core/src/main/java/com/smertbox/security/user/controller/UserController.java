package com.smertbox.security.user.controller;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.smertbox.security.core.util.SecurityUtil;
import com.smertbox.security.organization.service.OrganizationService;
import com.smertbox.security.position.service.PositionService;
import com.smertbox.security.role.service.RoleService;
import com.smertbox.security.rolegroup.service.RolegroupService;
import com.smertbox.security.user.model.SysUser;
import com.smertbox.security.user.service.UserService;
import com.smertbox.security.userorg.model.SysUserOrg;
import com.smertbox.security.userorg.service.UserOrgService;
import com.smertbox.security.userposition.model.SysUserPosition;
import com.smertbox.security.userposition.service.UserPositionService;
import com.smertbox.security.userrole.model.SysUserRole;
import com.smertbox.security.userrole.service.UserRoleService;
import com.smertbox.security.userrolegroup.model.SysUserRolegroup;
import com.smertbox.security.userrolegroup.service.UserRolegroupService;
import com.smertbox.util.page.DataTablePage;
import com.smertbox.util.properties.PropertiesUitl;
import com.smertbox.util.tree.model.TreeNode;

@Controller
@RequestMapping("/security/user")
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	RolegroupService rolegroupService;
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	UserRolegroupService userRolegroupService;
	@Autowired
	OrganizationService organizationService;
	@Autowired
	UserOrgService userOrgService;
	@Autowired
	UserPositionService userPositionService;
	@Autowired
	PositionService positionService;

	@RequestMapping(value = "/listPage")
	public String index(Model model,HttpServletRequest request){
		
		return "security/user/list";
	}
	
	/**
	 * @description 分页
	 * @param model
	 * @param page
	 * @param request
	 * @return JSON数据
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,SysUser sysUser){
		try {
			sysUser.setPage(request);// 设置查询分页信息参数
			String loginAccount = SecurityUtil.getCurrentUserName();
			sysUser.setNowLoginAccount(loginAccount);
			List<SysUser> data = null;
			int total = 0;
			if(userService.ismanage(loginAccount)){
				data = userService.selectAdminPage(sysUser);
				total = userService.selectAdminPageSize(sysUser);
			}else{
				data = userService.selectPage(sysUser);
				total = userService.selectPageSize(sysUser);
			}
			if(data!=null&&data.size()>0){
				page.setData(data);
				page.setRecordsFiltered(total);
				page.setRecordsTotal(total);
			}
		} catch (Exception e) {
			logger.error("UserController list error:"+ExceptionUtils.getFullStackTrace(e));
		}
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPage(Model model,HttpServletRequest request){
		return "security/user/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Model model,HttpServletRequest request,SysUser sysUser){
		try{
			if(sysUser!=null){
				// 加密密码 使用sha256
				String salt = sysUser.getLoginAccount() + PropertiesUitl.getInstance().getProperty("spring-security/security.properties", "security.passwordencoder.salt");
				ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
				sha.setEncodeHashAsBase64(true);
				String password = sha.encodePassword(sysUser.getPasswd(), salt);
				String userid = UUID.randomUUID().toString();
				sysUser.setPasswd(password);
				sysUser.setUserId(userid);
				sysUser.setCreateTime(Calendar.getInstance().getTime());
				sysUser.setCtUserId(SecurityUtil.getCurrentUserName());
				sysUser.setDel((short) 0);
				
				if(StringUtils.isNotBlank(sysUser.getOrgSid())){
					String[] orgSid = sysUser.getOrgSid().split(",");
					for (int i = 0; i < orgSid.length; i++) {
						SysUserOrg suo = new SysUserOrg();
						suo.setUoId(UUID.randomUUID().toString());
						suo.setUserId(userid);
						suo.setOrgId(orgSid[i]);
						suo.setCreateTime(Calendar.getInstance().getTime());
						userOrgService.insert(suo);
					}
					sysUser.setOrgSid(null);
				}
				
				userService.insert(sysUser);
				return "1";
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "0";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPage(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysUser sysUser = userService.selectByPrimaryKey(id);
			model.addAttribute("vobj", sysUser);
		}
		return "security/user/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String edit(Model model,HttpServletRequest request,SysUser sysUser){
		try{
			if(sysUser!=null){
				sysUser.setUpTime(Calendar.getInstance().getTime());
				sysUser.setUpUserId(SecurityUtil.getCurrentUserName());
				userService.update(sysUser);
				return "1";
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "0";
	}
	
	@RequestMapping(value = "/resetpassword", method = RequestMethod.GET)
	public String resetpassword(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysUser sysUser = userService.selectByPrimaryKey(id);
			if(sysUser != null){
				model.addAttribute("vobj", sysUser);
			}else{
				return "redirect:/error/404";
			}
		}
		return "security/user/resetpassword";
	}
	
	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	@ResponseBody
	public String resetpassword(Model model,HttpServletRequest request,SysUser sysUser){
		try{
			if(sysUser!=null){
				// 加密密码 使用sha256
				String salt = sysUser.getLoginAccount() + PropertiesUitl.getInstance().getProperty("spring-security/security.properties", "security.passwordencoder.salt");
				ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
				sha.setEncodeHashAsBase64(true);
				String password = sha.encodePassword(sysUser.getPasswd(), salt);
				
				sysUser.setPasswd(password);
				sysUser.setUpTime(Calendar.getInstance().getTime());
				sysUser.setUpUserId(SecurityUtil.getCurrentUserName());
				
				userService.update(sysUser);
				return "1";
			}
		}catch(Exception e){
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return "0";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			SysUser sysUser = userService.selectByPrimaryKey(id);
			model.addAttribute("vobj", sysUser);
		}
		return "security/user/detail";
	}
	
	@RequestMapping(value = "/isExist", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String isExist(Model model,HttpServletRequest request,SysUser sysUser,int max){
		int size = userService.selectPageSize(sysUser);
		if(size <= max){
			return "0";
		}
		return "1";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String delete(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			String[] ids = id.split(",");
			for (int i = 0; i < ids.length; i++) {
				SysUser sysUser = userService.selectByPrimaryKey(ids[i]);
				sysUser.setDel((short) 1);
				userService.update(sysUser);
			}
			return "1";
		}
		return "0";
	}
	
	public static void main(String[] args) {
		ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
		sha.setEncodeHashAsBase64(true);
		String password = sha.encodePassword("test", "testsmertbox");
		System.out.println(password+"   "+password.length());
	}
	
	@RequestMapping(value = "/assignationRole", method = RequestMethod.GET)
	public String assignationRole(Model model,HttpServletRequest request,String id){
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setUserId(id);
		sysUserRole.setStart(-1);
		model.addAttribute("roles", JSONObject.toJSONString(userRoleService.selectPage(sysUserRole)));
		model.addAttribute("alls", roleService.selectPageByOrgId(getOrgByUserId(id)));
		model.addAttribute("userId", id);
		return "security/user/assignationRole";
	}
	
	@RequestMapping(value = "/assignationRolegroup", method = RequestMethod.GET)
	public String assignation(Model model,HttpServletRequest request,String id){
		SysUserRolegroup sysUserRolegroup = new SysUserRolegroup();
		sysUserRolegroup.setUserId(id);
		sysUserRolegroup.setStart(-1);
		model.addAttribute("rolegroups", JSONObject.toJSONString(userRolegroupService.selectPage(sysUserRolegroup)));
		model.addAttribute("alls", rolegroupService.selectPageByOrgId(getOrgByUserId(id)));
		model.addAttribute("userId", id);
		return "security/user/assignationRolegroup";
	}
	
	public Set<String> getOrgByUserId(String userId){
		Set<String> orgs = null;
		SysUserOrg sysUserOrg = new SysUserOrg();
		sysUserOrg.setUserId(userId);
		sysUserOrg.setStart(-1);
		List<SysUserOrg> suo = userOrgService.selectPage(sysUserOrg);
		if(suo != null && suo.size() > 0){
			orgs = new HashSet<String>();
			for (int i = 0; i < suo.size(); i++) {
				orgs.add(suo.get(i).getOrgId());
			}
		}
		return orgs;
	}
	
	@RequestMapping(value = "/assignationOrg", method = RequestMethod.GET)
	public String assignationOrg(Model model,HttpServletRequest request,String id){
		SysUserOrg sysUserOrg = new SysUserOrg();
		sysUserOrg.setUserId(id);
		sysUserOrg.setStart(-1);
		model.addAttribute("orgs", JSONObject.toJSONString(userOrgService.selectPage(sysUserOrg)));
		model.addAttribute("userId", id);
		return "security/user/assignationOrg";
	}
	
	@RequestMapping(value = "/assignationPosition", method = RequestMethod.GET)
	public String assignationPosition(Model model,HttpServletRequest request,String id){
		SysUserPosition sysUserPosition = new SysUserPosition();
		sysUserPosition.setUserId(id);
		sysUserPosition.setStart(-1);
		model.addAttribute("positions", JSONObject.toJSONString(userPositionService.selectPage(sysUserPosition)));
		model.addAttribute("alls", positionService.selectPageByUserId(id));
		model.addAttribute("userId", id);
		return "security/user/assignationPosition";
	}
	
	@RequestMapping(value = "/orgTree", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String orgTree(Model model,HttpServletRequest request){
		try {
			String loginAccount = SecurityUtil.getCurrentUserName();
			List<TreeNode> list = null;
			if(userService.ismanage(loginAccount)){
				list = organizationService.selectAdminOrganizationTree();
			}else{
				list = organizationService.selectOrganizationTree(SecurityUtil.getCurrentUserName());
			}
			if(list.size()>0){
				return JSONObject.toJSONString(list);
			}
		} catch (Exception e) {
			logger.error("UserController orgTree error:"+ExceptionUtils.getFullStackTrace(e));
		}
		return "-1";
	}
}
