package com.prac.sel.TestRunners;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/main/resources/features/PickYourTrailsRecheck.feature"},
		tags = {"@pickyourrecheck"},
	    glue = {"com.prac.sel.stepdefinitions", "com.prac.sel.BrowserUtillities"}
		) 

public class TestBlahBlah_IT {

}
