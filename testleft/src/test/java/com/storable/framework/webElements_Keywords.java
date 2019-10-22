package com.storable.framework;

import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Common.reporting;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.TypeKey;;

public abstract class webElements_Keywords implements webObjects{
	public reporting Report = new reporting();
	public static HashMap<String, String > myElements = new HashMap<String, String >();
	
	//Button
	public void button_Click(WebElement seleniumElement) {
		String objName=getElementName(seleniumElement);
		seleniumElement.click();
		Report.executionReport("passed", objName+" was clicked");
	}
	
	//TextBox
	public void textBox_EnterText(WebElement seleniumElement,String strText) {
		seleniumElement.click();
		seleniumElement.clear();
		seleniumElement.sendKeys(strText);
		String[] objDetails = getElementName(seleniumElement).split(":");
		Report.executionReport("passed", objDetails[0]+":"+ strText+ " was entered into "+objDetails[1]);
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
	
	public String getElementName(Object objectName) {
		String ObjectID;
		if(objectName.toString().contains("Proxy element")) {
			String[] st1= objectName.toString().split("'By.");
			ObjectID= st1[st1.length-1].trim().replace("]'", "]");
		}else {
			String[] st1= objectName.toString().split("->");
			ObjectID=st1[st1.length-1].trim().replaceFirst("]", "");
		}
		
		String strObjName = myElements.get(ObjectID);
		return strObjName;
	}

}
