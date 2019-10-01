package com.Samples;

import com.smartbear.testleft.*;
import com.smartbear.testleft.testobjects.*;

public class SampleTestLeft {

	public static void main(String[] args) throws Exception, TestAgentRunException, RestConnectionRefused {
		Driver driver = new LocalDriver();

		TextEdit edit = driver.find(TestProcess.class, new ProcessPattern(){{ProcessName = "notepad";}}).find(TopLevelWindow.class, new WindowPattern(){{ 
			WndClass = "Notepad"; 
		}}).find(TextEdit.class, new WindowPattern(){{ 
			WndClass = "Edit"; 
		}});
		
		edit.keys("Hola");
		
		
		


		Control scrollViewer = driver.find(TestProcess.class, new ProcessPattern(){{ 
			ProcessName = "Microsoft.WindowsCalculator"; 
		}}).find(TopLevelWindow.class, new UIAPattern(){{ 
			FrameworkId = "XAML"; 
			ClassName = "Windows.UI.Core.CoreWindow"; 
			LocalizedControlType = "ventana"; 
			ObjectIdentifier = "Calculadora"; 
			ObjectGroupIndex = 1; 
		}}).find(Control.class, new UIAPattern(){{ 
			FrameworkId = "XAML"; 
			ClassName = "LandmarkTarget"; 
			LocalizedControlType = "grupo"; 
			ObjectIdentifier = "LandmarkTarget"; 
			ObjectGroupIndex = 1; 
		}}).find(Control.class, new UIAPattern(){{ 
			FrameworkId = "XAML"; 
			ClassName = null; 
			LocalizedControlType = "texto"; 
			ObjectIdentifier = "Se_muestra_0"; 
		}}).find(Control.class, new UIAPattern(){{ 
			FrameworkId = "XAML"; 
			ClassName = "ScrollViewer"; 
			LocalizedControlType = "panel"; 
			ObjectIdentifier = "TextContainer"; 
		}});
	}

}
