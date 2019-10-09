package POM.SiteLinkWebEdition;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import com.smartbear.testleft.Driver;
import com.smartbear.testleft.LocalDriver;
import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.TextEdit;
import com.smartbear.testleft.testobjects.TopLevelWindow;
import com.smartbear.testleft.testobjects.Window;
import com.storable.framework.desktopElements_keywords;


public class LoginForm extends desktopElements_keywords{

	Process SiteLinkClient;	
	//Objects
	private TextEdit txtCorpCode;
	private TextEdit txtLocationCode;
	private TextEdit txtPassword;
	private TextEdit txtUserName;
	private Control btnLogin;
	private Control btnNext;
	private Control btnPrintReports;
	private Control btnContinue;
	
	//CommonObjects
	public TopLevelWindow FrmLogonClient;
	public Window WinPanelMain;
	public Window WinPanelCurrent;
	public Window WinStepCredentials;
	public Window WinSmdGroupBox2;
	public Window WinPanelFooter;
	public Window WinStepWebEditionStartOfDay;
	public Window WinSmdGroupBox1;
	public Window WinPanelFooterCustom;
	public Window WinPanelCustomFooter;
	
	private HashMap<Object, Object> ScreenName = new HashMap<>();
	
	//AddScreenName
	public LoginForm() {
		
		//setCommonObjects();
	
	}
	
	//Init Common Objects
	private CommonObjects CObjects = new CommonObjects();

	@Override
	public void setCommonObjects(Screens ScreenInventory) {
		initDriver();
		FrmLogonClient = CObjects.getTopLevelWindow("SiteLinkClient", "FrmLogonClient");
		WinPanelMain = CObjects.GetChildWindow(FrmLogonClient, "pnlMain");
		WinPanelCurrent = CObjects.GetChildWindow(WinPanelMain, "pnlCurrent");
		WinStepCredentials = CObjects.GetChildWindow(WinPanelCurrent, "StepCredentials");
		WinSmdGroupBox2 = CObjects.GetChildWindow(WinStepCredentials, "SmdGroupBox2");
		WinPanelFooter = CObjects.GetChildWindow(FrmLogonClient, "pnlFooter");
		ScreenInventory.ScreenName.put("Login",WinSmdGroupBox2);
		ScreenInventory.ScreenName.put("StartOfDay",WinStepWebEditionStartOfDay);
	}
	
	private void setCommonObjects_StartOfDay() {
		WinStepWebEditionStartOfDay = CObjects.GetChildWindow(WinPanelCurrent, "StepWebEditionStartOfDay");
		WinSmdGroupBox1 = CObjects.GetChildWindow(WinStepWebEditionStartOfDay, "SmdGroupBox1");
		WinPanelFooterCustom = CObjects.GetChildWindow(FrmLogonClient, "pnlFooterCustom");
		WinPanelCustomFooter = CObjects.GetChildWindow(WinPanelFooterCustom, "pnlCustomFooter");
	}
	
