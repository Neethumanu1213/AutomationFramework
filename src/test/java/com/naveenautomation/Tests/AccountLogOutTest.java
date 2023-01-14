package com.naveenautomation.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLogOutPage;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.MyAccountPage;

public class AccountLogOutTest extends TestBase {

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
	public void verifyTitleOfThePage() {
		AccountLogOutPage accountLogOutPage = myAccountPage.logOut();
		Assert.assertEquals(accountLogOutPage.getAccountLogOutText(), accountLogOutPage.getTitleOfAccountLogOutPage(),
				"Title is not matched");

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
