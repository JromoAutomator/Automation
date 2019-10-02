package POM.Google;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitGoogle {

	public WebDriver InitDriver(){
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chromeDriver.manage().window().maximize();
		return chromeDriver;
	}
	
}
