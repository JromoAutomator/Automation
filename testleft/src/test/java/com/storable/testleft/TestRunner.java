package com.storable.testleft;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefs"},
        tags = {"@SmokeTest"})

public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;
	

  @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
  public void feature(CucumberFeatureWrapper cucumberFeature) {
      testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
  }

  @BeforeClass(alwaysRun = true)
  public void beforeClass() {
	  testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
  }

  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  testNGCucumberRunner.finish();  
  }
  
  @DataProvider  
  public Object[][] features() {  
        return testNGCucumberRunner.provideFeatures();  
  }  

}
