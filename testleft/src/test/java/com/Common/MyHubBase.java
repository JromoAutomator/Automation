package com.Common;

import org.openqa.selenium.WebDriver;
import POM.SiteLinkMyHub.HomePage;
import POM.SiteLinkMyHub.LoginPage;
import POM.SiteLinkMyHub.SideMenu;
import POM.SiteLinkMyHub.TenantsPage;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class MyHubBase {
	
	public LoginPage SiteLinkMyHub_LoginPage;
	public HomePage SiteLinkMyHub_HomePage;
	public SideMenu SiteLlinkMyHub_SideMenu;
	public TenantsPage SiteLinkMyHub_Tenants;
	public reporting Report;
	private projectProperties projectProp;
	
	
	public MyHubBase() {
		projectProp = new projectProperties();
	}
	
	public MyHubBase(WebDriver intDriver, reporting outReport) {
		projectProp = new projectProperties();
		SiteLinkMyHub_LoginPage = new LoginPage(intDriver);
		SiteLinkMyHub_HomePage = new HomePage(intDriver);
		SiteLlinkMyHub_SideMenu= new SideMenu(intDriver);
		SiteLinkMyHub_Tenants = new TenantsPage(intDriver);
		
		SiteLinkMyHub_LoginPage.Report = outReport;
		SiteLinkMyHub_HomePage.Report = outReport;
		SiteLlinkMyHub_SideMenu.Report = outReport;
		SiteLinkMyHub_Tenants.Report = outReport;
		
		Report=outReport;
		Report.executionReport("Passed", "Navigated to " + projectProp.myHubURL);
	}
	
	
	public LoginPage getLoginPage() {
		return this.SiteLinkMyHub_LoginPage;
	}
	
	public HomePage getHomePage() {
		return this.SiteLinkMyHub_HomePage;
	}
	
	public SideMenu getSideMenu() {
		return this.SiteLlinkMyHub_SideMenu;
	}
	
	public TenantsPage getTenantsPage() {
		return this.SiteLinkMyHub_Tenants;
	}

}
