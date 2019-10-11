package com.Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.storable.framework.webElements_Keywords;

import POM.SiteLinkMyHub.HomePage;
import POM.SiteLinkMyHub.LoginPage;

public class TestContext extends webElements_Keywords{
	
	private WebDriver intDriver;
	public HipTest hipTest= new HipTest();
	public LoginPage SiteLinkMyHub_LoginPage;
	public HomePage SiteLinkMyHub_HomePage;
	
	public TestContext(){
		System.out.println("");
	}
	
	//Driver
	public WebDriver InitDriver(){
		System.setProperty("webdriver.chrome.driver","C:/Drivers/chromedriver.exe" );
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chromeDriver.manage().window().maximize();
		chromeDriver.get("https://myhubstaging.smdservers.net/Account/Login");
		this.intDriver=chromeDriver;
		
		SiteLinkMyHub_LoginPage = new LoginPage(chromeDriver);
		SiteLinkMyHub_HomePage = new HomePage(chromeDriver);
		
		return chromeDriver;
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
	
	

}
