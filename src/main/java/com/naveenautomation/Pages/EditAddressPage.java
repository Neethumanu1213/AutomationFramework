package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.Base.TestBase;

public class EditAddressPage extends TestBase {

	public EditAddressPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-lastname")
	WebElement lastNameInputField;

	@FindBy(id = "input-country")
	WebElement countryInputField;

	@FindBy(id = "input-zone")
	WebElement regionInputField;

	@FindBy(css = "input[type='Submit']")
	WebElement continueBtn;

	private void editLastNameField(String lName) {
		lastNameInputField.clear();
		lastNameInputField.sendKeys(lName);

	}

	private void enterCountryField(String country) {
		selectRatingByVisibleText(country, countryInputField);
	}

	private void enterRegionField(String region) {
		selectRatingByVisibleText(region, regionInputField);
		;
	}

	public AddressBookPage clickContinueBtn(String lName, String country, String region) {
		editLastNameField(lName);
		enterCountryField(country);
		enterRegionField(region);
		continueBtn.submit();
		return new AddressBookPage();
	}

	private void selectRatingByVisibleText(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
}
