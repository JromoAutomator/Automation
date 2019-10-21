package com.Common;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.storable.framework.webElements_Keywords;

public class Common extends webElements_Keywords{
	
	private projectProperties projectProp;
	public WebDriver intDriver;
	public MyHubBase myHub;
	
	public Common() {
		projectProp = new projectProperties();
	}	
	
	public WebDriver InitDriver(){
		System.setProperty(projectProp.setProperty,projectProp.driverPath);
		intDriver = getBrowserDriver();
		intDriver.get(projectProp.myHubURL);
		myHub = new MyHubBase(intDriver, this.Report);
		
		return intDriver;
	}
	
	public void teardown(HipTest hipTest) {
		try {
			if (!hipTest.sthipTestCaseID.equals("")) {
				hipTest.addResultToHipTest();
			}

			Report.testCaseMessage = "";
			Report.testCaseStatus = 1;
			hipTest.sthipTestCaseID = "";
		} catch (Exception e) {
			System.out.println(e);
		} 
		intDriver.quit();
	}
	
	public WebDriver getBrowserDriver() {
		WebDriver bDriver;
		switch(projectProp.browser) {
		case "Chrome":
			bDriver = new ChromeDriver();
			bDriver.manage().timeouts().implicitlyWait(projectProp.driverTimeout, TimeUnit.SECONDS);
			bDriver.manage().window().maximize();
			break;
		case "FireFox":
			bDriver = new FirefoxDriver();
			bDriver.manage().timeouts().implicitlyWait(projectProp.driverTimeout, TimeUnit.SECONDS);
			bDriver.manage().window().maximize();
			break;
		default:
			bDriver = new ChromeDriver();
			bDriver.manage().timeouts().implicitlyWait(projectProp.driverTimeout, TimeUnit.SECONDS);
			bDriver.manage().window().maximize();
		}
		
		return bDriver;
	}
	

}
