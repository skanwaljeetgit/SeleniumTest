package Selenium.Test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Test.Base.BaseClass;
import Selenium.Test.ActionDriver.Action;


/**
 * @author kanwaljeetsingh PageFactory is used to initialize elements on pages
 */
public class AddToCartPage extends BaseClass {

	@FindBy(xpath = "//input[@id='quantity_wanted']")
	WebElement quantity;

	@FindBy(xpath = "//select[@id='group_1']")
	WebElement size;

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartButton;

	@FindBy(xpath = "//p[@class='buttons_bottom_block no-print']//span[text()='Add to cart']")
	WebElement addToCartButtonQuickView;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/i")
	WebElement addToCartMessage;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutButton;

	public AddToCartPage() {
		PageFactory.initElements(getDriver()
				, this);
	}

	// enter quantity
	public void enterQuantity(String quantity) throws Exception {
		Action.type(this.quantity, quantity);
	}

	// select size
	public void selectSize(String size) throws Exception {
		Action.selectByVisibleText(size, this.size);
	}

	// click addToCartButton
	public void clickAddToCart() throws Exception {
		// Action.explicitWait(getDriver(), addToCartButton, 30);

		Action.click(addToCartButton);
	}

	// validate addToCartMessage is displayed
	public boolean validateAddToCart() throws Exception {
		return Action.isDisplayed(addToCartMessage);
	}

	// click proceedToCheckoutButton on AddToCartPag to load OrderPage
	public OrderPage clickProceedToCheckout() throws Exception {
		Action.click(proceedToCheckoutButton);
		return new OrderPage();
	}

}
