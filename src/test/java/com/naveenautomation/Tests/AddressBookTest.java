package com.naveenautomation.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.AddressBookPage;
import com.naveenautomation.Pages.EditAddressPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.MyAccountPage;

public class AddressBookTest extends TestBase {
	HomePage homePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		homePage = new HomePage();
		accountLoginPage = homePage.clickLoginLink();
		myAccountPage = accountLoginPage.clickLoginBtnForLogin("neethu123@gmail.com", "password@01");
	}

	@Test
	public void verifyTheAddressIsDeleted() {

		AddressBookPage addressBookPage = myAccountPage.clickAddressBookLink();
		EditAddressPage editAddressPage = addressBookPage.clickEditAddressbook("Ab765c");
		addressBookPage = editAddressPage.clickContinueBtn("Nibha", "Canada", "Ontario");
		System.out.println(addressBookPage.getEditSuccessBannerText());
		Assert.assertEquals(addressBookPage.getEditSuccessBannerText(), "Your address has been successfully updated",
				"Not able to edit");

		addressBookPage.clickDeleteAddressbook("N2x09v");
		Assert.assertEquals(addressBookPage.getDeleteSuccessBannerText(), "Your address has been successfully deleted",
				"Address is not deleted");

		editAddressPage = addressBookPage.clickEditAddressbook("C2C012");
		addressBookPage = editAddressPage.clickContinueBtn("Sankar", "Canada", "Ontario");
		System.out.println(addressBookPage.getEditSuccessBannerText());
		Assert.assertEquals(addressBookPage.getEditSuccessBannerText(), "Your address has been successfully updated",
				"Not able to edit");

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
