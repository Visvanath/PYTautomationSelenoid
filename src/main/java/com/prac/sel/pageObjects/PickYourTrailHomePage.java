package com.prac.sel.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PickYourTrailHomePage {
	
private WebDriver driver;

    @FindBy(how=How.XPATH,using="//img[contains(@alt,'PickYourTrail')]")
	 public  WebElement pickYourTrailLogo;
	 
	 @FindBy(how=How.XPATH,using="//button[contains(text(),'Start Planning')]")
	 public  WebElement creteItinerary;
	 
	 @FindBy(how=How.XPATH,using="//input[@id='landing-search-input']")
	 public  WebElement searchCityTextBox;
	 
	 @FindBy(how=How.XPATH,using="//div[contains(@class,'search-suggestions')]")
	 public  WebElement searchCitySuggestions;	 
	 
	 @FindBy(how=How.XPATH,using="//div[contains(@class,'search-suggestions')]//div[contains(text(),'Australia')]")
	 public  WebElement listedOption;	 
	 
	 @FindBy(how=How.XPATH,using="(//span[contains(text(),'OUR PICK')])[1]")
	 public  WebElement selectTravelMonth;	 
	 
	 @FindBy(how=How.XPATH,using="(//div[contains(@class,'totalhmdays')]//input/parent::div)[1]")
	 public  WebElement selectDuration;	
	 
	 @FindBy(how=How.XPATH,using="//*[contains(text(),'What do you like to see and do?')]")
	 public  WebElement vacationType;	 
	 
	 @FindBy(how=How.XPATH,using="(//div[contains(@class,'seeanddo')]//input/parent::div)[1]")
	 public  WebElement typeOfVacation;
	 
	 @FindBy(how=How.XPATH,using="//a[contains(text(),'Choose cities')]")
	 public  WebElement chooseCitiesYouVisit;
	 
	 @FindBy(how=How.XPATH,using="(//section[contains(@class,'clearfix city-card')])[1]")
	 public  WebElement citySelect;
	 
	 @FindBy(how=How.XPATH,using="//span[contains(text(),'Done! Build itinerary')]")
	 public  WebElement doneBuildItinerary;
	 
	 @FindBy(how=How.XPATH,using="//section[contains(@class,'itin-title-bar')]//button[contains(text(),'Get trip cost')]")
	 public  WebElement getTripCost;
	 
	 @FindBy(how=How.XPATH,using="//ul//a[contains(text(),'Guides')][contains(@class,'header-guides')]")
	 public  WebElement guidesLink;
	 
	 @FindBy(how=How.XPATH,using="//h1[contains(text(),'World Travel Guides')]")
	 public  WebElement worldTravelGuidesLabel;	 
	 
	 @FindBy(how=How.XPATH,using="//*[contains(text(),'Australia')]/ancestor::div[contains(@class,'landing-cards')]/parent::a")
	 public  WebElement destinationImageGuideAus;
	 
	 @FindBy(how=How.XPATH,using="//h1[@title='Australia Travel Guide']//span[contains(text(),'Australia')]")
	 public  WebElement australiaGuidePageLabel;
	 
	 @FindBy(how=How.XPATH,using="//a[contains(@class,'item planning')]")
	 public  WebElement planningAus;
	 
	 @FindBy(how=How.XPATH,using="//a[contains(text(),'Getting there')]")
	 public  WebElement gettingThere;
	 
	 @FindBy(how=How.XPATH,using="//a[contains(text(),'Best time to go')]")
	 public  WebElement bestTimeToGo;
	 
	 @FindBy(how=How.XPATH,using="//a[contains(text(),'Visa requirements')]")
	 public  WebElement visaReq;
	 
	 @FindBy(how=How.XPATH,using="//a[contains(text(),'Read more')][contains(@href,'best-time-to-visit')]")
	 public  WebElement bestTimeToGoReadMore;
	 
	 @FindBy(how=How.XPATH,using="//h2[contains(text(),'Best time to visit ')]")
	 public  WebElement bestTimeToVisitPageLabel;
	 
	 
	 
	 
	 
	 
	 
	 @FindBy(how=How.XPATH,using="//a[contains(text(),'Testimonials')]")
	 public  WebElement testimonialsLink;
	 
	 
	 
	
	 
	 	
	 
	 public PickYourTrailHomePage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	 }



}
