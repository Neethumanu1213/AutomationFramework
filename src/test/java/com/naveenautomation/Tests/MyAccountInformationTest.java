package com.naveenautomation.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.MyAccountInformationPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Utils.ExcelUtils;

public class MyAccountInformationTest extends TestBase {

	HomePage homePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	SoftAssert sfAssert =new SoftAssert();

	@BeforeMethod
	public void setUp() {
		launchBrowser(); 
		homePage = new HomePage(driver,true).get();
		accountLoginPage = homePage.clickLoginLink();

	}

	@Ignore
	@Test(dataProvider = "LoginDataProvider")
	public void verifyUserInformationFieldsArePreFilled(String username, String password, String firstName,
			String lastName, String email1D, String telephone) {
		myAccountPage = accountLoginPage.clickLoginBtnForLogin(username, password).get();
		sfAssert.assertEquals(myAccountPage.getTitleOfThePage(), "My Account", "Title is not matching");

		MyAccountInformationPage myAccountInformationPage = myAccountPage.clickEditYourInformationLink().get();
		sfAssert.assertEquals(myAccountInformationPage.getAttributeValueOfFirstName(), firstName,
				"First name is not matching");
		sfAssert.assertEquals(myAccountInformationPage.getAttributeValueOfLastName(), lastName,
				"Last name  is not matching");
		sfAssert.assertEquals(myAccountInformationPage.getAttributValueOfEmailID(), email1D, "Email ID is not matching");
		sfAssert.assertEquals(myAccountInformationPage.getAttributeValueOfTelephone(), telephone,
				"Telephone is not matching");
		sfAssert.assertAll();

	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] provideLoginData() throws IOException {
		String filePath = "./Test Data\\LoginDetails.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
