package stepdefs;


import POM.CalculatorApp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinitions {
	CalculatorApp Calculator;
	
	
  @Given("^the windows calculator app$")
  public void given() throws Throwable {
	  this.Calculator = new CalculatorApp();
  }

  @When("^I click on number 5$")
  public void when() throws Throwable {
	  this.Calculator.button_Click(this.Calculator.button5);
  }

  @Then("the value on the calculator shows 12")
  public void then() throws Throwable {
	  System.out.println("it is working, peding get value form app");
  }
  
  @Then("Close the APP")
  public void Close() throws Throwable {
	  this.Calculator.CloseApp();
  }

  @And("click on number 7")
  public void and() throws Throwable {
	  this.Calculator.button_Click(Calculator.button7);
  }
  
  @And("click on SUM button")
  public void and2() throws Throwable {
	  this.Calculator.button_Click(Calculator.buttonSum);
  }
  
  @And("click on = button")
  public void ClickEqual() throws Throwable {
	  this.Calculator.button_Click(Calculator.buttonEqual);
  }
  
  
  

}
