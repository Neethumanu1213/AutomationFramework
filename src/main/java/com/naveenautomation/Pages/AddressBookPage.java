package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.Browsers.ProxyDriver;

public class AddressBookPage extends Page {

	public AddressBookPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private static final String PAGE_URL = "account/address";

	private static By lastNameInputField = By.id("input-lastname");
	private static By countryInputField = By.id("input-country");
	private static By regionInputField = By.id("input-zone");
	private static By continueBtn = By.cssSelector("input[type='Submit']");
	private static By editSuccessBannerText = By.cssSelector("div.alert.alert-success.alert-dismissible");
	private static By deleteSuccessBannerText = By.cssSelector("div.alert.alert-success.alert-dismissible");

	private void editLastNameField(String lName) {
		((ProxyDriver) wd).clear(lastNameInputField);
		((ProxyDriver) wd).sendKeys(lastNameInputField, lName);
	}

	private void enterCountryField(String country) {
		((ProxyDriver) wd).selectFromDropDown(countryInputField, country);

	}

	private void enterRegionField(String region) {
		((ProxyDriver) wd).selectFromDropDown(regionInputField, region);

	}

	private WebElement getElemntFromTable(String primaryKey) {
		List<WebElement> rowsInTable = wd
				.findElements(By.cssSelector("table.table.table-bordered.table-hover tbody tr"));
		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));

			String[] addressArray = cells.get(0).getText().split(" |\n");
			for (int j = 0; j < addressArray.length; j++) {
				if (addressArray[j].equalsIgnoreCase(primaryKey)) {
					return cells.get(1);
				}
			}
		}
		System.out.println("Postal code is not present");
		return null;
	}

	public String getEditSuccessBannerText() {
		return ((ProxyDriver) wd).getText(editSuccessBannerText, 10);
	}

	public String getDeleteSuccessBannerText() {
		return ((ProxyDriver) wd).getText(deleteSuccessBannerText, 10);
	}

	private void clickEditBtn(String primaryKey) {
		WebElement editElementinCell = getElemntFromTable(primaryKey);
		editElementinCell.findElement(By.cssSelector("a:first-of-type")).click();

	}

	public void clickContinueBtn(String primaryKey, String lName, String country, String region) {
		clickEditBtn(primaryKey);
		editLastNameField(lName);
		enterCountryField(country);
		enterRegionField(region);
		((ProxyDriver) wd).submit(continueBtn);
	}

	public void clickDeleteAddressbook(String primaryKey) {
		WebElement editElementinCell = getElemntFromTable(primaryKey);
		WebElement delete = editElementinCell.findElement(By.cssSelector("a:last-of-type"));
		delete.click();
		((ProxyDriver) wd).switchTo();
		((ProxyDriver) wd).acceptAlert();
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
	public AddressBookPage get() {
		return (AddressBookPage) super.get();
	}
}
