package POM.SiteLinkMyHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.storable.framework.webElements_Keywords;

public class SideMenu extends webElements_Keywords {

	@FindBy(xpath = "//a[text()='Customers']")
	public WebElement lnkCustomers;
	
	@FindBy(xpath = "//a[text()='Tenants']")
	public WebElement lnkTenants;
	
	@FindBy(xpath = "//*[@data-icon='chevron-left']")
	public WebElement lnkBackButton;
	
	public SideMenu(WebDriver intWebDriver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(intWebDriver, 100), this);
	}
	
	/*public void navigateMenu(WebElement seleniumElement, String path){
		for (String menuItem : path.split("/")) {
			button_Click(seleniumElement, menuItem);
		}
	}*/
	
}
