package com.prac.sel.BrowserUtillities;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager  extends DriverManager{

	@Override
	protected void createWebdriver() {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		this.driver = new ChromeDriver(options);
		
		
	}

}
