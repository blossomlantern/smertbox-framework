package com.smertbox.common.kaptcha;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * Author : ladeng
 * Time: 2016年8月27日 上午10:13:45
 * Desc : 验证码图片获取
 */
@Controller
@RequestMapping(value = "/kaptcha")
public class KaptchaController {

	private static Logger logger = Logger.getLogger(KaptchaController.class);
	
	@Autowired
	Producer captchaProducer;
	
	@RequestMapping("/image")
	public String getKaptcha(Model model,HttpServletRequest request,HttpServletResponse response){
		HttpSession session =  request.getSession();
		String kaptchaKey = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		logger.debug("kaptcha kaptchaKey:"+kaptchaKey);
		response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        response.setHeader("Pragma", "no-cache");  
        response.setContentType("image/jpeg");
        String kaptchaText = captchaProducer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, kaptchaText);
        BufferedImage bufferedImage = captchaProducer.createImage(kaptchaText); 
        ServletOutputStream outputStream = null;
        try {
        	outputStream = response.getOutputStream(); 
			ImageIO.write(bufferedImage, "jpg", outputStream);
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(outputStream!=null){
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
