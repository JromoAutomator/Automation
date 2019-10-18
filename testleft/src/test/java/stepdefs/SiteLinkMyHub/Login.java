package stepdefs.SiteLinkMyHub;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
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
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_CorpCode, "SLQA","Login : SLQA was entered into Client_CorpCode");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_LocationCode, "L001","Login : L001 was entered into Client_LocationCode");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_UserName, "L001","Login : L001 was entered into Client_UserName");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_Password, "demo","Login : L001 was entered into Client_Password");
	  SiteLinkMyHub_LoginPage.button_Click(SiteLinkMyHub_LoginPage.btnSignin,"Login : Signin was clicked");
	  
	//Uncomment for Option 1
	  /*SiteLinkMyHub_LoginPage.Client_CorpCode_EnterText("SLQA");
	  SiteLinkMyHub_LoginPage.Client_LocationCode_EnterText("L001");
	  SiteLinkMyHub_LoginPage.Client_UserName_EnterText("L001");
	  SiteLinkMyHub_LoginPage.Client_Password_EnterText("demo");
	  SiteLinkMyHub_LoginPage.Signin_click();*/
	  
  }
  
  public void updatePFObjects() {
		SiteLinkMyHub_LoginPage = ObjCommon.getLoginPage();
		SiteLinkMyHub_HomePage = ObjCommon.getHomePage();
	}

}
