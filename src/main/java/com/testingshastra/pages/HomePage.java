package com.testingshastra.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.keywords.UIKeywords;

public class HomePage {

	UIKeywords keyword = UIKeywords.getInstance();
  //  @CacheLookup// 
	@FindBy(css = "div#navbarContent li:nth-child(1)") //or @FindBy(how=How.CSS, using="div#navbarContent li:nth-child(1)")
	public WebElement joinMeetingTab;

	public WebElement navbarContent;// it means it is finding with name or id like //*[@name='navBarContent'] OR //*[@id='navbarContent']
                                   // generally not be used reduces readability of code
	@FindBy(css = "div.footer-last-view-support div:nth-child(3) li a")
	public List<WebElement> infoLinks;

	public HomePage() {
		PageFactory.initElements(keyword.driver, this);
		
		// we have initialized  in HomePage Test class 
		// HomePage home = new HomePage ,     
		// in pageFactory we need to initialize  object like below
		// HomePage home = PageFactory.initElements(keyword.driver,HomePage);
		// the RHS of above we intialized  here in HomePage, in constructor ,, so we need to have written above constructor  

	}

	public void clickOnJoinMeetingTab() {
		joinMeetingTab.click();

	}

	public void getTextOfInfoLinks() {

		Iterator<WebElement> itr = infoLinks.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		

	}
	public void rightClickOnNavBar() {
		Actions act = new Actions(keyword.driver);
		act.contextClick(navbarContent).build().perform();

	}

}
