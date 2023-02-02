package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLogOutPage;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.MyAccountPage;

public class AccountLogOutTest extends TestBase {

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

	@Test
	public void verifyTitleOfThePage() {
		AccountLogOutPage accountLogOutPage = myAccountPage.logOut().get();
		sfAssert.assertEquals(accountLogOutPage.getAccountLogOutText(), accountLogOutPage.getTitleOfAccountLogOutPage(),
				"Title is not matched");

		sfAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
