package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class RegisterAccountPage extends TestBase {

	public RegisterAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-firstname")
	WebElement firstNameInputField;

	@FindBy(css = "#input-lastname")
	WebElement lastNameInputField;

	@FindBy(css = "#input-email")
	WebElement emailInputField;

	@FindBy(css = "#input-telephone")
	WebElement telePhoneInputField;

	@FindBy(css = "#input-password")
	WebElement passwordInputField;

	@FindBy(css = "#input-confirm")
	WebElement confirmPasswordInputField;

	@FindBy(css = "input[type='checkbox']")
	WebElement privacyPolicyCheckBox;

	@FindBy(css = "input[type='submit']")
	WebElement continueBtn;

	private void enterFirstName(String firstName) {
		firstNameInputField.sendKeys(firstName);

	}

	private void enterLastName(String LastName) {
		lastNameInputField.sendKeys(LastName);

	}

	private void enterEmail(String emailID) {
		emailInputField.sendKeys(emailID);

	}

	private void enterTelephone(String phoneNumber) {
		telePhoneInputField.sendKeys(phoneNumber);
	}

	private void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}

	private void enterConfirmPassword(String confirmPassword) {
		confirmPasswordInputField.sendKeys(confirmPassword);
	}

	private void clickPrivacyPolicyCheckBox() {
		privacyPolicyCheckBox.click();
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
		continueBtn.submit();
		return new AccountCreatedPage();

	}

}
