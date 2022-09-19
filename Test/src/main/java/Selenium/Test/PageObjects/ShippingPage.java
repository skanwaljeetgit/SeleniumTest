package Selenium.Test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Test.Base.BaseClass;
import Selenium.Test.ActionDriver.Action;


/**
 * @author kanwaljeetsingh PageFactory is used to initialize elements on pages
 */

public class ShippingPage extends BaseClass {

	@FindBy(xpath = "//input[@id='cgv']")
	WebElement termsOfServiceCheckbox;

	@FindBy(xpath = "//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutButton;

	public ShippingPage() {
		PageFactory.initElements(getDriver()
				, this);
	}

	// click on checkTermsCheckbox
	public void checkTermsCheckbox() throws Exception {
		Action.check(termsOfServiceCheckbox);
	}

	// click on proceedToCheckoutButton on ShippingPage to load PaymentPage
	public PaymentPage clickProceedToCheckout() throws Exception {
		Action.click(proceedToCheckoutButton);
		return new PaymentPage();
	}

}
