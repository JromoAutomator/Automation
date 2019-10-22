package POM.SiteLinkMyHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.storable.framework.webElements_Keywords;

public class TenantsPage extends webElements_Keywords{

	@FindBy(xpath="//input[@ng-required='input.tenantDefaults.FName']")
    public WebElement txtFirstName;
	
	@FindBy(xpath="//input[@ng-required='input.tenantDefaults.LName']")
    public WebElement txtLastName;
	
	@FindBy(xpath="//input[@ng-required='input.tenantDefaults.Addr1']")
    public WebElement txtAddress1;
	
	@FindBy(xpath="//div[@class='modal-content']//button[text()='Submit']")
    public WebElement btnSubmit;
	
	@FindBy(xpath="//div[@aria-hidden='false']//button[@id='btnConfirmDlg']")
    public WebElement btnYes;
	
	@FindBy(xpath="//div[@aria-hidden='false']//button[@id='btnCancelDlg']")
    public WebElement btnNo;
	
	@FindBy(xpath="//i[@class='fa']")
    public WebElement lnkExpandSideTab;
	
	@FindBy(xpath="//a[text()='Add']")
    public WebElement lnkTenantAdd;
	
	@FindBy(xpath="//span[text()='All']")
    public WebElement spnShowAllTenants;
	
	public TenantsPage(WebDriver intWebDriver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(intWebDriver,100), this);
	}
	
}
