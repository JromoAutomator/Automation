package POM.SiteLinkWebEdition;

import java.util.HashMap;
import java.util.List;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.InvocationException;
import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.ObjectTreeNode;
import com.smartbear.testleft.testobjects.TopLevelWindow;
import com.smartbear.testleft.testobjects.Window;
import com.storable.framework.desktopElements_keywords;

public class Operations extends desktopElements_keywords {
	
	//Objects
	private Control btnMoveIn;
	private Control btnMoveOut;
	private Control btnPayment;
	private Control btnTransfer;
	private Control btnribbon;
	private Control btnMerchandisePurchase;
	

	//CommonObjects
	private TopLevelWindow FrmNav;
	private Window WinPanelOper;
	private Window WinGroupOper;
	private Window WinGroupPos;

	private CommonObjects CObjects = new CommonObjects();

	@Override
	public void setCommonObjects(Screens ScreenInventory) {
		FrmNav = CObjects.getTopLevelWindow("SiteLinkClient", "FrmNav");
		WinPanelOper = CObjects.GetChildWindow(FrmNav, "pnlOper");
		WinGroupOper = CObjects.GetChildWindow(WinPanelOper, "grpOper");
		WinGroupPos = CObjects.GetChildWindow(WinPanelOper, "grpPOS");
		ScreenInventory.ScreenName.put("Operations",WinGroupOper);
		
		//Buttons
		ScreenInventory.Operations_ButtonName.put("Setup", $btnribbon());
		ScreenInventory.Operations_ButtonName.put("Move in", $btnMoveIn());
		ScreenInventory.Operations_ButtonName.put("Move out", $btnMoveOut());
		ScreenInventory.Operations_ButtonName.put("Payment", $btnPayment());
		ScreenInventory.Operations_ButtonName.put("Transfer", $btnTransfer());
		ScreenInventory.Operations_ButtonName.put("Merchandise Purchase", $btnMerchandisePurchase());
		
		
		
		//ButtonPos
		ScreenInventory.Operations_ButtonCoor.put("Setup", "440,14");
		
	}
	
	
	//AddScreenName
	public Operations() {
	
		
	}
	
	
	public Control $btnMoveIn() {
		return btnMoveIn = CObjects.CreateButton(WinGroupOper, "btnMoveIn");
	}
	
	public Control $btnMoveOut() {
		return btnMoveOut = CObjects.CreateButton(WinGroupOper, "btnMoveOut");
	}
	
	public Control $btnPayment() {
		return btnPayment = CObjects.CreateButton(WinGroupOper, "btnPayment");
	}
	
	public Control $btnTransfer() {
		return btnTransfer = CObjects.CreateButton(WinGroupOper, "btnTransfer");
	}
	
	public Control $btnribbon() {
		return btnribbon = CObjects.CreateButton(FrmNav, "Ribbon1");
	}

	public Control $btnMerchandisePurchase() {
		return btnMerchandisePurchase = CObjects.CreateButton(WinGroupPos, "btnPOS");
	}
	
	
	
	
}




