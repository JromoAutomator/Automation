package com.Common;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class myPageFactory extends PageFactory{
	
	private static HashMap<String, String > myElements = new HashMap<String, String >();
	private static String objID;

	public static void initElements(ElementLocatorFactory factory, Object page) {
		final ElementLocatorFactory factoryRef = factory;
		initElements(new DefaultFieldDecorator(factoryRef), page);
	}
	
	public static HashMap<String, String > $initElements(ElementLocatorFactory factory, Object page) {
		final ElementLocatorFactory factoryRef = factory;
		initElements(new DefaultFieldDecorator(factoryRef), page);
		return myElements;
	}

	public static void initElements(FieldDecorator decorator, Object page) {
		Class<?> proxyIn = page.getClass();
		while (proxyIn != Object.class) {
			proxyFields(decorator, page, proxyIn);
			proxyIn = proxyIn.getSuperclass();
		}
	}
	
	private static void proxyFields(FieldDecorator decorator, Object page, Class<?> proxyIn) {
		String objectID, objectSubID=null, strlastCharacter;
		String[] ArrScreenName = proxyIn.toString().split(" ");
		String[] strScreenName = ArrScreenName[1].split("\\.");
		String ScreenName = strScreenName[strScreenName.length-1];
	    Field[] fields = proxyIn.getDeclaredFields();
	    for (Field field : fields) {
	      Object value = decorator.decorate(page.getClass().getClassLoader(), field);
	      if (value != null) {
	        try {
	          field.setAccessible(true);
	          field.set(page, value);
	          objID=value.toString();
	          if(objID.contains("Proxy element")) {
	  			String[] st1= objID.split("'By.");
	  			objectID= st1[st1.length-1].trim();
	  			if(!objectID.contains("xpath")) {
	  				objectSubID=objectID.substring(0, objectID.length()-1);
				}else {
					strlastCharacter=""+objectID.charAt(objectID.length()-1);
					if(strlastCharacter.equals("'")) {
						objectSubID=objectID.substring(0, objectID.length()-1);
					}else {
						objectSubID=objectID;}
					}
	  		  }else {
	  			String[] st1= objID.split("->");
	  			objectID= st1[st1.length-1].trim();
	  			if(!objectID.contains("xpath")) {
	  				objectSubID=objectID.substring(0, objectID.length()-1);
				}else {
					strlastCharacter=""+objectID.charAt(objectID.length()-1);
					if(strlastCharacter.equals("'")) {
						objectSubID=objectID.substring(0, objectID.length()-1);
					}else {
						objectSubID=objectID;}
					}
	  		  }
	          
	         // System.out.println(objectSubID);
	          myElements.put(objectSubID, ScreenName+":"+field.getName());
	        } catch (IllegalAccessException e) {
	          throw new RuntimeException(e);
	        }
	      }
	    }
	  }
}
