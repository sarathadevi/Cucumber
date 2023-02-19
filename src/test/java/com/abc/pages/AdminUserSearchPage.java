package com.abc.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUserSearchPage {
	WebDriver lDriver; //

	public AdminUserSearchPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(lDriver, this);
	}

	@FindBy(xpath = "//*[@class='oxd-main-menu']/li//*[text()='Admin']")
	WebElement sideMenuAdminButton;

	public void navigateAdminPage() {
		sideMenuAdminButton.click();
	}
	
	@FindBy(xpath = "(//*[@class='oxd-form-row']/div[1]/div[2]//*[text()='User Role']//following::div//*[text()='-- Select --'])[1]")
	WebElement userDropDownBox;
	@FindBy(xpath="//*[@role='listbox']//div")
	List <WebElement> dropDownOption;
	@FindBy(xpath = "//*[@type='submit'] [text()=' Search ']")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@class='oxd-table']//*[@class='oxd-table-body']/div/div/div[3]/div")
	List <WebElement> tableColSize;
	
	public boolean userRoleSelection(String userole) {
		boolean userroleMatch = false;
		userDropDownBox.click();
		for(int a=0; a<=dropDownOption.size(); a++) {
			if(dropDownOption.get(a).getText().equalsIgnoreCase(userole)) {
				dropDownOption.get(a).click();
				break;
			}
		}
		searchButton.click();
		for(int a=0; a<tableColSize.size(); a++) {   //0 15  16
			String role = tableColSize.get(a).getText();
			if(role.equalsIgnoreCase(userole)) {
				userroleMatch = true;
			}
			else {
				userroleMatch = false;
			}
		}
		return userroleMatch;
	}
}
