package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomation.Browsers.ProxyDriver;

public class LaptopsAndNotebooksPage extends Page {

	public LaptopsAndNotebooksPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	WebDriverWait wait;

	private static final String PAGE_URL = "product/category&path=18";

	private static By laptopAndNoteBookText = By.cssSelector("div#content>h2");
	private static By sortByBtn = By.cssSelector("#input-sort");
	private static By sonyVAIOWishListBtn = By.cssSelector(
			"div.product-layout:nth-of-type(1) div.product-thumb:first-of-type>div:last-of-type>div>button:nth-of-type(2)");
	private static By macBookProWishListBtn = By.cssSelector(
			"div.product-layout:nth-of-type(2) div.product-thumb:first-of-type>div:last-of-type>div>button:nth-of-type(2)");
	private static By macBookAirWishListBtn = By.cssSelector(
			"div.product-layout:nth-of-type(3) div.product-thumb:first-of-type>div:last-of-type>div>button:nth-of-type(2)");
	private static By wishListSuccessBannerText = By.cssSelector("div.alert.alert-success.alert-dismissible");
	private static By wishListLink = By.cssSelector("#wishlist-total");

	public String getTitleOfThePage() {
		return ((ProxyDriver) wd).getTitle();
	}

	public String getLaptopAndNotebooksText() {
		return ((ProxyDriver) wd).getText(laptopAndNoteBookText, 10);
	}

	private void clickSortByBtn() {
		((ProxyDriver) wd).click(sortByBtn);

	}

	public void clickSonyVAIOWishlistBtn() {
		wd.navigate().refresh();
		((ProxyDriver) wd).click(sonyVAIOWishListBtn);

	}

	public void clickMacBookProWishlist() {
		((ProxyDriver) wd).navigate().refresh();
		// wd.navigate().refresh();

		((ProxyDriver) wd).click(macBookProWishListBtn);
	}

	public void clickMacBookAirWishlist() {
		((ProxyDriver) wd).navigate().refresh();
		((ProxyDriver) wd).click(macBookAirWishListBtn);

	}

	public String getWishListSuccessBannerText() {
		return ((ProxyDriver) wd).getText(wishListSuccessBannerText, 10);
	}

	public void selectTheRatingHighToLow(String text) {
		clickSortByBtn();
		((ProxyDriver) wd).selectFromDropDown(sortByBtn, text);

	}

	public MyWishListPage clickingWishListLink() {
		((ProxyDriver) wd).navigate().refresh();
		((ProxyDriver) wd).click(wishListLink);
		return new MyWishListPage(wd, true);

	}

	@Override
	protected void isLoaded() {

		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

	@Override
	public LaptopsAndNotebooksPage get() {
		return (LaptopsAndNotebooksPage) super.get();
	}
}
