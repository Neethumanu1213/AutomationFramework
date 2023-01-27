package com.naveenautomation.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.HomePage;
import com.naveenautomation.Pages.LaptopsAndNotebooksPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.MyWishListPage;
import com.naveenautomation.Pages.MyWishListPage.WishList;

public class MyWishListTest extends TestBase {

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
	public void verifyTheItemIsRemoved() {

		LaptopsAndNotebooksPage laptopsAndNotebooksPage = myAccountPage.clickShowAllLaptopsAndNotebookLink();
		sfAssert.assertEquals(laptopsAndNotebooksPage.getTitleOfThePage(),
				laptopsAndNotebooksPage.getLaptopAndNotebooksText(), "Title is not Maching");
		laptopsAndNotebooksPage.selectTheRatingHighToLow("Rating (Highest)");

		laptopsAndNotebooksPage.clickSonyVAIOWishlistBtn();
		System.out.println(laptopsAndNotebooksPage.getWishListSuccessBannerText());
		sfAssert.assertEquals(laptopsAndNotebooksPage.getWishListSuccessBannerText(),
				"Success: You have added Sony VAIO to your wish list!\n×", "Item is not added to the wishList");
		laptopsAndNotebooksPage.clickMacBookProWishlist();
		System.out.println(laptopsAndNotebooksPage.getWishListSuccessBannerText());
		sfAssert.assertEquals(laptopsAndNotebooksPage.getWishListSuccessBannerText(),
				"Success: You have added MacBook Pro to your wish list!\n×", "Item is not added to the wishList");
		laptopsAndNotebooksPage.clickMacBookAirWishlist();
		System.out.println(laptopsAndNotebooksPage.getWishListSuccessBannerText());
		sfAssert.assertEquals(laptopsAndNotebooksPage.getWishListSuccessBannerText(),
				"Success: You have added MacBook Air to your wish list!\n×", "Item is not added to the wishList");

		MyWishListPage myWishListPage = laptopsAndNotebooksPage.clickingWishListLink();
		sfAssert.assertEquals(myWishListPage.getTitleOfThePage(), "My Wish List", "Title is not matching");

		WebElement macBookAirPrice = myWishListPage.getElementFromTheTable("MacBook Air", WishList.UNIT_PRICE);
		sfAssert.assertEquals(macBookAirPrice.getText(), "$1,202.00", "Not Matching price");
		WebElement macBookProPrice = myWishListPage.getElementFromTheTable("MacBook Pro", WishList.UNIT_PRICE);
		sfAssert.assertEquals(macBookProPrice.getText(), "$2,000.00", "Not Matching price");
		WebElement sonyVAIOPrice = myWishListPage.getElementFromTheTable("Sony VAIO", WishList.UNIT_PRICE);
		sfAssert.assertEquals(sonyVAIOPrice.getText(), "$1,202.00", "Not Matching price");

		myWishListPage.deleteProductFromTheTable("Sony VAIO", WishList.ACTION, By.cssSelector("a"));
		sfAssert.assertEquals(myWishListPage.getDeleteSuccessBannerText(),
				"Success: You have modified your wish list!\n×", "Cannot able to delete");
		sfAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
