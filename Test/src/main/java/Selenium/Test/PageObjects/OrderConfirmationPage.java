package Selenium.Test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Selenium.Test.Base.BaseClass;


/**
 * @author kanwaljeetsingh PageFactory is used to initialize elements on pages
 */

public class OrderConfirmationPage extends BaseClass {
	@FindBy(xpath = "//p/strong[text() = 'Your order on My Store is complete.']")
	WebElement confirmOrderMessage;

	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver()
				, this);
	}

	// validate confirmOrderMessage is displayed
	public String validateConfirmOrderMessage() {
		String confirmOrderMessage = this.confirmOrderMessage.getText();
		return confirmOrderMessage;
	}

}
