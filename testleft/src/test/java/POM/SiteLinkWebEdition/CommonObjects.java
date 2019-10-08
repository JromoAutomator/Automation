package POM.SiteLinkWebEdition;

import com.smartbear.testleft.Driver;
import com.smartbear.testleft.LocalDriver;
import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.ProcessPattern;
import com.smartbear.testleft.testobjects.TestProcess;
import com.smartbear.testleft.testobjects.TextEdit;
import com.smartbear.testleft.testobjects.TopLevelWindow;
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
			e.printStackTrace();
		}
		return WinTopLevel;
	}
	
	public Window GetChildWindow(TopLevelWindow ObjTLWindow,String ControlName) {
		Window WinChildPanel=null;
		final String strControlName = ControlName;
		try {
			WinChildPanel = ObjTLWindow.find(Window.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return WinChildPanel;
	}
	
	public Window GetChildWindow(Window ObjTLWindow,String ControlName) {
		Window WinChildPanel=null;
		final String strControlName = ControlName;
		try {
			WinChildPanel = ObjTLWindow.find(Window.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return WinChildPanel;
	}
	
	public Control CreateButton(Window ObjTLWindow, String ControlName) {
		final String strControlName=ControlName;
		Control Button=null;
		try {
			Button = ObjTLWindow.find(Control.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Button;
	}
	
	public TextEdit CreateTextEdit(Window ObjTLWindow, String ControlName) {
		final String strControlName=ControlName;
		TextEdit TextEditField=null;
		try {
			TextEditField = ObjTLWindow.find(TextEdit.class, new WinFormsPattern(){{WinFormsControlName = strControlName;}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return TextEditField;
	}
	
	
}





