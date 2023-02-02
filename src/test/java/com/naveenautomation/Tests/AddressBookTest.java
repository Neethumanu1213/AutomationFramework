package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.AddressBookPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.MyAccountPage;

public class AddressBookTest extends TestBase {
	HomePage homePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	SoftAssert sfAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		homePage = new HomePage(driver, true).get();
		accountLoginPage = homePage.clickLoginLink();
		myAccountPage = accountLoginPage.clickLoginBtnForLogin("neethu1234@gmail.com", "password@01");
	}

	@Test(enabled=false)
	public void verifyTheAddressIsDeleted() {

		AddressBookPage addressBookPage = myAccountPage.clickAddressBookLink().get();
		addressBookPage.clickContinueBtn("Ab765c", "Sankar", "Canada", "Ontario");
		System.out.println(addressBookPage.getEditSuccessBannerText());
		sfAssert.assertEquals(addressBookPage.getEditSuccessBannerText(), "Your address has been successfully updated",
				"Not able to edit");

		addressBookPage.clickDeleteAddressbook("N2c009");
		sfAssert.assertEquals(addressBookPage.getDeleteSuccessBannerText(),
				"Your address has been successfully deleted", "Address is not deleted");

		sfAssert.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
