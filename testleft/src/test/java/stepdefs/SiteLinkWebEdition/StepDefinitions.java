package stepdefs.SiteLinkWebEdition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import POM.SiteLinkWebEdition.LoginForm;

public class StepDefinitions {
	LoginForm WinLoginForm;
	
  @Given("^SLWE is running and logged in as a valid user with sufficient privileges$")
  public void LaunchSLWE() throws Throwable {
	  WinLoginForm = new LoginForm();
	  WinLoginForm.textBox_EnterText(WinLoginForm.txtCorpCode, "SLQA");
	  WinLoginForm.textBox_EnterText(WinLoginForm.txtLocationCode, "TP");
	  WinLoginForm.textBox_EnterText(WinLoginForm.txtUserName, "Jesus");
	  WinLoginForm.textBox_EnterText(WinLoginForm.txtPassword, "Test4me1");
	  WinLoginForm.button_Click(WinLoginForm.btnLogin);
  }

  @When("^you are in When annotation$")
  public void when() throws Throwable {
  }

  @Then("^you are in Then annotation$")
  public void then() throws Throwable {
  }

  @And("^you are in And annotation$")
  public void and() throws Throwable {
  }

}
