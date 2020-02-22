package com.prac.sel.BrowserUtillities;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;

public class ExtentTestManager {
	
	public static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	public static Map<Integer, ExtentTest> nodeExtentTestMap = new HashMap<Integer, ExtentTest>();
	public static Map<Integer, ExtentTest> childNodeExtentTestMap = new HashMap<Integer, ExtentTest>();
	public static ExtentReports extent = ExtentReportManager.getInstance();

	public static synchronized ExtentTest getTest() {
		return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void flush() {
		ExtentReportManager.getInstance().flush();
	}

	public static synchronized ExtentTest startTest(String testName) {
		return startTest(testName, "");
	}

	public static synchronized ExtentTest createNode(String testName) throws ClassNotFoundException {
		ExtentTest node = extentTestMap.get((int) (long) (Thread.currentThread().getId())).createNode(new GherkinKeyword("Scenario"), testName);
		nodeExtentTestMap.put((int) (long) (Thread.currentThread().getId()), node);
		return node;
	}

	public static synchronized ExtentTest createChildNode(String testName) throws ClassNotFoundException {
		ExtentTest childNode = nodeExtentTestMap.get((int) (long) (Thread.currentThread().getId()))	.createNode(new GherkinKeyword("Given"), testName);
		childNodeExtentTestMap.put((int) (long) (Thread.currentThread().getId()), childNode);
		return childNode;
	}

	public static synchronized ExtentTest getChildNode() {
		return childNodeExtentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized ExtentTest getNode() {
		return nodeExtentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}
	
	public static synchronized ExtentTest startTest (String testName , String desc) {
		ExtentTest test = extent.createTest(testName, desc);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}
	


}
