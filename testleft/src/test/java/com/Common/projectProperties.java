package com.Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class projectProperties {
	public String myHubURL;
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

	String hipTestCaseID;

	
	public projectProperties() {
		Properties prop = new Properties();
		propFileName = System.getProperty("system.config.file");
		//uncomment to run as a cucumber feature file
		propFileName="C:/_/testleft/src/test/resources/config/config.properties";
		//mvn -Dsystem.config.file=file.properties test
		
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
