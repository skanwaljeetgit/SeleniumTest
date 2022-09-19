package Selenium.Test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Test.Base.BaseClass;
import Selenium.Test.ActionDriver.Action;

/**
 * @author kanwaljeetsingh
 * PageFactory is used to initialize elements on pages
 */
public class AccountCreationPage extends BaseClass {

	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement createAccountFormHeader;

	public AccountCreationPage() {
		PageFactory.initElements(getDriver()
				, this);
	}

	// validate createAccountFormHeader is displayed
	public boolean validateAccountCreatePage() throws Exception {
		return Action.isDisplayed(createAccountFormHeader);
	}

}
