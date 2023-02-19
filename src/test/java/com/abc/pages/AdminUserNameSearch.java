package com.abc.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUserNameSearch {
	
	
	WebDriver lDriver; //

	public AdminUserNameSearch(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(lDriver, this);
	}
	
	@FindBy(xpath = "//*[@class='oxd-form-row']/div[1]/div[1]//*[text()='Username']//following::div//*[@class='oxd-input oxd-input--active']")
	WebElement userTextBox;

	@FindBy(xpath = "//*[@type='submit'] [text()=' Search ']")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@class='oxd-table']//*[@class='oxd-table-body']/div/div/div[4]/div")
	List <WebElement> tableColSize;
	
	@FindBy(xpath = "//*[@class='oxd-userdropdown']//*[@class='oxd-userdropdown-name']")
	WebElement AdminName;

	public boolean userNamesearch(String searchusername) throws InterruptedException {
		boolean usernameMatch = false;
		
		Thread.sleep(5000);
		userTextBox.sendKeys(searchusername);
		
	     searchButton.click();
	    
	     
	     for(int a=0; a<tableColSize.size(); a++) {   //0 15  16
				String name = tableColSize.get(a).getText();
				String adminname=AdminName.getText();
				if(name.equalsIgnoreCase(adminname)) {
					usernameMatch = true;
				}
				else {
					usernameMatch = false;
				}
			}
			return usernameMatch;
			
		
			
	    }

}
