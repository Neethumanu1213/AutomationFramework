package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class RegisterAccountPage extends Page {

	public RegisterAccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final String PAGE_URL = "account/register";

	private static By firstNameInputField = By.cssSelector("#input-firstname");
	private static By lastNameInputField = By.cssSelector("#input-lastname");
	private static By emailInputField = By.cssSelector("#input-email");
	private static By telePhoneInputField = By.cssSelector("#input-telephone");
	private static By passwordInputField = By.cssSelector("#input-password");
	private static By confirmPasswordInputField = By.cssSelector("#input-confirm");
	private static By privacyPolicyCheckBox = By.cssSelector("input[type='checkbox']");
	private static By continueBtn = By.cssSelector("input[type='checkbox']");

	private void enterFirstName(String firstName) {
		((ProxyDriver) wd).sendKeys(firstNameInputField, firstName);

	}

	private void enterLastName(String LastName) {
		((ProxyDriver) wd).sendKeys(lastNameInputField, LastName);

	}

	private void enterEmail(String emailID) {
		((ProxyDriver) wd).sendKeys(emailInputField, emailID);

	}

	private void enterTelephone(String phoneNumber) {
		((ProxyDriver) wd).sendKeys(telePhoneInputField, phoneNumber);
	}

	private void enterPassword(String password) {
		((ProxyDriver) wd).sendKeys(passwordInputField, password);
	}

	private void enterConfirmPassword(String confirmPassword) {
		((ProxyDriver) wd).sendKeys(confirmPasswordInputField, confirmPassword);
	}

	private void clickPrivacyPolicyCheckBox() {
		((ProxyDriver) wd).click(privacyPolicyCheckBox);
	}

	public AccountCreatedPage ClickContinueBtnForSignUp(String firstName, String lastName, String emailID,
			String phoneNumber, String password, String confirmPassword) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(emailID);
		enterTelephone(phoneNumber);
		enterPassword(confirmPassword);
		enterConfirmPassword(confirmPassword);
		clickPrivacyPolicyCheckBox();
		((ProxyDriver) wd).submit(continueBtn);
		return new AccountCreatedPage(wd, true);

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
	public RegisterAccountPage get() {
		return (RegisterAccountPage) super.get();
	}

}
