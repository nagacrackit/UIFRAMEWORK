package com.testweb.testcases;


import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.testweb.pages.BaseClass;
import com.testweb.pages.LoginPage;

public class LoginToCsm extends BaseClass {
	
	@Test
	public void CsmLogin() throws InterruptedException {
		logger=report.createTest("Login to CSM");
		LoginPage logPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");
		logPage.loginCSM(excel.getData("login", 0, 0),excel.getData("login", 0, 1));
		logger.pass("Login success");
		
		
	}

}
