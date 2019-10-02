package POM.Calculator;

import com.smartbear.testleft.testobjects.Control;
import com.smartbear.testleft.testobjects.ProcessPattern;
import com.smartbear.testleft.testobjects.TestProcess;
import com.smartbear.testleft.testobjects.TopLevelWindow;
import com.smartbear.testleft.testobjects.UIAPattern;
import com.storable.framework.desktopElements_keywords;
import com.smartbear.testleft.*;


public class CalculatorApp extends desktopElements_keywords {
	TestProcess process=null;

	private Driver initDriver() {
		Driver desdriver=null;
		try {
			desdriver=new LocalDriver();
			process = desdriver.getApplications().run("C:\\Windows\\System32\\calc.exe");
			}catch(Exception e) {
				e.printStackTrace();
			}
		return desdriver;
	}
	
	private Driver intDriver = initDriver();
	private Control numericKeyboard = getNumericKeyboard();
	private Control standardOperations = getStandarOperation();
	
	public Control button5 = get_button5();
	public Control button7 = get_button7();
	public Control buttonSum =get_buttonSum();
	public Control buttonEqual =get_buttonEqual();
	
	public void CloseApp() {
		try {
			process.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private Control get_button5 () {		
		Control Button=null;
		try {
			Button = numericKeyboard.find(Control.class, new UIAPattern(){{ 
			FrameworkId = "XAML"; 
			ClassName = "Button"; 
			LocalizedControlType = "botón"; 
			ObjectIdentifier = "Cinco";}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Button;
	}
	private Control get_button7 () {
		Control Button=null;
		try {
			Button = numericKeyboard.find(Control.class, new UIAPattern(){{ 
			FrameworkId = "XAML"; 
			ClassName = "Button"; 
			LocalizedControlType = "botón"; 
			ObjectIdentifier = "Siete";}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Button;
	}
	private Control get_buttonSum () {
		Control Button=null;
		try {
			Button = standardOperations.find(Control.class, new UIAPattern(){{ 
			FrameworkId = "XAML"; 
			ClassName = "Button"; 
			LocalizedControlType = "botón"; 
			ObjectIdentifier = "Más";}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Button;
		}
	private Control get_buttonEqual () {
		Control Button=null;
		try {
			Button = standardOperations.find(Control.class, new UIAPattern(){{ 
			FrameworkId = "XAML"; 
			ClassName = "Button"; 
			LocalizedControlType = "botón"; 
			ObjectIdentifier = "Es_igual_a";}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Button;
		}
	
	
	private TopLevelWindow getparentObject() {
		TopLevelWindow Container=null;
		try {
			Container = intDriver.find(TestProcess.class, new ProcessPattern(){{ 
			ProcessName = "Microsoft.WindowsCalculator";}}).find(TopLevelWindow.class, new UIAPattern(){{ 
			FrameworkId = "XAML"; 
			ClassName = "Windows.UI.Core.CoreWindow"; 
			LocalizedControlType = "ventana"; 
			ObjectIdentifier = "Calculadora"; 
			ObjectGroupIndex = 1; 
		}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Container;
	}
	private Control getLandTarget() {
		TopLevelWindow App = getparentObject();
		Control LandTarget=null;
		try {
		LandTarget = App.find(Control.class, new UIAPattern(){{ 
			FrameworkId = "XAML"; 
			ClassName = "LandmarkTarget"; 
			LocalizedControlType = "grupo"; 
			ObjectIdentifier = "LandmarkTarget"; 
			ObjectGroupIndex = 1; 
		}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return LandTarget;
	}
	private Control getNumericKeyboard() {
		Control Container = getLandTarget();
		Control NumericKeyboard=null;
		try {
			NumericKeyboard = Container.find(Control.class, new UIAPattern(){{ 
				FrameworkId = "XAML"; 
				ClassName = "NamedContainerAutomationPeer"; 
				LocalizedControlType = "grupo"; 
				ObjectIdentifier = "Teclado_numérico"; 
			}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return NumericKeyboard;
	}
	private Control getStandarOperation() {
		Control Container = getLandTarget();
		Control StandarOperation=null;
		try {
			StandarOperation = Container.find(Control.class, new UIAPattern(){{ 
			FrameworkId = "XAML"; 
			ClassName = "NamedContainerAutomationPeer"; 
			LocalizedControlType = "grupo"; 
			ObjectIdentifier = "Operadores_estándar"; 
			}});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return StandarOperation;
	}
}	



