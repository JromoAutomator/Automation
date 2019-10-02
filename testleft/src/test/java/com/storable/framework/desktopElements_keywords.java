package com.storable.framework;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.InvocationException;
import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.TextEdit;

public abstract class desktopElements_keywords implements desktopObjects{
	

	//Calculator
	public void button_Click(Control windowObject) {
		try {
			windowObject.click();
		} catch (InvocationException e) {
			e.printStackTrace();
		} catch (HttpException e) {
			e.printStackTrace();
		}
	}

	public String element_Getlabel(Control windowObject) {
		String strValue=null;
		try {
			strValue = windowObject.getProperty(String.class, "Text");
		} catch (InvocationException e) {
			e.printStackTrace();
		} catch (HttpException e) {
			e.printStackTrace();
		}
		return strValue;
	}
	
	
	//Notepad
	public String element_Getlabel(TextEdit editApp) {
		String strValue=null;
		try {
			strValue = editApp.getProperty(String.class, "Text");
		} catch (InvocationException e) {
			e.printStackTrace();
		} catch (HttpException e) {
			e.printStackTrace();
		}
		return strValue;
	}
}
