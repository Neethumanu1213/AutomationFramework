package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.MyAccountInformationPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.NewsLetterSubsciptionPage;

public class MyAccountTest extends TestBase {

	HomePage homePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	SoftAssert sfAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		homePage = new HomePage(driver, true).get();
		accountLoginPage = homePage.clickLoginLink();
		myAccountPage = accountLoginPage.clickLoginBtnForLogin("neethu123@gmail.com", "password@01");
	}

	@Test
	public void verifyUserIsAbleToLoginSuccesfully() {
		sfAssert.assertEquals(myAccountPage.getMyAccountText(), "My Account", "Login failed");
		sfAssert.assertAll();
	}

	@Test
	public void verifySuccessBannerForPhoneNumberUpdate() {
		MyAccountInformationPage myAccountInformationPage = myAccountPage.clickEditYourInformationLink();
		myAccountInformationPage.clickContinueAfterUpdatingPhoneNumber("9876543210");
		sfAssert.assertEquals(myAccountPage.getAccountUpdatedSuccessText(),
				"Success: Your account has been successfully updated.", "Phone number is not updated");

		sfAssert.assertAll();
	}

	@Test
	public void verifySuccessBannerForNewsLetterSusciption() {
		NewsLetterSubsciptionPage newsLetterSubsciptionPage = myAccountPage.subsciptionOfNewsletter();
		newsLetterSubsciptionPage.updatingSubscription();
		sfAssert.assertEquals(myAccountPage.getAccountUpdatedSuccessText(),
				"Success: Your newsletter subscription has been successfully updated!", "Subscription is not updated");
		sfAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
