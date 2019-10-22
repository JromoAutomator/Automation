package POM.SiteLinkMyHub;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.Common.myPageFactory;
import com.storable.framework.webElements_Keywords;

public class HomePage extends webElements_Keywords{

	@FindBy(id="title-operations")
    public WebElement lblOperations;
	
	public HomePage(WebDriver intWebDriver) {
		intWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		myElements = myPageFactory.$initElements(new AjaxElementLocatorFactory(intWebDriver,0), this);
		PageFactory.initElements(new AjaxElementLocatorFactory(intWebDriver,10), this);
	}

	
}
