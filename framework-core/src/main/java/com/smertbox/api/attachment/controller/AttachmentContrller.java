package com.smertbox.api.attachment.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.smertbox.api.attachment.model.CmAttachment;
import com.smertbox.api.attachment.service.AttachmentService;
import com.smertbox.security.core.util.SecurityUtil;
import com.smertbox.system.application.ApplicationContext;
import com.smertbox.util.file.FileUtil;
import com.smertbox.util.io.IOUtil;
import com.smertbox.util.page.DataTablePage;
import com.smertbox.util.properties.PropertiesUitl;

@Controller
@RequestMapping("/api/attachment")
public class AttachmentContrller {

	private static Logger logger = LoggerFactory.getLogger(AttachmentContrller.class);
	
	@Autowired
	AttachmentService attachmentService;
	
	@RequestMapping("/listPage")
	public String listPage(Model model,HttpServletRequest request){
		
		return "api/attachment/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public DataTablePage list(Model model,DataTablePage page,HttpServletRequest request,CmAttachment attachment){
		attachment.setPage(request);// 设置查询分页信息参数
		List<CmAttachment> data = attachmentService.checkPhysicalState(attachmentService.selectPage(attachment));// 获取数据并检查附件物理状态
		int total = attachmentService.selectPageSize(attachment);
		if(data!=null&&data.size()>0){
			page.setData(data);
			page.setRecordsFiltered(total);
			page.setRecordsTotal(total);
		}
		return page;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			CmAttachment attachment = attachmentService.selectByPrimaryKey(id);
			model.addAttribute("vobj", attachment);
		}
		return "api/attachment/detail";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String delete(Model model,HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			String[] ids = id.split(",");
			for (int i = 0; i < ids.length; i++) {
				CmAttachment attachment = attachmentService.selectByPrimaryKey(ids[i]);
				attachment.setDel((short) 1);
				attachmentService.update(attachment);
			}
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value = "/deleteByPhysical", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String deleteByPhysical(HttpServletRequest request,String id){
		if(StringUtils.isNotBlank(id)){
			String[] ids = id.split(",");
			for (int i = 0; i < ids.length; i++) {
				CmAttachment attachment = attachmentService.selectByPrimaryKey(ids[i]);
				if(attachment != null){
					String dir = PropertiesUitl.getInstance().getSystemProperty("attachment.upload.dir");
					String deleteFile = dir + attachment.getRelativeAddr();
					attachmentService.deleteByPrimaryKey(ids[i]);
					IOUtil.deleteFile(deleteFile);
				}
			}
			return "1";
		}
		return "0";
	}
	
	@RequestMapping(value="/upload" ,method = RequestMethod.POST)
	@ResponseBody
	public String upload(HttpServletRequest request){
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
			MultipartFile multipartFile = null;
			for (Map.Entry<String, MultipartFile> set : fileMap.entrySet()) {
				multipartFile = set.getValue();
			}
			//String realPath = request.getSession().getServletContext().getRealPath("/");
			String uuid = request.getParameter("uuid");
			DateFormat format = new SimpleDateFormat("yyyyMMdd");
			String dir = PropertiesUitl.getInstance().getSystemProperty("attachment.upload.dir");
			String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
			String fullName = format.format(Calendar.getInstance().getTime()) + "/"+uuid+suffix;
			String outPutFile = dir + fullName;// 截取文件类型 拼接uuid
			// 文件访问地址
			String uri = "/api/attachment/download?attachmentId=" + uuid;
			// 文件写入硬盘
			int result =  IOUtil.randomAccessWriteFile(outPutFile,multipartFile);
			// 上传结果响应码
			int resultCode = 0;
			if(StringUtils.isNotBlank(request.getParameter("chunk"))){// 有分片
				int chunk = Integer.parseInt(request.getParameter("chunk")); // 当前分片节点
		        int chunks = Integer.parseInt(request.getParameter("chunks")); // 分片总计
				if(chunk == chunks - 1){
					resultCode = 1; // 上传成功
				}else{
					resultCode = 2; // 上传中
				}
			}else{// 无分片
				resultCode = 1; // 上传成功 
			}
			if(result==0){
				resultCode = 0; //上传失败
			}
			if(resultCode == 1){
				// 插入数据库表数据
				CmAttachment cac = new CmAttachment();
				cac.setAttachmentId(uuid);
				cac.setName(uuid+suffix);
				cac.setOriginalName(multipartFile.getOriginalFilename());
				cac.setPrefix(multipartFile.getOriginalFilename().substring(0,multipartFile.getOriginalFilename().lastIndexOf(".")));
				cac.setSuffix(multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1));
				cac.setPhysicalAddr(outPutFile);
				cac.setRelativeAddr(fullName);
				cac.setCreateTime(Calendar.getInstance().getTime());
				cac.setCtUserId(SecurityUtil.getCurrentUserName());
				cac.setDel((short) 0);
				attachmentService.insert(cac);
			}
			JSONObject ret = new JSONObject();
			ret.put("resultCode", resultCode);
			ret.put("uri", uri);
			
			return JSONObject.toJSONString(ret);
		} catch (Exception e) {
			logger.error("File upload error:" + ExceptionUtils.getFullStackTrace(e));
		}
		
