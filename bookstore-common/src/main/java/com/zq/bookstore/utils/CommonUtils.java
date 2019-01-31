package com.zq.bookstore.utils;

import java.util.UUID;

/**
 * 通用工具类
 * @author Administrator
 *
 */
public class CommonUtils {
	/**
	 * 获取32位UUID
	 * @return
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
		return uuid;
	}
	
	public static void main(String[] args) {
		System.out.println(getUUID());
	}
}
