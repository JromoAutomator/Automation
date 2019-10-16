package stepdefs.SiteLinkMyHub;

import com.Common.HipTest;
import com.Common.TestContext;
import POM.SiteLinkMyHub.HomePage;
import POM.SiteLinkMyHub.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class tenant{
	TestContext ObjCommon;
	HipTest hipTest;
	LoginPage SiteLinkMyHub_LoginPage;
	HomePage SiteLinkMyHub_HomePage;


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
		  SiteLinkMyHub_HomePage.element_isVisible(SiteLinkMyHub_HomePage.lblOperations);
		  hipTest.addResultToHipTest("passed", "Running from Cucumber Parallel");
	  }
	
	public void updatePFObjects() {
		SiteLinkMyHub_LoginPage = ObjCommon.getLoginPage();
		SiteLinkMyHub_HomePage = ObjCommon.getHomePage();
	}
}
