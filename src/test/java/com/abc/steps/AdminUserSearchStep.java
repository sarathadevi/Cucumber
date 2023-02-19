package com.abc.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.abc.pages.AdminUserSearchPage;
import com.abc.utils.DriverFactroy;

import io.cucumber.java.en.Then;

public class AdminUserSearchStep {
	AdminUserSearchPage adminUserSearchPage;
	Hooks hooks;
	WebDriver driver;
	
	@Then("I navigate to admins page")
	public void i_navigate_to_admins_page() {
		hooks = new Hooks();
		driver = DriverFactroy.getDriver();
		adminUserSearchPage = new AdminUserSearchPage(driver);
		adminUserSearchPage.navigateAdminPage();
	}

	@Then("I search userrole as {string}")
	public void i_search_userrole_as(String userole) {
		Assert.assertEquals(adminUserSearchPage.userRoleSelection(userole),true);
	    
	}
}
