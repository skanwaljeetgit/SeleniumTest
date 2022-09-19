package Selenium.Test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Test.Base.BaseClass;
import Selenium.Test.ActionDriver.Action;


/**
 * @author kanwaljeetsingh PageFactory is used to initialize elements on pages
 */

public class OrderPage extends BaseClass {

	@FindBy(xpath = "//td[@class='cart_unit']/span/span[@class='price']")
	WebElement unitPrice;

	@FindBy(id = "total_price")
	WebElement totalPrice;

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckoutButton;

	public OrderPage() {

		PageFactory.initElements(getDriver()
				, this);
	}

	// calculate finalUnitPrice
	public double getUnitPrice() {

		String unitPrice = this.unitPrice.getText();
		String unit = unitPrice.replaceAll("[^a-zA-Z0-9]", "");
		Double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice / 100;
	}

	// calculate finalTotalPrice
	public double getTotalPrice() {

		String totalPrice = this.totalPrice.getText();
		String total = totalPrice.replaceAll("[^a-zA-Z0-9]", "");
		Double finalTotalPrice = Double.parseDouble(total);
		return finalTotalPrice / 100;
	}

	// click proceedToCheckoutButton on OrderPage to load LoginPage
	public LoginPage clickProceedToCheckout() throws Exception {

		Action.click(proceedToCheckoutButton);
		return new LoginPage();

	}

	// click on proceedToCheckoutButton on OrderPage to load AddressPage
	public AddressPage clickProceedToCheckoutAddress() throws Exception {

		Action.click(proceedToCheckoutButton);
		return new AddressPage();
	}
}
