package com.storable.testleft;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefs","com.Common"},
        //tags = {"~@ignore"}
        tags = {"@Web"}
        )


public class TestRunner extends AbstractTestNGCucumberTests{
	/*private TestNGCucumberRunner testNGCucumberRunner;
	

  @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
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
  }*/
  
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
