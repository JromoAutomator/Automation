package POM.SiteLinkMyHub;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.Common.myPageFactory;
import com.storable.framework.webElements_Keywords;

public class LoginPage extends webElements_Keywords{

	
	
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
		intWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		myElements = myPageFactory.$initElements(new AjaxElementLocatorFactory(intWebDriver,0), this);
		PageFactory.initElements(new AjaxElementLocatorFactory(intWebDriver,10), this);
	}
	

	
}
