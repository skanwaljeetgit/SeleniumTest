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
public class HomePage extends BaseClass {
	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement myWishlists;

	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;

	public HomePage() {
		PageFactory.initElements(getDriver()
				, this);
	}

	// validate myWishlists label is displayed
	public boolean validateMyWishlists() throws Exception {
		return Action.isDisplayed(myWishlists);
	}

	// validate orderHistory label is displayed
	public boolean validateOrderHistory() throws Exception {
		return Action.isDisplayed(orderHistory);
	}
	
	// get current page URL
	public String getCurrentUrl() {
		String homePageUrl = getDriver().getCurrentUrl();
		return homePageUrl;
	}
}
