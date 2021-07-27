package com.testweb.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	WebDriver driver;
	
	public static WebDriver startApp(WebDriver driver, String bname, String url) {
		
		if(bname.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe" );
			driver= new ChromeDriver();
		} else if(bname.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe" );
			driver= new FirefoxDriver();
		} else {
			System.out.println("We do not support this browser");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void quitBroser(WebDriver driver) {
		driver.quit();
	}

}
