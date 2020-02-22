package com.prac.sel.BrowserUtillities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ExtentReportManager {
	
	private static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	//public static ExtentXReporter extentx;
	public static String fileName = System.getProperty("user.dir");
	
	public static ExtentReports getInstance() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		if(extent==null) {
			return createInstance(fileName+"/TestAutomationReport"+".html");
	}else {
		return extent;
	}
		
	}
	public static ExtentReports createInstance(String fileName) {
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(fileName);
		extent.attachReporter(htmlReporter);		
		return extent;
	}
	
	
	
	
	
	
}
