package com.testingshastrasignuptests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.pages.HomePage;
import com.testingshastra.pages.JoinMeetingPage;
import com.testingshastra.util.WaitFor;

public class HomePageTests extends BaseClass {

	UIKeywords keyword = UIKeywords.getInstance();

	@Test
	public void verifyTitleOfHomePage() { 
		String expectedTitle = "IJmeet";
		Assert.assertEquals(keyword.driver.getTitle(), expectedTitle);
	}

	@Test
	public void verifyIfUserRedirectsToJoinMeetingPage() throws InterruptedException {
		HomePage home = new HomePage();//or // PageFactory.initElements(keyword.driver, HomePage); we have initialized it in constructor
		// in HomePage
		
		
		home.clickOnJoinMeetingTab();
		JoinMeetingPage joinMeeting = new JoinMeetingPage();
		WaitFor.elementToBeVisible(joinMeeting.quickJoinMeetingTitle, 10);
		String actual = joinMeeting.getQuickJoinMeetingTitle();
		Assert.assertTrue(actual.contains("Quick"));
	}

	@Test
	public void printAllInfoLinks() {

		HomePage home = new HomePage();
		home.getTextOfInfoLinks();
		System.out.println("this is just a git demo");
	}
	
	@Test
	public void clickOnNavBar() throws InterruptedException {// (public WebElement navbarContent; approach in HomePAge)
		HomePage home = new HomePage();
		home.rightClickOnNavBar();
		Thread.sleep(5000);
		
	}
}
