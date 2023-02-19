package com.abc.steps;

import org.openqa.selenium.WebDriver;

import com.abc.pages.LoginPage;
import com.abc.utils.DriverFactroy;
import com.abc.utils.ReadConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class LoginSteps {
	
	LoginPage loginPage;
	Hooks hooks;
	WebDriver driver;

	@Given("I launch application")
	public void i_launch_application() {
		driver = DriverFactroy.getDriver();
		driver.get(ReadConfig.getUrl());
	}
	@Given("I enter the username as {string}")
	public void i_enter_the_username_as(String username) throws InterruptedException {
	   
		driver = DriverFactroy.getDriver();
		loginPage = new LoginPage(driver);
		loginPage.enterUserName(username);
		Thread.sleep(3000);
	}

	@Then("I enter the password as {string}")
	public void i_enter_the_password_as(String password) {
		loginPage.enterPassword(password);
	}
	
	@Given("I click on login button")
	public void i_click_on_login_button() {
		 loginPage.clickLoginbutton();
	}

	@Then("I check the login is valid")
	public void i_check_the_login_is_valid() {
	   boolean checkLogin = loginPage.checkLoginSuccess();
	   //true false
	   Assert.assertEquals(checkLogin, true);
	}
	
	
	@Then("I check the login is invalid")
	public void i_check_the_login_is_invalid() {
	   boolean checkLogin = loginPage.checkLoginSuccess();
	   //true false
	   Assert.assertEquals(checkLogin, false);
	}
	
	@Then("I logout from application")
	public void i_logout_from_application() {
	    Assert.assertEquals(loginPage.checkLogoutSuccess(), true);
	}
}
