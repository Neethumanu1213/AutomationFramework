package com.naveenautomation.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountCreatedPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.RegisterAccountPage;

public class AccountCreatedTest extends TestBase {
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		homePage = new HomePage(driver,true);
	}

	@Test
	public void verifyUserIsAbleToRegisterSuccesfully() {

		RegisterAccountPage registerAccountPage = homePage.clickRegisterLink();
		AccountCreatedPage accountCreatedPage = registerAccountPage.ClickContinueBtnForSignUp("Neethu", "Manu",
				"neethu130@gmail.com", "1234567890", "password@01", "password@01");
		Assert.assertEquals(accountCreatedPage.getAccountCreatedSuccessText(), "Your Account Has Been Created!",
				"Account is not created ");

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
