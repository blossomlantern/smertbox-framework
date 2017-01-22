package com.smertbox.util.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Author : ladeng
 * Time: 2016年11月19日 下午11:45:32
 * Desc : 文件工具类
 */
public class FileUtil {

	/**
	 * 是否是图片文件
	 * @param file 
	 * @return
	 */
	public static boolean isImage(String file){
		boolean flag = false;
		try {
			BufferedImage image = ImageIO.read(new File(file));
			if(image != null){
				flag = true;
			}
		} catch (IOException e) {
			flag = false;
		}
		return flag;
	}
}
