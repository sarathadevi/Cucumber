package com.abc.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactroy {

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public static void driverSetup(String browserName, String url) {
		if(browserName.contains("chrome")) {
			ChromeOptions co = new ChromeOptions();
			//co.addArguments("--headless");
			tlDriver.set(new ChromeDriver());			
		}
		else if(browserName.contains("edge")) {
			//driver = new EdgeDriver();
		}
		else {
			System.out.println("BROWSER IS NOT DEFINED");
		}
		
	}
	
	public static  WebDriver getDriver() {
		return tlDriver.get();
	}
	
}
