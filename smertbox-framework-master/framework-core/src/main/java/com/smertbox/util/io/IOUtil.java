package com.smertbox.util.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

/**
 * Author : ladeng
 * Time: 2016年9月21日 下午11:45:32
 * Desc : IO文件读写方法类
 */
public class IOUtil {

	/**
	 * @description 使用随机文件写方式将文件写到硬盘
	 * @param outPutFile
	 * @param tempFile
	 * @return
	 */
	public static int randomAccessWriteFile(String outPutFile, MultipartFile tempFile) {
		RandomAccessFile randomAccessFile = null;
		BufferedInputStream inputStream = null;
		try {
			File dirFile = new File(outPutFile);
			File dirPath = new File(dirFile.getParent());
			if(!dirPath.exists()||!dirPath.isDirectory()){
				dirPath.mkdirs();
			}
			randomAccessFile = new RandomAccessFile(dirFile, "rw");
			randomAccessFile.seek(randomAccessFile.length());
			inputStream = new BufferedInputStream(tempFile.getInputStream());
			byte[] buf = new byte[1024];
			int length = 0;
			while ((length = inputStream.read(buf)) != -1) {
				randomAccessFile.write(buf, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (randomAccessFile != null) {
					randomAccessFile.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		return 1;
	}
	
	/**
	 * @description 使用随机文件写方式将文件写到硬盘
	 * @param outPutFile
	 * @param tempFile
	 * @return
	 */
	public static int randomAccessWriteFile(String outPutFile, File tempFile) {
		RandomAccessFile randomAccessFile = null;
		BufferedInputStream inputStream = null;
		InputStream is = null;
		try {
			File dirFile = new File(outPutFile);
			File dirPath = new File(dirFile.getParent());
			if(!dirPath.exists()||!dirPath.isDirectory()){
				dirPath.mkdirs();
			}
			randomAccessFile = new RandomAccessFile(dirFile, "rw");
			randomAccessFile.seek(randomAccessFile.length());
			is = new FileInputStream(tempFile);
			inputStream = new BufferedInputStream(is);
			byte[] buf = new byte[1024];
			int length = 0;
			while ((length = inputStream.read(buf)) != -1) {
				randomAccessFile.write(buf, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (randomAccessFile != null) {
					randomAccessFile.close();
				}
				if(is!=null){
					is.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		return 1;
	}
	
	/**
     * 随机读取文件内容
     */
    public static void randomAccessReadFile(String inputFile,OutputStream os) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(inputFile, "r");
            //long fileLength = randomAccessFile.length();
            // 读文件的起始位置
           // int beginIndex = (fileLength > 8) ? 8 : 0;
            // 将读文件的开始位置移到beginIndex位置
            randomAccessFile.seek(0);
            byte[] bytes = new byte[8];
            int read = 0;
            // 一次读8个字节，如果文件内容不足8个字节，则读剩下的字节。
            // 将一次读取的字节数赋给read
            while ((read = randomAccessFile.read(bytes)) != -1) {
                //System.out.write(bytes, 0, read);
            	os.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	if(os != null){
        		try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
            if (randomAccessFile != null) {
            	try {
					randomAccessFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
    }
    
    /**
     * 读取图片文件通过自定义宽度和高度
     * 如果输出文件为空 则输出默认文件 默认文件在项目根路径当中，默认文件只需传入根路径一下的部分路径
     * 
     * 特别注意：Thumbnails不支持网页特有的图片格式 诸如svg、ico等 如果使用将会报错，请谨慎使用！
     * 
     * @param inputFile 传入文件
     * @param os 输出到流
     * @param width 宽度
     * @param height 高度
     * @param type 输出图片类型
     * @param defaultFile 默认文件路径
     */
    public static void readImageByWidthHeight(String inputFile,OutputStream os,int width,int height,String type,String defaultFile) {
        	try {
        		File file = new File(inputFile);
        		if(!file.exists()){
        			Thumbnails.of(defaultFile).size(width, height).outputFormat(type).toOutputStream(os);
        		}else{
        			Thumbnails.of(inputFile).size(width, height).outputFormat(type).toOutputStream(os);
        		}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(os != null){
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
    }
    
    /**
     * 按照特定宽高输出默认图片文件
     * 
     * 特别注意：Thumbnails不支持网页特有的图片格式 诸如svg、ico等 如果使用将会报错，请谨慎使用！
     * 
     * @param os
     * @param width
     * @param height
     * @param type
     * @param defaultFile
     */
    public static void readDefaultImageByWidthHeight(OutputStream os,int width,int height,String type,String defaultFile) {
    	try {
			Thumbnails.of(defaultFile).size(width, height).outputFormat(type).toOutputStream(os);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
}
    
    /**
	 * @description 复制文件到指定定文件
	 * @param fromFile
	 * @param toFile
	 */
	public static int copyFile(String fromFile, String toFile) {
		File originalFile = new File(fromFile);
		File newFile = new File(toFile);
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new BufferedInputStream(new FileInputStream(originalFile));
			os = new BufferedOutputStream(new FileOutputStream(newFile));
			byte[] bt = new byte[4096];
			int i;
			while((i = is.read(bt))!=-1){
				os.write(bt,0,i);
			}
			return 1;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(os!=null){
					os.close();
				}
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
    
    /**
     * @description 删除文件
     */
    public static int deleteFile(String deleteFile){
		File file = new File(deleteFile);
		if (file.exists() && file.isFile()) {
			file.delete();
			return 1;
		}else if(!file.exists()){
			return 2;//文件不存在
		}
		return 0;
    }
    
    /**
	 * @description 删除文件夹
	 * @param folderPath
	 */
	public static int deleteFolder(String folderPath) {
		try {
			deleteAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * @description 删除指定文件夹下所有文件
	 * @param path
	 * @return
	 */
	public static int deleteAllFile(String path) {
		int flag = 0;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				deleteAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				deleteFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = 1;
			}
		}
		return flag;
	}
}
