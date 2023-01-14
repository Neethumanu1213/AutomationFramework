package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomation.Base.TestBase;

public class AddressBookPage extends TestBase {

	WebDriverWait wait= new WebDriverWait(driver, 20);
	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement editSuccessBannerText;
	
	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement deleteSuccessBannerText;
	
	private WebElement getElemntFromTable(String primaryKey) {
		
		List<WebElement> rowsInATable=driver.findElements(By.cssSelector("table.table.table-bordered.table-hover tbody tr"));
		for(int i=0;i<rowsInATable.size();i++) {
			List<WebElement> cells=rowsInATable.get(i).findElements(By.cssSelector("td"));
			String[] address=cells.get(0).getText().split("\n");
			for(int j=0;j<address.length;j++) {
				String[] addressAfterSplit=address[j].split(" ");
				for(int k=0;k<addressAfterSplit.length;k++) {
					if(addressAfterSplit[k].equals(primaryKey)) {
						return cells.get(1); 
					} 
				} 			
			}
		}
		System.out.println("Postal code is not present");
		return null;	
	}
	
	public String getEditSuccessBannerText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success.alert-dismissible")));
		return editSuccessBannerText.getText();
	}
	public String getDeleteSuccessBannerText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success.alert-dismissible")));
		return editSuccessBannerText.getText();
	}
	
	public EditAddressPage clickEditAddressbook(String primaryKey) {
		WebElement editElementinCell=getElemntFromTable(primaryKey);
		editElementinCell.findElement(By.cssSelector("a:first-of-type")).click();
		return new EditAddressPage();
	}
	public void clickDeleteAddressbook(String primaryKey) {
		WebElement editElementinCell=getElemntFromTable(primaryKey);
		editElementinCell.findElement(By.cssSelector("a:last-of-type")).click();
		driver.switchTo().alert().accept();
	}
}
