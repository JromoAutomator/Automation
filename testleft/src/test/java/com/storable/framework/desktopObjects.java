package com.storable.framework;

import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.TextEdit;

public interface desktopObjects {
//Notepad App
    //Buttons
   // public void button_Click(TextEdit editApp);

    //TextBox
    public void textBox_EnterText(TextEdit editApp,String strText);
    public String element_Getlabel(TextEdit editApp);

    //Object Common
   // public boolean element_isVisible(TextEdit editApp);
   // public boolean element_isEnabled(TextEdit editApp);
    
  
//Calculator App
    //Buttons
    public void button_Click(Control windowObject);

    //TextBox
   // public void textBox_EnterText(Control windowObject,String strText);

    //Object Common
    //public boolean element_isVisible(Control windowObject);
   // public boolean element_isEnabled(Control windowObject);
    public String element_Getlabel(Control windowObject) ;
	
}


