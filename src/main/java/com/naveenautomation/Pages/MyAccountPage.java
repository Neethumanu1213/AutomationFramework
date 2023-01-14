package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class MyAccountPage extends TestBase {

	Actions actions = new Actions(driver);

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountText;

	@FindBy(xpath = "//a[text()='Edit your account information']")
	WebElement editAccountInformationLink;

	@FindBy(css = "div.alert.alert-success")
	WebElement accountUpdatedSuccessBanner;

	@FindBy(css = "div#content>ul:last-of-type>li a")
	WebElement newsLetterUnsubscibtionLink;

	@FindBy(css = "div.alert.alert-success")
	WebElement newsLetterSubsciptionSuccessBanner;

	@FindBy(css = "#column-right>div>a:last-of-type")
	WebElement logOutBtn;

	@FindBy(xpath = "//a[text()='Laptops & Notebooks']")
	WebElement laptopsAndNotebookLink;

	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	WebElement showAllLaptopsAndNotebookLink;

	@FindBy(xpath = "//a[text()='Address Book']")
	WebElement addressBookLink;

	public void mouseeHoverToLaptopAndNotebooks() {
		actions.moveToElement(laptopsAndNotebookLink).perform();

	}

	public LaptopsAndNotebooksPage clickShowAllLaptopsAndNotebookLink() {
		mouseeHoverToLaptopAndNotebooks();
		showAllLaptopsAndNotebookLink.click();
		return new LaptopsAndNotebooksPage();

	}

	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public String getTitleOfThePage() {
		return driver.getTitle();

	}

	public MyAccountInformationPage clickEditYourInformationLink() {
		editAccountInformationLink.click();
		return new MyAccountInformationPage();

	}

	public String getAccountUpdatedSuccessText() {
		return accountUpdatedSuccessBanner.getText();
	}

	public NewsLetterSubsciptionPage subsciptionOfNewsletter() {
		newsLetterUnsubscibtionLink.click();
		return new NewsLetterSubsciptionPage();

	}

	public String getNewsLetterSubscriptionSuccessText() {
		return newsLetterSubsciptionSuccessBanner.getText();

	}

	public AccountLogOutPage logOut() {
		logOutBtn.click();
		return new AccountLogOutPage(); 
	}

	public AddressBookPage clickAddressBookLink() {
		addressBookLink.click();
		return new AddressBookPage();

	}

}
