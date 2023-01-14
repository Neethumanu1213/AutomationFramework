package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class AccountLogOutPage extends TestBase {

	public AccountLogOutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content>h1")
	WebElement accountLogOutText;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;

	public String getAccountLogOutText() {
		return accountLogOutText.getText();
		
	}
	public String getTitleOfAccountLogOutPage() {
		return driver.getTitle();
		
	}
	
	public HomePage logOut() {
		continueBtn.click();
		return new HomePage();
	}
}
