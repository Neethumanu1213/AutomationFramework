package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class AccountLogOutPage extends Page {

	public AccountLogOutPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final String PAGE_URL = "account/logout";

	private static By accountLogOutText = By.cssSelector("#content>h1");
	private static By continueBtn = By.xpath("//a[text()='Continue']");

	public String getAccountLogOutText() {
		return ((ProxyDriver) wd).getText(accountLogOutText, 10);

	}

	public String getTitleOfAccountLogOutPage() {
		return ((ProxyDriver) wd).getTitle();

	}

	public HomePage logOut() {
		((ProxyDriver) wd).click(continueBtn);
		return new HomePage(wd, true);
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
	public AccountLogOutPage get() {
		return (AccountLogOutPage) super.get();
	}
}
