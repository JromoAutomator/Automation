package com.Samples;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.Keywords.Enums;
import com.Keywords.java_Utils;


public class SampleWebTest {
    private WebDriver chromeDriver;
    private WebDriver firefoxDriver;
    private WebDriver SafariDriver;
    private WebDriver IEDriver;
    private WebDriver EdgeDriver;
	private java_Utils java_u = new java_Utils();

    @Test(groups = {Enums.RegressionTest,Enums.Chrome}, priority = 1, description = "Simple web Test-Chrome")
    public void SimpleChromeTest(){
        this.chromeDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        this.chromeDriver.quit();
    }

    @Test(groups = {Enums.RegressionTest,Enums.Chrome}, priority = 1, description = "Simple web Test-Chrome")
    public void SimpleChromeTest2(){
    	this.chromeDriver.get("https://www.google.com/");
    }

    @Test(groups = {Enums.RegressionTest,Enums.Firefox}, priority = 1, description = "Simple web Test-FireFox")
    public void SimpleFireFoxTest(){

    }


    //SetUp @Before and After
    @BeforeTest(groups=Enums.Chrome)
    public void setUpChromeSession(){
    	this.chromeDriver= java_u.getDriver(Enums.Browser.CHROME);
    }

    @BeforeTest(groups=Enums.Firefox)
    public void setUpFireFoxSession(){

    }

    @BeforeTest(groups=Enums.Safari)
    public void setUpSafariSession(){

    }

    @BeforeTest(groups=Enums.Internet_Explorer)
    public void setUpIESession(){

    }

    @BeforeTest(groups=Enums.Edge)
    public void setUpEdgeSession(){

    }

  




}

