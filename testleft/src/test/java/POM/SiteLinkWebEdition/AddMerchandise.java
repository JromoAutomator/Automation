package POM.SiteLinkWebEdition;

import com.smartbear.testleft.testobjects.Button;
import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.TextEdit;
import com.smartbear.testleft.testobjects.TopLevelWindow;
import com.smartbear.testleft.testobjects.UpDownEditReal;
import com.smartbear.testleft.testobjects.WinFormsPattern;
import com.smartbear.testleft.testobjects.Window;
import com.storable.framework.desktopElements_keywords;

public class AddMerchandise extends desktopElements_keywords{
	private TopLevelWindow FrmPOSPicker;
	private Window WinsmdGroupBox;
	private Window WingrpDiscounts;
	private Window WinpnlDiscountAmounts;
	private Window WinpnlDiscountPct;
	private Window WinpnlDiscountPctValue;
	private UpDownEditReal updownnarrow;
	private TextEdit txtupDownEdit;
	private Button chkDiscountPct;
	
	
	
	
	private CommonObjects CObjects = new CommonObjects();
	private Control btnAdd;
	private Control btnOK;
	
	public AddMerchandise() {
		//setCommonObjects();
		
	}

	@Override
	public void setCommonObjects(Screens ScreenInventory) {
		FrmPOSPicker = CObjects.getTopLevelWindow("SiteLinkClient", "FrmPOSPicker");
		WinsmdGroupBox = CObjects.GetChildWindow(FrmPOSPicker, "grpEdit");
		WingrpDiscounts = CObjects.GetChildWindow(FrmPOSPicker, "grpDiscounts");
		WinpnlDiscountAmounts = CObjects.GetChildWindow(WingrpDiscounts, "pnlDiscountAmounts");
		WinpnlDiscountPct = CObjects.GetChildWindow(WinpnlDiscountAmounts, "pnlDiscountPct");
		WinpnlDiscountPctValue = CObjects.GetChildWindow(WinpnlDiscountPct, "pnlDiscountPctValue");
		
		
		ScreenInventory.ScreenName.put("Add Merchandise", WinsmdGroupBox);
		ScreenInventory.AddMerchandise_ButtonName.put("add to cart", $btnAdd());
		ScreenInventory.AddMerchandise_ButtonName.put("OK", $btnOK());
	}
	
	public Control $btnAdd() {
		return btnAdd = CObjects.CreateButton(FrmPOSPicker, "btnAdd");
	}
	
	public Control $btnOK() {
		return btnOK = CObjects.CreateButton(FrmPOSPicker, "btnOK");
	}
	
	public TextEdit $updownnarrow() {
		try {
		updownnarrow = CObjects.CreateUPDOWN(WinpnlDiscountPctValue, "nudDiscountPct");
		txtupDownEdit = updownnarrow.find(TextEdit.class, new WinFormsPattern(){{ 
			ClrFullClassName = "System.Windows.Forms.UpDownBase+UpDownEdit"; 
		}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return txtupDownEdit;
	}
	
	public Button $chkDiscountPct(){
		return chkDiscountPct = CObjects.CreatewButton(WinpnlDiscountPct, "chkDiscountPct");
	}
	
}





