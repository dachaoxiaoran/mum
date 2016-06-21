package com.mum.utils;

import static com.mum.constant.IConstant.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件工具
 * @author 王超
 *
 */
public class PropertiesUtil {
	
	/**
	 * @see java.util.Properties
	 */
	private static Properties properties;
	
	static {
		properties = new Properties();
		try {
			try(InputStream inputStream = PropertiesUtil.class.getResourceAsStream(CONFIG_PROPERTIES)) {
				properties.load(inputStream);
			}
		} catch(IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/**
	 * 根据属性文件key，获得value
	 * @param key 属性文件key
	 * @return 属性文件value
	 */
	public static String get(String key) {
		return properties.getProperty(key);
	}
	
	
	public static void set(String key, String value) throws IOException {
		properties.setProperty(key, value);
		try(FileOutputStream fileOutputStream = new FileOutputStream(PropertiesUtil.class.getResource(CONFIG_PROPERTIES).getPath())) {
			properties.store(fileOutputStream, "历史数据同步开始时间");
		}
	}
}
