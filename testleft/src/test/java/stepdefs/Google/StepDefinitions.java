package stepdefs.Google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import POM.Google.GooglePage;
import POM.Google.GoogleResults;
import POM.Google.InitGoogle;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	private GooglePage HomePage;
	private GoogleResults ResultsPage;
	private WebDriver intdriver;
	
	 @Given("^I open application in Chrome browser$")
	  public void given() throws Throwable {
		 InitGoogle newSession = new InitGoogle();
		 intdriver = newSession.InitDriver();
			
		 HomePage = new GooglePage(intdriver);
		 ResultsPage = new GoogleResults(intdriver);
	  }

	  @When("^I navigate to URL (.*)$")
	  public void navigatetoURL(String strURL) throws Throwable {
		  System.out.println(strURL);
		  intdriver.get(strURL);
	  }

	  @Then("i click on images tab")
	  public void then() throws Throwable {
		  ResultsPage.button_Click(ResultsPage.btnImages);
	  }
	  
	  @And("search for TestComplete (.*)")
	  public void EnterKeyword(String strKeyword) throws Throwable {
		  HomePage.textBox_EnterText(HomePage.inputSearch, strKeyword);
		  HomePage.TestBox_SendKeyBoardKeys(HomePage.inputSearch, Keys.TAB);
		  HomePage.TestBox_SendKeyBoardKeys(HomePage.inputSearch, Keys.TAB);
		  HomePage.TestBox_SendKeyBoardKeys(HomePage.inputSearch, Keys.ENTER);
	  }
	  
	  
	  @Then("i Close the browser")
	  public void Closethebrowser() throws Throwable {
		  intdriver.quit();
	  }
	  
	  
	
	
}
