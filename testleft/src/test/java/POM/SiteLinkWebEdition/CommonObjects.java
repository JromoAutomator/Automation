package POM.SiteLinkWebEdition;

import com.smartbear.testleft.Driver;
import com.smartbear.testleft.LocalDriver;
import com.smartbear.testleft.testobjects.Button;
import com.smartbear.testleft.testobjects.ComboBox;
import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.ObjectTreeNode;
import com.smartbear.testleft.testobjects.ProcessPattern;
import com.smartbear.testleft.testobjects.TestProcess;
import com.smartbear.testleft.testobjects.TextEdit;
import com.smartbear.testleft.testobjects.TopLevelWindow;
import com.smartbear.testleft.testobjects.UpDownEditReal;
import com.smartbear.testleft.testobjects.WinFormsPattern;
import com.smartbear.testleft.testobjects.Window;

public class CommonObjects {
	private Driver intDriver;
	
	public CommonObjects() {
		try {
			intDriver = new LocalDriver();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	

	public TopLevelWindow getTopLevelWindow(String ProcessName, String ControlName) {
		TopLevelWindow WinTopLevel=null;
		final String strProcessName = ProcessName;
		final String strControlName = ControlName;
		try {
			WinTopLevel = intDriver.find(TestProcess.class, new ProcessPattern(){{ProcessName = strProcessName;}}).
			find(TopLevelWindow.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			///e.printStackTrace();
			//System.out.println("unble to locate TopLevelWindow : "+ControlName);
		}
		return WinTopLevel;
	}
	
	public Window GetChildWindow(TopLevelWindow ObjTLWindow,String ControlName) {
		Window WinChildPanel=null;
		final String strControlName = ControlName;
		try {
			WinChildPanel = ObjTLWindow.find(Window.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			//e.printStackTrace();
			//System.out.println("unble to locate ChildWindow : "+ControlName);
		}
		return WinChildPanel;
	}
	
	public Window GetChildWindow(Window ObjTLWindow,String ControlName) {
		Window WinChildPanel=null;
		final String strControlName = ControlName;
		try {
			WinChildPanel = ObjTLWindow.find(Window.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			//e.printStackTrace();
			//System.out.println("unble to locate ChildWindow : "+ControlName);
		}
		return WinChildPanel;
	}
	
	public Control CreateButton(Window ObjTLWindow, String ControlName) {
		final String strControlName=ControlName;
		Control Button=null;
		try {
			Button = ObjTLWindow.find(Control.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return Button;
	}
	
	public Control CreateButton(TopLevelWindow ObjTLWindow, String ControlName) {
		final String strControlName=ControlName;
		Control Button=null;
		try {
			Button = ObjTLWindow.find(Control.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return Button;
	}
	
	public TextEdit CreateTextEdit(Window ObjTLWindow, String ControlName) {
		final String strControlName=ControlName;
		TextEdit TextEditField=null;
		try {
			TextEditField = ObjTLWindow.find(TextEdit.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return TextEditField;
	}
	
	public TextEdit CreateTextEdit(UpDownEditReal ObjTLWindow, String ControlName) {
		final String strControlName=ControlName;
		TextEdit TextEditField=null;
		try {
			TextEditField = ObjTLWindow.find(TextEdit.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return TextEditField;
	}
	
	public UpDownEditReal CreateUPDOWN(Window ObjTLWindow, String ControlName) {
		final String strControlName=ControlName;
		UpDownEditReal TextEditField=null;
		try {
			TextEditField = ObjTLWindow.find(UpDownEditReal.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return TextEditField;
	}
	
	public ComboBox CreateComboBox(Window ObjTLWindow, String ControlName) {
		final String strControlName=ControlName;
		ComboBox cbButton=null;
		try {
			cbButton = ObjTLWindow.find(ComboBox.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return cbButton;
	}
	
	public Button CreatewButton(Window ObjTLWindow, String ControlName) {
		final String strControlName=ControlName;
		Button Button=null;
		try {
			Button = ObjTLWindow.find(Button.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			//e.printStackTrace();
		}
		return Button;
	}
	
}





