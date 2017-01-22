package com.smertbox.util.uuid;

import java.util.Random;
import java.util.UUID;

import com.alibaba.fastjson.JSON;

public class UUIDUtil {
	
	/**
	 * @Description 获得一个UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉 "-" 符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}

	/**
	 * @Description 获得指定字符的UUID
	 * @param number 需要获得的UUID字符数量
	 */
	public static String getUUID(int number) {
		if (number < 1)
			return null;
		return UUID.randomUUID().toString().replace("-", "").substring(0, number);
	}

	/**
	 * @Description 获得指定数量的UUID
	 * @param number 需要获得的UUID数量
	 */
	public static String[] getUUIDS(int number) {
		if (number < 1) {
			return null;
		}
		String[] strs = new String[number];
		for (int i = 0; i < number; i++) {
			strs[i] = getUUID();
		}
		return strs;
	}
	
	/**
	 * 随机数
	 */
	public static String getRandom() {
		char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		int length = 6;
		String result = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int rd = random.nextInt(10);
			result += str[rd];
		}
		return result;
	}

	
	/**
	 * 转JSON字符串
	 */
	public static <T> String serialize(T object) {
        return JSON.toJSONString(object);
    }
	
	public static void main(String[] args) {
		String string = getRandom();
		System.out.println(string);
		System.out.println("UUID:"+UUID.randomUUID().toString());
	}
}
