package stepdefs.SiteLinkMyHub;

import com.Common.Common;
import com.Common.HipTest;
import com.Common.TestContext;
import POM.SiteLinkMyHub.HomePage;
import POM.SiteLinkMyHub.LoginPage;
import cucumber.api.java.After;
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
	
	public void updatePFObjects() {
		SiteLinkMyHub_LoginPage = ObjCommon.BaseCommon.myHub.getLoginPage();
		SiteLinkMyHub_HomePage = ObjCommon.BaseCommon.myHub.getHomePage();
	}
}
