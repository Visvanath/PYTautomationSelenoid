package com.prac.sel.BrowserUtillities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	 DriverManager driverManager;	 
	 public  WebDriver driver;
	 ExtentReports extentReport;
	 ExtentTest extentTest;
	 public String environment = "remote";
	 private static HashMap<Long, WebDriver>  map = new HashMap<Long, WebDriver>(); 
	 
	 public WebDriver getDriver() {
		 WebDriver driver = map.get(Thread.currentThread().getId());
		 return driver;
	 }
	@Before("@Chrome")
	public WebDriver  setUpChrome(Scenario scenario) throws ClassNotFoundException, MalformedURLException {
		String featureName = scenario.getId().split(";")[0].toString();
		featureName = featureName.substring(0,1).toUpperCase()+featureName.substring(1);
		if(ExtentTestManager.getTest() == null) {
			ExtentTestManager.startTest(featureName);
		}
		ExtentTestManager.createNode(scenario.getName()+" | "+ scenario.getSourceTagNames());
		ExtentTestManager.getTest().log(Status.INFO,"Initiating thread in Thread ID:"+ Thread.currentThread().getId()+"Thread name:" + Thread.currentThread().getName());
		System.out.println("Opening the Chrome Browser");		
		if(environment.equalsIgnoreCase("local")){
		driverManager =  DriverManagerFatory.getWebdriverManager(DriverType.CHROME); 
       driver =  driverManager.getWebdriver();
		}
		else {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setVersion("80");
			capabilities.setCapability("enableVNC", true)	;
			capabilities.setCapability("name",scenario.getName());			
			RemoteWebDriver remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			driver = remoteDriver;
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(250,TimeUnit.SECONDS);
		}
		
       map.put(Thread.currentThread().getId(),driver);
       ExtentTestManager.getTest().log(Status.INFO,"Inside @Before");
       return driver;
	}
	@After
	public void tearDown() {
	WebDriver driver = map.get(Thread.currentThread().getId());
	driver.close();
	ExtentTestManager.getTest().log(Status.INFO,"Closing the thread : "+ Thread.currentThread().getId());
	ExtentReportManager.getInstance().flush();
	}
	

}
