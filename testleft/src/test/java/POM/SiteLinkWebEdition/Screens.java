package POM.SiteLinkWebEdition;

import java.util.HashMap;

import com.storable.framework.desktopElements_keywords;

public class Screens extends desktopElements_keywords{
	
	public HashMap<Object, Object> ScreenName = new HashMap<>(); 
	public HashMap<Object, Object> ClassScreenName = new HashMap<>(); 
	public HashMap<Object, Object> Maps = new HashMap<>(); 
	public HashMap<Object, Object> MapsCoor = new HashMap<>(); 
	
	public HashMap<Object, Object> Operations_ButtonName = new HashMap<>();
	public HashMap<Object, Object> Operations_ButtonCoor = new HashMap<>();

	public HashMap<Object, Object> AddMerchandise_ButtonName = new HashMap<>();
	public HashMap<Object, Object> Payment_ButtonName = new HashMap<>();
	
	
	
	public Screens() {
		Maps.put("Operations", Operations_ButtonName);
		Maps.put("Add Merchandise", AddMerchandise_ButtonName);
		Maps.put("Payment", Payment_ButtonName);
		
		MapsCoor.put("Operations", Operations_ButtonCoor);
	}
}
