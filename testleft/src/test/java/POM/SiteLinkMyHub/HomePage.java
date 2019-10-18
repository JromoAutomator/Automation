package POM.SiteLinkMyHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.Common.TestContext;
import com.Common.reporting;
import com.storable.framework.webElements_Keywords;

public class HomePage extends webElements_Keywords{
	

	//private String Page= "HomePage";

	@FindBy(id="title-operations")
    public WebElement lblOperations;
	
	private reporting internalReport;
	
	
	public HomePage(WebDriver intWebDriver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(intWebDriver,10), this);
	}

	public HomePage(WebDriver intWebDriver,reporting outReport) {
		PageFactory.initElements(new AjaxElementLocatorFactory(intWebDriver,10), this);
		internalReport= outReport;
	}
	
	//uncommnet option 1
	/*
	public boolean lblOperations_isVisible() {
		try {
		return lblOperations.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}*/
	

	
	
}
