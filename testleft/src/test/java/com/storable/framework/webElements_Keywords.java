package com.storable.framework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Common.reporting;;

public abstract class webElements_Keywords implements webObjects{
	public reporting Report = new reporting();
	
	//Button
	public void button_Click(WebElement seleniumElement) {
		seleniumElement.click();
		Report.executionReport("passed", "button click");
	}
	
	//TextBox
	public void textBox_EnterText(WebElement seleniumElement,String strText) {
		seleniumElement.click();
		seleniumElement.clear();
		seleniumElement.sendKeys(strText);
		Report.executionReport("passed", "Test edit enter text : " + strText);
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
