package com.naveenautomation.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		homePage = new HomePage(driver, true).get();
		accountLoginPage = homePage.clickLoginLink();
		myAccountPage = accountLoginPage.clickLoginBtnForLogin("neethu123@gmail.com", "password@01");
	}

	@Test
	public void verifyUserIsAbleToLoginSuccesfully() {
		Assert.assertEquals(myAccountPage.getMyAccountText(), "My Account", "Login failed");
	}
	

	@Test
	public void verifySuccessBannerForPhoneNumberUpdate() {
		MyAccountInformationPage myAccountInformationPage = myAccountPage.clickEditYourInformationLink();
		myAccountInformationPage.clickContinueAfterUpdatingPhoneNumber("9876543210");
		Assert.assertEquals(myAccountPage.getAccountUpdatedSuccessText(),
				"Success: Your account has been successfully updated.", "Phone number is not updated");

	}

	@Test
	public void verifySuccessBannerForNewsLetterSusciption() {
		NewsLetterSubsciptionPage newsLetterSubsciptionPage = myAccountPage.subsciptionOfNewsletter();
		newsLetterSubsciptionPage.updatingSubscription();
		Assert.assertEquals(myAccountPage.getAccountUpdatedSuccessText(),
				"Success: Your newsletter subscription has been successfully updated!", "Subscription is not updated");

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
