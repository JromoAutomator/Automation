package POM.SiteLinkMyHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.storable.framework.webElements_Keywords;

public class HomePage extends webElements_Keywords{

	@FindBy(id="title-operations")
    public WebElement lblOperations;
	

	public HomePage(int intTimeOut) {
		PageFactory.initElements(new AjaxElementLocatorFactory(this.GetDriver(),intTimeOut), this);
	}
	
	public HomePage(String strChromeDriverPath,String strurl) {
		PageFactory.initElements(new AjaxElementLocatorFactory(this.InitDriver(strChromeDriverPath,strurl),100), this);
	}
	
	public HomePage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(this.GetDriver(),10), this);
	}
	
	
}
