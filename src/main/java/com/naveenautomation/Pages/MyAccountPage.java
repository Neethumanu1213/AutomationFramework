package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyAccountPage extends Page {

	public MyAccountPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		// TODO Auto-generated constructor stub
	}

	Actions actions = new Actions(wd);
	private static final String PAGE_URL = "account/account";

	private static By myAccountText = By.xpath("//h2[text()='My Account']");
	private static By editAccountInformationLink = By.xpath("//a[text()='Edit your account information']");
	private static By accountUpdatedSuccessBanner = By.cssSelector("div.alert.alert-success");
	private static By newsLetterUnsubscibtionLink = By.cssSelector("div#content>ul:last-of-type>li a");;
	private static By newsLetterSubsciptionSuccessBanner = By.cssSelector("div.alert.alert-success");;
	private static By logOutBtn = By.cssSelector("#column-right>div>a:last-of-type");
	private static By laptopsAndNotebookLink = By.xpath("//a[text()='Laptops & Notebooks']");
	private static By showAllLaptopsAndNotebookLink = By.xpath("//a[text()='Show All Laptops & Notebooks']");
	private static By addressBookLink = By.xpath("//a[text()='Address Book']");

	public void mouseeHoverToLaptopAndNotebooks() {
		((ProxyDriver) wd).mouseHoverAction(wd.findElement(laptopsAndNotebookLink));

	}

	public LaptopsAndNotebooksPage clickShowAllLaptopsAndNotebookLink() {
		mouseeHoverToLaptopAndNotebooks();
		((ProxyDriver) wd).click(showAllLaptopsAndNotebookLink);
		return new LaptopsAndNotebooksPage(wd, true);

	}

	public String getMyAccountText() {
		return ((ProxyDriver) wd).getText(myAccountText, 10);
	}

	public String getTitleOfThePage() {
		return ((ProxyDriver) wd).getTitle();
	}

	public MyAccountInformationPage clickEditYourInformationLink() {
		((ProxyDriver) wd).click(editAccountInformationLink);
		return new MyAccountInformationPage(wd, true);

	}

	public String getAccountUpdatedSuccessText() {
		return ((ProxyDriver) wd).getText(accountUpdatedSuccessBanner, 10);
	}

	public NewsLetterSubsciptionPage subsciptionOfNewsletter() {
		((ProxyDriver) wd).click(newsLetterUnsubscibtionLink);
		return new NewsLetterSubsciptionPage(wd, true);

	}

	public String getNewsLetterSubscriptionSuccessText() {
		return ((ProxyDriver) wd).getText(newsLetterSubsciptionSuccessBanner, 10);
	}

	public AccountLogOutPage logOut() {
		((ProxyDriver) wd).click(logOutBtn);
		return new AccountLogOutPage(wd, true);
	}

	public AddressBookPage clickAddressBookLink() {
		((ProxyDriver) wd).click(addressBookLink);
		return new AddressBookPage(wd, true);

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
	public MyAccountPage get() {
		return (MyAccountPage) super.get();
	}
}
