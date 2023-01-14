package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class MyAccountInformationPage extends TestBase {

	public MyAccountInformationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstNameInputField;
	
	@FindBy(id = "input-lastname")
	WebElement lastNameInputField;
	
	@FindBy(id = "input-email")
	WebElement emailInputField;
	
	@FindBy(id = "input-telephone")
	WebElement telephoneInputField;

	@FindBy(css = "input[type='Submit']")
	WebElement continueBtn;

	private void changingPhoneNumber(String phoneNum) {
		telephoneInputField.clear();
		telephoneInputField.sendKeys(phoneNum);
	}

	public MyAccountPage clickContinueAfterUpdatingPhoneNumber(String phoneNum) {
		changingPhoneNumber(phoneNum);
		continueBtn.submit();
		return new MyAccountPage();
	}

	public String getAttributeValueOfFirstName() {
		return firstNameInputField.getAttribute("value");
	}
	public String getAttributeValueOfLastName() {
		return lastNameInputField.getAttribute("value");
	}
	public String getAttributValueOfEmailID() {
		return emailInputField.getAttribute("value");
	}
	public String getAttributeValueOfTelephone() {
		return telephoneInputField.getAttribute("value");
	}
}
