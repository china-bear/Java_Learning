package com.chinabear.jdbc.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {

	private static Properties properties;

	static {
		properties = new Properties();
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			properties.load(classLoader.getResourceAsStream("application.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
	    if (properties == null) {
	        try {
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				properties.load(classLoader.getResourceAsStream("application.properties"));
            } catch (IOException e) {
              e.printStackTrace();
            }
        }
		return properties.getProperty(key);
	}
	
	public static Map<String, String> loadToMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("url", get("url"));
        map.put("driverClassName", get("driverClassName"));
        map.put("username", get("username"));
        map.put("password", get("password"));
        return map;
        
    }
	public static void main(String[] args) {
		System.out.println(properties.getProperty("odin.openapi.url"));
		System.out.println(properties.getProperty("odin.openapi.user"));
		System.out.println(properties.getProperty("odin.openapi.password"));
		System.out.println("==================================");
		System.out.println(PropertiesUtils.get("odin.openapi.url"));
		System.out.println(PropertiesUtils.get("odin.openapi.user"));
		System.out.println(PropertiesUtils.get("odin.openapi.password"));
	}
}

