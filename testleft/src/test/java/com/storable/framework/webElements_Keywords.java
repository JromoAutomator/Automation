package com.storable.framework;

import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Common.Common;
import com.Common.reporting;;

public abstract class webElements_Keywords implements webObjects{
	public reporting Report = new reporting();
	public static HashMap<String, String > myElements = new HashMap<String, String >();
	public WebDriver intDriver=Common.intDriver;
	
	//Button
	public void button_Click(WebElement seleniumElement) {
		String objName=getElementName(seleniumElement);
		waitforElementtobeVisible(seleniumElement);
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
		boolean blnvisible=false;
		String objName=getElementName(seleniumElement);
		try {
			blnvisible=seleniumElement.isDisplayed();
			Report.executionReport("INFO", objName+" is visible =" + blnvisible);
		return blnvisible;
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
		String ObjectID, objectSubID = null,strlastCharacter;
		if(objectName.toString().contains("Proxy element")) {
			String[] st1= objectName.toString().split("'By.");
			ObjectID= st1[st1.length-1].trim();
			if(!ObjectID.contains("xpath")) {
				objectSubID=ObjectID.substring(0, ObjectID.length()-1);
			}else {
				strlastCharacter=""+ObjectID.charAt(ObjectID.length()-2);
				if(strlastCharacter.equals("]")) {
					objectSubID=ObjectID.substring(0, ObjectID.length()-1);
				}else {
					objectSubID=ObjectID;
				}
			}
		}else {
			String[] st1= objectName.toString().split("->");
			ObjectID=st1[st1.length-1].trim();
			if(!ObjectID.contains("xpath")) {
				objectSubID=ObjectID.substring(0, ObjectID.length()-1);
			}else {
				strlastCharacter=""+ObjectID.charAt(ObjectID.length()-2);
				if(strlastCharacter.equals("]")) {
					objectSubID=ObjectID.substring(0, ObjectID.length()-1);
				}else {
					objectSubID=ObjectID;
				}
			}
			
		}
		
		//System.out.println(objectSubID);
		String strObjName = myElements.get(objectSubID);
		return strObjName;
	}
	
	public void waitforElementtobeVisible(WebElement seleniumElement) {
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		WebDriverWait wait2 = new WebDriverWait(intDriver, 10);
		wait2.until(ExpectedConditions.visibilityOf(seleniumElement));
	}

}
