package Selenium.Test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Test.Base.BaseClass;
import Selenium.Test.ActionDriver.Action;


/**
 * @author kanwaljeetsingh PageFactory is used to initialize elements on pages
 */

public class OrderSummaryPage extends BaseClass {
	@FindBy(xpath = "//span[text()='I confirm my order']")
	WebElement confirmOrderButton;

	public OrderSummaryPage() {
		PageFactory.initElements(getDriver()
				, this);
	}

	// click on confirmOrderButton on OrderSummaryPage to load OrderConfirmationPage
	public OrderConfirmationPage clickConfirmOrder() throws Exception {

		Action.click(confirmOrderButton);
		return new OrderConfirmationPage();
	}

}
