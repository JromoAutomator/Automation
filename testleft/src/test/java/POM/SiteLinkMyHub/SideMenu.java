package POM.SiteLinkMyHub;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.Common.myPageFactory;
import com.storable.framework.webElements_Keywords;

public class SideMenu extends webElements_Keywords {
	
	private WebDriver intdriver;

	@FindBy(xpath = "//a[text()='Customers']")
	public WebElement lnkCustomers;
	
	@FindBy(xpath = "//a[text()='Tenants']")
	public WebElement lnkTenants;
	
	@FindBy(xpath = "//*[@data-icon='chevron-left']")
	public WebElement lnkBackButton;
	
	public SideMenu(WebDriver intWebDriver) {
		intdriver=intWebDriver;
		intWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		myElements = myPageFactory.$initElements(new AjaxElementLocatorFactory(intWebDriver,0), this);
		PageFactory.initElements(new AjaxElementLocatorFactory(intWebDriver,10), this);
	}
	
	public void navigateMenu(String path) throws InterruptedException{
		for (String menuItem : path.split("/")) {
			navigateMenuClick(menuItem);
		}
	}
	
	public void navigateMenuClick(String path) throws InterruptedException {
		Thread.sleep(2000);
		WebElement thisElement = intdriver.findElement(By.xpath("//div[contains(@class,'menu-content')]//*[text()='" + path + "']"));
		this.button_Click(thisElement);
	}
	
}
