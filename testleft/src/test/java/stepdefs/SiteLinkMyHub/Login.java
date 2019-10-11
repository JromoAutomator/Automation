package stepdefs.SiteLinkMyHub;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import com.Common.HipTest;

import POM.SiteLinkMyHub.HomePage;
import POM.SiteLinkMyHub.LoginPage;

public class Login {
	HipTest hipTest= new HipTest();
	LoginPage SiteLinkMyHub_LoginPage;
	HomePage SiteLinkMyHub_HomePage;

	
  @Given("^HipTestCaseID is \"([^\"]*)\"$")
  public void HipTestCase(String strHipTestID) throws Throwable {
	  	System.out.println("@Given HipTestCaseID is "+strHipTestID);
		hipTest.hipTestCaseID=strHipTestID;
		hipTest.addHipTestCaseToRun();
  }

  @Given("^user is on sitelink login page$")
  public void when() throws Throwable {
	  System.out.println("@Given user is on sitelink login page");
	  SiteLinkMyHub_LoginPage = new LoginPage("C:/Drivers/chromedriver.exe","https://myhubstaging.smdservers.net/Account/Login");
  }

  @Then("^success message is displayed$")
  public void then() throws Throwable {
	  System.out.println("@Then success message is displayed");
	  SiteLinkMyHub_HomePage= new HomePage();
	  SiteLinkMyHub_HomePage.element_isVisible(SiteLinkMyHub_HomePage.lblOperations);
	  hipTest.addResultToHipTest("passed", "Running from Cucumber");
  }

  @When("^user enters login info and presses submit$")
  public void and() throws Throwable {
	  System.out.println("@When user enters login info and presses submit");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_CorpCode, "SLQA");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_LocationCode, "L001");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_UserName, "L001");
	  SiteLinkMyHub_LoginPage.textBox_EnterText(SiteLinkMyHub_LoginPage.txtClient_Password, "demo");
	  SiteLinkMyHub_LoginPage.button_Click(SiteLinkMyHub_LoginPage.btnSignin);
  }

}
