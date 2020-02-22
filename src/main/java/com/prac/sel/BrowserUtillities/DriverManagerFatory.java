package com.prac.sel.BrowserUtillities;

public class DriverManagerFatory {
	
	public static  DriverManager getWebdriverManager(DriverType type) {
		DriverManager driverManager;
		
		switch(type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;		
			
			default:
				driverManager = new ChromeDriverManager();
		}
		
		return driverManager;
		
	}

}
