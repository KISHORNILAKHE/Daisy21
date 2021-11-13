package com.testingshastra.config;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.util.PropertiesFile;

public class BaseClass {
	UIKeywords keyword = UIKeywords.getInstance();
	public RemoteWebDriver driver = null;

	@Parameters("browser-name")
	@BeforeMethod
	public void setup() {
		Application app = new Application();
		keyword.openBrowser("Chrome");
		this.driver = keyword.getDriver();
		driver.get(app.getAppUrl());

	}

	@AfterMethod 
	public void tearDown() {
		keyword.closeBrowser();
	}

}
