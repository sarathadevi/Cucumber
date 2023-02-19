package com.abc.steps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.abc.utils.DriverFactroy;
import com.abc.utils.ReadConfig;
import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.masterthought.cucumber.ReportParser;

public class Hooks {
	
	static WebDriver driver;
	ReadConfig readConfig;
	String browserNmae ; 
	
	
	@Before(order = 0)
	public void startUp() throws IOException {
		readConfig = new ReadConfig();
		readConfig.readConfig();
		browserNmae = readConfig.getBrowser();
		DriverFactroy.driverSetup(browserNmae, readConfig.getUrl());
		this.driver = DriverFactroy.getDriver();
		//driver.get(readConfig.getUrl());
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Before("@sanity")
	public void strating() {
		System.out.println("**************STARTING TEST");
	}
	
	@After
	public void shutdown(Scenario scenario) {
		if(scenario.isFailed() == true) {
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				
				byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", screenShotName);
				
				//Take Failed Screenshots
				File sourceType = ts.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(".\\screenshots\\"+screenShotName+".png");
				Files.copy(sourceType, destinationPath);
			
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//driver.close();
		driver.quit();
		System.out.print("close");
				
	}
	
	
	
	
	
}
