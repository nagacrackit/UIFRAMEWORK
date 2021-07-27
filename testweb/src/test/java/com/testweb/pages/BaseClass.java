package com.testweb.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testweb.utilities.BrowserFactory;
import com.testweb.utilities.ConfigDataProvider;
import com.testweb.utilities.ExcelDataProvider;
import com.testweb.utilities.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
	Reporter.log("Setting up reports and test is getting ready",true);
	excel=new ExcelDataProvider();	
	config=new ConfigDataProvider();
	ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/"+Helper.getCurrentDateTime()+".html"));
	report=new ExtentReports();
	report.attachReporter(extent);
	Reporter.log("Setting is done-test can be started");
	}
	
	@BeforeClass
	public void setUp() {
		Reporter.log("Trying to start browser and getting application ready", true);
		driver=BrowserFactory.startApp(driver, config.getBrowser(), config.getQaUrl());
		Reporter.log("Browser and application is up and running", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBroser(driver);
	}
	
	@AfterMethod
	public void tearDownMehod(ITestResult result) throws IOException {
		Reporter.log("Test is about to end", true);
		if(result.getStatus()==ITestResult.FAILURE) {
			
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();
		Reporter.log("Test Completed>>> reports generated",true);
	}
}
