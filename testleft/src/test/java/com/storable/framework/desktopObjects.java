package com.storable.framework;

import java.util.HashMap;

import com.smartbear.testleft.testobjects.Button;
import com.smartbear.testleft.testobjects.ComboBox;
import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.TextEdit;
import com.smartbear.testleft.testobjects.Window;

import POM.SiteLinkWebEdition.Screens;

public interface desktopObjects {
//TextEdit
    public void textBox_EnterText(TextEdit editApp,String strText);
    public String element_Getlabel(TextEdit editApp);

    //Object Common
   // public boolean element_isVisible(TextEdit editApp);
   // public boolean element_isEnabled(TextEdit editApp);
    
  
//Control
    //Buttons
    public void button_Click(Control windowObject);
    public void button_Click(Button windowObject);
    public void button_Click(Control windowObject, int x, int y);
    public void waitforButtontoExist(Control windowObject);
    public Control getButtonByName(String strButonName,HashMap<Object, Object> ButtonList);
    public int[] getButtonCoorByName(String strButonName,HashMap<Object, Object> ButtonList);
    public boolean OCRButton(String strButonName,HashMap<Object, Object> ButtonList);
    //TextBox
   // public void textBox_EnterText(Control windowObject,String strText);

    //Object Common
    //public boolean element_isVisible(Control windowObject);
   // public boolean element_isEnabled(Control windowObject);
    public String element_Getlabel(Control windowObject);
	
    
// Window
    public void waitforWindowtoExist(Window winObject);
    public boolean ScreenExist(Window winObject);
    public Window getWindowByName(String strScreenName,HashMap<Object, Object> ScreenName);
    
    public void setCommonObjects(Screens ScreenInventory);
    
    
    //CboBOx
    public void Combobox_SelectItem(ComboBox objComboBox, int index);
}


