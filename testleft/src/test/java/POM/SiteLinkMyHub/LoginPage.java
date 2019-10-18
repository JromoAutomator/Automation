package POM.SiteLinkMyHub;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


import com.Common.TestContext;
import com.Common.reporting;
import com.storable.framework.webElements_Keywords;

public class LoginPage extends webElements_Keywords{

	public WebDriver CommonDriver;
	public reporting internalReport;
	//private String Page= "Login";
	
	@FindBy(id="Client_CorpCode")
    public WebElement txtClient_CorpCode;
	
	@FindBy(id="Client_LocationCode")
    public WebElement txtClient_LocationCode;
	
	@FindBy(id="Client_UserName")
    public WebElement txtClient_UserName;
	
	@FindBy(id="Client_Password")
    public WebElement txtClient_Password;
	
	@FindBy(xpath="//*[@id=\" loginform\"]/div[1]/div[1]/form/div/div[3]/div/input")
    public WebElement btnSignin;
	

	public LoginPage(WebDriver intWebDriver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(intWebDriver,10), this);
	}
	
	public LoginPage(WebDriver intWebDriver,reporting outReport) {
		PageFactory.initElements(new AjaxElementLocatorFactory(intWebDriver,10), this);
		internalReport= outReport;
	}
	
	//uncommnet option 1
	/*
	public void Client_CorpCode_EnterText(String strText) {
		txtClient_CorpCode.sendKeys(strText);
		internalReport.executionReport("passed", Page + ":" + strText + " was entered into Client_CorpCode");
	}
	
	public void Client_LocationCode_EnterText(String strText) {
		txtClient_LocationCode.sendKeys(strText);
		internalReport.executionReport("passed", Page + ":" + strText + " was entered into Client_LocationCode");
	}
	
	public void Client_UserName_EnterText(String strText) {
		txtClient_UserName.sendKeys(strText);
		internalReport.executionReport("passed", Page + ":" + strText + " was entered into Client_UserName");
	}
	
	public void Client_Password_EnterText(String strText) {
		txtClient_Password.sendKeys(strText);
		internalReport.executionReport("passed", Page + ":" + strText + " was entered into Client_Password");
	}
	
	public void Signin_click() {
		btnSignin.click();
		internalReport.executionReport("passed", Page + ": Signin was clicked");
	}*/
	
	
	
	
}
