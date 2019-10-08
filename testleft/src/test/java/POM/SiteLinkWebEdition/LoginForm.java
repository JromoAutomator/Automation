package POM.SiteLinkWebEdition;

import com.smartbear.testleft.Driver;
import com.smartbear.testleft.LocalDriver;
import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.TextEdit;
import com.smartbear.testleft.testobjects.TopLevelWindow;
import com.smartbear.testleft.testobjects.Window;
import com.storable.framework.desktopElements_keywords;

public class LoginForm extends desktopElements_keywords{

	Process SiteLinkClient;	
	
	
	
	//Init Driver and launch APP
	private Driver intDriver = initDriver();
	//Init Common Objects
	private CommonObjects CObjects = new CommonObjects();
	private TopLevelWindow FrmLogonClient = CObjects.getTopLevelWindow("SiteLinkClient", "FrmLogonClient");
	private Window WinPanelMain = CObjects.GetChildWindow(FrmLogonClient, "pnlMain");
		private Window WinPanelCurrent = CObjects.GetChildWindow(WinPanelMain, "pnlCurrent");
		private Window WinStepCredentials = CObjects.GetChildWindow(WinPanelCurrent, "StepCredentials");
		private Window WinSmdGroupBox2 = CObjects.GetChildWindow(WinStepCredentials, "SmdGroupBox2");
	private Window WinPanelFooter = CObjects.GetChildWindow(FrmLogonClient, "pnlFooter");
	//Init Child Objects
	public TextEdit txtCorpCode = CObjects.CreateTextEdit(WinSmdGroupBox2, "txtCorpCode");
	public TextEdit txtLocationCode = CObjects.CreateTextEdit(WinSmdGroupBox2, "txtLocationCode");
	public TextEdit txtPassword = CObjects.CreateTextEdit(WinSmdGroupBox2, "txtPassword");
	public TextEdit txtUserName = CObjects.CreateTextEdit(WinSmdGroupBox2, "txtUserName");
	public Control btnLogin = CObjects.CreateTextEdit(WinPanelFooter, "btnNext");
	
	private Driver initDriver() {
		Driver desdriver=null;
		try {
			desdriver=new LocalDriver();
			System.out.println("launching Site Link");
			SiteLinkClient = new ProcessBuilder("C:/Program Files (x86)/SiteLink Web Edition/Bin/SiteLinkClient.exe").start();
			Thread.sleep(5000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return desdriver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

Driver driver = new LocalDriver();

Window stepWebEditionStartOfDay = driver.find(TestProcess.class, new ProcessPattern(){{ 
	ProcessName = "SiteLinkClient"; 
}}).find(TopLevelWindow.class, new WinFormsPattern(){{ 
	WinFormsControlName = "FrmLogonClient"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlMain"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "pnlCurrent"; 
}}).find(Window.class, new WinFormsPattern(){{ 
	WinFormsControlName = "StepWebEditionStartOfDay"; 
}});

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
