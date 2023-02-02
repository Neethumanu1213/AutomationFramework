package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.Browsers.ProxyDriver;

public class MyWishListPage extends Page {

	public MyWishListPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static final String PAGE_URL = "account/wishlist";
	private static By deleteBtn = By.cssSelector("tbody>tr:last-of-type>td:last-of-type>a");
	private static By deleteSuccessBannerText = By.cssSelector("div.alert.alert-success.alert-dismissible");

	public String getTitleOfThePage() {
		return ((ProxyDriver) wd).getTitle();
	}

	public void clickDeleteBtn() {
		((ProxyDriver) wd).click(deleteBtn);
	}

	public String getDeleteSuccessBannerText() {
		return ((ProxyDriver) wd).getText(deleteSuccessBannerText, 10);
	}

	public WebElement getElementFromTheTable(String primaryKey, WishList column) {
		int columnIndex = getIndexOfColumn(column);

		List<WebElement> rowsInATable = wd
				.findElements(By.cssSelector("table.table.table-bordered.table-hover tbody tr"));
		for (int i = 0; i < rowsInATable.size(); i++) {
			List<WebElement> cells = rowsInATable.get(i).findElements(By.cssSelector("td"));
			if (cells.get(1).getText().equals(primaryKey)) {
				return cells.get(columnIndex);
			}
		}
		System.out.println("Column not found ");
		return null;

	}

	public void deleteProductFromTheTable(String primaryKey, WishList column, By locator) {
		getElementFromTheTable(primaryKey, column).findElement(locator).click();

	}

	private int getIndexOfColumn(WishList column) {
		List<WebElement> headers = wd
				.findElements(By.cssSelector("table.table.table-bordered.table-hover thead tr td"));

		for (WebElement webElement : headers) {
			String headerText = webElement.getText();
			if (headerText.equals(column.getName())) {
				return headers.indexOf(webElement);
			}
		}
		return -1;
	}

	public enum WishList {
		IMAGE("Image"), PRODUCT_NAME("Product Name"), MODEL("Model"), STOCK("Stock"), UNIT_PRICE("Unit Price"),
		ACTION("Action");

		String name;

		private WishList(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

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
	public MyWishListPage get() {
		return (MyWishListPage) super.get();
	}

}
