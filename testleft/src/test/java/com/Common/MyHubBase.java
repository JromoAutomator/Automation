package com.Common;

import org.openqa.selenium.WebDriver;
import POM.SiteLinkMyHub.HomePage;
import POM.SiteLinkMyHub.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class MyHubBase {
	
	public LoginPage SiteLinkMyHub_LoginPage;
	public HomePage SiteLinkMyHub_HomePage;
	public reporting Report;
	private projectProperties projectProp;
	
	
	public MyHubBase() {
		projectProp = new projectProperties();
	}
	
	public MyHubBase(WebDriver intDriver, reporting outReport) {
		projectProp = new projectProperties();
		SiteLinkMyHub_LoginPage = new LoginPage(intDriver);
		SiteLinkMyHub_HomePage = new HomePage(intDriver);
		SiteLinkMyHub_LoginPage.Report = outReport;
		SiteLinkMyHub_HomePage.Report = outReport;
		Report=outReport;
		Report.executionReport("Passed", "Navigated to " + projectProp.myHubURL);
	}
	
	
	public LoginPage getLoginPage() {
		return this.SiteLinkMyHub_LoginPage;
	}
	
	public HomePage getHomePage() {
		return this.SiteLinkMyHub_HomePage;
	}

}
