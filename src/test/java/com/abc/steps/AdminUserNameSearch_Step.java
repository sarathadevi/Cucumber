package com.abc.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.abc.pages.AdminUserNameSearch;
import com.abc.utils.DriverFactroy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AdminUserNameSearch_Step {
	AdminUserNameSearch adminUserNameSearch;
	Hooks hooks;
	WebDriver driver;
	@Then("I search username as {string}")
	public void i_search_username_as(String searchusername) throws InterruptedException {
		hooks = new Hooks();
		driver = DriverFactroy.getDriver();
		adminUserNameSearch = new AdminUserNameSearch(driver);
		//adminUserNameSearch.userNamesearch(searchusername);
		Assert.assertEquals(adminUserNameSearch.userNamesearch(searchusername),true);
	
		//Assert.assertEquals(adminUserNameSearch.userNamesearch(username),true);
	}

}
