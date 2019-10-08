package com.storable.framework;

import com.smartbear.testleft.Driver;
import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.ProcessPattern;
import com.smartbear.testleft.testobjects.TestProcess;
import com.smartbear.testleft.testobjects.TextEdit;
import com.smartbear.testleft.testobjects.TopLevelWindow;
import com.smartbear.testleft.testobjects.WinFormsPattern;
import com.smartbear.testleft.testobjects.Window;

public abstract class desktopElements_keywords implements desktopObjects{
	

	//Button
	public void button_Click(Control windowObject) {
		try {
			windowObject.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String element_Getlabel(Control windowObject) {
		String strValue=null;
		try {
			strValue = windowObject.getProperty(String.class, "Text");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strValue;
	}
	
	
	//TextEdit
	public String element_Getlabel(TextEdit editApp) {
		String strValue=null;
		try {
			strValue = editApp.getProperty(String.class, "Text");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strValue;
	}
	
	public void textBox_EnterText(TextEdit editApp, String strText) {
		try {
			editApp.click();
			editApp.callMethod("Clear");
			editApp.setText(strText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}






