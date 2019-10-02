package POM.Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.storable.framework.webElements_Keywords;

public class GooglePage extends webElements_Keywords{
	
	@FindBy(name="q")
    public WebElement inputSearch;
	
	@FindBy(name="btnK")
    public WebElement btnSearch;
	
	public GooglePage(WebDriver extdriver,int intTimeOut) {
		PageFactory.initElements(new AjaxElementLocatorFactory(extdriver,intTimeOut), this);
	}
	
	public GooglePage(WebDriver extdriver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(extdriver,100), this);
	}
	
	
}
