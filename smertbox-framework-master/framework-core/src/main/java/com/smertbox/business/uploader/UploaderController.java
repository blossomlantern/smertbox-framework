package com.smertbox.business.uploader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping(value = "/uploader")
public class UploaderController {

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String uploaderPage(Model model) {
		model.addAttribute("uuid", UUID.randomUUID().toString());
		return "upload";
	}
	
	@RequestMapping(value = "/pdf", method = RequestMethod.GET)
	public String pdf(Model model) {
		model.addAttribute("uuid", UUID.randomUUID().toString());
		return "pdf";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String uploader(HttpServletRequest request) {
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		Iterator<String> ite = multiRequest.getFileNames();
		MultipartFile file = null;
        while(ite.hasNext()){  
             file = multiRequest.getFile(ite.next());
        }
        String uuid = request.getParameter("uuid");
 		int chunk = Integer.parseInt(request.getParameter("chunk")); // 当前分片
        int chunks = Integer.parseInt(request.getParameter("chunks")); // 分片总计
		String fullname = file.getOriginalFilename();
		String suffix = fullname.substring(fullname.lastIndexOf(".")).toLowerCase();
		String target = "D:/Workspace/Temp/"+uuid+suffix;
		randomAccessFile(target,file);
		
		if(chunk == chunks - 1){
			return "0"; // 上传成功
		}else{
			return "2"; // 上传中
		}
	}

	public static boolean randomAccessFile(String outPath, MultipartFile tempFile) {
		RandomAccessFile raFile = null;
		BufferedInputStream inputStream = null;
		try {
			File dirFile = new File(outPath);
			raFile = new RandomAccessFile(dirFile, "rw");
			raFile.seek(raFile.length());
			inputStream = new BufferedInputStream(tempFile.getInputStream());
			byte[] buf = new byte[1024];
			int length = 0;
			while ((length = inputStream.read(buf)) != -1) {
				raFile.write(buf, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (raFile != null) {
					raFile.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
}
