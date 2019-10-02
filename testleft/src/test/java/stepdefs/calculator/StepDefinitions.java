package stepdefs.calculator;


import org.testng.Assert;

import POM.Calculator.CalculatorApp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinitions {
	CalculatorApp Calculator;
	
	
  @Given("^the windows calculator app$")
  public void given() throws Throwable {
	  this.Calculator = new CalculatorApp();
	  Thread.sleep(2000);
  }

  @When("^click on Numeric button (.*)$")
  public void when(String ObjectI) throws Throwable {
	  this.Calculator.button_Click(this.Calculator.CreateNumericButton(ObjectI));
  }

  @Then("^print the result on the calculator$")
  public void then() throws Throwable {
	  String value = this.Calculator.element_Getlabel(this.Calculator.GetTextBoxArea());
	  System.out.println("actual value "+value);
	  //Assert.assertEquals(intactual, Integer.parseInt(intExpected));
  }
  
  @Then("Close the APP")
  public void Close() throws Throwable {
	  this.Calculator.CloseApp();
  }

  @And("^click on Operation button (.*)$")
  public void and2(String ObjectI) throws Throwable {
	  this.Calculator.button_Click(this.Calculator.CreateOperationButton(ObjectI));
  }
  
 
  
  

}
