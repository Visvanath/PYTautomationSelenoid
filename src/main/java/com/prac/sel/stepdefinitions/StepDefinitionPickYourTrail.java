package com.prac.sel.stepdefinitions;

import org.openqa.selenium.WebDriver;
import java.lang.reflect.Method;

import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import com.prac.sel.BrowserUtillities.Hooks;
import com.prac.sel.BrowserUtillities.StatusReports;
import com.prac.sel.BrowserUtillities.WrapperMethods;
import com.prac.sel.pageObjects.PickYourTrailHomePage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionPickYourTrail extends WrapperMethods {
	WrapperMethods wrapperMethods = new WrapperMethods();
	Hooks hook = new Hooks();
	WebDriver driver = hook.getDriver();
	PickYourTrailHomePage pickYourTrailHomePage = new PickYourTrailHomePage(driver);

	@Given("^I launch the PIckYourTrails homePage$")
	public void i_launch_the_PIckYourTrails_homePage() throws Throwable {
		WebDriver driver = hook.getDriver();
		driver.get("https://pickyourtrail.com/");
	//	StatusReports.logStatus(true, "Verifiation of launching PYT", driver);
	}

	@Given("^I enter text in 'Create Itinerary text box' in homepage$")
	public void i_enter_text_in_Create_Itinerary_text_box_in_homepage() throws Throwable {

		wrapperMethods.checkAndClick(driver, pickYourTrailHomePage.creteItinerary);
		wrapperMethods.checkAndType(driver, pickYourTrailHomePage.searchCityTextBox, "Australia");
	    StatusReports.logStatus(isElementVisible(driver, pickYourTrailHomePage.searchCitySuggestions), "Verification of typeAhead suggestions", driver);
	}

	@When("^I select one of the options listed below$")
	public void i_select_one_of_the_options_listed_below() throws Throwable {
		
		wrapperMethods.checkAndClick(driver, pickYourTrailHomePage.listedOption);
		wrapperMethods.checkAndClick(driver, pickYourTrailHomePage.selectTravelMonth);
		wrapperMethods.checkAndClick(driver, pickYourTrailHomePage.selectDuration); 
		StatusReports.logStatus(isElementVisible(driver, pickYourTrailHomePage.vacationType), "Verification of navigation to vacation type page", driver);
	}

	@Then("^the list of available dates with the heading 'when do you want to explore\\?' must be shown$")
	public void the_list_of_available_dates_with_the_heading_when_do_you_want_to_explore_must_be_shown()
			throws Throwable {		
		wrapperMethods.checkAndClick(driver, pickYourTrailHomePage.typeOfVacation);
		wrapperMethods.checkAndClick(driver, pickYourTrailHomePage.chooseCitiesYouVisit);
		wrapperMethods.checkAndClick(driver, pickYourTrailHomePage.citySelect);
		wrapperMethods.checkAndClick(driver, pickYourTrailHomePage.doneBuildItinerary);
		StatusReports.logStatus(isElementVisible(driver, pickYourTrailHomePage.getTripCost), "Verification of Get Trip Cost button", driver);
	}
	
	@Given("^I click on the Guides button on the navigation bar at the top And click on the destination image in the Guide page$")
	public void i_click_on_the_Guides_button_on_the_navigation_bar_at_the_top_And_click_on_the_destination_image_in_the_Guide_page() throws Throwable {
		wrapperMethods.checkAndClick(driver, pickYourTrailHomePage.guidesLink);
		wrapperMethods.switchTab(driver);
		StatusReports.logStatus(isElementVisible(driver, pickYourTrailHomePage.worldTravelGuidesLabel), "Verification of navigation to Guides page", driver);
		wrapperMethods.checkAndClick(driver, pickYourTrailHomePage.destinationImageGuideAus);
		StatusReports.logStatus(isElementVisible(driver, pickYourTrailHomePage.australiaGuidePageLabel), "Verification of navigation to Australia guide page", driver);		
	}

	@When("^I click on the Planning tab image in the header And navigate to the Planning setion$")
	public void i_click_on_the_Planning_tab_image_in_the_header_And_navigate_to_the_Planning_setion() throws Throwable {
		wrapperMethods.checkAndClick(driver, pickYourTrailHomePage.planningAus);
		StatusReports.logStatus(isElementVisible(driver, pickYourTrailHomePage.gettingThere), "Verification of Getting there tab in guide page", driver);
		StatusReports.logStatus(isElementVisible(driver, pickYourTrailHomePage.bestTimeToGo), "Verification of Best Time to Go tab in guide page", driver);
		
			    
	}

	@Then("^I must verify 'Best time to go'  And select 'Read more'$")
	public void i_must_verify_Best_time_to_go_And_select_Read_more() throws Throwable {
		wrapperMethods.checkAndClick(driver, pickYourTrailHomePage.bestTimeToGo);
		wrapperMethods.jsClick(driver, pickYourTrailHomePage.bestTimeToGoReadMore);
		StatusReports.logStatus(isElementVisible(driver, pickYourTrailHomePage.bestTimeToVisitPageLabel), "Verification of Best Time to visit details page label", driver);		
		wrapperMethods.switchToParentTab(driver);
		
	}



}
