package com.Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class projectProperties {
	String myHubURL;
	String browser;
	String chromedriverPath;
	String dbCon;
	String propFileName;
	String hipTestBaseURL;
	String hipTestRunID;
	String HipTestToken;
	String hipTestClient;
	String hipTestUser;
	String hipTestProjectId;
	String browserSystemProp;
	String chromeSystemProp;
	String fireFoxdriverPath;
	String fireFoxSystemProp;
	int driverTimeout;
	String driverPath;
	String setProperty;
	
	
	public projectProperties() {
		Properties prop = new Properties();
		propFileName = System.getProperty("propertyName");
		
		try {
			InputStream inputStream = new FileInputStream(propFileName);
			 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			// get the property value and print it out
			myHubURL = prop.getProperty("myHubURL");
			browser = prop.getProperty("browser");
			
			dbCon = prop.getProperty("dbCon");
			browserSystemProp = prop.getProperty("browserSystemProp");
			hipTestBaseURL = prop.getProperty("hipTestBaseURL");
			hipTestRunID = prop.getProperty("hipTestRunID");
			HipTestToken = prop.getProperty("HipTestToken");
			hipTestClient = prop.getProperty("hipTestClient");
			hipTestUser = prop.getProperty("hipTestUser");
			hipTestProjectId = prop.getProperty("hipTestProjectId");
			
			chromedriverPath = prop.getProperty("chromedriverPath");
			chromeSystemProp = prop.getProperty("chromeSystemProp");
			fireFoxdriverPath = prop.getProperty("fireFoxdriverPath");
			fireFoxSystemProp = prop.getProperty("fireFoxSystemProp");

			getBrowser(browser);
			driverTimeout=Integer.parseInt(prop.getProperty("driverTimeout"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getBrowser(String strBrowser) {
		
		switch(strBrowser) {
		case "Chrome":
			driverPath = chromedriverPath;
			setProperty = chromeSystemProp;
			break;
		case "FireFox":
			driverPath = fireFoxdriverPath;
			setProperty = fireFoxSystemProp;
			break;
		default:
			driverPath = chromedriverPath;
			setProperty = chromeSystemProp;
		}
		
		
	}

}
