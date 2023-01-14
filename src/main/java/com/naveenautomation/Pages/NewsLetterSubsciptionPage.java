package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class NewsLetterSubsciptionPage extends TestBase {

	public NewsLetterSubsciptionPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "label.radio-inline:first-of-type>input")
	WebElement yesRadioBtn;

	@FindBy(css = "input[type='Submit']")
	WebElement continueBtn;

	public MyAccountPage updatingSubscription() {
		yesRadioBtn.click();
		continueBtn.submit();
		return new MyAccountPage();

	}

}
