package com.Common;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.storable.framework.webElements_Keywords;

import POM.SiteLinkMyHub.HomePage;
import POM.SiteLinkMyHub.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class TestContext extends webElements_Keywords{
	
	private WebDriver intDriver;
	public LoginPage SiteLinkMyHub_LoginPage;
	public HomePage SiteLinkMyHub_HomePage;
	public projectProperties projectProp;
	//Uncomment for Option 1
	//public reporting Report = new reporting();
	public reporting Report2;
	public HipTest hipTest= new HipTest();
	Scenario scenario;

	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	  //Uncomment for Option 1
	    //Report.scenarioName=scenario.getName();
	    hipTest.sthipTestCaseID=getHipTestCaseID();
	    hipTest.addHipTestCaseToRun(hipTest.sthipTestCaseID);
	    System.out.println("***********Thread "+Thread.currentThread().getId()+" running tets case id = "+ hipTest.sthipTestCaseID+ " *********************");
	}
	
	public TestContext(){
		projectProp = new projectProperties();
	}
	
	//Driver
	public WebDriver InitDriver(){
		System.setProperty(projectProp.setProperty,projectProp.driverPath);
		intDriver = getBrowserDriver();
		intDriver.get(projectProp.myHubURL);
		

		//Uncomment for Option 1
		/*SiteLinkMyHub_LoginPage = new LoginPage(intDriver,Report);
		SiteLinkMyHub_HomePage = new HomePage(intDriver,Report);*/
		
		SiteLinkMyHub_LoginPage = new LoginPage(intDriver);
		SiteLinkMyHub_HomePage = new HomePage(intDriver);
		
		
		Report2=SiteLinkMyHub_LoginPage.Report;
		Report2.scenarioName=this.scenario.getName();
		Report2.executionReport("Passed", "Navigated to " + projectProp.myHubURL);
		hipTest.internalReport=Report2;
		
		return intDriver;
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
	
	public WebDriver GetDriver() {
		return this.intDriver;
	}
	
	public HipTest getHipTest() {
		return this.hipTest;
	}
	
	public LoginPage getLoginPage() {
		return this.SiteLinkMyHub_LoginPage;
	}
	
	public HomePage getHomePage() {
		return this.SiteLinkMyHub_HomePage;
	}
	
	private String getHipTestCaseID() {
		String tag=null;
		Collection<String> ArrayTags = this.scenario.getSourceTagNames();
		for (String Arrtag : ArrayTags) {
			if(Arrtag.contains("@HTC")) {
				String[] Splittag=Arrtag.split("-");
				tag=Splittag[1];
			}
		}
		return tag;
	}
	
	

}
