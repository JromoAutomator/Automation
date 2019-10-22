package stepdefs.SiteLinkMyHub;

import com.Common.Common;
import com.Common.HipTest;
import com.Common.TestContext;
import POM.SiteLinkMyHub.HomePage;
import POM.SiteLinkMyHub.LoginPage;
import POM.SiteLinkMyHub.SideMenu;
import POM.SiteLinkMyHub.TenantsPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class tenant{
	TestContext ObjCommon;
	HipTest hipTest;
	LoginPage SiteLinkMyHub_LoginPage;
	HomePage SiteLinkMyHub_HomePage;
	SideMenu SiteLlinkMyHub_SideMenu;
	TenantsPage SiteLinkMyHub_Tenants;

	@After
	public void after() {
		if(!ObjCommon.hipTest.blnhipTestlog) {hipTest.addResultToHipTest();}
	}

	 public tenant(TestContext context) {
		 ObjCommon = context;
		 hipTest= ObjCommon.getHipTest();
	 }
	
	@Given("^user is on sitelink login page$")
	  public void when() throws Throwable {
		  ObjCommon.BaseCommon.InitDriver();
		  updatePFObjects();
		  SiteLinkMyHub_LoginPage.element_isVisible(SiteLinkMyHub_LoginPage.btnSignin);
	  }
	
	@Then("^success message is displayed$")
	  public void then() throws Throwable {
		if(SiteLinkMyHub_HomePage.element_isVisible(SiteLinkMyHub_HomePage.lblOperations)){
			ObjCommon.BaseCommon.myHub.Report.executionReport("passed", "HomePage : welcome screen is displayed with new reporting stuff");
		}else {
			ObjCommon.BaseCommon.myHub.Report.executionReport("failed", "HomePage : something went wrong with login steps");
		}
		SiteLinkMyHub_HomePage.element_isVisible(SiteLinkMyHub_HomePage.lblOperations);  
	  }
	
	@Given("^user navigates to the Tenants page$")
	public void navigate_to_tenant_page() throws Throwable {
		SiteLlinkMyHub_SideMenu.navigateMenu("Customers/Tenants");

	}
	
	@Given("^User expands the tab and clicks Add$")
	public void expand_tenant_tab_and_click_add() throws Throwable {
		SiteLinkMyHub_Tenants.button_Click(SiteLinkMyHub_Tenants.lnkExpandSideTab);
		SiteLinkMyHub_Tenants.button_Click(SiteLinkMyHub_Tenants.lnkTenantAdd);
	}
	
	@Given("^User enters tenant details$")
	public void populate_tenant_data() throws Throwable {
		SiteLinkMyHub_Tenants.textBox_EnterText(SiteLinkMyHub_Tenants.txtFirstName, "Testfirst"); 
		SiteLinkMyHub_Tenants.textBox_EnterText(SiteLinkMyHub_Tenants.txtLastName, "Testlast"); 
		SiteLinkMyHub_Tenants.button_Click(SiteLinkMyHub_Tenants.btnSubmit);
		SiteLinkMyHub_Tenants.button_Click(SiteLinkMyHub_Tenants.spnShowAllTenants); 
	}

	@Given("^Tenant is added to the Tenant grid$")
	public void tenant_is_in_tenant_grid() throws Throwable {
		//common.databaseDataExists(report, queries.getTenantIDFromName("Testfirst", "Testlast"), true);
		//SF.perform.exists("//td[contains(text(),'Testlast, Testfirst')]");
		//SF.databaseDataExists(Queries.getTenantIDFromName("Testfirst", "Testlast"), true);
		
	}
	
	public void updatePFObjects() {
		SiteLinkMyHub_LoginPage = ObjCommon.BaseCommon.myHub.getLoginPage();
		SiteLinkMyHub_HomePage = ObjCommon.BaseCommon.myHub.getHomePage();
		SiteLlinkMyHub_SideMenu = ObjCommon.BaseCommon.myHub.getSideMenu();
		SiteLinkMyHub_Tenants = ObjCommon.BaseCommon.myHub.getTenantsPage();
	}
}
