package POM.SiteLinkMyHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.Common.myPageFactory;
import com.storable.framework.webElements_Keywords;

public class HomePage extends webElements_Keywords{

	@FindBy(id="title-operations")
    public WebElement lblOperations;
	
	public HomePage(WebDriver intWebDriver) {
		myElements = myPageFactory.$initElements(new AjaxElementLocatorFactory(intWebDriver,10), this);
	}

	
}
