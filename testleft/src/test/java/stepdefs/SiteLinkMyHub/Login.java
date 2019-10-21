package stepdefs.SiteLinkMyHub;

import cucumber.api.java.After;
import cucumber.api.java.en.When;
import com.Common.HipTest;
import com.Common.TestContext;
import POM.SiteLinkMyHub.HomePage;
import POM.SiteLinkMyHub.LoginPage;


public class Login {
	TestContext ObjCommon;
	HipTest hipTest;
	LoginPage SiteLinkMyHub_LoginPage;
	HomePage SiteLinkMyHub_HomePage;
	
	@After
	public void after() {
		if(!ObjCommon.hipTest.blnhipTestlog) {hipTest.addResultToHipTest();}
		
	}

	public Login(TestContext context) {
		ObjCommon = context;
		hipTest= ObjCommon.getHipTest();
	}

  @When("^user enters login info and presses submit$")
  public void and() throws Throwable {
	  updatePFObjects();
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_CorpCode, "SLQA");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_LocationCode, "L001");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_UserName, "L001");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_Password, "demo");
	  SiteLinkMyHub_LoginPage.button_Click(SiteLinkMyHub_LoginPage.btnSignin);
	  
  }
  
  public void updatePFObjects() {
	  SiteLinkMyHub_LoginPage = ObjCommon.BaseCommon.myHub.getLoginPage();
	  SiteLinkMyHub_HomePage = ObjCommon.BaseCommon.myHub.getHomePage();
	}

}
