package com.prac.sel.BrowserUtillities;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class StatusReports {
	
	public static void logStatus (Boolean status, String description, WebDriver driver) {
		try {
			ExtentTestManager.createChildNode(Thread.currentThread().getStackTrace()[2].getMethodName());
			//description  = "Verification of "+description;
			if (status) {
				ExtentTestManager.getChildNode().log(Status.PASS, description);
			}
			else if(status == false) {
				ExtentTestManager.getChildNode().log(Status.FAIL, description);
			}
			else {
				ExtentTestManager.getChildNode().log(Status.FAIL, "Incorrect value received for status"+status);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void logException (Exception ex) {
		try {
			ExtentTestManager.createChildNode(Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentTestManager.getChildNode().fail(new Exception (ex));
	}
	
	

}
