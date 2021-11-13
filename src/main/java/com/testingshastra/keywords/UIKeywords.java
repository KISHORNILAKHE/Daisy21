package com.testingshastra.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeywords {

	public RemoteWebDriver driver = null;
	private static UIKeywords uikeywords;
	static {
		uikeywords = new UIKeywords();
	}

	public static UIKeywords getInstance() {
		return uikeywords;

	}

	private UIKeywords() {

	}

	/**
	 * This keyword is used to launch specified browser.
	 * 
	 * @author Shree
	 * @param browserName must be one of the following
	 *                    <ul>
	 *                    <li>chrome</li>
	 *                    <li>firefox</li>
	 *                    <li>ie</li>
	 *                    </ul>
	 */
     
	
	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Invalid browser name" + browserName);
		}
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void click(WebElement element) {
		element.click();
	}

	public void enterText(WebElement element, String textToEnter) {
		element.sendKeys(textToEnter);
	}
	/**
	 * In next version of framework , this method will be deleted . Instead you can enterText(String object,String textToEnter
	 * @param LocatorType
	 * @param LocatorValue
	 * @param textToEnter
	 */
   // @Deprecated
	public void enterText(String LocatorType, String LocatorValue, String textToEnter) {
		getWebElement(LocatorType, LocatorValue).sendKeys(textToEnter);

	}

	public WebElement getWebElement(String LocatorType, String LocatorValue) {
		WebElement element = null;
		if (LocatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(LocatorValue));
		}
		if (LocatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(LocatorValue));
		}
		if (LocatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(LocatorValue));
		}
		if (LocatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(LocatorValue));
		}
		if (LocatorType.equalsIgnoreCase("tag")) {
			element = driver.findElement(By.tagName(LocatorValue));
		}

		return element;
	}

	public void switchToFrameAt(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(String idorName) {
		driver.switchTo().frame(idorName);
	}

	public void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);

	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();

	}

	public String getTitleOfPage() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	public RemoteWebDriver getDriver() {
		return driver;
	}

	public void click(String LocatorType, String LocatorValue) {
		getWebElement(LocatorType, LocatorValue).click();

	}

	public void enterText(String object, String textToEnter) {
         String[] parts = object.split("##");
         getWebElement(parts[0],parts[1]).sendKeys(textToEnter);
         
	}

	

}
