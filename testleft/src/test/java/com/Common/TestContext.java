package com.Common;

import java.util.Collection;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class TestContext {
	
	//Objects
	private WebDriver intDriver;
	public projectProperties projectProp;
	public HipTest hipTest= new HipTest();
	public Common BaseCommon = new Common();


	@Before
	public void before(Scenario scenario) {
	    hipTest.sthipTestCaseID=getHipTestCaseID(scenario);
	    hipTest.addHipTestCaseToRun(hipTest.sthipTestCaseID);
	    hipTest.internalReport.scenarioName=scenario.getName();
	    System.out.println("***********Thread "+Thread.currentThread().getId()+" running tets case id = "+ hipTest.sthipTestCaseID+ " *********************");
	}
	
	public TestContext(){
		projectProp = new projectProperties();
		hipTest.internalReport=BaseCommon.Report;	
	}
	
	
	public WebDriver GetDriver() {
		return this.intDriver;
	}
	
	public HipTest getHipTest() {
		return this.hipTest;
	}
	
	
	private String getHipTestCaseID(Scenario scenario) {
		String tag=null;
		Collection<String> ArrayTags = scenario.getSourceTagNames();
		for (String Arrtag : ArrayTags) {
			if(Arrtag.contains("@HTC")) {
				String[] Splittag=Arrtag.split("-");
				tag=Splittag[1];
			}
		}
		return tag;
	}
	
	

}