		return null;
	}
	
	@RequestMapping(value="/download")
	public void download(HttpServletRequest request,HttpServletResponse response,String attachmentId){
		if(StringUtils.isNotBlank(attachmentId)){
			try {
				CmAttachment cac = attachmentService.findById(attachmentId);
				if(cac != null){
					String dir = PropertiesUitl.getInstance().getSystemProperty("attachment.upload.dir");
					String inputFile = dir + cac.getRelativeAddr();
					response.setContentType(request.getSession().getServletContext().getMimeType(inputFile));
					response.setHeader("Content-Disposition", "attachment;filename="+cac.getName());  
					OutputStream os = response.getOutputStream();
					IOUtil.randomAccessReadFile(inputFile, os);
				}
			} catch (IOException e) {
				logger.error("File download error:" + ExceptionUtils.getFullStackTrace(e));
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 通过自定宽度和高度下载图片
	 * @param request
	 * @param response
	 * @param attachmentId 附件id
	 * @param width 宽度
	 * @param height 高度
	 */
	@RequestMapping(value="/downloadByWidthHeight")
	public void downloadByWidthHeight(HttpServletRequest request,HttpServletResponse response,String attachmentId,int width,int height){
		if(StringUtils.isNotBlank(attachmentId) && width != 0 && height != 0){
			try {
				CmAttachment cac = attachmentService.findById(attachmentId);
				String defaultFile = ApplicationContext.applicationRootPath + "img/manage/default_photo.png";
				// 附件文件对象不为空 并且为图片文件
				if(cac != null && FileUtil.isImage(cac.getPhysicalAddr())){
					String dir = PropertiesUitl.getInstance().getSystemProperty("attachment.upload.dir");
					String inputFile = dir + cac.getRelativeAddr();
					response.setContentType(request.getSession().getServletContext().getMimeType(inputFile));
					response.setHeader("Content-Disposition", "attachment;filename="+cac.getName());  
					OutputStream os = response.getOutputStream();
					IOUtil.readImageByWidthHeight(inputFile, os, width, height, cac.getSuffix(),defaultFile);
				}else{
					response.setContentType(request.getSession().getServletContext().getMimeType(defaultFile));
					response.setHeader("Content-Disposition", "attachment;filename=default_photo");  
					OutputStream os = response.getOutputStream();
					IOUtil.readDefaultImageByWidthHeight(os, width, height, "png", defaultFile);
				}
			} catch (IOException e) {
				logger.error("File download error:" + ExceptionUtils.getFullStackTrace(e));
				e.printStackTrace();
			}
		}
	}
}
