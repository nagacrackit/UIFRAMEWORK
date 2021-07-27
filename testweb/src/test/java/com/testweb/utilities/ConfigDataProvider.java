package com.testweb.utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProvider {
	
	Properties p;
	public ConfigDataProvider() {
		
		File src= new File("./Config/config.properties");
		try {
			FileInputStream fs = new FileInputStream(src);
			p = new Properties();
			p.load(fs);
		} catch (Exception e) {
			System.out.println("Unable to find the config>>"+e.getMessage());
		} 
	}
	
	public String getDataFromConfig(String keyToSearch) {
		return keyToSearch;
		
	}
	
	public String  getBrowser() {
		return p.getProperty("browser");
	}
	
	public String getQaUrl() {
		return p.getProperty("qaurl");
		
	}

}
