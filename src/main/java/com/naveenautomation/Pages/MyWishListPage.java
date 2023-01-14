package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class MyWishListPage extends TestBase {

	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tbody>tr:last-of-type>td:last-of-type>a")
	WebElement deleteBtn;

	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement deleteSuccessBannerText;

	public String getTitleOfThePage() {
		return driver.getTitle();
	}

	public void clickDeleteBtn() {
		deleteBtn.click();
	}

	public String getDeleteSuccessBannerText() {
		return deleteSuccessBannerText.getText();

	}

	public WebElement getElementFromTheTable(String primaryKey, WishList column) {
		int columnIndex = getIndexOfColumn(column);

		List<WebElement> rowsInATable = driver
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
	
	public void deleteProductFromTheTable(String primaryKey, WishList column,By locator) {
		getElementFromTheTable(primaryKey, column).findElement(locator).click();
		
	}

	private int getIndexOfColumn(WishList column) {
		List<WebElement> headers = driver
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
		IMAGE("Image"), 
		PRODUCT_NAME("Product Name"), 
		MODEL("Model"), 
		STOCK("Stock"), 
		UNIT_PRICE("Unit Price"),
		ACTION("Action"); 

		String name;

		private WishList(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

}
