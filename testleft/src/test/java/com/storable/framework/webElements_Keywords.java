package com.storable.framework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.*;;

public abstract class webElements_Keywords implements webObjects{
	private WebDriver intDriver;
	
	//Driver
	public WebDriver InitDriver(String strChromeDriverPath,String url){
		System.setProperty("webdriver.chrome.driver",strChromeDriverPath );
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chromeDriver.manage().window().maximize();
		chromeDriver.get(url);
		return chromeDriver;
	}
	
	public WebDriver GetDriver() {
		return this.intDriver;
	}
	
	
	//Button
	public void button_Click(WebElement seleniumElement) {
		seleniumElement.click();
	}
	
	//TextBox
	public void textBox_EnterText(WebElement seleniumElement,String strText) {
		seleniumElement.click();
		seleniumElement.clear();
		seleniumElement.sendKeys(strText);
	}
	
	public void TestBox_SendKeyBoardKeys(WebElement seleniumElement,Keys strText) {
		seleniumElement.sendKeys(strText);
	}
	
	//Object
	public boolean element_isVisible(WebElement seleniumElement) {
		try {
		return seleniumElement.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean element_isEnabled(WebElement seleniumElement) {
		return seleniumElement.isEnabled();
	}
	
	public String element_Getlabel(WebElement seleniumElement) {
		return seleniumElement.getText();
	}
	
	public void element_GotoElement(WebElement seleniumElement, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(seleniumElement);
		actions.perform();
	}

}
