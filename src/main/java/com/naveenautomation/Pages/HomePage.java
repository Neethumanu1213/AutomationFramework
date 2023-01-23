package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class HomePage extends Page {

	public HomePage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "common/home";

	public static  By myAccountText = By.cssSelector("#top-links>ul>li:nth-of-type(2)>a");
	public static  By registerLink = By.xpath("//a[text()='Register']");
	public static  By loginLink = By.xpath("//a[text()='Login']");

	private void clickMyAccountText() {
		((ProxyDriver) wd).click(myAccountText);
	}

	public RegisterAccountPage clickRegisterLink() {
		clickMyAccountText();
		((ProxyDriver) wd).click(registerLink);
		return new RegisterAccountPage(wd, true);

	}

	public AccountLoginPage clickLoginLink() {
		clickMyAccountText();
		((ProxyDriver) wd).click(loginLink);
		return new AccountLoginPage(wd, true);

	}

	public String getTitleOfHomePage() {
		return ((ProxyDriver) wd).getTitle();

	}

	@Override
	protected void isLoaded() {

		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	public HomePage get() {
		// TODO Auto-generated method stub
		return (HomePage) super.get();
	}
}
