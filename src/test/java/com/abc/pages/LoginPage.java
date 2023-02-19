package com.abc.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver lDriver;  //

	public LoginPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(lDriver, this);
	}
	
	
	//actions in method
	
	@FindBy(name="username")
	WebElement usernameBox;  //element will stored
	
	public void enterUserName(String username) {
		usernameBox.sendKeys(username);
	}
	
	@FindBy(name="password")
	WebElement passwordBox;
	
	public void enterPassword(String password) {
		passwordBox.sendKeys(password);
	}
	
	@FindBy(xpath = "//*[contains(@class, 'login')] [@type='submit']")
	WebElement loginButton;
	
	public void clickLoginbutton() {
		loginButton.click();
	}
	
	

	@FindBy(xpath = "//*[@class='oxd-userdropdown']/span/img")
	WebElement profileIcon;
	
	@FindBy(xpath = "//*[@class='oxd-userdropdown']/span/img")
	List <WebElement> profileIconSize;
	
	public boolean checkLoginSuccess() {
//		boolean isProfileIconDisplayed = profileIcon.isDisplayed();  //true
//		return isProfileIconDisplayed;  
		boolean isProfileIconDisplayed = false;
		int size = profileIconSize.size();
		if(size >=1 ){
			isProfileIconDisplayed = true;
		}
		return isProfileIconDisplayed;
		
	}
	
	@FindBy(xpath = "//*[@class='oxd-dropdown-menu']/li//*[text()='Logout']")
	WebElement logoutButton;
	
	public boolean checkLogoutSuccess() {
		profileIcon.click();
		logoutButton.click();
		boolean isLogoutSuccess = false;
		isLogoutSuccess = usernameBox.isDisplayed();
		return isLogoutSuccess;
		
	}
	
}
