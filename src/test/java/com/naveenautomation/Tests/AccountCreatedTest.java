package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountCreatedPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.RegisterAccountPage;
import com.naveenautomation.Utils.Utils;

public class AccountCreatedTest extends TestBase {
	HomePage homePage;
	SoftAssert sfAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		homePage = new HomePage(driver, true);
	}

	@Test
	@Ignore
	public void verifyUserIsAbleToRegisterSuccesfully() {

		RegisterAccountPage registerAccountPage = homePage.clickRegisterLink();
		AccountCreatedPage accountCreatedPage = registerAccountPage.ClickContinueBtnForSignUp("Neethu", "Manu",
				Utils.getRandomEmail(), "1234567890", "password@01", "password@01");
		sfAssert.assertEquals(accountCreatedPage.getAccountCreatedSuccessText(), "Your Account Has Been Created!",
				"Account is not created ");
		sfAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
