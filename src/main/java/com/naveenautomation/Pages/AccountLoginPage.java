package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class AccountLoginPage extends Page {

	

	public AccountLoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL="account/login";
	
	private static  By emailInputField=By.id("input-email");
	private static  By passwordInputField=By.id("input-password");
	private static  By loginBtn=By.cssSelector("input[type='submit']");
	

	private void enterEmailIDForLogin(String email) {
		((ProxyDriver)wd).sendKeys(emailInputField, email);
	}

	private void enterPasswordForLogin(String password) {
		((ProxyDriver)wd).sendKeys(passwordInputField, password);
	}

	public MyAccountPage clickLoginBtnForLogin(String email, String password) {
		enterEmailIDForLogin(email);
		enterPasswordForLogin(password);
		((ProxyDriver)wd).submit(loginBtn);
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
	
	@Override
	public AccountLoginPage get() {
		return (AccountLoginPage) super.get();
	}
}
