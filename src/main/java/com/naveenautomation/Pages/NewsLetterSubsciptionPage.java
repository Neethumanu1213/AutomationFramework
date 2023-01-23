package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class NewsLetterSubsciptionPage extends Page {

	

	public NewsLetterSubsciptionPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL="account/newsletter";
	
	public static  By yesRadioBtn=By.cssSelector("label.radio-inline:first-of-type>input");
	public static  By continueBtn=By.cssSelector("input[type='Submit']");
	

	public MyAccountPage updatingSubscription() {
		((ProxyDriver)wd).click(yesRadioBtn);
		((ProxyDriver)wd).submit(continueBtn);;
		return new MyAccountPage(wd,true);

	}
	
	@Override
	protected void isLoaded() {

		if(!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}
	
	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

}
