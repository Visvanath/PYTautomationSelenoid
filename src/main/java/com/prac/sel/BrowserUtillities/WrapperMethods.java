package com.prac.sel.BrowserUtillities;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.owasp.html.examples.EbayPolicyExample;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WrapperMethods {

	public WebDriver driver;
	public ExtentReports extent;
	public static ExtentTest scenarioDef;
	public static ExtentTest features;
	static String workingDir = System.getProperty("user.dir");
	public static String reportLocation = workingDir;// +"/ExtentReportResults.html";

	public void checkAndClick(WebDriver driver, WebElement element) throws ClassNotFoundException {
		try {
			ExpectedConditions.elementToBeClickable(element);
			ExpectedConditions.stalenessOf(element);
			element.click();
		} catch (Exception ex) {
			// simply retry finding the element in the refreshed DOM
			StatusReports.logException(ex);

		}
	}
	
	public void jsClick(WebDriver driver, WebElement element) {
		((JavascriptExecutor )driver).executeScript("arguments[0].click();", element);
	}

	public void checkAndType(WebDriver driver, WebElement element, String text) {
		try {
			//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
			ExpectedConditions.elementToBeClickable(element);
			if (element.isEnabled()) {
				element.sendKeys(text);
			}

		} catch (StaleElementReferenceException sere) {
			element.click();
		}
	}
	
	public boolean isElementVisible(WebDriver driver , WebElement element) {
		boolean visibleFlag;
		try {
		ExpectedConditions.visibilityOf(element);
		visibleFlag = element.isDisplayed();
		if(!visibleFlag) {
			visibleFlag = element.isEnabled();
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			StatusReports.logException(ex);
			visibleFlag = false;
		}		
		return visibleFlag;		
	}
	
	public void switchTab(WebDriver driver) {
		try {
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles) {
			if(!(handle.equals(parentWindowHandle))){
				driver.switchTo().window(handle);
				break;
			}
		}
		}
			catch(Exception ex)  {
				ex.printStackTrace();				
			}
			}
	public void switchToParentTab(WebDriver driver) {
		try {
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles) {
			if(!(handle.equals(currentWindowHandle))){
				driver.close();
				driver.switchTo().window(handle);
				break;
			}
		}
		}
			catch(Exception ex)  {
				ex.printStackTrace();				
			}
			}
	
	public void closeCurrentTab(WebDriver driver) {
		try {
			driver.close();		
		}
			catch(Exception ex)  {
				ex.printStackTrace();				
			}
			}
			
		
		
	}


