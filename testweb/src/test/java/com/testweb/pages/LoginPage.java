package com.testweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	//add few more pages
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
		@FindBy(xpath="//input[@name='username1']") WebElement uname;
	@FindBy(xpath="//input[@name='password']") WebElement upass;
	@FindBy(xpath="//input[@value='Login']") WebElement logBtn;

	public void loginCSM(String AppUsername,String AppUserpass) {
		uname.sendKeys(AppUsername);
		upass.sendKeys(AppUserpass);
		logBtn.click();
	}
}
