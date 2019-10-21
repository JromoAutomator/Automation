package stepdefs.SiteLinkWebEdition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

import java.util.HashMap;

import com.storable.framework.desktopElements_keywords;

import POM.SiteLinkWebEdition.AddMerchandise;
import POM.SiteLinkWebEdition.LoginForm;
import POM.SiteLinkWebEdition.Operations;
import POM.SiteLinkWebEdition.Payment;
import POM.SiteLinkWebEdition.Screens;


public class StepDefinitions {
	Screens ScreenInventory = new Screens();
	LoginForm WinLoginForm = new LoginForm();;
	Operations WinOperations = new Operations();;
	AddMerchandise WinAddMerchandise = new AddMerchandise();
	Payment WinPayment = new Payment();
	HashMap<Object, Object> ButtonName = new HashMap<>();
	HashMap<Object, Object> ButtonCoor = new HashMap<>();
	desktopElements_keywords CurrentScreen;
	
	
	
  @Given("^SLWE is running and logged in as a valid user with sufficient privileges$")
  public void LaunchSLWE() throws Throwable {
	  System.out.println("@Given SLWE is running and logged in as a valid user with sufficient privileges");
	  if(!screenisvisible("Operations")) {
		  screenisvisible("Login");
		  WinLoginForm.textBox_EnterText(WinLoginForm.$txtCorpCode(), "SLQA");
		  WinLoginForm.textBox_EnterText(WinLoginForm.$txtLocationCode(), "TP");
		  WinLoginForm.textBox_EnterText(WinLoginForm.$txtUserName(), "Jesus");
		  WinLoginForm.textBox_EnterText(WinLoginForm.$txtPassword(), "Test4me1");
		  WinLoginForm.button_Click(WinLoginForm.$btnLogin());
		  WinLoginForm.waitforButtontoExist(WinLoginForm.$btnPrintReports());
		  WinLoginForm.button_Click(WinLoginForm.$btnContinue());
	  }else{
		  System.out.println("You are already signed in");
	  }
		  
  }

  @When("^I click (.*)$")
  public void Buttonclick(String strButtonPath) throws Throwable {
	  System.out.println("@When I click"+strButtonPath);
	  String[] List = strButtonPath.split("->");
	  for (String Option : List) {
		  if(CurrentScreen.OCRButton(Option, ButtonCoor)) {
			  int[] btnCoor= CurrentScreen.getButtonCoorByName(Option, ButtonCoor);
			  CurrentScreen.button_Click(CurrentScreen.getButtonByName(Option, ButtonName), btnCoor[0],btnCoor[1]);
		  }else {
			  CurrentScreen.button_Click(CurrentScreen.getButtonByName(Option, ButtonName));
		  }
			  
	  }
  }

  @And("^finish with cash payment$")
  public void FinishCash() throws Throwable {
	  System.out.println("@And finish with cash payment");
	  screenisvisible("Payment");
	  WinPayment.Combobox_SelectItem(WinPayment.$cbPaymentMethod(), 3);
	  WinPayment.button_Click(WinPayment.$btnOK());
	  WinPayment.button_Click(WinPayment.$msgbtnYes("Save"));
	  WinPayment.button_Click(WinPayment.$msgbtnNo("Print"));
	  WinPayment.button_Click(WinPayment.$msgbtnNo("Email"));
	  WinPayment.button_Click(WinPayment.$msgbtnNo("Success"));
	  screenisvisible("Operations");
  }

  @And("^the (.*) screen is visible$")
  public boolean screenisvisible(String strScreen) throws Throwable {
	  System.out.println("@And the "+strScreen+" screen is visible");
	  SetUpScreen(strScreen);
	  boolean blnvisible=false;
	  CurrentScreen = (desktopElements_keywords) ScreenInventory.ClassScreenName.get(strScreen);
	  ButtonName = (HashMap<Object, Object>) ScreenInventory.Maps.get(strScreen);
	  ButtonCoor = (HashMap<Object, Object>) ScreenInventory.MapsCoor.get(strScreen);
	  try {
		  CurrentScreen.setCommonObjects(ScreenInventory);
	  }catch(Exception e) {}
	  if(ScreenInventory.ScreenExist(ScreenInventory.getWindowByName(strScreen,ScreenInventory.ScreenName))) {
		  //System.out.println(strScreen +" screen exists");
		  blnvisible = true;
	  }
	  return blnvisible;
  }
  
  
  @And("^Set discount percent to (.*)% and apply using the checkbox$")
  public void applydiscount(String strdiscount) {
	  System.out.println("@And Set discount percent to "+strdiscount+"% and apply using the checkbox");
	  WinAddMerchandise.textBox_EnterText(WinAddMerchandise.$updownnarrow(), strdiscount);
	  WinAddMerchandise.button_Click(WinAddMerchandise.$chkDiscountPct());
  }
  
  //Utility
  private void SetUpScreen(String strScreen) {
	  ScreenInventory.ClassScreenName.put("Login", WinLoginForm);
	  ScreenInventory.ClassScreenName.put("Operations", WinOperations);
	  ScreenInventory.ClassScreenName.put("Add Merchandise", WinAddMerchandise);
	  ScreenInventory.ClassScreenName.put("Payment", WinPayment);
  }

}




