package stepdefs.SiteLinkMyHub;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import com.Common.HipTest;
import com.Common.TestContext;
import POM.SiteLinkMyHub.HomePage;
import POM.SiteLinkMyHub.LoginPage;


public class Login{
	TestContext ObjCommon;
	HipTest hipTest;
	LoginPage SiteLinkMyHub_LoginPage;
	HomePage SiteLinkMyHub_HomePage;

	 
	 public Login(TestContext context) {
		 ObjCommon = context;
		 hipTest= ObjCommon.getHipTest();
	 }

	
  @Given("^HipTestCaseID is \"([^\"]*)\"$")
  public void HipTestCase(String strHipTestID) throws Throwable {
	  	System.out.println("@Given HipTestCaseID is "+strHipTestID);
	  	updatePFObjects();
		hipTest.hipTestCaseID=strHipTestID;
		hipTest.addHipTestCaseToRun();
  }

  

  @When("^user enters login info and presses submit$")
  public void and() throws Throwable {
	  System.out.println("@When user enters login info and presses submit");
	  updatePFObjects();
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_CorpCode, "SLQA");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_LocationCode, "L001");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_UserName, "L001");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_Password, "demo");
	  SiteLinkMyHub_LoginPage.button_Click(SiteLinkMyHub_LoginPage.btnSignin);
  }
  
  public void updatePFObjects() {
		SiteLinkMyHub_LoginPage = ObjCommon.getLoginPage();
		SiteLinkMyHub_HomePage = ObjCommon.getHomePage();
	}

}
