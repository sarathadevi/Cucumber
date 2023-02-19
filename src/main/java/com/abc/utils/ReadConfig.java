package com.abc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	static Properties prop;

	public static Properties readConfig() throws IOException {
		File src = new File("src\\test\\resources\\config.properties");
		prop = new Properties();
		FileInputStream fis = new FileInputStream(src);
		prop.load(fis);
		return prop;
	}

	public static String getUrl() {
		String url = prop.getProperty("url");
		return url;
	}
	public String getBrowser() {
		String browserName = prop.getProperty("browsername");
		return browserName;
	}
}
