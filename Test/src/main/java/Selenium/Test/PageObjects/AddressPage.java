package Selenium.Test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Test.Base.BaseClass;
import Selenium.Test.ActionDriver.Action;

/**
 * @author kanwaljeetsingh PageFactory is used to initialize elements on pages
 */
public class AddressPage extends BaseClass {

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckoutButton;

	public AddressPage() {
		PageFactory.initElements(getDriver()
				, this);
	}

	public ShippingPage clickProceedToCheckout() throws Exception {

		// click on proceedToCheckoutButton on AddressPage to load ShippingPage
		Action.click(proceedToCheckoutButton);
		return new ShippingPage();
	}

}
