package stepdefs.SiteLinkMyHub;

import com.Common.HipTest;
import com.Common.TestContext;
import POM.SiteLinkMyHub.HomePage;
import POM.SiteLinkMyHub.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class tenant{
	TestContext ObjCommon;
	HipTest hipTest;
	LoginPage SiteLinkMyHub_LoginPage;
	HomePage SiteLinkMyHub_HomePage;

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
		  ObjCommon.InitDriver();
		  updatePFObjects();
		  SiteLinkMyHub_LoginPage.element_isVisible(SiteLinkMyHub_LoginPage.btnSignin);
	  }
	
	@Then("^success message is displayed$")
	  public void then() throws Throwable {
		//Uncomment for Option 1
		//if(SiteLinkMyHub_HomePage.lblOperations_isVisible()) {
		if(SiteLinkMyHub_HomePage.element_isVisible(SiteLinkMyHub_HomePage.lblOperations)){
			ObjCommon.Report2.executionReport("passed", "HomePage : welcome screen is displayed");
		}else {
			ObjCommon.Report2.executionReport("failed", "HomePage : something went wrong with login steps");
		}
		
		SiteLinkMyHub_HomePage.element_isVisible(SiteLinkMyHub_HomePage.lblOperations);
		  
	  }
	
	public void updatePFObjects() {
		SiteLinkMyHub_LoginPage = ObjCommon.getLoginPage();
		SiteLinkMyHub_HomePage = ObjCommon.getHomePage();
	}
}
