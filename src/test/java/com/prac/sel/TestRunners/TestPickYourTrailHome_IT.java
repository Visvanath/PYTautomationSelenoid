package com.prac.sel.TestRunners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/main/resources/features/PickYourTrailsHome.feature"},
		tags = {"@pickyourtrailHome"},
	    glue = {"com.prac.sel.stepdefinitions", "com.prac.sel.BrowserUtillities"}
		) 

public class TestPickYourTrailHome_IT {
	
}
