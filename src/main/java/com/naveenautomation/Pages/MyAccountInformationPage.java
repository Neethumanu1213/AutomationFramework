package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyAccountInformationPage extends Page {

	

	public MyAccountInformationPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}
	
	private static final String PAGE_URL="account/edit";

	public static  By firstNameInputField = By.id("input-firstname");
	public static  By lastNameInputField = By.id("input-lastname");
	public static  By emailInputField = By.id("input-email");
	public static  By telephoneInputField = By.id("input-telephone");
	public static  By continueBtn = By.cssSelector("input[type='Submit']");
	

	private void changingPhoneNumber(String phoneNum) {
		((ProxyDriver)wd).clear(telephoneInputField);
		((ProxyDriver)wd).sendKeys(telephoneInputField, phoneNum);;
	}

	public MyAccountPage clickContinueAfterUpdatingPhoneNumber(String phoneNum) {
		changingPhoneNumber(phoneNum);
		((ProxyDriver)wd).submit(continueBtn);
		return new MyAccountPage(wd,true);
	} 

	public String getAttributeValueOfFirstName() {
	return	((ProxyDriver)wd).getAttributeValue(firstNameInputField);
		//return firstNameInputField.getAttribute("value");
	}
	public String getAttributeValueOfLastName() {
		return	((ProxyDriver)wd).getAttributeValue(lastNameInputField);
		//return lastNameInputField.getAttribute("value");
	}
	public String getAttributValueOfEmailID() {
		return	((ProxyDriver)wd).getAttributeValue(emailInputField);
		//return emailInputField.getAttribute("value");
	}
	public String getAttributeValueOfTelephone() {
		return	((ProxyDriver)wd).getAttributeValue(telephoneInputField);
		//return telephoneInputField.getAttribute("value");
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
