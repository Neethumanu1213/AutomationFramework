package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class HomePage extends TestBase {

	Actions actions = new Actions(driver);

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAccountText;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerLink;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginLink;

	private void clickMyAccountText() {
		myAccountText.click();
	}

	public RegisterAccountPage clickRegisterLink() {
		clickMyAccountText();
		registerLink.click();
		return new RegisterAccountPage();

	}

	public AccountLoginPage clickLoginLink() {
		clickMyAccountText();
		loginLink.click();
		return new AccountLoginPage();

	}

	public String getTitleOfHomePage() {
		return driver.getTitle();

	}

}
