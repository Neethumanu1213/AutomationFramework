package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomation.Base.TestBase;

public class LaptopsAndNotebooksPage extends TestBase {

	WebDriverWait wait;
	
	public LaptopsAndNotebooksPage() {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,10);
	}

	@FindBy(css = "div#content>h2")
	WebElement laptopAndNoteBookText;

	@FindBy(css = "#input-sort")
	WebElement sortByBtn;

	@FindBy(css = "div.product-layout:nth-of-type(1) div.product-thumb:first-of-type>div:last-of-type>div>button:nth-of-type(2)")
	WebElement sonyVAIOWishListBtn;

	@FindBy(css = "div.product-layout:nth-of-type(2) div.product-thumb:first-of-type>div:last-of-type>div>button:nth-of-type(2)")
	WebElement macBookProWishListBtn;

	@FindBy(css = "div.product-layout:nth-of-type(3) div.product-thumb:first-of-type>div:last-of-type>div>button:nth-of-type(2)")
	WebElement macBookAirWishListBtn;

	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement wishListSuccessBannerText;

	@FindBy(css = "#wishlist-total")
	WebElement wishListLink;

	public String getTitleOfThePage() {
		return driver.getTitle();
	}

	public String getLaptopAndNotebooksText() {
		return laptopAndNoteBookText.getText();
	}

	private void clickSortByBtn() {
		sortByBtn.click();
	}

	private void selectRatingByVisibleText(String text) {
		Select select = new Select(sortByBtn);
		select.selectByVisibleText(text);// Rating (Highest)
	}

	public void clickSonyVAIOWishlistBtn() {
		sonyVAIOWishListBtn.click();
	}

	public void clickMacBookProWishlist() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.product-layout:nth-of-type(2) div.product-thumb:first-of-type>div:last-of-type>div>button:nth-of-type(2")));
		macBookProWishListBtn.click();
	}

	public void clickMacBookAirWishlist() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.product-layout:nth-of-type(3) div.product-thumb:first-of-type>div:last-of-type>div>button:nth-of-type(2")));
		macBookAirWishListBtn.click();
		
	}

	public String getWishListSuccessBannerText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success.alert-dismissible")));
		return wishListSuccessBannerText.getText();
	}

	public void selectTheRatingHighToLow(String text) {
		clickSortByBtn();
		selectRatingByVisibleText(text);
	}

	public MyWishListPage clickingWishListLink() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#wishlist-total")));
		wishListLink.click();
		return new MyWishListPage();

	}
}
