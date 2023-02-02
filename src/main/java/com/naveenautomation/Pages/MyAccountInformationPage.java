package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyAccountInformationPage extends Page {

	public MyAccountInformationPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "account/edit";

	private static By firstNameInputField = By.id("input-firstname");
	private static By lastNameInputField = By.id("input-lastname");
	private static By emailInputField = By.id("input-email");
	private static By telephoneInputField = By.id("input-telephone");
	private static By continueBtn = By.cssSelector("input[type='Submit']");

	private void changingPhoneNumber(String phoneNum) {
		((ProxyDriver) wd).clear(telephoneInputField);
		((ProxyDriver) wd).sendKeys(telephoneInputField, phoneNum);
		;
	}

	public MyAccountPage clickContinueAfterUpdatingPhoneNumber(String phoneNum) {
		changingPhoneNumber(phoneNum);
		((ProxyDriver) wd).submit(continueBtn);
		return new MyAccountPage(wd, true);
	}

	public String getAttributeValueOfFirstName() {
		return ((ProxyDriver) wd).getAttributeValue(firstNameInputField);

	}

	public String getAttributeValueOfLastName() {
		return ((ProxyDriver) wd).getAttributeValue(lastNameInputField);

	}

	public String getAttributValueOfEmailID() {
		return ((ProxyDriver) wd).getAttributeValue(emailInputField);

	}

	public String getAttributeValueOfTelephone() {
		return ((ProxyDriver) wd).getAttributeValue(telephoneInputField);

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
	public MyAccountInformationPage get() {
		return (MyAccountInformationPage) super.get();
	}
}
