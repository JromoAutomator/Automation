package com.storable.framework;

import java.util.HashMap;

import com.smartbear.testleft.Driver;
import com.smartbear.testleft.testobjects.Button;
import com.smartbear.testleft.testobjects.ComboBox;
import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.ProcessPattern;
import com.smartbear.testleft.testobjects.TestProcess;
import com.smartbear.testleft.testobjects.TextEdit;
import com.smartbear.testleft.testobjects.TopLevelWindow;
import com.smartbear.testleft.testobjects.WinFormsPattern;
import com.smartbear.testleft.testobjects.Window;

import POM.SiteLinkWebEdition.Screens;

public abstract class desktopElements_keywords implements desktopObjects{
	

	//Button
	public void button_Click(Control windowObject) {
		try {
			windowObject.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void button_Click(Button windowObject) {
		try {
			windowObject.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void button_Click(Control windowObject,int x, int y) {
		try {
			windowObject.click(x,y);
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
	
	public void waitforWindowtoExist(Window winObject) {
		boolean blnExist= false;
		try {
			while(!blnExist){
				Thread.sleep(1000);
				blnExist = winObject.getProperty(boolean.class, "Exists");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitforButtontoExist(Control windowObject) {
		boolean blnExist= false;
		try {
			while(!blnExist){
				Thread.sleep(1000);
				blnExist = windowObject.getProperty(boolean.class, "Exists");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean ScreenExist(Window winObject) {
		boolean blnexist=false;
		try {
			blnexist = winObject.getProperty(boolean.class, "Exists");
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Operations Screen is not visible");
		}
		return blnexist;
	}
	
	public Window getWindowByName(String strScreenName, HashMap<Object, Object> ObjScreenName) {
		Window winOutput = (Window) ObjScreenName.get(strScreenName);
		return winOutput;
	}
	
	public Control getButtonByName(String strButonName,HashMap<Object, Object> ButtonList) {
		Control btnOutput = (Control) ButtonList.get(strButonName);
		return btnOutput;
	}
	
	public int[] getButtonCoorByName(String strButonName,HashMap<Object, Object> ButtonList) {
		int x=0;
		int y=0;
		String strCoor = (String) ButtonList.get(strButonName);
		String[] strxy=strCoor.split(",");
		x=Integer.parseInt(strxy[0]);
		y=Integer.parseInt(strxy[1]);
		int [] outCoor= {x,y};
		return outCoor;
	}
	
	public boolean OCRButton(String strButonName,HashMap<Object, Object> ButtonList) {
		boolean blnOCR=false;
		try {
			int[] Coord =getButtonCoorByName(strButonName,ButtonList);
			blnOCR=true;
		}catch(NullPointerException e) {
			blnOCR=false;
		}

		return blnOCR;
	}
	
	public void setCommonObjects(Screens ScreenInventory) {
		
	}
	
	
	public void Combobox_SelectItem(ComboBox objComboBox , int index) {
		try {
			objComboBox.clickItem(index);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}






