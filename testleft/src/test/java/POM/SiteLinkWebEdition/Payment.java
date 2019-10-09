package POM.SiteLinkWebEdition;

import com.smartbear.testleft.Driver;
import com.smartbear.testleft.LocalDriver;
import com.smartbear.testleft.testobjects.Button;
import com.smartbear.testleft.testobjects.ComboBox;
import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.ProcessPattern;
import com.smartbear.testleft.testobjects.TestProcess;
import com.smartbear.testleft.testobjects.TopLevelWindow;
import com.smartbear.testleft.testobjects.UIAPattern;
import com.smartbear.testleft.testobjects.WinFormsPattern;
import com.smartbear.testleft.testobjects.Window;
import com.storable.framework.desktopElements_keywords;

public class Payment extends desktopElements_keywords {
	private TopLevelWindow FrmPayment;
	private Window WinsmdgrpPmt;
	private CommonObjects CObjects = new CommonObjects();
	private ComboBox cbPaymentMethod;
	private Control btnOK;
	private Driver driver;
	//Pending to check if this is generic, then create a separate class
	private TopLevelWindow FrmSmdMessageBox;
	private Window WinpnlButtons;
	private Button msgbtnYes;
	private Button msgbtnNo;
	private Button msgbtnOK;

	
	public Payment() {
		//setCommonObjects();
		
	}

	@Override
	public void setCommonObjects(Screens ScreenInventory) {
		FrmPayment = CObjects.getTopLevelWindow("SiteLinkClient", "FrmPayment");
		WinsmdgrpPmt = CObjects.GetChildWindow(FrmPayment, "grpPmt");
		ScreenInventory.ScreenName.put("Payment", WinsmdgrpPmt);
		ScreenInventory.Payment_ButtonName.put("OK", $btnOK());
	}
	
	
	public Control $btnOK() {
		return btnOK = CObjects.CreateButton(FrmPayment, "btnOK");
	}
	
	public ComboBox $cbPaymentMethod() {
		return cbPaymentMethod = CObjects.CreateComboBox(WinsmdgrpPmt, "cboPmtType");
	}

	public Button $msgbtnYes(String strWindow) {
		FrmSmdMessageBox = WinstMessage(strWindow);
		WinpnlButtons = CObjects.GetChildWindow(FrmSmdMessageBox, "pnlButtons");
		return msgbtnYes = CObjects.CreatewButton(WinpnlButtons, "btn2");
		
	}
	
	public Button $msgbtnNo(String strWindow) {
		FrmSmdMessageBox = WinstMessage(strWindow);
		WinpnlButtons = CObjects.GetChildWindow(FrmSmdMessageBox, "pnlButtons");
		return msgbtnNo = CObjects.CreatewButton(WinpnlButtons, "btn3");
	}
	
	public Button $msgbtnOK(String strWindow) {
		FrmSmdMessageBox = WinstMessage(strWindow);
		WinpnlButtons = CObjects.GetChildWindow(FrmSmdMessageBox, "pnlButtons");
		return msgbtnOK = CObjects.CreatewButton(WinpnlButtons, "btn3");
	}
	
	
	private TopLevelWindow WinstMessage(String strCaption) {
		final String strFlCaption= strCaption;
		try {
			driver = new LocalDriver();
			FrmSmdMessageBox = driver.find(TestProcess.class, new ProcessPattern(){{ProcessName = "SiteLinkClient"; 
			}}).find(TopLevelWindow.class, new WinFormsPattern(){{WinFormsControlName = "SmdMessageBox"; WndCaption = strFlCaption;}});
			}catch(Exception e) {
				e.printStackTrace();
			}
		return FrmSmdMessageBox;
	}
	
	
	
}





