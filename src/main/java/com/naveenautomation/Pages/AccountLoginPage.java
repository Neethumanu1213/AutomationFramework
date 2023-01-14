package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	WebElement emailInputField;

	@FindBy(id = "input-password")
	WebElement passwordInputField;

	@FindBy(css = "input[type='submit']")
	WebElement loginBtn;

	private void enterEmailIDForLogin(String email) {
		emailInputField.sendKeys(email);
	}

	private void enterPasswordForLogin(String password) {
		passwordInputField.sendKeys(password);
	}

	public MyAccountPage clickLoginBtnForLogin(String email, String password) {
		enterEmailIDForLogin(email);
		enterPasswordForLogin(password);
		loginBtn.submit();
		return new MyAccountPage();
	}

}
