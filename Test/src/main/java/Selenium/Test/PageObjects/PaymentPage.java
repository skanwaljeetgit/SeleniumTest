package Selenium.Test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Test.Base.BaseClass;
import Selenium.Test.ActionDriver.Action;


/**
 * @author kanwaljeetsingh PageFactory is used to initialize elements on pages
 */

public class PaymentPage extends BaseClass {
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	WebElement payByBankWireButton;

	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	WebElement payByCheckButton;

	public PaymentPage() {
		PageFactory.initElements(getDriver()
				, this);
	}

	// click on payByBankWireButton on PaymentPage to load OrderSummaryPage
	public OrderSummaryPage clickOnPaymentMethod() throws Exception {
		Action.click(payByBankWireButton);
		return new OrderSummaryPage();
	}

}