	private void initDriver() {
		try {
			System.out.println("launching Site Link");
			SiteLinkClient = new ProcessBuilder("C:/Program Files (x86)/SiteLink Web Edition/Bin/SiteLinkClient.exe").start();
			Thread.sleep(5000);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public TextEdit $txtCorpCode() {
		return txtCorpCode = CObjects.CreateTextEdit(WinSmdGroupBox2, "txtCorpCode");
	}
	
	public TextEdit $txtLocationCode() {
		return txtLocationCode = CObjects.CreateTextEdit(WinSmdGroupBox2, "txtLocationCode");
	}
	
	public TextEdit $txtPassword() {
		return txtPassword = CObjects.CreateTextEdit(WinSmdGroupBox2, "txtPassword");
	}
	
	public TextEdit $txtUserName() {
		return txtUserName = CObjects.CreateTextEdit(WinSmdGroupBox2, "txtUserName");
	}
	
	public Control $btnLogin() {
		return btnLogin = CObjects.CreateButton(WinPanelFooter, "btnNext");
	}
	
	public Control $btnPrintReports() {
		setCommonObjects_StartOfDay();
		return btnPrintReports = CObjects.CreateButton(WinSmdGroupBox1, "btnPrintReports");
	}
	
	public Control $btnContinue() {
		return btnContinue = CObjects.CreateButton(WinPanelCustomFooter, "btnBack");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}




//Update
/*
Driver driver = new LocalDriver();

Window smdButton = driver.find(TestProcess.class, new ProcessPattern(){{ 
	ProcessName = "SiteLinkLiveUpdate"; 
}}).find(TopLevelWindow.class, new WinFormsPattern(){{ 
	WinFormsControlName = "FrmLiveUpdateBase"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlFooter"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "btnNext"; 
}});


Driver driver = new LocalDriver();

Button radioButton = driver.find(TestProcess.class, new ProcessPattern(){{ 
	ProcessName = "SiteLinkLiveUpdate"; 
}}).find(TopLevelWindow.class, new WinFormsPattern(){{ 
	WinFormsControlName = "FrmLiveUpdateBase"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlMain"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlCurrent"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "StepLicenseAgreement"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlOptions"; 
}}).find(Button.class, new WinFormsPattern(){{ 
	WinFormsControlName = "rdoAcceptLicense"; 
}});


Driver driver = new LocalDriver();

Window smdButton = driver.find(TestProcess.class, new ProcessPattern(){{ 
	ProcessName = "SiteLinkLiveUpdate"; 
}}).find(TopLevelWindow.class, new WinFormsPattern(){{ 
	WinFormsControlName = "FrmLiveUpdateBase"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlFooter"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "btnNext"; 
}});


Driver driver = new LocalDriver();

Window smdButton = driver.find(TestProcess.class, new ProcessPattern(){{ 
	ProcessName = "SiteLinkLiveUpdate"; 
}}).find(TopLevelWindow.class, new WinFormsPattern(){{ 
	WinFormsControlName = "FrmLiveUpdateBase"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlFooter"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "btnFinish"; 
}});
*/

/*
Driver driver = new LocalDriver();

TextEdit smdTextBox = driver.find(TestProcess.class, new ProcessPattern(){{ 
	ProcessName = "SiteLinkClient"; 
}}).find(TopLevelWindow.class, new WinFormsPattern(){{ 
	WinFormsControlName = "FrmLogonClient"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlMain"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlCurrent"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "StepCredentials"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "SmdGroupBox2"; 
}}).find(TextEdit.class, new WinFormsPattern(){{ 
	WinFormsControlName = "txtCorpCode"; 
}});

Driver driver = new LocalDriver();

TextEdit smdTextBox = driver.find(TestProcess.class, new ProcessPattern(){{ 
	ProcessName = "SiteLinkClient"; 
}}).find(TopLevelWindow.class, new WinFormsPattern(){{ 
	WinFormsControlName = "FrmLogonClient"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlMain"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlCurrent"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "StepCredentials"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "SmdGroupBox2"; 
}}).find(TextEdit.class, new WinFormsPattern(){{ 
	WinFormsControlName = "txtLocationCode"; 
}});

Driver driver = new LocalDriver();

TextEdit smdTextBox = driver.find(TestProcess.class, new ProcessPattern(){{ 
	ProcessName = "SiteLinkClient"; 
}}).find(TopLevelWindow.class, new WinFormsPattern(){{ 
	WinFormsControlName = "FrmLogonClient"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlMain"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlCurrent"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "StepCredentials"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "SmdGroupBox2"; 
}}).find(TextEdit.class, new WinFormsPattern(){{ 
	WinFormsControlName = "txtPassword"; 
}});


Driver driver = new LocalDriver();

TextEdit smdTextBox = driver.find(TestProcess.class, new ProcessPattern(){{ 
	ProcessName = "SiteLinkClient"; 
}}).find(TopLevelWindow.class, new WinFormsPattern(){{ 
	WinFormsControlName = "FrmLogonClient"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlMain"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlCurrent"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "StepCredentials"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "SmdGroupBox2"; 
}}).find(TextEdit.class, new WinFormsPattern(){{ 
	WinFormsControlName = "txtUserName"; 
}});



Driver driver = new LocalDriver();

TextEdit smdTextBox = driver.find(TestProcess.class, new ProcessPattern(){{ 
	ProcessName = "SiteLinkClient"; 
}}).find(TopLevelWindow.class, new WinFormsPattern(){{ 
	WinFormsControlName = "FrmLogonClient"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlMain"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlCurrent"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "StepCredentials"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "SmdGroupBox2"; 
}}).find(TextEdit.class, new WinFormsPattern(){{ 
	WinFormsControlName = "txtCorpCode"; 
}});

boolean existsValue = smdTextBox.getProperty(boolean.class, "Exists");
*/
