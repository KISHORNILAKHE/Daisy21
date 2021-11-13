package com.testingshastra.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.keywords.UIKeywords;

public class SignUpPage {

	UIKeywords keyword = UIKeywords.getInstance();
	  
		@FindBy(css = "div#navbarContent li:nth-child(1)")
		public WebElement joinMeetingTab;

		

		public SignUpPage() {
			PageFactory.initElements(keyword.driver, this);

		}

		public void clickOnJoinMeetingTab() {
			joinMeetingTab.click();

		}

		
			

	

		

	}


