package com.abc.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.abc.utils.DriverFactroy;

import io.cucumber.java.en.Given;

public class ParallelSteps {
	
	WebDriver driver;
	
	@Given("i launch {string}")
	public void i_launch(String browserName) {
		if(browserName.equalsIgnoreCase("google")) {
			driver = DriverFactroy.getDriver();
			driver.get("https://www.google.com");
		}
		
		else {
			driver = DriverFactroy.getDriver();
			driver.get("https://www.bing.com");
		}
		
	}

	@Given("i search something on {string}")
	public void i_search_something_on(String browserName) {
	     driver.findElement(By.name("q")).sendKeys(browserName);
	}

}
